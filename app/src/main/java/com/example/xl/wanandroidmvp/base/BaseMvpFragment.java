package com.example.xl.wanandroidmvp.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.xl.wanandroidmvp.dialog.LoadingDialog;
import com.trello.rxlifecycle2.components.support.RxFragment;


public abstract class BaseMvpFragment<P extends BasePresenter> extends RxFragment{
    protected P mPresenter;
    private LoadingDialog mLoadingDialog;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter=createPresenter();
    }

    protected abstract P createPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    public void showLoadingDialog(boolean canclable){
        if (mLoadingDialog==null){
            mLoadingDialog = new LoadingDialog(getContext());
            mLoadingDialog.setCanceledOnTouchOutside(canclable);
        }
        if (!mLoadingDialog.isShowing()){
            mLoadingDialog.show();
            mLoadingDialog.getWindow().setBackgroundDrawable(null);
        }
    }

    public void hideLoadingDialog(){
        if (mLoadingDialog!=null&&mLoadingDialog.isShowing()){
            mLoadingDialog.dismiss();
        }
    }

    public void toastShort(String msg){
        Toast.makeText(this.getContext(), ""+msg, Toast.LENGTH_SHORT).show();
    }

    public void toastLong(String msg){
        Toast.makeText(this.getContext(), ""+msg, Toast.LENGTH_SHORT).show();
    }
}
