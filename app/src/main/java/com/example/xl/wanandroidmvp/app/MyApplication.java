package com.example.xl.wanandroidmvp.app;

import android.app.Application;
import android.content.Context;
import android.os.Build;

import com.squareup.leakcanary.LeakCanary;

import org.litepal.LitePal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MyApplication extends Application {

//   非ui使用,注意内存泄漏问题
    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
        disableAPIDialog();

        LitePal.initialize(this);
        LeakCanary.install(this);
    }

    /**
     * 反射 禁止弹窗(google不建议使用非官方的api)
     */
    private void disableAPIDialog(){
        if (Build.VERSION.SDK_INT < 28){
            return;
        }
        try {
            Class clazz = Class.forName("android.app.ActivityThread");
            Method currentActivityThread = clazz.getDeclaredMethod("currentActivityThread");
            currentActivityThread.setAccessible(true);
            Object activityThread = currentActivityThread.invoke(null);
            Field mHiddenApiWarningShown = clazz.getDeclaredField("mHiddenApiWarningShown");
            mHiddenApiWarningShown.setAccessible(true);
            mHiddenApiWarningShown.setBoolean(activityThread, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Context getContext(){
        return mContext;
    }
}
