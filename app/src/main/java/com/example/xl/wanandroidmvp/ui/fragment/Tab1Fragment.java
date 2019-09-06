package com.example.xl.wanandroidmvp.ui.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.base.BaseMvpFragment;
import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.bean.ArticleBean;
import com.example.xl.wanandroidmvp.bean.BannerBean;
import com.example.xl.wanandroidmvp.bean.SearchResultBean;
import com.example.xl.wanandroidmvp.presenter.Tab1Presenter;
import com.example.xl.wanandroidmvp.ui.activity.SearchResultActivity;
import com.example.xl.wanandroidmvp.ui.activity.WebViewActivity;
import com.example.xl.wanandroidmvp.ui.adapter.ArticleAdapter;
import com.example.xl.wanandroidmvp.ui.adapter.BannerAdapter;
import com.example.xl.wanandroidmvp.view.Tab1View;
import com.jude.rollviewpager.OnItemClickListener;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.IconHintView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author xulei
 * @date 2019/7/19
 */
public class Tab1Fragment extends BaseMvpFragment implements Tab1View {


    @BindView(R.id.banner_id)
    RollPagerView mBannerId;
    @BindView(R.id.rv_home)
    RecyclerView mRvHome;
    Unbinder unbinder;
    private BannerAdapter mBannerAdapter;
    private Tab1Presenter mPresenter;
    private List<ArticleBean.DataBean.DatasBean> mDataBeanList=new ArrayList<>();
    private ArticleAdapter mArticleAdapter;

    public Tab1Fragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        unbinder = ButterKnife.bind(this, view);
        mRvHome.setLayoutManager(new LinearLayoutManager(getContext()));
        mArticleAdapter = new ArticleAdapter(getContext());
        mRvHome.setAdapter(mArticleAdapter);
        initBanner();
        initListener();
        return view;
    }

    private void initListener() {
        mArticleAdapter.setOnItemClickListener(new ArticleAdapter.OnItemClickListener() {
            @Override
            public void onItem(int position) {
                ArticleBean.DataBean.DatasBean datasBean = mDataBeanList.get(position);
                Intent intent = new Intent(Tab1Fragment.this.getActivity(), WebViewActivity.class);
                intent.putExtra("url",datasBean.getLink());
                intent.putExtra("isCollected", datasBean.isCollect());
                intent.putExtra("articleId", datasBean.getId());
                intent.putExtra("collectTime", datasBean.getNiceDate());
                intent.putExtra("publishTime", datasBean.getPublishTime());
                intent.putExtra("author", datasBean.getAuthor());
                intent.putExtra("title", datasBean.getTitle());
                startActivity(intent);
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.getBanner();
        mPresenter.getArticleList(0);
    }

    private void initBanner() {
        mBannerId.setPlayDelay(5000);
        mBannerId.setHintView(new IconHintView(getContext(),R.drawable.banner_selected_point,R.drawable.banner_nomal_point,40));
        mBannerAdapter = new BannerAdapter(getContext(),mBannerId);
        mBannerId.setAdapter(mBannerAdapter);
        mBannerId.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), "点击的位置"+position, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected BasePresenter createPresenter() {
        return mPresenter=new Tab1Presenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onBannerSuccess(BannerBean bannerBean) {
        if (bannerBean!=null){
            mBannerAdapter.setData(bannerBean.getData());
        }
    }

    @Override
    public void onSusses(ArticleBean articleBean) {
        if (articleBean!=null){
            mDataBeanList.addAll(articleBean.getData().getDatas());
            mArticleAdapter.setData(mDataBeanList);
        }
    }

    @Override
    public void onFail(String errorMsg) {

    }
}
