package com.example.zk1lx.mvp.model;

import com.example.zk1lx.bean.SouBean;

public interface SeekModel {
        void gethome(String url,String keyword, CteanView cteanView);

        interface CteanView {
            void onSuccess(SouBean bean);
            void onFailure();
        }
}
