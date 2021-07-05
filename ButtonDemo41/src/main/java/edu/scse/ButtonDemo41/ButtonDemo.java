package edu.scse.ButtonDemo41;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
/***** author：张伊阳 *******
 ****** class：物联网183 *****
 ****** SNO：185818 ********/
public class ButtonDemo extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button button = (Button) findViewById(R.id.Button01);
        ImageButton imageButton =
                (ImageButton) findViewById(R.id.ImageButton01);
        button.setText("Button 按 钮 物联网183张伊阳");
        imageButton.setImageResource(R.drawable.ic_launcher_foreground);
        final TextView textView = (TextView) findViewById(R.id.TextView01);
        //（1）按钮注册到各自的监听器x
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView.setText("Button按钮 185818张伊阳");
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                textView.setText("ImageButton按钮185818张伊阳");
            }
        });
        //（2）按钮注册到同一个监听器
        Button.OnClickListener buttonListener = new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.Button01:
                        textView.setText("Button按钮 185818张伊阳");
                        return;
                    case R.id.ImageButton01:
                        textView.setText("ImageButton按钮 185818张伊阳");
                        return;
                }
            }
        };
        button.setOnClickListener(buttonListener);
        imageButton.setOnClickListener(buttonListener);
    }
}
