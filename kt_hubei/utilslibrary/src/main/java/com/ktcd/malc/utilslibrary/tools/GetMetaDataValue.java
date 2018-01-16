package com.ktcd.malc.utilslibrary.tools;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;


/**
 * @author amos_bo 284285624@qq.com
 * @version V1.0
 * @Title: Roadbusiness
 * @Package com.zowee.roadbusiness.utils
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2016/12/2 11:16
 */
public class GetMetaDataValue {
    /**
     * @description 获取配置在AndroidManifest文件下的工场名称
     * @date 2015年8月4日
     * @param context
     * @return
     */
    public static String getGroupName(Context context,String key) {
            try {
                PackageManager pckManager = context.getPackageManager();
                ApplicationInfo appInfo = pckManager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
                if (appInfo != null && appInfo.metaData != null) {
                    return appInfo.metaData.getString(key);
                }
                else {
                   return  null;
                }
            }
            catch (PackageManager.NameNotFoundException e) {
                return  null;
            }
            catch (Exception e) {
                return  null;
            }
    }
}
