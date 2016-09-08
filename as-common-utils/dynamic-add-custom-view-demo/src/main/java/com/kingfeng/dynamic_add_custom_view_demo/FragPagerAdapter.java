package com.kingfeng.dynamic_add_custom_view_demo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * TODO:
 *
 * @author lijf
 * @version 1.0.0
 */
public class FragPagerAdapter extends FragmentStatePagerAdapter {

    private int fragIndex;

    public FragPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        return new MyFragment(i);
    }

    @Override
    public int getCount() {
        return 5;
    }
}
