package com.kingfeng.net_retrofit_load_demos;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Query {

    private static APIService instanse;

    private static final String BASE_URL = "http://taharo.pp.ua/";

    public static APIService getInstanse() {
        if (instanse == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(new OkHttpClient()) // 添加okhttp的委托
                    .build();

            instanse = retrofit.create(APIService.class);
            return instanse;
        }
        return instanse;
    }
}
