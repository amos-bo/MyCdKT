package com.ktcd.malc.kt_ma_lc.responseparam;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2017/7/12.
 */

public class CollapseResouresInfoListResponse implements Serializable{


    /**
     * total : 260
     * rows : [{"rcId":1,"rcCode":"2","rcCounty":"梅县区","rcCountry":"白渡","rcVillage":"径口","rcGroup":"新屋","rcLongitude":116.1935,"rcLatitude":24.3101,"rcScale":"小型","rcThreatenPopulation":12,"rcThreatenProperty":27.8,"rcMonitor":"钟汉清","rcMonitorTel":"2772518","rcMonitorPhone":"13543209961","rcMonitorResponsible":"钟建仪","rcMonitorRTel":"2772518","rcMonitorRPhone":"13823800160","rcPotentialHarm":"中型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往右边走"},{"updateTime":"2017-06-12 09:46:11","rcId":2,"rcCode":"4","rcCounty":"梅县区","rcCountry":"白渡","rcVillage":"凤岭","rcGroup":"第一","rcLongitude":116.145,"rcLatitude":24.3231,"rcScale":"小型","rcThreatenPopulation":5,"rcThreatenProperty":4.22,"rcMonitor":"刘永旺","rcMonitorTel":"2673179","rcMonitorPhone":"13549116566","rcMonitorResponsible":"刘建元","rcMonitorRTel":"2673823","rcMonitorRPhone":"13902781782","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到村委会安置","rcEvacuationRoute":"往左边走"},{"rcId":3,"rcCode":"5","rcCounty":"梅县区","rcCountry":"白渡","rcVillage":"建桥","rcGroup":"旗山","rcLongitude":116.1327,"rcLatitude":24.2639,"rcScale":"小型","rcThreatenPopulation":8,"rcThreatenProperty":10.76,"rcMonitor":"谢德安","rcMonitorTel":"2672162","rcMonitorPhone":"13723678686","rcMonitorResponsible":"谢妙群","rcMonitorRTel":"2672383","rcMonitorRPhone":"13719951348","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、复合土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到村委会安置","rcEvacuationRoute":"往右边走"},{"rcId":4,"rcCode":"9","rcCounty":"梅县区","rcCountry":"白渡","rcVillage":"赋梅","rcGroup":"深田","rcLongitude":116.1232,"rcLatitude":24.3108,"rcScale":"小型","rcThreatenPopulation":6,"rcThreatenProperty":6.3,"rcMonitor":"宋达球","rcMonitorTel":"2678732","rcMonitorPhone":"13411288164","rcMonitorResponsible":"宋维政","rcMonitorRTel":"2678281","rcMonitorRPhone":"13560965716","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往右边走"},{"rcId":5,"rcCode":"10","rcCounty":"梅县区","rcCountry":"白渡","rcVillage":"赋梅","rcGroup":"质田","rcLongitude":116.1228,"rcLatitude":24.305,"rcScale":"小型","rcThreatenPopulation":18,"rcThreatenProperty":11.3,"rcMonitor":"宋伯兰","rcMonitorTel":"2678035","rcMonitorPhone":"13536714789","rcMonitorResponsible":"宋维政","rcMonitorRTel":"2678281","rcMonitorRPhone":"13560965716","rcPotentialHarm":"中型","rcGeologicalConditions":"丘陵地貌、花岗岩强风化土","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往右边走"},{"rcId":6,"rcCode":"12","rcCounty":"梅县区","rcCountry":"白渡","rcVillage":"悦来","rcGroup":"大陂2","rcLongitude":116.1129,"rcLatitude":24.2645,"rcScale":"小型","rcThreatenPopulation":4,"rcThreatenProperty":1.5,"rcMonitor":"钟奕雄","rcMonitorPhone":"13539173216","rcMonitorResponsible":"李洁清","rcMonitorRPhone":"13923013693","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到村委会安置","rcEvacuationRoute":"往右边走"},{"rcId":7,"rcCode":"13","rcCounty":"梅县区","rcCountry":"白渡","rcVillage":"悦来","rcGroup":"大陂3","rcLongitude":116.1118,"rcLatitude":24.2628,"rcScale":"小型","rcThreatenPopulation":4,"rcThreatenProperty":1.5,"rcMonitor":"钟育生","rcMonitorTel":"2672378","rcMonitorPhone":"13539196620","rcMonitorResponsible":"李洁清","rcMonitorRPhone":"13923013693","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往左边走"},{"rcId":8,"rcCode":"14","rcCounty":"梅县区","rcCountry":"白渡","rcVillage":"三和","rcGroup":"连珠坝","rcLongitude":116.1325,"rcLatitude":24.2552,"rcScale":"小型","rcThreatenPopulation":24,"rcThreatenProperty":21,"rcMonitor":"谢梅兆","rcMonitorTel":"2672986","rcMonitorPhone":"13509091519","rcMonitorResponsible":"陈凤中","rcMonitorRTel":"2672012","rcMonitorRPhone":"15916531600","rcPotentialHarm":"中型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往右边走"},{"rcId":9,"rcCode":"16","rcCounty":"梅县区","rcCountry":"白渡","rcVillage":"半步","rcGroup":"新田仔","rcLongitude":116.1223,"rcLatitude":24.3225,"rcScale":"小型","rcThreatenPopulation":4,"rcThreatenProperty":0.6,"rcMonitor":"谢云战","rcMonitorPhone":"13536740752","rcMonitorResponsible":"宋苑连","rcMonitorRPhone":"13824585541","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、花岗岩强风化土","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"工程治理","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往右边走"},{"rcId":10,"rcCode":"21","rcCounty":"梅县区","rcCountry":"白渡","rcVillage":"峰溪","rcGroup":"上溪口上一","rcLongitude":116.1608,"rcLatitude":24.3305,"rcScale":"小型","rcThreatenPopulation":5,"rcThreatenProperty":25,"rcMonitor":"吴碧宏","rcMonitorPhone":"13549194067","rcMonitorResponsible":"曾淦尧","rcMonitorRPhone":"13719963960","rcPotentialHarm":"小型","rcGeologicalConditions":"土质","rcDeformationCharacteristics":"2013年5月22日发生过崩塌","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、贴纸监测","rcSuggest":"工程治理等","rcAlarmMethod":"鸣锣等","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往安全地带走"},{"rcId":11,"rcCode":"40","rcCounty":"梅县区","rcCountry":"丙村","rcVillage":"银二","rcGroup":"伯公岌","rcLongitude":116.1301,"rcLatitude":24.2112,"rcScale":"小型","rcThreatenPopulation":1,"rcThreatenProperty":0.5,"rcMonitor":"赖仁志","rcMonitorPhone":"13622974042","rcMonitorResponsible":"余书祥","rcMonitorRTel":"2151622","rcMonitorRPhone":"13823802305","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、复合土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往右边走"},{"rcId":12,"rcCode":"41","rcCounty":"梅县区","rcCountry":"丙村","rcVillage":"黄梅","rcGroup":"黄梅","rcLongitude":116.1751,"rcLatitude":24.2147,"rcScale":"小型","rcThreatenPopulation":4,"rcThreatenProperty":6,"rcMonitor":"廖明江","rcMonitorPhone":"13549186332","rcMonitorResponsible":"曾桓科","rcMonitorRTel":"2852595","rcMonitorRPhone":"13923034705","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、复合土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往右边走"},{"rcId":13,"rcCode":"42","rcCounty":"梅县区","rcCountry":"丙村","rcVillage":"银竹","rcGroup":"银竹","rcLongitude":116.1444,"rcLatitude":24.2143,"rcScale":"小型","rcThreatenPopulation":5,"rcThreatenProperty":8,"rcMonitor":"林锦江","rcMonitorPhone":"13823818926","rcMonitorResponsible":"刘孟隆","rcMonitorRTel":"2859743","rcMonitorRPhone":"13502540250","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、复合土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往左边走"},{"rcId":14,"rcCode":"43","rcCounty":"梅县区","rcCountry":"丙村","rcVillage":"大雅","rcGroup":"大雅","rcLongitude":116.1439,"rcLatitude":24.2359,"rcScale":"小型","rcThreatenPopulation":3,"rcThreatenProperty":5,"rcMonitor":"邹托贤","rcMonitorPhone":"13430136963","rcMonitorResponsible":"邹文标","rcMonitorRPhone":"13923047912","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵、二叠系下统栖霞灰岩。","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往右边走"},{"rcId":15,"rcCode":"44","rcCounty":"梅县区","rcCountry":"丙村","rcVillage":"芦陵","rcGroup":"芦陵","rcLongitude":116.1627,"rcLatitude":24.2647,"rcScale":"小型","rcThreatenPopulation":3,"rcThreatenProperty":5,"rcMonitor":"叶伟环","rcMonitorPhone":"13549177566","rcMonitorResponsible":"叶迪彪","rcMonitorRPhone":"13690863836","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到村委会安置","rcEvacuationRoute":"往左边走"},{"rcId":16,"rcCode":"45","rcCounty":"梅县区","rcCountry":"丙村","rcVillage":"旋风","rcGroup":"正坑钟仕达","rcLongitude":116.1548,"rcLatitude":24.2415,"rcScale":"小型","rcThreatenPopulation":1,"rcThreatenProperty":0.3,"rcMonitor":"钟仕金","rcMonitorTel":"2851283","rcMonitorPhone":"13924471873","rcMonitorResponsible":"叶柳青","rcMonitorRTel":"2851283","rcMonitorRPhone":"13823894459","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往左边走"},{"rcId":17,"rcCode":"53","rcCounty":"梅县区","rcCountry":"程江","rcVillage":"横岗","rcGroup":"三","rcLongitude":116.0428,"rcLatitude":24.1219,"rcScale":"小型","rcThreatenPopulation":14,"rcThreatenProperty":12.9,"rcMonitor":"范秀荣","rcMonitorPhone":"13450704669","rcMonitorResponsible":"范润协","rcMonitorRPhone":"13502330303","rcPotentialHarm":"中型","rcGeologicalConditions":"丘陵地貌、第四系、复合土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往右边走"},{"rcId":18,"rcCode":"54","rcCounty":"梅县区","rcCountry":"程江","rcVillage":"长滩","rcGroup":"沙罗背","rcLongitude":116.0111,"rcLatitude":24.1829,"rcScale":"小型","rcThreatenPopulation":8,"rcThreatenProperty":4.2,"rcMonitor":"古纪德","rcMonitorPhone":"13823803801","rcMonitorResponsible":"高烈昌","rcMonitorRPhone":"13723683680","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、复合土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往右边走"},{"rcId":19,"rcCode":"56","rcCounty":"梅县区","rcCountry":"程江","rcVillage":"横岗","rcGroup":"冰坑","rcLongitude":116.0431,"rcLatitude":24.1232,"rcScale":"小型","rcThreatenPopulation":2,"rcThreatenProperty":1.3,"rcMonitor":"胡烈才","rcMonitorPhone":"13825983291","rcMonitorResponsible":"范润协","rcMonitorRPhone":"13502330303","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、复合土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到村委会安置","rcEvacuationRoute":"往右边走"},{"rcId":20,"rcCode":"60","rcCounty":"梅县区","rcCountry":"程江","rcVillage":"横岗","rcGroup":"四组吕福祥屋","rcLongitude":116.045,"rcLatitude":24.1252,"rcScale":"小型","rcThreatenPopulation":4,"rcThreatenProperty":1,"rcMonitor":"范秀荣","rcMonitorPhone":"13450704669","rcMonitorResponsible":"范润协","rcMonitorRPhone":"13502330303","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到村委会安置","rcEvacuationRoute":"往右边走"},{"rcId":21,"rcCode":"61","rcCounty":"梅县区","rcCountry":"程江","rcVillage":"横岗","rcGroup":"二组熊权定","rcLongitude":116.0402,"rcLatitude":24.1215,"rcScale":"小型","rcThreatenPopulation":4,"rcThreatenProperty":2,"rcMonitor":"范秀荣","rcMonitorPhone":"13450704669","rcMonitorResponsible":"范润协","rcMonitorRPhone":"13502330304","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到村委会安置","rcEvacuationRoute":"往右边走"},{"rcId":22,"rcCode":"62","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"三台","rcGroup":"第一","rcLongitude":115.5633,"rcLatitude":24.2118,"rcScale":"小型","rcThreatenPopulation":4,"rcThreatenProperty":1.2,"rcMonitor":"钟良华","rcMonitorPhone":"1343182245","rcMonitorResponsible":"曾凤英","rcMonitorRPhone":"15917942648","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、花岗岩强风化土","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到村委会安置","rcEvacuationRoute":"往右边走"},{"rcId":23,"rcCode":"66","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"育豪","rcGroup":"农会","rcLongitude":115.5955,"rcLatitude":24.2434,"rcScale":"小型","rcThreatenPopulation":13,"rcThreatenProperty":2,"rcMonitor":"杨耀宗","rcMonitorPhone":"13549188548","rcMonitorResponsible":"廖念恩","rcMonitorRPhone":"13543237161","rcPotentialHarm":"中型","rcGeologicalConditions":"丘陵地貌、第四系、复合土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往右边走"},{"rcId":24,"rcCode":"67","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"营里","rcGroup":"大坑","rcLongitude":115.5908,"rcLatitude":24.2516,"rcScale":"小型","rcThreatenPopulation":2,"rcThreatenProperty":1.8,"rcMonitor":"李海生","rcMonitorTel":"2642842","rcMonitorResponsible":"李会安","rcMonitorRPhone":"13549146323","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、花岗岩强风化土","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到村委会安置","rcEvacuationRoute":"往左边走"},{"rcId":25,"rcCode":"71","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"三台","rcGroup":"下梨坑2","rcLongitude":115.5653,"rcLatitude":24.2102,"rcScale":"小型","rcThreatenPopulation":12,"rcThreatenProperty":2,"rcMonitor":"钟淼生","rcMonitorTel":"2640642","rcMonitorResponsible":"曾凤英","rcMonitorRPhone":"15917942648","rcPotentialHarm":"中型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"较差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往右边走"},{"rcId":26,"rcCode":"72","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"守台","rcGroup":"邓屋","rcLongitude":115.5547,"rcLatitude":24.2158,"rcScale":"小型","rcThreatenPopulation":80,"rcThreatenProperty":12,"rcMonitor":"邓勇","rcMonitorPhone":"13723623416","rcMonitorResponsible":"李春芬","rcMonitorRPhone":"13727649580","rcPotentialHarm":"中型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"较差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往右边走"},{"rcId":27,"rcCode":"73","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"育豪","rcGroup":"河背","rcLongitude":115.5916,"rcLatitude":24.2441,"rcScale":"小型","rcThreatenPopulation":3,"rcThreatenProperty":18,"rcMonitor":"李素平","rcMonitorPhone":"13824585356","rcMonitorResponsible":"郭宏兴","rcMonitorRPhone":"13549103058","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"云彩楼","rcEvacuationRoute":"往右边走"},{"rcId":28,"rcCode":"74","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"育豪","rcGroup":"河背路","rcLongitude":115.5916,"rcLatitude":24.2457,"rcScale":"小型","rcThreatenPopulation":10,"rcThreatenProperty":2.5,"rcMonitor":"李素平","rcMonitorPhone":"13824585356","rcMonitorResponsible":"廖念恩","rcMonitorRPhone":"13543237161","rcPotentialHarm":"中型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往右边走"},{"rcId":29,"rcCode":"75","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"育豪","rcGroup":"樟坑里","rcLongitude":115.5942,"rcLatitude":24.2454,"rcScale":"小型","rcThreatenPopulation":8,"rcThreatenProperty":10.8,"rcMonitor":"廖念恩","rcMonitorPhone":"13543237161","rcMonitorResponsible":"廖念恩","rcMonitorRPhone":"13543237161","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往右边走"},{"rcId":30,"rcCode":"76","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"坪畲","rcGroup":"兰岌","rcLongitude":115.5625,"rcLatitude":24.252,"rcScale":"小型","rcThreatenPopulation":7,"rcThreatenProperty":3,"rcMonitor":"李锦发","rcMonitorPhone":"13823810899","rcMonitorResponsible":"李珍朋","rcMonitorRPhone":"15917947439","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到村委会安置","rcEvacuationRoute":"往右边走"},{"rcId":31,"rcCode":"77","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"坪畲","rcGroup":"塘二1","rcLongitude":115.554,"rcLatitude":24.2351,"rcScale":"小型","rcThreatenPopulation":5,"rcThreatenProperty":1.5,"rcMonitor":"李运良","rcMonitorPhone":"13723645417","rcMonitorResponsible":"李珍朋","rcMonitorRPhone":"15917947439","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到村委会安置","rcEvacuationRoute":"往右边走"},{"rcId":32,"rcCode":"78","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"坪畲","rcGroup":"塘二2","rcLongitude":115.5603,"rcLatitude":24.2443,"rcScale":"小型","rcThreatenPopulation":16,"rcThreatenProperty":4,"rcMonitor":"李桂胜","rcMonitorPhone":"15119373974","rcMonitorResponsible":"李珍朋","rcMonitorRPhone":"15917947439","rcPotentialHarm":"中型","rcGeologicalConditions":"丘陵地貌、第四系、复合土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"较差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往左边走"},{"rcId":33,"rcCode":"79","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"上和","rcGroup":"中嶂广元","rcLongitude":115.5722,"rcLatitude":24.235,"rcScale":"小型","rcThreatenPopulation":7,"rcThreatenProperty":8,"rcMonitor":"蓝广元","rcMonitorTel":"2648327","rcMonitorPhone":"13549151322","rcMonitorResponsible":"蓝玉芬","rcMonitorRPhone":"13723649297","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"上和小学","rcEvacuationRoute":"往左边走"},{"rcId":34,"rcCode":"80","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"雷甘","rcGroup":"甘水1","rcLongitude":115.5912,"rcLatitude":24.2144,"rcScale":"小型","rcThreatenPopulation":19,"rcThreatenProperty":6,"rcMonitor":"吴启元","rcMonitorPhone":"13549183530","rcMonitorResponsible":"吴小莉","rcMonitorRPhone":"13549183530","rcPotentialHarm":"中型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"较差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到村委会安置","rcEvacuationRoute":"往左边走"},{"rcId":35,"rcCode":"81","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"雷甘","rcGroup":"甘水2","rcLongitude":115.594,"rcLatitude":24.213,"rcScale":"小型","rcThreatenPopulation":14,"rcThreatenProperty":7,"rcMonitor":"吴雄岳","rcMonitorPhone":"13539181774","rcMonitorResponsible":"吴小莉","rcMonitorRPhone":"13549183530","rcPotentialHarm":"中型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"较差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到村委会安置","rcEvacuationRoute":"往右边走"},{"rcId":36,"rcCode":"82","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"206国道","rcGroup":"200-250","rcLongitude":115.5945,"rcLatitude":24.2537,"rcScale":"小型","rcThreatenPopulation":0,"rcThreatenProperty":2.5,"rcMonitor":"古翠娇","rcMonitorPhone":"13719988026","rcMonitorResponsible":"古翠娇","rcMonitorRPhone":"13719988026","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、复合土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往左边走"},{"rcId":37,"rcCode":"83","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"206国道","rcGroup":"2139-500","rcLongitude":115.5938,"rcLatitude":24.2547,"rcScale":"小型","rcThreatenPopulation":0,"rcThreatenProperty":10,"rcMonitor":"古翠娇","rcMonitorPhone":"13719988026","rcMonitorResponsible":"古翠娇","rcMonitorRPhone":"13719988026","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、复合土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到村委会安置","rcEvacuationRoute":"往右边走"},{"rcId":38,"rcCode":"84","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"206国道","rcGroup":"900-950","rcLongitude":115.5943,"rcLatitude":24.2542,"rcScale":"小型","rcThreatenPopulation":0,"rcThreatenProperty":2.5,"rcMonitor":"古翠娇","rcMonitorPhone":"13719988026","rcMonitorResponsible":"古翠娇","rcMonitorRPhone":"13719988026","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往左边走"},{"rcId":39,"rcCode":"85","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"206国道","rcGroup":"100-150","rcLongitude":115.5947,"rcLatitude":24.2524,"rcScale":"小型","rcThreatenPopulation":0,"rcThreatenProperty":2.5,"rcMonitor":"古翠娇","rcMonitorPhone":"13719988026","rcMonitorResponsible":"古翠娇","rcMonitorRPhone":"13719988026","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到村委会安置","rcEvacuationRoute":"往右边走"},{"rcId":40,"rcCode":"86","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"平中","rcLongitude":115.5747,"rcLatitude":24.204,"rcScale":"小型","rcThreatenPopulation":5,"rcThreatenProperty":5,"rcMonitor":"张勇梅","rcMonitorPhone":"13549140675","rcMonitorResponsible":"张勇梅","rcMonitorRPhone":"13549140675","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到村委会安置","rcEvacuationRoute":"往左边走"},{"rcId":41,"rcCode":"100","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"营里","rcGroup":"大坑曹带英","rcLongitude":115.591,"rcLatitude":24.2513,"rcScale":"小型","rcThreatenPopulation":2,"rcThreatenProperty":0.8,"rcMonitor":"曹带英","rcMonitorPhone":"13431804835","rcMonitorResponsible":"钟新平","rcMonitorRPhone":"13727609551","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到亲戚家","rcEvacuationRoute":"往左边走"},{"rcId":42,"rcCode":"101","rcCounty":"梅县区","rcCountry":"大坪","rcVillage":"清连","rcGroup":"下岌卢菊珍","rcLongitude":115.5817,"rcLatitude":24.2417,"rcScale":"小型","rcThreatenPopulation":2,"rcThreatenProperty":0.7,"rcMonitor":"卢菊珍","rcMonitorPhone":"13539172549","rcMonitorResponsible":"杨新云","rcMonitorRPhone":"13539172549","rcPotentialHarm":"小型","rcGeologicalConditions":"丘陵地貌、第四系、土质","rcDeformationCharacteristics":"未变形","rcStabilityAnalysis":"差","rcTriggeringFactor":"持续强降雨","rcMonitoringMethod":"目视检查、监测","rcSuggest":"遇持续强降雨、应避让、搬迁","rcAlarmMethod":"鸣锣报警","rcDisasterLocation":"到村委会安置","rcEvacuationRoute":"往右边走"}]
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

    public static class RowsBean {
        /**
         * rcId : 1
         * rcCode : 2
         * rcCounty : 梅县区
         * rcCountry : 白渡
         * rcVillage : 径口
         * rcGroup : 新屋
         * rcLongitude : 116.1935
         * rcLatitude : 24.3101
         * rcScale : 小型
         * rcThreatenPopulation : 12
         * rcThreatenProperty : 27.8
         * rcMonitor : 钟汉清
         * rcMonitorTel : 2772518
         * rcMonitorPhone : 13543209961
         * rcMonitorResponsible : 钟建仪
         * rcMonitorRTel : 2772518
         * rcMonitorRPhone : 13823800160
         * rcPotentialHarm : 中型
         * rcGeologicalConditions : 丘陵地貌、第四系、土质
         * rcDeformationCharacteristics : 未变形
         * rcStabilityAnalysis : 差
         * rcTriggeringFactor : 持续强降雨
         * rcMonitoringMethod : 目视检查、监测
         * rcSuggest : 遇持续强降雨、应避让、搬迁
         * rcAlarmMethod : 鸣锣报警
         * rcDisasterLocation : 到亲戚家
         * rcEvacuationRoute : 往右边走
         * updateTime : 2017-06-12 09:46:11
         */

        private int rcId;
        private String rcCode;
        private String rcCounty;
        private String rcCountry;
        private String rcVillage;
        private String rcGroup;
        private double rcLongitude;
        private double rcLatitude;
        private String rcScale;
        private int rcThreatenPopulation;
        private double rcThreatenProperty;
        private String rcMonitor;
        private String rcMonitorTel;
        private String rcMonitorPhone;
        private String rcMonitorResponsible;
        private String rcMonitorRTel;
        private String rcMonitorRPhone;
        private String rcPotentialHarm;
        private String rcGeologicalConditions;
        private String rcDeformationCharacteristics;
        private String rcStabilityAnalysis;
        private String rcTriggeringFactor;
        private String rcMonitoringMethod;
        private String rcSuggest;
        private String rcAlarmMethod;
        private String rcDisasterLocation;
        private String rcEvacuationRoute;
        private String updateTime;

        public int getRcId() {
            return rcId;
        }

        public void setRcId(int rcId) {
            this.rcId = rcId;
        }

        public String getRcCode() {
            return rcCode;
        }

        public void setRcCode(String rcCode) {
            this.rcCode = rcCode;
        }

        public String getRcCounty() {
            return rcCounty;
        }

        public void setRcCounty(String rcCounty) {
            this.rcCounty = rcCounty;
        }

        public String getRcCountry() {
            return rcCountry;
        }

        public void setRcCountry(String rcCountry) {
            this.rcCountry = rcCountry;
        }

        public String getRcVillage() {
            return rcVillage;
        }

        public void setRcVillage(String rcVillage) {
            this.rcVillage = rcVillage;
        }

        public String getRcGroup() {
            return rcGroup;
        }

        public void setRcGroup(String rcGroup) {
            this.rcGroup = rcGroup;
        }

        public double getRcLongitude() {
            return rcLongitude;
        }

        public void setRcLongitude(double rcLongitude) {
            this.rcLongitude = rcLongitude;
        }

        public double getRcLatitude() {
            return rcLatitude;
        }

        public void setRcLatitude(double rcLatitude) {
            this.rcLatitude = rcLatitude;
        }

        public String getRcScale() {
            return rcScale;
        }

        public void setRcScale(String rcScale) {
            this.rcScale = rcScale;
        }

        public int getRcThreatenPopulation() {
            return rcThreatenPopulation;
        }

        public void setRcThreatenPopulation(int rcThreatenPopulation) {
            this.rcThreatenPopulation = rcThreatenPopulation;
        }

        public double getRcThreatenProperty() {
            return rcThreatenProperty;
        }

        public void setRcThreatenProperty(double rcThreatenProperty) {
            this.rcThreatenProperty = rcThreatenProperty;
        }

        public String getRcMonitor() {
            return rcMonitor;
        }

        public void setRcMonitor(String rcMonitor) {
            this.rcMonitor = rcMonitor;
        }

        public String getRcMonitorTel() {
            return rcMonitorTel;
        }

        public void setRcMonitorTel(String rcMonitorTel) {
            this.rcMonitorTel = rcMonitorTel;
        }

        public String getRcMonitorPhone() {
            return rcMonitorPhone;
        }

        public void setRcMonitorPhone(String rcMonitorPhone) {
            this.rcMonitorPhone = rcMonitorPhone;
        }

        public String getRcMonitorResponsible() {
            return rcMonitorResponsible;
        }

        public void setRcMonitorResponsible(String rcMonitorResponsible) {
            this.rcMonitorResponsible = rcMonitorResponsible;
        }

        public String getRcMonitorRTel() {
            return rcMonitorRTel;
        }

        public void setRcMonitorRTel(String rcMonitorRTel) {
            this.rcMonitorRTel = rcMonitorRTel;
        }

        public String getRcMonitorRPhone() {
            return rcMonitorRPhone;
        }

        public void setRcMonitorRPhone(String rcMonitorRPhone) {
            this.rcMonitorRPhone = rcMonitorRPhone;
        }

        public String getRcPotentialHarm() {
            return rcPotentialHarm;
        }

        public void setRcPotentialHarm(String rcPotentialHarm) {
            this.rcPotentialHarm = rcPotentialHarm;
        }

        public String getRcGeologicalConditions() {
            return rcGeologicalConditions;
        }

        public void setRcGeologicalConditions(String rcGeologicalConditions) {
            this.rcGeologicalConditions = rcGeologicalConditions;
        }

        public String getRcDeformationCharacteristics() {
            return rcDeformationCharacteristics;
        }

        public void setRcDeformationCharacteristics(String rcDeformationCharacteristics) {
            this.rcDeformationCharacteristics = rcDeformationCharacteristics;
        }

        public String getRcStabilityAnalysis() {
            return rcStabilityAnalysis;
        }

        public void setRcStabilityAnalysis(String rcStabilityAnalysis) {
            this.rcStabilityAnalysis = rcStabilityAnalysis;
        }

        public String getRcTriggeringFactor() {
            return rcTriggeringFactor;
        }

        public void setRcTriggeringFactor(String rcTriggeringFactor) {
            this.rcTriggeringFactor = rcTriggeringFactor;
        }

        public String getRcMonitoringMethod() {
            return rcMonitoringMethod;
        }

        public void setRcMonitoringMethod(String rcMonitoringMethod) {
            this.rcMonitoringMethod = rcMonitoringMethod;
        }

        public String getRcSuggest() {
            return rcSuggest;
        }

        public void setRcSuggest(String rcSuggest) {
            this.rcSuggest = rcSuggest;
        }

        public String getRcAlarmMethod() {
            return rcAlarmMethod;
        }

        public void setRcAlarmMethod(String rcAlarmMethod) {
            this.rcAlarmMethod = rcAlarmMethod;
        }

        public String getRcDisasterLocation() {
            return rcDisasterLocation;
        }

        public void setRcDisasterLocation(String rcDisasterLocation) {
            this.rcDisasterLocation = rcDisasterLocation;
        }

        public String getRcEvacuationRoute() {
            return rcEvacuationRoute;
        }

        public void setRcEvacuationRoute(String rcEvacuationRoute) {
            this.rcEvacuationRoute = rcEvacuationRoute;
        }

        public String getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(String updateTime) {
            this.updateTime = updateTime;
        }
    }
}
