package com.example.fan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

@Doc
@DocLayout(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv_content)
    TextView tv_content;
    @BindView(R.id.btn_download)
    Button btn_download;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        //原始ButterKnife
        //Butterknife.bind(this);
        //模仿版ButterKnife
        DocButterKnife.bind(this);
        //使用模仿版ButterKnife
        tv_content.setText("Hello 6666");
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "下载中...", Toast.LENGTH_SHORT).show();
            }
        });
        //获取注解中的信息
        getAnnotionValue();
    }


    //获取注解中的信息
    private void getAnnotionValue() {
        Class<? extends MainActivity> clazz = this.getClass();
        //提取某一个具体的注解
        Doc annotation = clazz.getAnnotation(Doc.class);
        //Toast显示该注解
        Toast.makeText(this, "我的年龄:" + annotation.value(), Toast.LENGTH_SHORT).show();
    }


}
