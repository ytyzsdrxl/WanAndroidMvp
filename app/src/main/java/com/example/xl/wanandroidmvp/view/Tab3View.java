package com.example.xl.wanandroidmvp.view;

import com.example.xl.wanandroidmvp.base.BaseView;
import com.example.xl.wanandroidmvp.bean.TreeBean;

public interface Tab3View extends BaseView {
    void onSusses(TreeBean treeBean);

    void onFail(String errorMsg);
}
