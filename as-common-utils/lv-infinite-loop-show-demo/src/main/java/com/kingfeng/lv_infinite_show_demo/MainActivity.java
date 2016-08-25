package com.kingfeng.lv_infinite_show_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * 可以无限制滚动列表 (RecyclerView 实现)
 */
public class MainActivity extends AppCompatActivity implements InfiniteLoopShowAdapter.ItemOnClickListener {
    private static final String TAG = MainActivity.class.getSimpleName();

    private InfiniteLoopShowAdapter infiniteLoopShowAdapter;
    private RecyclerView rvNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvNames = (RecyclerView) findViewById(R.id.rv_names);
        rvNames.setLayoutManager(new LinearLayoutManager(this));
        rvNames.setItemAnimator(new DefaultItemAnimator());
        infiniteLoopShowAdapter = new InfiniteLoopShowAdapter(this,getDatas());
        getDatas();

        rvNames.setAdapter(infiniteLoopShowAdapter);
        rvNames.scrollToPosition(Integer.MAX_VALUE/2+1); // 取中间值，既能往前scroll，也能往后scroll
        infiniteLoopShowAdapter.setmItemOnclickListener(this);
    }

    private ArrayList<String> getDatas() {
        ArrayList<String> datas = new ArrayList<>();
        datas.add("test1");
        datas.add("test2");
        datas.add("test3");
        datas.add("test4");
        datas.add("test5");
        datas.add("test6");
        datas.add("test7");
        datas.add("test8");
        datas.add("test9");
        datas.add("test10");
        return  datas;
    }

    @Override
    public void onItemClick(int postion) {
        Toast.makeText(MainActivity.this, "点击的位置是："+ postion, Toast.LENGTH_LONG).show();
        Log.i(TAG, "click position is: " + postion);
    }
}
