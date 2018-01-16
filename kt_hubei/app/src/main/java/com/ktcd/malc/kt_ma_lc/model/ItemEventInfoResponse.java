package com.ktcd.malc.kt_ma_lc.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/11.
 */

public class ItemEventInfoResponse implements Serializable{


    /**
     * total : 7
     * rows : [{"eiId":302,"disasterType":{"cdtId":909,"cdtCode":"00001","cdtName":"台风","hiddenDangerPoints":[{"hdpId":11,"hdpName":"滑坡"},{"hdpId":12,"hdpName":"崩塌"},{"hdpId":13,"hdpName":"卫生局"}],"id":909,"text":"台风","createTime":1498014278698,"updateTime":1498014295472},"disasterLevel":{"cdlId":82,"cdlCode":"0001","cdlName":"一级","cdlEnum":"no_2","createTime":1498014205594,"updateTime":1499758679303},"eiName":"今年第二台风'苗柏\"已经生成","eiStatus":{"value":0,"description":"开始"},"eiDescribetion":"台风登陆时间2017年6月24日17点27分，影响范围方圆7公里，受伤人数11人","eiExecMode":"人为处理","eiLongitude":116.26565,"eiLatitude":24.23522,"createTime":1498296466408,"updateTime":1498296466387,"eventDetailInfoList":[{"createTime":1499766541084,"updateTime":"2017-07-11 17:49:01","ediTile":"今年第二台风'苗柏\"已经生成","ediDescription":"fgh","ediContent":"[{\"id\":null,\"originalName\":\"magazine-unlock-01-2.3.672-_ea550f7699b4424d949ebb66e52f50f2.jpg\",\"name\":\"20170711_174857__156898.jpg\",\"type\":\"jpg\",\"attachmentSize\":401057,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_174857__427347.jpg\"},{\"id\":null,\"originalName\":\"magazine-unlock-01-2.3.672-_031db9112dbf489f85beb27d961e541b.jpg\",\"name\":\"20170711_174857__409584.jpg\",\"type\":\"jpg\",\"attachmentSize\":590576,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_174857__136355.jpg\"}]","ediLongtitude":"104.06623","cpLattitude":"30.579294"},{"createTime":1499766648375,"updateTime":"2017-07-11 17:50:48","ediTile":"今年第二台风'苗柏\"已经生成","ediDescription":"xvbbbbbhhnbhh","ediContent":"[{\"id\":null,\"originalName\":\"magazine-unlock-05-2.3.672-_eab8f120aaf247f1a02d1947713a338e.jpg\",\"name\":\"20170711_175044__971530.jpg\",\"type\":\"jpg\",\"attachmentSize\":340411,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175044__541850.jpg\"},{\"id\":null,\"originalName\":\"JPEG_20170710_105935.jpg\",\"name\":\"20170711_175044__258838.jpg\",\"type\":\"jpg\",\"attachmentSize\":2269821,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175044__176400.jpg\"},{\"id\":null,\"originalName\":\"1645.amr\",\"name\":\"20170711_175044__989391.amr\",\"type\":\"amr\",\"attachmentSize\":5945,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175044__194694.amr\"},{\"id\":null,\"originalName\":\"1817.mp4\",\"name\":\"20170711_175044__475033.mp4\",\"type\":\"mp4\",\"attachmentSize\":591367,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175044__988304.mp4\"},{\"id\":null,\"originalName\":\"magazine-unlock-05-2.3.672-_161e8e5352be4ec1b7af985124ec9198.jpg\",\"name\":\"20170711_175044__468713.jpg\",\"type\":\"jpg\",\"attachmentSize\":555194,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175044__773405.jpg\"},{\"id\":null,\"originalName\":\"magazine-unlock-05-2.3.672-_a0a09d6f13c742918e0bfe8abed4b6d5.jpg\",\"name\":\"20170711_175044__677550.jpg\",\"type\":\"jpg\",\"attachmentSize\":312405,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175044__307140.jpg\"}]","ediLongtitude":"104.066296","cpLattitude":"30.579259"},{"createTime":1499766807552,"updateTime":"2017-07-11 17:53:27","ediTile":"今年第二台风'苗柏\"已经生成","ediDescription":"zcccfccf","ediContent":"[{\"id\":null,\"originalName\":\"magazine-unlock-05-2.3.672-_eab8f120aaf247f1a02d1947713a338e.jpg\",\"name\":\"20170711_175323__331397.jpg\",\"type\":\"jpg\",\"attachmentSize\":340411,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175323__476075.jpg\"},{\"id\":null,\"originalName\":\"JPEG_20170710_105935.jpg\",\"name\":\"20170711_175323__569180.jpg\",\"type\":\"jpg\",\"attachmentSize\":2269821,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175323__744962.jpg\"},{\"id\":null,\"originalName\":\"4946.amr\",\"name\":\"20170711_175323__798825.amr\",\"type\":\"amr\",\"attachmentSize\":5561,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175323__165487.amr\"},{\"id\":null,\"originalName\":\"magazine-unlock-01-2.3.672-_ea550f7699b4424d949ebb66e52f50f2.jpg\",\"name\":\"20170711_175323__105768.jpg\",\"type\":\"jpg\",\"attachmentSize\":401057,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175323__335362.jpg\"},{\"id\":null,\"originalName\":\"magazine-unlock-05-2.3.672-_161e8e5352be4ec1b7af985124ec9198.jpg\",\"name\":\"20170711_175323__562968.jpg\",\"type\":\"jpg\",\"attachmentSize\":555194,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175323__833994.jpg\"},{\"id\":null,\"originalName\":\"5042.amr\",\"name\":\"20170711_175323__343095.amr\",\"type\":\"amr\",\"attachmentSize\":5177,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175323__910901.amr\"},{\"id\":null,\"originalName\":\"JPEG_20170711_175256.jpg\",\"name\":\"20170711_175323__590390.jpg\",\"type\":\"jpg\",\"attachmentSize\":2642930,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175323__689079.jpg\"}]","ediLongtitude":"104.066289","cpLattitude":"30.579286"}]},{"eiId":266,"disasterType":{"cdtId":909,"cdtCode":"00001","cdtName":"台风","hiddenDangerPoints":[{"hdpId":11,"hdpName":"滑坡"},{"hdpId":12,"hdpName":"崩塌"},{"hdpId":13,"hdpName":"卫生局"}],"id":909,"text":"台风","createTime":1498014278698,"updateTime":1498014295472},"disasterLevel":{"cdlId":82,"cdlCode":"0001","cdlName":"一级","cdlEnum":"no_2","createTime":1498014205594,"updateTime":1499758679303},"eiName":"梅县区6月22号台风事件","eiStatus":{"value":1,"description":"处理中"},"eiDescribetion":"台风登陆时间2017年6月22日14点47分，影响范围方圆5公里，受伤人数13人","eiExecMode":"人为处理","eiLongitude":117,"eiLatitude":24.6,"createTime":1498107457326,"updateTime":1498107457319,"eventDetailInfoList":[]},{"eiId":265,"disasterType":{"cdtId":909,"cdtCode":"00001","cdtName":"台风","hiddenDangerPoints":[{"hdpId":11,"hdpName":"滑坡"},{"hdpId":12,"hdpName":"崩塌"},{"hdpId":13,"hdpName":"卫生局"}],"id":909,"text":"台风","createTime":1498014278698,"updateTime":1498014295472},"disasterLevel":{"cdlId":82,"cdlCode":"0001","cdlName":"一级","cdlEnum":"no_2","createTime":1498014205594,"updateTime":1499758679303},"eiName":"梅县区一级台风事件","eiStatus":{"value":1,"description":"处理中"},"eiDescribetion":"台风登陆时间2017年6月22日14点47分，影响范围方圆6公里，受伤人数9人","eiExecMode":"人为处理","eiLongitude":116,"eiLatitude":24.5,"createTime":1498106472225,"updateTime":1498114041481,"eventDetailInfoList":[{"createTime":1499757581891,"updateTime":"2017-07-11 15:19:41","ediTile":"事件标题","ediDescription":"事件详情描述","ediContent":"[{\"id\":null,\"originalName\":\"22.jpg\",\"name\":\"20170711_151937__562380.jpg\",\"type\":\"jpg\",\"attachmentSize\":5636,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_151937__524945.jpg\"},{\"id\":null,\"originalName\":\"awdwda.jpg\",\"name\":\"20170711_151937__421355.jpg\",\"type\":\"jpg\",\"attachmentSize\":24813,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_151937__206178.jpg\"}]","ediLongtitude":"123.2","cpLattitude":"23.2"}]}]
     */

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
        /**
         * eiId : 302
         * disasterType : {"cdtId":909,"cdtCode":"00001","cdtName":"台风","hiddenDangerPoints":[{"hdpId":11,"hdpName":"滑坡"},{"hdpId":12,"hdpName":"崩塌"},{"hdpId":13,"hdpName":"卫生局"}],"id":909,"text":"台风","createTime":1498014278698,"updateTime":1498014295472}
         * disasterLevel : {"cdlId":82,"cdlCode":"0001","cdlName":"一级","cdlEnum":"no_2","createTime":1498014205594,"updateTime":1499758679303}
         * eiName : 今年第二台风'苗柏"已经生成
         * eiStatus : {"value":0,"description":"开始"}
         * eiDescribetion : 台风登陆时间2017年6月24日17点27分，影响范围方圆7公里，受伤人数11人
         * eiExecMode : 人为处理
         * eiLongitude : 116.26565
         * eiLatitude : 24.23522
         * createTime : 1498296466408
         * updateTime : 1498296466387
         * eventDetailInfoList : [{"createTime":1499766541084,"updateTime":"2017-07-11 17:49:01","ediTile":"今年第二台风'苗柏\"已经生成","ediDescription":"fgh","ediContent":"[{\"id\":null,\"originalName\":\"magazine-unlock-01-2.3.672-_ea550f7699b4424d949ebb66e52f50f2.jpg\",\"name\":\"20170711_174857__156898.jpg\",\"type\":\"jpg\",\"attachmentSize\":401057,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_174857__427347.jpg\"},{\"id\":null,\"originalName\":\"magazine-unlock-01-2.3.672-_031db9112dbf489f85beb27d961e541b.jpg\",\"name\":\"20170711_174857__409584.jpg\",\"type\":\"jpg\",\"attachmentSize\":590576,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_174857__136355.jpg\"}]","ediLongtitude":"104.06623","cpLattitude":"30.579294"},{"createTime":1499766648375,"updateTime":"2017-07-11 17:50:48","ediTile":"今年第二台风'苗柏\"已经生成","ediDescription":"xvbbbbbhhnbhh","ediContent":"[{\"id\":null,\"originalName\":\"magazine-unlock-05-2.3.672-_eab8f120aaf247f1a02d1947713a338e.jpg\",\"name\":\"20170711_175044__971530.jpg\",\"type\":\"jpg\",\"attachmentSize\":340411,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175044__541850.jpg\"},{\"id\":null,\"originalName\":\"JPEG_20170710_105935.jpg\",\"name\":\"20170711_175044__258838.jpg\",\"type\":\"jpg\",\"attachmentSize\":2269821,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175044__176400.jpg\"},{\"id\":null,\"originalName\":\"1645.amr\",\"name\":\"20170711_175044__989391.amr\",\"type\":\"amr\",\"attachmentSize\":5945,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175044__194694.amr\"},{\"id\":null,\"originalName\":\"1817.mp4\",\"name\":\"20170711_175044__475033.mp4\",\"type\":\"mp4\",\"attachmentSize\":591367,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175044__988304.mp4\"},{\"id\":null,\"originalName\":\"magazine-unlock-05-2.3.672-_161e8e5352be4ec1b7af985124ec9198.jpg\",\"name\":\"20170711_175044__468713.jpg\",\"type\":\"jpg\",\"attachmentSize\":555194,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175044__773405.jpg\"},{\"id\":null,\"originalName\":\"magazine-unlock-05-2.3.672-_a0a09d6f13c742918e0bfe8abed4b6d5.jpg\",\"name\":\"20170711_175044__677550.jpg\",\"type\":\"jpg\",\"attachmentSize\":312405,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175044__307140.jpg\"}]","ediLongtitude":"104.066296","cpLattitude":"30.579259"},{"createTime":1499766807552,"updateTime":"2017-07-11 17:53:27","ediTile":"今年第二台风'苗柏\"已经生成","ediDescription":"zcccfccf","ediContent":"[{\"id\":null,\"originalName\":\"magazine-unlock-05-2.3.672-_eab8f120aaf247f1a02d1947713a338e.jpg\",\"name\":\"20170711_175323__331397.jpg\",\"type\":\"jpg\",\"attachmentSize\":340411,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175323__476075.jpg\"},{\"id\":null,\"originalName\":\"JPEG_20170710_105935.jpg\",\"name\":\"20170711_175323__569180.jpg\",\"type\":\"jpg\",\"attachmentSize\":2269821,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175323__744962.jpg\"},{\"id\":null,\"originalName\":\"4946.amr\",\"name\":\"20170711_175323__798825.amr\",\"type\":\"amr\",\"attachmentSize\":5561,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175323__165487.amr\"},{\"id\":null,\"originalName\":\"magazine-unlock-01-2.3.672-_ea550f7699b4424d949ebb66e52f50f2.jpg\",\"name\":\"20170711_175323__105768.jpg\",\"type\":\"jpg\",\"attachmentSize\":401057,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175323__335362.jpg\"},{\"id\":null,\"originalName\":\"magazine-unlock-05-2.3.672-_161e8e5352be4ec1b7af985124ec9198.jpg\",\"name\":\"20170711_175323__562968.jpg\",\"type\":\"jpg\",\"attachmentSize\":555194,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175323__833994.jpg\"},{\"id\":null,\"originalName\":\"5042.amr\",\"name\":\"20170711_175323__343095.amr\",\"type\":\"amr\",\"attachmentSize\":5177,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175323__910901.amr\"},{\"id\":null,\"originalName\":\"JPEG_20170711_175256.jpg\",\"name\":\"20170711_175323__590390.jpg\",\"type\":\"jpg\",\"attachmentSize\":2642930,\"path\":\"fileUpload\\\\eventReported\\\\2017\\\\7\\\\1120170711_175323__689079.jpg\"}]","ediLongtitude":"104.066289","cpLattitude":"30.579286"}]
         */

        private int eiId;
        private DisasterTypeBean disasterType;
        private DisasterLevelBean disasterLevel;
        private String eiName;
        private EiStatusBean eiStatus;
        private String eiDescribetion;
        private String eiExecMode;
        private double eiLongitude;
        private double eiLatitude;
        private long createTime;
        private long updateTime;
        private List<EventDetailInfoListBean> eventDetailInfoList;

        public int getEiId() {
            return eiId;
        }

        public void setEiId(int eiId) {
            this.eiId = eiId;
        }

        public DisasterTypeBean getDisasterType() {
            return disasterType;
        }

        public void setDisasterType(DisasterTypeBean disasterType) {
            this.disasterType = disasterType;
        }

        public DisasterLevelBean getDisasterLevel() {
            return disasterLevel;
        }

        public void setDisasterLevel(DisasterLevelBean disasterLevel) {
            this.disasterLevel = disasterLevel;
        }

        public String getEiName() {
            return eiName;
        }

        public void setEiName(String eiName) {
            this.eiName = eiName;
        }

        public EiStatusBean getEiStatus() {
            return eiStatus;
        }

        public void setEiStatus(EiStatusBean eiStatus) {
            this.eiStatus = eiStatus;
        }

        public String getEiDescribetion() {
            return eiDescribetion;
        }

        public void setEiDescribetion(String eiDescribetion) {
            this.eiDescribetion = eiDescribetion;
        }

        public String getEiExecMode() {
            return eiExecMode;
        }

        public void setEiExecMode(String eiExecMode) {
            this.eiExecMode = eiExecMode;
        }

        public double getEiLongitude() {
            return eiLongitude;
        }

        public void setEiLongitude(double eiLongitude) {
            this.eiLongitude = eiLongitude;
        }

        public double getEiLatitude() {
            return eiLatitude;
        }

        public void setEiLatitude(double eiLatitude) {
            this.eiLatitude = eiLatitude;
        }

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

        public List<EventDetailInfoListBean> getEventDetailInfoList() {
            return eventDetailInfoList;
        }

        public void setEventDetailInfoList(List<EventDetailInfoListBean> eventDetailInfoList) {
            this.eventDetailInfoList = eventDetailInfoList;
        }

        public static class DisasterTypeBean implements Serializable{
            /**
             * cdtId : 909
             * cdtCode : 00001
             * cdtName : 台风
             * hiddenDangerPoints : [{"hdpId":11,"hdpName":"滑坡"},{"hdpId":12,"hdpName":"崩塌"},{"hdpId":13,"hdpName":"卫生局"}]
             * id : 909
             * text : 台风
             * createTime : 1498014278698
             * updateTime : 1498014295472
             */

            private int cdtId;
            private String cdtCode;
            private String cdtName;
            private int id;
            private String text;
            private long createTime;
            private long updateTime;
            private List<HiddenDangerPointsBean> hiddenDangerPoints;

            public int getCdtId() {
                return cdtId;
            }

            public void setCdtId(int cdtId) {
                this.cdtId = cdtId;
            }

            public String getCdtCode() {
                return cdtCode;
            }

            public void setCdtCode(String cdtCode) {
                this.cdtCode = cdtCode;
            }

            public String getCdtName() {
                return cdtName;
            }

            public void setCdtName(String cdtName) {
                this.cdtName = cdtName;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getText() {
                return text;
            }

            public void setText(String text) {
                this.text = text;
            }

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

            public List<HiddenDangerPointsBean> getHiddenDangerPoints() {
                return hiddenDangerPoints;
            }

            public void setHiddenDangerPoints(List<HiddenDangerPointsBean> hiddenDangerPoints) {
                this.hiddenDangerPoints = hiddenDangerPoints;
            }

            public static class HiddenDangerPointsBean implements Serializable{
                /**
                 * hdpId : 11
                 * hdpName : 滑坡
                 */

                private int hdpId;
                private String hdpName;

                public int getHdpId() {
                    return hdpId;
                }

                public void setHdpId(int hdpId) {
                    this.hdpId = hdpId;
                }

                public String getHdpName() {
                    return hdpName;
                }

                public void setHdpName(String hdpName) {
                    this.hdpName = hdpName;
                }
            }
        }

        public static class DisasterLevelBean implements Serializable{
            /**
             * cdlId : 82
             * cdlCode : 0001
             * cdlName : 一级
             * cdlEnum : no_2
             * createTime : 1498014205594
             * updateTime : 1499758679303
             */

            private int cdlId;
            private String cdlCode;
            private String cdlName;
            private String cdlEnum;
            private long createTime;
            private long updateTime;

            public int getCdlId() {
                return cdlId;
            }

            public void setCdlId(int cdlId) {
                this.cdlId = cdlId;
            }

            public String getCdlCode() {
                return cdlCode;
            }

            public void setCdlCode(String cdlCode) {
                this.cdlCode = cdlCode;
            }

            public String getCdlName() {
                return cdlName;
            }

            public void setCdlName(String cdlName) {
                this.cdlName = cdlName;
            }

            public String getCdlEnum() {
                return cdlEnum;
            }

            public void setCdlEnum(String cdlEnum) {
                this.cdlEnum = cdlEnum;
            }

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
        }

        public static class EiStatusBean implements Serializable{
            /**
             * value : 0
             * description : 开始
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
        public static class EventDetailInfoListBean implements Serializable{
            /**
             * createTime : 1499766541084
             * updateTime : 2017-07-11 17:49:01
             * ediTile : 今年第二台风'苗柏"已经生成
             * ediDescription : fgh
             * ediContent : [{"id":null,"originalName":"magazine-unlock-01-2.3.672-_ea550f7699b4424d949ebb66e52f50f2.jpg","name":"20170711_174857__156898.jpg","type":"jpg","attachmentSize":401057,"path":"fileUpload\\eventReported\\2017\\7\\1120170711_174857__427347.jpg"},{"id":null,"originalName":"magazine-unlock-01-2.3.672-_031db9112dbf489f85beb27d961e541b.jpg","name":"20170711_174857__409584.jpg","type":"jpg","attachmentSize":590576,"path":"fileUpload\\eventReported\\2017\\7\\1120170711_174857__136355.jpg"}]
             * ediLongtitude : 104.06623
             * cpLattitude : 30.579294
             */

            private long createTime;
            private String updateTime;
            private String ediTile;
            private String ediDescription;
            private String ediContent;
            private String ediLongtitude;
            private String cpLattitude;
            private String ediAddress;

            public String getUserid() {
                return userid;
            }

            public void setUserid(String userid) {
                this.userid = userid;
            }

            private String userid;

            public String getEdiAddress() {
                return ediAddress;
            }

            public void setEdiAddress(String ediAddress) {
                this.ediAddress = ediAddress;
            }

            public long getCreateTime() {
                return createTime;
            }

            public void setCreateTime(long createTime) {
                this.createTime = createTime;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
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
            public static class AttachmentVo implements Serializable{


                private String id;

                /**  附件原始名称 */
                private String originalName;

                /**  附件名称 */
                private String name;

                /**  类型 */
                private String type;

                /**  附件大小 */
                private Long attachmentSize;

                /**  附件路径 */
                private String path;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getOriginalName() {
                    return originalName;
                }

                public void setOriginalName(String originalName) {
                    this.originalName = originalName;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public Long getAttachmentSize() {
                    return attachmentSize;
                }

                public void setAttachmentSize(Long attachmentSize) {
                    this.attachmentSize = attachmentSize;
                }

                public String getPath() {
                    return path;
                }

                public void setPath(String path) {
                    this.path = path;
                }
            }
        }
    }
}
