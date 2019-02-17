package com.example.keyi.mvp.callback;

public interface  MyCallBack<T> {

    void success(T data);
    void failed(Exception e);
}
