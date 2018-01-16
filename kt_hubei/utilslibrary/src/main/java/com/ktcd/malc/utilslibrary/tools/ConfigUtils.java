package com.ktcd.malc.utilslibrary.tools;

import android.content.Context;

/**
 * @author amos_bo 284285624@qq.com
 * @ClassName: ConfigUtils
 * @Description: 持久化类
 * @date 2015年9月9日 下午4:54:53
 */
public class ConfigUtils {

    /**
     * 持久化-文件名
     */
    private static final String FILE_NAME = "user_info";

    /**
     * 持久化-APP是否有更新
     */
    public static final String APP_OPEN_NUMBER = "app_open_number";
    /**
     * 持久化-用户登录
     */
    public static final String APP_USER_LOGIN = "app_user_login";
    /**
     * 持久化-用户ID
     */
    public static final String APP_USER_ID = "app_user_id";


    /**
     * 持久化-是否打开定位
     */
    public static final String APP_ISCAN_LOC = "app_iscan_loc";

    /**
     * 持久化-IM是否注册
     */
    public static final String APP_IS_REGISTED = "app_is_registed";

    /**
     * 持久化-数据IP
     */
    public static final String APP_DATA_IP = "app_data_ip";

    /**
     * 持久化-图片IP
     */
    public static final String APP_PIC_IP = "app_pic_ip";


    /**
     * 当前配置文件操作类
     */
    private static SPUtils spUtils = null;

    private static void init(Context context) {
        if (spUtils == null) {
            spUtils = new SPUtils(context, FILE_NAME);
        }
    }

    /**
     * @Description: 获得应用是否第一次打开
     */
    public static int isFirstOpen(Context context) {
        init(context);
        return spUtils.getValue(APP_OPEN_NUMBER, 1);
    }

    /**
     * @Description: 设置是否第一次打开
     */
    public static void setFirstOpen(Context context, int flag) {
        init(context);
        spUtils.setValue(APP_OPEN_NUMBER, flag);
    }

    /**
     * @Description: 获得应用是否登录
     */
    public static boolean getUserLogin(Context context) {
        init(context);
        return spUtils.getValue(APP_USER_LOGIN,false);
    }
    /**
     * @Description: 设置应用登录Id
     */
    public static void setUserID(Context context,int Id) {
        init(context);
        spUtils.setValue(APP_USER_ID,Id);
    }
    /**
     * @Description: 获得应用是否登录ID
     */
    public static int getUserID(Context context) {
        init(context);
        return spUtils.getValue(APP_USER_ID,0);
    }
    /**
     * @Description: 设置应用登录
     */
    public static void setUserLogin(Context context,boolean bl) {
        init(context);
        spUtils.setValue(APP_USER_LOGIN,bl);
    }
    /**
     * @Description: 获得应用是否可定位
     */
    public static boolean getIsCanLoc(Context context) {
        init(context);
        return spUtils.getValue(APP_ISCAN_LOC,true);
    }
    /**
     * @Description: 设置应用是否可定位
     */
    public static void setIsCanLoc(Context context,boolean bl) {
        init(context);
        spUtils.setValue(APP_ISCAN_LOC,bl);
    }


    /**
     * @Description: 获得应用IM是否注册
     */
    public static boolean getIsRegisted(Context context) {
        init(context);
        return spUtils.getValue(APP_IS_REGISTED,false);
    }
    /**
     * @Description: 设置应用IM是否注册
     */
    public static void setIsRegisted(Context context,boolean bl) {
        init(context);
        spUtils.setValue(APP_IS_REGISTED,bl);
    }
    /**
     * @Description: 获得应用数据IP
     */
    public static String getAppDataIP(Context context) {
        init(context);
        return spUtils.getValue(APP_DATA_IP,"http://116.7.250.72,9091,8082");
    }
    /**
     * @Description: 设置应用数据IP
     */
    public static void setAppDataIP(Context context,String bl) {
        init(context);
        spUtils.setValue(APP_DATA_IP,bl);
    }

    /**
     * @Description: 获得应用图片IP
     */
    public static String getAppPicIP(Context context) {
        init(context);
        return spUtils.getValue(APP_PIC_IP,"http://192.168.0.110:8082/KT_S_Attachment/");
    }
    /**
     * @Description: 设置应用图片IP
     */
    public static void setAppPicIP(Context context,String bl) {
        init(context);
        spUtils.setValue(APP_PIC_IP,bl);
    }


    /**
     * 删除第一次打开
     */
    public static void removeUuId(Context context) {
        init(context);
        spUtils.remove(APP_OPEN_NUMBER);
    }

}
