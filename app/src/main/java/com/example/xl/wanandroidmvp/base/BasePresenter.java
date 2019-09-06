package com.example.xl.wanandroidmvp.base;


import com.example.xl.wanandroidmvp.utils.Preconditions;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
*   @author xulei
*   @date   2019/6/10
*/

public class BasePresenter<V extends BaseView, M extends BaseModel> {
    //持有M层和V层，必须是要实现BaseView和BaseModel
    /**
     * 由于Presenter 经常性的持有Activity 的强引用，如果在一些请求结束之前Activity 被销毁了，Activity对象将无法被回收，此时就会发生内存泄露。
     * 这里我们使用虚引用和泛型来对MVP中的内存泄漏问题进行改良。
     */
    protected Reference<V> mView;
    protected M mModel;

    public BasePresenter(V view, M model) {
        Preconditions.checkNotNull(model, "%s cannot be null", BaseModel.class.getName());
        Preconditions.checkNotNull(view, "%s cannot be null", BaseView.class.getName());
        this.mModel = model;
        attachView(view);
    }

    protected V getView() {
        return mView.get();
    }


    public void attachView(V view) {
        this.mView= new WeakReference<>(view);
    }


    public void detachView() {
        if (mView != null) {
            mView.clear();
            mView = null;
        }

    }
}
