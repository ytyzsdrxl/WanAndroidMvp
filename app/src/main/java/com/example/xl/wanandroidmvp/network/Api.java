package com.example.xl.wanandroidmvp.network;


import com.example.xl.wanandroidmvp.bean.ArticleBean;
import com.example.xl.wanandroidmvp.bean.BannerBean;
import com.example.xl.wanandroidmvp.bean.ChaArtBean;
import com.example.xl.wanandroidmvp.bean.HotKeysBean;
import com.example.xl.wanandroidmvp.bean.HotKeysTextBean;
import com.example.xl.wanandroidmvp.bean.LoginBean;
import com.example.xl.wanandroidmvp.bean.RegistBean;
import com.example.xl.wanandroidmvp.bean.SearchResultBean;
import com.example.xl.wanandroidmvp.bean.TreeBean;
import com.example.xl.wanandroidmvp.bean.WXCBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

;

/**
*   @author xulei
*   @date   2019/6/10
*/

public interface Api {

//    获取首页文章列表
    @GET("article/list/{index}/json")
    Observable<ArticleBean> getArticleList(@Path("index") int index);

//    广告页
    @GET("banner/json")
    Observable<BannerBean> getBanner();

//    热点
    @GET("hotkey/json")
    Observable<HotKeysBean> getHot();

//    搜索
    @FormUrlEncoded
    @POST("article/query/{index}/json")
    Observable<SearchResultBean> searchByKey(@Path("index")int index, @Field("k")String key);

//   获取热点搜索
    @GET("hotkey/json")
    Observable<HotKeysTextBean> getHotKeys();

//    知识体系
    @GET("tree/json")
    Observable<TreeBean> getTree();

//    公众号
    @GET("wxarticle/chapters/json")
    Observable<WXCBean> getWXC();

//    公众号文章列表
    @GET("wxarticle/list/{id}/{index}/json")
    Observable<ChaArtBean> getChaArt(@Path("id")String id, @Path("index")int index);

//    注册
    @FormUrlEncoded
    @POST("user/register")
    Observable<RegistBean> regist(@Field("username")String name, @Field("password")String password, @Field("repassword")String repassword);

//    登陆
    @FormUrlEncoded
    @POST("user/login")
    Observable<LoginBean> login(@Field("username")String name, @Field("password")String password);

//    退出登录
    @GET("user/logout/json")
    Observable<ResponseBody> logout();
}
