package com.ktcd.malc.kt_ma_lc.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/26.
 */

public class ItemHomeTypeInfo  implements Serializable{

//  1  subside 塌陷
//  2  collapse 崩塌
//  3  landslide 滑坡
//  4  smallRiver 中小河流
//  5  floods 山洪沟
//  6 debrisFlow 泥石流

    /**图片Id*/
    public int drawAbleId;
    /**模块名字*/
    public String TypeName;
    /**对应字段*/
    public String TypeRequest;

    public boolean isSelected;
}
