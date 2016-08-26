package com.kingfeng.lv_infinite_show_demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class InfiniteLoopShowAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private LayoutInflater mInflater;
    private Context mContext;
    private ArrayList<String> datas;

    private ItemOnClickListener mItemOnclickListener;

    interface ItemOnClickListener {
         void onItemClick(int postion);
    }

    public void setmItemOnclickListener(ItemOnClickListener mItemOnclickListener) {
        this.mItemOnclickListener = mItemOnclickListener;
    }

    public InfiniteLoopShowAdapter(Context context,ArrayList<String> datas) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.datas = datas;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = mInflater.inflate(R.layout.name_list_item, null);
        return new MyItemHolder(mView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
//        (MyItemHolder)holder.setText(datas.get(position));
        MyItemHolder myItemHolder = (MyItemHolder) holder;
        myItemHolder.tvName.setText(datas.get(position % datas.size()));
//        myItemHolder.scrollview.setScrollView();
    }

    @Override
    public int getItemCount() {
        // 这个值是int的最大值 2147483647
        return datas != null ? Integer.MAX_VALUE : 0;
    }

    class MyItemHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView tvName;

//        private SyncHorizontalScrollView scrollview;

        public MyItemHolder(View itemView) {
            super(itemView);
            this.tvName = (TextView) itemView.findViewById(R.id.tv_name_item);
            tvName.setOnClickListener(this);
//            scrollview = (SyncHorizontalScrollView) itemView.findViewById(R.id.scrollview);
        }

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.tv_name_item) {
                mItemOnclickListener.onItemClick(getAdapterPosition());  // 使用这个来替换 getPosition()
            }
        }
    }

}
