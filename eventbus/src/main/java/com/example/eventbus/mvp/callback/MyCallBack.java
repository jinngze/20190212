package com.example.eventbus.mvp.callback;

public interface  MyCallBack<T> {

    void success(T data);
    void failed(Exception e);
}
