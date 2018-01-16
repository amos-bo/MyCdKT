package com.ktcd.malc.kt_ma_lc.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/26.
 */

public class SelectPersonInfo implements Serializable {
    /**
     * 是否被选中
     */
    public boolean isSelected;
    /**
     * 图片url
     */
    public String imgUrl;
    /**
     * 人员姓名
     */
    public String name;
    /**
     * 状态
     */
    public String state;
    /**
     * 用户id
     */
    public String jid;
}
