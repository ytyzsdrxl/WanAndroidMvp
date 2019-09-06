package com.example.xl.wanandroidmvp.base;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.example.xl.wanandroidmvp.app.ActivityManager;
import com.example.xl.wanandroidmvp.dialog.LoadingDialog;
import com.example.xl.wanandroidmvp.utils.XlStatusBarUtil;
import com.trello.rxlifecycle2.components.support.RxFragmentActivity;


public abstract class BaseMvpFragmentActivity<P extends BasePresenter> extends RxFragmentActivity{
    protected P mPresenter;
    private LoadingDialog mLoadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        mPresenter = createPresenter();
        super.onCreate(savedInstanceState);
        XlStatusBarUtil.StatusBarLightMode(this, XlStatusBarUtil.StatusBarLightMode(this));
        ActivityManager.addActivity(this);
    }

    //    限制字体大小改变
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (newConfig.fontScale!=1){
            getResources();
        }
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public Resources getResources() {
        Resources res = super.getResources();
        if (res.getConfiguration().fontScale != 1) {//非默认值
            Configuration newConfig = new Configuration();
            newConfig.setToDefaults();//设置默认
            res.updateConfiguration(newConfig, res.getDisplayMetrics());
        }
        return res;
    }

    protected abstract P createPresenter();

    public void showLoadingDialog(boolean canclable){
        if (mLoadingDialog==null){
            mLoadingDialog = new LoadingDialog(this);
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
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();
    }

    public void toastLong(String msg){
        Toast.makeText(this, ""+msg, Toast.LENGTH_SHORT).show();
    }
}
