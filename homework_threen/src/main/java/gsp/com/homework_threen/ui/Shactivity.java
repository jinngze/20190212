package gsp.com.homework_threen.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import gsp.com.homework_threen.R;
import gsp.com.homework_threen.data.Shoppingbean;
import gsp.com.homework_threen.di.Logincontract;
import gsp.com.homework_threen.di.Loginpresenter;


public class Shactivity extends Fragment implements Logincontract.Loginview {
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    Unbinder unbinder;

    private Loginpresenter loginpresenter;
    private Grideadapter grideadapter;
    private List<Shoppingbean.ResultBean.PzshBean.CommodityListBeanX> pzsh;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.sh, null);
        unbinder = ButterKnife.bind(this, view);

        loginpresenter = new Loginpresenter();
        loginpresenter.attachview(this);
        //最后一定要调用resquesData
        loginpresenter.resquesData();

        recyclerview.setLayoutManager(new LinearLayoutManager(getActivity()));
        grideadapter = new Grideadapter(R.layout.sh_text, pzsh);
        //给组件id
        recyclerview.setAdapter(grideadapter);

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void shapeData(Shoppingbean shoppingbean) {
        //记得转下型吧list转成Arraylist
        //数据源
        pzsh = shoppingbean.getResult().getPzsh().get(0).getCommodityList();
        Toast.makeText(getActivity(), "pzsh:" + pzsh, Toast.LENGTH_SHORT).show();
        grideadapter.notifyDataSetChanged();
        ArrayList<Shoppingbean.ResultBean.PzshBean.CommodityListBeanX> data = (ArrayList<Shoppingbean.ResultBean.PzshBean.CommodityListBeanX>) shoppingbean.getResult().getPzsh().get(0).getCommodityList();
        //波浪型的布局需要设置RecyclerView   其他类型的不需要设置了
        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerview.setLayoutManager(manager);
        //设置适配器
        Grideadapter grideadapter = new Grideadapter(R.layout.sh_text, data);

        recyclerview.setAdapter(grideadapter);
    }
}
