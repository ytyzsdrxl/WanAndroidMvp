package com.example.xl.wanandroidmvp.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.xl.wanandroidmvp.network.Constants;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

;

public class ImageUtil {
//    将网络图片保存到本地
    public static void saveNetImage(Context context, String url){
        Bitmap bitmap = null;
        try {
            bitmap = Glide.with(context)
                    .asBitmap()
                    .load(url)
                    .apply(new RequestOptions().skipMemoryCache(true))
                    .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                    .get();
            if (bitmap != null){
                // 在这里执行图片保存方法
                saveImage(context,bitmap);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    //  bitmap 保存本地
    public static void saveImage(Context context, Bitmap bmp) {
        File fileExist=isFileExist();
        if (fileExist.exists()){
            fileExist.mkdirs();
        }
        String fileName = "adv.jpg";
        File file = new File(fileExist, fileName);
        try {
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 最后通知图库更新
        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.fromFile(new File(file.getPath()))));

    }

    public static File isFileExist(){
        // 首先保存图片
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsoluteFile();//注意小米手机必须这样获得public绝对路径
        String filesName = Constants.ADV_FILE_NAME;
        File appDir = new File(file ,filesName);
        return appDir;
    }

}
