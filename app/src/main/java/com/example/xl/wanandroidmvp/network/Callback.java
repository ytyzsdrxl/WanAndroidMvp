package com.example.xl.wanandroidmvp.network;

/**
*   @author xulei
*   @date   2019/6/10
*/

public interface Callback<T> {
    void success(T t);

    void fail(String msg);
}
