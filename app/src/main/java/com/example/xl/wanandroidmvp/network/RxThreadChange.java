package com.example.xl.wanandroidmvp.network;


import com.example.xl.wanandroidmvp.base.BaseView;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.schedulers.Schedulers;

/**
*   @author xulei
*   @date   2019/6/10
*/

public class RxThreadChange {
    /*public static <T> ObservableTransformer<T, T> io2main(final BaseView baseView) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(@NonNull Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).unsubscribeOn(Schedulers.io()).compose(baseView.bindToLifecycle());
            }
        };
    }*/

     public static <T> ObservableTransformer<T, T> io2main(final BaseView view) {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .compose(view.bindToLifecycle());
    }
}
