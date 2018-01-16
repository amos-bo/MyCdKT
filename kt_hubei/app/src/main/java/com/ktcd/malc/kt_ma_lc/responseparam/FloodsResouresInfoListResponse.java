package com.ktcd.malc.kt_ma_lc.responseparam;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */

public class FloodsResouresInfoListResponse implements Serializable {
    /**
     * total : 1
     * rows : [{"createTime":"2017-07-10 13:52:55","updateTime":"2017-07-10 18:12:54","rffId":1,"rffCode":"123","rffSmallRiverCode":"213","rffWatershedArea":"123","rffLength":123,"rffWidth":123,"rffDepth":123,"rffFrequency":"1233","rffLongitude":123,"rffLatitude":123,"rffAltitude":1,"rffDataSource":"123","rffRemark":"123"}]
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
         * createTime : 2017-07-10 13:52:55
         * updateTime : 2017-07-10 18:12:54
         * rffId : 1
         * rffCode : 123
         * rffSmallRiverCode : 213
         * rffWatershedArea : 123
         * rffLength : 123
         * rffWidth : 123
         * rffDepth : 123
         * rffFrequency : 1233
         * rffLongitude : 123
         * rffLatitude : 123
         * rffAltitude : 1
         * rffDataSource : 123
         * rffRemark : 123
         */

        private String createTime;
        private String updateTime;
        private int rffId;
        private String rffCode;
        private String rffSmallRiverCode;
        private String rffWatershedArea;
        private double rffLength;
        private double rffWidth;
        private double rffDepth;
        private String rffFrequency;
        private double rffLongitude;
        private double rffLatitude;
        private int rffAltitude;
        private String rffDataSource;
        private String rffRemark;

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

        public int getRffId() {
            return rffId;
        }

        public void setRffId(int rffId) {
            this.rffId = rffId;
        }

        public String getRffCode() {
            return rffCode;
        }

        public void setRffCode(String rffCode) {
            this.rffCode = rffCode;
        }

        public String getRffSmallRiverCode() {
            return rffSmallRiverCode;
        }

        public void setRffSmallRiverCode(String rffSmallRiverCode) {
            this.rffSmallRiverCode = rffSmallRiverCode;
        }

        public String getRffWatershedArea() {
            return rffWatershedArea;
        }

        public void setRffWatershedArea(String rffWatershedArea) {
            this.rffWatershedArea = rffWatershedArea;
        }

        public double getRffLength() {
            return rffLength;
        }

        public void setRffLength(int rffLength) {
            this.rffLength = rffLength;
        }

        public double getRffWidth() {
            return rffWidth;
        }

        public void setRffWidth(int rffWidth) {
            this.rffWidth = rffWidth;
        }

        public double getRffDepth() {
            return rffDepth;
        }

        public void setRffDepth(int rffDepth) {
            this.rffDepth = rffDepth;
        }

        public String getRffFrequency() {
            return rffFrequency;
        }

        public void setRffFrequency(String rffFrequency) {
            this.rffFrequency = rffFrequency;
        }

        public double getRffLongitude() {
            return rffLongitude;
        }

        public void setRffLongitude(int rffLongitude) {
            this.rffLongitude = rffLongitude;
        }

        public double getRffLatitude() {
            return rffLatitude;
        }

        public void setRffLatitude(int rffLatitude) {
            this.rffLatitude = rffLatitude;
        }

        public int getRffAltitude() {
            return rffAltitude;
        }

        public void setRffAltitude(int rffAltitude) {
            this.rffAltitude = rffAltitude;
        }

        public String getRffDataSource() {
            return rffDataSource;
        }

        public void setRffDataSource(String rffDataSource) {
            this.rffDataSource = rffDataSource;
        }

        public String getRffRemark() {
            return rffRemark;
        }

        public void setRffRemark(String rffRemark) {
            this.rffRemark = rffRemark;
        }
    }
}
