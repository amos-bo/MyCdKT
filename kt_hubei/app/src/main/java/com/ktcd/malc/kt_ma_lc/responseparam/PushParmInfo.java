package com.ktcd.malc.kt_ma_lc.responseparam;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/14.
 */

public class PushParmInfo implements Serializable{

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

        private String createTime;
        private String updateTime;
        private int baId;
        private String baCode;
        private String baTitle;
        private String baSubtitle;
        private String baContent;
        private String baStatus;
        private BaTypeBean baType;
        private String baUrl;

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

        public String getBaStatus() {
            return baStatus;
        }

        public void setBaStatus(String baStatus) {
            this.baStatus = baStatus;
        }

        public BaTypeBean getBaType() {
            return baType;
        }

        public void setBaType(BaTypeBean baType) {
            this.baType = baType;
        }

        public String getBaUrl() {
            return baUrl;
        }

        public void setBaUrl(String baUrl) {
            this.baUrl = baUrl;
        }

        public static class BaTypeBean implements Serializable{
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
