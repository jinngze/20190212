package com.example.dell.a20190212.mvp.model;



import com.example.dell.a20190212.mvp.callback.MyCallBack;
import com.example.dell.a20190212.util.ICallBack;
import com.example.dell.a20190212.util.OkHttpUtils;

import java.util.Map;

public class ShowModel implements IModel {



    @Override
    public void requestData(String url, Map<String, String> params, Class clazz, final MyCallBack callBack) {
            OkHttpUtils.getInstance().postEnqueue(url, params, clazz, new ICallBack() {
                @Override
                public void success(Object obj) {
                    callBack.success(obj);
                }

                @Override
                public void failed(Exception e) {

                    callBack.failed(e);
                }
            });

        }
}