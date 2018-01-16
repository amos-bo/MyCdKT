package com.ktcd.malc.kt_ma_lc.DateManager;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/11/13.
 */

public class FirstMoreDataMountain  implements Serializable{

    /**
     * tv : [{"id":"545","provincename":"云南","disastertype":"山洪","mtname":"密德河山洪沟","mtcode":"GC0000002001A","rivercm":130.6,"tlongitude":104.4375,"tlatitude":26.1119,"relerain":"云南海岱镇","raincount":"泰森多边形法","warningname":"密德村委会","warningcode":"530381109208005","warningcity":"曲靖市","warningburg":"文阁村委会","warningcounty":"宣威市","waringlatitude":26.1125,"warningtowns":"海岱镇","sureway":"指南","warninglongitude":104.4072,"crisisrainhour":6,"elevation":1777,"qperain":66.1,"mtrank":1,"crisislevel":1,"crisisfrain":66.1,"storagetime":"2016-05-26 17:03:30","waterlevel":1,"revisewhy":2,"crisislevelm":1,"madetime":"2015/10/1","datarevisetime":"2016-05-26 17:03:30","fillpeope":"云南","telephone":"87164189223","revisetime":"2016/5/26"},{"id":"313","provincename":"云南","disastertype":"山洪","mtname":"密德河山洪沟","mtcode":"GC0000002001A","rivercm":130.6,"tlongitude":104.4375,"tlatitude":26.1119,"relerain":"云南海岱镇","raincount":"泰森多边形法","warningname":"密德村委会","warningcode":"530381109208005","warningcity":"曲靖市","warningburg":"文阁村委会","warningcounty":"宣威市","waringlatitude":26.1125,"warningtowns":"海岱镇","sureway":"指南","warninglongitude":104.4072,"crisisrainhour":3,"elevation":1777,"qperain":54.5,"mtrank":1,"crisislevel":1,"crisisfrain":54.5,"storagetime":"2016-05-26 17:03:30","waterlevel":1,"revisewhy":2,"crisislevelm":1,"madetime":"2015/10/1","datarevisetime":"2016-05-26 17:03:30","fillpeope":"云南","telephone":"87164189223","revisetime":"2016/5/26"},{"id":"314","provincename":"云南","disastertype":"山洪","mtname":"密德河山洪沟","mtcode":"GC0000002001A","rivercm":130.6,"tlongitude":104.4375,"tlatitude":26.1119,"relerain":"云南海岱镇","raincount":"泰森多边形法","warningname":"密德村委会","warningcode":"530381109208005","warningcity":"曲靖市","warningburg":"文阁村委会","warningcounty":"宣威市","waringlatitude":26.1125,"warningtowns":"海岱镇","sureway":"指南","warninglongitude":104.4072,"crisisrainhour":12,"elevation":1777,"qperain":79.3,"mtrank":1,"crisislevel":1,"crisisfrain":79.3,"storagetime":"2016-05-26 17:03:30","waterlevel":1,"revisewhy":2,"crisislevelm":1,"madetime":"2015/10/1","datarevisetime":"2016-05-26 17:03:30","fillpeope":"云南","telephone":"87164189223","revisetime":"2016/5/26"}]
     * M1 : {"id":"C414EEC0D38A4858AF9B8572A63AF6A5","number":"002","rivercode":"GC000000A","torrentcode":"GC0000002001A","villagescode":"0000212ads","longitude":116.04084557173785,"latitude":24.445715711420792,"altitude":1421,"basicprofile":"无","datasource":"梅县"}
     * M2 : [{"id":"3187BF4D5D4C40DFB04D1D8A7FD94457","number":null,"torrentcode":"GC0000002001A","rivercode":"GC201500","smallwatershedarea":228,"channellength":0,"channelwidth":30,"channeldepth":0.003,"numberofdisasters":0,"longitude":94.9494,"latitude":26.2626,"altitude":150,"remarks":"无","datasources":"各乡镇政府"}]
     * M3 : [{"id":"F1546BEFB81E4C1A85850F732E452F72","number":null,"torrentcode":"GC0000002001A","villagescode":"1101010010010","year":"2010.0","acreage":20.85,"cultivatedarea":2.27,"urbanpopulation":0,"ruralpopulation":1565,"totalpopulation":1565,"residentpopulation":1565,"elderlypopulation":148,"proportionagedpopulation":9.5,"childrenspopulation":243,"percentageofchildren":15.56,"familynumber":423,"housenumber":0,"gdp":2444,"industry":50,"agriculture":2394,"datasources":"各乡镇政府","remarks":"无"}]
     * M4 : [{"id":"7F8E9C3FCF4C43619623CD51570BE852","number":null,"torrentcode":"GC0000002001A","villagescode":"1.10101001001E12","year":"2010.0","nationaltotallength":0,"nationalassets":0,"provincetotallength":9.5,"provinceassets":48,"countytotallength":18.3,"countyassets":1300,"railwaylength":0,"railwayassets":0,"bridgesnumber":5,"bridgesassets":160,"gridlength":32,"gridassets":291,"networklength":0,"networkassets":0,"altvlength":0,"altvassets":0,"stationslength":0,"stationsassets":0,"undergroundnetlength":0,"undergroundnetassets":0,"networktotalassets":0,"heightgradegridlength":0,"heightgradegridassets":0,"lowgradegridlength":32,"heightgradegrid":291,"powerplantsnumber":1,"capacityplant":500,"onagawaassets":500,"gaswellnumber":0,"gaswellassets":0,"oilwellnumber":0,"oilwellassets":0,"pipelinelength":0,"pipelineassets":0,"naturalgaslinelength":0,"naturalgaslineassets":0,"drinkfacilitiesnumber":1,"drinkfacilitiesassets":20,"aqueductlength":11.8,"aqueductassets":72,"waterconservancy":92,"traffichingenumber":0,"traffichingeassets":0,"waterworknumber":0,"waterworkassets":0,"watersupplypipelength":0,"watersupplypipeassets":0,"drainpipelength":0,"drainpipeassets":0,"airsupplypipelength":0,"airsupplypipeassets":0,"datasources":"各乡政府"}]
     * M5 : [{"id":"3C78BCCE42AD464DB7EF8DCDA75FD6C0","number":null,"torrentcode":"GC0000002001A","villagescode":"1.10101001001E12","hiddentroublename":"后庄电站","longitude":94.9494,"latitude":26.2626,"altitude":0,"employeesnumber":0,"companytype":"其他","assets":0,"annualoutputvalue":0,"acreageundercultivation":0,"staplecrop":"0.0","disastertreatment":"0.0","datasources":"乡政府","remarks":"0.0"}]
     * M6 : [{"id":"A108DE9046014D18A1612B3F084D21A5","number":null,"torrentcode":"GC0000002001A","dikecode":"DGC0103000111","diketype":"混凝土堤","embankmentheight":5.7,"designfloodlevel":231.44,"insuringstage":230.4,"warninglevel":228.5,"designflow":3090,"dependableflow":0,"alarmflow":0,"arablelandprotection":4.5,"populationprotect":38500,"remarks":null,"datasources":"防汛办"}]
     * M7 : [{"id":"A694270BB18144DE9D4EC3A2C407458F","number":null,"torrentcode":"GC0000002001A","reservoircode":"SCB0503003145","longitude":94.9494,"latitude":26.2626,"reservoirtype":"小㈡型","managementunit":"洋中镇人民政府","constructionyear":"2040.0","catchmentarea":2.2,"totalstoragecapacity":26,"designfloodlevel":null,"checkfloodstage":120.7,"topfloodlevel":0,"deadwaterlevel":103,"storagelevel":119.2,"floodcontrollevel":114,"floodstorage":4.2,"floodcontrolstorage":0,"damtype":"均质土坝","damlength":106,"damheight":21.5,"crestelevation":121.5,"spillwaytype":"渠式","spillwaybottom":119.2,"wateramountlargest":32.4,"designfloodfrequency":20,"checkfloodfrequency":200,"nowfloodfrequency":0,"designdischargecapacity":0,"checkdischargecapacity":0,"safetydischargecapacity":0,"schedulingdepartment":"县水利局","appraisaldate":"2.0020101E7","safetytype":"0.0","reservoirsituation":"0.0","socialeconomicindicators":"水库主要以灌溉下游800亩农田，综合发电，装机100kw，以及水面养鱼。","warningfacilitiesmeans":"0.0","floodpreventionschemes":"0.0","datasources":"水利局","remarks":"0.0"}]
     * M8 : [{"id":"4594907BDDA14A12A36DB2593D709C66","number":null,"torrentcode":"GC0000002001A","villagescode":"1.10101001001E12","year":"2015.0","totalarea":77,"subtotalbasicfarmland":720,"paddyfieldbasicfarmland":1,"tsubochibasicfarmland":1,"damfieldbasicfarmland":1,"slopecroplandbasic":1,"woodlandsubtotal":1,"woodlandforestland":1,"fruitforestzones":720,"sparseforest":1,"youngstand":1,"grassland":1,"slopes":1,"waterarea":1,"unproductiveland":1,"unusedland":1,"grasscoverage":1,"forestcoverage":1,"datasources":"乡政府","remarks":null}]
     * M9 : [{"id":"9073F53EE1F7480E88961938982BE964","number":null,"torrentcode":"GC0000002001A","villagescode":"3.50426201207E12","agrotype":"红壤","texture":"0.0","porosity":"0.0","structure":"0.0","soilprofile":"0.0","datasources":"实地调查","remarks":"0.0"}]
     * tTorrentHiddentroubles : [{"id":"E52887D6358642BB87BD1BE2E8A64E79","number":null,"torrentcode":"GC0000002001A","villagescode":"1.10101001001E12","hiddentroublename":"后庄电站","segmentname":"aaa","startlongitude":118.1818,"endlongitude":118.1818,"startaltitude":200,"startlatitude":26.2626,"endlatitude":26.2626,"endaltitude":0}]
     * tTorrentWarningindexNows : []
     * tTorrentWarningindexReadies : []
     * tTorrentSublevelditchwidths : [{"id":"4CBF28BE942B43A09ED873748B66EEE0","number":null,"torrentcode":"GC0000002001A","middlesmallcreekscode":"GC201500","mainditchname":"荆溪","mainditchwidth":24.66,"mainditchstartlongitude":119.1919,"mainditchstartlatitude":26.2626,"mainditchendlongitude":119.1919,"mainditchendlatitude":26.2626}]
     * tTorrentSublevelditchdepths : [{"id":"FDC50FF4009F4ECCAF5E8676B9AF0BF4","number":null,"torrentcode":"GC0000002001A","middlesmallcreekscode":"GC201500","mainditchname":"十八重溪","mainditchdepth":3.7,"mainditchstartlongitude":119.1919,"mainditchstartlatitude":26.2626,"mainditchendlongitude":119.1919,"mainditchendlatitude":26.2626}]
     * tTorrentInformation : [{"id":"5D13511D82F5440CBF267EA428F814AD","number":null,"torrentname":"山洪沟名称","torrentcode":"GC0000002001A","province":"福建"}]
     * tTorrentDikeinformations : [{"id":"E2D17209DD8F443AA092050D7ABBAA1E","number":null,"torrentcode":"GC0000002001A","dikecode":"DGC0103000111","segmentname":"混凝土堤","startlongitude":94.9494,"endlongitude":94.9494,"startlatitude":18.18418,"endlatitude":18.1818,"embankmentslength":3090,"embankmentheight":66}]
     * tTorrentFloodlosses : [{"id":"F8981F2790F746E4831F755455E4903D","number":null,"torrentcode":"GC0000002001A","occurrencetime":"1.986070215E9","villagescode":"1101010010010","patchname":"ddddgg","patchlongitude":119.1919,"patchlatitude":100,"patchaltitude":26.2626,"patchinundatedwaterdepth":5,"patchstartedfloodingtime":"1.986070215E9","patchendedfloodingtime":"1.986070215E9","patchsubmergedduration":4}]
     * M11 : [{"id":"5FE2964DCC10458CA0663730EFC26B8D","number":null,"torrentcode":"GC0000002001A","villagescode":"1101010010010","stationnumber":"1101010010010","datasources":"1101010010010","remarks":"1101010010010"}]
     * tTorrentGroovegradients : [{"id":"921702AF18214876AB98FAFE01BD300A","number":null,"torrentcode":"GC0000002001A","middlesmallcreekscode":"GC201500","mainditchname":"高洲溪","startlongitude":118.1818,"startlatitude":26.2626,"endlongitude":118.1818,"endlatitude":26.2626,"groovegradient":0.02}]
     * M10 : [{"id":"79647CD566DA464A9E5D7329D4A7F1AE","number":null,"torrentcode":"GC0000002001A","villagescode":"1101010010010","stationnumber":"1101010010010","datasources":"1101010010010","remarks":"1101010010010"}]
     * tTorrentTransverseprofiles : [{"id":"54EF8F563C22478E94B34545905AE60F","number":null,"torrentcode":"GC0000002001A","middlesmallcreekscode":"GC201500","transverseprofilenumber":"aaaa","transverseprofilestartlon":118.1818,"transverseprofilestartlat":26.2626,"transverseprofileendlon":118.1818,"transverseprofileendlat":26.2626,"transverseprofileimage":null}]
     * M13 : [{"id":"E4216A7928AB4B738DD8B8D475F5C262","number":null,"countylandcode":"350925.0","year":"1944.0","affectednumber":1,"affectedpeople":0,"deadpopulation":48,"agriculturalloss":0,"totaleconomicloss":0,"currentgdp":0,"datasources":"防汛办、民政局","remarks":"有些资料搜集不到"}]
     * M12 : [{"id":"58BF964F0651488E969291124E566048","number":null,"torrentcode":"GC0000002001A","occurrencetime":"2.010061812E9","terminaltime":"2.012081011E9","disasternumber":1,"villagescode":3509222042120,"inundatedarea":0,"submergedduration":0,"damagearea":0,"damagedhouses":0,"dilapidatedbuilding":0,"disasteredpeople":0,"evacuatepeople":0,"deadpopulation":0,"missingperson":0,"totalpopulation":0,"villagesinformation":null,"agriculturalcroptypes":null,"agriculturaldisasterarea":0,"agriculturalcroparea":0,"agriculturalloss":0,"industrialloss":0,"industrialdisasterinformation":null,"affectedenterprises":null,"affectedschool":null,"affectedhospital":null,"directeconomicloss":"0.0","rainfallregimedescribed":null,"disasterdescribed":null,"datasources":"凤埔乡","remarks":null}]
     * M15 : [{"id":"A97F9BE719324393B9579DE807FEB053","number":null,"villagescode":"0000212ads","monitormethod":"有","advancewarningmethod":"有","contingencyplan":"有","reliefgroups":"无","policiesregulations":"有","datasources":"通过了解","remarks":"电信、移动、联通三大通信网全覆盖，当前的预警措施已延伸到村级，广播电视预警也滚动播出，但仍需提高信息传递速度和覆盖面。"}]
     * M14 : [{"id":"48206187F84B45D59ADE974DD6BBFABD","number":null,"torrentcode":"GC0000002001A","warningpointname":"北溪村委会","warningpointlongitude":94.9494,"warningpointlatitude":26.2626,"warningpointaltitude":780,"areapeople":74,"readytransferwarningpoint":"溪河水位达警戒水位","immediatelytransfer":"溪河水位达保证水位","associatedstations":null,"indexsources":"县防汛办","datasources":"县防汛办","remarks":null}]
     */

    private M1Bean M1;
    private List<TvBean> tv;
    private List<M2Bean> M2;
    private List<M3Bean> M3;
    private List<M4Bean> M4;
    private List<M5Bean> M5;
    private List<M6Bean> M6;
    private List<M7Bean> M7;
    private List<M8Bean> M8;
    private List<M9Bean> M9;
    private List<TTorrentHiddentroublesBean> tTorrentHiddentroubles;
    private List<?> tTorrentWarningindexNows;
    private List<?> tTorrentWarningindexReadies;
    private List<TTorrentSublevelditchwidthsBean> tTorrentSublevelditchwidths;
    private List<TTorrentSublevelditchdepthsBean> tTorrentSublevelditchdepths;
    private List<TTorrentInformationBean> tTorrentInformation;
    private List<TTorrentDikeinformationsBean> tTorrentDikeinformations;
    private List<TTorrentFloodlossesBean> tTorrentFloodlosses;
    private List<M11Bean> M11;
    private List<TTorrentGroovegradientsBean> tTorrentGroovegradients;
    private List<M10Bean> M10;
    private List<TTorrentTransverseprofilesBean> tTorrentTransverseprofiles;
    private List<M13Bean> M13;
    private List<M12Bean> M12;
    private List<M15Bean> M15;
    private List<M14Bean> M14;

    public M1Bean getM1() {
        return M1;
    }

    public void setM1(M1Bean M1) {
        this.M1 = M1;
    }

    public List<TvBean> getTv() {
        return tv;
    }

    public void setTv(List<TvBean> tv) {
        this.tv = tv;
    }

    public List<M2Bean> getM2() {
        return M2;
    }

    public void setM2(List<M2Bean> M2) {
        this.M2 = M2;
    }

    public List<M3Bean> getM3() {
        return M3;
    }

    public void setM3(List<M3Bean> M3) {
        this.M3 = M3;
    }

    public List<M4Bean> getM4() {
        return M4;
    }

    public void setM4(List<M4Bean> M4) {
        this.M4 = M4;
    }

    public List<M5Bean> getM5() {
        return M5;
    }

    public void setM5(List<M5Bean> M5) {
        this.M5 = M5;
    }

    public List<M6Bean> getM6() {
        return M6;
    }

    public void setM6(List<M6Bean> M6) {
        this.M6 = M6;
    }

    public List<M7Bean> getM7() {
        return M7;
    }

    public void setM7(List<M7Bean> M7) {
        this.M7 = M7;
    }

    public List<M8Bean> getM8() {
        return M8;
    }

    public void setM8(List<M8Bean> M8) {
        this.M8 = M8;
    }

    public List<M9Bean> getM9() {
        return M9;
    }

    public void setM9(List<M9Bean> M9) {
        this.M9 = M9;
    }

    public List<TTorrentHiddentroublesBean> getTTorrentHiddentroubles() {
        return tTorrentHiddentroubles;
    }

    public void setTTorrentHiddentroubles(List<TTorrentHiddentroublesBean> tTorrentHiddentroubles) {
        this.tTorrentHiddentroubles = tTorrentHiddentroubles;
    }

    public List<?> getTTorrentWarningindexNows() {
        return tTorrentWarningindexNows;
    }

    public void setTTorrentWarningindexNows(List<?> tTorrentWarningindexNows) {
        this.tTorrentWarningindexNows = tTorrentWarningindexNows;
    }

    public List<?> getTTorrentWarningindexReadies() {
        return tTorrentWarningindexReadies;
    }

    public void setTTorrentWarningindexReadies(List<?> tTorrentWarningindexReadies) {
        this.tTorrentWarningindexReadies = tTorrentWarningindexReadies;
    }

    public List<TTorrentSublevelditchwidthsBean> getTTorrentSublevelditchwidths() {
        return tTorrentSublevelditchwidths;
    }

    public void setTTorrentSublevelditchwidths(List<TTorrentSublevelditchwidthsBean> tTorrentSublevelditchwidths) {
        this.tTorrentSublevelditchwidths = tTorrentSublevelditchwidths;
    }

    public List<TTorrentSublevelditchdepthsBean> getTTorrentSublevelditchdepths() {
        return tTorrentSublevelditchdepths;
    }

    public void setTTorrentSublevelditchdepths(List<TTorrentSublevelditchdepthsBean> tTorrentSublevelditchdepths) {
        this.tTorrentSublevelditchdepths = tTorrentSublevelditchdepths;
    }

    public List<TTorrentInformationBean> getTTorrentInformation() {
        return tTorrentInformation;
    }

    public void setTTorrentInformation(List<TTorrentInformationBean> tTorrentInformation) {
        this.tTorrentInformation = tTorrentInformation;
    }

    public List<TTorrentDikeinformationsBean> getTTorrentDikeinformations() {
        return tTorrentDikeinformations;
    }

    public void setTTorrentDikeinformations(List<TTorrentDikeinformationsBean> tTorrentDikeinformations) {
        this.tTorrentDikeinformations = tTorrentDikeinformations;
    }

    public List<TTorrentFloodlossesBean> getTTorrentFloodlosses() {
        return tTorrentFloodlosses;
    }

    public void setTTorrentFloodlosses(List<TTorrentFloodlossesBean> tTorrentFloodlosses) {
        this.tTorrentFloodlosses = tTorrentFloodlosses;
    }

    public List<M11Bean> getM11() {
        return M11;
    }

    public void setM11(List<M11Bean> M11) {
        this.M11 = M11;
    }

    public List<TTorrentGroovegradientsBean> getTTorrentGroovegradients() {
        return tTorrentGroovegradients;
    }

    public void setTTorrentGroovegradients(List<TTorrentGroovegradientsBean> tTorrentGroovegradients) {
        this.tTorrentGroovegradients = tTorrentGroovegradients;
    }

    public List<M10Bean> getM10() {
        return M10;
    }

    public void setM10(List<M10Bean> M10) {
        this.M10 = M10;
    }

    public List<TTorrentTransverseprofilesBean> getTTorrentTransverseprofiles() {
        return tTorrentTransverseprofiles;
    }

    public void setTTorrentTransverseprofiles(List<TTorrentTransverseprofilesBean> tTorrentTransverseprofiles) {
        this.tTorrentTransverseprofiles = tTorrentTransverseprofiles;
    }

    public List<M13Bean> getM13() {
        return M13;
    }

    public void setM13(List<M13Bean> M13) {
        this.M13 = M13;
    }

    public List<M12Bean> getM12() {
        return M12;
    }

    public void setM12(List<M12Bean> M12) {
        this.M12 = M12;
    }

    public List<M15Bean> getM15() {
        return M15;
    }

    public void setM15(List<M15Bean> M15) {
        this.M15 = M15;
    }

    public List<M14Bean> getM14() {
        return M14;
    }

    public void setM14(List<M14Bean> M14) {
        this.M14 = M14;
    }

    public static class M1Bean {
        /**
         * id : C414EEC0D38A4858AF9B8572A63AF6A5
         * number : 002
         * rivercode : GC000000A
         * torrentcode : GC0000002001A
         * villagescode : 0000212ads
         * longitude : 116.04084557173785
         * latitude : 24.445715711420792
         * altitude : 1421
         * basicprofile : 无
         * datasource : 梅县
         */

        private String id;
        private String number;
        private String rivercode;
        private String torrentcode;
        private String villagescode;
        private double longitude;
        private double latitude;
        private int altitude;
        private String basicprofile;
        private String datasource;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getNumber() {
            return number;
        }

        public void setNumber(String number) {
            this.number = number;
        }

        public String getRivercode() {
            return rivercode;
        }

        public void setRivercode(String rivercode) {
            this.rivercode = rivercode;
        }

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getVillagescode() {
            return villagescode;
        }

        public void setVillagescode(String villagescode) {
            this.villagescode = villagescode;
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

        public int getAltitude() {
            return altitude;
        }

        public void setAltitude(int altitude) {
            this.altitude = altitude;
        }

        public String getBasicprofile() {
            return basicprofile;
        }

        public void setBasicprofile(String basicprofile) {
            this.basicprofile = basicprofile;
        }

        public String getDatasource() {
            return datasource;
        }

        public void setDatasource(String datasource) {
            this.datasource = datasource;
        }
    }

    public static class TvBean {
        /**
         * id : 545
         * provincename : 云南
         * disastertype : 山洪
         * mtname : 密德河山洪沟
         * mtcode : GC0000002001A
         * rivercm : 130.6
         * tlongitude : 104.4375
         * tlatitude : 26.1119
         * relerain : 云南海岱镇
         * raincount : 泰森多边形法
         * warningname : 密德村委会
         * warningcode : 530381109208005
         * warningcity : 曲靖市
         * warningburg : 文阁村委会
         * warningcounty : 宣威市
         * waringlatitude : 26.1125
         * warningtowns : 海岱镇
         * sureway : 指南
         * warninglongitude : 104.4072
         * crisisrainhour : 6
         * elevation : 1777
         * qperain : 66.1
         * mtrank : 1
         * crisislevel : 1
         * crisisfrain : 66.1
         * storagetime : 2016-05-26 17:03:30
         * waterlevel : 1
         * revisewhy : 2
         * crisislevelm : 1
         * madetime : 2015/10/1
         * datarevisetime : 2016-05-26 17:03:30
         * fillpeope : 云南
         * telephone : 87164189223
         * revisetime : 2016/5/26
         */

        private String id;
        private String provincename;
        private String disastertype;
        private String mtname;
        private String mtcode;
        private double rivercm;
        private double tlongitude;
        private double tlatitude;
        private String relerain;
        private String raincount;
        private String warningname;
        private String warningcode;
        private String warningcity;
        private String warningburg;
        private String warningcounty;
        private double waringlatitude;
        private String warningtowns;
        private String sureway;
        private double warninglongitude;
        private int crisisrainhour;
        private int elevation;
        private double qperain;
        private int mtrank;
        private int crisislevel;
        private double crisisfrain;
        private String storagetime;
        private int waterlevel;
        private int revisewhy;
        private int crisislevelm;
        private String madetime;
        private String datarevisetime;
        private String fillpeope;
        private String telephone;
        private String revisetime;

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

        public String getMtname() {
            return mtname;
        }

        public void setMtname(String mtname) {
            this.mtname = mtname;
        }

        public String getMtcode() {
            return mtcode;
        }

        public void setMtcode(String mtcode) {
            this.mtcode = mtcode;
        }

        public double getRivercm() {
            return rivercm;
        }

        public void setRivercm(double rivercm) {
            this.rivercm = rivercm;
        }

        public double getTlongitude() {
            return tlongitude;
        }

        public void setTlongitude(double tlongitude) {
            this.tlongitude = tlongitude;
        }

        public double getTlatitude() {
            return tlatitude;
        }

        public void setTlatitude(double tlatitude) {
            this.tlatitude = tlatitude;
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

        public String getWarningburg() {
            return warningburg;
        }

        public void setWarningburg(String warningburg) {
            this.warningburg = warningburg;
        }

        public String getWarningcounty() {
            return warningcounty;
        }

        public void setWarningcounty(String warningcounty) {
            this.warningcounty = warningcounty;
        }

        public double getWaringlatitude() {
            return waringlatitude;
        }

        public void setWaringlatitude(double waringlatitude) {
            this.waringlatitude = waringlatitude;
        }

        public String getWarningtowns() {
            return warningtowns;
        }

        public void setWarningtowns(String warningtowns) {
            this.warningtowns = warningtowns;
        }

        public String getSureway() {
            return sureway;
        }

        public void setSureway(String sureway) {
            this.sureway = sureway;
        }

        public double getWarninglongitude() {
            return warninglongitude;
        }

        public void setWarninglongitude(double warninglongitude) {
            this.warninglongitude = warninglongitude;
        }

        public int getCrisisrainhour() {
            return crisisrainhour;
        }

        public void setCrisisrainhour(int crisisrainhour) {
            this.crisisrainhour = crisisrainhour;
        }

        public int getElevation() {
            return elevation;
        }

        public void setElevation(int elevation) {
            this.elevation = elevation;
        }

        public double getQperain() {
            return qperain;
        }

        public void setQperain(double qperain) {
            this.qperain = qperain;
        }

        public int getMtrank() {
            return mtrank;
        }

        public void setMtrank(int mtrank) {
            this.mtrank = mtrank;
        }

        public int getCrisislevel() {
            return crisislevel;
        }

        public void setCrisislevel(int crisislevel) {
            this.crisislevel = crisislevel;
        }

        public double getCrisisfrain() {
            return crisisfrain;
        }

        public void setCrisisfrain(double crisisfrain) {
            this.crisisfrain = crisisfrain;
        }

        public String getStoragetime() {
            return storagetime;
        }

        public void setStoragetime(String storagetime) {
            this.storagetime = storagetime;
        }

        public int getWaterlevel() {
            return waterlevel;
        }

        public void setWaterlevel(int waterlevel) {
            this.waterlevel = waterlevel;
        }

        public int getRevisewhy() {
            return revisewhy;
        }

        public void setRevisewhy(int revisewhy) {
            this.revisewhy = revisewhy;
        }

        public int getCrisislevelm() {
            return crisislevelm;
        }

        public void setCrisislevelm(int crisislevelm) {
            this.crisislevelm = crisislevelm;
        }

        public String getMadetime() {
            return madetime;
        }

        public void setMadetime(String madetime) {
            this.madetime = madetime;
        }

        public String getDatarevisetime() {
            return datarevisetime;
        }

        public void setDatarevisetime(String datarevisetime) {
            this.datarevisetime = datarevisetime;
        }

        public String getFillpeope() {
            return fillpeope;
        }

        public void setFillpeope(String fillpeope) {
            this.fillpeope = fillpeope;
        }

        public String getTelephone() {
            return telephone;
        }

        public void setTelephone(String telephone) {
            this.telephone = telephone;
        }

        public String getRevisetime() {
            return revisetime;
        }

        public void setRevisetime(String revisetime) {
            this.revisetime = revisetime;
        }
    }

    public static class M2Bean {
        /**
         * id : 3187BF4D5D4C40DFB04D1D8A7FD94457
         * number : null
         * torrentcode : GC0000002001A
         * rivercode : GC201500
         * smallwatershedarea : 228
         * channellength : 0
         * channelwidth : 30
         * channeldepth : 0.003
         * numberofdisasters : 0
         * longitude : 94.9494
         * latitude : 26.2626
         * altitude : 150
         * remarks : 无
         * datasources : 各乡镇政府
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String rivercode;
        private int smallwatershedarea;
        private int channellength;
        private int channelwidth;
        private double channeldepth;
        private int numberofdisasters;
        private double longitude;
        private double latitude;
        private int altitude;
        private String remarks;
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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getRivercode() {
            return rivercode;
        }

        public void setRivercode(String rivercode) {
            this.rivercode = rivercode;
        }

        public int getSmallwatershedarea() {
            return smallwatershedarea;
        }

        public void setSmallwatershedarea(int smallwatershedarea) {
            this.smallwatershedarea = smallwatershedarea;
        }

        public int getChannellength() {
            return channellength;
        }

        public void setChannellength(int channellength) {
            this.channellength = channellength;
        }

        public int getChannelwidth() {
            return channelwidth;
        }

        public void setChannelwidth(int channelwidth) {
            this.channelwidth = channelwidth;
        }

        public double getChanneldepth() {
            return channeldepth;
        }

        public void setChanneldepth(double channeldepth) {
            this.channeldepth = channeldepth;
        }

        public int getNumberofdisasters() {
            return numberofdisasters;
        }

        public void setNumberofdisasters(int numberofdisasters) {
            this.numberofdisasters = numberofdisasters;
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

        public int getAltitude() {
            return altitude;
        }

        public void setAltitude(int altitude) {
            this.altitude = altitude;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }
    }

    public static class M3Bean {
        /**
         * id : F1546BEFB81E4C1A85850F732E452F72
         * number : null
         * torrentcode : GC0000002001A
         * villagescode : 1101010010010
         * year : 2010.0
         * acreage : 20.85
         * cultivatedarea : 2.27
         * urbanpopulation : 0
         * ruralpopulation : 1565
         * totalpopulation : 1565
         * residentpopulation : 1565
         * elderlypopulation : 148
         * proportionagedpopulation : 9.5
         * childrenspopulation : 243
         * percentageofchildren : 15.56
         * familynumber : 423
         * housenumber : 0
         * gdp : 2444
         * industry : 50
         * agriculture : 2394
         * datasources : 各乡镇政府
         * remarks : 无
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String villagescode;
        private String year;
        private double acreage;
        private double cultivatedarea;
        private int urbanpopulation;
        private int ruralpopulation;
        private int totalpopulation;
        private int residentpopulation;
        private int elderlypopulation;
        private double proportionagedpopulation;
        private int childrenspopulation;
        private double percentageofchildren;
        private int familynumber;
        private int housenumber;
        private int gdp;
        private int industry;
        private int agriculture;
        private String datasources;
        private String remarks;

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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getVillagescode() {
            return villagescode;
        }

        public void setVillagescode(String villagescode) {
            this.villagescode = villagescode;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public double getAcreage() {
            return acreage;
        }

        public void setAcreage(double acreage) {
            this.acreage = acreage;
        }

        public double getCultivatedarea() {
            return cultivatedarea;
        }

        public void setCultivatedarea(double cultivatedarea) {
            this.cultivatedarea = cultivatedarea;
        }

        public int getUrbanpopulation() {
            return urbanpopulation;
        }

        public void setUrbanpopulation(int urbanpopulation) {
            this.urbanpopulation = urbanpopulation;
        }

        public int getRuralpopulation() {
            return ruralpopulation;
        }

        public void setRuralpopulation(int ruralpopulation) {
            this.ruralpopulation = ruralpopulation;
        }

        public int getTotalpopulation() {
            return totalpopulation;
        }

        public void setTotalpopulation(int totalpopulation) {
            this.totalpopulation = totalpopulation;
        }

        public int getResidentpopulation() {
            return residentpopulation;
        }

        public void setResidentpopulation(int residentpopulation) {
            this.residentpopulation = residentpopulation;
        }

        public int getElderlypopulation() {
            return elderlypopulation;
        }

        public void setElderlypopulation(int elderlypopulation) {
            this.elderlypopulation = elderlypopulation;
        }

        public double getProportionagedpopulation() {
            return proportionagedpopulation;
        }

        public void setProportionagedpopulation(double proportionagedpopulation) {
            this.proportionagedpopulation = proportionagedpopulation;
        }

        public int getChildrenspopulation() {
            return childrenspopulation;
        }

        public void setChildrenspopulation(int childrenspopulation) {
            this.childrenspopulation = childrenspopulation;
        }

        public double getPercentageofchildren() {
            return percentageofchildren;
        }

        public void setPercentageofchildren(double percentageofchildren) {
            this.percentageofchildren = percentageofchildren;
        }

        public int getFamilynumber() {
            return familynumber;
        }

        public void setFamilynumber(int familynumber) {
            this.familynumber = familynumber;
        }

        public int getHousenumber() {
            return housenumber;
        }

        public void setHousenumber(int housenumber) {
            this.housenumber = housenumber;
        }

        public int getGdp() {
            return gdp;
        }

        public void setGdp(int gdp) {
            this.gdp = gdp;
        }

        public int getIndustry() {
            return industry;
        }

        public void setIndustry(int industry) {
            this.industry = industry;
        }

        public int getAgriculture() {
            return agriculture;
        }

        public void setAgriculture(int agriculture) {
            this.agriculture = agriculture;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }
    }

    public static class M4Bean {
        /**
         * id : 7F8E9C3FCF4C43619623CD51570BE852
         * number : null
         * torrentcode : GC0000002001A
         * villagescode : 1.10101001001E12
         * year : 2010.0
         * nationaltotallength : 0
         * nationalassets : 0
         * provincetotallength : 9.5
         * provinceassets : 48
         * countytotallength : 18.3
         * countyassets : 1300
         * railwaylength : 0
         * railwayassets : 0
         * bridgesnumber : 5
         * bridgesassets : 160
         * gridlength : 32
         * gridassets : 291
         * networklength : 0
         * networkassets : 0
         * altvlength : 0
         * altvassets : 0
         * stationslength : 0
         * stationsassets : 0
         * undergroundnetlength : 0
         * undergroundnetassets : 0
         * networktotalassets : 0
         * heightgradegridlength : 0
         * heightgradegridassets : 0
         * lowgradegridlength : 32
         * heightgradegrid : 291
         * powerplantsnumber : 1
         * capacityplant : 500
         * onagawaassets : 500
         * gaswellnumber : 0
         * gaswellassets : 0
         * oilwellnumber : 0
         * oilwellassets : 0
         * pipelinelength : 0
         * pipelineassets : 0
         * naturalgaslinelength : 0
         * naturalgaslineassets : 0
         * drinkfacilitiesnumber : 1
         * drinkfacilitiesassets : 20
         * aqueductlength : 11.8
         * aqueductassets : 72
         * waterconservancy : 92
         * traffichingenumber : 0
         * traffichingeassets : 0
         * waterworknumber : 0
         * waterworkassets : 0
         * watersupplypipelength : 0
         * watersupplypipeassets : 0
         * drainpipelength : 0
         * drainpipeassets : 0
         * airsupplypipelength : 0
         * airsupplypipeassets : 0
         * datasources : 各乡政府
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String villagescode;
        private String year;
        private int nationaltotallength;
        private int nationalassets;
        private double provincetotallength;
        private int provinceassets;
        private double countytotallength;
        private int countyassets;
        private int railwaylength;
        private int railwayassets;
        private int bridgesnumber;
        private int bridgesassets;
        private int gridlength;
        private int gridassets;
        private int networklength;
        private int networkassets;
        private int altvlength;
        private int altvassets;
        private int stationslength;
        private int stationsassets;
        private int undergroundnetlength;
        private int undergroundnetassets;
        private int networktotalassets;
        private int heightgradegridlength;
        private int heightgradegridassets;
        private int lowgradegridlength;
        private int heightgradegrid;
        private int powerplantsnumber;
        private int capacityplant;
        private int onagawaassets;
        private int gaswellnumber;
        private int gaswellassets;
        private int oilwellnumber;
        private int oilwellassets;
        private int pipelinelength;
        private int pipelineassets;
        private int naturalgaslinelength;
        private int naturalgaslineassets;
        private int drinkfacilitiesnumber;
        private int drinkfacilitiesassets;
        private double aqueductlength;
        private int aqueductassets;
        private int waterconservancy;
        private int traffichingenumber;
        private int traffichingeassets;
        private int waterworknumber;
        private int waterworkassets;
        private int watersupplypipelength;
        private int watersupplypipeassets;
        private int drainpipelength;
        private int drainpipeassets;
        private int airsupplypipelength;
        private int airsupplypipeassets;
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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getVillagescode() {
            return villagescode;
        }

        public void setVillagescode(String villagescode) {
            this.villagescode = villagescode;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public int getNationaltotallength() {
            return nationaltotallength;
        }

        public void setNationaltotallength(int nationaltotallength) {
            this.nationaltotallength = nationaltotallength;
        }

        public int getNationalassets() {
            return nationalassets;
        }

        public void setNationalassets(int nationalassets) {
            this.nationalassets = nationalassets;
        }

        public double getProvincetotallength() {
            return provincetotallength;
        }

        public void setProvincetotallength(double provincetotallength) {
            this.provincetotallength = provincetotallength;
        }

        public int getProvinceassets() {
            return provinceassets;
        }

        public void setProvinceassets(int provinceassets) {
            this.provinceassets = provinceassets;
        }

        public double getCountytotallength() {
            return countytotallength;
        }

        public void setCountytotallength(double countytotallength) {
            this.countytotallength = countytotallength;
        }

        public int getCountyassets() {
            return countyassets;
        }

        public void setCountyassets(int countyassets) {
            this.countyassets = countyassets;
        }

        public int getRailwaylength() {
            return railwaylength;
        }

        public void setRailwaylength(int railwaylength) {
            this.railwaylength = railwaylength;
        }

        public int getRailwayassets() {
            return railwayassets;
        }

        public void setRailwayassets(int railwayassets) {
            this.railwayassets = railwayassets;
        }

        public int getBridgesnumber() {
            return bridgesnumber;
        }

        public void setBridgesnumber(int bridgesnumber) {
            this.bridgesnumber = bridgesnumber;
        }

        public int getBridgesassets() {
            return bridgesassets;
        }

        public void setBridgesassets(int bridgesassets) {
            this.bridgesassets = bridgesassets;
        }

        public int getGridlength() {
            return gridlength;
        }

        public void setGridlength(int gridlength) {
            this.gridlength = gridlength;
        }

        public int getGridassets() {
            return gridassets;
        }

        public void setGridassets(int gridassets) {
            this.gridassets = gridassets;
        }

        public int getNetworklength() {
            return networklength;
        }

        public void setNetworklength(int networklength) {
            this.networklength = networklength;
        }

        public int getNetworkassets() {
            return networkassets;
        }

        public void setNetworkassets(int networkassets) {
            this.networkassets = networkassets;
        }

        public int getAltvlength() {
            return altvlength;
        }

        public void setAltvlength(int altvlength) {
            this.altvlength = altvlength;
        }

        public int getAltvassets() {
            return altvassets;
        }

        public void setAltvassets(int altvassets) {
            this.altvassets = altvassets;
        }

        public int getStationslength() {
            return stationslength;
        }

        public void setStationslength(int stationslength) {
            this.stationslength = stationslength;
        }

        public int getStationsassets() {
            return stationsassets;
        }

        public void setStationsassets(int stationsassets) {
            this.stationsassets = stationsassets;
        }

        public int getUndergroundnetlength() {
            return undergroundnetlength;
        }

        public void setUndergroundnetlength(int undergroundnetlength) {
            this.undergroundnetlength = undergroundnetlength;
        }

        public int getUndergroundnetassets() {
            return undergroundnetassets;
        }

        public void setUndergroundnetassets(int undergroundnetassets) {
            this.undergroundnetassets = undergroundnetassets;
        }

        public int getNetworktotalassets() {
            return networktotalassets;
        }

        public void setNetworktotalassets(int networktotalassets) {
            this.networktotalassets = networktotalassets;
        }

        public int getHeightgradegridlength() {
            return heightgradegridlength;
        }

        public void setHeightgradegridlength(int heightgradegridlength) {
            this.heightgradegridlength = heightgradegridlength;
        }

        public int getHeightgradegridassets() {
            return heightgradegridassets;
        }

        public void setHeightgradegridassets(int heightgradegridassets) {
            this.heightgradegridassets = heightgradegridassets;
        }

        public int getLowgradegridlength() {
            return lowgradegridlength;
        }

        public void setLowgradegridlength(int lowgradegridlength) {
            this.lowgradegridlength = lowgradegridlength;
        }

        public int getHeightgradegrid() {
            return heightgradegrid;
        }

        public void setHeightgradegrid(int heightgradegrid) {
            this.heightgradegrid = heightgradegrid;
        }

        public int getPowerplantsnumber() {
            return powerplantsnumber;
        }

        public void setPowerplantsnumber(int powerplantsnumber) {
            this.powerplantsnumber = powerplantsnumber;
        }

        public int getCapacityplant() {
            return capacityplant;
        }

        public void setCapacityplant(int capacityplant) {
            this.capacityplant = capacityplant;
        }

        public int getOnagawaassets() {
            return onagawaassets;
        }

        public void setOnagawaassets(int onagawaassets) {
            this.onagawaassets = onagawaassets;
        }

        public int getGaswellnumber() {
            return gaswellnumber;
        }

        public void setGaswellnumber(int gaswellnumber) {
            this.gaswellnumber = gaswellnumber;
        }

        public int getGaswellassets() {
            return gaswellassets;
        }

        public void setGaswellassets(int gaswellassets) {
            this.gaswellassets = gaswellassets;
        }

        public int getOilwellnumber() {
            return oilwellnumber;
        }

        public void setOilwellnumber(int oilwellnumber) {
            this.oilwellnumber = oilwellnumber;
        }

        public int getOilwellassets() {
            return oilwellassets;
        }

        public void setOilwellassets(int oilwellassets) {
            this.oilwellassets = oilwellassets;
        }

        public int getPipelinelength() {
            return pipelinelength;
        }

        public void setPipelinelength(int pipelinelength) {
            this.pipelinelength = pipelinelength;
        }

        public int getPipelineassets() {
            return pipelineassets;
        }

        public void setPipelineassets(int pipelineassets) {
            this.pipelineassets = pipelineassets;
        }

        public int getNaturalgaslinelength() {
            return naturalgaslinelength;
        }

        public void setNaturalgaslinelength(int naturalgaslinelength) {
            this.naturalgaslinelength = naturalgaslinelength;
        }

        public int getNaturalgaslineassets() {
            return naturalgaslineassets;
        }

        public void setNaturalgaslineassets(int naturalgaslineassets) {
            this.naturalgaslineassets = naturalgaslineassets;
        }

        public int getDrinkfacilitiesnumber() {
            return drinkfacilitiesnumber;
        }

        public void setDrinkfacilitiesnumber(int drinkfacilitiesnumber) {
            this.drinkfacilitiesnumber = drinkfacilitiesnumber;
        }

        public int getDrinkfacilitiesassets() {
            return drinkfacilitiesassets;
        }

        public void setDrinkfacilitiesassets(int drinkfacilitiesassets) {
            this.drinkfacilitiesassets = drinkfacilitiesassets;
        }

        public double getAqueductlength() {
            return aqueductlength;
        }

        public void setAqueductlength(double aqueductlength) {
            this.aqueductlength = aqueductlength;
        }

        public int getAqueductassets() {
            return aqueductassets;
        }

        public void setAqueductassets(int aqueductassets) {
            this.aqueductassets = aqueductassets;
        }

        public int getWaterconservancy() {
            return waterconservancy;
        }

        public void setWaterconservancy(int waterconservancy) {
            this.waterconservancy = waterconservancy;
        }

        public int getTraffichingenumber() {
            return traffichingenumber;
        }

        public void setTraffichingenumber(int traffichingenumber) {
            this.traffichingenumber = traffichingenumber;
        }

        public int getTraffichingeassets() {
            return traffichingeassets;
        }

        public void setTraffichingeassets(int traffichingeassets) {
            this.traffichingeassets = traffichingeassets;
        }

        public int getWaterworknumber() {
            return waterworknumber;
        }

        public void setWaterworknumber(int waterworknumber) {
            this.waterworknumber = waterworknumber;
        }

        public int getWaterworkassets() {
            return waterworkassets;
        }

        public void setWaterworkassets(int waterworkassets) {
            this.waterworkassets = waterworkassets;
        }

        public int getWatersupplypipelength() {
            return watersupplypipelength;
        }

        public void setWatersupplypipelength(int watersupplypipelength) {
            this.watersupplypipelength = watersupplypipelength;
        }

        public int getWatersupplypipeassets() {
            return watersupplypipeassets;
        }

        public void setWatersupplypipeassets(int watersupplypipeassets) {
            this.watersupplypipeassets = watersupplypipeassets;
        }

        public int getDrainpipelength() {
            return drainpipelength;
        }

        public void setDrainpipelength(int drainpipelength) {
            this.drainpipelength = drainpipelength;
        }

        public int getDrainpipeassets() {
            return drainpipeassets;
        }

        public void setDrainpipeassets(int drainpipeassets) {
            this.drainpipeassets = drainpipeassets;
        }

        public int getAirsupplypipelength() {
            return airsupplypipelength;
        }

        public void setAirsupplypipelength(int airsupplypipelength) {
            this.airsupplypipelength = airsupplypipelength;
        }

        public int getAirsupplypipeassets() {
            return airsupplypipeassets;
        }

        public void setAirsupplypipeassets(int airsupplypipeassets) {
            this.airsupplypipeassets = airsupplypipeassets;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }
    }

    public static class M5Bean {
        /**
         * id : 3C78BCCE42AD464DB7EF8DCDA75FD6C0
         * number : null
         * torrentcode : GC0000002001A
         * villagescode : 1.10101001001E12
         * hiddentroublename : 后庄电站
         * longitude : 94.9494
         * latitude : 26.2626
         * altitude : 0
         * employeesnumber : 0
         * companytype : 其他
         * assets : 0
         * annualoutputvalue : 0
         * acreageundercultivation : 0
         * staplecrop : 0.0
         * disastertreatment : 0.0
         * datasources : 乡政府
         * remarks : 0.0
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String villagescode;
        private String hiddentroublename;
        private double longitude;
        private double latitude;
        private int altitude;
        private int employeesnumber;
        private String companytype;
        private int assets;
        private int annualoutputvalue;
        private int acreageundercultivation;
        private String staplecrop;
        private String disastertreatment;
        private String datasources;
        private String remarks;

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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getVillagescode() {
            return villagescode;
        }

        public void setVillagescode(String villagescode) {
            this.villagescode = villagescode;
        }

        public String getHiddentroublename() {
            return hiddentroublename;
        }

        public void setHiddentroublename(String hiddentroublename) {
            this.hiddentroublename = hiddentroublename;
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

        public int getAltitude() {
            return altitude;
        }

        public void setAltitude(int altitude) {
            this.altitude = altitude;
        }

        public int getEmployeesnumber() {
            return employeesnumber;
        }

        public void setEmployeesnumber(int employeesnumber) {
            this.employeesnumber = employeesnumber;
        }

        public String getCompanytype() {
            return companytype;
        }

        public void setCompanytype(String companytype) {
            this.companytype = companytype;
        }

        public int getAssets() {
            return assets;
        }

        public void setAssets(int assets) {
            this.assets = assets;
        }

        public int getAnnualoutputvalue() {
            return annualoutputvalue;
        }

        public void setAnnualoutputvalue(int annualoutputvalue) {
            this.annualoutputvalue = annualoutputvalue;
        }

        public int getAcreageundercultivation() {
            return acreageundercultivation;
        }

        public void setAcreageundercultivation(int acreageundercultivation) {
            this.acreageundercultivation = acreageundercultivation;
        }

        public String getStaplecrop() {
            return staplecrop;
        }

        public void setStaplecrop(String staplecrop) {
            this.staplecrop = staplecrop;
        }

        public String getDisastertreatment() {
            return disastertreatment;
        }

        public void setDisastertreatment(String disastertreatment) {
            this.disastertreatment = disastertreatment;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }
    }

    public static class M6Bean {
        /**
         * id : A108DE9046014D18A1612B3F084D21A5
         * number : null
         * torrentcode : GC0000002001A
         * dikecode : DGC0103000111
         * diketype : 混凝土堤
         * embankmentheight : 5.7
         * designfloodlevel : 231.44
         * insuringstage : 230.4
         * warninglevel : 228.5
         * designflow : 3090
         * dependableflow : 0
         * alarmflow : 0
         * arablelandprotection : 4.5
         * populationprotect : 38500
         * remarks : null
         * datasources : 防汛办
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String dikecode;
        private String diketype;
        private double embankmentheight;
        private double designfloodlevel;
        private double insuringstage;
        private double warninglevel;
        private int designflow;
        private int dependableflow;
        private int alarmflow;
        private double arablelandprotection;
        private int populationprotect;
        private Object remarks;
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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getDikecode() {
            return dikecode;
        }

        public void setDikecode(String dikecode) {
            this.dikecode = dikecode;
        }

        public String getDiketype() {
            return diketype;
        }

        public void setDiketype(String diketype) {
            this.diketype = diketype;
        }

        public double getEmbankmentheight() {
            return embankmentheight;
        }

        public void setEmbankmentheight(double embankmentheight) {
            this.embankmentheight = embankmentheight;
        }

        public double getDesignfloodlevel() {
            return designfloodlevel;
        }

        public void setDesignfloodlevel(double designfloodlevel) {
            this.designfloodlevel = designfloodlevel;
        }

        public double getInsuringstage() {
            return insuringstage;
        }

        public void setInsuringstage(double insuringstage) {
            this.insuringstage = insuringstage;
        }

        public double getWarninglevel() {
            return warninglevel;
        }

        public void setWarninglevel(double warninglevel) {
            this.warninglevel = warninglevel;
        }

        public int getDesignflow() {
            return designflow;
        }

        public void setDesignflow(int designflow) {
            this.designflow = designflow;
        }

        public int getDependableflow() {
            return dependableflow;
        }

        public void setDependableflow(int dependableflow) {
            this.dependableflow = dependableflow;
        }

        public int getAlarmflow() {
            return alarmflow;
        }

        public void setAlarmflow(int alarmflow) {
            this.alarmflow = alarmflow;
        }

        public double getArablelandprotection() {
            return arablelandprotection;
        }

        public void setArablelandprotection(double arablelandprotection) {
            this.arablelandprotection = arablelandprotection;
        }

        public int getPopulationprotect() {
            return populationprotect;
        }

        public void setPopulationprotect(int populationprotect) {
            this.populationprotect = populationprotect;
        }

        public Object getRemarks() {
            return remarks;
        }

        public void setRemarks(Object remarks) {
            this.remarks = remarks;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }
    }

    public static class M7Bean {
        /**
         * id : A694270BB18144DE9D4EC3A2C407458F
         * number : null
         * torrentcode : GC0000002001A
         * reservoircode : SCB0503003145
         * longitude : 94.9494
         * latitude : 26.2626
         * reservoirtype : 小㈡型
         * managementunit : 洋中镇人民政府
         * constructionyear : 2040.0
         * catchmentarea : 2.2
         * totalstoragecapacity : 26
         * designfloodlevel : null
         * checkfloodstage : 120.7
         * topfloodlevel : 0
         * deadwaterlevel : 103
         * storagelevel : 119.2
         * floodcontrollevel : 114
         * floodstorage : 4.2
         * floodcontrolstorage : 0
         * damtype : 均质土坝
         * damlength : 106
         * damheight : 21.5
         * crestelevation : 121.5
         * spillwaytype : 渠式
         * spillwaybottom : 119.2
         * wateramountlargest : 32.4
         * designfloodfrequency : 20
         * checkfloodfrequency : 200
         * nowfloodfrequency : 0
         * designdischargecapacity : 0
         * checkdischargecapacity : 0
         * safetydischargecapacity : 0
         * schedulingdepartment : 县水利局
         * appraisaldate : 2.0020101E7
         * safetytype : 0.0
         * reservoirsituation : 0.0
         * socialeconomicindicators : 水库主要以灌溉下游800亩农田，综合发电，装机100kw，以及水面养鱼。
         * warningfacilitiesmeans : 0.0
         * floodpreventionschemes : 0.0
         * datasources : 水利局
         * remarks : 0.0
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String reservoircode;
        private double longitude;
        private double latitude;
        private String reservoirtype;
        private String managementunit;
        private String constructionyear;
        private double catchmentarea;
        private int totalstoragecapacity;
        private Object designfloodlevel;
        private double checkfloodstage;
        private int topfloodlevel;
        private int deadwaterlevel;
        private double storagelevel;
        private int floodcontrollevel;
        private double floodstorage;
        private int floodcontrolstorage;
        private String damtype;
        private int damlength;
        private double damheight;
        private double crestelevation;
        private String spillwaytype;
        private double spillwaybottom;
        private double wateramountlargest;
        private int designfloodfrequency;
        private int checkfloodfrequency;
        private int nowfloodfrequency;
        private int designdischargecapacity;
        private int checkdischargecapacity;
        private int safetydischargecapacity;
        private String schedulingdepartment;
        private String appraisaldate;
        private String safetytype;
        private String reservoirsituation;
        private String socialeconomicindicators;
        private String warningfacilitiesmeans;
        private String floodpreventionschemes;
        private String datasources;
        private String remarks;

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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getReservoircode() {
            return reservoircode;
        }

        public void setReservoircode(String reservoircode) {
            this.reservoircode = reservoircode;
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

        public String getReservoirtype() {
            return reservoirtype;
        }

        public void setReservoirtype(String reservoirtype) {
            this.reservoirtype = reservoirtype;
        }

        public String getManagementunit() {
            return managementunit;
        }

        public void setManagementunit(String managementunit) {
            this.managementunit = managementunit;
        }

        public String getConstructionyear() {
            return constructionyear;
        }

        public void setConstructionyear(String constructionyear) {
            this.constructionyear = constructionyear;
        }

        public double getCatchmentarea() {
            return catchmentarea;
        }

        public void setCatchmentarea(double catchmentarea) {
            this.catchmentarea = catchmentarea;
        }

        public int getTotalstoragecapacity() {
            return totalstoragecapacity;
        }

        public void setTotalstoragecapacity(int totalstoragecapacity) {
            this.totalstoragecapacity = totalstoragecapacity;
        }

        public Object getDesignfloodlevel() {
            return designfloodlevel;
        }

        public void setDesignfloodlevel(Object designfloodlevel) {
            this.designfloodlevel = designfloodlevel;
        }

        public double getCheckfloodstage() {
            return checkfloodstage;
        }

        public void setCheckfloodstage(double checkfloodstage) {
            this.checkfloodstage = checkfloodstage;
        }

        public int getTopfloodlevel() {
            return topfloodlevel;
        }

        public void setTopfloodlevel(int topfloodlevel) {
            this.topfloodlevel = topfloodlevel;
        }

        public int getDeadwaterlevel() {
            return deadwaterlevel;
        }

        public void setDeadwaterlevel(int deadwaterlevel) {
            this.deadwaterlevel = deadwaterlevel;
        }

        public double getStoragelevel() {
            return storagelevel;
        }

        public void setStoragelevel(double storagelevel) {
            this.storagelevel = storagelevel;
        }

        public int getFloodcontrollevel() {
            return floodcontrollevel;
        }

        public void setFloodcontrollevel(int floodcontrollevel) {
            this.floodcontrollevel = floodcontrollevel;
        }

        public double getFloodstorage() {
            return floodstorage;
        }

        public void setFloodstorage(double floodstorage) {
            this.floodstorage = floodstorage;
        }

        public int getFloodcontrolstorage() {
            return floodcontrolstorage;
        }

        public void setFloodcontrolstorage(int floodcontrolstorage) {
            this.floodcontrolstorage = floodcontrolstorage;
        }

        public String getDamtype() {
            return damtype;
        }

        public void setDamtype(String damtype) {
            this.damtype = damtype;
        }

        public int getDamlength() {
            return damlength;
        }

        public void setDamlength(int damlength) {
            this.damlength = damlength;
        }

        public double getDamheight() {
            return damheight;
        }

        public void setDamheight(double damheight) {
            this.damheight = damheight;
        }

        public double getCrestelevation() {
            return crestelevation;
        }

        public void setCrestelevation(double crestelevation) {
            this.crestelevation = crestelevation;
        }

        public String getSpillwaytype() {
            return spillwaytype;
        }

        public void setSpillwaytype(String spillwaytype) {
            this.spillwaytype = spillwaytype;
        }

        public double getSpillwaybottom() {
            return spillwaybottom;
        }

        public void setSpillwaybottom(double spillwaybottom) {
            this.spillwaybottom = spillwaybottom;
        }

        public double getWateramountlargest() {
            return wateramountlargest;
        }

        public void setWateramountlargest(double wateramountlargest) {
            this.wateramountlargest = wateramountlargest;
        }

        public int getDesignfloodfrequency() {
            return designfloodfrequency;
        }

        public void setDesignfloodfrequency(int designfloodfrequency) {
            this.designfloodfrequency = designfloodfrequency;
        }

        public int getCheckfloodfrequency() {
            return checkfloodfrequency;
        }

        public void setCheckfloodfrequency(int checkfloodfrequency) {
            this.checkfloodfrequency = checkfloodfrequency;
        }

        public int getNowfloodfrequency() {
            return nowfloodfrequency;
        }

        public void setNowfloodfrequency(int nowfloodfrequency) {
            this.nowfloodfrequency = nowfloodfrequency;
        }

        public int getDesigndischargecapacity() {
            return designdischargecapacity;
        }

        public void setDesigndischargecapacity(int designdischargecapacity) {
            this.designdischargecapacity = designdischargecapacity;
        }

        public int getCheckdischargecapacity() {
            return checkdischargecapacity;
        }

        public void setCheckdischargecapacity(int checkdischargecapacity) {
            this.checkdischargecapacity = checkdischargecapacity;
        }

        public int getSafetydischargecapacity() {
            return safetydischargecapacity;
        }

        public void setSafetydischargecapacity(int safetydischargecapacity) {
            this.safetydischargecapacity = safetydischargecapacity;
        }

        public String getSchedulingdepartment() {
            return schedulingdepartment;
        }

        public void setSchedulingdepartment(String schedulingdepartment) {
            this.schedulingdepartment = schedulingdepartment;
        }

        public String getAppraisaldate() {
            return appraisaldate;
        }

        public void setAppraisaldate(String appraisaldate) {
            this.appraisaldate = appraisaldate;
        }

        public String getSafetytype() {
            return safetytype;
        }

        public void setSafetytype(String safetytype) {
            this.safetytype = safetytype;
        }

        public String getReservoirsituation() {
            return reservoirsituation;
        }

        public void setReservoirsituation(String reservoirsituation) {
            this.reservoirsituation = reservoirsituation;
        }

        public String getSocialeconomicindicators() {
            return socialeconomicindicators;
        }

        public void setSocialeconomicindicators(String socialeconomicindicators) {
            this.socialeconomicindicators = socialeconomicindicators;
        }

        public String getWarningfacilitiesmeans() {
            return warningfacilitiesmeans;
        }

        public void setWarningfacilitiesmeans(String warningfacilitiesmeans) {
            this.warningfacilitiesmeans = warningfacilitiesmeans;
        }

        public String getFloodpreventionschemes() {
            return floodpreventionschemes;
        }

        public void setFloodpreventionschemes(String floodpreventionschemes) {
            this.floodpreventionschemes = floodpreventionschemes;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }
    }

    public static class M8Bean {
        /**
         * id : 4594907BDDA14A12A36DB2593D709C66
         * number : null
         * torrentcode : GC0000002001A
         * villagescode : 1.10101001001E12
         * year : 2015.0
         * totalarea : 77
         * subtotalbasicfarmland : 720
         * paddyfieldbasicfarmland : 1
         * tsubochibasicfarmland : 1
         * damfieldbasicfarmland : 1
         * slopecroplandbasic : 1
         * woodlandsubtotal : 1
         * woodlandforestland : 1
         * fruitforestzones : 720
         * sparseforest : 1
         * youngstand : 1
         * grassland : 1
         * slopes : 1
         * waterarea : 1
         * unproductiveland : 1
         * unusedland : 1
         * grasscoverage : 1
         * forestcoverage : 1
         * datasources : 乡政府
         * remarks : null
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String villagescode;
        private String year;
        private int totalarea;
        private int subtotalbasicfarmland;
        private int paddyfieldbasicfarmland;
        private int tsubochibasicfarmland;
        private int damfieldbasicfarmland;
        private int slopecroplandbasic;
        private int woodlandsubtotal;
        private int woodlandforestland;
        private int fruitforestzones;
        private int sparseforest;
        private int youngstand;
        private int grassland;
        private int slopes;
        private int waterarea;
        private int unproductiveland;
        private int unusedland;
        private int grasscoverage;
        private int forestcoverage;
        private String datasources;
        private Object remarks;

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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getVillagescode() {
            return villagescode;
        }

        public void setVillagescode(String villagescode) {
            this.villagescode = villagescode;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public int getTotalarea() {
            return totalarea;
        }

        public void setTotalarea(int totalarea) {
            this.totalarea = totalarea;
        }

        public int getSubtotalbasicfarmland() {
            return subtotalbasicfarmland;
        }

        public void setSubtotalbasicfarmland(int subtotalbasicfarmland) {
            this.subtotalbasicfarmland = subtotalbasicfarmland;
        }

        public int getPaddyfieldbasicfarmland() {
            return paddyfieldbasicfarmland;
        }

        public void setPaddyfieldbasicfarmland(int paddyfieldbasicfarmland) {
            this.paddyfieldbasicfarmland = paddyfieldbasicfarmland;
        }

        public int getTsubochibasicfarmland() {
            return tsubochibasicfarmland;
        }

        public void setTsubochibasicfarmland(int tsubochibasicfarmland) {
            this.tsubochibasicfarmland = tsubochibasicfarmland;
        }

        public int getDamfieldbasicfarmland() {
            return damfieldbasicfarmland;
        }

        public void setDamfieldbasicfarmland(int damfieldbasicfarmland) {
            this.damfieldbasicfarmland = damfieldbasicfarmland;
        }

        public int getSlopecroplandbasic() {
            return slopecroplandbasic;
        }

        public void setSlopecroplandbasic(int slopecroplandbasic) {
            this.slopecroplandbasic = slopecroplandbasic;
        }

        public int getWoodlandsubtotal() {
            return woodlandsubtotal;
        }

        public void setWoodlandsubtotal(int woodlandsubtotal) {
            this.woodlandsubtotal = woodlandsubtotal;
        }

        public int getWoodlandforestland() {
            return woodlandforestland;
        }

        public void setWoodlandforestland(int woodlandforestland) {
            this.woodlandforestland = woodlandforestland;
        }

        public int getFruitforestzones() {
            return fruitforestzones;
        }

        public void setFruitforestzones(int fruitforestzones) {
            this.fruitforestzones = fruitforestzones;
        }

        public int getSparseforest() {
            return sparseforest;
        }

        public void setSparseforest(int sparseforest) {
            this.sparseforest = sparseforest;
        }

        public int getYoungstand() {
            return youngstand;
        }

        public void setYoungstand(int youngstand) {
            this.youngstand = youngstand;
        }

        public int getGrassland() {
            return grassland;
        }

        public void setGrassland(int grassland) {
            this.grassland = grassland;
        }

        public int getSlopes() {
            return slopes;
        }

        public void setSlopes(int slopes) {
            this.slopes = slopes;
        }

        public int getWaterarea() {
            return waterarea;
        }

        public void setWaterarea(int waterarea) {
            this.waterarea = waterarea;
        }

        public int getUnproductiveland() {
            return unproductiveland;
        }

        public void setUnproductiveland(int unproductiveland) {
            this.unproductiveland = unproductiveland;
        }

        public int getUnusedland() {
            return unusedland;
        }

        public void setUnusedland(int unusedland) {
            this.unusedland = unusedland;
        }

        public int getGrasscoverage() {
            return grasscoverage;
        }

        public void setGrasscoverage(int grasscoverage) {
            this.grasscoverage = grasscoverage;
        }

        public int getForestcoverage() {
            return forestcoverage;
        }

        public void setForestcoverage(int forestcoverage) {
            this.forestcoverage = forestcoverage;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }

        public Object getRemarks() {
            return remarks;
        }

        public void setRemarks(Object remarks) {
            this.remarks = remarks;
        }
    }

    public static class M9Bean {
        /**
         * id : 9073F53EE1F7480E88961938982BE964
         * number : null
         * torrentcode : GC0000002001A
         * villagescode : 3.50426201207E12
         * agrotype : 红壤
         * texture : 0.0
         * porosity : 0.0
         * structure : 0.0
         * soilprofile : 0.0
         * datasources : 实地调查
         * remarks : 0.0
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String villagescode;
        private String agrotype;
        private String texture;
        private String porosity;
        private String structure;
        private String soilprofile;
        private String datasources;
        private String remarks;

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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getVillagescode() {
            return villagescode;
        }

        public void setVillagescode(String villagescode) {
            this.villagescode = villagescode;
        }

        public String getAgrotype() {
            return agrotype;
        }

        public void setAgrotype(String agrotype) {
            this.agrotype = agrotype;
        }

        public String getTexture() {
            return texture;
        }

        public void setTexture(String texture) {
            this.texture = texture;
        }

        public String getPorosity() {
            return porosity;
        }

        public void setPorosity(String porosity) {
            this.porosity = porosity;
        }

        public String getStructure() {
            return structure;
        }

        public void setStructure(String structure) {
            this.structure = structure;
        }

        public String getSoilprofile() {
            return soilprofile;
        }

        public void setSoilprofile(String soilprofile) {
            this.soilprofile = soilprofile;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }
    }

    public static class TTorrentHiddentroublesBean {
        /**
         * id : E52887D6358642BB87BD1BE2E8A64E79
         * number : null
         * torrentcode : GC0000002001A
         * villagescode : 1.10101001001E12
         * hiddentroublename : 后庄电站
         * segmentname : aaa
         * startlongitude : 118.1818
         * endlongitude : 118.1818
         * startaltitude : 200
         * startlatitude : 26.2626
         * endlatitude : 26.2626
         * endaltitude : 0
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String villagescode;
        private String hiddentroublename;
        private String segmentname;
        private double startlongitude;
        private double endlongitude;
        private int startaltitude;
        private double startlatitude;
        private double endlatitude;
        private int endaltitude;

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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getVillagescode() {
            return villagescode;
        }

        public void setVillagescode(String villagescode) {
            this.villagescode = villagescode;
        }

        public String getHiddentroublename() {
            return hiddentroublename;
        }

        public void setHiddentroublename(String hiddentroublename) {
            this.hiddentroublename = hiddentroublename;
        }

        public String getSegmentname() {
            return segmentname;
        }

        public void setSegmentname(String segmentname) {
            this.segmentname = segmentname;
        }

        public double getStartlongitude() {
            return startlongitude;
        }

        public void setStartlongitude(double startlongitude) {
            this.startlongitude = startlongitude;
        }

        public double getEndlongitude() {
            return endlongitude;
        }

        public void setEndlongitude(double endlongitude) {
            this.endlongitude = endlongitude;
        }

        public int getStartaltitude() {
            return startaltitude;
        }

        public void setStartaltitude(int startaltitude) {
            this.startaltitude = startaltitude;
        }

        public double getStartlatitude() {
            return startlatitude;
        }

        public void setStartlatitude(double startlatitude) {
            this.startlatitude = startlatitude;
        }

        public double getEndlatitude() {
            return endlatitude;
        }

        public void setEndlatitude(double endlatitude) {
            this.endlatitude = endlatitude;
        }

        public int getEndaltitude() {
            return endaltitude;
        }

        public void setEndaltitude(int endaltitude) {
            this.endaltitude = endaltitude;
        }
    }

    public static class TTorrentSublevelditchwidthsBean {
        /**
         * id : 4CBF28BE942B43A09ED873748B66EEE0
         * number : null
         * torrentcode : GC0000002001A
         * middlesmallcreekscode : GC201500
         * mainditchname : 荆溪
         * mainditchwidth : 24.66
         * mainditchstartlongitude : 119.1919
         * mainditchstartlatitude : 26.2626
         * mainditchendlongitude : 119.1919
         * mainditchendlatitude : 26.2626
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String middlesmallcreekscode;
        private String mainditchname;
        private double mainditchwidth;
        private double mainditchstartlongitude;
        private double mainditchstartlatitude;
        private double mainditchendlongitude;
        private double mainditchendlatitude;

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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getMiddlesmallcreekscode() {
            return middlesmallcreekscode;
        }

        public void setMiddlesmallcreekscode(String middlesmallcreekscode) {
            this.middlesmallcreekscode = middlesmallcreekscode;
        }

        public String getMainditchname() {
            return mainditchname;
        }

        public void setMainditchname(String mainditchname) {
            this.mainditchname = mainditchname;
        }

        public double getMainditchwidth() {
            return mainditchwidth;
        }

        public void setMainditchwidth(double mainditchwidth) {
            this.mainditchwidth = mainditchwidth;
        }

        public double getMainditchstartlongitude() {
            return mainditchstartlongitude;
        }

        public void setMainditchstartlongitude(double mainditchstartlongitude) {
            this.mainditchstartlongitude = mainditchstartlongitude;
        }

        public double getMainditchstartlatitude() {
            return mainditchstartlatitude;
        }

        public void setMainditchstartlatitude(double mainditchstartlatitude) {
            this.mainditchstartlatitude = mainditchstartlatitude;
        }

        public double getMainditchendlongitude() {
            return mainditchendlongitude;
        }

        public void setMainditchendlongitude(double mainditchendlongitude) {
            this.mainditchendlongitude = mainditchendlongitude;
        }

        public double getMainditchendlatitude() {
            return mainditchendlatitude;
        }

        public void setMainditchendlatitude(double mainditchendlatitude) {
            this.mainditchendlatitude = mainditchendlatitude;
        }
    }

    public static class TTorrentSublevelditchdepthsBean {
        /**
         * id : FDC50FF4009F4ECCAF5E8676B9AF0BF4
         * number : null
         * torrentcode : GC0000002001A
         * middlesmallcreekscode : GC201500
         * mainditchname : 十八重溪
         * mainditchdepth : 3.7
         * mainditchstartlongitude : 119.1919
         * mainditchstartlatitude : 26.2626
         * mainditchendlongitude : 119.1919
         * mainditchendlatitude : 26.2626
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String middlesmallcreekscode;
        private String mainditchname;
        private double mainditchdepth;
        private double mainditchstartlongitude;
        private double mainditchstartlatitude;
        private double mainditchendlongitude;
        private double mainditchendlatitude;

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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getMiddlesmallcreekscode() {
            return middlesmallcreekscode;
        }

        public void setMiddlesmallcreekscode(String middlesmallcreekscode) {
            this.middlesmallcreekscode = middlesmallcreekscode;
        }

        public String getMainditchname() {
            return mainditchname;
        }

        public void setMainditchname(String mainditchname) {
            this.mainditchname = mainditchname;
        }

        public double getMainditchdepth() {
            return mainditchdepth;
        }

        public void setMainditchdepth(double mainditchdepth) {
            this.mainditchdepth = mainditchdepth;
        }

        public double getMainditchstartlongitude() {
            return mainditchstartlongitude;
        }

        public void setMainditchstartlongitude(double mainditchstartlongitude) {
            this.mainditchstartlongitude = mainditchstartlongitude;
        }

        public double getMainditchstartlatitude() {
            return mainditchstartlatitude;
        }

        public void setMainditchstartlatitude(double mainditchstartlatitude) {
            this.mainditchstartlatitude = mainditchstartlatitude;
        }

        public double getMainditchendlongitude() {
            return mainditchendlongitude;
        }

        public void setMainditchendlongitude(double mainditchendlongitude) {
            this.mainditchendlongitude = mainditchendlongitude;
        }

        public double getMainditchendlatitude() {
            return mainditchendlatitude;
        }

        public void setMainditchendlatitude(double mainditchendlatitude) {
            this.mainditchendlatitude = mainditchendlatitude;
        }
    }

    public static class TTorrentInformationBean {
        /**
         * id : 5D13511D82F5440CBF267EA428F814AD
         * number : null
         * torrentname : 山洪沟名称
         * torrentcode : GC0000002001A
         * province : 福建
         */

        private String id;
        private Object number;
        private String torrentname;
        private String torrentcode;
        private String province;

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

        public String getTorrentname() {
            return torrentname;
        }

        public void setTorrentname(String torrentname) {
            this.torrentname = torrentname;
        }

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }
    }

    public static class TTorrentDikeinformationsBean {
        /**
         * id : E2D17209DD8F443AA092050D7ABBAA1E
         * number : null
         * torrentcode : GC0000002001A
         * dikecode : DGC0103000111
         * segmentname : 混凝土堤
         * startlongitude : 94.9494
         * endlongitude : 94.9494
         * startlatitude : 18.18418
         * endlatitude : 18.1818
         * embankmentslength : 3090
         * embankmentheight : 66
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String dikecode;
        private String segmentname;
        private double startlongitude;
        private double endlongitude;
        private double startlatitude;
        private double endlatitude;
        private int embankmentslength;
        private int embankmentheight;

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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getDikecode() {
            return dikecode;
        }

        public void setDikecode(String dikecode) {
            this.dikecode = dikecode;
        }

        public String getSegmentname() {
            return segmentname;
        }

        public void setSegmentname(String segmentname) {
            this.segmentname = segmentname;
        }

        public double getStartlongitude() {
            return startlongitude;
        }

        public void setStartlongitude(double startlongitude) {
            this.startlongitude = startlongitude;
        }

        public double getEndlongitude() {
            return endlongitude;
        }

        public void setEndlongitude(double endlongitude) {
            this.endlongitude = endlongitude;
        }

        public double getStartlatitude() {
            return startlatitude;
        }

        public void setStartlatitude(double startlatitude) {
            this.startlatitude = startlatitude;
        }

        public double getEndlatitude() {
            return endlatitude;
        }

        public void setEndlatitude(double endlatitude) {
            this.endlatitude = endlatitude;
        }

        public int getEmbankmentslength() {
            return embankmentslength;
        }

        public void setEmbankmentslength(int embankmentslength) {
            this.embankmentslength = embankmentslength;
        }

        public int getEmbankmentheight() {
            return embankmentheight;
        }

        public void setEmbankmentheight(int embankmentheight) {
            this.embankmentheight = embankmentheight;
        }
    }

    public static class TTorrentFloodlossesBean {
        /**
         * id : F8981F2790F746E4831F755455E4903D
         * number : null
         * torrentcode : GC0000002001A
         * occurrencetime : 1.986070215E9
         * villagescode : 1101010010010
         * patchname : ddddgg
         * patchlongitude : 119.1919
         * patchlatitude : 100
         * patchaltitude : 26.2626
         * patchinundatedwaterdepth : 5
         * patchstartedfloodingtime : 1.986070215E9
         * patchendedfloodingtime : 1.986070215E9
         * patchsubmergedduration : 4
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String occurrencetime;
        private String villagescode;
        private String patchname;
        private double patchlongitude;
        private int patchlatitude;
        private double patchaltitude;
        private int patchinundatedwaterdepth;
        private String patchstartedfloodingtime;
        private String patchendedfloodingtime;
        private int patchsubmergedduration;

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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getOccurrencetime() {
            return occurrencetime;
        }

        public void setOccurrencetime(String occurrencetime) {
            this.occurrencetime = occurrencetime;
        }

        public String getVillagescode() {
            return villagescode;
        }

        public void setVillagescode(String villagescode) {
            this.villagescode = villagescode;
        }

        public String getPatchname() {
            return patchname;
        }

        public void setPatchname(String patchname) {
            this.patchname = patchname;
        }

        public double getPatchlongitude() {
            return patchlongitude;
        }

        public void setPatchlongitude(double patchlongitude) {
            this.patchlongitude = patchlongitude;
        }

        public int getPatchlatitude() {
            return patchlatitude;
        }

        public void setPatchlatitude(int patchlatitude) {
            this.patchlatitude = patchlatitude;
        }

        public double getPatchaltitude() {
            return patchaltitude;
        }

        public void setPatchaltitude(double patchaltitude) {
            this.patchaltitude = patchaltitude;
        }

        public int getPatchinundatedwaterdepth() {
            return patchinundatedwaterdepth;
        }

        public void setPatchinundatedwaterdepth(int patchinundatedwaterdepth) {
            this.patchinundatedwaterdepth = patchinundatedwaterdepth;
        }

        public String getPatchstartedfloodingtime() {
            return patchstartedfloodingtime;
        }

        public void setPatchstartedfloodingtime(String patchstartedfloodingtime) {
            this.patchstartedfloodingtime = patchstartedfloodingtime;
        }

        public String getPatchendedfloodingtime() {
            return patchendedfloodingtime;
        }

        public void setPatchendedfloodingtime(String patchendedfloodingtime) {
            this.patchendedfloodingtime = patchendedfloodingtime;
        }

        public int getPatchsubmergedduration() {
            return patchsubmergedduration;
        }

        public void setPatchsubmergedduration(int patchsubmergedduration) {
            this.patchsubmergedduration = patchsubmergedduration;
        }
    }

    public static class M11Bean {
        /**
         * id : 5FE2964DCC10458CA0663730EFC26B8D
         * number : null
         * torrentcode : GC0000002001A
         * villagescode : 1101010010010
         * stationnumber : 1101010010010
         * datasources : 1101010010010
         * remarks : 1101010010010
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String villagescode;
        private String stationnumber;
        private String datasources;
        private String remarks;

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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getVillagescode() {
            return villagescode;
        }

        public void setVillagescode(String villagescode) {
            this.villagescode = villagescode;
        }

        public String getStationnumber() {
            return stationnumber;
        }

        public void setStationnumber(String stationnumber) {
            this.stationnumber = stationnumber;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }
    }

    public static class TTorrentGroovegradientsBean {
        /**
         * id : 921702AF18214876AB98FAFE01BD300A
         * number : null
         * torrentcode : GC0000002001A
         * middlesmallcreekscode : GC201500
         * mainditchname : 高洲溪
         * startlongitude : 118.1818
         * startlatitude : 26.2626
         * endlongitude : 118.1818
         * endlatitude : 26.2626
         * groovegradient : 0.02
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String middlesmallcreekscode;
        private String mainditchname;
        private double startlongitude;
        private double startlatitude;
        private double endlongitude;
        private double endlatitude;
        private double groovegradient;

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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getMiddlesmallcreekscode() {
            return middlesmallcreekscode;
        }

        public void setMiddlesmallcreekscode(String middlesmallcreekscode) {
            this.middlesmallcreekscode = middlesmallcreekscode;
        }

        public String getMainditchname() {
            return mainditchname;
        }

        public void setMainditchname(String mainditchname) {
            this.mainditchname = mainditchname;
        }

        public double getStartlongitude() {
            return startlongitude;
        }

        public void setStartlongitude(double startlongitude) {
            this.startlongitude = startlongitude;
        }

        public double getStartlatitude() {
            return startlatitude;
        }

        public void setStartlatitude(double startlatitude) {
            this.startlatitude = startlatitude;
        }

        public double getEndlongitude() {
            return endlongitude;
        }

        public void setEndlongitude(double endlongitude) {
            this.endlongitude = endlongitude;
        }

        public double getEndlatitude() {
            return endlatitude;
        }

        public void setEndlatitude(double endlatitude) {
            this.endlatitude = endlatitude;
        }

        public double getGroovegradient() {
            return groovegradient;
        }

        public void setGroovegradient(double groovegradient) {
            this.groovegradient = groovegradient;
        }
    }

    public static class M10Bean {
        /**
         * id : 79647CD566DA464A9E5D7329D4A7F1AE
         * number : null
         * torrentcode : GC0000002001A
         * villagescode : 1101010010010
         * stationnumber : 1101010010010
         * datasources : 1101010010010
         * remarks : 1101010010010
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String villagescode;
        private String stationnumber;
        private String datasources;
        private String remarks;

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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getVillagescode() {
            return villagescode;
        }

        public void setVillagescode(String villagescode) {
            this.villagescode = villagescode;
        }

        public String getStationnumber() {
            return stationnumber;
        }

        public void setStationnumber(String stationnumber) {
            this.stationnumber = stationnumber;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }
    }

    public static class TTorrentTransverseprofilesBean {
        /**
         * id : 54EF8F563C22478E94B34545905AE60F
         * number : null
         * torrentcode : GC0000002001A
         * middlesmallcreekscode : GC201500
         * transverseprofilenumber : aaaa
         * transverseprofilestartlon : 118.1818
         * transverseprofilestartlat : 26.2626
         * transverseprofileendlon : 118.1818
         * transverseprofileendlat : 26.2626
         * transverseprofileimage : null
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String middlesmallcreekscode;
        private String transverseprofilenumber;
        private double transverseprofilestartlon;
        private double transverseprofilestartlat;
        private double transverseprofileendlon;
        private double transverseprofileendlat;
        private Object transverseprofileimage;

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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getMiddlesmallcreekscode() {
            return middlesmallcreekscode;
        }

        public void setMiddlesmallcreekscode(String middlesmallcreekscode) {
            this.middlesmallcreekscode = middlesmallcreekscode;
        }

        public String getTransverseprofilenumber() {
            return transverseprofilenumber;
        }

        public void setTransverseprofilenumber(String transverseprofilenumber) {
            this.transverseprofilenumber = transverseprofilenumber;
        }

        public double getTransverseprofilestartlon() {
            return transverseprofilestartlon;
        }

        public void setTransverseprofilestartlon(double transverseprofilestartlon) {
            this.transverseprofilestartlon = transverseprofilestartlon;
        }

        public double getTransverseprofilestartlat() {
            return transverseprofilestartlat;
        }

        public void setTransverseprofilestartlat(double transverseprofilestartlat) {
            this.transverseprofilestartlat = transverseprofilestartlat;
        }

        public double getTransverseprofileendlon() {
            return transverseprofileendlon;
        }

        public void setTransverseprofileendlon(double transverseprofileendlon) {
            this.transverseprofileendlon = transverseprofileendlon;
        }

        public double getTransverseprofileendlat() {
            return transverseprofileendlat;
        }

        public void setTransverseprofileendlat(double transverseprofileendlat) {
            this.transverseprofileendlat = transverseprofileendlat;
        }

        public Object getTransverseprofileimage() {
            return transverseprofileimage;
        }

        public void setTransverseprofileimage(Object transverseprofileimage) {
            this.transverseprofileimage = transverseprofileimage;
        }
    }

    public static class M13Bean {
        /**
         * id : E4216A7928AB4B738DD8B8D475F5C262
         * number : null
         * countylandcode : 350925.0
         * year : 1944.0
         * affectednumber : 1
         * affectedpeople : 0
         * deadpopulation : 48
         * agriculturalloss : 0
         * totaleconomicloss : 0
         * currentgdp : 0
         * datasources : 防汛办、民政局
         * remarks : 有些资料搜集不到
         */

        private String id;
        private Object number;
        private String countylandcode;
        private String year;
        private int affectednumber;
        private int affectedpeople;
        private int deadpopulation;
        private int agriculturalloss;
        private int totaleconomicloss;
        private int currentgdp;
        private String datasources;
        private String remarks;

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

        public String getCountylandcode() {
            return countylandcode;
        }

        public void setCountylandcode(String countylandcode) {
            this.countylandcode = countylandcode;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public int getAffectednumber() {
            return affectednumber;
        }

        public void setAffectednumber(int affectednumber) {
            this.affectednumber = affectednumber;
        }

        public int getAffectedpeople() {
            return affectedpeople;
        }

        public void setAffectedpeople(int affectedpeople) {
            this.affectedpeople = affectedpeople;
        }

        public int getDeadpopulation() {
            return deadpopulation;
        }

        public void setDeadpopulation(int deadpopulation) {
            this.deadpopulation = deadpopulation;
        }

        public int getAgriculturalloss() {
            return agriculturalloss;
        }

        public void setAgriculturalloss(int agriculturalloss) {
            this.agriculturalloss = agriculturalloss;
        }

        public int getTotaleconomicloss() {
            return totaleconomicloss;
        }

        public void setTotaleconomicloss(int totaleconomicloss) {
            this.totaleconomicloss = totaleconomicloss;
        }

        public int getCurrentgdp() {
            return currentgdp;
        }

        public void setCurrentgdp(int currentgdp) {
            this.currentgdp = currentgdp;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }
    }

    public static class M12Bean {
        /**
         * id : 58BF964F0651488E969291124E566048
         * number : null
         * torrentcode : GC0000002001A
         * occurrencetime : 2.010061812E9
         * terminaltime : 2.012081011E9
         * disasternumber : 1
         * villagescode : 3509222042120
         * inundatedarea : 0
         * submergedduration : 0
         * damagearea : 0
         * damagedhouses : 0
         * dilapidatedbuilding : 0
         * disasteredpeople : 0
         * evacuatepeople : 0
         * deadpopulation : 0
         * missingperson : 0
         * totalpopulation : 0
         * villagesinformation : null
         * agriculturalcroptypes : null
         * agriculturaldisasterarea : 0
         * agriculturalcroparea : 0
         * agriculturalloss : 0
         * industrialloss : 0
         * industrialdisasterinformation : null
         * affectedenterprises : null
         * affectedschool : null
         * affectedhospital : null
         * directeconomicloss : 0.0
         * rainfallregimedescribed : null
         * disasterdescribed : null
         * datasources : 凤埔乡
         * remarks : null
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String occurrencetime;
        private String terminaltime;
        private int disasternumber;
        private long villagescode;
        private int inundatedarea;
        private int submergedduration;
        private int damagearea;
        private int damagedhouses;
        private int dilapidatedbuilding;
        private int disasteredpeople;
        private int evacuatepeople;
        private int deadpopulation;
        private int missingperson;
        private int totalpopulation;
        private Object villagesinformation;
        private Object agriculturalcroptypes;
        private int agriculturaldisasterarea;
        private int agriculturalcroparea;
        private int agriculturalloss;
        private int industrialloss;
        private Object industrialdisasterinformation;
        private Object affectedenterprises;
        private Object affectedschool;
        private Object affectedhospital;
        private String directeconomicloss;
        private Object rainfallregimedescribed;
        private Object disasterdescribed;
        private String datasources;
        private Object remarks;

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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getOccurrencetime() {
            return occurrencetime;
        }

        public void setOccurrencetime(String occurrencetime) {
            this.occurrencetime = occurrencetime;
        }

        public String getTerminaltime() {
            return terminaltime;
        }

        public void setTerminaltime(String terminaltime) {
            this.terminaltime = terminaltime;
        }

        public int getDisasternumber() {
            return disasternumber;
        }

        public void setDisasternumber(int disasternumber) {
            this.disasternumber = disasternumber;
        }

        public long getVillagescode() {
            return villagescode;
        }

        public void setVillagescode(long villagescode) {
            this.villagescode = villagescode;
        }

        public int getInundatedarea() {
            return inundatedarea;
        }

        public void setInundatedarea(int inundatedarea) {
            this.inundatedarea = inundatedarea;
        }

        public int getSubmergedduration() {
            return submergedduration;
        }

        public void setSubmergedduration(int submergedduration) {
            this.submergedduration = submergedduration;
        }

        public int getDamagearea() {
            return damagearea;
        }

        public void setDamagearea(int damagearea) {
            this.damagearea = damagearea;
        }

        public int getDamagedhouses() {
            return damagedhouses;
        }

        public void setDamagedhouses(int damagedhouses) {
            this.damagedhouses = damagedhouses;
        }

        public int getDilapidatedbuilding() {
            return dilapidatedbuilding;
        }

        public void setDilapidatedbuilding(int dilapidatedbuilding) {
            this.dilapidatedbuilding = dilapidatedbuilding;
        }

        public int getDisasteredpeople() {
            return disasteredpeople;
        }

        public void setDisasteredpeople(int disasteredpeople) {
            this.disasteredpeople = disasteredpeople;
        }

        public int getEvacuatepeople() {
            return evacuatepeople;
        }

        public void setEvacuatepeople(int evacuatepeople) {
            this.evacuatepeople = evacuatepeople;
        }

        public int getDeadpopulation() {
            return deadpopulation;
        }

        public void setDeadpopulation(int deadpopulation) {
            this.deadpopulation = deadpopulation;
        }

        public int getMissingperson() {
            return missingperson;
        }

        public void setMissingperson(int missingperson) {
            this.missingperson = missingperson;
        }

        public int getTotalpopulation() {
            return totalpopulation;
        }

        public void setTotalpopulation(int totalpopulation) {
            this.totalpopulation = totalpopulation;
        }

        public Object getVillagesinformation() {
            return villagesinformation;
        }

        public void setVillagesinformation(Object villagesinformation) {
            this.villagesinformation = villagesinformation;
        }

        public Object getAgriculturalcroptypes() {
            return agriculturalcroptypes;
        }

        public void setAgriculturalcroptypes(Object agriculturalcroptypes) {
            this.agriculturalcroptypes = agriculturalcroptypes;
        }

        public int getAgriculturaldisasterarea() {
            return agriculturaldisasterarea;
        }

        public void setAgriculturaldisasterarea(int agriculturaldisasterarea) {
            this.agriculturaldisasterarea = agriculturaldisasterarea;
        }

        public int getAgriculturalcroparea() {
            return agriculturalcroparea;
        }

        public void setAgriculturalcroparea(int agriculturalcroparea) {
            this.agriculturalcroparea = agriculturalcroparea;
        }

        public int getAgriculturalloss() {
            return agriculturalloss;
        }

        public void setAgriculturalloss(int agriculturalloss) {
            this.agriculturalloss = agriculturalloss;
        }

        public int getIndustrialloss() {
            return industrialloss;
        }

        public void setIndustrialloss(int industrialloss) {
            this.industrialloss = industrialloss;
        }

        public Object getIndustrialdisasterinformation() {
            return industrialdisasterinformation;
        }

        public void setIndustrialdisasterinformation(Object industrialdisasterinformation) {
            this.industrialdisasterinformation = industrialdisasterinformation;
        }

        public Object getAffectedenterprises() {
            return affectedenterprises;
        }

        public void setAffectedenterprises(Object affectedenterprises) {
            this.affectedenterprises = affectedenterprises;
        }

        public Object getAffectedschool() {
            return affectedschool;
        }

        public void setAffectedschool(Object affectedschool) {
            this.affectedschool = affectedschool;
        }

        public Object getAffectedhospital() {
            return affectedhospital;
        }

        public void setAffectedhospital(Object affectedhospital) {
            this.affectedhospital = affectedhospital;
        }

        public String getDirecteconomicloss() {
            return directeconomicloss;
        }

        public void setDirecteconomicloss(String directeconomicloss) {
            this.directeconomicloss = directeconomicloss;
        }

        public Object getRainfallregimedescribed() {
            return rainfallregimedescribed;
        }

        public void setRainfallregimedescribed(Object rainfallregimedescribed) {
            this.rainfallregimedescribed = rainfallregimedescribed;
        }

        public Object getDisasterdescribed() {
            return disasterdescribed;
        }

        public void setDisasterdescribed(Object disasterdescribed) {
            this.disasterdescribed = disasterdescribed;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }

        public Object getRemarks() {
            return remarks;
        }

        public void setRemarks(Object remarks) {
            this.remarks = remarks;
        }
    }

    public static class M15Bean {
        /**
         * id : A97F9BE719324393B9579DE807FEB053
         * number : null
         * villagescode : 0000212ads
         * monitormethod : 有
         * advancewarningmethod : 有
         * contingencyplan : 有
         * reliefgroups : 无
         * policiesregulations : 有
         * datasources : 通过了解
         * remarks : 电信、移动、联通三大通信网全覆盖，当前的预警措施已延伸到村级，广播电视预警也滚动播出，但仍需提高信息传递速度和覆盖面。
         */

        private String id;
        private Object number;
        private String villagescode;
        private String monitormethod;
        private String advancewarningmethod;
        private String contingencyplan;
        private String reliefgroups;
        private String policiesregulations;
        private String datasources;
        private String remarks;

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

        public String getVillagescode() {
            return villagescode;
        }

        public void setVillagescode(String villagescode) {
            this.villagescode = villagescode;
        }

        public String getMonitormethod() {
            return monitormethod;
        }

        public void setMonitormethod(String monitormethod) {
            this.monitormethod = monitormethod;
        }

        public String getAdvancewarningmethod() {
            return advancewarningmethod;
        }

        public void setAdvancewarningmethod(String advancewarningmethod) {
            this.advancewarningmethod = advancewarningmethod;
        }

        public String getContingencyplan() {
            return contingencyplan;
        }

        public void setContingencyplan(String contingencyplan) {
            this.contingencyplan = contingencyplan;
        }

        public String getReliefgroups() {
            return reliefgroups;
        }

        public void setReliefgroups(String reliefgroups) {
            this.reliefgroups = reliefgroups;
        }

        public String getPoliciesregulations() {
            return policiesregulations;
        }

        public void setPoliciesregulations(String policiesregulations) {
            this.policiesregulations = policiesregulations;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }

        public String getRemarks() {
            return remarks;
        }

        public void setRemarks(String remarks) {
            this.remarks = remarks;
        }
    }

    public static class M14Bean {
        /**
         * id : 48206187F84B45D59ADE974DD6BBFABD
         * number : null
         * torrentcode : GC0000002001A
         * warningpointname : 北溪村委会
         * warningpointlongitude : 94.9494
         * warningpointlatitude : 26.2626
         * warningpointaltitude : 780
         * areapeople : 74
         * readytransferwarningpoint : 溪河水位达警戒水位
         * immediatelytransfer : 溪河水位达保证水位
         * associatedstations : null
         * indexsources : 县防汛办
         * datasources : 县防汛办
         * remarks : null
         */

        private String id;
        private Object number;
        private String torrentcode;
        private String warningpointname;
        private double warningpointlongitude;
        private double warningpointlatitude;
        private int warningpointaltitude;
        private int areapeople;
        private String readytransferwarningpoint;
        private String immediatelytransfer;
        private Object associatedstations;
        private String indexsources;
        private String datasources;
        private Object remarks;

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

        public String getTorrentcode() {
            return torrentcode;
        }

        public void setTorrentcode(String torrentcode) {
            this.torrentcode = torrentcode;
        }

        public String getWarningpointname() {
            return warningpointname;
        }

        public void setWarningpointname(String warningpointname) {
            this.warningpointname = warningpointname;
        }

        public double getWarningpointlongitude() {
            return warningpointlongitude;
        }

        public void setWarningpointlongitude(double warningpointlongitude) {
            this.warningpointlongitude = warningpointlongitude;
        }

        public double getWarningpointlatitude() {
            return warningpointlatitude;
        }

        public void setWarningpointlatitude(double warningpointlatitude) {
            this.warningpointlatitude = warningpointlatitude;
        }

        public int getWarningpointaltitude() {
            return warningpointaltitude;
        }

        public void setWarningpointaltitude(int warningpointaltitude) {
            this.warningpointaltitude = warningpointaltitude;
        }

        public int getAreapeople() {
            return areapeople;
        }

        public void setAreapeople(int areapeople) {
            this.areapeople = areapeople;
        }

        public String getReadytransferwarningpoint() {
            return readytransferwarningpoint;
        }

        public void setReadytransferwarningpoint(String readytransferwarningpoint) {
            this.readytransferwarningpoint = readytransferwarningpoint;
        }

        public String getImmediatelytransfer() {
            return immediatelytransfer;
        }

        public void setImmediatelytransfer(String immediatelytransfer) {
            this.immediatelytransfer = immediatelytransfer;
        }

        public Object getAssociatedstations() {
            return associatedstations;
        }

        public void setAssociatedstations(Object associatedstations) {
            this.associatedstations = associatedstations;
        }

        public String getIndexsources() {
            return indexsources;
        }

        public void setIndexsources(String indexsources) {
            this.indexsources = indexsources;
        }

        public String getDatasources() {
            return datasources;
        }

        public void setDatasources(String datasources) {
            this.datasources = datasources;
        }

        public Object getRemarks() {
            return remarks;
        }

        public void setRemarks(Object remarks) {
            this.remarks = remarks;
        }
    }
}
