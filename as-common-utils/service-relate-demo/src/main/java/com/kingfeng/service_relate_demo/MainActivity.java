package com.kingfeng.service_relate_demo;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.kingfeng.service_relate_demo.service.MsgService;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private MsgService msgService;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //绑定Service
        Intent intent = new Intent("com.example.communication.MSG_ACTION");
        bindService(intent,connection, Context.BIND_AUTO_CREATE);

        mProgressBar = (ProgressBar) findViewById(R.id.progressbar1);

        Button mButton = (Button) findViewById(R.id.btn_test);
        mButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //开始下载
                msgService.startDownLoad();
            }
        });

        findViewById(R.id.btn_test_intent_ervice).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,TestIntentServiceActivity.class));
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbindService(connection);
    }

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            msgService = ((MsgService.MsgBinder) service).getService();

//            MsgService.MsgBinder binder = (MsgService.MsgBinder) service;
//            MainActivity.this.msgService = (MsgService) binder.getService();

            msgService.setOnProgressListener(new MsgService.onProgressListener() {
                @Override
                public void onProgress(int progress) {
                    mProgressBar.setProgress(progress);
                }
            });
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            msgService = null;
            Log.d(TAG, "MsgService dicconnected");

        }
    };
}
