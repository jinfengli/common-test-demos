package com.kingfeng.custom_thread_pool_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 * 线程池功能的不同归根到底还是内部的BlockingQueue实现不同，所以，我们要实现我们自己想要的线程池，
 * 就必须从BlockingQueue的实现上做手脚，而上面也说了BlockingQueue的实现类有多个，
 * 那么这次我们就选用PriorityBlockingQueue来实现一个功能是按任务的优先级来处理的线程池。
 */
public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView textView;

    boolean isPause = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textview);

        // 使用自己的PriorityRunnable 提交任务
//        ExecutorService priorityThreadPool = new ThreadPoolExecutor(3, 3, 0L,
//                TimeUnit.SECONDS, new PriorityBlockingQueue<Runnable>());
//        for (int i = 1; i <= 10; i++) {
//            final int priority = i;
//            priorityThreadPool.execute(new PriorityRunnable(priority) {
//                @Override
//                public void doSth() {
//                    String threadName = Thread.currentThread().getName();
//                    Log.v(TAG, "线程：" + threadName + ",正在执行优先级为：" + priority + "的任务");
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }

        final PausableThreadPoolExecutor pausableThreadPoolExecutor = new PausableThreadPoolExecutor(1, 1, 0L, TimeUnit.SECONDS,
                new PriorityBlockingQueue<Runnable>());

        findViewById(R.id.btn_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 1; i <= 100; i++) {
                    final int priority = i;
                    pausableThreadPoolExecutor.execute(new PriorityRunnable(priority) {
                        @Override
                        public void doSth() {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    textView.setText(priority + "");
                                }
                            });

                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        });

        findViewById(R.id.btn_pause).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPause) {
                    pausableThreadPoolExecutor.resume();
                    isPause = false;
                } else {
                    pausableThreadPoolExecutor.pause();
                    isPause = true;

                }
            }
        });

        findViewById(R.id.btn_stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!pausableThreadPoolExecutor.isShutdown()) {
                    pausableThreadPoolExecutor.shutdown();
//                    pausableThreadPoolExecutor.shutdownNow();
                }

            }
        });








//        这个线程池设为只有一个线程，然后直接在TextView中显示当前执行的任务的优先级，然后设置个开关，控制线程池的暂停与开始：


    }





}
