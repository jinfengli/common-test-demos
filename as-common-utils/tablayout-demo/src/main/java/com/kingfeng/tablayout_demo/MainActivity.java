package com.kingfeng.tablayout_demo;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {


    private static final int totalPagerNumbers = 10;

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private List<String> mTitleList = new ArrayList<>();
    private View view1;//页卡视图
    private List<View> mViewList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewPager = (ViewPager) findViewById(R.id.vp_view);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        view1 = LayoutInflater.from(this).inflate(R.layout.view1, null);

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

        for (int i=0; i< totalPagerNumbers; i++) {
            mViewList.add(view1);
        }

        for (int i=0; i< totalPagerNumbers; i++) {
            mTitleList.add("包裹" +(i+1));
            mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(i)));
        }

        My1PagerAdapter mAdapter = new My1PagerAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
//        mTabLayout.setTabsFromPagerAdapter(mAdapter);
    }


    //ViewPager适配器
    class My1PagerAdapter extends PagerAdapter {
        private List<View> mViewList;

        public My1PagerAdapter(List<View> mViewList) {
            this.mViewList = mViewList;
        }

        @Override
        public int getCount() {
            return mViewList.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            container.removeView(mViewList.get(position));

//            if(mViewList.get(position) != null) {
//                container.removeView(mViewList.get(position));
//            }

            container.addView(mViewList.get(position));
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);
        }

    }
}
