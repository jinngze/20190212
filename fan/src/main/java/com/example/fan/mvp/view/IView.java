package com.example.fan.mvp.view;

public interface IView<T> {

    void showResponseData(T data);
    void showResponseFail(T data);
}
