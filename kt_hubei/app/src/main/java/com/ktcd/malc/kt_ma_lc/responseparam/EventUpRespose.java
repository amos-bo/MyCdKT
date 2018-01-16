package com.ktcd.malc.kt_ma_lc.responseparam;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/13.
 */

public class EventUpRespose implements Serializable {


    /**
     * eventInfo : {"eiId":402}
     * ediTile : 6y6
     * ediDescription : 6y56
     * ediContent : []
     * ediLongtitude : y6
     * cpLattitude : 65y6
     * ediAddress : 6y56y
     */

    private EventInfoBean eventInfo;
    private String ediTile;
    private String ediDescription;
    private String ediContent;
    private String ediLongtitude;
    private String cpLattitude;
    private String ediAddress;

    public EventInfoBean getEventInfo() {
        return eventInfo;
    }

    public void setEventInfo(EventInfoBean eventInfo) {
        this.eventInfo = eventInfo;
    }

    public String getEdiTile() {
        return ediTile;
    }

    public void setEdiTile(String ediTile) {
        this.ediTile = ediTile;
    }

    public String getEdiDescription() {
        return ediDescription;
    }

    public void setEdiDescription(String ediDescription) {
        this.ediDescription = ediDescription;
    }

    public String getEdiContent() {
        return ediContent;
    }

    public void setEdiContent(String ediContent) {
        this.ediContent = ediContent;
    }

    public String getEdiLongtitude() {
        return ediLongtitude;
    }

    public void setEdiLongtitude(String ediLongtitude) {
        this.ediLongtitude = ediLongtitude;
    }

    public String getCpLattitude() {
        return cpLattitude;
    }

    public void setCpLattitude(String cpLattitude) {
        this.cpLattitude = cpLattitude;
    }

    public String getEdiAddress() {
        return ediAddress;
    }

    public void setEdiAddress(String ediAddress) {
        this.ediAddress = ediAddress;
    }

    public static class EventInfoBean implements Serializable{
        /**
         * eiId : 402
         */

        private int eiId;

        public int getEiId() {
            return eiId;
        }

        public void setEiId(int eiId) {
            this.eiId = eiId;
        }
    }
}
