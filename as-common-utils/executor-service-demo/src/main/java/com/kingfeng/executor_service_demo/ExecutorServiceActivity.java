package com.kingfeng.executor_service_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class ExecutorServiceActivity extends AppCompatActivity {
    private static final String TAG = ExecutorServiceActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_executor_service);
        Log.d(TAG, "CPU 数量:" + Runtime.getRuntime().availableProcessors());

        // 打印线程池中的线程执行任务的情况
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//        for (int i = 1; i <= 10; i++) {
//            final int index = i;
//            fixedThreadPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    String threadName = Thread.currentThread().getName();
//                    Log.v(TAG, "线程："+threadName+",正在执行第" + index + "个任务");
//                    try {
//                        Thread.sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//        }


        // 依次一个一个的处理任务，而且都是复用一个线程;
        // 创建一个singleThreadExecutorPool实际上就是创建一个核心线程数和最大线程数都为1的fixedThreadPool.
        // 看源码：
//    public static ExecutorService newSingleThreadExecutor() {
//        return new FinalizableDelegatedExecutorService
//                (new ThreadPoolExecutor(1, 1,
//                        0L, TimeUnit.MILLISECONDS,
//                        new LinkedBlockingQueue<Runnable>()));
//    }


        ExecutorService singleThreadPool = Executors.newSingleThreadExecutor();
        for (int i = 1; i <= 10; i++) {
            final int index = i;
            singleThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    String threadName = Thread.currentThread().getName();
                    Log.v(TAG, "线程："+threadName+",正在执行第" + index + "个任务");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }


        // 创建一个可以根据实际情况调整线程池中线程的数量的线程池
//        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
//        for (int i = 1; i <= 10; i++) {
//            final int index = i;
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            cachedThreadPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    String threadName = Thread.currentThread().getName();
//                    Log.v(TAG, "线程：" + threadName + ",正在执行第" + index + "个任务");
//                    try {
//                        long time = index * 500;
//                        Thread.sleep(time);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            });
//
//        }

        // 创建一个可以定时或周期性执行任务的线程池
//        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);//延迟2秒后执行该任务
//        scheduledThreadPool.schedule(new Runnable() {
//            @Override
//            public void run()
//            {}
//        }, 2, TimeUnit.SECONDS);//延迟1秒后，每隔2秒执行一次该任务
//
//        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run()
//            {}
//        }, 1, 2, TimeUnit.SECONDS);

        ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();


    }
}
