package com.example.dell.a20190212.mvp.callback;

public interface  MyCallBack<T> {

    void success(T data);
    void failed(Exception e);
}
