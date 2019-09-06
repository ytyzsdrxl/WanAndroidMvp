package com.example.xl.wanandroidmvp.model;

import com.example.xl.wanandroidmvp.base.BaseModel;
import com.example.xl.wanandroidmvp.bean.ChaArtBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;

public class ChapterArtModel implements BaseModel {
    public Observable<ChaArtBean> getChaArt(String id, int index){
        return baseApi.getChaArt(id,index);
    }
}
