package com.ktcd.malc.kt_ma_lc.bean;

import com.baidu.mapapi.model.LatLng;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/10/18.
 */

public class MapResourcePoitinfo implements Serializable {

    /**
     * createTime : null
     * createUser : null
     * updateTime : null
     * updateUser : null
     * id : 8ADFE8C5D6B24E1DA04D4C0A6F82EE78
     * title : 标题XXXXX
     * longitude : 116.219924
     * latitude : 24.659464
     * areaCode : area_code
     * departmentCode : department_code
     * category : risk_point
     * subclass : smallRiver
     * createUserid : 990BBF33C198478DA41560E8129A40DF
     * creatTime : 1508218991000
     * updateUserid : null
     * contactName : null
     * contactTelephone : null
     * contactMobilePhone : null
     * responsibleName : null
     * responsibleTelephone : null
     * responsibleMobilePhone : null
     */

    private Object createTime;
    private Object createUser;
    private Object updateTime;
    private Object updateUser;
    private String id;
    private String title;
    private double longitude;
    private double latitude;
    private String areaCode;
    private String departmentCode;
    private String category;
    private String subclass;
    private String createUserid;
    private long creatTime;
    private Object updateUserid;
    private Object contactName;
    private Object contactTelephone;
    private Object contactMobilePhone;
    private Object responsibleName;
    private Object responsibleTelephone;
    private Object responsibleMobilePhone;

    public TypeData typeData=new TypeData();

    public Object getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Object createTime) {
        this.createTime = createTime;
    }

    public Object getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Object createUser) {
        this.createUser = createUser;
    }

    public Object getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Object updateTime) {
        this.updateTime = updateTime;
    }

    public Object getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Object updateUser) {
        this.updateUser = updateUser;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubclass() {
        return subclass;
    }

    public void setSubclass(String subclass) {
        this.subclass = subclass;
    }

    public String getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(String createUserid) {
        this.createUserid = createUserid;
    }

    public long getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(long creatTime) {
        this.creatTime = creatTime;
    }

    public Object getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Object updateUserid) {
        this.updateUserid = updateUserid;
    }

    public Object getContactName() {
        return contactName;
    }

    public void setContactName(Object contactName) {
        this.contactName = contactName;
    }

    public Object getContactTelephone() {
        return contactTelephone;
    }

    public void setContactTelephone(Object contactTelephone) {
        this.contactTelephone = contactTelephone;
    }

    public Object getContactMobilePhone() {
        return contactMobilePhone;
    }

    public void setContactMobilePhone(Object contactMobilePhone) {
        this.contactMobilePhone = contactMobilePhone;
    }

    public Object getResponsibleName() {
        return responsibleName;
    }

    public void setResponsibleName(Object responsibleName) {
        this.responsibleName = responsibleName;
    }

    public Object getResponsibleTelephone() {
        return responsibleTelephone;
    }

    public void setResponsibleTelephone(Object responsibleTelephone) {
        this.responsibleTelephone = responsibleTelephone;
    }

    public Object getResponsibleMobilePhone() {
        return responsibleMobilePhone;
    }

    public void setResponsibleMobilePhone(Object responsibleMobilePhone) {
        this.responsibleMobilePhone = responsibleMobilePhone;
    }

    public  class TypeData implements Serializable{
        public String name;
        public LatLng latLng;
        public String Id;
        public int ImageType;//图片id
        public int PointType;//大类:1、人员、2风险点、3场所
        public int subType;//小类: 1subside崩塌2collapse塌陷3landslide
        // 滑坡4smallRiver中小河流5floods山洪沟6debrisFlow泥石流
        // 7医院8避难所
    }
}
