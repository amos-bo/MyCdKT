package com.ktcd.malc.kt_ma_lc.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/26.
 */

public class ItemMessgeInfo implements Serializable {
    /**
     * 消息类型
     */
    public int messgeType;
    /**
     * 消息左上角图标ID
     */
    public int messgeTypeImg;
    /**
     * 头像地址
     */
    public String imgUrl;
    /**
     * 好友名称
     */
    public String personName;
    /**
     * 群总人数
     */
    public int personAllNum;
    /**
     * 群在线人数
     */
    public int personOnlinNum;
    /**
     * 信息内容
     */
    public String textContent;
    /**
     * 信息时间
     */
    public String messgeTime;
    /**
     * 未读信息数量
     */
    public String unReadmessgeNum;
    /**
     * 是否显示红点
     */
    public boolean isCanShowRedDot;
}
