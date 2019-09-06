package com.example.xl.wanandroidmvp.presenter;

import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.bean.ArticleBean;
import com.example.xl.wanandroidmvp.bean.BannerBean;
import com.example.xl.wanandroidmvp.model.Tab1Model;
import com.example.xl.wanandroidmvp.network.DataObserver;
import com.example.xl.wanandroidmvp.network.NetException;
import com.example.xl.wanandroidmvp.network.RxThreadChange;
import com.example.xl.wanandroidmvp.view.Tab1View;

import java.io.IOException;

import okhttp3.ResponseBody;

public class Tab1Presenter extends BasePresenter<Tab1View,Tab1Model> {

    public Tab1Presenter(Tab1View view) {
        super(view, new Tab1Model());
    }

    public void getArticleList(int index){
        mModel.getArt(index).compose(RxThreadChange.io2main(getView())).subscribe(new DataObserver<ArticleBean>() {
            @Override
            public void success(ArticleBean articleBean) {
               getView().onSusses(articleBean);
            }

            @Override
            public void error(NetException.ResponseException e) {
                getView().onFail(e.toString());
            }
        });
    }

    public void getBanner(){
        mModel.getBanner().compose(RxThreadChange.io2main(getView())).subscribe(new DataObserver<BannerBean>() {
            @Override
            public void success(BannerBean bannerBean) {
               getView().onBannerSuccess(bannerBean);
            }

            @Override
            public void error(NetException.ResponseException e) {
                getView().onFail(e.toString());
            }
        });
    }

}
