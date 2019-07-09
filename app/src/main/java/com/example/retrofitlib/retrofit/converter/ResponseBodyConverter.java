package com.example.retrofitlib.retrofit.converter;

import com.example.retrofitlib.retrofit.exception.MyException;
import com.example.retrofitlib.retrofit.response.Result;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;

import java.io.IOException;
import java.io.StringReader;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by Yuaihen.
 * on 2019/7/8
 * 解析服务器返回的异常
 * 通过json中的code
 */
public class ResponseBodyConverter<T> implements Converter<ResponseBody, T> {

    private final Gson gson;
    private final TypeAdapter<T> adapter;

    //定义后台返回的异常code
    private static final int SUCCESS = 0;                   // 成功
    private static final int FAILURE = -1;                  // 失败
    public static final int TOKEN_NOT_EXIST = 10086;        //token不存在
    public static final int SERVER_EXCEPTION = 502;         //服务器异常
    public static final int MAC_NOT_EXIST = 999;            //mac地址不存在，未入库


    public ResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;

    }

    @Override
    public T convert(ResponseBody value) throws IOException {
//        JsonReader jsonReader = gson.newJsonReader(value.charStream());
        String json = value.string();
        try {
            verify(json);
            //            return adapter.read(jsonReader);
            return adapter.read(gson.newJsonReader(new StringReader(json)));
        } finally {
            value.close();
        }

    }


    private void verify(String json) {
        Result result = gson.fromJson(json, Result.class);
        if (result.getCode() != SUCCESS) {
            int code = result.getCode();
            switch (code) {
                case FAILURE:
                    throw new MyException("errorCode:" + FAILURE + " 服务器返回异常~");
                case TOKEN_NOT_EXIST:
                    throw new MyException("errorCode:" + TOKEN_NOT_EXIST + " token参数不存在~");
                case SERVER_EXCEPTION:
                    throw new MyException("errorCode:" + SERVER_EXCEPTION + " 镜子后台正在维护升级中，请您稍后再试~");
                case MAC_NOT_EXIST:
                    throw new MyException("errorCode:" + MAC_NOT_EXIST + " Mac地址不存在，该设备未入库~");
                default:
                    throw new MyException("IO异常，请重试~");
            }
        }
    }

}
