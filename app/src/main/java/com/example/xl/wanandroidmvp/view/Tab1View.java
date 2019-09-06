package com.example.xl.wanandroidmvp.view;

import com.example.xl.wanandroidmvp.base.BaseView;
import com.example.xl.wanandroidmvp.bean.ArticleBean;
import com.example.xl.wanandroidmvp.bean.BannerBean;

public interface Tab1View extends BaseView {

    void onSusses(ArticleBean articleBean);

    void onFail(String errorMsg);

    void onBannerSuccess(BannerBean bannerBean);
}
