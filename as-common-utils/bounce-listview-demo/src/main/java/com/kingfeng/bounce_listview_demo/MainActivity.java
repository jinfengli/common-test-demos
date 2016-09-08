package com.kingfeng.bounce_listview_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));

        setContentView(linearLayout);

        BounceListView bounceListView = new BounceListView(this);

        String[] data = new String[30];
        for (int i = 0; i < data.length; i++) {
            data[i] = "bounce-- " + i;
        }

        ArrayAdapter<String> arrayAdapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, data);

        bounceListView.setAdapter(arrayAdapter);

        linearLayout.addView(bounceListView);
    }

}
