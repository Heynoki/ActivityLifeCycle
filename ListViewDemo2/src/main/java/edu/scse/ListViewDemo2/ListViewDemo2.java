package edu.scse.ListViewDemo2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ListViewDemo2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final TextView textView = (TextView) findViewById(R.id.TextView01);
        ListView listView01 = (ListView) findViewById(R.id.ListView01);
        ListView listView02 = (ListView) findViewById(R.id.ListView02);
        ListView listView03 = (ListView) findViewById(R.id.ListView03);
        List<String> list01 = new ArrayList<String>();
        List<String> list02 = new ArrayList<String>();
        List<String> list03 = new ArrayList<String>();
        list01.add("ListView01 周一");
        list01.add("ListView01 周二");
        list01.add("ListView01 周三");
        list01.add("——————————————");

        list02.add("ListView02 一年");
        list02.add("ListView02 两年");
        list02.add("ListView02 三年");
        list02.add("——————————————");

        list03.add("ListView03 一月");
        list03.add("ListView03 二月");
        list03.add("ListView03 三月");
        list03.add("——————————————");
        ArrayAdapter<String> adapter01 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, list01);
        listView01.setAdapter(adapter01);
        ArrayAdapter<String> adapter02 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, list02);
        listView02.setAdapter(adapter02);
        ArrayAdapter<String> adapter03 = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, list03);
        listView03.setAdapter(adapter03);
        AdapterView.OnItemClickListener ListViewListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = "父View：" + parent.toString() + "\n" +
                        "子View：" + view.toString() + "\n" +
                        "位置：" + position + "\n" +
                        "id：" + id + "\n";
                textView.setText(msg);
            }
        };
        listView01.setOnItemClickListener(ListViewListener);
        listView02.setOnItemClickListener(ListViewListener);
        listView03.setOnItemClickListener(ListViewListener);
    }
}