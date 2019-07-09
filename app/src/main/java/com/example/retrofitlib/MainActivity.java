package com.example.retrofitlib;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofitlib.retrofit.NetManager;
import com.example.retrofitlib.retrofit.bean.TokenBean;
import com.example.retrofitlib.retrofit.response.Result;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    private void getToken() {
        NetManager.getApi().getToken().enqueue(new Callback<Result<TokenBean>>() {
            @Override
            public void onResponse(Call<Result<TokenBean>> call, Response<Result<TokenBean>> response) {
                Log.d(TAG, "onResponse: 成功");
            }

            @Override
            public void onFailure(Call<Result<TokenBean>> call, Throwable t) {
                Log.d(TAG, "onFailure: 失败" + t.getMessage());
            }
        });
    }
}
