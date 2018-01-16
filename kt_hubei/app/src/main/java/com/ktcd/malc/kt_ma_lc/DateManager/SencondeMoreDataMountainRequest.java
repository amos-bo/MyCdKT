package com.ktcd.malc.kt_ma_lc.DateManager;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/11/13.
 */

public class SencondeMoreDataMountainRequest implements Serializable{

    /**
     * lon : 116.0408456
     * lat : 24.4457157
     * data : [{"thresholdWater":1,"waterlevel":1,"hour":6,"threshold":66.1},{"thresholdWater":1,"waterlevel":1,"hour":3,"threshold":54.5},{"thresholdWater":1,"waterlevel":1,"hour":12,"threshold":79.3}]
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
         * thresholdWater : 1
         * waterlevel : 1
         * hour : 6
         * threshold : 66.1
         */

        private int thresholdWater;
        private int waterlevel;
        private int hour;
        private double threshold;

        public int getThresholdWater() {
            return thresholdWater;
        }

        public void setThresholdWater(int thresholdWater) {
            this.thresholdWater = thresholdWater;
        }

        public int getWaterlevel() {
            return waterlevel;
        }

        public void setWaterlevel(int waterlevel) {
            this.waterlevel = waterlevel;
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
