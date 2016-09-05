package com.kingfeng.rv_nest_demo;

import java.util.ArrayList;

/**
 * TODO:
 *
 * @author lijf
 * @version 1.0.0
 * @date $today
 * @copyright (c) wonhigh.cn All rights reserved.
 */
public class Order {

//    private ItemType itemType; //作为不同item类型的判断
    private String tagName;

    private ArrayList<Good> goodsList;


    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public ArrayList<Good> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(ArrayList<Good> goodsList) {
        this.goodsList = goodsList;
    }

    public Order(String tagName, ArrayList<Good> goodsList) {
        this.tagName = tagName;
        this.goodsList = goodsList;
    }

    static class Good {
        private String name;
        private String price;
        private String picUrl;

        public Good(String name, String price, String picUrl) {
            this.name = name;
            this.price = price;
            this.picUrl = picUrl;
        }

        public String getName() {
            return name;
        }

        public String getPrice() {
            return price;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }
    }


}
