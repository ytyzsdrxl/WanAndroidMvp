package com.example.xl.wanandroidmvp.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author xulei
 * @date 2019/6/12
 */
public class Util {

    //  获取设备信息
    public static String getAppMsg(Context context) {
        String appVersion = "";
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            appVersion = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String model = "Android/" + Build.MODEL + "/" + Build.VERSION.SDK_INT + "/" + Build.VERSION.RELEASE + "/" + appVersion;
        return model;
    }

    //    获取app版本名称
    public static String getVersionName(Context context) {
        String appVersion = "";
        PackageManager manager = context.getPackageManager();
        try {
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            appVersion = info.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appVersion;
    }

    //    获取版本code
    public int getVersionCode(Context context) {
        PackageManager manager = context.getPackageManager();//获取包管理器
        try {
            //通过当前的包名获取包的信息
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);//获取包对象信息
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //   检查网络是否可用
    public static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            @SuppressLint("MissingPermission") NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (info != null && info.isConnected()) {
                // 当前网络是连接的
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    // 当前所连接的网络可用
                    return true;
                }
            }
        }
        return false;
    }

    //    检查身份证号码格式
    public static boolean checkIdCard(String cardid) {
        String ls_id = cardid;
        if (ls_id.length() != 18) {
            return false;
        }
        char[] l_id = ls_id.toCharArray();
        int l_jyw = 0;
        int[] wi = new int[]{7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1};
        char[] ai = new char[]{'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};
        for (int i = 0; i < 17; i++) {
            if (l_id[i] < '0' || l_id[i] > '9') {
                return false;
            }
            l_jyw += (l_id[i] - '0') * wi[i];
        }
        l_jyw = l_jyw % 11;
        if (ai[l_jyw] != l_id[17]) {
            return false;
        }
        return true;
    }

    //    验证人名的正确性（中文）
    public static boolean checkName(String name) {
        return name.matches("[\u4e00-\u9fa5]{2,}");
    }


    //    手机号验证
    public static boolean isMobileNum(String mobiles) {
        Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
        Matcher m = p.matcher(mobiles);
        return m.matches();
    }

//    登陆密码格式验证
    public static  boolean checkPsw(String password) {

        Pattern p1= Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{8,20}$");
        Matcher m=p1.matcher(password);
        if(!m.find()){
            return false;
        } else{
            if(password.length()>20||password.length()<8){
                return false;
            }else if(!(password.trim().length()==password.length())){
                return false;
            }else {
                return true;
            }
        }
    }

//    连点
    private static long lastClickTime;
    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        long timeD = time - lastClickTime;
        if ( 0 < timeD && timeD < 1000) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

//    时间格式转换
    public static String timeToDay(long time){
        SimpleDateFormat format=new SimpleDateFormat("yyyy.MM.dd");
        return format.format(new Date(time));
    }
}
