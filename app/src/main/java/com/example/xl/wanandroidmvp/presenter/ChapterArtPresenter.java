package com.example.xl.wanandroidmvp.presenter;

import com.example.xl.wanandroidmvp.base.BasePresenter;
import com.example.xl.wanandroidmvp.bean.ChaArtBean;
import com.example.xl.wanandroidmvp.model.ChapterArtModel;
import com.example.xl.wanandroidmvp.network.DataObserver;
import com.example.xl.wanandroidmvp.network.NetException;
import com.example.xl.wanandroidmvp.network.RxThreadChange;
import com.example.xl.wanandroidmvp.view.ChapterArtView;


public class ChapterArtPresenter extends BasePresenter<ChapterArtView,ChapterArtModel> {
    public ChapterArtPresenter(ChapterArtView view) {
        super(view, new ChapterArtModel());
    }
    public void getChapterArt(String id,int pageIndex){
        mModel.getChaArt(id,pageIndex).compose(RxThreadChange.io2main(getView())).subscribe(new DataObserver<ChaArtBean>() {
            @Override
            public void success(ChaArtBean chaArtBean) {
                getView().onSusses(chaArtBean);
            }

            @Override
            public void error(NetException.ResponseException e) {
                getView().onFail(e.toString());
            }
        });
    }
}
