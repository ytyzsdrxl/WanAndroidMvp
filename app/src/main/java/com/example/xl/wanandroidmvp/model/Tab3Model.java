package com.example.xl.wanandroidmvp.model;

import com.example.xl.wanandroidmvp.base.BaseModel;
import com.example.xl.wanandroidmvp.bean.TreeBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class Tab3Model implements BaseModel {
    public Observable<TreeBean> getTree(){
        return baseApi.getTree();
    }
}
