package com.example.xl.wanandroidmvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.base.BaseMvpActivity;
import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.bean.SearchResultBean;
import com.example.xl.wanandroidmvp.presenter.SearchResultPresenter;
import com.example.xl.wanandroidmvp.ui.adapter.SearchAdapter;
import com.example.xl.wanandroidmvp.view.SearchResultView;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.footer.ClassicsFooter;
import com.scwang.smartrefresh.layout.header.ClassicsHeader;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SearchResultActivity extends BaseMvpActivity implements SearchResultView {

    @BindView(R.id.iv_head_back)
    ImageView mIvHeadBack;
    @BindView(R.id.tv_head_title)
    TextView mTvHeadTitle;
    @BindView(R.id.iv_head_more)
    ImageView mIvHeadMore;
    @BindView(R.id.rv_search_result)
    RecyclerView mRvSearchResult;
    @BindView(R.id.srl_search_result)
    SmartRefreshLayout mSrlSearchResult;

    private SearchResultPresenter mPresenter;
    private int index = 0;
    private String mKey;
    private SearchAdapter mAdapter;
    private List<SearchResultBean.DataBean.DatasBean> mDatas = new ArrayList<>();
    private int mPageNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        ButterKnife.bind(this);
        initView();
        initListener();
    }

    private void initListener() {
        mSrlSearchResult.setRefreshHeader(new ClassicsHeader(this));
        mSrlSearchResult.setRefreshFooter(new ClassicsFooter(this));
        mSrlSearchResult.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                index = 0;
                mDatas.clear();
                getData();
            }
        });
        mSrlSearchResult.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                index++;
                if (index<mPageNum){
                    getData();
                }else {
                    toastShort("没有更多数据");
                    mSrlSearchResult.finishLoadMore();
                }
            }
        });
    }

    private void getData() {
        showLoadingDialog(false);
        mPresenter.searchByKey(index, mKey);
    }

    @Override
    protected BasePresenter createPresenter() {
        return mPresenter = new SearchResultPresenter(this);
    }

    private void initView() {
        mKey = getIntent().getStringExtra("key");
        mTvHeadTitle.setText(mKey);
        mRvSearchResult.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new SearchAdapter(this);
        mRvSearchResult.setAdapter(mAdapter);

        getData();

        mAdapter.setOnItemClick(new SearchAdapter.OnItemClick() {
            @Override
            public void onItem(int position) {
                SearchResultBean.DataBean.DatasBean datasBean = mDatas.get(position);
                Intent intent = new Intent(SearchResultActivity.this, WebViewActivity.class);
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

    @OnClick(R.id.iv_head_back)
    public void onClick() {
        finish();
    }

    @Override
    public void onSusses(SearchResultBean resultBean) {
        mSrlSearchResult.finishRefresh();
        mSrlSearchResult.finishLoadMore();
        hideLoadingDialog();
        if (resultBean != null) {
            mPageNum = resultBean.getData().getPageCount();
            mDatas.addAll(resultBean.getData().getDatas());
            mAdapter.setData(mDatas);
        }
    }

    @Override
    public void onFail(String errorMsg) {
        mSrlSearchResult.finishRefresh();
        mSrlSearchResult.finishLoadMore();
        hideLoadingDialog();
        toastShort(errorMsg);
    }
}
