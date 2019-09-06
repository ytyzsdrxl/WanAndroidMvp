package com.example.xl.wanandroidmvp.utils;

import android.content.Context;
import android.content.Intent;

import java.io.File;

//import com.baidu.mapapi.model.LatLng;

/**
 * @author xulei
 * @date 2019/6/6
 */

public class MapUtil {
    public static final String PN_GAODE_MAP = "com.autonavi.minimap";// 高德地图包名
    public static final String PN_BAIDU_MAP = "com.baidu.BaiduMap"; // 百度地图包名
    public static final String PN_TENCENT_MAP = "com.tencent.map"; // 腾讯地图包名

    //   检测高德地图是否安装
    public static boolean isGdMapInstalled() {
        return isInstallPackage(PN_GAODE_MAP);
    }

    //   检测百度地图是否安装
    public static boolean isBaiduMapInstalled() {
        return isInstallPackage(PN_BAIDU_MAP);
    }

    //   检测腾讯地图是否安装
    public static boolean isTencentMapInstalled() {
        return isInstallPackage(PN_TENCENT_MAP);
    }

    private static boolean isInstallPackage(String packageName) {
        return new File("/data/data/" + packageName).exists();
    }


    //  打开百度地图进行导航
    public static void openBaiduMap(Context context, double endLatitude, double endLongitude) {
        Intent naviIntent = new Intent("android.intent.action.VIEW", android.net.Uri.parse("baidumap://map/geocoder?location=" + endLatitude + "," + endLongitude));
        context.startActivity(naviIntent);
    }

    //  打开高德地图进行导航
    public static void openGaodeMap(Context context, double endLatitude, double endLongitude) {
        Intent naviIntent = new Intent("android.intent.action.VIEW", android.net.Uri.parse("androidamap://route?sourceApplication=appName&slat=&slon=&sname=我的位置&dlat=" + endLatitude + "&dlon=" + endLongitude + "&dname=目的地&dev=0&t=2"));
        context.startActivity(naviIntent);
    }

    //  打开腾讯地图进行导航
    public static void openTencentMap(Context context, double endLatitude, double endLongitude) {
        Intent naviIntent = new Intent("android.intent.action.VIEW", android.net.Uri.parse("qqmap://map/routeplan?type=drive&from=&fromcoord=&to=目的地&tocoord=" + endLatitude + "," + endLongitude + "&policy=0&referer=appName"));
        context.startActivity(naviIntent);
    }

    //  百度坐标系（BD09）转高德（腾讯）坐标系（GCJ02）
    /*public static LatLng bdToGcj(double latitude,double longitude) {
        double x = longitude - 0.0065, y = latitude - 0.006;
        double z = Math.sqrt(x * x + y * y) - 0.00002 * Math.sin(y * Math.PI);
        double theta = Math.atan2(y, x) - 0.000003 * Math.cos(x * Math.PI);

        double lng = z * Math.cos(theta);//lng
        double lat = z * Math.sin(theta);//lat
        return new LatLng(lat, lng);
    }*/

    //  高德（腾讯）坐标系（GCJ02）转百度坐标系（BD09）
    /*public static LatLng gcjToBd(double latitude,double longitude) {
        double x = longitude, y = latitude;
        double z = Math.sqrt(x * x + y * y) + 0.00002 * Math.sin(y * Math.PI);
        double theta = Math.atan2(y, x) + 0.000003 * Math.cos(x * Math.PI);
        double tempLon = z * Math.cos(theta) + 0.0065;
        double tempLat = z * Math.sin(theta) + 0.006;
        return new LatLng(tempLat, tempLon);
    }*/

}
