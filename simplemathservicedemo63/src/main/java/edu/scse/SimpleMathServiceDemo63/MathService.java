package edu.scse.SimpleMathServiceDemo63;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;
/***** author：张伊阳 *******
 ****** class：物联网183 *****
 ****** SNO：185818 ********/
public class MathService extends Service {
    private final IBinder mBinder = new LocalBinder();
    public class LocalBinder extends Binder {
        MathService getService() {
            return MathService.this;
        }
    }
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "本地绑定：MathService",
                Toast.LENGTH_SHORT).show();
        return mBinder;
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Toast.makeText(this, "取消本地绑定：MathService",
                Toast.LENGTH_SHORT).show();
        return false;
    }
    public long Add(long a, long b) {
        return a + b;
    }
}
