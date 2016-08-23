package com.kingfeng.asyncload_executor_demo;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 *  ref: http://www.eoeandroid.com/forum.php?mod=viewthread&tid=210082&page=1&_dsign=1b202888
 *
 *  @date 2016-8-22
 *  @author li.jf
 */
public class ExecutorServiceLoadActivity extends AppCompatActivity {

//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_asyncload);
//        loadImage3("http://www.baidu.com/img/baidu_logo.gif", R.id.imageView1);
//        loadImage3("http://www.chinatelecom.com.cn/images/logo_new.gif",
//                R.id.imageView2);
//        loadImage3("http://cache.soso.com/30d/img/web/logo.gif",
//                R.id.imageView3);
//        loadImage3("http://csdnimg.cn/www/images/csdnindex_logo.gif",
//                R.id.imageView4);
//        loadImage3("http://images.cnblogs.com/logo_small.gif",
//                R.id.imageView5);
//    }
//
//    private Handler handler = new Handler();
//
//    private ExecutorService executorService = Executors.newFixedThreadPool(5);
//
//    // 引入线程池来管理多线程
//    private void loadImage3(final String url, final int id) {
//        executorService.submit(new Runnable() {
//            public void run() {
//                try {
//                    final Drawable drawable = Drawable.createFromStream(
//                            new URL(url).openStream(), "image.png");
//                    // 模拟网络延时
//                    SystemClock.sleep(2000);
//                    handler.post(new Runnable() {
//                        public void run() {
//                            ((ImageView) ExecutorServiceLoadActivity.this.findViewById(id))
//                                    .setImageDrawable(drawable);
//                        }
//                    });
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
//    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asyncload);

        loadImage("http://www.baidu.com/img/baidu_logo.gif", R.id.imageView1);
        loadImage("http://www.chinatelecom.com.cn/images/logo_new.gif", R.id.imageView2);
        loadImage("http://cache.soso.com/30d/img/web/logo.gif", R.id.imageView3);
        loadImage("http://csdnimg.cn/www/images/csdnindex_logo.gif", R.id.imageView4);
        loadImage("http://images.cnblogs.com/logo_small.gif", R.id.imageView5);
    }

    private AsyncImageLoader asyncImageLoader = new AsyncImageLoader();

    // 引入线程池，并引入内存缓存功能,并对外部调用封装了接口，简化调用过程
    private void loadImage(final String url, final int id) {
        // 如果缓存过就会从缓存中取出图像，ImageCallback接口中方法也不会被执行
        Drawable cacheImage = asyncImageLoader.loadDrawable(url,
                new AsyncImageLoader.ImageCallback() {
                    // 请参见实现：如果第一次加载url时下面方法会执行
                    public void imageLoaded(Drawable imageDrawable) {
                        ((ImageView) findViewById(id)).setImageDrawable(imageDrawable);
                    }
                });
        if (cacheImage != null) {
            ((ImageView) findViewById(id)).setImageDrawable(cacheImage);
        }
    }

}
