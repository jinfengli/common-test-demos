package com.kingfeng.service_relate_demo.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MsgService extends Service {
    // 更新进度回调
    public interface onProgressListener {
        void onProgress(int progress);
    }

    // 进度条的最大值
    public static final int MAX_PROGRESS = 100;
    // 进度条的进度值
    private int progress = 0;
    private onProgressListener onProgressListener;

    public void setOnProgressListener(MsgService.onProgressListener onProgressListener) {
        this.onProgressListener = onProgressListener;
    }

    // 返回一个Binder对象；
    @Override
    public IBinder onBind(Intent intent) {
        return new MsgBinder();
    }

    public class MsgBinder extends Binder {

        // 获取当前Service的实例
        public MsgService getService() {

            return MsgService.this;
        }
    }

    public void startDownLoad() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress < MAX_PROGRESS) {
                    progress += 5;
                    if(onProgressListener != null) {
                        onProgressListener.onProgress(progress);
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }
}
