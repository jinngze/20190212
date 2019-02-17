package com.example.a20190216.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a20190216.Apis;
import com.example.a20190216.R;
import com.example.a20190216.data.bean.Good;


import com.example.a20190216.di.presneter.IPresentImpl;
import com.example.a20190216.di.view.IView;

import com.example.a20190216.ui.adapter.MyAdapter;
import com.recker.flybanner.FlyBanner;
import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements IView {

    @BindView(R.id.zxing)
    TextView zxing;
    @BindView(R.id.putin)
    EditText putin;
    @BindView(R.id.sousuo)
    ImageView sousuo;
    @BindView(R.id.qiehuan)
    ImageView qiehuan;
    @BindView(R.id.hand)
    RecyclerView hand;
    @BindView(R.id.marqueeView)
    MarqueeView marqueeView;
    @BindView(R.id.banner)
    FlyBanner banner;

    private IPresentImpl iPresent;
    private MyAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

          iPresent = new IPresentImpl(this);

        initData();
        loadData();
        zxing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ZXingActivity.class));
                finish();
            }
        });

        List<String> info = new ArrayList<>();
        info.add("1. 大家好，我是孙福生。");
        info.add("2. 欢迎大家关注我哦！");
        info.add("3. GitHub帐号：sfsheng0322");
        info.add("4. 新浪微博：孙福生微博");
        info.add("5. 个人博客：sunfusheng.com");
        info.add("6. 微信公众号：孙福生");
        marqueeView.startWithList(info);

        // 在代码里设置自己的动画
        marqueeView.startWithList(info, R.anim.anim_bottom_in, R.anim.anim_top_out);


        ArrayList<String> list = new ArrayList<>();
        list.add("http://172.17.8.100/images/small/banner/cj.png");
        list.add("http://172.17.8.100/images/small/banner/hzp.png");
        list.add("http://172.17.8.100/images/small/banner/lyq.png");
        list.add("http://172.17.8.100/images/small/banner/px.png");
        list.add("http://172.17.8.100/images/small/banner/wy.png");
        banner.setImagesUrl(list);






    }



    private void initData() {

        hand.setLayoutManager(new GridLayoutManager(this,2));
        myAdapter = new MyAdapter(this);
        hand.setAdapter(myAdapter);

    }

    private void loadData() {
        Map<String,String> map = new HashMap<>();
        map.put("keywords","笔记本");
        map.put("page","1");
        iPresent.onRequest(Apis.URL,map,Good.class);

    }

    @Override
    public void onSuccess(Object data) {

        Good good = (Good) data;
        myAdapter.setData(good.getNewslist());
    }





 @Override
    protected void onDestroy() {
        super.onDestroy();
        iPresent.onDetach();


    }

}
