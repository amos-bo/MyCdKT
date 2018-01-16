package com.ktcd.malc.kt_ma_lc.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/11.
 */

public class ItemResouresInfo implements Serializable {

    /**
     * createTime : 2017-07-10 15:28:15
     * updateTime : 2017-06-12 09:46:23
     * rsId : 1
     * rsCode : 1
     * rsCounty : 梅县区
     * rsCountry : 白渡
     * rsVillage : 悦一
     * rsGroup : 坡下
     * rsLongitude : 116.1048
     * rsLatitude : 24.2705
     * rsScale : 小型
     * rsThreatenPopulation : 5
     * rsThreatenProperty : 10.9
     * rsMonitor : 古新生
     * rsMonitorTel : 2678455
     * rsMonitorPhone : 13431807132
     * rsMonitorResponsible : 古文忠
     * rsMonitorRPhone : 13723638077
     * rsPotentialHarm : 小型
     * rsGeologicalConditions : 混合岩质
     * rsDeformationCharacteristics : 未变形
     * rsStabilityAnalysis : 差
     * rsTriggeringFactor : 地下水位变化
     * rsMonitoringMethod : 目视检查、监测
     * rsSuggest : 工程治理
     * rsAlarmMethod : 鸣锣报警
     * rsDisasterLocation : 到村委会安置
     * rsEvacuationRoute : 往左边走
     * rsMonitorRTel : 2670578
     * rsRemarks : 百人点
     */

    private String createTime;
    private String updateTime;
    private int rsId;
    private String rsCode;
    private String rsCounty;
    private String rsCountry;
    private String rsVillage;
    private String rsGroup;
    private double rsLongitude;
    private double rsLatitude;
    private String rsScale;
    private int rsThreatenPopulation;
    private double rsThreatenProperty;
    private String rsMonitor;
    private String rsMonitorTel;
    private String rsMonitorPhone;
    private String rsMonitorResponsible;
    private String rsMonitorRPhone;
    private String rsPotentialHarm;
    private String rsGeologicalConditions;
    private String rsDeformationCharacteristics;
    private String rsStabilityAnalysis;
    private String rsTriggeringFactor;
    private String rsMonitoringMethod;
    private String rsSuggest;
    private String rsAlarmMethod;
    private String rsDisasterLocation;
    private String rsEvacuationRoute;
    private String rsMonitorRTel;
    private String rsRemarks;

    private int rsTypr;//灾害点类型

    public int getrsTypr() {
        return rsTypr;
    }

    public void setrsTypr(int rsTypr) {
        this.rsTypr = rsTypr;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getRsId() {
        return rsId;
    }

    public void setRsId(int rsId) {
        this.rsId = rsId;
    }

    public String getRsCode() {
        return rsCode;
    }

    public void setRsCode(String rsCode) {
        this.rsCode = rsCode;
    }

    public String getRsCounty() {
        return rsCounty;
    }

    public void setRsCounty(String rsCounty) {
        this.rsCounty = rsCounty;
    }

    public String getRsCountry() {
        return rsCountry;
    }

    public void setRsCountry(String rsCountry) {
        this.rsCountry = rsCountry;
    }

    public String getRsVillage() {
        return rsVillage;
    }

    public void setRsVillage(String rsVillage) {
        this.rsVillage = rsVillage;
    }

    public String getRsGroup() {
        return rsGroup;
    }

    public void setRsGroup(String rsGroup) {
        this.rsGroup = rsGroup;
    }

    public double getRsLongitude() {
        return rsLongitude;
    }

    public void setRsLongitude(double rsLongitude) {
        this.rsLongitude = rsLongitude;
    }

    public double getRsLatitude() {
        return rsLatitude;
    }

    public void setRsLatitude(double rsLatitude) {
        this.rsLatitude = rsLatitude;
    }

    public String getRsScale() {
        return rsScale;
    }

    public void setRsScale(String rsScale) {
        this.rsScale = rsScale;
    }

    public int getRsThreatenPopulation() {
        return rsThreatenPopulation;
    }

    public void setRsThreatenPopulation(int rsThreatenPopulation) {
        this.rsThreatenPopulation = rsThreatenPopulation;
    }

    public double getRsThreatenProperty() {
        return rsThreatenProperty;
    }

    public void setRsThreatenProperty(double rsThreatenProperty) {
        this.rsThreatenProperty = rsThreatenProperty;
    }

    public String getRsMonitor() {
        return rsMonitor;
    }

    public void setRsMonitor(String rsMonitor) {
        this.rsMonitor = rsMonitor;
    }

    public String getRsMonitorTel() {
        return rsMonitorTel;
    }

    public void setRsMonitorTel(String rsMonitorTel) {
        this.rsMonitorTel = rsMonitorTel;
    }

    public String getRsMonitorPhone() {
        return rsMonitorPhone;
    }

    public void setRsMonitorPhone(String rsMonitorPhone) {
        this.rsMonitorPhone = rsMonitorPhone;
    }

    public String getRsMonitorResponsible() {
        return rsMonitorResponsible;
    }

    public void setRsMonitorResponsible(String rsMonitorResponsible) {
        this.rsMonitorResponsible = rsMonitorResponsible;
    }

    public String getRsMonitorRPhone() {
        return rsMonitorRPhone;
    }

    public void setRsMonitorRPhone(String rsMonitorRPhone) {
        this.rsMonitorRPhone = rsMonitorRPhone;
    }

    public String getRsPotentialHarm() {
        return rsPotentialHarm;
    }

    public void setRsPotentialHarm(String rsPotentialHarm) {
        this.rsPotentialHarm = rsPotentialHarm;
    }

    public String getRsGeologicalConditions() {
        return rsGeologicalConditions;
    }

    public void setRsGeologicalConditions(String rsGeologicalConditions) {
        this.rsGeologicalConditions = rsGeologicalConditions;
    }

    public String getRsDeformationCharacteristics() {
        return rsDeformationCharacteristics;
    }

    public void setRsDeformationCharacteristics(String rsDeformationCharacteristics) {
        this.rsDeformationCharacteristics = rsDeformationCharacteristics;
    }

    public String getRsStabilityAnalysis() {
        return rsStabilityAnalysis;
    }

    public void setRsStabilityAnalysis(String rsStabilityAnalysis) {
        this.rsStabilityAnalysis = rsStabilityAnalysis;
    }

    public String getRsTriggeringFactor() {
        return rsTriggeringFactor;
    }

    public void setRsTriggeringFactor(String rsTriggeringFactor) {
        this.rsTriggeringFactor = rsTriggeringFactor;
    }

    public String getRsMonitoringMethod() {
        return rsMonitoringMethod;
    }

    public void setRsMonitoringMethod(String rsMonitoringMethod) {
        this.rsMonitoringMethod = rsMonitoringMethod;
    }

    public String getRsSuggest() {
        return rsSuggest;
    }

    public void setRsSuggest(String rsSuggest) {
        this.rsSuggest = rsSuggest;
    }

    public String getRsAlarmMethod() {
        return rsAlarmMethod;
    }

    public void setRsAlarmMethod(String rsAlarmMethod) {
        this.rsAlarmMethod = rsAlarmMethod;
    }

    public String getRsDisasterLocation() {
        return rsDisasterLocation;
    }

    public void setRsDisasterLocation(String rsDisasterLocation) {
        this.rsDisasterLocation = rsDisasterLocation;
    }

    public String getRsEvacuationRoute() {
        return rsEvacuationRoute;
    }

    public void setRsEvacuationRoute(String rsEvacuationRoute) {
        this.rsEvacuationRoute = rsEvacuationRoute;
    }

    public String getRsMonitorRTel() {
        return rsMonitorRTel;
    }

    public void setRsMonitorRTel(String rsMonitorRTel) {
        this.rsMonitorRTel = rsMonitorRTel;
    }

    public String getRsRemarks() {
        return rsRemarks;
    }

    public void setRsRemarks(String rsRemarks) {
        this.rsRemarks = rsRemarks;
    }
}
