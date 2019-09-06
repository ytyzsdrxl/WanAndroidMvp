package com.example.xl.wanandroidmvp.model;

import com.example.xl.wanandroidmvp.base.BaseModel;
import com.example.xl.wanandroidmvp.bean.ArticleBean;
import com.example.xl.wanandroidmvp.bean.BannerBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class Tab1Model implements BaseModel {

    public Observable<ArticleBean> getArt(int index){
        return baseApi.getArticleList(index);
    }

    public Observable<BannerBean> getBanner(){
        return baseApi.getBanner();
    }

}
