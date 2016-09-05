package com.kingfeng.rv_nest_demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * TODO:
 *
 * @author lijf
 * @version 1.0.0
 * @date $today
 * @copyright (c) wonhigh.cn All rights reserved.
 */
public class ItemAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Order.Good> goods = new ArrayList<>();
        private LayoutInflater mInflater;
        private Context context;

        ItemAdapter(Context context, ArrayList<Order.Good> goods) {
            this.context = context;
            this.goods = goods;
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View mView = mInflater.inflate(R.layout.goods_item, parent, false);
            return new GoodsItemHolder(mView);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            GoodsItemHolder goodsItemHolder = (GoodsItemHolder) holder;
            goodsItemHolder.tvGoodName.setText(goods.get(position).getName());
            goodsItemHolder.tvGoodPrice.setText(goods.get(position).getPrice());
            goodsItemHolder.tvGoodsUrl.setText(goods.get(position).getPicUrl());
        }

        @Override
        public int getItemCount() {
            return goods.size();
        }


        class GoodsItemHolder extends RecyclerView.ViewHolder {

            TextView tvGoodName;
            TextView tvGoodPrice;
            TextView tvGoodsUrl;

            public GoodsItemHolder(View itemView) {
                super(itemView);

                this.tvGoodName = (TextView) itemView.findViewById(R.id.tv_good_name);
                this.tvGoodPrice = (TextView) itemView.findViewById(R.id.tv_good_price);
                this.tvGoodsUrl = (TextView) itemView.findViewById(R.id.tv_good_url);
            }
        }

}
