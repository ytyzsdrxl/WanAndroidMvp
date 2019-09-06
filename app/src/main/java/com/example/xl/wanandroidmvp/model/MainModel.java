package com.example.xl.wanandroidmvp.model;

import com.example.xl.wanandroidmvp.base.BaseModel;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class MainModel implements BaseModel {

    public Observable<ResponseBody> logout(){
        return baseApi.logout();
    }
}
