package com.example.xl.wanandroidmvp.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.bean.ArticleBean;
import com.example.xl.wanandroidmvp.utils.Util;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ArticleAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {

    private Context mContext;
    private List<ArticleBean.DataBean.DatasBean> data = new ArrayList<>();

    public ArticleAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<ArticleBean.DataBean.DatasBean> data) {
        this.data.clear();
        this.data.addAll(data);
        notifyDataSetChanged();
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.article_item, viewGroup, false);
        return new ArticleHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        if (viewHolder instanceof ArticleHolder){
            ((ArticleHolder) viewHolder).mTvItemHomeTitle.setText(data.get(position).getTitle());
            ((ArticleHolder) viewHolder).mTvItemHomeTitle.setTextColor(ContextCompat.getColor(mContext,R.color.black));
            ((ArticleHolder) viewHolder).mTvItemHomeTime.setText(data.get(position).getNiceDate());
            ((ArticleHolder) viewHolder).mTvItemHomeTag.setText(data.get(position).getAuthor());
            if (Util.timeToDay(System.currentTimeMillis())==Util.timeToDay(data.get(position).getPublishTime())){
                ((ArticleHolder) viewHolder).mIvItemHomeNew.setVisibility(View.VISIBLE);
            }else {
                ((ArticleHolder) viewHolder).mIvItemHomeNew.setVisibility(View.GONE);
            }

            viewHolder.itemView.setTag(position);
            viewHolder.itemView.setOnClickListener(this);

        }
    }

    @Override
    public int getItemCount() {
        return data.size()>0?data.size():0;
    }

    @Override
    public void onClick(View v) {
        int position= (int) v.getTag();
        if (mOnItemClickListener!=null){
            mOnItemClickListener.onItem(position);
        }
    }

    static class ArticleHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_item_home_title)
        TextView mTvItemHomeTitle;
        @BindView(R.id.tv_item_home_time)
        TextView mTvItemHomeTime;
        @BindView(R.id.tv_item_home_tag)
        TextView mTvItemHomeTag;
        @BindView(R.id.iv_item_home_new)
        ImageView mIvItemHomeNew;

        ArticleHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.mOnItemClickListener=onItemClickListener;
    }
    public OnItemClickListener mOnItemClickListener;
    public interface OnItemClickListener{
        void onItem(int position);
    }
}
