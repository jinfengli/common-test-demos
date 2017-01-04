package com.kingfeng.android_mask_demo;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.kingfeng.android_mask_demo.checkpermission.CheckPermission;
import com.kingfeng.android_mask_demo.checkpermission.PermissionActivity;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 0;//请求码
    private CheckPermission checkPermission;//检测权限器

    //配置需要取的权限
    public static final String[] PERMISSION = new String[]{
            Manifest.permission.WRITE_EXTERNAL_STORAGE,// 写入权限
            Manifest.permission.READ_EXTERNAL_STORAGE,  //读取权限
            Manifest.permission.READ_PHONE_STATE,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_mask_demo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MaskingActivity.class));
            }
        });

        checkPermission = new CheckPermission(this);
        // 缺少权限时，进入权限设置页面
        if (checkPermission.permissionSet(PERMISSION)) {
            startPermissionActivity();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        //缺少权限时，进入权限设置页面
//        if (checkPermission.permissionSet(PERMISSION)) {
//            startPermissionActivity();
//        }
    }

    //进入权限设置页面
    private void startPermissionActivity() {
        PermissionActivity.startActivityForResult(this, REQUEST_CODE, PERMISSION);
    }

    //返回结果回调
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //拒绝时，没有获取到主要权限，无法运行，关闭页面
        if (requestCode == REQUEST_CODE && resultCode == PermissionActivity.PERMISSION_DENIEG) {
            finish();
            Toast.makeText(MainActivity.this, "权限不足，部分功能可能无法使用", Toast.LENGTH_LONG).show();
        }
    }
}

