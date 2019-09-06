package com.example.xl.wanandroidmvp.ui.adapter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.bean.SearchResultBean;
import com.example.xl.wanandroidmvp.utils.Util;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements View.OnClickListener {
    private Context mContext;
    private List<SearchResultBean.DataBean.DatasBean> data = new ArrayList<>();

    public SearchAdapter(Context context) {
        mContext = context;
    }

    public void setData(List<SearchResultBean.DataBean.DatasBean> data) {
        this.data=data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.search_item, parent, false);
        return new SearchHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SearchHolder){
            if (Build.VERSION.SDK_INT>Build.VERSION_CODES.N){
                ((SearchHolder) holder).mTvItemHomeTitle.setText(Html.fromHtml(data.get(position).getTitle(),Html.FROM_HTML_MODE_LEGACY));
            }else {
                ((SearchHolder) holder).mTvItemHomeTitle.setText(Html.fromHtml(data.get(position).getTitle()));
            }
            ((SearchHolder) holder).mTvItemHomeTime.setText(data.get(position).getNiceDate());
            ((SearchHolder) holder).mTvItemHomeTag.setText(data.get(position).getSuperChapterName()+" / "+data.get(position).getChapterName());
            if (Util.timeToDay(System.currentTimeMillis())==Util.timeToDay(data.get(position).getPublishTime())){
                ((SearchHolder) holder).mIvItemHomeNew.setVisibility(View.VISIBLE);
            }else {
                ((SearchHolder) holder).mIvItemHomeNew.setVisibility(View.GONE);
            }

            holder.itemView.setTag(position);
            holder.itemView.setOnClickListener(this);
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onClick(View v) {
        int position= (int) v.getTag();
        if (mOnItemClick!=null){
            mOnItemClick.onItem(position);
        }
    }

    static class SearchHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv_item_home_title)
        TextView mTvItemHomeTitle;
        @BindView(R.id.tv_item_home_time)
        TextView mTvItemHomeTime;
        @BindView(R.id.tv_item_home_tag)
        TextView mTvItemHomeTag;
        @BindView(R.id.iv_item_home_new)
        ImageView mIvItemHomeNew;

        SearchHolder(View view) {
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
