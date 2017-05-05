package com.kingfeng.the_mvp_demo;

import android.widget.TextView;

import com.kingfeng.the_mvp_demo.base.view.AppDelegate;

/**
 * View视图层，完全移除与Presenter业务逻辑的耦合
 *
 * @author lijf
 * @version 1.0.0
 * @date 2017-5-5
 * @copyright (c) wonhigh.cn All rights reserved.
 */
public class SimpleDelegate extends AppDelegate {

    @Override
    public int getRootLayoutId() {
        return R.layout.activity_mainactivity;
    }

    @Override
    public void initWidget() {
        super.initWidget();
        TextView tv = get(R.id.tv_themvp_name);
        tv.setText("my name is China.");
    }

    public void setText(String text) {
        TextView tv1 = get(R.id.tv_themvp_name);
        tv1.setText(text);
    }

//    @Override
//    public Toolbar getToolbar() {
//        return super.getToolbar();
//    }
}
