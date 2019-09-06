package com.example.xl.wanandroidmvp.presenter;

import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.model.MainModel;
import com.example.xl.wanandroidmvp.network.DataObserver;
import com.example.xl.wanandroidmvp.network.NetException;
import com.example.xl.wanandroidmvp.network.RxThreadChange;
import com.example.xl.wanandroidmvp.view.MainView;

import java.io.IOException;

import okhttp3.ResponseBody;

public class MainPresenter extends BasePresenter<MainView,MainModel> {
    public MainPresenter(MainView view) {
        super(view, new MainModel());
    }

    public void logout(){
        mModel.logout().compose(RxThreadChange.io2main(getView())).subscribe(new DataObserver<ResponseBody>() {
            @Override
            public void success(ResponseBody responseBody) {
                try {
                    String data = responseBody.string();
                    getView().onSusses(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void error(NetException.ResponseException e) {
                getView().onFail(e.toString());
            }
        });
    }
}
