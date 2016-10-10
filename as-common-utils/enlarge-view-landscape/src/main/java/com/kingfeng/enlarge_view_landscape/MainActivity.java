package com.kingfeng.enlarge_view_landscape;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private Button btnEnlarge;

    private ListView lvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnlarge = (Button) findViewById(R.id.btn_enlarge);
        lvTest = (ListView) findViewById(R.id.lv_test);
    }
}
