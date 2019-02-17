package com.example.dell.a20190212.mvp.presenter;

import java.util.Map;

public interface IPresenter {

    void startRequest(String url, Map<String, String> params, Class clazz);
}
