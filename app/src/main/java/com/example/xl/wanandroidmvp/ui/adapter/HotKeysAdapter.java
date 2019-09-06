package com.example.xl.wanandroidmvp.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.bean.HotKeysTextBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HotKeysAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private Context mContext;
    private List<HotKeysTextBean.DataBean> data = new ArrayList<>();

    public HotKeysAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<HotKeysTextBean.DataBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.hotkeys_item, viewGroup, false);
        return new HotKeysViewHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof HotKeysViewHoder){
            ((HotKeysViewHoder) holder).mTvItemHotKey.setText(data.get(position).getName());
        }
        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(this);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {
        int pos= (int) v.getTag();
        if (mOnItemClickListerer!=null){
            mOnItemClickListerer.onItem(data.get(pos).getName());
        }
    }

    static class HotKeysViewHoder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_item_hot_key)
        TextView mTvItemHotKey;

        HotKeysViewHoder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setOnItemClickListerer(OnItemClickListerer onItemClickListerer){
        this.mOnItemClickListerer=onItemClickListerer;
    }
    public OnItemClickListerer mOnItemClickListerer;
    public interface OnItemClickListerer{
        void onItem(String keys);
    }
}
