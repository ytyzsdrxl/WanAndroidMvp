package com.example.xl.wanandroidmvp.network;


import com.example.xl.wanandroidmvp.app.MyApplication;
import com.example.xl.wanandroidmvp.utils.CookieUtil;
import com.example.xl.wanandroidmvp.utils.PreferencesUtil;
import com.example.xl.wanandroidmvp.utils.Util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
*   @author xulei
*   @date   2019/6/10
*/
public class RetrofitHelper {

    private static final long DEFAULT_TIMEOUT = 10;
    private volatile static OkHttpClient mOkHttpClient;
    private volatile static RetrofitHelper sRetrofitHelper;

    public static RetrofitHelper getRetrofitHelper(){
        if (sRetrofitHelper==null){
            synchronized (RetrofitHelper.class){
                if (sRetrofitHelper==null){
                    sRetrofitHelper=new RetrofitHelper();
                }
            }
        }
        return sRetrofitHelper;
    }

    static {
        initOkHttpClient();
    }

    public  Api getApi(String baseUrl) {
        return createApi(Api.class,baseUrl);
    }


    /**
     * 根据传入的baseUrl，和api创建retrofit
     */
    private  <T> T createApi(Class<T> clazz, String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(mOkHttpClient)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(clazz);
    }


    /**
     * 初始化OKHttpClient,设置缓存,设置超时时间,设置打印日志,设置Request拦截器
     */
    private static void initOkHttpClient() {
        HashMap<String,List<Cookie>> hashMapList=new HashMap<>();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        if (mOkHttpClient == null) {
            synchronized (RetrofitHelper.class) {
                if (mOkHttpClient == null) {
                    mOkHttpClient = new OkHttpClient.Builder()
                            .cookieJar(new CookieJar() {
                                @Override
                                public void saveFromResponse(HttpUrl url, List<Cookie> cookies) {
                                    hashMapList.put(url.host(),cookies);
                                }

                                @Override
                                public List<Cookie> loadForRequest(HttpUrl url) {
                                    return hashMapList.get(url.host())==null?new ArrayList<>():hashMapList.get(url.host());
                                }
                            })
                            .addInterceptor(interceptor)
                            .addInterceptor(new RequestInterceptor())
                            .addInterceptor(new CookieIntercept())
                            .addInterceptor(new HeadIntercept())
                            .addInterceptor(new OfflineCacheInterceptor())
                            .retryOnConnectionFailure(true)
                            .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .writeTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
    }

    private static class OfflineCacheInterceptor implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (!Util.isNetworkAvailable(MyApplication.getContext())) {
                int offlineCacheTime = 60;//离线的时候的缓存的过期时间
                request = request.newBuilder()
//                        .cacheControl(new CacheControl
//                                .Builder()
//                                .maxStale(60,TimeUnit.SECONDS)
//                                .onlyIfCached()
//                                .build()
//                        ) 两种方式结果是一样的，写法不同
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + offlineCacheTime)
                        .build();
            }
            return chain.proceed(request);
        }
    }


    private static class CookieIntercept implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Response response = chain.proceed(request);
            String url = request.url().toString();
            if ((url.contains("user/login")||url.contains("user/register"))&&!response.headers("set-cookie").isEmpty()){
                List<String> cookies=response.headers("set-cookie");
                String encodeCookie = CookieUtil.INSTANCE.encodeCookie(cookies);
                CookieUtil.INSTANCE.saveCookie(encodeCookie);
            }
            return response;
        }
    }

    private static class HeadIntercept implements Interceptor{

        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            Request.Builder builder = request.newBuilder();
            builder.addHeader("Content-type", "application/json; charset=utf-8");
            String host = request.url().host();
            if (!host.isEmpty()){
                String cookie=PreferencesUtil.getString(MyApplication.getContext(),"cookie","");
                builder.addHeader("Cookie",cookie);
            }
            return chain.proceed(builder.build());
        }
    }

    private static class RequestInterceptor implements Interceptor {
        @Override
        public Response intercept(Chain chain) throws IOException {
            Request request = chain.request();
            if (request.method().equals("POST")) {
                if (request.body() instanceof FormBody) {
                    request = addPostFormParams(request);
                } else if (request.body() instanceof MultipartBody) {
                    request = addPostMultiParams(request);
                }
            } else if (request.method().equals("GET")) {
                request = addGetParams(chain);
            }
            return chain.proceed(request);
        }
    }

    //上传时
    private static Request addPostMultiParams(Request request) {
        // 添加公共参数
        MultipartBody.Builder builder = new MultipartBody.Builder().addFormDataPart("deviceId", "123456");
        MultipartBody oldBody = (MultipartBody) request.body();
        for (int i = 0; i < oldBody.size(); i++) {
            builder.addPart(oldBody.part(i));
        }
        oldBody = builder.build();
        request = request.newBuilder().post(oldBody).build();
        return request;
    }

    //正常时
    private static Request addPostFormParams(Request request) {
        FormBody.Builder bodyBuilder = new FormBody.Builder();
        FormBody formBody = (FormBody) request.body();
        //把原来的参数添加到新的构造器，（因为没找到直接添加，所以就new新的）
        for (int i = 0; i < formBody.size(); i++) {
            bodyBuilder.addEncoded(formBody.encodedName(i), formBody.encodedValue(i));
        }
        //添加公共参数
        formBody = bodyBuilder
                .addEncoded("deviceId", "123456").build();
        request = request.newBuilder().post(formBody).build();
        return request;
    }

    private static Request addGetParams(Interceptor.Chain chain) {
        Request request;
        Request oldRequest = chain.request();
        // 添加公共参数
        HttpUrl authorizedUrlBuilder = oldRequest.url()
                .newBuilder()
                .addQueryParameter("deviceId", "123456").build();
        request = oldRequest.newBuilder()
                .url(authorizedUrlBuilder)
                .build();
        return request;
    }
}
