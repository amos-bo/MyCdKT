package com.ktcd.malc.kt_ma_lc.applicatoin;

/**
 * Created by Administrator on 2017/6/19.
 */

public class ApiPathUrl {

    /**
     * 按id查询指令信息
     */
    public final static String ACTION_GETDIRECTIVEBYID = "rest/userDirective/getUserDirectiveById";
    /**
     * 登录
     */
    public final static String ACTION_LOGIN = "rest/User/login";
    /**
     * 分页查询指令
     */
    public final static String ACTION_DIRECTIVELIST = "rest/userDirective/getUserDirectiveList";
    /**
     * 天气查询图片根目录
     */
    public final static String WEATHER_ROOT_IMG = "http://m.weather.com.cn/img/";
    /**
     * 天气查询
     */
    public final static String ACTION_WEATHER = "rest/weather/getWeatherByCityName";
    /**
     * 事件列表查询
     */
    public final static String ACTION_GETEVENTLIST = "rest/event/getEventList";
    /**
     * 风险点查询
     */
    public final static String ACTION_GETRISKPOINTBYTYPE = "rest/riskPoint/getRiskPointByType";
    /**
     * 事件上报
     */
    public final static String ACTION_ADDINFORMATIONFEEDBACK = "rest/event/addEventReported";
    /**
     * 图片根地址
     */
//    public final  static String  ACTION_FILES_ROOT="http://192.168.0.200:8091/KT_S_LinkageCommand-service/";
//  梅州演示
//    public   static String  ACTION_FILES_ROOT="http://192.168.0.110:9091/KT_S_LinkageCommand-service/";
    public static String ACTION_FILES_ROOT = "http://192.168.0.110:8082/KT_S_Attachment/";
    /**
     * 服务场所
     */
    public final static String ACTION_GETALLPLACE = "rest/place/getAllPlace";
    /**
     * 根据Id查用户
     */
    public final static String ACTION_GETUSERBYID = "rest/User/getUserById";
    /**
     * 公告查询
     */
    public final static String ACTION_NOTICE = "rest/announcement/getAnnouncementList";
    /**
     * 我接受的指令查询
     */
    public final static String ACTION_BYUSER = "rest/actionPlanDirective/getActionPlanDirectiveListByUser";
    /**
     * 改变指令状态
     */
    public final static String ACTION_UPDATESTATUS = "rest/actionPlanDirective/updateActionPlanDirectiveStatusById";
    /**
     * 上传定位信息
     */
    public final static String ACTION_GPSHISTORYTRACK = "rest/gpsHistoryTrack/add";
    /**
     * openfire 群聊上传文件
     */
    public final static String ACTION_OPENFIRE_MUCFILEUPLOAD = "http://192.168.0.200:8091/KT_S_LinkageCommand-service/rest/openFire/fileUpload";

    /**
     * 上传定位信息
     */
    public final static String ACTION_GETMESSAGESNUM = "rest/messageStatistics/getMessageStatistics";
}
