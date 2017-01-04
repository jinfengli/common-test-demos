package com.kingfeng.flowlayout_demo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 把一个ScrollView设置为界面
        ScrollView scrollView = new ScrollView(this);

        // 把FlowLayout添加到ScrollView
        FlowLayout flowLayout = new FlowLayout(this);
        flowLayout.setPadding(6, 6, 6, 6);

        for (String text : list) {
            //创建随即背景的textView
            TextView textView = UiUtils.createRandomColorTextView(this);
            textView.setText(text);
            textView.setTextColor(Color.RED);
            // 把TextView添加到FlowLayout
            flowLayout.addView(textView);
        }

//        flowLayout.setMinimumHeight(200);//设置容器的最小高
        scrollView.addView(flowLayout);
        setContentView(scrollView);
    }

    public static ArrayList<String> list = new ArrayList<String>();

    static {
        list.add("你好");
        list.add("");
        list.add("好帅");
        list.add("人挺不错");
        list.add("善良体贴");
        list.add("有本启奏无本退朝");
        list.add("so good");
        list.add("没有什么可以阻挡");
        list.add("我对自由的向往");
        list.add("好吧");
        list.add("呵呵");
        list.add("对不起");
        list.add("给我个机会");
        list.add("要我做什么都行");
        list.add("你好");
        list.add("你好");
        list.add("三年之后又三年");
        list.add("你好");
        list.add("挺利索的12123");
        list.add("迟早要还的");
        list.add("出来跑");
        list.add("怎么给你机会");
        list.add("你好");
        list.add("你好");
    }
}
