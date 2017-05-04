package com.kingfeng.the_mvp_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IUserView {

    private EditText mFirstNameEditText , mLastNameEditText , mIdEditText ;
    private Button mSaveButton , mLoadButton ;
    private UserPresenter mUserPresenter ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public String getFristName() {
        return null;
    }

    @Override
    public String getLastName() {
        return null;
    }

    @Override
    public void setFirstName(String firstName) {

    }

    @Override
    public void setLastName(String lastName) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.saveButton:
                mUserPresenter.saveUser(getID(), getFristName(),
                        getLastName());
                break;
            case R.id.loadButton:
                mUserPresenter.loadUser(getID());
                break;
            default:
                break;
        }
    }
}
