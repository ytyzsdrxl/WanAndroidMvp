package com.example.xl.wanandroidmvp.presenter;

import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.bean.LoginBean;
import com.example.xl.wanandroidmvp.bean.RegistBean;
import com.example.xl.wanandroidmvp.model.LoginModel;
import com.example.xl.wanandroidmvp.network.DataObserver;
import com.example.xl.wanandroidmvp.network.NetException;
import com.example.xl.wanandroidmvp.network.RxThreadChange;
import com.example.xl.wanandroidmvp.view.LoginView;

import java.io.IOException;

import okhttp3.ResponseBody;

public class LoginPresenter extends BasePresenter<LoginView,LoginModel> {

    public LoginPresenter(LoginView view) {
        super(view, new LoginModel());
    }

    public void regist(String name,String password,String repassword){
        mModel.regist(name,password,repassword).compose(RxThreadChange.io2main(getView())).subscribe(new DataObserver<RegistBean>() {
            @Override
            public void success(RegistBean registBean) {
               getView().onSusses(registBean);
            }

            @Override
            public void error(NetException.ResponseException e) {
                getView().onFail(e.toString());
            }
        });
    }

    public void login(String name,String password){
        mModel.login(name,password).compose(RxThreadChange.io2main(getView())).subscribe(new DataObserver<LoginBean>() {
            @Override
            public void success(LoginBean loginBean) {
                getView().onLoginSuccess(loginBean);
            }

            @Override
            public void error(NetException.ResponseException e) {
                getView().onFail(e.toString());
            }
        });
    }

}
