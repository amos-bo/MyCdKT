package com.ktcd.malc.kt_ma_lc.DateManager;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/11/13.
 */

public class SencondeMoreDataLandsSlide implements Serializable{

    private String lon;
    private String lat;
    public List<SencondeMoreDataLandsSlide.DataBean> data;

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

    public List<SencondeMoreDataLandsSlide.DataBean> getData() {
        return data;
    }

    public void setData(List<SencondeMoreDataLandsSlide.DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * thresholdwater : 4.87
         * basiclevel : 3.85
         * hour : 24
         * threshold : 80
         */

        private String day;
        private String daythreshold;
        private String hour;
        private String threshold;


        public String getDay() {
            return day;
        }

        public void setDay(String day) {
            this.day = day;
        }

        public String getDaythreshold() {
            return daythreshold;
        }

        public void setDaythreshold(String daythreshold) {
            this.daythreshold = daythreshold;
        }

        public String getHour() {
            return hour;
        }

        public void setHour(String hour) {
            this.hour = hour;
        }

        public String getThreshold() {
            return threshold;
        }

        public void setThreshold(String threshold) {
            this.threshold = threshold;
        }
    }
}
