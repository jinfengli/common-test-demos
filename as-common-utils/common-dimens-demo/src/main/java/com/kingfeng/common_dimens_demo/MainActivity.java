package com.kingfeng.common_dimens_demo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements View.OnClickListener{
    private TextView tvFontSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvFontSize = (TextView) findViewById(R.id.tv_name);

        tvFontSize.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_name:
                Toast.makeText(MainActivity.this, tvFontSize.getTextSize() + "",
                        Toast.LENGTH_LONG).show();

                break;

            default:
                break;
        }
    }
}
