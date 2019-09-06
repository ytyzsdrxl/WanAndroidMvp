package com.example.xl.wanandroidmvp.presenter;

import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.bean.SearchResultBean;
import com.example.xl.wanandroidmvp.model.SearchResultModel;
import com.example.xl.wanandroidmvp.network.DataObserver;
import com.example.xl.wanandroidmvp.network.NetException;
import com.example.xl.wanandroidmvp.network.RxThreadChange;
import com.example.xl.wanandroidmvp.view.SearchResultView;


public class SearchResultPresenter extends BasePresenter<SearchResultView,SearchResultModel> {

    public SearchResultPresenter(SearchResultView view) {
        super(view, new SearchResultModel());
    }

    public void searchByKey(int index,String key){
        mModel.searchByKey(index,key).compose(RxThreadChange.io2main(getView())).subscribe(new DataObserver<SearchResultBean>() {
            @Override
            public void success(SearchResultBean searchResultBean) {
                getView().onSusses(searchResultBean);
            }

            @Override
            public void error(NetException.ResponseException e) {
                getView().onFail(e.toString());
            }
        });
    }
}
