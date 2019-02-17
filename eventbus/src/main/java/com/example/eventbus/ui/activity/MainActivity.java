package com.example.eventbus.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.eventbus.R;
import com.example.eventbus.data.Constant;
import com.example.eventbus.data.bean.Bean;
import com.example.eventbus.data.bean.Sbean;
import com.example.eventbus.di.presenter.ShowPresenter;
import com.example.eventbus.di.view.IView;
import com.example.eventbus.ui.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class MainActivity extends AppCompatActivity implements IView {

    @BindView(R.id.recycle)
    RecyclerView recycle;
    Context  context;
    private MyAdapter myAdapter;
    private ShowPresenter mPresent = new ShowPresenter(this);
    private ArrayList<Sbean.ResultsBean> mdd = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        mPresent = new ShowPresenter(this);


        initView();
        initData();
    }

    private void initData() {

        Map<String,String> map = new HashMap<>();
        map.put("mpage","1");
        mPresent.startRequest(Constant.URL_Q,map,Sbean.class);
    }

    private void initView() {


        GridLayoutManager manager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        recycle.setLayoutManager(manager);

    }

    @Override
    public void showResponseData(Object data) {

        /* Bean bean = (Bean) data;
         mdd.addAll(bean.getResults().get福利());*/
       final  Sbean sbean = (Sbean) data;
         mdd.addAll(sbean.getResults());
          myAdapter = new MyAdapter(this,mdd);
          recycle.setAdapter(myAdapter);

    }

    @Override
    public void showResponseFail(Object data) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresent.onDetach();
    }


}
