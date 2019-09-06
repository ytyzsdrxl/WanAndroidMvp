package com.example.xl.wanandroidmvp.model;

import com.example.xl.wanandroidmvp.base.BaseModel;
import com.example.xl.wanandroidmvp.bean.HotKeysBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class SearchModel implements BaseModel {
    public Observable<HotKeysBean> getHot(){
        return baseApi.getHot();
    }
}
