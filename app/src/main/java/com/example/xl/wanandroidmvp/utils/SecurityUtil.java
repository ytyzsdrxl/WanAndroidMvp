package com.example.xl.wanandroidmvp.utils;

public class SecurityUtil {

//    检测是否装有xposed框架
    public static boolean hasXPosed(){
        boolean isXPosedExist=false;
        try {
            Class c = ClassLoader.getSystemClassLoader()
                    .loadClass("de.robv.android.xposed.XposedBridge");
            if(null!=c){
                isXPosedExist=true;
            }
        } catch (ClassNotFoundException e) {
            isXPosedExist=false;
        }

        return isXPosedExist;
    }
}
