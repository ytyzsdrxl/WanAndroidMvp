package com.example.xl.wanandroidmvp.app;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
*   @author xulei
*   @date   2019/6/10
*/
//activity管理类
public class ActivityManager {
    static List<Activity> activities = new ArrayList<>();
    public static void addActivity(Activity activity){
        if (!activities.contains(activity)) {
            activities.add(activity);
        }
    }
    public static void removeActivity(Activity activity){
        if (activities.contains(activity)) {
            activities.remove(activity);
            activity.finish();
        }
    }
    public static void finishAll(){
        for (Activity activity:activities){
            activity.finish();
        }
    }

    public static void removeClass(Class<?> cls){
        for (Activity activity : activities) {
            if(activity.getClass().equals(cls) ){
                activities.remove(activity);
                activity.finish();
            }
        }
    }
}
