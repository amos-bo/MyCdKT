package com.ktcd.malc.kt_ma_lc.DateManager;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/11/13.
 */

public class FirstMoreDataLandsSlide implements Serializable{
    /**
     * S3 : [{"id":"D6B8B6108A864509A32CE22DE78616FA","number":null,"disasternum":"1.0","landlidecodeing":"3501221002S","ppnum":"3.50104E12","occurrencetime":"38553.416666666664","affectfactor":null,"disastercm":0,"disasterpeople":50,"locpeople":0,"diepeople":0,"placementpeople":0,"collapsehouse":0,"damagehouse":0,"plantcm":0,"noharvestscm":0,"financialloss":0,"croptype":null,"dieanimal":0,"roadm":0,"bridge":0,"describes":null,"datasources":"绂忓窞甯傛皵璞\u2033眬"}]
     * S4 : [{"id":"5634DA8BDF634EA79D13B7E665C0AE8E","number":null,"landlidecodeing":"3501221002S","ppnum":null,"status":"鏃�","type":"鏃�","construction":"鏃�","datasources":"鏃�"}]
     * S8Immediate : [{"id":"B1B519C5C77D440F86562EB643A99E34","number":null,"codes":"3501221002S","ppnum":"3.50102E12","warningPointName":"灏嗗啗灞辨柊鏉�1鍙锋ゼ","immediateTransferTime":3,"earlyWarningIndex":5}]
     * S5 : [{"id":"314D0976FDF04C46809CD675685F36C9","landlidecodeing":"3501221002S","ppnum":null,"monitorability":"鏃�","monitortype":"鏃�","constructioncase":"鏃�","datasources":"鏃�"}]
     * tv : [{"id":"15118","provincename":"浜戝崡","disastertype":"婊戝潯","landname":"涓婊戝潯(鏅嬪畞)","landcoding":"3501221002S","rivercm":1,"longitude":102.2733,"latitude":24.4789,"relerain":"浜戝崡鏅嬪畞","raincount":"娉版．澶氳竟褰㈡硶","warningname":"涓","warningcode":"530122205201001","warningcity":"鏄嗘槑甯�","warningcounty":"鏅嬪畞鍘�","warningtowns":"澶曢槼褰濇棌涔�","warningburg":"澶曢槼鏉戝浼�","warninglongitude":102.2733,"warninglatitude":24.4789,"sureway":"鎸囧崡","altitudehigh":1550,"affectcm":0,"affectpeople":0,"affecthouse":0,"affectmoney":0,"crisisrain":16.8,"qperain":16.8,"decaynum":0.78,"rainday":10,"earyuserain":109.4,"striketime":6,"strikerain":16.8,"qpestrikerain":16.8,"madetime":"2015/6/23","altertime":"2015/6/23","altercause":"鏃�","storagetime":"2016-06-23 15:37:42","datarevise":"2016-06-23 15:37:42","checker":null,"preparer":"浜戝崡","examinant":null,"telephone":"67892353"},{"id":"1134","provincename":"浜戝崡","disastertype":"婊戝潯","landname":"涓婊戝潯(鏅嬪畞)","landcoding":"3501221002S","rivercm":1,"longitude":102.2733,"latitude":24.4789,"relerain":"浜戝崡鏅嬪畞","raincount":"娉版．澶氳竟褰㈡硶","warningname":"涓","warningcode":"530122205201001","warningcity":"鏄嗘槑甯�","warningcounty":"鏅嬪畞鍘�","warningtowns":"澶曢槼褰濇棌涔�","warningburg":"澶曢槼鏉戝浼�","warninglongitude":102.2733,"warninglatitude":24.4789,"sureway":"鎸囧崡","altitudehigh":1550,"affectcm":0,"affectpeople":0,"affecthouse":0,"affectmoney":0,"crisisrain":32.8,"qperain":32.8,"decaynum":0.78,"rainday":10,"earyuserain":109.4,"striketime":12,"strikerain":32.8,"qpestrikerain":32.8,"madetime":"2015/6/23","altertime":"2015/6/23","altercause":"鏃�","storagetime":"2016-06-23 15:37:42","datarevise":"2016-06-23 15:37:42","checker":null,"preparer":"浜戝崡","examinant":null,"telephone":"67892353"},{"id":"1135","provincename":"浜戝崡","disastertype":"婊戝潯","landname":"涓婊戝潯(鏅嬪畞)","landcoding":"3501221002S","rivercm":1,"longitude":102.2733,"latitude":24.4789,"relerain":"浜戝崡鏅嬪畞","raincount":"娉版．澶氳竟褰㈡硶","warningname":"涓","warningcode":"530122205201001","warningcity":"鏄嗘槑甯�","warningcounty":"鏅嬪畞鍘�","warningtowns":"澶曢槼褰濇棌涔�","warningburg":"澶曢槼鏉戝浼�","warninglongitude":102.2733,"warninglatitude":24.4789,"sureway":"鎸囧崡","altitudehigh":1550,"affectcm":0,"affectpeople":0,"affecthouse":0,"affectmoney":0,"crisisrain":65.31,"qperain":65.31,"decaynum":0.78,"rainday":10,"earyuserain":109.4,"striketime":24,"strikerain":65.31,"qpestrikerain":65.31,"madetime":"2015/6/23","altertime":"2015/6/23","altercause":"鏃�","storagetime":"2016-06-23 15:37:42","datarevise":"2016-06-23 15:37:42","checker":null,"preparer":"浜戝崡","examinant":null,"telephone":"67892353"},{"id":"5112","provincename":"浜戝崡","disastertype":"婊戝潯","landname":"涓婊戝潯(鏅嬪畞)","landcoding":"3501221002S","rivercm":1,"longitude":102.2733,"latitude":24.4789,"relerain":"浜戝崡鏅嬪畞","raincount":"娉版．澶氳竟褰㈡硶","warningname":"涓","warningcode":"530122205201001","warningcity":"鏄嗘槑甯�","warningcounty":"鏅嬪畞鍘�","warningtowns":"澶曢槼褰濇棌涔�","warningburg":"澶曢槼鏉戝浼�","warninglongitude":102.2733,"warninglatitude":24.4789,"sureway":"鎸囧崡","altitudehigh":1550,"affectcm":0,"affectpeople":0,"affecthouse":0,"affectmoney":0,"crisisrain":9.45,"qperain":9.45,"decaynum":0.78,"rainday":10,"earyuserain":109.4,"striketime":3,"strikerain":9.45,"qpestrikerain":9.45,"madetime":"2015/6/23","altertime":"2015/6/23","altercause":"鏃�","storagetime":"2016-06-23 15:37:42","datarevise":"2016-06-23 15:37:42","checker":null,"preparer":"浜戝崡","examinant":null,"telephone":"67892353"}]
     * S6 : [{"id":"BD80150BF385483993FA842D4F67162C","number":null,"landlidecodeing":"3501221002S","ppnum":"3.50182E12","traffic":null,"infrastructure":null,"other":null,"earthquake":null,"datasources":"绂忓缓鐪侀暱涔愬競鍥藉湡灞�"}]
     * S7 : [{"id":"A01FE6CA31504E008218D3055D620702","number":null,"landlidecodeing":"3501221002S","ppnum":"3.50182E12","longitude":94.9494,"latitude":26.2626,"elevation":7,"influencecm":0,"influencehouse":0,"influencepeople":110,"influencemoney":210,"other":null,"resurgencefactor":"A闄嶉洦","lolstate":"C","datasources":"绂忓缓鐪侀暱涔愬競鍥藉湡灞�"}]
     * S8 : [{"id":"B1BE9481E9CC4084BAA7F68FE2FFA491","number":null,"landlidecodeing":"3501221002S","ppnum":"3.50182E12","warningname":"闀夸箰甯傝亴涓氫腑涓撳鏍�","longitude":94.9494,"latitude":26.2626,"elevation":0,"areapeople":0,"preparename":"0.0","soonname":"0.0","relevance":null,"target":null,"remark":null,"datasources":"绂忓缓鐪侀暱涔愬競鍥藉湡灞�"}]
     * S9 : [{"id":"2FDF98EE42994E3B9725438A15CD60EF","number":null,"landlidecodeing":"3501221002S","stationstation":"F1004 ","sequencelength":"0.0","preparer":"濮氭灄濉�","checker":"濮氭灄濉�","examinant":"濮氭灄濉�","telephone":"8.3920524E7","filloutlol":null,"filloutdata":null,"datasources":"绂忓窞甯傛皵璞\u2033眬"}]
     * S8Readies : [{"id":"2424435A2F6D44DBB1D32E1574EB33FA","number":null,"codes":"3501221002S","ppnum":"3.50182E12","warningPointName":"灏嗗啗灞辨柊鏉�1鍙锋ゼ","immediateTransferTime":5,"earlyWarningIndex":12}]
     * S1 : {"id":"67CBA5F255174A74BE740671568B6D05","number":null,"landlidecodeing":"3501221002S","ppnum":"143012210","longitude":116.40931994058876,"latitude":24.473191373578786,"tophight":41,"toehight":42,"rivercoding":"353212212S","landyear":"2012","datasources":"姊呭幙"}
     * S2 : [{"id":"0BC610EA98D9428CB9CE11BE624D82FF","number":null,"landlidecodeing":"3501221002S","ppnum":"3.50122E12","landlidetype":null,"landlidenature":null,"microrelief":null,"riverseat":null,"floodstage":0,"lowwaterlevel":0,"slopeheight":0,"slope":0,"slopeshape":null,"materialcomposition":null,"earthquakeintensity":null,"characteristiclength":25,"characteristicwidth":50,"characteristicthickness":3,"landslidearea":0,"volume":3750,"watertype":null,"burieddepth":0,"supplytype":null,"forest":0,"shrub":0,"grassland":0,"slopefarmland":0,"steepfarmland":0,"utilizationland":0,"houseland":0,"otherland":0,"remotenumber":null,"photoname":null,"comfrom":"鍥藉湡灞�","starttime":"38628.354166666664"}]
     */

    private S1Bean S1;
    private List<S3Bean> S3;
    private List<S4Bean> S4;
    private List<S8ImmediateBean> S8Immediate;
    private List<S5Bean> S5;
    private List<TvBean> tv;
    private List<S6Bean> S6;
    private List<S7Bean> S7;
    private List<S8Bean> S8;
    private List<S9Bean> S9;
    private List<S8ReadiesBean> S8Readies;
    private List<S2Bean> S2;

    public S1Bean getS1() {
        return S1;
    }

    public void setS1(S1Bean S1) {
        this.S1 = S1;
    }

    public List<S3Bean> getS3() {
        return S3;
    }

    public void setS3(List<S3Bean> S3) {
        this.S3 = S3;
    }

    public List<S4Bean> getS4() {
        return S4;
    }

    public void setS4(List<S4Bean> S4) {
        this.S4 = S4;
    }

    public List<S8ImmediateBean> getS8Immediate() {
        return S8Immediate;
    }

    public void setS8Immediate(List<S8ImmediateBean> S8Immediate) {
        this.S8Immediate = S8Immediate;
    }

    public List<S5Bean> getS5() {
        return S5;
    }

    public void setS5(List<S5Bean> S5) {
        this.S5 = S5;
    }

    public List<TvBean> getTv() {
        return tv;
    }

    public void setTv(List<TvBean> tv) {
        this.tv = tv;
    }

    public List<S6Bean> getS6() {
        return S6;
    }

    public void setS6(List<S6Bean> S6) {
        this.S6 = S6;
    }

    public List<S7Bean> getS7() {
        return S7;
    }

    public void setS7(List<S7Bean> S7) {
        this.S7 = S7;
    }

    public List<S8Bean> getS8() {
        return S8;
    }

    public void setS8(List<S8Bean> S8) {
        this.S8 = S8;
    }

    public List<S9Bean> getS9() {
        return S9;
    }

    public void setS9(List<S9Bean> S9) {
        this.S9 = S9;
    }

    public List<S8ReadiesBean> getS8Readies() {
        return S8Readies;
    }

    public void setS8Readies(List<S8ReadiesBean> S8Readies) {
        this.S8Readies = S8Readies;
    }

    public List<S2Bean> getS2() {
        return S2;
    }

    public void setS2(List<S2Bean> S2) {
        this.S2 = S2;
    }

    public static class S1Bean {
        /**
         * id : 67CBA5F255174A74BE740671568B6D05
         * number : null
         * landlidecodeing : 3501221002S
         * ppnum : 143012210
         * longitude : 116.40931994058876
         * latitude : 24.473191373578786
         * tophight : 41
         * toehight : 42
         * rivercoding : 353212212S
         * landyear : 2012
         * datasources : 姊呭幙
         */

        private String id;
        private Object number;
        private String landlidecodeing;
        private String ppnum;
        private double longitude;
        private double latitude;
        private int tophight;
        private int toehight;
        private String rivercoding;
        private String landyear;
        private String datasources;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getNumber() {
            return number;
        }

        public void setNumber(Object number) {
            this.number = number;
        }

        public String getLandlidecodeing() {
            return landlidecodeing;
        }

        public void setLandlidecodeing(String landlidecodeing) {
            this.landlidecodeing = landlidecodeing;
        }

        public String getPpnum() {
            return ppnum;
        }

        public void setPpnum(String ppnum) {
            this.ppnum = ppnum;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public int getTophight() {
            return tophight;
        }

        public void setTophight(int tophight) {
            this.tophight = tophight;
        }

        public int getToehight() {
            return toehight;
        }

        public void setToehight(int toehight) {
            this.toehight = toehight;
        }

        public String getRivercoding() {
            return rivercoding;
        }

        public void setRivercoding(String rivercoding) {
            this.rivercoding = rivercoding;
        }

        public String getLandyear() {
            return landyear;
        }

        public void setLandyear(String landyear) {
            this.landyear = landyear;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }
    }

    public static class S3Bean {
        /**
         * id : D6B8B6108A864509A32CE22DE78616FA
         * number : null
         * disasternum : 1.0
         * landlidecodeing : 3501221002S
         * ppnum : 3.50104E12
         * occurrencetime : 38553.416666666664
         * affectfactor : null
         * disastercm : 0
         * disasterpeople : 50
         * locpeople : 0
         * diepeople : 0
         * placementpeople : 0
         * collapsehouse : 0
         * damagehouse : 0
         * plantcm : 0
         * noharvestscm : 0
         * financialloss : 0
         * croptype : null
         * dieanimal : 0
         * roadm : 0
         * bridge : 0
         * describes : null
         * datasources : 绂忓窞甯傛皵璞″眬
         */

        private String id;
        private Object number;
        private String disasternum;
        private String landlidecodeing;
        private String ppnum;
        private String occurrencetime;
        private Object affectfactor;
        private int disastercm;
        private int disasterpeople;
        private int locpeople;
        private int diepeople;
        private int placementpeople;
        private int collapsehouse;
        private int damagehouse;
        private int plantcm;
        private int noharvestscm;
        private int financialloss;
        private Object croptype;
        private int dieanimal;
        private int roadm;
        private int bridge;
        private Object describes;
        private String datasources;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getNumber() {
            return number;
        }

        public void setNumber(Object number) {
            this.number = number;
        }

        public String getDisasternum() {
            return disasternum;
        }

        public void setDisasternum(String disasternum) {
            this.disasternum = disasternum;
        }

        public String getLandlidecodeing() {
            return landlidecodeing;
        }

        public void setLandlidecodeing(String landlidecodeing) {
            this.landlidecodeing = landlidecodeing;
        }

        public String getPpnum() {
            return ppnum;
        }

        public void setPpnum(String ppnum) {
            this.ppnum = ppnum;
        }

        public String getOccurrencetime() {
            return occurrencetime;
        }

        public void setOccurrencetime(String occurrencetime) {
            this.occurrencetime = occurrencetime;
        }

        public Object getAffectfactor() {
            return affectfactor;
        }

        public void setAffectfactor(Object affectfactor) {
            this.affectfactor = affectfactor;
        }

        public int getDisastercm() {
            return disastercm;
        }

        public void setDisastercm(int disastercm) {
            this.disastercm = disastercm;
        }

        public int getDisasterpeople() {
            return disasterpeople;
        }

        public void setDisasterpeople(int disasterpeople) {
            this.disasterpeople = disasterpeople;
        }

        public int getLocpeople() {
            return locpeople;
        }

        public void setLocpeople(int locpeople) {
            this.locpeople = locpeople;
        }

        public int getDiepeople() {
            return diepeople;
        }

        public void setDiepeople(int diepeople) {
            this.diepeople = diepeople;
        }

        public int getPlacementpeople() {
            return placementpeople;
        }

        public void setPlacementpeople(int placementpeople) {
            this.placementpeople = placementpeople;
        }

        public int getCollapsehouse() {
            return collapsehouse;
        }

        public void setCollapsehouse(int collapsehouse) {
            this.collapsehouse = collapsehouse;
        }

        public int getDamagehouse() {
            return damagehouse;
        }

        public void setDamagehouse(int damagehouse) {
            this.damagehouse = damagehouse;
        }

        public int getPlantcm() {
            return plantcm;
        }

        public void setPlantcm(int plantcm) {
            this.plantcm = plantcm;
        }

        public int getNoharvestscm() {
            return noharvestscm;
        }

        public void setNoharvestscm(int noharvestscm) {
            this.noharvestscm = noharvestscm;
        }

        public int getFinancialloss() {
            return financialloss;
        }

        public void setFinancialloss(int financialloss) {
            this.financialloss = financialloss;
        }

        public Object getCroptype() {
            return croptype;
        }

        public void setCroptype(Object croptype) {
            this.croptype = croptype;
        }

        public int getDieanimal() {
            return dieanimal;
        }

        public void setDieanimal(int dieanimal) {
            this.dieanimal = dieanimal;
        }

        public int getRoadm() {
            return roadm;
        }

        public void setRoadm(int roadm) {
            this.roadm = roadm;
        }

        public int getBridge() {
            return bridge;
        }

        public void setBridge(int bridge) {
            this.bridge = bridge;
        }

        public Object getDescribes() {
            return describes;
        }

        public void setDescribes(Object describes) {
            this.describes = describes;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }
    }

    public static class S4Bean {
        /**
         * id : 5634DA8BDF634EA79D13B7E665C0AE8E
         * number : null
         * landlidecodeing : 3501221002S
         * ppnum : null
         * status : 鏃�
         * type : 鏃�
         * construction : 鏃�
         * datasources : 鏃�
         */

        private String id;
        private Object number;
        private String landlidecodeing;
        private Object ppnum;
        private String status;
        private String type;
        private String construction;
        private String datasources;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getNumber() {
            return number;
        }

        public void setNumber(Object number) {
            this.number = number;
        }

        public String getLandlidecodeing() {
            return landlidecodeing;
        }

        public void setLandlidecodeing(String landlidecodeing) {
            this.landlidecodeing = landlidecodeing;
        }

        public Object getPpnum() {
            return ppnum;
        }

        public void setPpnum(Object ppnum) {
            this.ppnum = ppnum;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getConstruction() {
            return construction;
        }

        public void setConstruction(String construction) {
            this.construction = construction;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }
    }

    public static class S8ImmediateBean {
        /**
         * id : B1B519C5C77D440F86562EB643A99E34
         * number : null
         * codes : 3501221002S
         * ppnum : 3.50102E12
         * warningPointName : 灏嗗啗灞辨柊鏉�1鍙锋ゼ
         * immediateTransferTime : 3
         * earlyWarningIndex : 5
         */

        private String id;
        private Object number;
        private String codes;
        private String ppnum;
        private String warningPointName;
        private int immediateTransferTime;
        private int earlyWarningIndex;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getNumber() {
            return number;
        }

        public void setNumber(Object number) {
            this.number = number;
        }

        public String getCodes() {
            return codes;
        }

        public void setCodes(String codes) {
            this.codes = codes;
        }

        public String getPpnum() {
            return ppnum;
        }

        public void setPpnum(String ppnum) {
            this.ppnum = ppnum;
        }

        public String getWarningPointName() {
            return warningPointName;
        }

        public void setWarningPointName(String warningPointName) {
            this.warningPointName = warningPointName;
        }

        public int getImmediateTransferTime() {
            return immediateTransferTime;
        }

        public void setImmediateTransferTime(int immediateTransferTime) {
            this.immediateTransferTime = immediateTransferTime;
        }

        public int getEarlyWarningIndex() {
            return earlyWarningIndex;
        }

        public void setEarlyWarningIndex(int earlyWarningIndex) {
            this.earlyWarningIndex = earlyWarningIndex;
        }
    }

    public static class S5Bean {
        /**
         * id : 314D0976FDF04C46809CD675685F36C9
         * landlidecodeing : 3501221002S
         * ppnum : null
         * monitorability : 鏃�
         * monitortype : 鏃�
         * constructioncase : 鏃�
         * datasources : 鏃�
         */

        private String id;
        private String landlidecodeing;
        private Object ppnum;
        private String monitorability;
        private String monitortype;
        private String constructioncase;
        private String datasources;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLandlidecodeing() {
            return landlidecodeing;
        }

        public void setLandlidecodeing(String landlidecodeing) {
            this.landlidecodeing = landlidecodeing;
        }

        public Object getPpnum() {
            return ppnum;
        }

        public void setPpnum(Object ppnum) {
            this.ppnum = ppnum;
        }

        public String getMonitorability() {
            return monitorability;
        }

        public void setMonitorability(String monitorability) {
            this.monitorability = monitorability;
        }

        public String getMonitortype() {
            return monitortype;
        }

        public void setMonitortype(String monitortype) {
            this.monitortype = monitortype;
        }

        public String getConstructioncase() {
            return constructioncase;
        }

        public void setConstructioncase(String constructioncase) {
            this.constructioncase = constructioncase;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }
    }

    public static class TvBean {
        /**
         * id : 15118
         * provincename : 浜戝崡
         * disastertype : 婊戝潯
         * landname : 涓婊戝潯(鏅嬪畞)
         * landcoding : 3501221002S
         * rivercm : 1
         * longitude : 102.2733
         * latitude : 24.4789
         * relerain : 浜戝崡鏅嬪畞
         * raincount : 娉版．澶氳竟褰㈡硶
         * warningname : 涓
         * warningcode : 530122205201001
         * warningcity : 鏄嗘槑甯�
         * warningcounty : 鏅嬪畞鍘�
         * warningtowns : 澶曢槼褰濇棌涔�
         * warningburg : 澶曢槼鏉戝浼�
         * warninglongitude : 102.2733
         * warninglatitude : 24.4789
         * sureway : 鎸囧崡
         * altitudehigh : 1550
         * affectcm : 0
         * affectpeople : 0
         * affecthouse : 0
         * affectmoney : 0
         * crisisrain : 16.8
         * qperain : 16.8
         * decaynum : 0.78
         * rainday : 10
         * earyuserain : 109.4
         * striketime : 6
         * strikerain : 16.8
         * qpestrikerain : 16.8
         * madetime : 2015/6/23
         * altertime : 2015/6/23
         * altercause : 鏃�
         * storagetime : 2016-06-23 15:37:42
         * datarevise : 2016-06-23 15:37:42
         * checker : null
         * preparer : 浜戝崡
         * examinant : null
         * telephone : 67892353
         */

        private String id;
        private String provincename;
        private String disastertype;
        private String landname;
        private String landcoding;
        private int rivercm;
        private double longitude;
        private double latitude;
        private String relerain;
        private String raincount;
        private String warningname;
        private String warningcode;
        private String warningcity;
        private String warningcounty;
        private String warningtowns;
        private String warningburg;
        private double warninglongitude;
        private double warninglatitude;
        private String sureway;
        private int altitudehigh;
        private int affectcm;
        private int affectpeople;
        private int affecthouse;
        private int affectmoney;
        private double crisisrain;
        private double qperain;
        private double decaynum;
        private int rainday;
        private double earyuserain;
        private int striketime;
        private double strikerain;
        private double qpestrikerain;
        private String madetime;
        private String altertime;
        private String altercause;
        private String storagetime;
        private String datarevise;
        private Object checker;
        private String preparer;
        private Object examinant;
        private String telephone;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getProvincename() {
            return provincename;
        }

        public void setProvincename(String provincename) {
            this.provincename = provincename;
        }

        public String getDisastertype() {
            return disastertype;
        }

        public void setDisastertype(String disastertype) {
            this.disastertype = disastertype;
        }

        public String getLandname() {
            return landname;
        }

        public void setLandname(String landname) {
            this.landname = landname;
        }

        public String getLandcoding() {
            return landcoding;
        }

        public void setLandcoding(String landcoding) {
            this.landcoding = landcoding;
        }

        public int getRivercm() {
            return rivercm;
        }

        public void setRivercm(int rivercm) {
            this.rivercm = rivercm;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public String getRelerain() {
            return relerain;
        }

        public void setRelerain(String relerain) {
            this.relerain = relerain;
        }

        public String getRaincount() {
            return raincount;
        }

        public void setRaincount(String raincount) {
            this.raincount = raincount;
        }

        public String getWarningname() {
            return warningname;
        }

        public void setWarningname(String warningname) {
            this.warningname = warningname;
        }

        public String getWarningcode() {
            return warningcode;
        }

        public void setWarningcode(String warningcode) {
            this.warningcode = warningcode;
        }

        public String getWarningcity() {
            return warningcity;
        }

        public void setWarningcity(String warningcity) {
            this.warningcity = warningcity;
        }

        public String getWarningcounty() {
            return warningcounty;
        }

        public void setWarningcounty(String warningcounty) {
            this.warningcounty = warningcounty;
        }

        public String getWarningtowns() {
            return warningtowns;
        }

        public void setWarningtowns(String warningtowns) {
            this.warningtowns = warningtowns;
        }

        public String getWarningburg() {
            return warningburg;
        }

        public void setWarningburg(String warningburg) {
            this.warningburg = warningburg;
        }

        public double getWarninglongitude() {
            return warninglongitude;
        }

        public void setWarninglongitude(double warninglongitude) {
            this.warninglongitude = warninglongitude;
        }

        public double getWarninglatitude() {
            return warninglatitude;
        }

        public void setWarninglatitude(double warninglatitude) {
            this.warninglatitude = warninglatitude;
        }

        public String getSureway() {
            return sureway;
        }

        public void setSureway(String sureway) {
            this.sureway = sureway;
        }

        public int getAltitudehigh() {
            return altitudehigh;
        }

        public void setAltitudehigh(int altitudehigh) {
            this.altitudehigh = altitudehigh;
        }

        public int getAffectcm() {
            return affectcm;
        }

        public void setAffectcm(int affectcm) {
            this.affectcm = affectcm;
        }

        public int getAffectpeople() {
            return affectpeople;
        }

        public void setAffectpeople(int affectpeople) {
            this.affectpeople = affectpeople;
        }

        public int getAffecthouse() {
            return affecthouse;
        }

        public void setAffecthouse(int affecthouse) {
            this.affecthouse = affecthouse;
        }

        public int getAffectmoney() {
            return affectmoney;
        }

        public void setAffectmoney(int affectmoney) {
            this.affectmoney = affectmoney;
        }

        public double getCrisisrain() {
            return crisisrain;
        }

        public void setCrisisrain(double crisisrain) {
            this.crisisrain = crisisrain;
        }

        public double getQperain() {
            return qperain;
        }

        public void setQperain(double qperain) {
            this.qperain = qperain;
        }

        public double getDecaynum() {
            return decaynum;
        }

        public void setDecaynum(double decaynum) {
            this.decaynum = decaynum;
        }

        public int getRainday() {
            return rainday;
        }

        public void setRainday(int rainday) {
            this.rainday = rainday;
        }

        public double getEaryuserain() {
            return earyuserain;
        }

        public void setEaryuserain(double earyuserain) {
            this.earyuserain = earyuserain;
        }

        public int getStriketime() {
            return striketime;
        }

        public void setStriketime(int striketime) {
            this.striketime = striketime;
        }

        public double getStrikerain() {
            return strikerain;
        }

        public void setStrikerain(double strikerain) {
            this.strikerain = strikerain;
        }

        public double getQpestrikerain() {
            return qpestrikerain;
        }

        public void setQpestrikerain(double qpestrikerain) {
            this.qpestrikerain = qpestrikerain;
        }

        public String getMadetime() {
            return madetime;
        }

        public void setMadetime(String madetime) {
            this.madetime = madetime;
        }

        public String getAltertime() {
            return altertime;
        }

        public void setAltertime(String altertime) {
            this.altertime = altertime;
        }

        public String getAltercause() {
            return altercause;
        }

        public void setAltercause(String altercause) {
            this.altercause = altercause;
        }

        public String getStoragetime() {
            return storagetime;
        }

        public void setStoragetime(String storagetime) {
            this.storagetime = storagetime;
        }

        public String getDatarevise() {
            return datarevise;
        }

        public void setDatarevise(String datarevise) {
            this.datarevise = datarevise;
        }

        public Object getChecker() {
            return checker;
        }

        public void setChecker(Object checker) {
            this.checker = checker;
        }

        public String getPreparer() {
            return preparer;
        }

        public void setPreparer(String preparer) {
            this.preparer = preparer;
        }

        public Object getExaminant() {
            return examinant;
        }

        public void setExaminant(Object examinant) {
            this.examinant = examinant;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }
    }

    public static class S6Bean {
        /**
         * id : BD80150BF385483993FA842D4F67162C
         * number : null
         * landlidecodeing : 3501221002S
         * ppnum : 3.50182E12
         * traffic : null
         * infrastructure : null
         * other : null
         * earthquake : null
         * datasources : 绂忓缓鐪侀暱涔愬競鍥藉湡灞�
         */

        private String id;
        private Object number;
        private String landlidecodeing;
        private String ppnum;
        private Object traffic;
        private Object infrastructure;
        private Object other;
        private Object earthquake;
        private String datasources;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getNumber() {
            return number;
        }

        public void setNumber(Object number) {
            this.number = number;
        }

        public String getLandlidecodeing() {
            return landlidecodeing;
        }

        public void setLandlidecodeing(String landlidecodeing) {
            this.landlidecodeing = landlidecodeing;
        }

        public String getPpnum() {
            return ppnum;
        }

        public void setPpnum(String ppnum) {
            this.ppnum = ppnum;
        }

        public Object getTraffic() {
            return traffic;
        }

        public void setTraffic(Object traffic) {
            this.traffic = traffic;
        }

        public Object getInfrastructure() {
            return infrastructure;
        }

        public void setInfrastructure(Object infrastructure) {
            this.infrastructure = infrastructure;
        }

        public Object getOther() {
            return other;
        }

        public void setOther(Object other) {
            this.other = other;
        }

        public Object getEarthquake() {
            return earthquake;
        }

        public void setEarthquake(Object earthquake) {
            this.earthquake = earthquake;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }
    }

    public static class S7Bean {
        /**
         * id : A01FE6CA31504E008218D3055D620702
         * number : null
         * landlidecodeing : 3501221002S
         * ppnum : 3.50182E12
         * longitude : 94.9494
         * latitude : 26.2626
         * elevation : 7
         * influencecm : 0
         * influencehouse : 0
         * influencepeople : 110
         * influencemoney : 210
         * other : null
         * resurgencefactor : A闄嶉洦
         * lolstate : C
         * datasources : 绂忓缓鐪侀暱涔愬競鍥藉湡灞�
         */

        private String id;
        private Object number;
        private String landlidecodeing;
        private String ppnum;
        private double longitude;
        private double latitude;
        private int elevation;
        private int influencecm;
        private int influencehouse;
        private int influencepeople;
        private int influencemoney;
        private Object other;
        private String resurgencefactor;
        private String lolstate;
        private String datasources;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getNumber() {
            return number;
        }

        public void setNumber(Object number) {
            this.number = number;
        }

        public String getLandlidecodeing() {
            return landlidecodeing;
        }

        public void setLandlidecodeing(String landlidecodeing) {
            this.landlidecodeing = landlidecodeing;
        }

        public String getPpnum() {
            return ppnum;
        }

        public void setPpnum(String ppnum) {
            this.ppnum = ppnum;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public int getElevation() {
            return elevation;
        }

        public void setElevation(int elevation) {
            this.elevation = elevation;
        }

        public int getInfluencecm() {
            return influencecm;
        }

        public void setInfluencecm(int influencecm) {
            this.influencecm = influencecm;
        }

        public int getInfluencehouse() {
            return influencehouse;
        }

        public void setInfluencehouse(int influencehouse) {
            this.influencehouse = influencehouse;
        }

        public int getInfluencepeople() {
            return influencepeople;
        }

        public void setInfluencepeople(int influencepeople) {
            this.influencepeople = influencepeople;
        }

        public int getInfluencemoney() {
            return influencemoney;
        }

        public void setInfluencemoney(int influencemoney) {
            this.influencemoney = influencemoney;
        }

        public Object getOther() {
            return other;
        }

        public void setOther(Object other) {
            this.other = other;
        }

        public String getResurgencefactor() {
            return resurgencefactor;
        }

        public void setResurgencefactor(String resurgencefactor) {
            this.resurgencefactor = resurgencefactor;
        }

        public String getLolstate() {
            return lolstate;
        }

        public void setLolstate(String lolstate) {
            this.lolstate = lolstate;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }
    }

    public static class S8Bean {
        /**
         * id : B1BE9481E9CC4084BAA7F68FE2FFA491
         * number : null
         * landlidecodeing : 3501221002S
         * ppnum : 3.50182E12
         * warningname : 闀夸箰甯傝亴涓氫腑涓撳鏍�
         * longitude : 94.9494
         * latitude : 26.2626
         * elevation : 0
         * areapeople : 0
         * preparename : 0.0
         * soonname : 0.0
         * relevance : null
         * target : null
         * remark : null
         * datasources : 绂忓缓鐪侀暱涔愬競鍥藉湡灞�
         */

        private String id;
        private Object number;
        private String landlidecodeing;
        private String ppnum;
        private String warningname;
        private double longitude;
        private double latitude;
        private int elevation;
        private int areapeople;
        private String preparename;
        private String soonname;
        private Object relevance;
        private Object target;
        private Object remark;
        private String datasources;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getNumber() {
            return number;
        }

        public void setNumber(Object number) {
            this.number = number;
        }

        public String getLandlidecodeing() {
            return landlidecodeing;
        }

        public void setLandlidecodeing(String landlidecodeing) {
            this.landlidecodeing = landlidecodeing;
        }

        public String getPpnum() {
            return ppnum;
        }

        public void setPpnum(String ppnum) {
            this.ppnum = ppnum;
        }

        public String getWarningname() {
            return warningname;
        }

        public void setWarningname(String warningname) {
            this.warningname = warningname;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public int getElevation() {
            return elevation;
        }

        public void setElevation(int elevation) {
            this.elevation = elevation;
        }

        public int getAreapeople() {
            return areapeople;
        }

        public void setAreapeople(int areapeople) {
            this.areapeople = areapeople;
        }

        public String getPreparename() {
            return preparename;
        }

        public void setPreparename(String preparename) {
            this.preparename = preparename;
        }

        public String getSoonname() {
            return soonname;
        }

        public void setSoonname(String soonname) {
            this.soonname = soonname;
        }

        public Object getRelevance() {
            return relevance;
        }

        public void setRelevance(Object relevance) {
            this.relevance = relevance;
        }

        public Object getTarget() {
            return target;
        }

        public void setTarget(Object target) {
            this.target = target;
        }

        public Object getRemark() {
            return remark;
        }

        public void setRemark(Object remark) {
            this.remark = remark;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }
    }

    public static class S9Bean {
        /**
         * id : 2FDF98EE42994E3B9725438A15CD60EF
         * number : null
         * landlidecodeing : 3501221002S
         * stationstation : F1004
         * sequencelength : 0.0
         * preparer : 濮氭灄濉�
         * checker : 濮氭灄濉�
         * examinant : 濮氭灄濉�
         * telephone : 8.3920524E7
         * filloutlol : null
         * filloutdata : null
         * datasources : 绂忓窞甯傛皵璞″眬
         */

        private String id;
        private Object number;
        private String landlidecodeing;
        private String stationstation;
        private String sequencelength;
        private String preparer;
        private String checker;
        private String examinant;
        private String telephone;
        private Object filloutlol;
        private Object filloutdata;
        private String datasources;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getNumber() {
            return number;
        }

        public void setNumber(Object number) {
            this.number = number;
        }

        public String getLandlidecodeing() {
            return landlidecodeing;
        }

        public void setLandlidecodeing(String landlidecodeing) {
            this.landlidecodeing = landlidecodeing;
        }

        public String getStationstation() {
            return stationstation;
        }

        public void setStationstation(String stationstation) {
            this.stationstation = stationstation;
        }

        public String getSequencelength() {
            return sequencelength;
        }

        public void setSequencelength(String sequencelength) {
            this.sequencelength = sequencelength;
        }

        public String getPreparer() {
            return preparer;
        }

        public void setPreparer(String preparer) {
            this.preparer = preparer;
        }

        public String getChecker() {
            return checker;
        }

        public void setChecker(String checker) {
            this.checker = checker;
        }

        public String getExaminant() {
            return examinant;
        }

        public void setExaminant(String examinant) {
            this.examinant = examinant;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public Object getFilloutlol() {
            return filloutlol;
        }

        public void setFilloutlol(Object filloutlol) {
            this.filloutlol = filloutlol;
        }

        public Object getFilloutdata() {
            return filloutdata;
        }

        public void setFilloutdata(Object filloutdata) {
            this.filloutdata = filloutdata;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }
    }

    public static class S8ReadiesBean {
        /**
         * id : 2424435A2F6D44DBB1D32E1574EB33FA
         * number : null
         * codes : 3501221002S
         * ppnum : 3.50182E12
         * warningPointName : 灏嗗啗灞辨柊鏉�1鍙锋ゼ
         * immediateTransferTime : 5
         * earlyWarningIndex : 12
         */

        private String id;
        private Object number;
        private String codes;
        private String ppnum;
        private String warningPointName;
        private int immediateTransferTime;
        private int earlyWarningIndex;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getNumber() {
            return number;
        }

        public void setNumber(Object number) {
            this.number = number;
        }

        public String getCodes() {
            return codes;
        }

        public void setCodes(String codes) {
            this.codes = codes;
        }

        public String getPpnum() {
            return ppnum;
        }

        public void setPpnum(String ppnum) {
            this.ppnum = ppnum;
        }

        public String getWarningPointName() {
            return warningPointName;
        }

        public void setWarningPointName(String warningPointName) {
            this.warningPointName = warningPointName;
        }

        public int getImmediateTransferTime() {
            return immediateTransferTime;
        }

        public void setImmediateTransferTime(int immediateTransferTime) {
            this.immediateTransferTime = immediateTransferTime;
        }

        public int getEarlyWarningIndex() {
            return earlyWarningIndex;
        }

        public void setEarlyWarningIndex(int earlyWarningIndex) {
            this.earlyWarningIndex = earlyWarningIndex;
        }
    }

    public static class S2Bean {
        /**
         * id : 0BC610EA98D9428CB9CE11BE624D82FF
         * number : null
         * landlidecodeing : 3501221002S
         * ppnum : 3.50122E12
         * landlidetype : null
         * landlidenature : null
         * microrelief : null
         * riverseat : null
         * floodstage : 0
         * lowwaterlevel : 0
         * slopeheight : 0
         * slope : 0
         * slopeshape : null
         * materialcomposition : null
         * earthquakeintensity : null
         * characteristiclength : 25
         * characteristicwidth : 50
         * characteristicthickness : 3
         * landslidearea : 0
         * volume : 3750
         * watertype : null
         * burieddepth : 0
         * supplytype : null
         * forest : 0
         * shrub : 0
         * grassland : 0
         * slopefarmland : 0
         * steepfarmland : 0
         * utilizationland : 0
         * houseland : 0
         * otherland : 0
         * remotenumber : null
         * photoname : null
         * comfrom : 鍥藉湡灞�
         * starttime : 38628.354166666664
         */

        private String id;
        private Object number;
        private String landlidecodeing;
        private String ppnum;
        private Object landlidetype;
        private Object landlidenature;
        private Object microrelief;
        private Object riverseat;
        private int floodstage;
        private int lowwaterlevel;
        private int slopeheight;
        private int slope;
        private Object slopeshape;
        private Object materialcomposition;
        private Object earthquakeintensity;
        private int characteristiclength;
        private int characteristicwidth;
        private int characteristicthickness;
        private int landslidearea;
        private int volume;
        private Object watertype;
        private int burieddepth;
        private Object supplytype;
        private int forest;
        private int shrub;
        private int grassland;
        private int slopefarmland;
        private int steepfarmland;
        private int utilizationland;
        private int houseland;
        private int otherland;
        private Object remotenumber;
        private Object photoname;
        private String comfrom;
        private String starttime;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Object getNumber() {
            return number;
        }

        public void setNumber(Object number) {
            this.number = number;
        }

        public String getLandlidecodeing() {
            return landlidecodeing;
        }

        public void setLandlidecodeing(String landlidecodeing) {
            this.landlidecodeing = landlidecodeing;
        }

        public String getPpnum() {
            return ppnum;
        }

        public void setPpnum(String ppnum) {
            this.ppnum = ppnum;
        }

        public Object getLandlidetype() {
            return landlidetype;
        }

        public void setLandlidetype(Object landlidetype) {
            this.landlidetype = landlidetype;
        }

        public Object getLandlidenature() {
            return landlidenature;
        }

        public void setLandlidenature(Object landlidenature) {
            this.landlidenature = landlidenature;
        }

        public Object getMicrorelief() {
            return microrelief;
        }

        public void setMicrorelief(Object microrelief) {
            this.microrelief = microrelief;
        }

        public Object getRiverseat() {
            return riverseat;
        }

        public void setRiverseat(Object riverseat) {
            this.riverseat = riverseat;
        }

        public int getFloodstage() {
            return floodstage;
        }

        public void setFloodstage(int floodstage) {
            this.floodstage = floodstage;
        }

        public int getLowwaterlevel() {
            return lowwaterlevel;
        }

        public void setLowwaterlevel(int lowwaterlevel) {
            this.lowwaterlevel = lowwaterlevel;
        }

        public int getSlopeheight() {
            return slopeheight;
        }

        public void setSlopeheight(int slopeheight) {
            this.slopeheight = slopeheight;
        }

        public int getSlope() {
            return slope;
        }

        public void setSlope(int slope) {
            this.slope = slope;
        }

        public Object getSlopeshape() {
            return slopeshape;
        }

        public void setSlopeshape(Object slopeshape) {
            this.slopeshape = slopeshape;
        }

        public Object getMaterialcomposition() {
            return materialcomposition;
        }

        public void setMaterialcomposition(Object materialcomposition) {
            this.materialcomposition = materialcomposition;
        }

        public Object getEarthquakeintensity() {
            return earthquakeintensity;
        }

        public void setEarthquakeintensity(Object earthquakeintensity) {
            this.earthquakeintensity = earthquakeintensity;
        }

        public int getCharacteristiclength() {
            return characteristiclength;
        }

        public void setCharacteristiclength(int characteristiclength) {
            this.characteristiclength = characteristiclength;
        }

        public int getCharacteristicwidth() {
            return characteristicwidth;
        }

        public void setCharacteristicwidth(int characteristicwidth) {
            this.characteristicwidth = characteristicwidth;
        }

        public int getCharacteristicthickness() {
            return characteristicthickness;
        }

        public void setCharacteristicthickness(int characteristicthickness) {
            this.characteristicthickness = characteristicthickness;
        }

        public int getLandslidearea() {
            return landslidearea;
        }

        public void setLandslidearea(int landslidearea) {
            this.landslidearea = landslidearea;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        public Object getWatertype() {
            return watertype;
        }

        public void setWatertype(Object watertype) {
            this.watertype = watertype;
        }

        public int getBurieddepth() {
            return burieddepth;
        }

        public void setBurieddepth(int burieddepth) {
            this.burieddepth = burieddepth;
        }

        public Object getSupplytype() {
            return supplytype;
        }

        public void setSupplytype(Object supplytype) {
            this.supplytype = supplytype;
        }

        public int getForest() {
            return forest;
        }

        public void setForest(int forest) {
            this.forest = forest;
        }

        public int getShrub() {
            return shrub;
        }

        public void setShrub(int shrub) {
            this.shrub = shrub;
        }

        public int getGrassland() {
            return grassland;
        }

        public void setGrassland(int grassland) {
            this.grassland = grassland;
        }

        public int getSlopefarmland() {
            return slopefarmland;
        }

        public void setSlopefarmland(int slopefarmland) {
            this.slopefarmland = slopefarmland;
        }

        public int getSteepfarmland() {
            return steepfarmland;
        }

        public void setSteepfarmland(int steepfarmland) {
            this.steepfarmland = steepfarmland;
        }

        public int getUtilizationland() {
            return utilizationland;
        }

        public void setUtilizationland(int utilizationland) {
            this.utilizationland = utilizationland;
        }

        public int getHouseland() {
            return houseland;
        }

        public void setHouseland(int houseland) {
            this.houseland = houseland;
        }

        public int getOtherland() {
            return otherland;
        }

        public void setOtherland(int otherland) {
            this.otherland = otherland;
        }

        public Object getRemotenumber() {
            return remotenumber;
        }

        public void setRemotenumber(Object remotenumber) {
            this.remotenumber = remotenumber;
        }

        public Object getPhotoname() {
            return photoname;
        }

        public void setPhotoname(Object photoname) {
            this.photoname = photoname;
        }

        public String getComfrom() {
            return comfrom;
        }

        public void setComfrom(String comfrom) {
            this.comfrom = comfrom;
        }

        public String getStarttime() {
            return starttime;
        }

        public void setStarttime(String starttime) {
            this.starttime = starttime;
        }
    }
}
