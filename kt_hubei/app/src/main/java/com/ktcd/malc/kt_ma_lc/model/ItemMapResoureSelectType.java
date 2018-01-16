package com.ktcd.malc.kt_ma_lc.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/6/26.
 */

public class ItemMapResoureSelectType implements Serializable {
    /**
     * id : 30D187B26FE5420F90281303DC39F167
     * name : 塌陷
     * type : risk_point
     * basicDataDerviceCode : subside
     * orderNo : 1
     * description : 塌陷
     * deleted : false
     */

    /**
     * 类型
     */
    public int Type;

    //    是否选中
    public boolean isSelected;


    private String id;
    private String name;
    private String type;
    private String basicDataDerviceCode;
    private int orderNo;
    private String description;
    private boolean deleted;

    public  String dictCode;
    public  String parentDictionary;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBasicDataDerviceCode() {
        return basicDataDerviceCode;
    }

    public void setBasicDataDerviceCode(String basicDataDerviceCode) {
        this.basicDataDerviceCode = basicDataDerviceCode;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
