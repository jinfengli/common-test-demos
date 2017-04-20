package com.kingfeng.common_dimens_demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
    private TextView tvFontSize;

    private ImageView ivTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFontSize = (TextView) findViewById(R.id.tv_name);
        ivTest = (ImageView) findViewById(R.id.iv_test);
        tvFontSize.setOnClickListener(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                tvFontSize.setText("Done");
            }
        }, 2000L);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_name:
//                Toast.makeText(MainActivity.this, tvFontSize.getTextSize() + "",
//                        Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, ivTest.getWidth() + "--"
                        + ivTest.getHeight(), Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
    }
}
