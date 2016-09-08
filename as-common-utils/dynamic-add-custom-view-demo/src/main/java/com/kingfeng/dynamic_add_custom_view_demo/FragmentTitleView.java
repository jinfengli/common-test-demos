package com.kingfeng.dynamic_add_custom_view_demo;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * TODO:
 *
 * @author lijf
 * @version 1.0.0
 */
public class FragmentTitleView extends RelativeLayout {

    private static final String TAG = FragmentTitleView.class.getSimpleName();

    private Context mContext;
    private TextView tvTitle;
    private ImageView ivUnderLineTitle;
//    private RelativeLayout rlPackageTitle;

    public String getTitle() {
        return Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }



    public void setName() {
        tvTitle.setText(Title);
    }

    private String Title;

    private onTitleClickListener titleClickListener = null;
    public void setTitleClickListener(onTitleClickListener titleClickListener) {
        this.titleClickListener = titleClickListener;
    }

    public FragmentTitleView(Context context) {
        this(context,null);
    }

    public FragmentTitleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FragmentTitleView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.mContext = context;
        if (getChildCount() > 0) {
            throw new RuntimeException("IncreaseReduceTextView不允许有子元素.");
        }
        initView();
    }



    private void initView() {
//        rlPackageTitle = (RelativeLayout) findViewById(R.id.rv_package_title);

        final View view = LayoutInflater.from(mContext).inflate(R.layout.express_package_head_item, null);
        RelativeLayout.LayoutParams vlp = new RelativeLayout.LayoutParams(
                getResources().getDisplayMetrics().widthPixels / 5, RelativeLayout.LayoutParams.WRAP_CONTENT);
        view.setLayoutParams(vlp);

        tvTitle = (TextView) view.findViewById(R.id.tv_package_head_item);

        ivUnderLineTitle = (ImageView) view.findViewById(R.id.iv_underline_package_head_item);
        view.setFocusable(true);
//        addView(tvTitle);
//        view.addView(ivUnderLineTitle);

//        rlPackageTitle.addView(view);

//        removeView(rlPackageTitle);
//        removeAllViews();
//        addView(tvTitle);
//        addView(ivUnderLineTitle);
        this.addView(view);
        tvTitle.setText(getTitle() + "");

//        view.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (titleClickListener != null) {
//                    titleClickListener.onTitleClick();
//                    Log.e(TAG,"hello hello" +  view.getId());
//                }
//            }
//        });

    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {

        if(event.getAction() == MotionEvent.ACTION_DOWN) {
            titleClickListener.onTitleClick(this);
        }
        return super.onTouchEvent(event);
    }

    public void setting() {
        tvTitle.setText(getTitle());
        tvTitle.setTextColor(Color.RED);
        ivUnderLineTitle.setImageResource(R.color.green_express);
    }



    public void reset() {
        tvTitle.setTextColor(Color.BLACK);
        ivUnderLineTitle.setImageResource(R.color.light_gray);
    }

//    @Override
//    public boolean dispatchTouchEvent(MotionEvent ev) {
//        return true;
//    }

    //    @Override
//    public void onClick(View v) {
//        if (titleClickListener != null) {
//            titleClickListener.onTitleClick(v);
//        }
//    }
//

    public interface onTitleClickListener {
        void onTitleClick(View v);
    }
}
