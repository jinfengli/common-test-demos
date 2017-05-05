package com.kingfeng.the_mvp_demo;

import android.view.View;

import com.kingfeng.the_mvp_demo.base.ActivityPresenter;

public class MainActivity extends ActivityPresenter<SimpleDelegate> implements View.OnClickListener {

    @Override
    protected Class<SimpleDelegate> getDelegateClass() {
        return SimpleDelegate.class;
    }

    @Override
    protected void bindEventListener() {
        super.bindEventListener();
        viewDelegate.setOnClickListener(this, R.id.btn_themvp_save);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_themvp_save:
                viewDelegate.setText("click save button.");
//                viewDelegate.toast("点击了save button.");
                break;
        }
    }


}
