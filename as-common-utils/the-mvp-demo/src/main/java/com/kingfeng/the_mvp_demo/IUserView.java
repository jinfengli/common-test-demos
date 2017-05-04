package com.kingfeng.the_mvp_demo;

/**
 * TODO:
 *
 * @author lijf
 * @version 1.0.0
 * @date $today
 * @copyright (c) wonhigh.cn All rights reserved.
 */
public interface IUserView {
    int getID();
    String getFristName();
    String getLastName();
    void setFirstName (String firstName);
    void setLastName (String lastName);
}
