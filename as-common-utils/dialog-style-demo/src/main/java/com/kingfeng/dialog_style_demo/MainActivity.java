package com.kingfeng.dialog_style_demo;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.btn_show_dialog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDlg();
            }
        });


    }

    private void showDlg() {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_dialog);
        dialog.setTitle(" MyDialog");
        Window dlgWindow = dialog.getWindow();
        WindowManager.LayoutParams lp = dlgWindow.getAttributes();
        dlgWindow.setGravity(Gravity.CENTER | Gravity.BOTTOM);

        lp.width = getWindowManager().getDefaultDisplay().getWidth();
        lp.height = getWindowManager().getDefaultDisplay().getHeight() /3;
        dlgWindow.setAttributes(lp);

        dialog.show();
    }
}
