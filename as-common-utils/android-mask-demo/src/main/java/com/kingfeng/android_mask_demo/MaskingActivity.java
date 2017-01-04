package com.kingfeng.android_mask_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.widget.RelativeLayout;

public class MaskingActivity extends AppCompatActivity {
    private static final String TAG = "MaskingActivity";
    //    @BindView(R.id.mask_bt)
    AppCompatButton mBtMasking;
    private int mHeight;

    private RelativeLayout rlMask;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masking);
        setTitle("test mask");
//        ButterKnife.bind(this);

        rlMask = (RelativeLayout) findViewById(R.id.rl_mask);

        mBtMasking = (AppCompatButton) findViewById(R.id.mask_bt);
        showMask();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
    }

    //onCreat中直接去测量view的大小是测不出来的 所以在这个demo中我延时200ms去测量
    //实际使用一般在网络加载完成后去测量view的大小然后去显示蒙版
    private void showMask() {
        rlMask.postDelayed(new Runnable() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mHeight = getSupportActionBar().getHeight();
                        int left = mBtMasking.getLeft();
                        int right = mBtMasking.getRight();
                        int top = mBtMasking.getTop() + mHeight;
                        int bottom = mBtMasking.getBottom() + mHeight;
                        int loc[] = {left, top, right, bottom};
                        Intent intent = new Intent(MaskingActivity.this, TipsActivity.class);
                        intent.putExtra("loc", loc);
                        startActivity(intent);
                    }
                });
            }
        }, 0);
    }
}
