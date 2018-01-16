package com.ktcd.malc.kt_ma_lc.DateManager;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/11/13.
 */

public class SencondMoreDataRevierRequest {
    /**
     * lon : 116.0862882
     * lat : 24.601873
     * data : [{"thresholdwater":4.87,"basiclevel":3.85,"hour":24,"threshold":80},{"thresholdwater":5.14,"basiclevel":3.85,"hour":24,"threshold":102},{"thresholdwater":5.4,"basiclevel":3.85,"hour":24,"threshold":123}]
     */

    private String lon;
    private String lat;
    public List<SencondMoreDataRevierRequest.DataBean> data;

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
         * thresholdwater : 4.87
         * basiclevel : 3.85
         * hour : 24
         * threshold : 80
         */

        private double thresholdwater;
        private double basiclevel;
        private int hour;
        private int threshold;

        public double getThresholdwater() {
            return thresholdwater;
        }

        public void setThresholdwater(double thresholdwater) {
            this.thresholdwater = thresholdwater;
        }

        public double getBasiclevel() {
            return basiclevel;
        }

        public void setBasiclevel(double basiclevel) {
            this.basiclevel = basiclevel;
        }

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public int getThreshold() {
            return threshold;
        }

        public void setThreshold(int threshold) {
            this.threshold = threshold;
        }
    }
}
