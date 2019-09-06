package com.example.xl.wanandroidmvp.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.base.BaseMvpActivity;
import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.views.CollectPopupWindow;
import com.example.xl.wanandroidmvp.views.ProgressWebView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class WebViewActivity extends BaseMvpActivity {

    @BindView(R.id.iv_head_back)
    ImageView mIvHeadBack;
    @BindView(R.id.tv_head_title)
    TextView mTvHeadTitle;
    @BindView(R.id.iv_head_more)
    ImageView mIvHeadMore;
    @BindView(R.id.webview)
    ProgressWebView mWebView;
    private String mUrl;
    private boolean mIsCollected;
    private int mArticleId;
    private String mCollectTime;
    private String mPublishTime;
    private String mAuthor;
    private String mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        mUrl = intent.getStringExtra("url");
        mIsCollected = intent.getBooleanExtra("isCollected",false);
        mArticleId = intent.getIntExtra("articleId",-1);
        mCollectTime = intent.getStringExtra("collectTime");
        mPublishTime = intent.getStringExtra("publishTime");
        mAuthor = intent.getStringExtra("author");
        mTitle = intent.getStringExtra("title");

        initView();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    private void initView() {
        mTvHeadTitle.setText(Html.fromHtml(mTitle));
        mIvHeadMore.setVisibility(View.VISIBLE);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(mUrl);
    }

    @OnClick({R.id.iv_head_back,R.id.iv_head_more})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_head_more:
                showBottomWindow(view);
                break;
            case R.id.iv_head_back:
                finish();
                break;
        }
    }

    private void showBottomWindow(View view) {
        CollectPopupWindow collectPopupWindow=new CollectPopupWindow(WebViewActivity.this,mMyOnClickListener);
        collectPopupWindow.setVisable(mIsCollected);
        collectPopupWindow.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        collectPopupWindow.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        collectPopupWindow.showAtLocation(WebViewActivity.this.findViewById(R.id.webview), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);

        collectPopupWindow.getCancleText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                collectPopupWindow.dismiss();
            }
        });

        collectPopupWindow.getCollectOfflineText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                离线收藏
                mIsCollected = !mIsCollected;
                collectPopupWindow.dismiss();
            }
        });

        collectPopupWindow.getCollectText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                网络收藏
                mIsCollected = !mIsCollected;
                collectPopupWindow.dismiss();
            }
        });

        collectPopupWindow.getUnCollectText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                取消收藏
                mIsCollected = !mIsCollected;
                collectPopupWindow.dismiss();
            }
        });
    }

    public interface MyOnClickListener extends View.OnClickListener{

    }
    public MyOnClickListener mMyOnClickListener;

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()){
            mWebView.goBack();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onResume() {
        if(mWebView != null){
            mWebView.onResume();
        }
        super.onResume();
    }

    @Override
    protected void onPause() {
        if(mWebView!=null){
            mWebView.pauseTimers();
            mWebView.onPause();
        }
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        if(mWebView != null){
            mWebView.stopLoading();
            mWebView.removeAllViews();
            mWebView.setWebViewClient(null);
            mWebView.setWebChromeClient(null);
            unregisterForContextMenu(mWebView);
            mWebView.destroy();
        }
        super.onDestroy();
    }
}
