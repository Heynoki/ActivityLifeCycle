package edu.scse.ParcelMathServiceDemo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ParcelMathServiceDemo extends Activity {
    private TextView textView;
    private Button bind;
    private Button unbind;
    private Button add;

    private boolean isBound = false;
    private IMathService mathService;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mathService = IMathService.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mathService = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        textView = (TextView) findViewById(R.id.label);
        bind = (Button) findViewById(R.id.bind);
        unbind = (Button) findViewById(R.id.cancelBind);
        add = (Button) findViewById(R.id.add);

        bind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isBound) {
                    final Intent serviceIntent = new Intent();
                    serviceIntent.setAction("edu.scse.ParcelMathServiceDemo.MathService");
                    bindService(serviceIntent, mConnection, Context.BIND_AUTO_CREATE);
                    isBound = true;
                }
            }
        });

        unbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBound) {
                    unbindService(mConnection);
                    isBound = false;
                    mathService = null;
                }
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mathService == null) {
                    textView.setText("未绑定远程服务");
                    return;
                }
                long a = Math.round(Math.random() * 100);
                long b = Math.round(Math.random() * 100);
                AllResult result = null;
                try {
                    result = mathService.ComputeAll(a, b);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                String msg = "";
                if (result != null) {
                    msg += String.valueOf(a) + "+" + String.valueOf(b) + "=" +
                            String.valueOf(result.addResult) + "\n";
                    msg += String.valueOf(a) + "-" + String.valueOf(b) + "=" +
                            String.valueOf(result.subResult) + "\n";
                    msg += String.valueOf(a) + "*" + String.valueOf(b) + "=" +
                            String.valueOf(result.mulResult) + "\n";
                    msg += String.valueOf(a) + "/" + String.valueOf(b) + "=" +
                            String.valueOf(result.divResult) + "\n";
                }
                textView.setText(msg);
            }
        });
    }
}