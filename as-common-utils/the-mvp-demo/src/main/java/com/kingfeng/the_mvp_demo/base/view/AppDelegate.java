package com.kingfeng.the_mvp_demo.base.view;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * TODO:
 *
 * @author lijf
 * @version 1.0.0
 * @date $today
 * @copyright (c) wonhigh.cn All rights reserved.
 */
public abstract class AppDelegate implements IDelegate {
    protected View rootView;

    protected final SparseArray<View> mViews = new SparseArray<>();
    public abstract int getRootLayoutId();

    @Override
    public void create(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        int rootLayoutId = getRootLayoutId();
        rootView = inflater.inflate(rootLayoutId, container, false);
    }

    public void setOnClickListener(View.OnClickListener listener, int... ids) {
        if (ids == null) {
            return;
        }
        for (int id : ids) {
            get(id).setOnClickListener(listener);
        }
    }

    public <T extends View> T get(int id) {
        return (T) bindView(id);
    }

    @Override
    public int getOptionsMenuId() {
        return 0;
    }

    @Override
    public Toolbar getToolbar() {
        return null;
    }

    public void setRootView(View rootView) {
        this.rootView = rootView;
    }

    @Override
    public View getRootView() {
        return rootView;
    }

    @Override
    public void initWidget() {

    }

    public <T extends View> T bindView(int id) {
        T view = (T) mViews.get(id);
        if (view == null) {
            view = (T) rootView.findViewById(id);
            mViews.put(id, view);
        }
        return view;
    }

    public void toast(CharSequence msg) {
        Toast.makeText(rootView.getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
