package com.kingfeng.net_retrofit_load_demos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Person implements Serializable {

    @SerializedName("e-mail")
    @Expose
    private String email;

    @SerializedName("user")
    @Expose
    private String user;

    public String getmEmail() {
        return email;
    }

    public String getmUser() {
        return user;
    }

}
