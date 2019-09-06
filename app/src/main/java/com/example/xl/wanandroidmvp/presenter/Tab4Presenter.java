package com.example.xl.wanandroidmvp.presenter;

import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.bean.WXCBean;
import com.example.xl.wanandroidmvp.model.Tab4Model;
import com.example.xl.wanandroidmvp.network.DataObserver;
import com.example.xl.wanandroidmvp.network.NetException;
import com.example.xl.wanandroidmvp.network.RxThreadChange;
import com.example.xl.wanandroidmvp.view.Tab4View;

public class Tab4Presenter extends BasePresenter<Tab4View,Tab4Model> {
    public Tab4Presenter(Tab4View view) {
        super(view, new Tab4Model());
    }
    public void getData(){
        mModel.getWXC().compose(RxThreadChange.io2main(getView())).subscribe(new DataObserver<WXCBean>() {
            @Override
            public void success(WXCBean wxcBean) {
                getView().onSusses(wxcBean);
            }

            @Override
            public void error(NetException.ResponseException e) {
                getView().onFail(e.toString());
            }
        });
    }
}
