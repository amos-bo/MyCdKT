package com.ktcd.malc.kt_ma_lc.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/13.
 */

public class UpdateOrderBean implements Serializable{

    private String code;
    private String msg;
    private DataBean data;
    private boolean success;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public static class DataBean implements Serializable{

        private int eapdId;
        private EapdStatusBean eapdStatus;
        private String refuseReason;

        public int getEapdId() {
            return eapdId;
        }

        public void setEapdId(int eapdId) {
            this.eapdId = eapdId;
        }

        public EapdStatusBean getEapdStatus() {
            return eapdStatus;
        }

        public void setEapdStatus(EapdStatusBean eapdStatus) {
            this.eapdStatus = eapdStatus;
        }

        public String getRefuseReason() {
            return refuseReason;
        }

        public void setRefuseReason(String refuseReason) {
            this.refuseReason = refuseReason;
        }

        public static class EapdStatusBean implements Serializable{
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
