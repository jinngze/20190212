package gsp.com.homework_threen.di;

import gsp.com.homework_threen.data.Shoppingbean;


public interface Logincontract {
    //V层
    public interface Loginview {
        //回显数据
        public void shapeData(Shoppingbean shoppingbean);
    }

    //P层
    public interface Loginpresenter<Loginview> {
        //绑定服务
        public void attachview(Logincontract.Loginview loginview);

        //解绑服务
        public void detachview(Logincontract.Loginview loginview);

        //获取数据
        public void resquesData();
    }

    //M层
    public interface Loginmodel {
        //请求数据
        public void cantainData(Callback callback);

        //接口回调
        public interface Callback {
            public void onCallback(Shoppingbean shoppingbean);
        }

    }

}
