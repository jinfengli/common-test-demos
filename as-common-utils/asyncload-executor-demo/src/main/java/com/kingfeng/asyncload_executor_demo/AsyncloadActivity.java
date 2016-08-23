package com.kingfeng.asyncload_executor_demo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;

public class AsyncloadActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyncload);
        loadImage2("http://www.baidu.com/img/baidu_logo.gif", R.id.imageView1);
        loadImage2("http://www.chinatelecom.com.cn/images/logo_new.gif",
                R.id.imageView2);
        loadImage2("http://cache.soso.com/30d/img/web/logo.gif", R.id.imageView3);
        loadImage2("http://csdnimg.cn/www/images/csdnindex_logo.gif",
                R.id.imageView4);
        loadImage2("http://images.cnblogs.com/logo_small.gif",
                R.id.imageView5);
    }

    final Handler handler2 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            ((ImageView) AsyncloadActivity.this.findViewById(msg.arg1))
                    .setImageDrawable((Drawable) msg.obj);
        }
    };

    // 采用handler+Thread模式实现多线程异步加载    + Message
    private void loadImage2(final String url, final int id) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Drawable drawable = null;
                try {
                    drawable = Drawable.createFromStream(
                            new URL(url).openStream(), "image.png");
                } catch (IOException e) {
                    Log.d("test", e.getMessage());
                }

                // 模拟网络延时
                SystemClock.sleep(2000);

                Message message = handler2.obtainMessage();
                message.arg1 = id;
                message.obj = drawable;
                handler2.sendMessage(message);
            }
        };
        thread.start();
        thread = null;
    }
}
