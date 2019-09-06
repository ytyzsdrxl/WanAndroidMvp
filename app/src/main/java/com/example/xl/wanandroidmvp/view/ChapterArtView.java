package com.example.xl.wanandroidmvp.view;

import com.example.xl.wanandroidmvp.base.BaseView;
import com.example.xl.wanandroidmvp.bean.ChaArtBean;

public interface ChapterArtView extends BaseView {
    void onSusses(ChaArtBean chaArtBean);

    void onFail(String errorMsg);
}
