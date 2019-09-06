package com.example.xl.wanandroidmvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.base.BaseMvpActivity;
import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.bean.ChaArtBean;
import com.example.xl.wanandroidmvp.presenter.ChapterArtPresenter;
import com.example.xl.wanandroidmvp.ui.adapter.ChapterArtAdapter;
import com.example.xl.wanandroidmvp.view.ChapterArtView;
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

public class ChapterArticleActivity extends BaseMvpActivity implements ChapterArtView {

    @BindView(R.id.iv_head_back)
    ImageView mIvHeadBack;
    @BindView(R.id.tv_head_title)
    TextView mTvHeadTitle;
    @BindView(R.id.iv_head_more)
    ImageView mIvHeadMore;
    @BindView(R.id.rv_chapter_article)
    RecyclerView mRvChapterArticle;
    @BindView(R.id.srl_chapter_article)
    SmartRefreshLayout mSrlChapterArticle;

    private ChapterArtPresenter mPresenter;
    private int pageIndex=0;
    private ChapterArtAdapter mAdapter;
    private String mName;
    private String mId;
    private List<ChaArtBean.DataBean.DatasBean> dataList=new ArrayList<>();
    private int mPageNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter_article);
        ButterKnife.bind(this);
        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getData();
    }

    @Override
    protected BasePresenter createPresenter() {
        return mPresenter=new ChapterArtPresenter(this);
    }

    private void initView() {
        mName = getIntent().getStringExtra("name");
        mId = getIntent().getStringExtra("id");
        mTvHeadTitle.setText(mName);

        mSrlChapterArticle.setRefreshHeader(new ClassicsHeader(this));
        mSrlChapterArticle.setRefreshFooter(new ClassicsFooter(this));
        mRvChapterArticle.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new ChapterArtAdapter(this);
        mRvChapterArticle.setAdapter(mAdapter);

        initListener();
    }

    private void initListener() {
        mSrlChapterArticle.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(@NonNull RefreshLayout refreshLayout) {
                pageIndex=0;
                dataList.clear();
                getData();
            }
        });

        mSrlChapterArticle.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(@NonNull RefreshLayout refreshLayout) {
                pageIndex++;
                if (pageIndex<mPageNum){
                    getData();
                }else {
                    toastShort("没有更多数据");
                    mSrlChapterArticle.finishLoadMore();
                }
            }
        });

        mAdapter.setOnItemClick(new ChapterArtAdapter.OnItemClick() {
            @Override
            public void onItem(int position) {
                ChaArtBean.DataBean.DatasBean datasBean = dataList.get(position);
                Intent intent = new Intent(ChapterArticleActivity.this, WebViewActivity.class);
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

    private void getData() {
        showLoadingDialog(false);
        mPresenter.getChapterArt(mId,pageIndex);
    }

    @OnClick(R.id.iv_head_back)
    public void onClick() {
        finish();
    }

    @Override
    public void onSusses(ChaArtBean chaArtBean) {
        mSrlChapterArticle.finishRefresh();
        mSrlChapterArticle.finishLoadMore();
        hideLoadingDialog();
        if (chaArtBean!=null){
            mPageNum = chaArtBean.getData().getPageCount();
            dataList.addAll(chaArtBean.getData().getDatas());
            mAdapter.setData(dataList);
        }
    }

    @Override
    public void onFail(String errorMsg) {
        mSrlChapterArticle.finishRefresh();
        mSrlChapterArticle.finishLoadMore();
        hideLoadingDialog();
        toastShort(errorMsg);
    }
}
