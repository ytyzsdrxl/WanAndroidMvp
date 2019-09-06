package com.example.xl.wanandroidmvp.dialog;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;

import com.example.xl.wanandroidmvp.R;
import com.example.xl.wanandroidmvp.views.RoundLoadingView;


public class LoadingDialog extends AlertDialog {

    public LoadingDialog(Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loading_view);
        RoundLoadingView loadingView=findViewById(R.id.loading_view);
        loadingView.startLoading();
    }


}
