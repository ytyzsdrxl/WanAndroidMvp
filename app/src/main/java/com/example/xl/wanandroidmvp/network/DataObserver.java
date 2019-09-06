package com.example.xl.wanandroidmvp.network;


import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public abstract class DataObserver<T> implements Observer<T> {

    @Override
    public void onNext(T t) {
        success(t);
    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onError(Throwable e) {
        if (e instanceof NetException.ResponseException) {
            error((NetException.ResponseException) e);
        } else {
            error(new NetException.ResponseException(e, NetException.ERROR.UNKNOWN));
        }
    }

    public abstract void success(T t);

    public abstract void error(NetException.ResponseException e);
}
