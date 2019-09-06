package com.example.xl.wanandroidmvp.presenter;

import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.bean.TreeBean;
import com.example.xl.wanandroidmvp.model.Tab3Model;
import com.example.xl.wanandroidmvp.network.DataObserver;
import com.example.xl.wanandroidmvp.network.NetException;
import com.example.xl.wanandroidmvp.network.RxThreadChange;
import com.example.xl.wanandroidmvp.view.Tab3View;

import java.io.IOException;

import okhttp3.ResponseBody;

public class Tab3Presenter extends BasePresenter<Tab3View,Tab3Model> {

    public Tab3Presenter(Tab3View view) {
        super(view, new Tab3Model());
    }

    public void getTree(){
        mModel.getTree().compose(RxThreadChange.io2main(getView())).subscribe(new DataObserver<TreeBean>() {
            @Override
            public void success(TreeBean treeBean) {
                getView().onSusses(treeBean);
            }

            @Override
            public void error(NetException.ResponseException e) {
                getView().onFail(e.toString());
            }
        });
    }
}
