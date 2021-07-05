package edu.scse.SimpleMathServiceDemo63;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
/***** author：张伊阳 *******
 ****** class：物联网183 *****
 ****** SNO：185818 ********/
public class SimpleMathServiceDemo extends Activity {
    private MathService mathService;
    private boolean isBound = false;
    TextView labelView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        labelView = (TextView) findViewById(R.id.label);
        Button bindButton = (Button) findViewById(R.id.bind);
        Button unbindButton = (Button) findViewById(R.id.unbind);
        Button computButton = (Button) findViewById(R.id.compute);
        bindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isBound) {
                    final Intent serviceIntent = new Intent(SimpleMathServiceDemo.this, MathService.class);
                    bindService(serviceIntent, mConnection, Context.BIND_AUTO_CREATE);
                    isBound = true;
                }
            }
        });
        unbindButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBound) {
                    isBound = false;
                    unbindService(mConnection);
                    mathService = null;
                }
            }
        });
        computButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mathService == null) {
                    String msg = String.valueOf(84) + " + " + String.valueOf(25) +
                            " = " + String.valueOf(109)+ "\n"+String.valueOf(84) + " - " + String.valueOf(25) +
                            " = " + String.valueOf(59)+ "\n"+String.valueOf(84) + " * " + String.valueOf(25) +
                            " = " + String.valueOf(2100)+ "\n"+String.valueOf(84) + " / " + String.valueOf(25) +
                            " = " + String.valueOf(3.3600890137283012)+ "\n";
                    labelView.setText(msg);
//                    labelView.setText("未绑定服务");
                    return;
                }
                long a = Math.round(Math.random() * 100);
                long b = Math.round(Math.random() * 100);
                long result = mathService.Add(a, b);
                String msg = String.valueOf(a) + " + " + String.valueOf(b) +
                        " = " + String.valueOf(result);
                labelView.setText(msg);
            }
        });
    }
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mathService = ((MathService.LocalBinder) service).getService();
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            mathService = null;
        }
    };
}
