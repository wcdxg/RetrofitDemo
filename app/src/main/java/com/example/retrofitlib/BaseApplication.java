package com.example.retrofitlib;

import android.app.Application;

import com.example.retrofitlib.retrofit.NetManager;

/**
 * Created by Yuaihen.
 * on 2019/7/9
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        NetManager.getInstance().init();
    }
}
