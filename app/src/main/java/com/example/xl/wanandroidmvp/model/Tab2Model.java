package com.example.xl.wanandroidmvp.model;

import com.example.xl.wanandroidmvp.base.BaseModel;
import com.example.xl.wanandroidmvp.bean.HotKeysTextBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class Tab2Model implements BaseModel {
    public Observable<HotKeysTextBean> getHotKeys(){
        return baseApi.getHotKeys();
    }
}
