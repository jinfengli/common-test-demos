package com.kingfeng.bounce_listview_demo;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
    // 继承AppcompactActivity 隐藏不了标题栏
    private Button btnEnlarge;
    private BounceListView bounceListView;

    private static final int MSG_SCREEN_FULL = 0x00000004;
    private static final int MSG_SCREEN_WRAP = 0x00000005;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        btnEnlarge = (Button) findViewById(R.id.btn_enlarge);
        bounceListView = (BounceListView) findViewById(R.id.lv_datas);

//        LinearLayout linearLayout = new LinearLayout(this);
//        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
//                LinearLayout.LayoutParams.MATCH_PARENT));
//
//        setContentView(linearLayout);

//        BounceListView bounceListView = new BounceListView(this);

        String[] data = new String[5];
        for (int i = 0; i < data.length; i++) {
            data[i] = " bounce-- " + i;
        }

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        bounceListView.setAdapter(arrayAdapter);

//        linearLayout.addView(bounceListView);

        btnEnlarge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getScreenOrientation() == Configuration.ORIENTATION_PORTRAIT) {
                    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                    return;
                }
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
            }
        });
    }

    public void screenFullModeUI() {
//        mRela_Layout.setVisibility(View.GONE);
//        mImage_Full_Screen.setImageResource(R.drawable.jc_shrink);
        btnEnlarge.setVisibility(View.GONE);
        setScreenLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
    }

    private void setScreenLayoutParams(int width, int height) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(width, height);
        if (width == ViewGroup.LayoutParams.MATCH_PARENT && height == ViewGroup.LayoutParams.MATCH_PARENT) {
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        }
        bounceListView.setLayoutParams(layoutParams);
        bounceListView.requestFocus();
    }

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case MSG_SCREEN_FULL:
                    screenFullModeUI();
                    break;

                case MSG_SCREEN_WRAP:
                    screenWrapModeUI();
                    break;

                default:
                    break;
            }
        }
    };

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int value = getScreenOrientation();
        if (value == Configuration.ORIENTATION_LANDSCAPE) {
            mHandler.sendEmptyMessage(MSG_SCREEN_FULL);
        } else if (value == Configuration.ORIENTATION_PORTRAIT) {
            mHandler.sendEmptyMessage(MSG_SCREEN_WRAP);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (getScreenOrientation() == Configuration.ORIENTATION_LANDSCAPE) {
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    private int getScreenOrientation() {
        return getResources().getConfiguration().orientation;
    }

    public void screenWrapModeUI() {
//        mRela_Layout.setVisibility(View.VISIBLE);
//        mImage_Full_Screen.setImageResource(R.drawable.jc_enlarge);
        setScreenLayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, /* ScreenUtil.dip2px(this, 220)*/300);
    }

}
