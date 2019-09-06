package com.example.xl.wanandroidmvp.base;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
*   @author xulei
*   @date   2019/6/10
*/

public interface BaseView {
    //为了防止内存泄漏的风险，使用了第三方库rxlifecycle
//    LifecycleTransformer bindLifecycle();

    <T> LifecycleTransformer<T> bindToLifecycle();
}
