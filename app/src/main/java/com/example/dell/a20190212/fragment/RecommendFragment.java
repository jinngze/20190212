package com.example.dell.a20190212.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.a20190212.Apis;
import com.example.dell.a20190212.R;
import com.example.dell.a20190212.adapter.Fresco;
import com.example.dell.a20190212.bean.Bean;
import com.example.dell.a20190212.mvp.presenter.ShowPresenter;
import com.example.dell.a20190212.mvp.view.IView;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class RecommendFragment extends Fragment implements IView {
    Context context;
    @BindView(R.id.flybanner)
    FlyBanner flybanner;
    @BindView(R.id.hot)
    RecyclerView hot;
    private FlyBanner flyBanner;
    private String url = "http://www.zhaoapi.cn/home/getHome";
    Unbinder unbinder;
    private ArrayList<Bean.DataBean.TuijianBean.ListBeanX> mdd = new ArrayList<>();
    private Fresco fresco;
    private ShowPresenter mPresent = new ShowPresenter(this);


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.banner, container, false);

        flyBanner = view.findViewById(R.id.flybanner);
        ArrayList<String> list = new ArrayList<>();
        list.add("http://f.expoon.com/sub/news/2016/01/21/887844_230x162_0.jpg");
        list.add("http://attach.bbs.miui.com/forum/201303/16/173716jzszx8vbbb0z9o4k.jpg");
        list.add("http://pic28.photophoto.cn/20130929/0034034819144555_b.jpg");
        flyBanner.setImagesUrl(list);

        mPresent = new ShowPresenter(this);
        unbinder = ButterKnife.bind(this, view);
        initView();
        initData();
        return view;
    }

    private void initData() {

        Map<String, String> map = new HashMap<>();
        map.put("mpage", "1");
        mPresent.startRequest(Apis.URL_Q, map, Bean.class);
    }

    private void initView() {

        //瀑布流
        //2、*布局管理器
        //①线性   LinearLayoutManager
        //②网格   GridLayoutManager
        //③瀑布流 StaggeredGridLayoutManager
        //LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        //GridLayoutManager manager = new GridLayoutManager(context, 2,GridLayoutManager.VERTICAL,false);
        //final StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        //xRecyclerView.setLayoutManager(manager);
        GridLayoutManager manager = new GridLayoutManager(context, 2, GridLayoutManager.VERTICAL, false);
        hot.setLayoutManager(manager);
      /*  fresco = new Fresco(mdd,getActivity());
          hot.setAdapter(fresco);*/

    }


    @Override
    public void showResposneData(Object data) {

        final Bean bannerBean = (Bean) data;
        mdd.addAll(bannerBean.getData().getTuijian().getList());
        fresco = new Fresco(mdd,getActivity());
        hot.setAdapter(fresco);


    }

    @Override
    public void showResponseFail(Object data) {


    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresent.onDetach();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
