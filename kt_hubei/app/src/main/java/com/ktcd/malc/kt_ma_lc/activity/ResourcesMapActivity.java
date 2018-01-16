package com.ktcd.malc.kt_ma_lc.activity;

import android.app.ProgressDialog;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.google.gson.Gson;
import com.ktcd.malc.baselayer.activity.ToolbarActivity;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.applicatoin.ApiPathUrl;
import com.ktcd.malc.kt_ma_lc.bean.MapResourcePoitinfo;
import com.ktcd.malc.kt_ma_lc.dialog.PopWindowMapRight;
import com.ktcd.malc.kt_ma_lc.model.ItemHomeTypeInfo;
import com.ktcd.malc.kt_ma_lc.responseparam.CollapseResouresInfoListResponse;
import com.ktcd.malc.kt_ma_lc.responseparam.DebrisFlowResouresInfoListResponse;
import com.ktcd.malc.kt_ma_lc.responseparam.FloodsResouresInfoListResponse;
import com.ktcd.malc.kt_ma_lc.responseparam.LandslideResouresInfoListResponse;
import com.ktcd.malc.kt_ma_lc.responseparam.MapPlaceResponse;
import com.ktcd.malc.kt_ma_lc.responseparam.SmallRiverResouresInfoListResponse;
import com.ktcd.malc.kt_ma_lc.responseparam.SubsideResouresInfoListResponse;
import com.ktcd.malc.utilslibrary.net.KtkjError;
import com.ktcd.malc.utilslibrary.net.MyRetrofit;
import com.ktcd.malc.utilslibrary.net.ResponseCallBack;
import com.ktcd.malc.utilslibrary.tools.StringUtils;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

public class ResourcesMapActivity extends ToolbarActivity implements SensorEventListener {

    @BindView(R.id.bmapView)
    MapView bmapView;
    @BindView(R.id.lin_translate)
    LinearLayout linTranslate;
    @BindView(R.id.lin_person)
    LinearLayout linPerson;
    @BindView(R.id.lin_place)
    LinearLayout linPlace;
    @BindView(R.id.lin_zhiling)
    LinearLayout linZhiling;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.root)
    LinearLayout mRoot;


    private MapView mMapView = null;
    private BaiduMap mBaiduMap = null;
    private MapStatus.Builder mbuilder = null;
    private UiSettings mUiSettings = null;

    // 定位相关
    private LocationClient mLocClient;
    public MyLocationListenner myListener = new MyLocationListenner();
    private MyLocationConfiguration.LocationMode mCurrentMode;
    BitmapDescriptor mCurrentMarker;
    private static final int accuracyCircleFillColor = 0xAAFFFF88;
    private static final int accuracyCircleStrokeColor = 0xAA00FF00;
    private SensorManager mSensorManager;
    private Double lastX = 0.0;
    private int mCurrentDirection = 0;
    private double mCurrentLat = 0.0;
    private double mCurrentLon = 0.0;
    private float mCurrentAccracy;
    boolean isFirstLoc = true; // 是否首次定位
    private MyLocationData locData;
    private float direction;

    private List<ItemHomeTypeInfo> mItemHomeTypeInfoList;

    private Map<String, String> mRowsBeanMap;
    //  六个不同请求
    private List<SubsideResouresInfoListResponse.RowsBean> mAllRowsBean;
    private SubsideResouresInfoListResponse mSubsideResouresInfoListResponse;
    private CollapseResouresInfoListResponse mCollapseResouresInfoListResponse;
    private LandslideResouresInfoListResponse mLandslideResouresInfoListResponse;
    private SmallRiverResouresInfoListResponse mSmallRiverResouresInfoListResponse;
    private FloodsResouresInfoListResponse mFloodsResouresInfoListResponse;
    private DebrisFlowResouresInfoListResponse mDebrisFlowResouresInfoListResponse;


//    private List<SubsideResouresInfoListResponse.RowsBean> mAllRowsBean;
//    private List<SubsideResouresInfoListResponse.RowsBean> mAllRowsBean;
//    private List<SubsideResouresInfoListResponse.RowsBean> mAllRowsBean;
//    private List<SubsideResouresInfoListResponse.RowsBean> mAllRowsBean;
    //危险点集合
    private List<Marker> mMarkerList;
    //服务场所集合
    private boolean isShowPlace=false;
    private List<Marker> mPalcMarkerList;
    /**所有场所集合*/
    private MapPlaceResponse mMapPlaceResponse;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources_map);
        ButterKnife.bind(this);
        initView();
        initData();
        testRequest();
    }

    private void initView() {
        setUpToolbar(mToolbar);
        setNavigationIcon(R.mipmap.home_return);
        setTitle("资源");
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        //普通地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
//        //开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        mbuilder = new MapStatus.Builder();
        mbuilder.zoom(11.0f);//默认放缩级别11，最高21
        mbuilder.overlook(0);
        //移除百度图标
        mMapView.removeViewAt(1);
        //移除比例尺
        mMapView.removeViewAt(2);
        ;
        mUiSettings = mBaiduMap.getUiSettings();
        mUiSettings.setCompassEnabled(true);//开启指南针
        mCurrentMode = MyLocationConfiguration.LocationMode.NORMAL;
        mBaiduMap.setMyLocationConfiguration(new MyLocationConfiguration(
                mCurrentMode, true, null));//传null使用默认图标
        mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(mbuilder.build()));

        // 定位初始化
        mLocClient = new LocationClient(this);
        mLocClient.registerLocationListener(myListener);
        LocationClientOption option = new LocationClientOption();
        option.setOpenGps(true); // 打开gps
        option.setIsNeedAddress(true);
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(30000);
        mLocClient.setLocOption(option);
        mLocClient.start();
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);//获取传感器管理服务
        mCurrentMode = MyLocationConfiguration.LocationMode.NORMAL;
    }

    private void initData() {
        mRowsBeanMap = new HashMap<>();
        mAllRowsBean = new ArrayList<>();
        mItemHomeTypeInfoList = new ArrayList<>();
        mMarkerList = new ArrayList<>();
        mPalcMarkerList = new ArrayList<>();


        //  1  subside 崩塌
        //  2  collapse 塌陷
        //  3  landslide 滑坡
        //  4  smallRiver 中小河流
        //  5  floods 山洪沟
        //  6 debrisFlow 泥石流
        ItemHomeTypeInfo item1 = new ItemHomeTypeInfo();
        item1.drawAbleId = 1;
        item1.TypeRequest = "subside";

        ItemHomeTypeInfo item2 = new ItemHomeTypeInfo();
        item2.drawAbleId = 2;
        item2.TypeRequest = "collapse";

        ItemHomeTypeInfo item3 = new ItemHomeTypeInfo();
        item3.drawAbleId = 3;
        item3.TypeRequest = "landslide";

        ItemHomeTypeInfo item4 = new ItemHomeTypeInfo();
        item4.drawAbleId = 4;
        item4.TypeRequest = "smallRiver";

        ItemHomeTypeInfo item5 = new ItemHomeTypeInfo();
        item5.drawAbleId = 5;
        item5.TypeRequest = "floods";

        ItemHomeTypeInfo item6 = new ItemHomeTypeInfo();
        item6.drawAbleId = 6;
        item6.TypeRequest = "debrisFlow";

        mItemHomeTypeInfoList.add(item1);
        mItemHomeTypeInfoList.add(item2);
        mItemHomeTypeInfoList.add(item3);
        mItemHomeTypeInfoList.add(item4);
        mItemHomeTypeInfoList.add(item5);
        mItemHomeTypeInfoList.add(item6);
    }

    private void getData(final String type, final int postion) {
        final Map<String, String> map = new HashMap<>();
        map.put("type", type);

        if (type.equals("subside")) {
            final ProgressDialog pDialog = ProgressDialog
                    .show(this, "请稍等", "正在加载数据...");
            MyRetrofit.StartQueryNet(mContext, true, ApiPathUrl.ACTION_GETRISKPOINTBYTYPE, map, new ResponseCallBack<SubsideResouresInfoListResponse>() {
                @Override
                protected void onLoad(Disposable d) {
                    pDialog.show();
                }

                @Override
                protected void onError(KtkjError error) {
                    ToastUtils.showMessage(mContext, error.msg);
                    pDialog.dismiss();
                }

                @Override
                protected void onSuccess(SubsideResouresInfoListResponse result) {
                    pDialog.dismiss();
                    if (result.getRows().size() > 0) {
                        if (StringUtils.isEmpty(mRowsBeanMap.get(type))) {
                            mRowsBeanMap.put(type, type);
                            subsideShowData(type, result.getRows());
                        }
                    }
                }
            });

        } else if (type.equals("collapse")) {
            final ProgressDialog pDialog = ProgressDialog
                    .show(this, "请稍等", "正在加载数据...");
            MyRetrofit.StartQueryNet(mContext, true, ApiPathUrl.ACTION_GETRISKPOINTBYTYPE, map, new ResponseCallBack<CollapseResouresInfoListResponse>() {
                @Override
                protected void onLoad(Disposable d) {
                    pDialog.show();
                }

                @Override
                protected void onError(KtkjError error) {
                    ToastUtils.showMessage(mContext, error.msg);
                    pDialog.dismiss();
                }

                @Override
                protected void onSuccess(CollapseResouresInfoListResponse result) {
                    pDialog.dismiss();
                    if (result.getRows().size() > 0) {
                        if (StringUtils.isEmpty(mRowsBeanMap.get(type))) {
                            mRowsBeanMap.put(type, type);
                            collapseShowData(type, result.getRows());
                        }
                    }
                }
            });

        } else if (type.equals("landslide")) {
            final ProgressDialog pDialog = ProgressDialog
                    .show(this, "请稍等", "正在加载数据...");
            MyRetrofit.StartQueryNet(mContext, true, ApiPathUrl.ACTION_GETRISKPOINTBYTYPE, map, new ResponseCallBack<LandslideResouresInfoListResponse>() {
                @Override
                protected void onLoad(Disposable d) {
                    pDialog.show();
                }

                @Override
                protected void onError(KtkjError error) {
                    ToastUtils.showMessage(mContext, error.msg);
                    pDialog.dismiss();
                }

                @Override
                protected void onSuccess(LandslideResouresInfoListResponse result) {
                    pDialog.dismiss();
                    if (result.getRows().size() > 0) {
                        if (StringUtils.isEmpty(mRowsBeanMap.get(type))) {
                            mRowsBeanMap.put(type, type);
                            landslideShowData(type, result.getRows());
                        }
                    }
                }
            });
        } else if (type.equals("smallRiver")) {
            final ProgressDialog pDialog = ProgressDialog
                    .show(this, "请稍等", "正在加载数据...");
            MyRetrofit.StartQueryNet(mContext, true, ApiPathUrl.ACTION_GETRISKPOINTBYTYPE, map, new ResponseCallBack<SmallRiverResouresInfoListResponse>() {
                @Override
                protected void onLoad(Disposable d) {
                    pDialog.show();
                }

                @Override
                protected void onError(KtkjError error) {
                    ToastUtils.showMessage(mContext, error.msg);
                    pDialog.dismiss();
                }

                @Override
                protected void onSuccess(SmallRiverResouresInfoListResponse result) {
                    pDialog.dismiss();
                    if (result.getRows().size() > 0) {
                        if (StringUtils.isEmpty(mRowsBeanMap.get(type))) {
                            mRowsBeanMap.put(type, type);
                            smallRiverShowData(type, result.getRows());
                        }
                    }
                }
            });
        } else if (type.equals("floods")) {
            final ProgressDialog pDialog = ProgressDialog
                    .show(this, "请稍等", "正在加载数据...");
            MyRetrofit.StartQueryNet(mContext, true, ApiPathUrl.ACTION_GETRISKPOINTBYTYPE, map, new ResponseCallBack<FloodsResouresInfoListResponse>() {
                @Override
                protected void onLoad(Disposable d) {
                    pDialog.show();
                }

                @Override
                protected void onError(KtkjError error) {
                    ToastUtils.showMessage(mContext, error.msg);
                    pDialog.dismiss();
                }

                @Override
                protected void onSuccess(FloodsResouresInfoListResponse result) {
                    pDialog.dismiss();
                    if (result.getRows().size() > 0) {
                        if (StringUtils.isEmpty(mRowsBeanMap.get(type))) {
                            mRowsBeanMap.put(type, type);
                            floodsShowData(type, result.getRows());
                        }
                    }
                }
            });
        } else if (type.equals("debrisFlow")) {
            final ProgressDialog pDialog = ProgressDialog
                    .show(this, "请稍等", "正在加载数据...");
            MyRetrofit.StartQueryNet(mContext, true, ApiPathUrl.ACTION_GETRISKPOINTBYTYPE, map, new ResponseCallBack<DebrisFlowResouresInfoListResponse>() {
                @Override
                protected void onLoad(Disposable d) {
                    pDialog.show();
                }

                @Override
                protected void onError(KtkjError error) {
                    ToastUtils.showMessage(mContext, error.msg);
                    pDialog.dismiss();
                }

                @Override
                protected void onSuccess(DebrisFlowResouresInfoListResponse result) {
                    pDialog.dismiss();
                    if (result.getRows().size() > 0) {
                        if (StringUtils.isEmpty(mRowsBeanMap.get(type))) {
                            mRowsBeanMap.put(type, type);
                            debrisFlowShowData(type, result.getRows());
                        }
                    }
                }
            });
        }
    }

    @Override
    protected boolean needToolbar() {
        return false;
    }

    @Override
    protected void onResume() {
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
        //为系统的方向传感器注册监听器
        mSensorManager.registerListener(this, mSensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION),
                SensorManager.SENSOR_DELAY_UI);
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    protected void onStop() {
        //取消注册传感器监听
        mSensorManager.unregisterListener(this);
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        // 退出时销毁定位
        mLocClient.stop();
        // 关闭定位图层
        mBaiduMap.setMyLocationEnabled(false);
        mMapView.onDestroy();
        mMapView = null;
        super.onDestroy();
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        double x = sensorEvent.values[SensorManager.DATA_X];
        if (Math.abs(x - lastX) > 1.0) {
            mCurrentDirection = (int) x;
            locData = new MyLocationData.Builder()
                    .accuracy(mCurrentAccracy)
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(mCurrentDirection).latitude(mCurrentLat)
                    .longitude(mCurrentLon).build();
            mBaiduMap.setMyLocationData(locData);
        }
        lastX = x;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @OnClick({R.id.lin_translate, R.id.lin_person, R.id.lin_place, R.id.lin_zhiling})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_translate:
                PopWindowMapRight.Show(ResourcesMapActivity.this, mRoot, mItemHomeTypeInfoList, new PopWindowMapRight.OnItemClickListener() {
                    @Override
                    public void ItemClick(int position) {
                        if (StringUtils.isEmpty(mRowsBeanMap.get(mItemHomeTypeInfoList.get(position).TypeRequest))) {
                            getData(mItemHomeTypeInfoList.get(position).TypeRequest, position);
                        } else {
                            ReMoveplace(mMarkerList);
                        }
                    }
                });

                break;
            case R.id.lin_person:
                break;
            case R.id.lin_place:
                isShowPlace=!isShowPlace;
                initPlace();
                break;
            case R.id.lin_zhiling:
                break;
        }
    }


    /**
     * 定位SDK监听函数
     */
    public class MyLocationListenner implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // map view 销毁后不在处理新接收的位置
            if (location == null || mMapView == null) {
                return;
            }
            mCurrentLat = location.getLatitude();
            mCurrentLon = location.getLongitude();
            mCurrentAccracy = location.getRadius();
            locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(mCurrentDirection).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();
            mBaiduMap.setMyLocationData(locData);
            if (isFirstLoc) {
                isFirstLoc = false;
                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                mbuilder.target(ll).zoom(11.0f);
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(mbuilder.build()));
            }
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }

        public void onReceivePoi(BDLocation poiLocation) {

        }
    }

    private void subsideShowData(String type, List<SubsideResouresInfoListResponse.RowsBean> rowsBean) {
        CoordinateConverter converter = new CoordinateConverter();
        converter.from(CoordinateConverter.CoordType.COMMON);
        for (SubsideResouresInfoListResponse.RowsBean item : rowsBean) {
            // sourceLatLng待转换坐标
            converter.coord(new LatLng(item.getRsLatitude(), item.getRsLongitude()));
            LatLng desLatLng = converter.convert();
            setIconFlage(type, desLatLng, R.mipmap.map_icon_danger_taxian);
        }
    }

    private void collapseShowData(String type, List<CollapseResouresInfoListResponse.RowsBean> rowsBean) {
        CoordinateConverter converter = new CoordinateConverter();
        converter.from(CoordinateConverter.CoordType.COMMON);
        for (CollapseResouresInfoListResponse.RowsBean item : rowsBean) {
            //  1  collapse 崩塌
            //  2  subside 塌陷
            //  3  landslide 滑坡
            //  4  smallRiver 中小河流
            //  5  floods 山洪沟
            //  6 debrisFlow 泥石流

            converter.coord(new LatLng(item.getRcLatitude(), item.getRcLongitude()));
            LatLng desLatLng = converter.convert();
            setIconFlage(type, desLatLng, R.mipmap.map_icon_danger_bengta);
        }
    }

    private void landslideShowData(String type, List<LandslideResouresInfoListResponse.RowsBean> rowsBean) {
        CoordinateConverter converter = new CoordinateConverter();
        converter.from(CoordinateConverter.CoordType.COMMON);
        for (LandslideResouresInfoListResponse.RowsBean item : rowsBean) {
            //  1  collapse 崩塌
            //  2  subside 塌陷
            //  3  landslide 滑坡
            //  4  smallRiver 中小河流
            //  5  floods 山洪沟
            //  6 debrisFlow 泥石流
            converter.coord(new LatLng(item.getRlLatitude(), item.getRlLongitude()));
            LatLng desLatLng = converter.convert();
            setIconFlage(type, desLatLng, R.mipmap.map_icon_danger_huapo);
        }
    }

    private void smallRiverShowData(String type, List<SmallRiverResouresInfoListResponse.RowsBean> rowsBean) {
        CoordinateConverter converter = new CoordinateConverter();
        converter.from(CoordinateConverter.CoordType.COMMON);
        for (SmallRiverResouresInfoListResponse.RowsBean item : rowsBean) {
            //  1  collapse 崩塌
            //  2  subside 塌陷
            //  3  landslide 滑坡
            //  4  smallRiver 中小河流
            //  5  floods 山洪沟
            //  6 debrisFlow 泥石流
            converter.coord(new LatLng(item.getRmrRiverSourceLatitude(), item.getRmrRiverSourceLongitude()));
            LatLng desLatLng = converter.convert();
            setIconFlage(type, desLatLng, R.mipmap.map_icon_danger_smallriver);
        }
    }

    private void floodsShowData(String type, List<FloodsResouresInfoListResponse.RowsBean> rowsBean) {
        CoordinateConverter converter = new CoordinateConverter();
        converter.from(CoordinateConverter.CoordType.COMMON);
        for (FloodsResouresInfoListResponse.RowsBean item : rowsBean) {
            //  1  collapse 崩塌
            //  2  subside 塌陷
            //  3  landslide 滑坡
            //  4  smallRiver 中小河流
            //  5  floods 山洪沟
            //  6 debrisFlow 泥石流
            converter.coord(new LatLng(item.getRffLatitude(), item.getRffLongitude()));
            LatLng desLatLng = converter.convert();
            setIconFlage(type, desLatLng, R.mipmap.map_icon_danger_floods);
        }
    }


    private void debrisFlowShowData(String type, List<DebrisFlowResouresInfoListResponse.RowsBean> rowsBean) {
        CoordinateConverter converter = new CoordinateConverter();
        converter.from(CoordinateConverter.CoordType.COMMON);
        for (DebrisFlowResouresInfoListResponse.RowsBean item : rowsBean) {
            //  1  collapse 崩塌
            //  2  subside 塌陷
            //  3  landslide 滑坡
            //  4  smallRiver 中小河流
            //  5  floods 山洪沟
            //  6 debrisFlow 泥石流
            converter.coord(new LatLng(item.getRdfLatitude(), item.getRdfLongitude()));
            LatLng desLatLng = converter.convert();
            setIconFlage(type, desLatLng, R.mipmap.map_icon_danger_debrisflow);
        }
    }


    //风险点坐标设置
    private void setIconFlage(String type, LatLng lat, @DrawableRes int id) {

        final ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
        imageView.setImageResource(id);
        BitmapDescriptor pic = BitmapDescriptorFactory.fromView(imageView);
        MarkerOptions overlayOptions = new MarkerOptions()
                .position(lat)
                .icon(pic);
        Marker marker = (Marker) mBaiduMap.addOverlay(overlayOptions);
        Bundle bundle = new Bundle();
        bundle.putString("xb", type);
        marker.setExtraInfo(bundle);
        mMarkerList.add(marker);
    }
    //风险点坐标设置
    private void setPaceIconFlage(String type, LatLng lat, @DrawableRes int id) {

        final ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
        imageView.setImageResource(id);
        BitmapDescriptor pic = BitmapDescriptorFactory.fromView(imageView);
        MarkerOptions overlayOptions = new MarkerOptions()
                .position(lat)
                .icon(pic);
        Marker marker = (Marker) mBaiduMap.addOverlay(overlayOptions);
        Bundle bundle = new Bundle();
        bundle.putString("xb", type);
        marker.setExtraInfo(bundle);
        mPalcMarkerList.add(marker);
    }

    private void initPlace() {
        if (mMapPlaceResponse==null) {
                final ProgressDialog pDialog = ProgressDialog
                        .show(this, "请稍等", "正在加载数据...");
                MyRetrofit.StartQueryNet(mContext, false, ApiPathUrl.ACTION_GETALLPLACE, new HashMap<String, String>(), new ResponseCallBack<MapPlaceResponse>() {
                    @Override
                    protected void onLoad(Disposable d) {
                        pDialog.show();
                    }

                    @Override
                    protected void onError(KtkjError error) {
                        ToastUtils.showMessage(mContext, error.msg);
                        pDialog.dismiss();
                    }

                    @Override
                    protected void onSuccess(MapPlaceResponse result) {
                        pDialog.dismiss();
                        mMapPlaceResponse = result;
                        ReSetMarkChangShuo(mMapPlaceResponse);
                    }
                });

        }else {
            ReMoveplaceMark(mPalcMarkerList, isShowPlace);
        }


    }
    private void ReSetMarkChangShuo(MapPlaceResponse mapPlaceResponse){
        for (MapPlaceResponse.RowsBean item:mapPlaceResponse.getRows()) {
            int picId;
            if (item.getPlaceType().equals("healthStation")){
                picId=R.mipmap.map_icon_place_health;
            }else{
                picId=R.mipmap.map_icon_place_refuge;
            }
            CoordinateConverter converter = new CoordinateConverter();
            converter.from(CoordinateConverter.CoordType.COMMON);
            converter.coord(new LatLng(item.getPlLatitude(),item.getPlLongitude()));
            LatLng desLatLng = converter.convert();
            setPaceIconFlage(item.getPlaceType(),desLatLng,picId);
        }
    }

    /***
     * 是否显示标注
     * @param markerList
     * @param
     */
    private void ReMoveplace(List<Marker> markerList) {

        for (ItemHomeTypeInfo item : mItemHomeTypeInfoList) {
            if (item.isSelected) {
                for (Marker mark : markerList) {
                    if (mark.getExtraInfo().get("xb").equals(item.TypeRequest)) {
                        mark.setVisible(true);
                    }
                }
            } else {
                for (Marker mark : markerList) {
                    if (mark.getExtraInfo().get("xb").equals(item.TypeRequest)) {
                        mark.setVisible(false);
                    }
                }
            }
        }
    }

    /***
     * 是否显示场所
     * @param markerList
     * @param
     */
    private void ReMoveplaceMark(List<Marker> markerList,boolean isShow) {
          for (Marker item : markerList) {
                item.setVisible(isShow);
          }
    }


    private void testRequest(){
        List<List<String[]>> json=new ArrayList<>();
        List<String[]> list1=new ArrayList<>();
        list1.add(new String[]{"115.9986","24.7768"});
        list1.add(new String[]{"115.9712","24.4696"});
        list1.add(new String[]{"116.4910","24.4999"});
        list1.add(new String[]{"116.4637","24.8299"});
        list1.add(new String[]{"115.9986","24.7768"});
        json.add(list1);
        String json1 = new Gson().toJson(json);
        Map<String,String> mdate=new HashMap<>();
        mdate.put("polygonJsonStr",json1);
        MyRetrofit.StartQueryNetByAllPath(mContext,false, "http://192.168.0.134:5555/pointCache/point/getInformationPointByGeometry", mdate, new ResponseCallBack<MapResourcePoitinfo>() {
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
             List<MapResourcePoitinfo> xb=(ArrayList<MapResourcePoitinfo>)result;
                Log.e("xb","大小："+xb.size());
            }
        });

    }

}