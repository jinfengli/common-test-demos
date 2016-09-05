package com.kingfeng.rv_nest_demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RVNestingAdapter extends RecyclerView.Adapter<BaseHolder> {

    private static final String TAG = RVNestingAdapter.class.getSimpleName();

    private Context context;
    private ArrayList<Order> orders = new ArrayList<>();

    private ArrayList<Order.Good> goods = new ArrayList<>();

    private final static int UNIQUE = 0;
    private final static int NO_UNIQUE = 1;

    private LayoutInflater mInflater;

    public RVNestingAdapter(Context context, ArrayList<Order> orders) {
        this.context = context;
        this.orders = orders;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == UNIQUE) {
            return new ItemViewHolder(R.layout.order_single_item,parent,viewType);
        } else if(viewType == NO_UNIQUE) {
            return new SubRecyclerViewHolder(R.layout.order_double_item, parent,viewType);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(BaseHolder holder, int position) {

        Order order = orders.get(position);
        if(holder instanceof ItemViewHolder) {
            ((ItemViewHolder) holder).refreshData(order, position);
        } else if(holder instanceof SubRecyclerViewHolder) {
            ((SubRecyclerViewHolder) holder).refreshData(goods, position);
        }
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

    @Override
    public int getItemViewType(int position) {
        // 订单中的商品数大于一件
        if (orders != null && orders.get(position).getGoodsList().size() > 1) {
            return NO_UNIQUE;
        } else if (orders.get(position).getGoodsList().size() == 1)
            return UNIQUE;
        return super.getItemViewType(position);
    }

    private class ItemViewHolder extends BaseHolder<Order> {
        TextView tvOrderName;
        TextView tvGoodName;
        TextView tvGoodsPrice;
        TextView tvGoodPicUrl;

        public ItemViewHolder(int viewId, ViewGroup parent, int viewType) {
            super(viewId, parent, viewType);
            this.tvOrderName = (TextView) itemView.findViewById(R.id.tv_item_order_name);
            this.tvGoodName = (TextView) itemView.findViewById(R.id.tv_item_good_name);
            this.tvGoodsPrice = (TextView) itemView.findViewById(R.id.tv_item_good_price);
            this.tvGoodPicUrl = (TextView) itemView.findViewById(R.id.tv_item_good_url);
        }

        @Override
        public void refreshData(Order data, int position) {
            super.refreshData(data, position);
            tvOrderName.setText(data.getTagName());
            tvGoodName.setText(data.getGoodsList().get(position).getName());
            tvGoodsPrice.setText(data.getGoodsList().get(position).getPrice());
            tvGoodPicUrl.setText(data.getGoodsList().get(position).getPicUrl());
        }
    }

    private class SubRecyclerViewHolder extends BaseHolder<List<Order.Good>> {

        private RecyclerView item_recyclerview;
        private TextView tvOrderName;
        private List<Order.Good> data;
        public SubRecyclerViewHolder(int viewId, ViewGroup parent, int viewType) {
            super(viewId, parent, viewType);

            tvOrderName = (TextView) itemView.findViewById(R.id.tv_item_order_name2);
            item_recyclerview = (RecyclerView) itemView.findViewById(R.id.rvGoods);
        }

        @Override
        public void refreshData(List<Order.Good> data, int position) {
            super.refreshData(data, position);
            this.data = data;

            tvOrderName.setText(data.get(position).getName());

            item_recyclerview.setBackgroundResource(R.color.colorPrimary);
            item_recyclerview.setAdapter(new GoodItemAdapter());
        }

        private class GoodItemAdapter extends RecyclerView.Adapter<BaseHolder> {
            @Override
            public BaseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                return new GoodsItemHolder(R.layout.goods_item, parent, viewType);
            }

            @Override
            public void onBindViewHolder(BaseHolder holder, int position) {
                holder.refreshData(data.get(position), position);
            }

            @Override
            public int getItemCount() {
                return data.size();
            }
        }
    }

    class GoodsItemHolder extends BaseHolder<Order.Good> {

        TextView tvGoodName;
        TextView tvGoodPrice;
        TextView tvGoodsUrl;

        private Order.Good data;

        public GoodsItemHolder(int viewId, ViewGroup parent, int viewType) {
            super(viewId, parent, viewType);
            this.tvGoodName = (TextView) itemView.findViewById(R.id.tv_good_name);
            this.tvGoodPrice = (TextView) itemView.findViewById(R.id.tv_good_price);
            this.tvGoodsUrl = (TextView) itemView.findViewById(R.id.tv_good_url);
        }

        @Override
        public void refreshData(Order.Good data, int position) {
            super.refreshData(data, position);
            this.data = data;
            tvGoodName.setText(data.getName());
            tvGoodPrice.setText(data.getPrice());
            tvGoodsUrl.setText(data.getPicUrl());

        }

    }



}
