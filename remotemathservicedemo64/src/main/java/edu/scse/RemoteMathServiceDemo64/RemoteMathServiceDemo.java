package edu.scse.RemoteMathServiceDemo64;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import edu.scse.RemoteMathServiceDemo64.IMathService;
/***** author：张伊阳 *******
 ****** class：物联网183 *****
 ****** SNO：185818 ********/
public class RemoteMathServiceDemo extends AppCompatActivity {
    private IMathService iMathService;
    private boolean isBound = false;
    TextView labelView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        labelView = findViewById(R.id.label);
        Button bindButton = findViewById(R.id.bind);
        Button cancelButton = findViewById(R.id.cancelBind);
        Button computButton = findViewById(R.id.compute);
        bindButton.setOnClickListener(v -> {
            if (!isBound) {
                Intent intent = new Intent();
                intent.setAction("edu.scse.RemoteMathServiceDemo64.MathService");
                intent.setPackage("edu.scse.RemoteMathServiceDemo64");
                startService(intent);
                bindService(intent, con, Context.BIND_AUTO_CREATE);
                Toast.makeText(RemoteMathServiceDemo.this, "绑定成功!", Toast.LENGTH_SHORT).show();
                isBound = true;
            }
        });
        cancelButton.setOnClickListener(v -> {
            if (isBound) {
                isBound = false;
                unbindService(con);
                iMathService = null;
            }
        });
        computButton.setOnClickListener(v -> {
            if (iMathService == null) {
                labelView.setText("未绑定!");
                return;
            }
            long a = Math.round(Math.random() * 100);
            long b = Math.round(Math.random() * 100);
            long result = 0;
            try {
                result = iMathService.Add(a, b);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            String msg = a + " + " + b +
                    " = " + result;
            Toast.makeText(RemoteMathServiceDemo.this, msg, Toast.LENGTH_SHORT).show();
            labelView.setText(msg);
        });
    }
    ServiceConnection con = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iMathService = IMathService.Stub.asInterface(service);
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            iMathService = null;
        }
    };
}
