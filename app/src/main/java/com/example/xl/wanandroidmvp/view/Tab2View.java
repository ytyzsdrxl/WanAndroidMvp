package com.example.xl.wanandroidmvp.view;

import com.example.xl.wanandroidmvp.base.BaseView;
import com.example.xl.wanandroidmvp.bean.ArticleBean;
import com.example.xl.wanandroidmvp.bean.HotKeysTextBean;

public interface Tab2View extends BaseView {

    void onSusses(HotKeysTextBean hotKeysTextBean);

    void onFail(String errorMsg);
}
