package com.ktcd.malc.kt_ma_lc.responseparam;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */

public class LandslideResouresInfoListResponse implements Serializable{
    /**
     * total : 104
     * rows : [{"updateTime":"2017-06-12 09:24:11","rlId":1,"rlCode":"6","rlCounty":"梅县区","rlCountry":"白渡","rlVillage":"凤岭","rlGroup":"昌楼下","rlLongitude":116.1451,"rlLatitude":24.322,"rlScale":"小型","rlThreatenPopulation":55,"rlThreatenProperty":27.1,"rlMonitor":"刘永旺","rlMonitorTel":"2673173","rlMonitorPhone":"13549116566","rlMonitorResponsible":"刘建元","rlMonitorRTel":"2673823","rlMonitorRPhone":"13902781782","rlPotentialHarm":"中型","rlGeologicalConditions":"丘陵地貌、第四系、复合土质","rlDeformationCharacteristics":"未变形","rlStabilityAnalysis":"差","rlTriggeringFactor":"持续强降雨","rlMonitoringMethod":"目视检查、监测","rlSuggest":"遇持续强降雨、应避让、搬迁","rlAlarmMethod":"鸣锣报警","rlDisasterLocation":"到村委会安置","rlEvacuationRoute":"往左边走"},{"updateTime":"2017-06-12 09:24:20","rlId":2,"rlCode":"8","rlCounty":"梅县区","rlCountry":"白渡","rlVillage":"悦来","rlGroup":"大陂","rlLongitude":116.1141,"rlLatitude":24.2643,"rlScale":"小型","rlThreatenPopulation":194,"rlThreatenProperty":309,"rlMonitor":"钟仁勇","rlMonitorTel":"2672422","rlMonitorPhone":"13543206248","rlMonitorResponsible":"李洁清","rlMonitorRPhone":"13923013693","rlPotentialHarm":"中型","rlGeologicalConditions":"丘陵地貌、第四系、土质","rlDeformationCharacteristics":"未变形","rlStabilityAnalysis":"差","rlTriggeringFactor":"持续强降雨","rlMonitoringMethod":"目视检查、监测","rlSuggest":"遇持续强降雨、应避让、搬迁","rlAlarmMethod":"鸣锣报警","rlDisasterLocation":"到村委会安置","rlEvacuationRoute":"往右边走","rlRemarks":"百人点"},{"updateTime":"2017-06-12 09:24:38","rlId":3,"rlCode":"11","rlCounty":"梅县区","rlCountry":"白渡","rlVillage":"瓜洲","rlLongitude":116.1215,"rlLatitude":24.2755,"rlScale":"小型","rlThreatenPopulation":6,"rlThreatenProperty":4.5,"rlMonitor":"蔡顺英","rlMonitorTel":"2678910","rlMonitorPhone":"13823887531","rlMonitorResponsible":"李勇华","rlMonitorRPhone":"13823800483","rlPotentialHarm":"小型","rlGeologicalConditions":"丘陵地貌、第四系、土质","rlDeformationCharacteristics":"未变形","rlStabilityAnalysis":"差","rlTriggeringFactor":"持续强降雨","rlMonitoringMethod":"目视检查、监测","rlSuggest":"遇持续强降雨、应避让、搬迁","rlAlarmMethod":"鸣锣报警","rlDisasterLocation":"到亲戚家","rlEvacuationRoute":"往右边走"},{"rlId":4,"rlCode":"17","rlCounty":"梅县区","rlCountry":"白渡","rlVillage":"公珠","rlGroup":"背山","rlLongitude":116.1503,"rlLatitude":24.3139,"rlScale":"小型","rlThreatenPopulation":4,"rlThreatenProperty":4,"rlMonitor":"谢建平","rlMonitorTel":"2673397","rlMonitorPhone":"13823894208","rlMonitorResponsible":"谢文忠","rlMonitorRTel":"2211287","rlMonitorRPhone":"13923030255","rlPotentialHarm":"小型","rlGeologicalConditions":"丘陵地貌、花岗岩强风化土","rlDeformationCharacteristics":"未变形","rlStabilityAnalysis":"差","rlTriggeringFactor":"持续强降雨","rlMonitoringMethod":"目视检查、监测","rlSuggest":"遇持续强降雨、应避让、搬迁","rlAlarmMethod":"鸣锣报警","rlDisasterLocation":"到村委会安置","rlEvacuationRoute":"往右边走"}]
     */

    private int total;
    private List<RowsBean> rows;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<RowsBean> getRows() {
        return rows;
    }

    public void setRows(List<RowsBean> rows) {
        this.rows = rows;
    }

    public static class RowsBean {
        /**
         * updateTime : 2017-06-12 09:24:11
         * rlId : 1
         * rlCode : 6
         * rlCounty : 梅县区
         * rlCountry : 白渡
         * rlVillage : 凤岭
         * rlGroup : 昌楼下
         * rlLongitude : 116.1451
         * rlLatitude : 24.322
         * rlScale : 小型
         * rlThreatenPopulation : 55
         * rlThreatenProperty : 27.1
         * rlMonitor : 刘永旺
         * rlMonitorTel : 2673173
         * rlMonitorPhone : 13549116566
         * rlMonitorResponsible : 刘建元
         * rlMonitorRTel : 2673823
         * rlMonitorRPhone : 13902781782
         * rlPotentialHarm : 中型
         * rlGeologicalConditions : 丘陵地貌、第四系、复合土质
         * rlDeformationCharacteristics : 未变形
         * rlStabilityAnalysis : 差
         * rlTriggeringFactor : 持续强降雨
         * rlMonitoringMethod : 目视检查、监测
         * rlSuggest : 遇持续强降雨、应避让、搬迁
         * rlAlarmMethod : 鸣锣报警
         * rlDisasterLocation : 到村委会安置
         * rlEvacuationRoute : 往左边走
         * rlRemarks : 百人点
         */

        private String updateTime;
        private int rlId;
        private String rlCode;
        private String rlCounty;
        private String rlCountry;
        private String rlVillage;
        private String rlGroup;
        private double rlLongitude;
        private double rlLatitude;
        private String rlScale;
        private int rlThreatenPopulation;
        private double rlThreatenProperty;
        private String rlMonitor;
        private String rlMonitorTel;
        private String rlMonitorPhone;
        private String rlMonitorResponsible;
        private String rlMonitorRTel;
        private String rlMonitorRPhone;
        private String rlPotentialHarm;
        private String rlGeologicalConditions;
        private String rlDeformationCharacteristics;
        private String rlStabilityAnalysis;
        private String rlTriggeringFactor;
        private String rlMonitoringMethod;
        private String rlSuggest;
        private String rlAlarmMethod;
        private String rlDisasterLocation;
        private String rlEvacuationRoute;
        private String rlRemarks;

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }

        public int getRlId() {
            return rlId;
        }

        public void setRlId(int rlId) {
            this.rlId = rlId;
        }

        public String getRlCode() {
            return rlCode;
        }

        public void setRlCode(String rlCode) {
            this.rlCode = rlCode;
        }

        public String getRlCounty() {
            return rlCounty;
        }

        public void setRlCounty(String rlCounty) {
            this.rlCounty = rlCounty;
        }

        public String getRlCountry() {
            return rlCountry;
        }

        public void setRlCountry(String rlCountry) {
            this.rlCountry = rlCountry;
        }

        public String getRlVillage() {
            return rlVillage;
        }

        public void setRlVillage(String rlVillage) {
            this.rlVillage = rlVillage;
        }

        public String getRlGroup() {
            return rlGroup;
        }

        public void setRlGroup(String rlGroup) {
            this.rlGroup = rlGroup;
        }

        public double getRlLongitude() {
            return rlLongitude;
        }

        public void setRlLongitude(double rlLongitude) {
            this.rlLongitude = rlLongitude;
        }

        public double getRlLatitude() {
            return rlLatitude;
        }

        public void setRlLatitude(double rlLatitude) {
            this.rlLatitude = rlLatitude;
        }

        public String getRlScale() {
            return rlScale;
        }

        public void setRlScale(String rlScale) {
            this.rlScale = rlScale;
        }

        public int getRlThreatenPopulation() {
            return rlThreatenPopulation;
        }

        public void setRlThreatenPopulation(int rlThreatenPopulation) {
            this.rlThreatenPopulation = rlThreatenPopulation;
        }

        public double getRlThreatenProperty() {
            return rlThreatenProperty;
        }

        public void setRlThreatenProperty(double rlThreatenProperty) {
            this.rlThreatenProperty = rlThreatenProperty;
        }

        public String getRlMonitor() {
            return rlMonitor;
        }

        public void setRlMonitor(String rlMonitor) {
            this.rlMonitor = rlMonitor;
        }

        public String getRlMonitorTel() {
            return rlMonitorTel;
        }

        public void setRlMonitorTel(String rlMonitorTel) {
            this.rlMonitorTel = rlMonitorTel;
        }

        public String getRlMonitorPhone() {
            return rlMonitorPhone;
        }

        public void setRlMonitorPhone(String rlMonitorPhone) {
            this.rlMonitorPhone = rlMonitorPhone;
        }

        public String getRlMonitorResponsible() {
            return rlMonitorResponsible;
        }

        public void setRlMonitorResponsible(String rlMonitorResponsible) {
            this.rlMonitorResponsible = rlMonitorResponsible;
        }

        public String getRlMonitorRTel() {
            return rlMonitorRTel;
        }

        public void setRlMonitorRTel(String rlMonitorRTel) {
            this.rlMonitorRTel = rlMonitorRTel;
        }

        public String getRlMonitorRPhone() {
            return rlMonitorRPhone;
        }

        public void setRlMonitorRPhone(String rlMonitorRPhone) {
            this.rlMonitorRPhone = rlMonitorRPhone;
        }

        public String getRlPotentialHarm() {
            return rlPotentialHarm;
        }

        public void setRlPotentialHarm(String rlPotentialHarm) {
            this.rlPotentialHarm = rlPotentialHarm;
        }

        public String getRlGeologicalConditions() {
            return rlGeologicalConditions;
        }

        public void setRlGeologicalConditions(String rlGeologicalConditions) {
            this.rlGeologicalConditions = rlGeologicalConditions;
        }

        public String getRlDeformationCharacteristics() {
            return rlDeformationCharacteristics;
        }

        public void setRlDeformationCharacteristics(String rlDeformationCharacteristics) {
            this.rlDeformationCharacteristics = rlDeformationCharacteristics;
        }

        public String getRlStabilityAnalysis() {
            return rlStabilityAnalysis;
        }

        public void setRlStabilityAnalysis(String rlStabilityAnalysis) {
            this.rlStabilityAnalysis = rlStabilityAnalysis;
        }

        public String getRlTriggeringFactor() {
            return rlTriggeringFactor;
        }

        public void setRlTriggeringFactor(String rlTriggeringFactor) {
            this.rlTriggeringFactor = rlTriggeringFactor;
        }

        public String getRlMonitoringMethod() {
            return rlMonitoringMethod;
        }

        public void setRlMonitoringMethod(String rlMonitoringMethod) {
            this.rlMonitoringMethod = rlMonitoringMethod;
        }

        public String getRlSuggest() {
            return rlSuggest;
        }

        public void setRlSuggest(String rlSuggest) {
            this.rlSuggest = rlSuggest;
        }

        public String getRlAlarmMethod() {
            return rlAlarmMethod;
        }

        public void setRlAlarmMethod(String rlAlarmMethod) {
            this.rlAlarmMethod = rlAlarmMethod;
        }

        public String getRlDisasterLocation() {
            return rlDisasterLocation;
        }

        public void setRlDisasterLocation(String rlDisasterLocation) {
            this.rlDisasterLocation = rlDisasterLocation;
        }

        public String getRlEvacuationRoute() {
            return rlEvacuationRoute;
        }

        public void setRlEvacuationRoute(String rlEvacuationRoute) {
            this.rlEvacuationRoute = rlEvacuationRoute;
        }

        public String getRlRemarks() {
            return rlRemarks;
        }

        public void setRlRemarks(String rlRemarks) {
            this.rlRemarks = rlRemarks;
        }
    }
}
