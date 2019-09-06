package com.example.xl.wanandroidmvp.views;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.xl.wanandroidmvp.R;

import butterknife.BindView;

public class CollectPopupWindow extends PopupWindow {

    TextView mTvItemPopCancel;
    TextView mTvItemPopCollect;
    View mViewItemPop;
    TextView mTvItemPopCollectOffline;
    TextView mTvItemPopUncollect;

    public CollectPopupWindow(Context context, View.OnClickListener onClickListener) {
        super(context);
        View view = LayoutInflater.from(context).inflate(R.layout.item_dialog, null);
        initView(view);
        this.setContentView(view);
    }

    private void initView(View view) {
        mTvItemPopCancel=view.findViewById(R.id.tv_item_pop_cancel);
        mTvItemPopCollect=view.findViewById(R.id.tv_item_pop_collect);
        mViewItemPop=view.findViewById(R.id.view_item_pop);
        mTvItemPopCollectOffline=view.findViewById(R.id.tv_item_pop_collect_offline);
        mTvItemPopUncollect=view.findViewById(R.id.tv_item_pop_uncollect);
    }

    public TextView getCollectOfflineText(){
        return mTvItemPopCollectOffline;
    }

    public TextView getCollectText(){
        return mTvItemPopCollect;
    }

    public TextView getUnCollectText(){
        return mTvItemPopUncollect;
    }

    public TextView getCancleText(){
        return mTvItemPopCancel;
    }


    public void setVisable(boolean isCollect) {
        if (isCollect) {
            mTvItemPopCollect.setVisibility(View.GONE);
            mTvItemPopCollectOffline.setVisibility(View.GONE);
            mTvItemPopUncollect.setVisibility(View.VISIBLE);
        } else {
            mTvItemPopUncollect.setVisibility(View.VISIBLE);
            mTvItemPopCollectOffline.setVisibility(View.VISIBLE);
            mTvItemPopUncollect.setVisibility(View.GONE);
        }
    }

}
