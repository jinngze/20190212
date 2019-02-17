package gsp.com.homework_threen.ui;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import gsp.com.homework_threen.R;
import gsp.com.homework_threen.data.Shoppingbean;


public class Grideadapter_two extends BaseQuickAdapter<Shoppingbean.ResultBean.RxxpBean.CommodityListBean,BaseViewHolder> {


    public Grideadapter_two(int layoutResId, @Nullable List<Shoppingbean.ResultBean.RxxpBean.CommodityListBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Shoppingbean.ResultBean.RxxpBean.CommodityListBean item) {
        //获取文字
        helper.setText(R.id.gridetext, item.getCommodityName());
        //获取图片   记得强转一下helper.getView(R.id.image)
        Glide.with(mContext).load(item.getMasterPic()).into((ImageView) helper.getView(R.id.grideimage));
    }
}
