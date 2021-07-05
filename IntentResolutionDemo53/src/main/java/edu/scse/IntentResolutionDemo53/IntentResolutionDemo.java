    package edu.scse.IntentResolutionDemo53;
    import android.app.Activity;
    import android.content.Intent;
    import android.net.Uri;
    import android.os.Bundle;
    import android.view.View;
    import android.widget.Button;
    /***** author：张伊阳 *******
     ****** class：物联网183 *****
     ****** SNO：185818 ********/
    public class IntentResolutionDemo extends Activity {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.layout53);
            Button button = (Button) findViewById(R.id.btn);
            button.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("schemodemo://edu.scse/path"));
                    startActivity(intent);
                }
            });
        }
    }
