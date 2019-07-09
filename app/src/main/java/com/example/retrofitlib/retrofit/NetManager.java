package com.example.retrofitlib.retrofit;

import com.example.retrofitlib.retrofit.api.ApiService;
import com.example.retrofitlib.retrofit.converter.MyGsonConverterFactory;
import com.example.retrofitlib.retrofit.interceptor.LogInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by Yuaihen.
 * on 2019/7/5
 * 统一管理网络请求
 */
public class NetManager {

    private static Retrofit mRetrofit;

    private NetManager() {
    }

    private static String BASE_URL = "http://10.1.30.6:9008/";

    private static NetManager mInstance;

    public static NetManager getInstance() {
        if (mInstance == null) {
            synchronized (NetManager.class) {
                if (mInstance == null) {
                    mInstance = new NetManager();
                }
            }
        }
        return mInstance;
    }

    private static ApiService sApi;

    public static ApiService getApi() {
        if (sApi == null) {
            synchronized (ApiService.class) {
                if (sApi == null) {
                    sApi = mRetrofit.create(ApiService.class);
                }
            }
        }
        return sApi;
    }

//    private static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
//            //            .serializeNulls()
//            .create();


    /**
     * 初始化网络请求
     */
    public void init() {
        OkHttpClient.Builder client = new OkHttpClient.Builder();
        //        if (!AppUtil.isRelease()) {
        //            HttpLoggingInterceptor httpInterceptor = new HttpLoggingInterceptor(message -> LogUtil.e("data", message))
        //                    .setLevel(HttpLoggingInterceptor.Level.BODY);
        //            client.addNetworkInterceptor(httpInterceptor);
        //        }

        client.addInterceptor(new LogInterceptor());
        client.connectTimeout(10, TimeUnit.SECONDS);
        client.readTimeout(25, TimeUnit.SECONDS);
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MyGsonConverterFactory.create())
                //                .addConverterFactory(GsonConverterFactory.create(gson))
                //                .addCallAdapterFactory()
                .client(client.build())
                .build();
    }

}
