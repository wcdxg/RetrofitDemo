package com.example.retrofitlib.retrofit.view;

/**
 * Created by Yuaihen.
 * on 2019/7/5
 */
public interface BaseView<T> {

    void loadSuccess(T data, int requestCode);

    void loadFail(String errorMsg, int requestCode);

    void showProgress();

    void hideProgress();

}
