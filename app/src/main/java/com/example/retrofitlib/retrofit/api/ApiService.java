package com.example.retrofitlib.retrofit.api;

import com.example.retrofitlib.retrofit.bean.AdInfoBean;
import com.example.retrofitlib.retrofit.bean.TokenBean;
import com.example.retrofitlib.retrofit.response.Result;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Yuaihen.
 * on 2019/7/5
 * 管理所有接口以及BaseUrl
 * 拦截器中已经默认添加参数Mac/Token/Version
 */
public interface ApiService {

    /**
     * 获取Token
     */
    @POST("api/getToken")
    Call<Result<TokenBean>> getToken();

    /**
     * 获取轮播图
     */
    @POST("api/getAdInfo")
    Call<Result<AdInfoBean>> getAdInfo();

    @FormUrlEncoded
    @POST("api/getConfig")
    Call<Result<AdInfoBean>> getConfi(@Field("config") String config);

}
