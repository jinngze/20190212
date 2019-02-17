package com.example.keyi.mvp.model;


import com.example.keyi.mvp.callback.MyCallBack;

import java.util.Map;

public interface IModel  {

  void requestData(String url,Map<String,String>params,Class clazz,MyCallBack callBack);

}
