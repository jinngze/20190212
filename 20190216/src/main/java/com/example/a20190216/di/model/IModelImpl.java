package com.example.a20190216.di.model;

import com.example.a20190216.di.callback.MyCallBack;
import com.example.a20190216.network.RetrofitManage;

import com.google.gson.Gson;

import java.util.Map;

public class IModelImpl implements IModel {
    @Override
    public void postRequest(String url, Map<String, String> params, final Class clazz, final MyCallBack callBack) {
        RetrofitManage.getInstance().post(url,params).result(new RetrofitManage.HttpListener() {
            @Override
            public void onSuccess(String data) {
                Object o = new Gson().fromJson(data, clazz);
                callBack.onSuccess(o);
            }

            @Override
            public void onFail(String error) {
                callBack.onSuccess(error);
            }
        });
    }
}
