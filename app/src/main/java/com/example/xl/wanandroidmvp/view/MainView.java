package com.example.xl.wanandroidmvp.view;

import com.example.xl.wanandroidmvp.base.BaseView;

public interface MainView extends BaseView {

    void onSusses(String data);

    void onFail(String errorMsg);
}
