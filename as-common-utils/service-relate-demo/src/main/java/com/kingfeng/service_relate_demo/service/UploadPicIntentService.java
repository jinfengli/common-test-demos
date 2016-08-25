package com.kingfeng.service_relate_demo.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.kingfeng.service_relate_demo.TestIntentServiceActivity;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p/>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class UploadPicIntentService extends IntentService {

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    public UploadPicIntentService() {
        super("UploadPicIntentService");
    }

    private static final String ACTION_UPLOAD_PIC = "com.kingfeng.intentservice.action.UPLOAD_IMAGE";
    public static final String EXTRA_IMG_PATH = "com.kingfeng.intentservice.extra.IMG_PATH";

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_UPLOAD_PIC.equals(action)) {
                final String path = intent.getStringExtra(EXTRA_IMG_PATH);
                handleUploadImg(path);
            }
        }
    }

    private void handleUploadImg(String path) {
        try {
            //模拟上传耗时
            Thread.sleep(2000);
            Intent intent = new Intent(TestIntentServiceActivity.UPLOAD_RESULT);
            intent.putExtra(EXTRA_IMG_PATH, path);
            sendBroadcast(intent);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("TAG", "onCreate");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("TAG", "onDestroy");
    }

    public static void startUploadImg(Context context, String path) {
        Intent intent = new Intent(context, UploadPicIntentService.class);
        intent.setAction(ACTION_UPLOAD_PIC);
        intent.putExtra(EXTRA_IMG_PATH, path);
        context.startService(intent);
    }
}
