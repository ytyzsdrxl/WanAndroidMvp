package com.example.xl.wanandroidmvp.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;

public class ProgressWebView extends WebView{

    private ProgressBar progressBar;
    private Context context;
    public ProgressWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        progressBar = new ProgressBar(context,null,android.R.attr.progressBarStyleHorizontal);
        progressBar.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,3));//设置宽高属性
        addView(progressBar);
        //设置内部加载器
        setWebChromeClient(new MyWebChromeClient(context,progressBar));
        setWebViewClient(new MyWebViewClient());
    }

}
