package com.example.a20190216.di.presneter;

import com.example.a20190216.di.callback.MyCallBack;
import com.example.a20190216.di.model.IModelImpl;
import com.example.a20190216.di.view.IView;

import java.util.Map;

public class IPresentImpl  implements IPresent{
    private IView iView;
    private IModelImpl iModel;

    public IPresentImpl(IView iView) {
        this.iView = iView;
        iModel = new IModelImpl();
    }

    @Override
    public void onRequest(String url, Map<String, String> params, Class clazz) {
            iModel.postRequest(url, params, clazz, new MyCallBack() {
                @Override
                public void onSuccess(Object data) {
                    iView.onSuccess(data);
                }
            });
    }
    public void onDetach(){
        if(iModel!=null){
            iModel=null;
        }else if(iView!=null){
            iView =null;
        }
    }
}
