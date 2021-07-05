package edu.scse.RemoteMathServiceDemo64;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
/***** author：张伊阳 *******
 ****** class：物联网183 *****
 ****** SNO：185818 ********/
public class MathService extends Service {
    private final IMathService.Stub mBinder = new IMathService.Stub() {
        public long Add(long a, long b) {
            return a + b;
        }
    };
    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }
    @Override
    public boolean onUnbind (Intent intent){
        return false;
    }
}