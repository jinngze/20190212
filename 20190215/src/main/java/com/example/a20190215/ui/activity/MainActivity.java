package com.example.a20190215.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.a20190215.R;
import com.example.a20190215.data.Bean.ApiService;
import com.example.a20190215.data.Constants;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.button)
    Button button;
    @BindView(R.id.tv_content)
    TextView tvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    /**
     * 以最基本的形式，进行Get请求
     */

    private void requestGetData() {
        //2.实例化Retrofit
        //拼接根地址
        //可以获取到根地址
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.URL_Z)
                .build();

        //3.通过Retrofit实例创建接口服务对象
        //+子地址
        ApiService service = retrofit.create(ApiService.class);
        //4.接口服务对象调用接口中的方法，获取Call对象
        Call<ResponseBody> call = service.getRequestData();
        //5.Call对象执行请求（异步、同步请求）
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {


                try {
                    ResponseBody responseBody = response.body();
                    String responseData = responseBody.string();
                    tvContent.setText(responseData);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

                String message = t.getMessage();
                tvContent.setText(message);
            }
        });

    }

    @OnClick(R.id.button)
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.button:
                requestGetData();
                break;
        }

    }
}
