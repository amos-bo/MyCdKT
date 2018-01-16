package com.ktcd.malc.kt_ma_lc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.google.gson.Gson;
import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.activity.EventListActivity;
import com.ktcd.malc.kt_ma_lc.activity.InstructManagementActivity;
import com.ktcd.malc.kt_ma_lc.activity.NewMoreResourcesMapActivity;
import com.ktcd.malc.kt_ma_lc.activity.NewResourcesMapActivity;
import com.ktcd.malc.kt_ma_lc.activity.NoticeActivity;
import com.ktcd.malc.kt_ma_lc.activity.ResourcesMapActivity;
import com.ktcd.malc.kt_ma_lc.adapter.HomeWorkTypesAdapter;
import com.ktcd.malc.kt_ma_lc.applicatoin.ApiPathUrl;
import com.ktcd.malc.kt_ma_lc.applicatoin.KtkjMaLcApplication;
import com.ktcd.malc.kt_ma_lc.baiduloc.BaiduLocResult;
import com.ktcd.malc.kt_ma_lc.baiduloc.LocationClientConfig;
import com.ktcd.malc.kt_ma_lc.baiduloc.LocationListener;
import com.ktcd.malc.kt_ma_lc.bean.LoginBean;
import com.ktcd.malc.kt_ma_lc.bean.MapResourcePoitinfo;
import com.ktcd.malc.kt_ma_lc.model.HomeWeatherInfo;
import com.ktcd.malc.kt_ma_lc.model.ItemHomeTypeInfo;
import com.ktcd.malc.utilslibrary.net.KtkjError;
import com.ktcd.malc.utilslibrary.net.MyRetrofit;
import com.ktcd.malc.utilslibrary.net.ResponseCallBack;
import com.ktcd.malc.utilslibrary.tools.ConfigUtils;
import com.ktcd.malc.utilslibrary.tools.DateTimeUtils;
import com.ktcd.malc.utilslibrary.tools.FileUtils;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.disposables.Disposable;


/**
 * Created by xiangbo on 2017/6/17.
 * 工作台fragment
 */

public class WorkBenchFragment extends BaseFragment implements View.OnClickListener {

    private ImageView mImgWeatherBg;//天气背景

    private LinearLayout mLinTopLoc;//位置
    private TextView mTvLocName;//位置-城市
    private TextView mTvLocNameMark;//位置-灾害点

    private LinearLayout mLinUpData;//刷新

    private TextView mTvTemperature;//天气范围
    private ImageView mImgWeatherTypeSmall;//天气类型小图标
    private TextView mTvWeatherType;//天气状况

    private TextView mTvUpDataWeatherTime;//天气更新时间


    private LinearLayout mLinHintTip;
    private TextView mTvHintMessge;

    private LinearLayout mLinErrorTip;
    private TextView mTvErrorMessge;

    private RecyclerView mRecyclerView;

    private HomeWorkTypesAdapter mHomeWorkTypesAdapter;

    private List<ItemHomeTypeInfo> mItemHomeTypeInfoList;
    private String mCityName;

    private boolean mIsCanGetLoc = true;

    public static WorkBenchFragment newInstance(String type) {
        WorkBenchFragment f = new WorkBenchFragment();
        Bundle b = new Bundle();
        b.putSerializable("DATA", type);
        f.setArguments(b);
        return f;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {

        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workbench, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mIsCanGetLoc = true;
        initViews();
        initLoc();
    }

    private void initViews() {

        mImgWeatherBg = getActivity().findViewById(R.id.img_weather_type);//天气背景

        mLinTopLoc = getActivity().findViewById(R.id.lin_top_loc);//位置
        mTvLocName = getActivity().findViewById(R.id.tv_loc);//位置-城市
        mTvLocNameMark = getActivity().findViewById(R.id.tv_loc_type);//位置-灾害点

        mLinUpData = getActivity().findViewById(R.id.lin_updata);//刷新

        mTvTemperature = getActivity().findViewById(R.id.tv_temperature);//天气范围
        mImgWeatherTypeSmall = getActivity().findViewById(R.id.img_temperature_mark);//天气类型小图标
        mTvWeatherType = getActivity().findViewById(R.id.tv_temperature_mark);//天气状况

        mTvUpDataWeatherTime = getActivity().findViewById(R.id.tv_update_time);//天气更新时间


        mLinHintTip = getActivity().findViewById(R.id.lin_hint_tip);
        mTvHintMessge = getActivity().findViewById(R.id.tv_hint_messge);

        mLinErrorTip = getActivity().findViewById(R.id.lin_hint_error);
        mTvHintMessge = getActivity().findViewById(R.id.tv_error_hint);

        mRecyclerView = getActivity().findViewById(R.id.recyclerview);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));

        mHomeWorkTypesAdapter = new HomeWorkTypesAdapter(mContext);
        mItemHomeTypeInfoList = new ArrayList<>();


        ItemHomeTypeInfo ItemHomeTypeInfo_shijian = new ItemHomeTypeInfo();
        ItemHomeTypeInfo_shijian.drawAbleId = R.mipmap.home_works_shijian;
        ItemHomeTypeInfo_shijian.TypeName = "事件信息";

        ItemHomeTypeInfo ItemHomeTypeInfo_ziyuan = new ItemHomeTypeInfo();
        ItemHomeTypeInfo_ziyuan.drawAbleId = R.mipmap.home_works_ziyuan;
        ItemHomeTypeInfo_ziyuan.TypeName = "资源信息";

        ItemHomeTypeInfo ItemHomeTypeInfo_zhiling = new ItemHomeTypeInfo();
        ItemHomeTypeInfo_zhiling.drawAbleId = R.mipmap.home_works_zhiling;
        ItemHomeTypeInfo_zhiling.TypeName = "指令管理";

        ItemHomeTypeInfo ItemHomeTypeInfo_Tongzhi = new ItemHomeTypeInfo();
        ItemHomeTypeInfo_Tongzhi.drawAbleId = R.mipmap.works_img_notice;
        ItemHomeTypeInfo_Tongzhi.TypeName = "通知公告";

        mItemHomeTypeInfoList.add(ItemHomeTypeInfo_shijian);
        mItemHomeTypeInfoList.add(ItemHomeTypeInfo_ziyuan);
        mItemHomeTypeInfoList.add(ItemHomeTypeInfo_zhiling);
        mItemHomeTypeInfoList.add(ItemHomeTypeInfo_Tongzhi);

        mHomeWorkTypesAdapter.setList(mItemHomeTypeInfoList);
        mRecyclerView.setAdapter(mHomeWorkTypesAdapter);
        mHomeWorkTypesAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                switch (position) {
                    case 0:
                        startActivity(EventListActivity.class);
                        break;
                    case 1:
//                        startActivity(ResourcesMapActivity.class);
                        startActivity(NewMoreResourcesMapActivity.class);
                        break;
                    case 2:
                        startActivity(InstructManagementActivity.class);
                        break;
                    case 3:
                        startActivity(NoticeActivity.class);
                        break;
                    default:
                        break;

                }
//
//                if (position == 1) {
//                    startActivity(ResourcesMapActivity.class);
//                }
//                if (position == 2) {
//                    startActivity(EventInfoMapActivity.class);
//                }
//                if (position == 3) {
//                    startActivity(EventReportActivity.class);
//                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        mLinTopLoc.setOnClickListener(this);
        mLinUpData.setOnClickListener(this);
        mLinHintTip.setOnClickListener(this);
        mLinErrorTip.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lin_top_loc:

                break;
            case R.id.lin_updata:
                upDataWeather(mCityName);
                break;
            case R.id.lin_hint_tip:

                break;
            case R.id.lin_hint_error:

                break;
        }

    }

    @Override
    public void onResume() {
        super.onResume();
        mRecyclerView.setAdapter(mHomeWorkTypesAdapter);
    }

    /***
     * 定位开启
     */
    private void initLoc() {
        final int[] n = {0};
        final int MAX_Size = 3;
        final int[] ctSize = {0};
        KtkjMaLcApplication.getInstance().LOCATION_CLIENT = new LocationClient(KtkjMaLcApplication.getInstance());
        KtkjMaLcApplication.getInstance().LOCATION_CLIENT.setLocOption(LocationClientConfig.initLocation(true));
        KtkjMaLcApplication.getInstance().LOCATION_CLIENT.registerLocationListener(new LocationListener(new BaiduLocResult() {
            @Override
            public void getLocResultSuccess(String province, String city, String district, String Street, String citycode, double Longitude, double Latitude, BDLocation location) {
                if (mIsCanGetLoc) {
                    if (ctSize[0] <= MAX_Size)
                        upDataWeather(mCityName = city.replace("市", ""));
                    ctSize[0]++;
                }
                LatLng new_latlng = convertBaiduToGPS(new LatLng(Latitude, Longitude));
                updatePoint(new_latlng.latitude, new_latlng.longitude);
                Log.e("xb", "old x: " + Latitude + " old Y :" + Longitude);
                Log.e("xb", "new x: " + new_latlng.latitude + " new Y :" + new_latlng.longitude);
//                updatePoint(Latitude, Longitude);
//                if (n[0]%5==0) {
//                   getDataRequest();
//                }
//                n[0]++;
            }

            @Override
            public void getLocResultFailure(String eorrcode, String eorrmessege) {
                ToastUtils.showMessage(mContext, "获取位置信息错误 ：" + eorrmessege);
            }
        }));
        if (KtkjMaLcApplication.getInstance().ISCAN_LOC) {
            if (!KtkjMaLcApplication.getInstance().LOCATION_CLIENT.isStarted()) {
                KtkjMaLcApplication.getInstance().LOCATION_CLIENT.start();
            }
        } else {
            if (KtkjMaLcApplication.getInstance().LOCATION_CLIENT.isStarted()) {
                KtkjMaLcApplication.getInstance().LOCATION_CLIENT.stop();
            }
        }
    }

    private void updatePoint(double latitude, double longitude) {
        Map<String, String> map = new HashMap<>();
        map.put("longitude", "" + longitude);
        map.put("latitude", "" + latitude);
        map.put("userID", "" + ConfigUtils.getUserID(mContext));
        //TODO
        map.put("userName", "" + ((LoginBean.DataBean) FileUtils.getObject(mContext, "LoginBean.DataBean")).getCpName());
        MyRetrofit.StartQueryNet(mContext, true, ApiPathUrl.ACTION_GPSHISTORYTRACK, map, new ResponseCallBack<Serializable>() {
            @Override
            protected void onLoad(Disposable d) {

            }

            @Override
            protected void onError(KtkjError error) {

            }

            @Override
            protected void onSuccess(Serializable result) {
            }
        });
    }

    /***
     * 网络获取天气数据
     */
    private void upDataWeather(String city) {

        Map<String, String> map = new HashMap<>();
        map.put("cityName", city);
        MyRetrofit.StartQueryNet(mContext, true, ApiPathUrl.ACTION_WEATHER, map, new ResponseCallBack<HomeWeatherInfo>() {
            @Override
            protected void onLoad(Disposable d) {
                ToastUtils.showMessage(mContext, "开始刷新天气信息");
            }

            @Override
            protected void onError(KtkjError error) {
                ToastUtils.showMessage(mContext, error.msg);
            }

            @Override
            protected void onSuccess(HomeWeatherInfo result) {
                mIsCanGetLoc = false;
                setWeaterShow(result);
                ToastUtils.showMessage(mContext, "天气刷新成功");
            }
        });
    }

    private void setWeaterShow(HomeWeatherInfo result) {

        mTvLocName.setText(result.getCity());//位置-城市
        mTvTemperature.setText(result.getTemp1() + "~" + result.getTemp2());//天气范围
        mTvWeatherType.setText(result.getWeather());//天气状况
        mTvUpDataWeatherTime.setText(DateTimeUtils.getCurrentTime("HH:mm") + "更新");//天气更新时间
        if (result.getWeather().contains("晴")) {
            mImgWeatherBg.setImageResource(R.mipmap.weather_bg_sun);
            mImgWeatherTypeSmall.setImageResource(R.mipmap.weather_img_sun);
        } else if (result.getWeather().contains("阴")) {
            mImgWeatherBg.setImageResource(R.mipmap.weather_bg_overcast);
            mImgWeatherTypeSmall.setImageResource(R.mipmap.weather_img_overcast);

        } else if (result.getWeather().contains("雨")) {
            mImgWeatherBg.setImageResource(R.mipmap.weather_bg_rain);
            mImgWeatherTypeSmall.setImageResource(R.mipmap.weather_img_rain);

        } else if (result.getWeather().contains("云")) {
            mImgWeatherBg.setImageResource(R.mipmap.weather_bg_cloudy);
            mImgWeatherTypeSmall.setImageResource(R.mipmap.weather_img_cloudy);

        } else if (result.getWeather().contains("雷")) {
            mImgWeatherBg.setImageResource(R.mipmap.weather_bg_thunder);
            mImgWeatherTypeSmall.setImageResource(R.mipmap.weather_img_thunder);

        } else if (result.getWeather().contains("霾")) {
            mImgWeatherBg.setImageResource(R.mipmap.weather_bg_haze);
            mImgWeatherTypeSmall.setImageResource(R.mipmap.weather_img_haze);

        } else if (result.getWeather().contains("雪")) {
            mImgWeatherBg.setImageResource(R.mipmap.weather_bg_snow);
            mImgWeatherTypeSmall.setImageResource(R.mipmap.weather_img_snow);

        } else if (result.getWeather().contains("沙")) {
            mImgWeatherBg.setImageResource(R.mipmap.weather_bg_sand);
            mImgWeatherTypeSmall.setImageResource(R.mipmap.weather_img_sandstorm);
        } else if (result.getWeather().contains("风")) {
            mImgWeatherBg.setImageResource(R.mipmap.weather_bg_tornado);
            mImgWeatherTypeSmall.setImageResource(R.mipmap.weather_img_tornado);

        } else {
            mImgWeatherBg.setImageResource(R.mipmap.weather_bg_unknow);
            mImgWeatherTypeSmall.setImageResource(R.mipmap.weather_img_unknown);
        }
    }

    public static LatLng convertBaiduToGPS(LatLng sourceLatLng) {
        // 将GPS设备采集的原始GPS坐标转换成百度坐标
        CoordinateConverter converter = new CoordinateConverter();
        converter.from(CoordinateConverter.CoordType.GPS);
        // sourceLatLng待转换坐标
        converter.coord(sourceLatLng);
        LatLng desLatLng = converter.convert();
        double latitude = 2 * sourceLatLng.latitude - desLatLng.latitude;
        double longitude = 2 * sourceLatLng.longitude - desLatLng.longitude;
        BigDecimal bdLatitude = new BigDecimal(latitude);
        bdLatitude = bdLatitude.setScale(6, BigDecimal.ROUND_HALF_UP);
        BigDecimal bdLongitude = new BigDecimal(longitude);
        bdLongitude = bdLongitude.setScale(6, BigDecimal.ROUND_HALF_UP);
        return new LatLng(bdLatitude.doubleValue(), bdLongitude.doubleValue());
    }


    private void getDataRequest() {
        List<List<String[]>> json = new ArrayList<>();
        List<String[]> list1 = new ArrayList<>();
        list1.add(new String[]{"115.9986", "24.7768"});
        list1.add(new String[]{"115.9712", "24.4696"});
        list1.add(new String[]{"116.4910", "24.4999"});
        list1.add(new String[]{"116.4637", "24.8299"});
        list1.add(new String[]{"115.9986", "24.7768"});
        json.add(list1);
        String json1 = new Gson().toJson(json);
        Map<String, String> mdate = new HashMap<>();
        mdate.put("polygonJsonStr", json1);
        MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://192.168.0.134:5555/pointCache/point/getInformationPointByGeometry", mdate, new ResponseCallBack<MapResourcePoitinfo>() {
            @Override
            protected void onLoad(Disposable d) {

            }

            @Override
            protected void onError(KtkjError error) {

            }

            @Override
            protected void onSuccess(MapResourcePoitinfo result) {

            }

            @Override
            protected void onSuccessList(Object result) {

            }
        });

    }
}
