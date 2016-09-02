package com.kingfeng.net_retrofit_load_demos;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private List<Person> personList;
    private Context context;

    public DataAdapter(List<Person> persons, Context context) {
        this.personList = persons;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int position) {
        Person person = personList.get(position);
        viewHolder.mEmail.setText(person.getmEmail());
        viewHolder.mUser.setText(person.getmUser());
    }

    @Override
    public int getItemCount() {
        return personList == null ? 0 : personList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mEmail, mUser;

        public ViewHolder(View view) {
            super(view);
            mEmail = (TextView) view.findViewById(R.id.tv_mail);
            mUser = (TextView) view.findViewById(R.id.tv_user);
        }
    }
}
