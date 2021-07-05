package edu.scse.intentdemo51;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
/***** author：张伊阳 *******
 ****** class：物联网183 *****
 ****** SNO：185818 ********/
public class IntentDemo extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout51);
        Button button = (Button) findViewById(R.id.btn51);
        button.setOnClickListener(view -> {
            Intent intent =
                    new Intent(IntentDemo.this, edu.scse.intentdemo51.ActivityToStart.class);
            startActivity(intent);
        });
    }
}