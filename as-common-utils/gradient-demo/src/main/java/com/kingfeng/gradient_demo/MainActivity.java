package com.kingfeng.gradient_demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends Activity {

    private TextView textView;
    /**
     * 计时参数
     */
    private int timer = 0;
    private Handler handler = new Handler(Looper.getMainLooper());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        textView = (TextView) findViewById(R.id.tv_test);
        handler.post(myRunnable);

    }

    private final Runnable myRunnable = new Runnable() {
        @Override
        public void run() {
            textView.setText(String.valueOf(timer++));
            if(handler != null) {
                //  class com.kingfeng.gradient_demo.MainActivity$1
                Log.e("MyTest", this.getClass().getName() + "");
                handler.postDelayed(this, 1000);
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 避免handler导致内存泄漏
//        handler.removeCallbacksAndMessages(null);
        handler.removeCallbacks(myRunnable);
        handler = null;
    }
}
