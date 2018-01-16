package com.ktcd.malc.kt_ma_lc.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/6/26.
 */

public class ItemInstructTypeInfo implements Serializable {

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

        public static class RowsBean implements Serializable{
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
}
