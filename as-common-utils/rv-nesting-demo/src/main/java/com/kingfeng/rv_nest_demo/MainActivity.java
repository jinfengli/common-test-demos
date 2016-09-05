package com.kingfeng.rv_nest_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private ArrayList<Order> orderDatas = null;

    private ArrayList<Order.Good> goodsDatas = null;
    private ArrayList<Order.Good> goodsDatas2 = null;

    private RecyclerView recyclerView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        init();

        orderDatas = new ArrayList<>();
        goodsDatas = new ArrayList<>();
        goodsDatas2 = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recylcerview);

        initDatas();


//        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //添加了一个灰色背景
        recyclerView.setBackgroundColor(Color.WHITE);
        recyclerView.setAdapter(new RVNestingAdapter(this, orderDatas));
    }

    private void initDatas() {


        goodsDatas.add(new Order.Good("goods1--","16.00","test1"));
        goodsDatas.add(new Order.Good("goods2--","15.00","test2"));
        orderDatas.add(new Order("订单1", goodsDatas));



        goodsDatas2.add(new Order.Good("goods3---","20.00--","tes3"));
        orderDatas.add(new Order("订单3", goodsDatas2));

    }

//    private void init() {
//        orderDatas = new ArrayList<>();
//        goodsDatas = new ArrayList<>();
//
//        recyclerView = (RecyclerView) findViewById(R.id.recylcerview);
//    }
}
