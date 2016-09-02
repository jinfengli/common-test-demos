package com.kingfeng.net_retrofit_load_demos;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private List<Person> personList;
    private DataAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.card_recycler_view);
        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        getData(recyclerView);
    }

    public void getData(final RecyclerView recyclerView) {
        final ProgressDialog loading = new ProgressDialog(this);
        loading.setMessage("数据加载中...");
        loading.show();

        Query.getInstanse().getPersonDatas().enqueue(new Callback<List<Person>>() {
            @Override
            public void onResponse(Call<List<Person>> call, Response<List<Person>> response) {
                personList = response.body();
                mAdapter = new DataAdapter(personList, MainActivity.this);
                recyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();
                loading.dismiss();
            }

            @Override
            public void onFailure(Call<List<Person>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
                Toast.makeText(getApplicationContext(),"onFailure:" + t.getMessage(), Toast.LENGTH_LONG).show();
                loading.dismiss();
            }
        });
    }
}
