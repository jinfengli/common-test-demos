package com.kingfeng.two_direction_scroll;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * 双向滚动的View
 *
 * ref: http://blog.csdn.net/elinavampire/article/details/42142551
 */
public class MainActivity extends AppCompatActivity {
    private LinearLayout leftContainerView;
    private ListView leftListView;
    private List<String> leftlList;
    private LinearLayout rightContainerView;
    private ListView rightListView;
    private List<RightModel> models;
    private SyncHorizontalScrollView titleHorsv;
    private SyncHorizontalScrollView contentHorsv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        leftContainerView = (LinearLayout) findViewById(R.id.left_container);
        leftListView = (ListView) findViewById(R.id.left_container_listview);
        rightContainerView = (LinearLayout) findViewById(R.id.right_container);
        rightListView = (ListView) findViewById(R.id.right_container_listview);
        titleHorsv = (SyncHorizontalScrollView) findViewById(R.id.title_horsv);
        contentHorsv = (SyncHorizontalScrollView) findViewById(R.id.content_horsv);

        // 让title和content联动；
        titleHorsv.setScrollView(contentHorsv);
        contentHorsv.setScrollView(titleHorsv);
        leftContainerView.setBackgroundColor(Color.YELLOW);
        initLeftData();
        MyLeftAdapter adapter=new MyLeftAdapter(this, leftlList);
        leftListView.setAdapter(adapter);
        UtilTools.setListViewHeightBasedOnChildren(leftListView);
        rightContainerView.setBackgroundColor(Color.GRAY);

        initRightData();
        MyRightAdapter myRightAdapter=new MyRightAdapter(this, models);
        rightListView.setAdapter(myRightAdapter);
        UtilTools.setListViewHeightBasedOnChildren(rightListView);
    }

    private void initRightData() {
        models=new ArrayList<RightModel>();
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));

        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));

        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
        models.add(new RightModel("111", "222", "333", "444", "555", "666"));
    }

    private void initLeftData() {
        leftlList=new ArrayList<String>();
        leftlList.add("v1");
        leftlList.add("v2");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");

        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");

        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");
        leftlList.add("aaaa");

    }
}
