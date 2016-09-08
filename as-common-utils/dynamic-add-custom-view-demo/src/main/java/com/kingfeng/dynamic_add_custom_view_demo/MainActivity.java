package com.kingfeng.dynamic_add_custom_view_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_goto_ExpressMainActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,MainPageActivity.class));
            }
        });

    }

//    private void gotoExpressMainActivity() {
//        startActivity(new Intent(this,MainPageActivity.class));
//    }
}
