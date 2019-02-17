package com.example.dell.a20190212.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dell.a20190212.R;
import com.example.dell.a20190212.bean.Bean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Fresco extends RecyclerView.Adapter<Fresco.SubViewHolder> {

    Context context;
    private ArrayList<Bean.DataBean.TuijianBean.ListBeanX> beanList;


    public Fresco(ArrayList<Bean.DataBean.TuijianBean.ListBeanX> datas, Context context) {
        this.beanList = datas;
        this.context = context;
    }



    @NonNull
    @Override
    public SubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = View.inflate(context, R.layout.mytest, null);
        SubViewHolder subViewHolder = new SubViewHolder(view);
        return subViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SubViewHolder subViewHolder, int i) {

        subViewHolder.MyName.setText(beanList.get(i).getTitle());
        subViewHolder.MyPrice.setText("¥" + beanList.get(i).getPrice());
        String url = beanList.get(i).getImages();
        if (!url.isEmpty()) {
            String[] split = url.split("\\|");
            if (split != null) {
                for (int j = 0; j < split.length; j++) {
                    String replace = split[j].replace("https", "http");
                    Uri parse = Uri.parse(replace);
                    subViewHolder.MyImage.setImageURI(parse);
                }
            } else {
                String replace = url.replace("https", "http");
                Uri parse = Uri.parse(replace);
                subViewHolder.MyImage.setImageURI(parse);
            }
        }
    }
    @Override
    public int getItemCount() {
        return beanList.size();
    }

    class SubViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.MyImage)
        SimpleDraweeView MyImage;
        @BindView(R.id.MyName)
        TextView MyName;
        @BindView(R.id.MyPrice)
        TextView MyPrice;

        /* @BindView(R.id.iv)
         SimpleDraweeView iv;
         @BindView(R.id.tv)
         TextView tv;*/
        public SubViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}
