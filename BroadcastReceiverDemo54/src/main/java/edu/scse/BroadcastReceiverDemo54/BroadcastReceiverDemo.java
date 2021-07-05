package edu.scse.BroadcastReceiverDemo54;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
/***** author：张伊阳 *******
 ****** class：物联网183 *****
 ****** SNO：185818 ********/
public class BroadcastReceiverDemo extends Activity {
    private EditText entryText;
    private Button button;
    private static String TAG = "LIFTCYCLE54";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        entryText = (EditText) findViewById(R.id.entry54);
        button = (Button) findViewById(R.id.btn54);
        button.setOnClickListener(view -> {
            Intent intent = new Intent("edu.scse.BroadcastReceiverDemo54");
            intent.putExtra("mes", entryText.getText().toString());
            Log.i(TAG, entryText.getText().toString());
            sendBroadcast(intent);
            Log.i(TAG, "entryText.getText().toString()");
        });
    }
}
