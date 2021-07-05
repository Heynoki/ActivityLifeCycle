package edu.scse.TabDemo43;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.*;
/***** author：张伊阳 *******
 ****** class：物联网183 *****
 ****** SNO：185818 ********/
public class TabDemo extends TabActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabHost tabHost = getTabHost();
        LayoutInflater.from(this).inflate(R.layout.tab1,
                tabHost.getTabContentView(), true);
        LayoutInflater.from(this).inflate(R.layout.tab2, tabHost.getTabContentView(), true);
        LayoutInflater.from(this).inflate(R.layout.tab3, tabHost.getTabContentView(), true);
        tabHost.addTab(tabHost.newTabSpec("TAB1").
                setIndicator("线性布局").setContent(R.id.layout01));
        tabHost.addTab(tabHost.newTabSpec("TAB2").
                setIndicator("绝对布局").setContent(R.id.layout02));
        tabHost.addTab(tabHost.newTabSpec("TAB3").
                setIndicator("相对布局").setContent(R.id.layout03));
    }
}
