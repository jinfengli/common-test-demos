package com.kingfeng.the_mvp_demo;

import android.widget.TextView;

import com.kingfeng.the_mvp_demo.base.view.AppDelegate;

/**
 * TODO:
 *
 * @author lijf
 * @version 1.0.0
 * @date $today
 * @copyright (c) wonhigh.cn All rights reserved.
 */
public class SimpleDelegate extends AppDelegate {

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        TextView tv = get(R.id.username);
        tv.setText("my name is China.");
    }

    public void setText(String text) {
        TextView tv = get(R.id.username);
        tv.setText(text);
    }



//    @Override
//    public Toolbar getToolbar() {
//        return super.getToolbar();
//    }
}
