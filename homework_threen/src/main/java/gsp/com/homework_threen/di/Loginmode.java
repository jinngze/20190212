package gsp.com.homework_threen.di;

import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import gsp.com.homework_threen.data.Contain;
import gsp.com.homework_threen.data.Shoppingbean;


public class Loginmode implements Logincontract.Loginmodel {
    @Override
    public void cantainData(final Callback callback) {
        OkGo.<String>get(Contain.HOMEURI).execute(new StringCallback() {
            @Override
            public void onSuccess(Response<String> response) {
                //响应数据
                String responsedata = response.body().toString();
                //解析数据
                Gson gson = new Gson();
                //
                Shoppingbean shoppingbean = gson.fromJson(responsedata, Shoppingbean.class);

                //响应玩数据回调
                callback.onCallback(shoppingbean);

            }
        });
    }
}
