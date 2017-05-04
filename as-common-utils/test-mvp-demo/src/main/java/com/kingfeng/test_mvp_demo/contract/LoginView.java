package com.kingfeng.test_mvp_demo.contract;

/**
 * TODO:
 *
 * @author lijf
 * @version 1.0.0
 * @date $today
 * @copyright (c) wonhigh.cn All rights reserved.
 */
public interface LoginView {

    String getUserName();

    String getPassword();

    void clearUserName();

    void clearPassword();

    void showLoading();

    void hideLoading();

    void setUserNameError();

    void setPasswordError();

    void toMainActivity();

    void showFailedError();
}
