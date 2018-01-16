package com.ktcd.malc.kt_ma_lc.responseparam;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */

public class SmallRiverResouresInfoListResponse implements Serializable {

    /**
     * total : 2
     * rows : [{"createTime":"2017-07-10 13:54:20","updateTime":"2017-07-10 13:54:22","rmrId":1,"rmrCode":"1","rmrArea":"1","rmrPopulation":"1","rmrEstuaryLatitude":1,"rmrEstuaryAltitude":1,"rmrCrossBorder":"1","rmrRiverSourcePosition":"1","rmrRiverSourceLongitude":1,"rmrRiverSourceLatitude":1,"rmrBucklePosition":"1","rmrRiverSourceAltitude":"1","rmrStationName":"1","rmrDataSource":"1","rmrRemark":"1"}]
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
         * createTime : 2017-07-10 13:54:20
         * updateTime : 2017-07-10 13:54:22
         * rmrId : 1
         * rmrCode : 1
         * rmrArea : 1
         * rmrPopulation : 1
         * rmrEstuaryLatitude : 1.0
         * rmrEstuaryAltitude : 1
         * rmrCrossBorder : 1
         * rmrRiverSourcePosition : 1
         * rmrRiverSourceLongitude : 1.0
         * rmrRiverSourceLatitude : 1.0
         * rmrBucklePosition : 1
         * rmrRiverSourceAltitude : 1
         * rmrStationName : 1
         * rmrDataSource : 1
         * rmrRemark : 1
         */

        private String createTime;
        private String updateTime;
        private int rmrId;
        private String rmrCode;
        private String rmrArea;
        private String rmrPopulation;
        private double rmrEstuaryLatitude;
        private int rmrEstuaryAltitude;
        private String rmrCrossBorder;
        private String rmrRiverSourcePosition;
        private double rmrRiverSourceLongitude;
        private double rmrRiverSourceLatitude;
        private String rmrBucklePosition;
        private String rmrRiverSourceAltitude;
        private String rmrStationName;
        private String rmrDataSource;
        private String rmrRemark;

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

        public int getRmrId() {
            return rmrId;
        }

        public void setRmrId(int rmrId) {
            this.rmrId = rmrId;
        }

        public String getRmrCode() {
            return rmrCode;
        }

        public void setRmrCode(String rmrCode) {
            this.rmrCode = rmrCode;
        }

        public String getRmrArea() {
            return rmrArea;
        }

        public void setRmrArea(String rmrArea) {
            this.rmrArea = rmrArea;
        }

        public String getRmrPopulation() {
            return rmrPopulation;
        }

        public void setRmrPopulation(String rmrPopulation) {
            this.rmrPopulation = rmrPopulation;
        }

        public double getRmrEstuaryLatitude() {
            return rmrEstuaryLatitude;
        }

        public void setRmrEstuaryLatitude(double rmrEstuaryLatitude) {
            this.rmrEstuaryLatitude = rmrEstuaryLatitude;
        }

        public int getRmrEstuaryAltitude() {
            return rmrEstuaryAltitude;
        }

        public void setRmrEstuaryAltitude(int rmrEstuaryAltitude) {
            this.rmrEstuaryAltitude = rmrEstuaryAltitude;
        }

        public String getRmrCrossBorder() {
            return rmrCrossBorder;
        }

        public void setRmrCrossBorder(String rmrCrossBorder) {
            this.rmrCrossBorder = rmrCrossBorder;
        }

        public String getRmrRiverSourcePosition() {
            return rmrRiverSourcePosition;
        }

        public void setRmrRiverSourcePosition(String rmrRiverSourcePosition) {
            this.rmrRiverSourcePosition = rmrRiverSourcePosition;
        }

        public double getRmrRiverSourceLongitude() {
            return rmrRiverSourceLongitude;
        }

        public void setRmrRiverSourceLongitude(double rmrRiverSourceLongitude) {
            this.rmrRiverSourceLongitude = rmrRiverSourceLongitude;
        }

        public double getRmrRiverSourceLatitude() {
            return rmrRiverSourceLatitude;
        }

        public void setRmrRiverSourceLatitude(double rmrRiverSourceLatitude) {
            this.rmrRiverSourceLatitude = rmrRiverSourceLatitude;
        }

        public String getRmrBucklePosition() {
            return rmrBucklePosition;
        }

        public void setRmrBucklePosition(String rmrBucklePosition) {
            this.rmrBucklePosition = rmrBucklePosition;
        }

        public String getRmrRiverSourceAltitude() {
            return rmrRiverSourceAltitude;
        }

        public void setRmrRiverSourceAltitude(String rmrRiverSourceAltitude) {
            this.rmrRiverSourceAltitude = rmrRiverSourceAltitude;
        }

        public String getRmrStationName() {
            return rmrStationName;
        }

        public void setRmrStationName(String rmrStationName) {
            this.rmrStationName = rmrStationName;
        }

        public String getRmrDataSource() {
            return rmrDataSource;
        }

        public void setRmrDataSource(String rmrDataSource) {
            this.rmrDataSource = rmrDataSource;
        }

        public String getRmrRemark() {
            return rmrRemark;
        }

        public void setRmrRemark(String rmrRemark) {
            this.rmrRemark = rmrRemark;
        }
    }
}
