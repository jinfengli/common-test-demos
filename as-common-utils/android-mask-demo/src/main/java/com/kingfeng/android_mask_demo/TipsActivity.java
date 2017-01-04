package com.kingfeng.android_mask_demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout;

public class TipsActivity extends Activity {

    private static final String TAG = "TipsActivity";
    private int[] mLocs;

    RelativeLayout mRlRootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);//取消title
        setContentView(R.layout.activity_tips);
        Intent intent = getIntent();
        mLocs = intent.getIntArrayExtra("loc");//获取坐标
//        ButterKnife.bind(this);
        initView();
    }

    private void initView() {

        mRlRootView = (RelativeLayout) findViewById(R.id.tips_rootview);
        TipsView tipsView = new TipsView(this);//将坐标传给自定义view
        tipsView.setCircleLocation(mLocs);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout
                .LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mRlRootView.addView(tipsView, layoutParams);

        mRlRootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                overridePendingTransition(0, 0); //取消动画效果
            }
        });
    }

//    @OnClick(R.id.tips_rootview)
//    public void clickClose() {
//        finish();
//        overridePendingTransition(0, 0); //取消动画效果
//    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            finish();
            overridePendingTransition(0, 0);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}