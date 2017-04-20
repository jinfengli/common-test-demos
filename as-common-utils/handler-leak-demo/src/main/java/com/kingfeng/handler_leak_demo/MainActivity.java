package com.kingfeng.handler_leak_demo;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import java.lang.ref.WeakReference;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = MainActivity.class.getSimpleName();
    private TextView textView;

    // 次数
    private static int timer;

    private static Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);


//        textView.setText(String.valueOf(timer++));
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                textView.setText(String.valueOf(timer++));
//                handler.postDelayed(new MyRunnable(textView),1000L);
//            }
//        });

//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                textView.setText(String.valueOf(timer++));
//
//                if(handler != null) {
//                    handler.postDelayed(this, 1000);
//                }
//            }
//        });


//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                textView.setText(String.valueOf(timer++));
//
//                if(handler != null) {
//                    handler.postDelayed(new MyRunnable(textView), 1000);
//                }
//            }
//        });

        handler.post(new MyRunnable(textView));
    }

    // M1.
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 移除这个handler所拥有的Runnable和Message。   手动移除所有的消息。
        Log.e(TAG, "onDestroy: execute() " );
        handler.removeCallbacksAndMessages(null);
    }


    // M2.
    private static final class MyRunnable implements Runnable {
        private final WeakReference<TextView> textView;

        public MyRunnable(TextView textView) {
            this.textView = new WeakReference<>(textView);
//            this.textView = textView;
        }

        @Override
        public void run() {
//            textView.setText("done");
            final TextView tv = textView.get();
            if(tv != null) {
                tv.setText(String.valueOf(timer++));
            }

            if(handler != null) {
                handler.postDelayed(this,1000);
            }
        }
    }
}
