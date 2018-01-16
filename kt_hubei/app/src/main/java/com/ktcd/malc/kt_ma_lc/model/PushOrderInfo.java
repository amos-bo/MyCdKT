package com.ktcd.malc.kt_ma_lc.model;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/17.
 */

public class PushOrderInfo implements Serializable {


    /**
     * type : directive
     * data : {"createTime":null,"updateTime":null,"eapdId":1,"eapdStep":"2","eapdDes":"描述","eapdCreateBy":"1","eapdOrderType":null,"eapdStatus":{"value":0,"description":"待确认"},"eapdBdmId":151,"eapdCpId":287,"refuseReason":null,"eventMessageRecordlist":null}
     */

    private String type;
    private DataBean data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable{
        /**
         * createTime : null
         * updateTime : null
         * eapdId : 1
         * eapdStep : 2
         * eapdDes : 描述
         * eapdCreateBy : 1
         * eapdOrderType : null
         * eapdStatus : {"value":0,"description":"待确认"}
         * eapdBdmId : 151
         * eapdCpId : 287
         * refuseReason : null
         * eventMessageRecordlist : null
         */

        private long createTime;
        private long updateTime;
        private int eapdId;
        private String eapdStep;
        private String eapdDes;
        private String eapdCreateBy;
        private String eapdOrderType;
        private EapdStatusBean eapdStatus;
        private int eapdBdmId;
        private int eapdCpId;
        private String refuseReason;
        private Object eventMessageRecordlist;

        public long getCreateTime() {
            return createTime;
        }

        public void setCreateTime(long createTime) {
            this.createTime = createTime;
        }

        public long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(long updateTime) {
            this.updateTime = updateTime;
        }

        public int getEapdId() {
            return eapdId;
        }

        public void setEapdId(int eapdId) {
            this.eapdId = eapdId;
        }

        public String getEapdStep() {
            return eapdStep;
        }

        public void setEapdStep(String eapdStep) {
            this.eapdStep = eapdStep;
        }

        public String getEapdDes() {
            return eapdDes;
        }

        public void setEapdDes(String eapdDes) {
            this.eapdDes = eapdDes;
        }

        public String getEapdCreateBy() {
            return eapdCreateBy;
        }

        public void setEapdCreateBy(String eapdCreateBy) {
            this.eapdCreateBy = eapdCreateBy;
        }

        public String getEapdOrderType() {
            return eapdOrderType;
        }

        public void setEapdOrderType(String eapdOrderType) {
            this.eapdOrderType = eapdOrderType;
        }

        public EapdStatusBean getEapdStatus() {
            return eapdStatus;
        }

        public void setEapdStatus(EapdStatusBean eapdStatus) {
            this.eapdStatus = eapdStatus;
        }

        public int getEapdBdmId() {
            return eapdBdmId;
        }

        public void setEapdBdmId(int eapdBdmId) {
            this.eapdBdmId = eapdBdmId;
        }

        public int getEapdCpId() {
            return eapdCpId;
        }

        public void setEapdCpId(int eapdCpId) {
            this.eapdCpId = eapdCpId;
        }

        public String getRefuseReason() {
            return refuseReason;
        }

        public void setRefuseReason(String refuseReason) {
            this.refuseReason = refuseReason;
        }

        public Object getEventMessageRecordlist() {
            return eventMessageRecordlist;
        }

        public void setEventMessageRecordlist(Object eventMessageRecordlist) {
            this.eventMessageRecordlist = eventMessageRecordlist;
        }

        public static class EapdStatusBean implements Serializable{
            /**
             * value : 0
             * description : 待确认
             */

            private int value;
            private String description;

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }
    }
}
