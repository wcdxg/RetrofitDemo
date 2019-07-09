package com.example.retrofitlib.retrofit.response;

/**
 * Created by Yuaihen.
 * on 2019/7/5
 * 服务器返回的数据格式定义类
 */
public class Result<T> {

    private int code;// 返回的code
    private T data;// 具体的数据结果
    private String message; // message 可用来返回接口的说明
    private long timestamp;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message == null ? "" : message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
