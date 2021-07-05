package edu.scse.SDcardFileDemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
public class SDcardFileDemo extends Activity {
    private static String randomNumbersString="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final TextView label=(TextView)findViewById(R.id.label);
        Button random=(Button)findViewById(R.id.random);
        Button write=(Button)findViewById(R.id.write);
        final TextView textView=(TextView)findViewById(R.id.display);
        write.setOnClickListener(v -> {
            String fileName="SdcardFile-"+ System.currentTimeMillis()+".txt";
            File dir = new File("/sdcard/");
            if(dir.exists()&&dir.canWrite()){
                File newFile = new File(dir.getAbsolutePath()+"/"+fileName);
                FileOutputStream fos = null;
                try {
                    newFile.createNewFile();
                    if(newFile.exists()&&newFile.canWrite()){
                        fos=new FileOutputStream(newFile);
                        fos.write(randomNumbersString.getBytes());
                        label.setText(fileName+"文件写入SD卡");
                    }
                }
                catch (IOException e) {
                    Toast.makeText(SDcardFileDemo.this, "1"+e.getMessage(),
                            Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }
                finally {
                    if(fos!=null){
                        try{
                            fos.flush();
                            fos.close();
                        }
                        catch (IOException e) {
                            e.printStackTrace();
                        }}
                }
            }
        });
        random.setOnClickListener(v -> {
            StringBuilder msg= new StringBuilder();
            for(int i=0;i<10;i++){
                double randomDouble = Math.random()*100;
                msg.append(randomDouble).append("\n");
            }
            textView.setText(msg.toString());
        });
        write.setOnClickListener(v -> {
            String fileName="SdcardFile-"+ System.currentTimeMillis()+".txt";
            File dir=new File("/sdcard");
            if(dir.exists()&&dir.canWrite()){
                File newFile=new File(dir.getAbsolutePath()+"/"+fileName);
                FileOutputStream fos=null;
                try{
                    newFile.createNewFile();
                    if(newFile.exists()&&newFile.canWrite()){
                        fos=new FileOutputStream(newFile);
                        fos.write(randomNumbersString.getBytes());
                        label.setText(fileName+"文件写入SD卡");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(fos!=null){
                        try {
                            fos.flush();
                            fos.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
    });
    }
}