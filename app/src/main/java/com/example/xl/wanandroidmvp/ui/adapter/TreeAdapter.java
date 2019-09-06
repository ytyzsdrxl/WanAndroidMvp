package com.example.xl.wanandroidmvp.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.bean.TreeBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TreeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<TreeBean.DataBean> data = new ArrayList<>();

    public TreeAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<TreeBean.DataBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_tree, viewGroup, false);
        return new TreeViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        if (holder instanceof TreeViewHodler){
            ((TreeViewHodler) holder).mTvItemTree.setText(data.get(i).getName());
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class TreeViewHodler extends RecyclerView.ViewHolder{
        @BindView(R.id.tv_item_tree)
        TextView mTvItemTree;

        TreeViewHodler(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
