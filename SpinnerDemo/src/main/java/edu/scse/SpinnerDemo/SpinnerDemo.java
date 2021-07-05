package edu.scse.SpinnerDemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class SpinnerDemo extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Spinner spinner = findViewById(R.id.Spinner);
        List<String> SpinnerList = new ArrayList<>();
        SpinnerList.add("Spinner1 物联网183");
        SpinnerList.add("Spinner2 185818");
        SpinnerList.add("Spinner3 张伊阳");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>
                (this,R.layout.support_simple_spinner_dropdown_item,SpinnerList);

        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}