package com.ktcd.malc.kt_ma_lc.responseparam;

import java.io.Serializable;
import java.util.List;

/**
 * 
     * Title: Place.java    
     * Description: 场所
     * @author 向赵臣       
     * @created 2017年7月13日 下午2:58:31
 */
public class MapPlaceResponse  implements Serializable {


	/**
	 * total : 90
	 * rows : [{"createTime":null,"plId":1,"plShelterName":"白渡镇悦来村卫生站","plLongitude":116.209562,"plLatitude":24.449787,"plAddress":"梅州市梅县区白渡镇悦来村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":5,"plShelterName":"李霞个体牙科诊所","plLongitude":116.102764,"plLatitude":24.294398,"plAddress":"梅州市梅县区雁洋镇雁上村风情街A1-A2","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":6,"plShelterName":"林伟如个体牙科诊所","plLongitude":116.112227,"plLatitude":24.293405,"plAddress":"梅州市梅县区南口镇锦鸡村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":7,"plShelterName":"刘宇杏春堂个体内儿科诊所","plLongitude":116.10546,"plLatitude":24.298464,"plAddress":"梅州市梅县区南口镇车站侧","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":8,"plShelterName":"梅县白渡镇蕉南村卫生站","plLongitude":116.303471,"plLatitude":24.529414,"plAddress":"梅县白渡镇蕉南村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":9,"plShelterName":"梅县白渡镇卫生院嵩灵村卫生室","plLongitude":116.285633,"plLatitude":24.37225,"plAddress":"梅县白渡镇嵩灵村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":10,"plShelterName":"梅县城东镇葵下村卫生站","plLongitude":116.1036,"plLatitude":24.284,"plAddress":"梅县城东镇葵下村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":11,"plShelterName":"梅县程江卫生院扶外诊所","plLongitude":116.108844,"plLatitude":24.291984,"plAddress":"梅县程江镇扶外村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":12,"plShelterName":"梅县荷泗卫生院圩镇诊所","plLongitude":116.11365,"plLatitude":24.303269,"plAddress":"梅县荷泗圩镇","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":13,"plShelterName":"梅县华慧苑实业发展有限公司现代综合门诊部","plLongitude":116.09872,"plLatitude":24.299561,"plAddress":"梅州市梅县区嘉应西路华慧苑1栋","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":14,"plShelterName":"梅县区高级中学卫生室","plLongitude":116.017881,"plLatitude":24.257508,"plAddress":"梅州市东郊岗子上","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":16,"plShelterName":"梅县松口镇中井村卫生站","plLongitude":116.304252,"plLatitude":24.530622,"plAddress":"梅县松口镇中井村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":17,"plShelterName":"梅州农业学校城东校区医务室","plLongitude":115.663764,"plLatitude":23.982941,"plAddress":"梅州市梅县区城东镇金盘桥","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":18,"plShelterName":"梅州市华普健康产业投资有限公司综合门诊部","plLongitude":115.663764,"plLatitude":23.982941,"plAddress":"梅州市梅县区程江镇扶贵村梅塘西路305-315号","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":19,"plShelterName":"梅州市金雁铜业公司玉水铜矿卫生所","plLongitude":116.209521,"plLatitude":24.502045,"plAddress":"梅州市梅县区城东镇玉水","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":20,"plShelterName":"梅州市梅县区白渡镇白渡村卫生站","plLongitude":116.304252,"plLatitude":24.530622,"plAddress":"梅州市梅县区白渡镇白渡村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":23,"plShelterName":"梅州市梅县区白渡镇凤岭村卫生室","plLongitude":116.205469,"plLatitude":24.503277,"plAddress":"梅州市梅县区白渡镇凤岭村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":24,"plShelterName":"梅州市梅县区白渡镇桃柳村卫生站","plLongitude":116.205469,"plLatitude":24.503277,"plAddress":"梅州市梅县区白渡镇桃柳村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":25,"plShelterName":"梅州市梅县区白渡镇悦一村卫生站","plLongitude":116.285633,"plLatitude":24.37225,"plAddress":"梅州市梅县区白渡镇悦一村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":26,"plShelterName":"梅州市梅县区丙村镇程江村卫生室","plLongitude":116.255933,"plLatitude":24.394728,"plAddress":"梅州市梅县区丙村镇程江村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":27,"plShelterName":"梅州市梅县区丙村镇芦陵村卫生站","plLongitude":116.285633,"plLatitude":24.37225,"plAddress":"梅州市梅县区丙村镇芦陵村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":28,"plShelterName":"梅州市梅县区丙村镇人和村卫生站","plLongitude":116.285633,"plLatitude":24.37225,"plAddress":"梅州市梅县区丙村镇人和村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":29,"plShelterName":"梅州市梅县区丙村镇田头村卫生站","plLongitude":116.285633,"plLatitude":24.37225,"plAddress":"梅州市梅县区丙村镇田头村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":30,"plShelterName":"梅州市梅县区丙村镇溪联村第二卫生站","plLongitude":116.285633,"plLatitude":24.37225,"plAddress":"梅州市梅县区丙村镇溪联村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":31,"plShelterName":"梅州市梅县区丙村镇银竹村卫生站","plLongitude":116.278926,"plLatitude":24.379835,"plAddress":"梅州市梅县区丙村镇银竹村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":32,"plShelterName":"梅州市梅县区城东镇石下村第二卫生室","plLongitude":116.134794,"plLatitude":24.353232,"plAddress":"梅州市梅县区城东镇石下村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":33,"plShelterName":"梅州市梅县区城东镇石月村第一卫生站","plLongitude":116.153801,"plLatitude":24.356144,"plAddress":"梅州市梅县区城东镇石月村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":34,"plShelterName":"梅州市梅县区城东镇谢田村卫生站","plLongitude":116.209562,"plLatitude":24.449786,"plAddress":"梅州市梅县区城东镇谢田村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":35,"plShelterName":"梅州市梅县区程江镇长滩村卫生站","plLongitude":116.094012,"plLatitude":24.269863,"plAddress":"梅州市梅县区程江镇长滩村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":36,"plShelterName":"梅州市梅县区程江镇程江村第四卫生站","plLongitude":116.074272,"plLatitude":24.295163,"plAddress":"梅州市梅县区程江镇程江村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":37,"plShelterName":"梅州市梅县区程江镇扶贵村第二卫生站","plLongitude":116.107144,"plLatitude":24.292404,"plAddress":"梅州市梅县区程江镇扶贵村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":38,"plShelterName":"梅州市梅县区程江镇扶贵村第四卫生站","plLongitude":116.11529,"plLatitude":24.301187,"plAddress":"梅州市梅县区程江镇扶贵村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":39,"plShelterName":"梅州市梅县区程江镇扶贵村第一卫生站","plLongitude":116.098123,"plLatitude":24.298558,"plAddress":"梅州市梅县区程江镇扶贵村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":40,"plShelterName":"梅州市梅县区程江镇扶贵村锭子桥卫生站","plLongitude":116.101347,"plLatitude":24.284158,"plAddress":"梅州市梅县区程江镇扶贵村扶山路26号","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":42,"plShelterName":"梅州市梅县区程江镇槐岗村第三卫生站","plLongitude":116.073686,"plLatitude":24.296409,"plAddress":"梅州市梅县区程江镇槐岗村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":43,"plShelterName":"梅州市梅县区程江镇槐岗村第五卫生站","plLongitude":116.074272,"plLatitude":24.295163,"plAddress":"梅州市梅县区程江镇槐岗村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":44,"plShelterName":"梅州市梅县区程江镇岗子上","plLongitude":116.087941,"plLatitude":24.295618,"plAddress":"梅州市梅县区程江镇岗子上","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":45,"plShelterName":"梅州市梅县区大坪镇平中村卫生室","plLongitude":115.989921,"plLatitude":24.393491,"plAddress":"梅州市梅县区大坪镇平中村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":46,"plShelterName":"梅州市梅县区大坪镇守台村卫生室","plLongitude":115.970928,"plLatitude":24.373845,"plAddress":"梅州市梅县区大坪镇守台村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":47,"plShelterName":"梅州市梅县区大坪镇汤湖村卫生站","plLongitude":115.970928,"plLatitude":24.373845,"plAddress":"梅州市梅县区大坪镇汤湖村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":48,"plShelterName":"梅州市梅县区大坪镇营里村卫生站","plLongitude":115.970928,"plLatitude":24.373845,"plAddress":"梅州市梅县区大坪镇营里村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":49,"plShelterName":"梅州市梅县区扶大三葵村第二卫生站","plLongitude":116.084354,"plLatitude":24.268879,"plAddress":"梅州市梅县区扶大三葵村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":50,"plShelterName":"梅州市梅县区扶大三葵村第一卫生站","plLongitude":116.071674,"plLatitude":24.288964,"plAddress":"梅州市梅县区扶大三葵村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":51,"plShelterName":"梅州市梅县区扶大社区卫生服务中心","plLongitude":116.084427,"plLatitude":24.268045,"plAddress":"梅州市梅县区扶大铁炉潭村委会侧","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":52,"plShelterName":"梅州市梅县区扶大所里村第三卫生站","plLongitude":116.084354,"plLatitude":24.268879,"plAddress":"梅州市梅县区扶大所里村委","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":53,"plShelterName":"梅州市梅县区扶大铁炉潭村第二卫生站","plLongitude":116.075288,"plLatitude":24.292405,"plAddress":"梅州市梅县区扶大铁炉潭","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":55,"plShelterName":"梅州市梅县区扶大卫生院","plLongitude":116.072103,"plLatitude":24.26742,"plAddress":"梅州市梅县区扶大","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":56,"plShelterName":"梅州市梅县区妇幼保健计划生育服务中心","plLongitude":116.126762,"plLatitude":24.308293,"plAddress":"梅州市梅县区华侨城宪梓北路三巷2号","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":57,"plShelterName":"梅州市梅县区康乐医院","plLongitude":116.116663,"plLatitude":24.305278,"plAddress":"梅州市梅县区松口镇书院路10号","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":58,"plShelterName":"梅州市梅县区隆文镇江上村卫生站","plLongitude":116.11453,"plLatitude":24.154327,"plAddress":"梅州市梅县区隆文镇江上村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":59,"plShelterName":"梅州市梅县区隆文镇卫生院","plLongitude":116.357925,"plLatitude":24.598368,"plAddress":"梅州市梅县区隆文镇圩镇","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":60,"plShelterName":"梅州市梅县区慢性病防治院","plLongitude":116.10657,"plLatitude":24.298643,"plAddress":"梅州市梅县区华侨城科技路","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":61,"plShelterName":"梅州市梅县区慢性病防治院梅松门诊","plLongitude":116.127965,"plLatitude":24.324402,"plAddress":"梅州市梅松路37号","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":62,"plShelterName":"梅州市梅县区梅南镇卫生院","plLongitude":116.095755,"plLatitude":24.160583,"plAddress":"梅州市梅县区梅南镇新塘圩","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":63,"plShelterName":"梅州市梅县区梅西镇龙虎村卫生站","plLongitude":115.867066,"plLatitude":24.462527,"plAddress":"梅州市梅县区梅西镇龙虎村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":64,"plShelterName":"梅州市梅县区梅西镇罗墩村第一卫生站","plLongitude":115.867679,"plLatitude":24.459663,"plAddress":"梅州市梅县区梅西镇罗墩村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":65,"plShelterName":"梅州市梅县区梅西镇田福村卫生站","plLongitude":115.909444,"plLatitude":24.426279,"plAddress":"梅州市梅县区梅西镇田福村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":66,"plShelterName":"梅州市梅县区梅西镇卫生院","plLongitude":115.867066,"plLatitude":24.462527,"plAddress":"梅州市梅县区梅西镇龙虎圩","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":67,"plShelterName":"梅州市梅县区南口镇车陂村第二卫生室","plLongitude":116.017881,"plLatitude":24.257508,"plAddress":"梅州市梅县区南口镇车陂村村委会一楼","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":68,"plShelterName":"梅州市梅县区南口镇锦鸡村第二卫生站","plLongitude":116.017881,"plLatitude":24.257508,"plAddress":"梅州市梅县区南口镇锦鸡村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":69,"plShelterName":"梅州市梅县区南口镇群达村卫生室","plLongitude":116.012402,"plLatitude":24.217867,"plAddress":"梅州市梅县区南口镇群达村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":70,"plShelterName":"梅州市梅县区南口镇油坊村卫生站","plLongitude":115.88618,"plLatitude":24.30366,"plAddress":"梅州市梅县区南口镇油坊村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":71,"plShelterName":"梅州市梅县区畲江镇官铺村卫生室","plLongitude":115.983551,"plLatitude":24.034312,"plAddress":"梅州市梅县区畲江镇官铺村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":72,"plShelterName":"梅州市梅县区畲江镇径心村第二卫生站","plLongitude":116.041628,"plLatitude":23.949952,"plAddress":"梅州市梅县区畲江镇径心村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":73,"plShelterName":"梅州市梅县区畲江镇中心卫生院","plLongitude":115.990787,"plLatitude":24.045473,"plAddress":"梅州市梅县区畲江镇","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":74,"plShelterName":"梅州市梅县区石坑镇卫生院","plLongitude":115.840294,"plLatitude":24.393176,"plAddress":"梅州市梅县区石坑镇转水潭","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":75,"plShelterName":"梅州市梅县区石扇镇巴庄村第一卫生站","plLongitude":116.039782,"plLatitude":24.453723,"plAddress":"梅州市梅县区石扇镇巴庄村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":76,"plShelterName":"梅州市梅县区石扇镇松林村第一卫生站","plLongitude":116.095904,"plLatitude":24.449781,"plAddress":"梅州市梅县区石扇镇松林村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":77,"plShelterName":"梅州市梅县区石扇镇卫生院","plLongitude":116.039791,"plLatitude":24.4537,"plAddress":"梅州市梅县区石扇镇中和圩","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":78,"plShelterName":"梅州市梅县区水车镇卫生院","plLongitude":116.029514,"plLatitude":24.095937,"plAddress":"梅州市梅县区水车镇","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":79,"plShelterName":"梅州市梅县区松口镇大黄村卫生室","plLongitude":116.387456,"plLatitude":24.48217,"plAddress":"梅州市梅县区松口镇大黄村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":80,"plShelterName":"梅州市梅县区松口镇大力村卫生站","plLongitude":116.415386,"plLatitude":24.509714,"plAddress":"梅州市梅县区松口镇大力村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":81,"plShelterName":"梅州市梅县区松口镇到车村卫生室","plLongitude":116.354909,"plLatitude":24.532616,"plAddress":"梅州市梅县区松口镇到车村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":82,"plShelterName":"梅州市梅县区松口镇圳头村卫生站","plLongitude":116.407288,"plLatitude":24.493217,"plAddress":"梅州市梅县区松口镇圳头村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":83,"plShelterName":"梅州市梅县区松口镇中心卫生院","plLongitude":116.396714,"plLatitude":24.499687,"plAddress":"梅州市梅县区松口镇寺坑","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":84,"plShelterName":"梅州市梅县区松源镇化联村卫生站","plLongitude":116.388306,"plLatitude":24.735765,"plAddress":"梅州市梅县区松源镇化联村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":85,"plShelterName":"梅州市梅县区桃尧镇大美村卫生站","plLongitude":116.438706,"plLatitude":24.603269,"plAddress":"梅州市梅县区桃尧镇大美村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":86,"plShelterName":"梅州市梅县区桃尧镇卫生院","plLongitude":116.44772,"plLatitude":24.637702,"plAddress":"梅州市梅县区桃尧镇圩镇","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":87,"plShelterName":"梅州市梅县区雁洋镇上村村卫生站","plLongitude":116.342987,"plLatitude":24.419533,"plAddress":"梅州市梅县区雁洋镇上村村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":88,"plShelterName":"梅州市梅县区雁洋镇卫生院","plLongitude":116.33207,"plLatitude":24.418949,"plAddress":"梅州市梅县区雁洋镇","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":89,"plShelterName":"梅州市梅县区雁洋镇小都村卫生站","plLongitude":116.371616,"plLatitude":24.303528,"plAddress":"梅州市梅县区雁洋镇小都村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":90,"plShelterName":"梅州市梅县区中医医院","plLongitude":116.103897,"plLatitude":24.285443,"plAddress":"梅州市梅县区新城宪梓大道中52号","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":91,"plShelterName":"饶富棣个体中医内儿科诊所","plLongitude":116.096534,"plLatitude":24.286228,"plAddress":"梅州市梅县区大新城新富街润金花园A7A8栋35-37号店","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":92,"plShelterName":"石坑镇龙塘村卫生站","plLongitude":115.870405,"plLatitude":24.379771,"plAddress":"梅州市梅县区石坑镇龙塘村","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":93,"plShelterName":"谢伏生内儿科诊所","plLongitude":116.09286,"plLatitude":24.281986,"plAddress":"梅县区大新城新地街贵和花园A4栋6号","plArea":null,"placeType":"healthStation"},{"createTime":null,"plId":94,"plShelterName":"中山大学附属第三医院粤东医院","plLongitude":116.076272,"plLatitude":24.286834,"plAddress":"梅州市梅县区新县城公园北路","plArea":null,"placeType":"healthStation"},{"createTime":"2017-07-11 14:08:07","plId":724,"plShelterName":"测试测试","plLongitude":45.48112,"plLatitude":125.48554,"plAddress":"啊上帝的","plArea":null,"placeType":"healthStation"},{"createTime":"2017-07-12 11:50:54","plId":782,"plShelterName":"快乐圣诞节的身份了 ","plLongitude":1233,"plLatitude":23123,"plAddress":"阿德撒色的","plArea":null,"placeType":"healthStation"},{"createTime":"2017-07-10 17:48:37","plId":707,"plShelterName":"3","plLongitude":3244,"plLatitude":999,"plAddress":null,"plArea":null,"placeType":"placeEmergency"},{"createTime":"2017-07-11 13:56:36","plId":722,"plShelterName":"正南街街道办2","plLongitude":123.5552,"plLatitude":12.1584,"plAddress":"撒不发士大夫不是的4","plArea":"1123","placeType":"placeEmergency"}]
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
		 * createTime : null
		 * plId : 1
		 * plShelterName : 白渡镇悦来村卫生站
		 * plLongitude : 116.209562
		 * plLatitude : 24.449787
		 * plAddress : 梅州市梅县区白渡镇悦来村
		 * plArea : null
		 * placeType : healthStation
		 */

		private String createTime;
		private int plId;
		private String plShelterName;
		private double plLongitude;
		private double plLatitude;
		private String plAddress;
		private String plArea;
		private String placeType;

		public Object getCreateTime() {
			return createTime;
		}

		public void setCreateTime(String createTime) {
			this.createTime = createTime;
		}

		public int getPlId() {
			return plId;
		}

		public void setPlId(int plId) {
			this.plId = plId;
		}

		public String getPlShelterName() {
			return plShelterName;
		}

		public void setPlShelterName(String plShelterName) {
			this.plShelterName = plShelterName;
		}

		public double getPlLongitude() {
			return plLongitude;
		}

		public void setPlLongitude(double plLongitude) {
			this.plLongitude = plLongitude;
		}

		public double getPlLatitude() {
			return plLatitude;
		}

		public void setPlLatitude(double plLatitude) {
			this.plLatitude = plLatitude;
		}

		public String getPlAddress() {
			return plAddress;
		}

		public void setPlAddress(String plAddress) {
			this.plAddress = plAddress;
		}

		public Object getPlArea() {
			return plArea;
		}

		public void setPlArea(String plArea) {
			this.plArea = plArea;
		}

		public String getPlaceType() {
			return placeType;
		}

		public void setPlaceType(String placeType) {
			this.placeType = placeType;
		}
	}
}