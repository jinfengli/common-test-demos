package com.kingfeng.touch_event_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 *  判断onTouch(),onClick() 哪一个先执行
 */
public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";

    private Button btnTest;
    private ImageView ivTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTest = (Button) findViewById(R.id.btn_01);
        ivTest = (ImageView) findViewById(R.id.iv_test);

        btnTest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                Log.i(TAG, "onClick execute");
                startActivity(new Intent(MainActivity.this,SecondActivity.class));
            }
        });

        btnTest.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View arg0, MotionEvent event) {
                Log.i(TAG, "onTouch execute, action " + event.getAction());   // 0--down,  1--up,  2--move
                return false;
            }
        });

        ivTest.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Log.d(TAG, "ivTest onTouch execute, action " + event.getAction());
                return true;    // 这里默认是返回false的
            }
        });



    }
}
