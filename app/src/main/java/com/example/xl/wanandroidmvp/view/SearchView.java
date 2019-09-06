package com.example.xl.wanandroidmvp.view;

import com.example.xl.wanandroidmvp.base.BaseView;
import com.example.xl.wanandroidmvp.bean.HotKeysBean;

public interface SearchView extends BaseView {
    void onSusses(HotKeysBean hotKeysBean);

    void onFail(String errorMsg);
}
