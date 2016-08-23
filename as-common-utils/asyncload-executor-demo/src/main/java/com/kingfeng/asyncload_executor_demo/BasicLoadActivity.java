package com.kingfeng.asyncload_executor_demo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.net.URL;

/**
 * handler + Runnable 模式，这并不是异步加载。     ( 执行会报错，主线程中不能进行网络操作)
 *
 */
public class BasicLoadActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyncload);
        loadImage("http://www.baidu.com/img/baidu_logo.gif", R.id.imageView1);
        loadImage("http://www.baidu.com/img/baidu_logo.gif", R.id.imageView2);
        loadImage("http://cache.soso.com/30d/img/web/logo.gif", R.id.imageView3);
        loadImage("http://csdnimg.cn/www/images/csdnindex_logo.gif", R.id.imageView4);
        loadImage("http://images.cnblogs.com/logo_small.gif", R.id.imageView5);
    }

    private Handler handler = new Handler();

//    执行时会报错误： （不能在主线程中进行网络操作）
//    FATAL EXCEPTION: main
//    android.os.NetworkOnMainThreadException
//    at android.os.StrictMode$AndroidBlockGuardPolicy.onNetwork(StrictMode.java:1136)
    private void loadImage(final String url, final int id) {
        // Runnable 运行在那个线程 这里的代码其实是在UI 主线程中下载图片的，而不是新开线程。
        handler.post(new Runnable() {
            public void run() {
                Drawable drawable = null;
                try {
                    drawable = Drawable.createFromStream(
                            new URL(url).openStream(), "image.gif");
                } catch (IOException e) {
                    Log.d("test", e.getMessage());
                }
                if (drawable == null) {
                    Log.d("test", "null drawable");
                } else {
                    Log.d("test", "not null drawable");
                }
                // 为了测试缓存而模拟的网络延时
                SystemClock.sleep(2000);
                ((ImageView) BasicLoadActivity.this.findViewById(id)).setImageDrawable(drawable);
            }
        });
    }
}
