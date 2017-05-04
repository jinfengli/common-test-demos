package com.kingfeng.the_mvp_demo;

/**
 * TODO:
 *
 * @author lijf
 * @version 1.0.0
 * @date $today
 * @copyright (c) wonhigh.cn All rights reserved.
 */
public class UserBean {
    private String mFirstName ;
    private String mLastName ;
    public UserBean (String firstName, String lastName) {
        this .mFirstName = firstName;
        this .mLastName = lastName;
    }
    public String getFirstName() {
        return mFirstName ;
    }
    public String getLastName() {
        return mLastName ;
    }
}
