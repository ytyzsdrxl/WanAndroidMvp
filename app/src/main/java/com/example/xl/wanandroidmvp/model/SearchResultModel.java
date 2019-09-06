package com.example.xl.wanandroidmvp.model;

import com.example.xl.wanandroidmvp.base.BaseModel;
import com.example.xl.wanandroidmvp.bean.SearchResultBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class SearchResultModel implements BaseModel {
    public Observable<SearchResultBean> searchByKey(int index, String key){
        return baseApi.searchByKey(index,key);
    }
}
