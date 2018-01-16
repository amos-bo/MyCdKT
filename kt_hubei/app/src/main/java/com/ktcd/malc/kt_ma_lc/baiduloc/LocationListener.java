package com.ktcd.malc.kt_ma_lc.baiduloc;

import android.util.Log;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;

/**
 * 
 * @ClassName: ZoweeLocationListener
 * @Description:百度定位监听
 * @author amos_bo 284285624@qq.com
 * @date 2015年10月28日 上午9:46:47
 * 
 */
public class LocationListener implements BDLocationListener {

	private BaiduLocResult baidulocresult;

	public LocationListener(BaiduLocResult baidulocresult) {
		this.baidulocresult = baidulocresult;
	}

	@Override
	public void onReceiveLocation(BDLocation location) {
		switch (location.getLocType()) {
		case BDLocation.TypeGpsLocation:

		case BDLocation.TypeNetWorkLocation:

		case BDLocation.TypeOffLineLocation:
			baidulocresult.getLocResultSuccess(location.getProvince(),
					location.getCity(), location.getDistrict(),
					location.getStreet() + location.getStreetNumber(),
					location.getCityCode(),location.getLongitude(),location.getLatitude(),location);
			Log.e("xb", "号数" + location.getAddrStr());
			break;
		case BDLocation.TypeServerError:
			baidulocresult.getLocResultFailure("" + BDLocation.TypeServerError,
					"服务端网络定位失败");
			break;
		case BDLocation.TypeNetWorkException:
			baidulocresult.getLocResultFailure(""
					+ BDLocation.TypeNetWorkException, "定位失败,检查网络是否畅通");
			break;
		case BDLocation.TypeCriteriaException:
			baidulocresult.getLocResultFailure(""
					+ BDLocation.TypeNetWorkException, "无法获取有效定位依据导致定位失败");
			break;
		default:
			baidulocresult.getLocResultFailure("00000", "未知原因导致定位失败");
			break;
		}
	}

	@Override
	public void onConnectHotSpotMessage(String s, int i) {

	}
}