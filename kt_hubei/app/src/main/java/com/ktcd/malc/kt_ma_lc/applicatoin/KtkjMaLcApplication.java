package com.ktcd.malc.kt_ma_lc.applicatoin;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.os.Build;
import android.os.StrictMode;

import com.baidu.location.LocationClient;
import com.baidu.mapapi.SDKInitializer;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.ktcd.malc.kt_ma_lc.R;
//import com.ktcd.malc.kt_ma_lc.client.ServiceManager;
import com.ktcd.malc.utilslibrary.tools.CrashHandler;
import com.ktcd.malc.utilslibrary.tools.FontUtils;
import com.ktcd.malc.utilslibrary.tools.LogUtils;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;

import com.squareup.leakcanary.LeakCanary;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;


import cn.jpush.android.api.JPushInterface;


/**
 * @author Amos_bo E-mail:284285624@qq.com
 * @date 2015年8月21日 下午5:34:26
 * @描述:
 */
public class KtkjMaLcApplication extends Application  {

    /**
     * 所有的Activity列表
     */
    private ArrayList<Activity> mActivityList = new ArrayList<Activity>();

    /**
     * 所有的Service列表
     */
    private LinkedList<Service> mServiceList = new LinkedList<Service>();

    /**
     * 所有的广播列表
     */
    private LinkedList<BroadcastReceiver> mBroadcastReceiverList = new
            LinkedList<BroadcastReceiver>();

    /**
     * 上下文对象
     */
    private static KtkjMaLcApplication instance;
    //全局定位
    public LocationClient LOCATION_CLIENT = null;
    //是否开启定位
    public boolean ISCAN_LOC = true;




    @SuppressLint("NewApi")
    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        LogUtils.setDebug(BuildConfig.DEBUG);
        // 发布时DEBUG改为false
        if (BuildConfig.DEBUG && Build.VERSION_CODES.GINGERBREAD <= Build
                .VERSION.SDK_INT) {
            //开启严苛模式
            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                    .detectAll().penaltyLog().build());
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                    .detectAll().penaltyLog().build());
//            LeakCanary.install(this);//开启内存泄漏检测
        } else {
            //非调试，开启全局捕获异常
            CrashHandler handler = CrashHandler.getInstance();
            handler.init(this);
        }
        //防止修改系統文字大小影響佈局
        FontUtils.setFontSize(this);
        JPushInterface.setDebugMode(true);    // 设置开启日志,发布时请关闭日志
        JPushInterface.init(this);            // 初始化 JPush
        Fresco.initialize(this);
        //百度地图、定位初始化
        SDKInitializer.initialize(getApplicationContext());
    }

    public static KtkjMaLcApplication getInstance() {
        return instance;
    }

    /**
     * 添加Activity
     */
    public void addActivity(Activity activity) {
        mActivityList.add(activity);
    }

    /**
     * 添加Service
     */
    public void addService(Service service) {
        mServiceList.add(service);
    }

    /**
     * 添加BroadcastReceiver
     */
    public void addBroadcastReceiver(BroadcastReceiver broadcastreceiver) {
        mBroadcastReceiverList.add(broadcastreceiver);
    }

    /**
     * 关闭所有的Activity
     */
    public void clearActivities() {
        for (Activity item : mActivityList) {
            item.finish();
        }
        mActivityList.clear();
    }

    /**
     * 删除指定Activity
     *
     * @param name
     */
    public void reMoveActivity(String name) {
        for (Activity activity : mActivityList) {
            if (activity.getClass().getName().equals(name)) {
                activity.finish();
            }
        }

    }

    /**
     * 关闭服务
     */
    public void finishService() {
        for (Service service : mServiceList) {
            service.stopSelf();
        }
    }

    /**
     * @param
     * @return void 返回类型
     * @throws
     * @Title: exitApp
     * @Description: 退出APP
     */
    public void exitApp() {
        for (Activity activity : mActivityList) {
            activity.finish();
            deleteFilesByDirectory(activity.getFilesDir());
        }
        for (Service service : mServiceList) {
            service.stopSelf();
        }
        for (BroadcastReceiver broadcastReceive : mBroadcastReceiverList) {
             unregisterReceiver(broadcastReceive);
        }
        ToastUtils.cancelCurrentToast();
        android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    private void deleteFilesByDirectory(File directory) {
        if (directory != null && directory.exists() && directory.isDirectory()) {
            for (File item : directory.listFiles()) {
                item.delete();
            }
        }
    }

    public void onTerminate() {
        // 程序终止的时候执行,真机不执行
        super.onTerminate();
    }

    @Override
    public void onLowMemory() {
        // 低内存的时候执行
        super.onLowMemory();
    }

    @Override
    public void onTrimMemory(int level) {
        // 程序在内存清理的时候执行
        super.onTrimMemory(level);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//        AppContext.init(base);
    }

//    @Override
//    public SQLiteDBConfig getGlobalDbConfig() {
//        if (mDBConfig == null) {
//            synchronized (KtkjMaLcApplication.class) {
//                if (mDBConfig == null) {
//                    mDBConfig = new SQLiteDBConfig(AppContext.getInstance());
//                    mDBConfig.setDbName(getResources().getString(R.string.app_name) + ".db");
//                    //本地数据库文件保存在应用文件目录
////                    mDBConfig.setDbDirectoryPath(AppFileHelper.getAppDBDir());
//                }
//            }
//        }
//        return mDBConfig;
//    }



}
