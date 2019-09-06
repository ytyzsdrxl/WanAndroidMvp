package com.example.xl.wanandroidmvp.view;

import com.example.xl.wanandroidmvp.base.BaseView;
import com.example.xl.wanandroidmvp.bean.LoginBean;
import com.example.xl.wanandroidmvp.bean.RegistBean;

public interface LoginView extends BaseView{
    void onLoginSuccess(LoginBean loginBean);

    void onSusses(RegistBean registBean);

    void onFail(String errorMsg);
}
