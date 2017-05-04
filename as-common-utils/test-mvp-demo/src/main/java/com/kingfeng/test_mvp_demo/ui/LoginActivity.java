package com.kingfeng.test_mvp_demo.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.kingfeng.test_mvp_demo.contract.LoginPresenterImpl;
import com.kingfeng.test_mvp_demo.R;
import com.kingfeng.test_mvp_demo.contract.LoginView;

public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {

    private EditText mEtUsername, mEtPassword;
    private Button mBtnLogin, mBtnClear;
    private ProgressBar mPbLoading;

    private LoginPresenterImpl mUserLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mUserLoginPresenter = new LoginPresenterImpl(this);
        initViews();
    }

    private void initViews() {
        mEtUsername = (EditText) findViewById(R.id.id_et_username);
        mEtPassword = (EditText) findViewById(R.id.id_et_password);
        mBtnClear = (Button) findViewById(R.id.id_btn_clear);
        mBtnLogin = (Button) findViewById(R.id.id_btn_login);
        mPbLoading = (ProgressBar) findViewById(R.id.id_pb_loading);
        mBtnLogin.setOnClickListener(this);
        mBtnClear.setOnClickListener(this);
    }

    @Override
    public String getUserName() {
        return mEtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return mEtPassword.getText().toString();
    }

    @Override
    public void clearUserName() {
        mEtUsername.setText("");
    }

    @Override
    public void clearPassword() {
        mEtPassword.setText("");
    }

    @Override
    public void showLoading() {
        mPbLoading.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void setUserNameError() {
        Toast.makeText(this, "username should not null", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setPasswordError() {
        Toast.makeText(this, "Password should not null", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void toMainActivity() {
        Toast.makeText(this, "username" + getUserName()
                + "login success , to main page----", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.id_btn_login) {
            mUserLoginPresenter.login(getUserName(), getPassword());
        } else if(v.getId() == R.id.id_btn_clear) {
            mUserLoginPresenter.clear();
        }
    }
}
