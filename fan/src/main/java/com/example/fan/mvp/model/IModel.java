package com.example.fan.mvp.model;

import com.example.fan.mvp.callback.MyCallBack;

import java.util.Map;

public interface IModel {


      void requestData(String url,Map<String,String>params,Class clazz,MyCallBack callBack);

}
