package com.example.xl.wanandroidmvp.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.base.BaseMvpActivity;
import com.example.xl.wanandroidmvp.base.BasePresenter;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends BaseMvpActivity {

    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initEvent();
    }

    private void initEvent() {
        mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                jumpToMain();
            }
        }, 3000);
    }


    private void jumpToMain() {
        Intent intent = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
        mHandler=null;
    }

    @OnClick(R.id.tv_splash_jump)
    public void onClick() {
        jumpToMain();
    }
}
