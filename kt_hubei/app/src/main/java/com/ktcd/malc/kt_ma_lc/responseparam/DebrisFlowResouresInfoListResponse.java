package com.ktcd.malc.kt_ma_lc.responseparam;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */

public class DebrisFlowResouresInfoListResponse implements Serializable {


    /**
     * total : 3
     * rows : [{"createTime":"2017-07-10 13:51:58","updateTime":"2017-07-11 11:15:02","rdfId":1,"rdfAdminiLocationCode":"123","rdfWatershedCode":"213","rdfLongitude":123,"rdfLatitude":213,"rdfWatershedArea":123,"rdfSection":"123","rdfLongitudinalSlope":123,"rdfDistance":213,"rdfPosition":"123123","rdfDataSource":"123"},{"createTime":"2017-07-11 10:25:10","updateTime":"2017-07-11 10:25:14","rdfId":224,"rdfAdminiLocationCode":"434","rdfWatershedCode":"4324","rdfLongitude":34324,"rdfLatitude":324324,"rdfLongitudinalSlope":4343434,"rdfDistance":4343434,"rdfPosition":"4343"},{"createTime":"2017-07-11 10:45:59","updateTime":"2017-07-11 11:21:57","rdfId":243,"rdfAdminiLocationCode":"123123","rdfWatershedCode":"123123","rdfLongitude":123123,"rdfLatitude":123123,"rdfLongitudinalSlope":1233333,"rdfDistance":223,"rdfPosition":"123123"}]
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
         * createTime : 2017-07-10 13:51:58
         * updateTime : 2017-07-11 11:15:02
         * rdfId : 1
         * rdfAdminiLocationCode : 123
         * rdfWatershedCode : 213
         * rdfLongitude : 123
         * rdfLatitude : 213
         * rdfWatershedArea : 123
         * rdfSection : 123
         * rdfLongitudinalSlope : 123
         * rdfDistance : 213
         * rdfPosition : 123123
         * rdfDataSource : 123
         */

        private String createTime;
        private String updateTime;
        private int rdfId;
        private String rdfAdminiLocationCode;
        private String rdfWatershedCode;
        private double rdfLongitude;
        private double rdfLatitude;
        private int rdfWatershedArea;
        private String rdfSection;
        private int rdfLongitudinalSlope;
        private int rdfDistance;
        private String rdfPosition;
        private String rdfDataSource;

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

        public int getRdfId() {
            return rdfId;
        }

        public void setRdfId(int rdfId) {
            this.rdfId = rdfId;
        }

        public String getRdfAdminiLocationCode() {
            return rdfAdminiLocationCode;
        }

        public void setRdfAdminiLocationCode(String rdfAdminiLocationCode) {
            this.rdfAdminiLocationCode = rdfAdminiLocationCode;
        }

        public String getRdfWatershedCode() {
            return rdfWatershedCode;
        }

        public void setRdfWatershedCode(String rdfWatershedCode) {
            this.rdfWatershedCode = rdfWatershedCode;
        }

        public double getRdfLongitude() {
            return rdfLongitude;
        }

        public void setRdfLongitude(int rdfLongitude) {
            this.rdfLongitude = rdfLongitude;
        }

        public double getRdfLatitude() {
            return rdfLatitude;
        }

        public void setRdfLatitude(int rdfLatitude) {
            this.rdfLatitude = rdfLatitude;
        }

        public int getRdfWatershedArea() {
            return rdfWatershedArea;
        }

        public void setRdfWatershedArea(int rdfWatershedArea) {
            this.rdfWatershedArea = rdfWatershedArea;
        }

        public String getRdfSection() {
            return rdfSection;
        }

        public void setRdfSection(String rdfSection) {
            this.rdfSection = rdfSection;
        }

        public int getRdfLongitudinalSlope() {
            return rdfLongitudinalSlope;
        }

        public void setRdfLongitudinalSlope(int rdfLongitudinalSlope) {
            this.rdfLongitudinalSlope = rdfLongitudinalSlope;
        }

        public int getRdfDistance() {
            return rdfDistance;
        }

        public void setRdfDistance(int rdfDistance) {
            this.rdfDistance = rdfDistance;
        }

        public String getRdfPosition() {
            return rdfPosition;
        }

        public void setRdfPosition(String rdfPosition) {
            this.rdfPosition = rdfPosition;
        }

        public String getRdfDataSource() {
            return rdfDataSource;
        }

        public void setRdfDataSource(String rdfDataSource) {
            this.rdfDataSource = rdfDataSource;
        }
    }
}
