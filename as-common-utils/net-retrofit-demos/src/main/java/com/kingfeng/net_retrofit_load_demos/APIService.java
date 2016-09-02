package com.kingfeng.net_retrofit_load_demos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by Asus on 03.05.2016.
 */
public interface APIService {

    @GET("phptojson.php")
    Call<List<Person>> getPersonDatas();
}
