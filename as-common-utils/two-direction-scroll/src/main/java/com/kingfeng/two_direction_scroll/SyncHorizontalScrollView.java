package com.kingfeng.two_direction_scroll;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.HorizontalScrollView;

/**
 * TODO:
 *
 * @author lijf
 * @version 1.0.0
 * @date $today
 * @copyright (c) wonhigh.cn All rights reserved.
 */
public class SyncHorizontalScrollView extends HorizontalScrollView {
    private View mView;

    public SyncHorizontalScrollView(Context context) {
        super(context);
    }

    public SyncHorizontalScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        //设置控件滚动监听，得到滚动的距离，然后让传进来的view也设置相同的滚动具体
        if (mView != null) {
            mView.scrollTo(l, t);
        }
    }

    /**
     * 设置跟它联动的view
     *
     * @param view
     */
    public void setScrollView(View view) {
        mView = view;
    }
}
