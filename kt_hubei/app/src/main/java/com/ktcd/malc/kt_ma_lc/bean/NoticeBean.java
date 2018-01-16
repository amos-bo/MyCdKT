package com.ktcd.malc.kt_ma_lc.bean;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/6.
 */

public class NoticeBean implements Serializable{
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

        public static class RowsBean {

            private String createTime;
            private String updateTime;
            private int baId;
            private String baCode;
            private String baTitle;
            private String baSubtitle;
            private String baContent;
            private BaTypeBean baType;

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

            public int getBaId() {
                return baId;
            }

            public void setBaId(int baId) {
                this.baId = baId;
            }

            public String getBaCode() {
                return baCode;
            }

            public void setBaCode(String baCode) {
                this.baCode = baCode;
            }

            public String getBaTitle() {
                return baTitle;
            }

            public void setBaTitle(String baTitle) {
                this.baTitle = baTitle;
            }

            public String getBaSubtitle() {
                return baSubtitle;
            }

            public void setBaSubtitle(String baSubtitle) {
                this.baSubtitle = baSubtitle;
            }

            public String getBaContent() {
                return baContent;
            }

            public void setBaContent(String baContent) {
                this.baContent = baContent;
            }

            public BaTypeBean getBaType() {
                return baType;
            }

            public void setBaType(BaTypeBean baType) {
                this.baType = baType;
            }

            public static class BaTypeBean {

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
