package com.example.xl.wanandroidmvp.view;

import com.example.xl.wanandroidmvp.base.BaseView;
import com.example.xl.wanandroidmvp.bean.SearchResultBean;

public interface SearchResultView extends BaseView {

    void onSusses(SearchResultBean resultBean);

    void onFail(String errorMsg);
}
