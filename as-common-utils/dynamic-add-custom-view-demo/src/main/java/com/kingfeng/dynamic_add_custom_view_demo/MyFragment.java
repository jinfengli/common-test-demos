package com.kingfeng.dynamic_add_custom_view_demo;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


@SuppressLint("ValidFragment")
public class MyFragment extends Fragment {

    private View mainView;

    private int pageIndex;

    public MyFragment(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mainView = inflater.inflate(R.layout.fragment_express, null);

        TextView tvContent = (TextView) mainView.findViewById(R.id.fragment_test);
        tvContent.setText("您选中的fragment是：" + pageIndex);

//        return super.onCreateView(inflater, container, savedInstanceState);
        return mainView;
    }
}
