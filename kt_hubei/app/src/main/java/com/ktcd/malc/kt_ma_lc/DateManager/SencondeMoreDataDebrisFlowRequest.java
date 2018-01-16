package com.ktcd.malc.kt_ma_lc.DateManager;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/11/13.
 */

public class SencondeMoreDataDebrisFlowRequest implements Serializable{


    /**
     * lon : 116.0274866
     * lat : 24.7702707
     * data : [{"day":5,"daythreshold":215,"hour":24,"threshold":164.8},{"day":5,"daythreshold":215,"hour":6,"threshold":128.6},{"day":5,"daythreshold":215,"hour":12,"threshold":145.6},{"day":5,"daythreshold":215,"hour":3,"threshold":113.7},{"day":5,"daythreshold":215,"hour":1,"threshold":93.4}]
     */

    private String lon;
    private String lat;
    public List<DataBean> data;

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * day : 5
         * daythreshold : 215
         * hour : 24
         * threshold : 164.8
         */

        private int day;
        private int daythreshold;
        private int hour;
        private double threshold;

        public int getDay() {
            return day;
        }

        public void setDay(int day) {
            this.day = day;
        }

        public int getDaythreshold() {
            return daythreshold;
        }

        public void setDaythreshold(int daythreshold) {
            this.daythreshold = daythreshold;
        }

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public double getThreshold() {
            return threshold;
        }

        public void setThreshold(double threshold) {
            this.threshold = threshold;
        }
    }
}
