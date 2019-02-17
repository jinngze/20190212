package com.example.a20190216.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a20190216.R;
import com.example.a20190216.data.bean.Good;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.SubViewHolder> {


    private List<Good.NewslistBean> list;
    private Context context;

    public MyAdapter( Context context) {
        this.context = context;
        list = new ArrayList<>();
    }

    public void setData(List<Good.NewslistBean> data) {
        this.list = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = View.inflate(context, R.layout.item_one_layout, null);
        SubViewHolder subViewHolder = new SubViewHolder(view);
        return subViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SubViewHolder subViewHolder, int i) {

        subViewHolder.tvOne.setText(list.get(i).getTitle());
        String url = list.get(i).getPicUrl();
        Uri parse = Uri.parse(url);
        subViewHolder.imgOne.setImageURI(parse);
      /*  if (!url.isEmpty()) {
            String[] split = url.split("\\|");
            if (split != null) {
                for (int j = 0; j < split.length; j++) {
                    String replace = split[j].replace("https", "http");
                    Uri parse = Uri.parse(replace);
                    subViewHolder.imgOne.setImageURI(parse);
                }
            } else {
                String replace = url.replace("https", "http");
                Uri parse = Uri.parse(replace);
                subViewHolder.imgOne.setImageURI(parse);
            }
        }*/

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class SubViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.img_one)
        SimpleDraweeView imgOne;
        @BindView(R.id.tv_one)
        TextView tvOne;
        public SubViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);
        }
    }
}
