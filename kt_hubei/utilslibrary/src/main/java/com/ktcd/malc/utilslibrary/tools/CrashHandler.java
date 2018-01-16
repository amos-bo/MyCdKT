package com.ktcd.malc.utilslibrary.tools;

import android.content.Context;
import android.util.Log;

import java.lang.Thread.UncaughtExceptionHandler;
/**
 * @author amos_bo 284285624@qq.com
 * @version V1.0
 * @Title: Roadbusiness
 * @Package com.ktcd.malc.utilslibrary.utils
 * @Description: UncaughtException处理类,当程序发生Uncaught异常的时候,有该类来接管程序,并记录发送错误报告.
 * @date 2016/12/2 10:44
 */
public class CrashHandler implements UncaughtExceptionHandler {

    private static CrashHandler INSTANCE = new CrashHandler();

    @SuppressWarnings("unused")
    private Context mContext;

    /** 保证只有一个CrashHandler实例 */
    private CrashHandler() {
    }

    /** 获取CrashHandler实例 ,单例模式 */
    public static CrashHandler getInstance() {
        return INSTANCE;
    }

    /**
     * 初始化
     *
     * @param context
     */
    public void init(Context context) {
        mContext = context;
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    /**
     * 当UncaughtException发生时会转入该函数来处理
     */
    @Override
    public void uncaughtException(Thread thread, Throwable ex) {
        try {
            android.os.Process.killProcess(android.os.Process.myPid());    //获取PID
            System.exit(0);   //常规java、c#的标准退出法，返回值为0代表正常退出
        }
        catch (Exception e) {
            Log.e("CrashHandler", "error : " + e);
        }
    }
}
