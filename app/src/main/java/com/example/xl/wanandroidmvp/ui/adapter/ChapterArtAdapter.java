package com.example.xl.wanandroidmvp.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.bean.ChaArtBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChapterArtAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private Context mContext;
    private List<ChaArtBean.DataBean.DatasBean> data = new ArrayList<>();

    public ChapterArtAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<ChaArtBean.DataBean.DatasBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.chaart_item, viewGroup, false);
        return new ChaArtHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ChaArtHolder){
            ((ChaArtHolder) holder).mTvItemChapterArticleTitle.setText(data.get(position).getTitle());
            ((ChaArtHolder) holder).mTvItemChapterArticleAuthor.setText(data.get(position).getSuperChapterName()+":"+data.get(position).getChapterName());
            ((ChaArtHolder) holder).mTvItemChapterArticleTime.setText(data.get(position).getNiceDate());
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
        if (mOnItemClick!=null){
            mOnItemClick.onItem(pos);
        }
    }

    static class ChaArtHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_item_chapter_article_title)
        TextView mTvItemChapterArticleTitle;
        @BindView(R.id.tv_item_chapter_article_time)
        TextView mTvItemChapterArticleTime;
        @BindView(R.id.tv_item_chapter_article_author)
        TextView mTvItemChapterArticleAuthor;
        @BindView(R.id.iv_item_chapter_article)
        ImageView mIvItemChapterArticle;

        ChaArtHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

    public void setOnItemClick(OnItemClick onItemClick){
        this.mOnItemClick=onItemClick;
    }
    public OnItemClick mOnItemClick;
    public interface OnItemClick{
        void onItem(int position);
    }
}
