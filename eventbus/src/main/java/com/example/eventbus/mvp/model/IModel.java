package com.example.eventbus.mvp.model;




import com.example.dell.a20190212.mvp.callback.MyCallBack;

import java.util.Map;

public interface IModel  {

  void requestData(String url, Map<String, String> params, Class clazz, MyCallBack callBack);

}
