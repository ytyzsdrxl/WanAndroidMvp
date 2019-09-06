package com.example.xl.wanandroidmvp.model;

import com.example.xl.wanandroidmvp.base.BaseModel;
import com.example.xl.wanandroidmvp.bean.LoginBean;
import com.example.xl.wanandroidmvp.bean.RegistBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class LoginModel implements BaseModel {
    public Observable<RegistBean> regist(String name, String password, String repassword){
        return baseApi.regist(name,password,repassword);
    }

    public Observable<LoginBean> login(String name, String password){
        return baseApi.login(name,password);
    }
}
