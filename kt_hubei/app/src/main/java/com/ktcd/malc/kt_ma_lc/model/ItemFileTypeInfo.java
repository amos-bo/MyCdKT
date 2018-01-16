package com.ktcd.malc.kt_ma_lc.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/26.
 * 事件-进度
 */

public class ItemFileTypeInfo implements Serializable {
    /**
     * 文件类型：3语音、2视频、1图片
     */
    public int Type;
    /**
     * 文件地址
     */
    public String pathUrl;
    /**
     * 视频首帧 地址
     */
    public String lowPath;
}
