package com.example.xl.wanandroidmvp.view;

import com.example.xl.wanandroidmvp.base.BaseView;
import com.example.xl.wanandroidmvp.bean.WXCBean;

public interface Tab4View extends BaseView {
    void onSusses(WXCBean wxcBean);

    void onFail(String errorMsg);
}
