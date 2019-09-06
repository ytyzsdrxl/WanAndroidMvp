package com.example.xl.wanandroidmvp.base;


import com.example.xl.wanandroidmvp.network.Api;
import com.example.xl.wanandroidmvp.network.Constants;
import com.example.xl.wanandroidmvp.network.RetrofitHelper;

/**
*   @author xulei
*   @date   2019/6/10
*/

public interface BaseModel {
    Api baseApi= RetrofitHelper.getRetrofitHelper().getApi(Constants.BASE_URL);
}
