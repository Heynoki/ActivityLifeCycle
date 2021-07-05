package edu.scse.BroadcastReceiverDemo54;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;
/***** author：张伊阳 *******
 ****** class：物联网183 *****
 ****** SNO：185818 ********/
public class MyBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("dynamic receiver", "Context class  = " + context.getClass().getName());
        String msg = intent.getStringExtra("mes");
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
