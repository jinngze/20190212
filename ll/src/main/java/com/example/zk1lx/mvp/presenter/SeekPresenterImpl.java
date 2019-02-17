package com.example.zk1lx.mvp.presenter;

import com.example.zk1lx.Api.ApiService;
import com.example.zk1lx.bean.SouBean;
import com.example.zk1lx.fragment.HomeFragment;
import com.example.zk1lx.mvp.model.SeekModel;
import com.example.zk1lx.mvp.model.SeekModelImpl;

public class SeekPresenterImpl implements SeekPresenter {

    HomeFragment mfrag;
    SeekModelImpl seekModel;

    public SeekPresenterImpl(HomeFragment mfrag) {
        this.mfrag = mfrag;
        seekModel = new SeekModelImpl();
    }


    @Override
    public void getseekdata(String keyword) {
        seekModel.gethome(ApiService.HOME_URL, keyword, new SeekModel.CteanView() {
            @Override
            public void onSuccess(SouBean bean) {
                mfrag.getPreData(bean);
            }

            @Override
            public void onFailure() {

            }
        });
    }
}
