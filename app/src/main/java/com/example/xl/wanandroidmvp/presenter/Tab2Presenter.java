package com.example.xl.wanandroidmvp.presenter;

import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.bean.HotKeysTextBean;
import com.example.xl.wanandroidmvp.model.Tab2Model;
import com.example.xl.wanandroidmvp.network.DataObserver;
import com.example.xl.wanandroidmvp.network.NetException;
import com.example.xl.wanandroidmvp.network.RxThreadChange;
import com.example.xl.wanandroidmvp.view.Tab2View;

import java.io.IOException;

import okhttp3.ResponseBody;

public class Tab2Presenter extends BasePresenter<Tab2View,Tab2Model> {

    public Tab2Presenter(Tab2View view) {
        super(view, new Tab2Model());
    }

    public void getHotKey(){
        mModel.getHotKeys().compose(RxThreadChange.io2main(getView())).subscribe(new DataObserver<HotKeysTextBean>() {
            @Override
            public void success(HotKeysTextBean hotKeysTextBean) {
                getView().onSusses(hotKeysTextBean);
            }

            @Override
            public void error(NetException.ResponseException e) {
                getView().onFail(e.toString());
            }
        });
    }
}
