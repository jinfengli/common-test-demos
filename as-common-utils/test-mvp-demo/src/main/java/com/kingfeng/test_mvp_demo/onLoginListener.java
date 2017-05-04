package com.kingfeng.test_mvp_demo;

import com.kingfeng.test_mvp_demo.bean.User;

/**
 * TODO:
 *
 * @author lijf
 * @version 1.0.0
 * @date $today
 * @copyright (c) wonhigh.cn All rights reserved.
 */
public interface onLoginListener {

    void loginSuccess(User user);
    void loginFailed();
}
