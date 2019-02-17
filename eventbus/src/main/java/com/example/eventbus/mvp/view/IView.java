package com.example.eventbus.mvp.view;

public interface IView<T> {

    void showResposneData(T data);
    void showResponseFail(T data);

}
