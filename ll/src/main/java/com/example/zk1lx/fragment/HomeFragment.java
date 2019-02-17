package com.example.zk1lx.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zk1lx.R;
import com.example.zk1lx.adapter.HomeAdapter;
import com.example.zk1lx.bean.SouBean;
import com.example.zk1lx.mvp.presenter.SeekPresenterImpl;
import com.example.zk1lx.mvp.view.MyView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class HomeFragment extends Fragment implements MyView {
    @BindView(R.id.left)
    ImageView left;
    @BindView(R.id.shuru)
    EditText shuru;
    @BindView(R.id.sousuo)
    TextView sousuo;
    @BindView(R.id.xrecyview)
    XRecyclerView xrecyview;
    Unbinder unbinder;
    private SeekPresenterImpl seekPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefrag, container, false);
        unbinder = ButterKnife.bind(this, view);

        xrecyview.setLayoutManager(new GridLayoutManager(getActivity(),2));
        seekPresenter = new SeekPresenterImpl(this);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.left, R.id.shuru, R.id.sousuo})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.left:
                break;
            case R.id.shuru:
                
                break;
            case R.id.sousuo:
                String yang = shuru.getText().toString();
                seekPresenter.getseekdata(yang);
                break;
        }
    }

    @Override
    public void getPreData(SouBean myBean) {
        List<SouBean.ResultBean> list = myBean.getResult();
        HomeAdapter homeAdapter = new HomeAdapter(getActivity(),list);
        xrecyview.setAdapter(homeAdapter);
    }
}
