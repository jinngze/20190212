package com.example.dell.a20190212.mvp.view;

public interface IView<T> {

    void showResposneData(T data);
    void showResponseFail(T data);

}
