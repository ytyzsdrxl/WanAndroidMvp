package com.example.xl.wanandroidmvp.presenter;

import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.bean.HotKeysBean;
import com.example.xl.wanandroidmvp.model.SearchModel;
import com.example.xl.wanandroidmvp.network.DataObserver;
import com.example.xl.wanandroidmvp.network.NetException;
import com.example.xl.wanandroidmvp.network.RxThreadChange;
import com.example.xl.wanandroidmvp.view.SearchView;



public class SearchPresenter extends BasePresenter<SearchView,SearchModel> {

    public SearchPresenter(SearchView view) {
        super(view, new SearchModel());
    }

    public void getHot(){
        mModel.getHot().compose(RxThreadChange.io2main(getView())).subscribe(new DataObserver<HotKeysBean>() {
            @Override
            public void success(HotKeysBean hotKeysBean) {
               getView().onSusses(hotKeysBean);
            }

            @Override
            public void error(NetException.ResponseException e) {
                getView().onFail(e.toString());
            }
        });
    }
}
