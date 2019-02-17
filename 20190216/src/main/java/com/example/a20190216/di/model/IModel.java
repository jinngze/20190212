package com.example.a20190216.di.model;



import com.example.a20190216.di.callback.MyCallBack;

import java.util.Map;

public interface IModel  {
    void postRequest(String url, Map<String, String> params, Class clazz, MyCallBack callBack);
}
