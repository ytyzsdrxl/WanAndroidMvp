package com.example.xl.wanandroidmvp.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.bean.WXCBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WXCAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private Context mContext;
    private List<WXCBean.DataBean> data = new ArrayList<>();

    public WXCAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<WXCBean.DataBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.wx_item, viewGroup, false);
        return new WXCHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof WXCHolder){
            ((WXCHolder) holder).mTvItemChapter.setText(data.get(position).getName());
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
        if (mClickItemListener!=null){
            mClickItemListener.onIiem(data.get(pos).getName(), String.valueOf(data.get(pos).getId()));
        }
    }

    static class WXCHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_item_chapter)
        TextView mTvItemChapter;

        WXCHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setClickItemListener(ClickItemListener clickItemListener){
        this.mClickItemListener=clickItemListener;
    }

    public ClickItemListener mClickItemListener;
    public interface ClickItemListener{
        void onIiem(String name,String id);
    }
}
