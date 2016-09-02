package com.kingfeng.tablayout_demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * TODO:
 *
 * @author lijf
 * @version 1.0.0
 * @date $today
 * @copyright (c) wonhigh.cn All rights reserved.
 */
public class FindFragmentAdapter extends FragmentPagerAdapter {


//    public FindFragmentAdapter(FragmentManager fm) {
//        super(fm);
//    }

    private List<Fragment> list_fragment; //fragment列表
    private List<String> list_Title; //tab名的列表

    public FindFragmentAdapter(FragmentManager fm, List<Fragment> list_fragment, List<String> list_Title) {
        super(fm);
        this.list_fragment = list_fragment;
        this.list_Title = list_Title;
    }

    @Override
    public CharSequence getPageTitle(int position) {
//        return super.getPageTitle(position);

        return list_Title.get(position % list_Title.size());
    }

    @Override
    public Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
