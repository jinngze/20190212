package com.example.eventbus.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.eventbus.R;
import com.example.eventbus.data.bean.Bean;
import com.example.eventbus.data.bean.Sbean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.SubViewHolder> {

    Context context;
    private ArrayList<Sbean.ResultsBean> beanList;

   public MyAdapter(Context context, ArrayList<Sbean.ResultsBean> datas) {
        this.context = context;
        this.beanList = datas;
    }



    @NonNull
    @Override
    public SubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = View.inflate(context, R.layout.item, null);
        SubViewHolder subViewHolder = new SubViewHolder(view);
        return subViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SubViewHolder subViewHolder, int i) {

             subViewHolder.MyName.setText(beanList.get(i).getDesc());
             subViewHolder.MyPrice.setText(beanList.get(i).getType());

     /*  String url = String.valueOf(beanList.get(i).getImages());*/
        String url = beanList.get(i).getUrl();
         /* Uri parse = Uri.parse(url);
          subViewHolder.MyImage.setImageURI(parse);*/
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
        public SubViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
