package com.kingfeng.dynamic_add_custom_view_demo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 订单的所有包裹物流信息
 */
public class MainPageActivity extends FragmentActivity implements
        ViewPager.OnPageChangeListener,
        FragmentTitleView.onTitleClickListener {

    private static final String TAG = MainPageActivity.class.getSimpleName();
    private LinearLayout llFragmentTitle;

    private static final int TOTAL_NUM = 5;

    private ViewPager fragmentMainVP;

    private FragPagerAdapter fragPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_express_main);

        initView();
        setlistener();
    }

    protected void initView() {
        fragmentMainVP = (ViewPager) findViewById(R.id.expresss_main_vp);
        fragPagerAdapter = new FragPagerAdapter(this.getSupportFragmentManager());
        fragmentMainVP.setAdapter(fragPagerAdapter);
        llFragmentTitle = (LinearLayout) findViewById(R.id.ll_fragment_title);

        //定义子View中两个元素的布局
        for (int i = 0; i < TOTAL_NUM; i++) {
            FragmentTitleView titleView = new FragmentTitleView(MainPageActivity.this);
            titleView.setTitle("Tab"+(i+1));
            titleView.setFocusable(true);
            titleView.setClickable(true);

//            titleView.setTitleClickListener(MainPageActivity.this);
            titleView.setTag(i);
//            titleView.setId(View.generateViewId());
            titleView.setId(R.id.goods_head_title);   // 自己在ids.xml 中定义的id
            llFragmentTitle.addView(titleView);


            titleView.setTitleClickListener(this);
        }


        setAllTitle(llFragmentTitle);
        setFocusView(llFragmentTitle, 0); // 默认第0个fragment处于选中状态
    }

    private void setlistener() {
        fragmentMainVP.setOnPageChangeListener(this);
    }


    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Fragment mcFragment = fragPagerAdapter.getItem(position);
        setFocusView(llFragmentTitle, position);
        Log.e(TAG, "viewpager  pageSelected: ----> " + position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onTitleClick(View v) {
        int tag = (Integer) v.getTag();

        Log.e(TAG, "click tag is " + tag);
//        ((ExpressPackageTitleView) v).setting();
        setFocusView(llFragmentTitle, tag);
        fragmentMainVP.setCurrentItem(tag);

//        if(tag == 1) {
//            Log.e(TAG,"hello hello-------->  v.getTag():" + v.getTag());
//        } else if(tag == 0) {
//            Log.e(TAG,"---" + v.getTag());
//        }
    }

    public void setFocusView(LinearLayout linearLayout, int focusPosition) {

            for (int i = 0; i< TOTAL_NUM; i++) {
                FragmentTitleView titleView = (FragmentTitleView)linearLayout.getChildAt(i);
                if(i == focusPosition) {
                    titleView.setting();
                } else {
                    titleView.reset();
                }
//            view.reset();
            }
    }

    public void setAllTitle(LinearLayout linearLayout) {
        for (int i = 0; i< TOTAL_NUM; i++) {
            FragmentTitleView titleView = (FragmentTitleView)linearLayout.getChildAt(i);
            titleView.setName();
        }
    }
}
