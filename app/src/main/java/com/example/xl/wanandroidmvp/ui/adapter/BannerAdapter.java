package com.example.xl.wanandroidmvp.ui.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.bean.BannerBean;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.adapter.LoopPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class BannerAdapter extends LoopPagerAdapter {

    private List<BannerBean.DataBean> data=new ArrayList<>();
    private Context mContext;

    public BannerAdapter(Context context,RollPagerView viewPager) {
        super(viewPager);
        this.mContext=context;
    }

    public void setData(List<BannerBean.DataBean> data){
        this.data=data;
        notifyDataSetChanged();
    }

    @Override
    public View getView(ViewGroup container, int position) {
        ImageView imageView=new ImageView(container.getContext());
        Glide.with(mContext).load(data.get(position).getImagePath()).into(imageView);
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        return imageView;
    }

    @Override
    public int getRealCount() {
        return data.size();
    }
}
