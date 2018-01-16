package com.ktcd.malc.utilslibrary.tools;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

/**
 * @author amos_bo 284285624@qq.com
 * @version V1.0
 * @Title: newzowee127
 * @Package com.zowee.roadbusiness.utils
 * @Description: 申请权限
 * @date 2016/12/19 14:09
 */
public class PermissionsUtils {

    public static final int STORAGE_CODE=200;
    public static final int CAMERA_CODE=201;
    public static final int SENSORS_CODE=202;
    public static final int CONTACTS_CODE=203;
    public static final int PHONE_CODE=204;
    public static final int SMS_CODE=205;
    public static final int AUDIO_CODE=206;
    public static final int CALENDAR_CODE=207;
    public static final int LOCATION_CODE=208;

    public static final int ALL_CODE=210;

//    /**九组需要申请权限的组，每组中只需要申请成功一个其他权限自动获取得*/
//    public static String[] mPermissions=new String[]{
//             Manifest.permission.READ_EXTERNAL_STORAGE,//存储类
//             Manifest.permission.CAMERA,//相机类
//             Manifest.permission.BODY_SENSORS,//传感器类
//             Manifest.permission.WRITE_CONTACTS,//联系人类
//             Manifest.permission.CALL_PHONE,//电话类
//             Manifest.permission.SEND_SMS,//短信类
//             Manifest.permission.RECORD_AUDIO,//麦克风类
//             Manifest.permission.READ_CALENDAR,//用户的日程信息类
//             Manifest.permission.ACCESS_FINE_LOCATION//位置类
//    };

     public static void getAllPermissions(Activity content,int requestCode){
         if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
             return;
         }else{
             String[] mPermissions=new String[]{
                     Manifest.permission.READ_EXTERNAL_STORAGE,//存储类
                     Manifest.permission.CAMERA,//相机类
                     Manifest.permission.BODY_SENSORS,//传感器类
                     Manifest.permission.WRITE_CONTACTS,//联系人类
                     Manifest.permission.CALL_PHONE,//电话类
                     Manifest.permission.SEND_SMS,//短信类
                     Manifest.permission.RECORD_AUDIO,//麦克风类
                     Manifest.permission.READ_CALENDAR,//用户的日程信息类
                     Manifest.permission.ACCESS_FINE_LOCATION//位置类
             };
             String noPermissions="";
             for (String permission:mPermissions){
                 if (lacksPermission(permission,content)){
                     noPermissions=noPermissions+","+permission;
                 }
             }
             if (noPermissions.length()>2){
                 String []permissions=noPermissions.
                         substring(1,noPermissions.length())
                         .split(",");
                 ActivityCompat.requestPermissions(content,
                         permissions,requestCode);
             }
         }
     }

    /**文件读写权限*/
    public static void  requesFilePermissions(Activity context,int requestCode) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        }else {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {//没有权限
                ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, requestCode);
            }
        }
    }
    /**电话权限*/
    public static void  requesPhonePermissions(Activity context,int requestCode) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        }else {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {//没有权限
                ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.CALL_PHONE}, requestCode);
            }
        }
    }

    /**相机权限*/
    public static void  requesCameraPermissions(Activity context,int requestCode) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        }else {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {//没有权限
                ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.CAMERA}, requestCode);
            }
        }
    }

    /**联系人权限*/
    public static void  requesContactsermissions(Activity context,int requestCode) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        }else {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.WRITE_CONTACTS) != PackageManager.PERMISSION_GRANTED) {//没有权限
                ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.WRITE_CONTACTS}, requestCode);
            }
        }
    }

    /**传感器权限*/
    public static void  requesSensorsPermissions(Activity context,int requestCode) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        }else {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.BODY_SENSORS) != PackageManager.PERMISSION_GRANTED) {//没有权限
                ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.BODY_SENSORS}, requestCode);
            }
        }
    }

    /**短信权限*/
    public static void  requesSmsPermissions(Activity context,int requestCode) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        }else {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {//没有权限
                ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.SEND_SMS}, requestCode);
            }
        }
    }

    /**位置类权限*/
    public static void  requesLocationPermissions(Activity context,int requestCode) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        }else {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {//没有权限
                ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, requestCode);
            }
        }
    }
    /**麦克风权限*/
    public static void  requesAudioPermissions(Activity context,int requestCode) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        }else {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.RECORD_AUDIO) != PackageManager.PERMISSION_GRANTED) {//没有权限
                ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.RECORD_AUDIO}, requestCode);
            }
        }
    }

    /**日程权限*/
    public static void  requesCalendarPermissions(Activity context,int requestCode) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M){
            return;
        }else {
            if (ContextCompat.checkSelfPermission(context, Manifest.permission.READ_CALENDAR) != PackageManager.PERMISSION_GRANTED) {//没有权限
                ActivityCompat.requestPermissions(context, new String[]{Manifest.permission.READ_CALENDAR}, requestCode);
            }
        }
    }




    // 判断是否缺少权限 无权限返回true
    public  static  boolean lacksPermission(String permission, Context context) {
        return ContextCompat.checkSelfPermission(context, permission) ==
                PackageManager.PERMISSION_DENIED;
    }

}
