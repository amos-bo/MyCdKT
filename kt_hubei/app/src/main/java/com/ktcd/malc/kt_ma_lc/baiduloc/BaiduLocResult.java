package com.ktcd.malc.kt_ma_lc.baiduloc;

import com.baidu.location.BDLocation;

/**
 * @author amos_bo 284285624@qq.com
 * @ClassName: BaiduLocResult
 * @Description: 定位回调接口
 * @date 2015年10月12日 上午11:11:07
 */
public interface BaiduLocResult {
    /**
     * 定位成功回调
     */
    void getLocResultSuccess(String province, String city, String district,
                             String Street, String citycode, double
                                     Longitude, double Latitude, BDLocation
                                     location);

    /**
     * 定位失败回调
     */
    void getLocResultFailure(String eorrcode, String eorrmessege);

}
