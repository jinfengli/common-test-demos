package com.kingfeng.the_mvp_demo.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.kingfeng.the_mvp_demo.base.view.IDelegate;

/**
 * TODO: Presenter Activity实现基类
 *
 * @author lijf
 * @version 1.0.0
 * @date 2017-5-4
 * @copyright (c) wonhigh.cn All rights reserved.
 */
public abstract class ActivityPresenter<T extends IDelegate> extends AppCompatActivity {
    protected T viewDelegate;

    public ActivityPresenter() {
        try {
            viewDelegate = getDelegateClass().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//    }

    @Override
    public void onCreate(Bundle savedInstanceState/*, PersistableBundle persistentState*/) {
        super.onCreate(savedInstanceState/*, persistentState*/);

        viewDelegate.create(getLayoutInflater(), null, savedInstanceState);
        setContentView(viewDelegate.getRootView());

        initToolBar();
        viewDelegate.initWidget();
        bindEventListener();
    }

    protected void bindEventListener() {

    }

    private void initToolBar() {
        Toolbar toolbar = viewDelegate.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (viewDelegate.getOptionsMenuId() != 0) {
            getMenuInflater().inflate(viewDelegate.getOptionsMenuId(), menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onDestroy() {
        viewDelegate = null;
        super.onDestroy();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (viewDelegate == null) {
            try {
                viewDelegate = getDelegateClass().newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException("create IDelegate error");
            } catch (IllegalAccessException e) {
                throw new RuntimeException("create IDelegate error");
            }
        }
    }

    // 委托类
    protected abstract Class<T> getDelegateClass();
}
