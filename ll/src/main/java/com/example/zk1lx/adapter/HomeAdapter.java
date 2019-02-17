package com.example.zk1lx.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zk1lx.R;
import com.example.zk1lx.bean.SouBean;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyHolder> {
    private final List<SouBean.ResultBean> list;
    private final Context context;

    public HomeAdapter(Context context, List<SouBean.ResultBean> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = View.inflate(context, R.layout.item, null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.textView1.setText(list.get(position).getCommodityName());
        holder.textView2.setText(list.get(position).getPrice()+"");
        holder.imageview.setImageURI(list.get(position).getMasterPic());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView imageview;
        private final TextView textView1;
        private final TextView textView2;

        public MyHolder(View itemView) {
            super(itemView);
            imageview = itemView.findViewById(R.id.imageview);
            textView1 = itemView.findViewById(R.id.textview1);
            textView2 = itemView.findViewById(R.id.textview2);
        }
    }
}
