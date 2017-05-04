package com.kingfeng.test_mvp_demo.contract;

/**
 * TODO:
 *
 * @author lijf
 * @version 1.0.0
 * @date $today
 * @copyright (c) wonhigh.cn All rights reserved.
 */
public interface LoginPresenter {
    /**
     * 登陆请求
     *
     * @param username 用户名
     */
    void login(String username, String password);


    void clear();
}
