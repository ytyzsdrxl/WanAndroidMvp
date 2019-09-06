package com.example.xl.wanandroidmvp.model;

import com.example.xl.wanandroidmvp.base.BaseModel;
import com.example.xl.wanandroidmvp.bean.WXCBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class Tab4Model implements BaseModel {
    public Observable<WXCBean> getWXC(){
        return baseApi.getWXC();
    }
}
