package com.example.fan.mvp.presenter;

import java.util.Map;

public interface IPresenter {

    void  startRequest(String url, Map<String,String>params,Class clazz);
}
