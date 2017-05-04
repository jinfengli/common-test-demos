package com.kingfeng.the_mvp_demo;

/**
 * TODO:
 *
 * @author lijf
 * @version 1.0.0
 * @date $today
 * @copyright (c) wonhigh.cn All rights reserved.
 */
public interface IUserModel {
    void setID (int id);
    void setFirstName (String firstName);
    void setLastName (String lastName);
    int getID();
    UserBean load (int id);//通过id读取user信息,返回一个UserBean
}
