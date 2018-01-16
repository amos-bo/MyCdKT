package com.ktcd.malc.kt_ma_lc.activity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.Marker;
import com.baidu.mapapi.map.MarkerOptions;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.map.Projection;
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.google.gson.Gson;
import com.ktcd.malc.baselayer.activity.ToolbarActivity;
import com.ktcd.malc.kt_ma_lc.DateManager.AllDataToWeb;
import com.ktcd.malc.kt_ma_lc.DateManager.AllPointDataBean;
import com.ktcd.malc.kt_ma_lc.DateManager.FirstMoreDataDebrisFlow;
import com.ktcd.malc.kt_ma_lc.DateManager.FirstMoreDataLandsSlide;
import com.ktcd.malc.kt_ma_lc.DateManager.FirstMoreDataMountain;
import com.ktcd.malc.kt_ma_lc.DateManager.FirstMoreDataSmallRevier;
import com.ktcd.malc.kt_ma_lc.DateManager.SencondMoreDataRevierRequest;
import com.ktcd.malc.kt_ma_lc.DateManager.SencondeMoreDataDebrisFlowRequest;
import com.ktcd.malc.kt_ma_lc.DateManager.SencondeMoreDataLandsSlide;
import com.ktcd.malc.kt_ma_lc.DateManager.SencondeMoreDataMountainRequest;
import com.ktcd.malc.kt_ma_lc.DateManager.SmallRiverDateUtils;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.baiduloc.MyItemMarker;
import com.ktcd.malc.kt_ma_lc.baiduloc.clusterutil.clustering.ClusterManager;
import com.ktcd.malc.kt_ma_lc.bean.MapResourcePointInfoMore;
import com.ktcd.malc.kt_ma_lc.bean.MapResourcePoitinfo;
import com.ktcd.malc.kt_ma_lc.dialog.MyAlertDialog;
import com.ktcd.malc.kt_ma_lc.model.ItemMapResoureSelectType;
import com.ktcd.malc.utilslibrary.net.KtkjError;
import com.ktcd.malc.utilslibrary.net.MyRetrofit;
import com.ktcd.malc.utilslibrary.net.ResponseCallBack;

import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

import static com.baidu.mapapi.BMapManager.getContext;

public class NewMoreResourcesMapActivity extends ToolbarActivity implements SensorEventListener, BaiduMap.OnMapLoadedCallback {

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
    @BindView(R.id.toolbar_divider)
    View toolbarDivider;
    @BindView(R.id.toolbar_btn_container)
    LinearLayout toolbarBtnContainer;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.appbarLayout)
    AppBarLayout appbarLayout;
    @BindView(R.id.img_dgpoint)
    ImageView imgDgpoint;
    @BindView(R.id.img_person)
    ImageView imgPerson;
    @BindView(R.id.img_place)
    ImageView imgPlace;
    @BindView(R.id.lin_setting)
    LinearLayout linSetting;


    private MapView mMapView = null;
    private BaiduMap mBaiduMap = null;
    private MapStatus.Builder mbuilder = null;
    private UiSettings mUiSettings = null;

    MapStatus ms;
    private ClusterManager<MyItemMarker> mClusterManager;


    // 定位相关
    private LocationClient mLocClient;
    public MyLocationListenner myListener = new MyLocationListenner();
    private MyLocationConfiguration.LocationMode mCurrentMode;
    private SensorManager mSensorManager;
    private Double lastX = 0.0;
    private int mCurrentDirection = 0;
    private double mCurrentLat = 0.0;
    private double mCurrentLon = 0.0;
    private float mCurrentAccracy;
    boolean isFirstLoc = true; // 是否首次定位
    private MyLocationData locData;

    private List<MapResourcePoitinfo> mDgPointInfo;
    private List<MapResourcePoitinfo> mPersonPointInfo;
    private List<MapResourcePoitinfo> mPlacePointInfo;

    private List<Marker> mPalcMarkerList;
    private List<Marker> mDgMarkerList;
    private List<Marker> mPersonMarkerList;

    SoftReference<Object> mDgMarkerListsf;
    SoftReference<Object> mPalcMarkerListsf;
    SoftReference<Object> mPersonMarkerListsf;

    private boolean mIsCanShowDgMark = true;
    private boolean mIsCanShowPlaceMark = true;
    private boolean mIsCanShowPersonMark = true;


    private static long mFirstTime = 0;
    private LatLng mStartLng, mFinishLng;
    private float mZoomSize;
    private boolean mIsMove;

    private HashMap<String, String> mHashMap;


    private ArrayList<ItemMapResoureSelectType> mSelectDp;
    private ArrayList<ItemMapResoureSelectType> mSelectDg;

    private BitmapDescriptor[] mBitmapDescriptors;
    private InfoWindow mInfoWindow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources_map);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        setUpToolbar(mToolbar);
        setNavigationIcon(R.mipmap.home_return);
        setTitle("灾害点资源地图");
        mMapView = (MapView) findViewById(R.id.bmapView);
        mBaiduMap = mMapView.getMap();
        //普通地图
        mBaiduMap.setMapType(BaiduMap.MAP_TYPE_NORMAL);
        //开启定位图层
        mBaiduMap.setMyLocationEnabled(true);
        mbuilder = new MapStatus.Builder();
        mbuilder.zoom(8.0f);//默认放缩级别11，最高21
        mbuilder.overlook(0);
        //移除百度图标
        mMapView.removeViewAt(1);
        //移除比例尺
        mMapView.removeViewAt(2);
        mUiSettings = mBaiduMap.getUiSettings();
        mUiSettings.setCompassEnabled(true);//开启指南针
        mCurrentMode = MyLocationConfiguration.LocationMode.NORMAL;
        mBaiduMap.setMyLocationConfiguration(new MyLocationConfiguration(
                mCurrentMode, true, null));//传null使用默认图标
        mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(mbuilder.build()));
        ms = mbuilder.build();
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

        mBaiduMap.setOnMapLoadedCallback(this);
        mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(ms));
        mBaiduMap.setOnMapStatusChangeListener(new BaiduMap.OnMapStatusChangeListener() {
            @Override
            public void onMapStatusChangeStart(MapStatus mapStatus) {
                mZoomSize = mapStatus.zoom;
                mStartLng = mapStatus.target;
                mIsMove = false;
            }

            @Override
            public void onMapStatusChange(MapStatus mapStatus) {
            }

            @Override
            public void onMapStatusChangeFinish(MapStatus mapStatus) {
                mFinishLng = mapStatus.target;
                if (mStartLng.latitude != mFinishLng.latitude
                        || mStartLng.longitude != mFinishLng.longitude) {
                    Projection ject = mBaiduMap.getProjection();
                    Point startPoint = ject.toScreenLocation(mStartLng);
                    Point finishPoint = ject.toScreenLocation(mFinishLng);
                    double x = Math.abs(finishPoint.x - startPoint.x);
                    double y = Math.abs(finishPoint.y - startPoint.y);
                    if (x > 100 || y > 100) {
                        mIsMove = true;
                    }
                }
                long secondTime = System.currentTimeMillis();
                if (mZoomSize - mapStatus.zoom >= 1 || mIsMove) {
                    // 如果两次按键时间间隔大于800毫秒，则不退出
                    if (secondTime - mFirstTime >= 2000) {
                        if (mSelectDg != null || mSelectDp != null) {
                            getDataRequest(mSelectDp, mSelectDg);
                        }
                    }
                }
                mFirstTime = secondTime;
            }
        });
        mBaiduMap.setMaxAndMinZoomLevel(21, 8);
        mBitmapDescriptors = initIocnMap();
    }

    private void initData() {
        mDgPointInfo = Collections.synchronizedList(new ArrayList());//new ArrayList<>();
        mPersonPointInfo = Collections.synchronizedList(new ArrayList());
        mPlacePointInfo = Collections.synchronizedList(new ArrayList());
        mPalcMarkerList = Collections.synchronizedList(new ArrayList());
        mDgMarkerList = Collections.synchronizedList(new ArrayList());
        mPersonMarkerList = Collections.synchronizedList(new ArrayList());
        mBaiduMap.setOnMarkerClickListener(new BaiduMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                MapResourcePoitinfo.TypeData Type = (MapResourcePoitinfo.TypeData) marker.getExtraInfo().getSerializable("xb");
                if (Type.name.endsWith("Other")) {
                    getMorePointData(marker, Type);
                } else {
                    getLessPointData(marker, Type);
                }
                return true;
            }
        });
        mHashMap = new HashMap<>();
    }

    @Override
    protected boolean needToolbar() {
        return true;
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


        mDgPointInfo.clear();
        mPersonPointInfo.clear();
        mPlacePointInfo.clear();

        mPalcMarkerList.clear();
        mDgMarkerList.clear();
        mPersonMarkerList.clear();
        mHashMap.clear();

        mDgPointInfo = null;
        mPersonPointInfo = null;
        mPlacePointInfo = null;

        mPalcMarkerList = null;
        mDgMarkerList = null;
        mPersonMarkerList = null;
        mHashMap = null;

        // 退出时销毁定位
        mLocClient.stop();
        // 关闭定位图层
        mBaiduMap.setMyLocationEnabled(false);
        mMapView.onDestroy();
        mMapView = null;
        System.gc();
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

    @OnClick({R.id.lin_translate, R.id.lin_person, R.id.lin_place, R.id.lin_zhiling, R.id.lin_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_translate:
                if (mDgMarkerList.size() > 0) {
                    mIsCanShowDgMark = !mIsCanShowDgMark;
                    ReShowOrHiddeMark(1, mIsCanShowDgMark);
                }
                break;
            case R.id.lin_person:
                if (mPersonMarkerList.size() > 0) {
                    mIsCanShowPersonMark = !mIsCanShowPersonMark;
                    ReShowOrHiddeMark(3, mIsCanShowPersonMark);
                }
                break;
            case R.id.lin_place:
                if (mPalcMarkerList.size() > 0) {
                    mIsCanShowPlaceMark = !mIsCanShowPlaceMark;
                    ReShowOrHiddeMark(2, mIsCanShowPlaceMark);
                }
                break;
            case R.id.lin_setting:
                Bundle bundle = new Bundle();
                if (mSelectDp != null) {
                    mSelectDp.addAll(mSelectDg);
                    bundle.putSerializable("DP_AND_DG", mSelectDp);
                    startActivityForResult(ResourcesMapSettingActivity.class, bundle, 1000);
                } else {
                    startActivityForResult(ResourcesMapSettingActivity.class, 1000);
                }

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
 //               isFirstLoc = false;
//                LatLng ll = new LatLng(24.0797848,
//                        116.4015607);
//                mbuilder.target(ll).zoom(13.0f);
//                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(mbuilder.build()));
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
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 1000) {
                HashMap<Integer, ArrayList<ItemMapResoureSelectType>> selectData = (HashMap<Integer, ArrayList<ItemMapResoureSelectType>>) data.getExtras().getSerializable("DATA");
                if (selectData.size() > 0) {
                    mBaiduMap.clear();
                    mHashMap.clear();
                    mSelectDp = selectData.get(1);
                    mSelectDg = selectData.get(2);
                    mDgPointInfo.clear();
                    mPersonPointInfo.clear();
                    mPlacePointInfo.clear();
                    mPalcMarkerList.clear();
                    mDgMarkerList.clear();
                    mPersonMarkerList.clear();
                    getDataRequest(mSelectDp, mSelectDg);
                }
            }
        }
    }


    private void getDataRequest(ArrayList<ItemMapResoureSelectType> dpList, ArrayList<ItemMapResoureSelectType> dgList) {
        List<List<String[]>> json = new ArrayList<>();
        List<String[]> list1 = new ArrayList<>();


        List<String> dpcode = new ArrayList<>();
        List<String> dgcode = new ArrayList<>();

        String dgcodetest = "";
        String departmentCode = "";
        for (int i = 0; i < dpList.size(); i++) {
            dpcode.add(dpList.get(i).dictCode);
            departmentCode = dpList.get(i).dictCode + "," + departmentCode;
        }
        for (int i = 0; i < dgList.size(); i++) {
            dgcode.add(dgList.get(i).getBasicDataDerviceCode());
            dgcodetest = dgList.get(i).getBasicDataDerviceCode() + "," + dgcodetest;
        }

        LatLng ll1 = getSite(1);
        LatLng ll2 = getSite(2);
        LatLng ll3 = getSite(4);
        LatLng ll4 = getSite(3);
//        list1.add(new String[]{"115.9986", "24.7768"});
//        list1.add(new String[]{"115.9712", "24.4696"});
//        list1.add(new String[]{"116.4910", "24.4999"});
//        list1.add(new String[]{"116.4637", "24.8299"});
//        list1.add(new String[]{"115.9986", "24.7768"});
        list1.add(new String[]{"" + ll1.longitude, "" + ll1.latitude});
        list1.add(new String[]{"" + ll2.longitude, "" + ll2.latitude});
        list1.add(new String[]{"" + ll3.longitude, "" + ll3.latitude});
        list1.add(new String[]{"" + ll4.longitude, "" + ll4.latitude});
        list1.add(new String[]{"" + ll1.longitude, "" + ll1.latitude});
        json.add(list1);
        Map<String, String> mdate = new HashMap<>();
//        mdate.put("departmentCodeList", departmentCode.substring(0, departmentCode.length() - 1));
        mdate.put("subclassList", dgcodetest.substring(0, dgcodetest.length() - 1));
        mdate.put("departmentTypeList", departmentCode.substring(0, departmentCode.length() - 1));
        mdate.put("polygonJsonStr", new Gson().toJson(json));
//        MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://192.168.0.200:5555/pointCache/point/getCountInformationPointByParam", mdate, new ResponseCallBack<MapResourcePointInfoMore>() {
        MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://lgrjian.gicp.net:12787/pointCache/point/getCountInformationPointByParam", mdate, new ResponseCallBack<MapResourcePointInfoMore>() {
            @Override
            protected void onLoad(Disposable d) {

            }

            @Override
            protected void onError(KtkjError error) {

            }

            @Override
            protected void onSuccess(MapResourcePointInfoMore result) {

            }

            @Override
            protected void onSuccessList(Object result) {
                List<MapResourcePointInfoMore> allDataInfo = (ArrayList<MapResourcePointInfoMore>) result;
                splitDataofAllData(splitDataofAllDataFirist(allDataInfo));
            }
        });

    }


    /**
     * 第一次数据拆分
     *
     * @param allDataInfo
     */
    private List<MapResourcePoitinfo> splitDataofAllDataFirist(List<MapResourcePointInfoMore> allDataInfo) {
        List<MapResourcePoitinfo> resultDataInfo = new ArrayList<>();
        for (MapResourcePointInfoMore item1 : allDataInfo) {
            for (MapResourcePointInfoMore.CountBasicDataNumVoListBean item2 : item1.getCountBasicDataNumVoList()) {
                for (MapResourcePointInfoMore.CountBasicDataNumVoListBean.InformationPointListBean item3 : item2.getInformationPointList()) {
                    MapResourcePoitinfo myData = new MapResourcePoitinfo();
                    myData.setCategory(item3.getCategory());
                    myData.setDepartmentCode(item3.getDepartmentCode());
                    myData.setId(item3.getId());
                    myData.setLatitude(item3.getLatitude());
                    myData.setLongitude(item3.getLongitude());
                    myData.setSubclass(item3.getSubclass());
                    resultDataInfo.add(myData);
                }
            }
        }
        allDataInfo.clear();
        allDataInfo = null;
        return resultDataInfo;
    }

    /**
     * 分解：危险点、场所、人员信息
     *
     * @param allData
     */
    private void splitDataofAllData(List<MapResourcePoitinfo> allData) {
        for (final MapResourcePoitinfo item : allData) {
            //GPS坐标转百度地图坐标
            CoordinateConverter converter = new CoordinateConverter();
            converter.from(CoordinateConverter.CoordType.COMMON);
            converter.coord(new LatLng(item.getLatitude(), item.getLongitude()));
            item.typeData.latLng = converter.convert();
            item.typeData.name = item.getSubclass();
            item.typeData.Id = item.getId();
            if (item.getCategory().equals("risk_point")) { /**危险点**/
                //  1  subside 崩塌
                //  2  collapse 塌陷
                //  3  landslide 滑坡
                //  4  smallRiver 中小河流
                //  5  floods 山洪沟
                //  6 debrisFlow 泥石流
                item.typeData.PointType = 1;
                if (item.getSubclass().equals("subside") || item.getSubclass().equals("subsideOther")) {
                    item.typeData.subType = 1;
                    item.typeData.ImageType = R.mipmap.map_icon_danger_taxian;
                } else if (item.getSubclass().equals("collapse") || item.getSubclass().equals("collapseOther")) {
                    item.typeData.subType = 2;
                    item.typeData.ImageType = R.mipmap.map_icon_danger_bengta;
                } else if (item.getSubclass().equals("landslide") || item.getSubclass().equals("landslideOther")) {
                    item.typeData.subType = 3;
                    item.typeData.ImageType = R.mipmap.map_icon_danger_huapo;
                } else if (item.getSubclass().equals("smallRiver") || item.getSubclass().equals("smallRiverOther")) {
                    item.typeData.subType = 4;
                    item.typeData.ImageType = R.mipmap.map_icon_danger_smallriver;
                } else if (item.getSubclass().equals("flashFlood") || item.getSubclass().equals("flashFloodOther")) {
                    item.typeData.subType = 5;
                    item.typeData.ImageType = R.mipmap.map_icon_danger_floods;
                } else if (item.getSubclass().equals("debrisFlow") || item.getSubclass().equals("debrisFlowOther")) {
                    item.typeData.subType = 6;
                    item.typeData.ImageType = R.mipmap.map_icon_danger_debrisflow;
                }
                mDgPointInfo.add(item);
            } else if (item.getCategory().equals("place")) { /**场所**/
                item.typeData.PointType = 2;
                if (item.getSubclass().equals("healthStation")) {
                    item.typeData.subType = 7;//医院
                    item.typeData.ImageType = R.mipmap.map_icon_danger_debrisflow;
                } else if (item.getSubclass().equals("shelter")) {
                    item.typeData.subType = 8;//避难所
                    item.typeData.ImageType = R.mipmap.map_icon_place_refuge;
                }
                mPlacePointInfo.add(item);
            } else { /**人员**/
                item.typeData.PointType = 3;
                mPersonPointInfo.add(item);
            }
        }

        Thread dgThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mDgPointInfo) {
                    for (MapResourcePoitinfo item : mDgPointInfo) {
                        setIconFlage(item.typeData);
                    }
                }
            }
        });
        Thread plThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mPlacePointInfo) {
                    for (MapResourcePoitinfo item : mPlacePointInfo) {
                        setIconFlage(item.typeData);
                    }
                }
            }
        });
        Thread PersonThread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mPersonPointInfo) {
                    for (MapResourcePoitinfo item : mPersonPointInfo) {
                        setIconFlage(item.typeData);
                    }
                }
            }
        });
        dgThread.start();
        plThread.start();
        PersonThread.start();
    }

    //风险点坐标设置
    private void setIconFlage(MapResourcePoitinfo.TypeData typeData) {
        if (typeData.ImageType != 0 && mHashMap.get(typeData.Id) == null) {
            MarkerOptions overlayOptions = new MarkerOptions()
                    .position(typeData.latLng)
                    .icon(mBitmapDescriptors[typeData.subType]);
            Marker marker = (Marker) mBaiduMap.addOverlay(overlayOptions);
            SoftReference<Marker> sMarker = new SoftReference<Marker>(marker);
            Bundle bundle = new Bundle();
            bundle.putSerializable("xb", typeData);
            sMarker.get().setExtraInfo(bundle);
            if (typeData.PointType == 1) {
                mDgMarkerList.add(sMarker.get());
            } else if (typeData.PointType == 2) {
                mPalcMarkerList.add(sMarker.get());
            } else if (typeData.PointType == 3) {
                mPersonMarkerList.add(sMarker.get());
            }
            mHashMap.put(typeData.Id, "T");
//            pic.recycle();
        } else {
            Log.e("xb", "typeData:" + typeData.PointType);
            Log.e("xb", "nameF:" + typeData.name);
        }
    }


    /**
     * 是否显示marker
     *
     * @param Type   大类
     * @param isShow 是否显示
     */
    private void ReShowOrHiddeMark(int Type, final boolean isShow) {

        if (Type == 1) {
            if (isShow) {
                imgDgpoint.setImageResource(R.mipmap.map_btn_danger);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (mDgMarkerList) {
                            for (Marker item : mDgMarkerList) {
                                item.setVisible(isShow);
                            }
                        }
                    }
                }).start();
            }
            //TODO 可以继续添加子类操作
            else {
                imgDgpoint.setImageResource(R.mipmap.map_btn_gray_danger);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (mDgMarkerList) {
                            for (Marker item : mDgMarkerList) {
                                item.setVisible(isShow);
                            }
                        }
                    }
                }).start();
            }
        } else if (Type == 2) {
            if (isShow) {
                imgPlace.setImageResource(R.mipmap.map_btn_place);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (mPalcMarkerList) {
                            for (Marker item : mPalcMarkerList) {
                                item.setVisible(isShow);
                            }
                        }
                    }
                }).start();
                //TODO 可以继续添加子类操作
            } else {
                imgPlace.setImageResource(R.mipmap.map_btn_gray_place);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (mPalcMarkerList) {
                            for (Marker item : mPalcMarkerList) {
                                item.setVisible(isShow);
                            }
                        }
                    }
                }).start();
            }
        } else if (Type == 3) {
            if (isShow) {
                imgPerson.setImageResource(R.mipmap.map_btn_man);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (mPersonMarkerList) {
                            for (Marker item : mPersonMarkerList) {
                                item.setVisible(isShow);
                            }
                        }
                    }
                }).start();
            }
            //TODO 可以继续添加子类操作
            else {
                imgPerson.setImageResource(R.mipmap.map_btn_gray_man);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        synchronized (mPersonMarkerList) {
                            for (Marker item : mPersonMarkerList) {
                                item.setVisible(isShow);
                            }
                        }
                    }
                }).start();
            }
        }
    }


    @Override
    public void onMapLoaded() {
        // TODO Auto-generated method stub
        ms = new MapStatus.Builder().zoom(11).build();
        mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(ms));
//        getDataRequest();
    }


    private LatLng getSite(int type) {
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        Point pt = new Point();
        if (type == 1) {
            //左上角
            pt.x = 0;
            pt.y = 0;
        }
        if (type == 2) {
            //左下角
            pt.x = 0;
            pt.y = dm.heightPixels;
        }
        if (type == 3) {
            //右上角
            pt.x = dm.widthPixels;
            pt.y = 0;
        }
        if (type == 4) {
            //右下角
            pt.x = dm.widthPixels;
            pt.y = dm.heightPixels;
        }

        LatLng ll = mBaiduMap.getProjection().fromScreenLocation(pt);
        return ll;
    }

    private BitmapDescriptor[] initIocnMap() {
        BitmapDescriptor[] fs = new BitmapDescriptor[11];
        for (int i = 0; i <= 10; i++) {
            ImageView imageView = new ImageView(mContext);
            SoftReference<ImageView> sfimg = new SoftReference<ImageView>(imageView);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
            if (i == 1) {
                imageView.setImageResource(R.mipmap.map_icon_danger_taxian);
            }
            if (i == 2) {
                imageView.setImageResource(R.mipmap.map_icon_danger_bengta);
            }
            if (i == 3) {
                imageView.setImageResource(R.mipmap.map_icon_danger_huapo);
            }
            if (i == 4) {
                imageView.setImageResource(R.mipmap.map_icon_danger_taxian);
            }
            if (i == 5) {
                imageView.setImageResource(R.mipmap.map_icon_danger_floods);
            }
            if (i == 6) {
                imageView.setImageResource(R.mipmap.map_icon_danger_debrisflow);
            }
            if (i == 7) {
                imageView.setImageResource(R.mipmap.map_icon_danger_debrisflow);
            }
            if (i == 8) {
                imageView.setImageResource(R.mipmap.map_icon_place_refuge);
            }
            if (i == 9) {
                imageView.setImageResource(R.mipmap.map_icon_danger_taxian);
            }
            if (i == 10) {
                imageView.setImageResource(R.mipmap.map_icon_danger_taxian);
            }
            BitmapDescriptor pic = BitmapDescriptorFactory.fromView(sfimg.get());
            fs[i] = pic;
        }
        return fs;
    }

    /**
     * 显示弹框
     *
     * @param marker
     */
    private void ShowInfoWind(final Marker marker, View view) {
        InfoWindow.OnInfoWindowClickListener listener = null;
        listener = new InfoWindow.OnInfoWindowClickListener() {
            public void onInfoWindowClick() {
                LatLng ll = marker.getPosition();
                LatLng llNew = new LatLng(ll.latitude + 0.005,
                        ll.longitude + 0.005);
                marker.setPosition(llNew);
                mBaiduMap.hideInfoWindow();
            }
        };
        LatLng ll = marker.getPosition();
//        mInfoWindow = new InfoWindow(BitmapDescriptorFactory.fromView(view), ll, -47, listener);
        mInfoWindow = new InfoWindow(view, ll, -80);
        mBaiduMap.showInfoWindow(mInfoWindow);
    }

    /**
     * 普查
     *
     * @param typeData
     */
    private void getMorePointData(final Marker marker, final MapResourcePoitinfo.TypeData typeData) {
        String lastUrl = "";
        HashMap<String, String> mapData = new HashMap<>();
        mapData.put("str", typeData.Id);

        final AllDataToWeb allPointDataBean = new AllDataToWeb();
        allPointDataBean.Type = typeData.name;
        switch (typeData.name) {
            case "subsideOther":
                lastUrl = "";
                break;
            case "collapseOther":
                lastUrl = "";
                break;
            case "landslideOther":
                lastUrl = "/SLandslide/getLandslide";
//                MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://192.168.0.200:5555/geologyHazard" + lastUrl, mapData, new ResponseCallBack<FirstMoreDataLandsSlide>() {
                MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://lgrjian.gicp.net:12787/geologyHazard" + lastUrl, mapData, new ResponseCallBack<FirstMoreDataLandsSlide>() {
                    @Override
                    protected void onLoad(Disposable d) {

                    }

                    @Override
                    protected void onError(KtkjError error) {

                    }

                    @Override
                    protected void onSuccess(FirstMoreDataLandsSlide result) {
                        allPointDataBean.data = result;
                        SencondeMoreDataLandsSlide sencondemoredatalandsslide = new SencondeMoreDataLandsSlide();
                        sencondemoredatalandsslide.setLat("" + typeData.latLng.latitude);
                        sencondemoredatalandsslide.setLon("" + typeData.latLng.longitude);
                        sencondemoredatalandsslide.data = new ArrayList<>();
                        for (FirstMoreDataLandsSlide.TvBean item : result.getTv()) {
                            SencondeMoreDataLandsSlide.DataBean date = new SencondeMoreDataLandsSlide.DataBean();
                            date.setDay("" + item.getRainday());
                            date.setDaythreshold("" + item.getEaryuserain());
                            date.setHour("" + item.getStriketime());
                            date.setThreshold("" + item.getStrikerain());
                            sencondemoredatalandsslide.data.add(date);
                        }

                        HashMap<String, String> mapData = new HashMap<>();
                        mapData.put("str", new Gson().toJson(sencondemoredatalandsslide));
//                        MyRetrofit.StartQueryNetByAllPath(mContext, true, "http://192.168.0.200:5555/dynamicInfo/AwsDynamicData/getDynamicDataLandslide", mapData, new ResponseCallBack<String>() {
                        MyRetrofit.StartQueryNetByAllPath(mContext, true, "http://lgrjian.gicp.net:12787/dynamicInfo/AwsDynamicData/getDynamicDataLandslide", mapData, new ResponseCallBack<String>() {
                            @Override
                            protected void onLoad(Disposable d) {

                            }

                            @Override
                            protected void onError(KtkjError error) {

                            }

                            @Override
                            protected void onSuccess(String result) {
                                allPointDataBean.realdata = result;
                                ShowInfoWind(marker, SmallRiverDateUtils.setMoreDateWebView(mContext, "http://192.168.0.107:8080/meizu/view/common/mapLandslidedetail.html?type=app", allPointDataBean, new SmallRiverDateUtils.DeletListener() {
                                    @Override
                                    public void deletOk() {
                                        mBaiduMap.hideInfoWindow();
                                    }
                                }));
//
//                                final MyAlertDialog alertDialog = new MyAlertDialog.Builder(mContext)
//                                        .setContentView(
//                                                SmallRiverDateUtils.setMoreDateWebView(mContext, "http://192.168.0.107:8080/meizu/view/common/mapLandslidedetail.html?type=app", allPointDataBean, new SmallRiverDateUtils.DeletListener() {
//                                                    @Override
//                                                    public void deletOk() {
//
//                                                    }
//                                                })
//                                        ).fromWidthHeight(1200,1400).setOnDismissListener(new OnDismissListener() {
//                                            @Override
//                                            public void onDismiss(DialogInterface dialogInterface) {
//                                                dialogInterface.dismiss();
//                                            }
//                                        }).show();
                            }
                        });
                    }
                });
                break;
            case "smallRiverOther":
                lastUrl = "/rivercontroll/getRiver";
//                MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://192.168.0.200:5555/geologyHazard" + lastUrl, mapData, new ResponseCallBack<FirstMoreDataSmallRevier>() {
                MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://lgrjian.gicp.net:12787/geologyHazard" + lastUrl, mapData, new ResponseCallBack<FirstMoreDataSmallRevier>() {
                    @Override
                    protected void onLoad(Disposable d) {

                    }

                    @Override
                    protected void onError(KtkjError error) {

                    }

                    @Override
                    protected void onSuccess(FirstMoreDataSmallRevier result) {
                        allPointDataBean.data = result;
                        SencondMoreDataRevierRequest sencondmoredatarevierrequest = new SencondMoreDataRevierRequest();
                        sencondmoredatarevierrequest.setLat("" + typeData.latLng.latitude);
                        sencondmoredatarevierrequest.setLon("" + typeData.latLng.longitude);
                        sencondmoredatarevierrequest.data = new ArrayList<>();
                        for (FirstMoreDataSmallRevier.TvBean item : result.getTv()) {
                            SencondMoreDataRevierRequest.DataBean date = new SencondMoreDataRevierRequest.DataBean();
                            date.setThresholdwater(item.getRainfallfate());
                            date.setBasiclevel(item.getBasiclevel());
                            date.setHour(item.getCriticalrainfall());
                            date.setThreshold(item.getAttenuationcoefficient());
                            sencondmoredatarevierrequest.data.add(date);
                        }

                        HashMap<String, String> mapData = new HashMap<>();
                        mapData.put("str", new Gson().toJson(sencondmoredatarevierrequest));
//                        MyRetrofit.StartQueryNetByAllPath(mContext, true, "http://192.168.0.200:5555/dynamicInfo/AwsDynamicData/getDynamicDataRiver", mapData, new ResponseCallBack<String>() {
                        MyRetrofit.StartQueryNetByAllPath(mContext, true, "http://lgrjian.gicp.net:12787/dynamicInfo/AwsDynamicData/getDynamicDataRiver", mapData, new ResponseCallBack<String>() {
                            @Override
                            protected void onLoad(Disposable d) {

                            }

                            @Override
                            protected void onError(KtkjError error) {

                            }

                            @Override
                            protected void onSuccess(String result) {
                                allPointDataBean.realdata = result;
                                ShowInfoWind(marker, SmallRiverDateUtils.setMoreDateWebView(mContext, "http://lgrjian.gicp.net:12546/webui/view/common/mapRiverdetail.html?type=app", allPointDataBean, new SmallRiverDateUtils.DeletListener() {
                                    @Override
                                    public void deletOk() {
                                        mBaiduMap.hideInfoWindow();
                                    }
                                }));
                            }
                        });
                    }
                });
                break;
            case "flashFloodOther":
                lastUrl = "/mountaintorrents/getMountain";
//                MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://192.168.0.200:5555/geologyHazard" + lastUrl, mapData, new ResponseCallBack<FirstMoreDataMountain>() {
                MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://lgrjian.gicp.net:12787/geologyHazard" + lastUrl, mapData, new ResponseCallBack<FirstMoreDataMountain>() {
                    @Override
                    protected void onLoad(Disposable d) {

                    }

                    @Override
                    protected void onError(KtkjError error) {

                    }

                    @Override
                    protected void onSuccess(FirstMoreDataMountain result) {
                        allPointDataBean.data = result;
                        SencondeMoreDataMountainRequest sencondemoredatamountainrequest = new SencondeMoreDataMountainRequest();
                        sencondemoredatamountainrequest.setLat("" + typeData.latLng.latitude);
                        sencondemoredatamountainrequest.setLon("" + typeData.latLng.longitude);
                        sencondemoredatamountainrequest.data = new ArrayList<>();
                        for (FirstMoreDataMountain.TvBean item : result.getTv()) {
                            SencondeMoreDataMountainRequest.DataBean date = new SencondeMoreDataMountainRequest.DataBean();
                            date.setHour(item.getCrisisrainhour());
                            date.setThreshold(item.getCrisisfrain());
                            date.setThresholdWater(item.getCrisislevel());
                            date.setWaterlevel(item.getWaterlevel());
                            sencondemoredatamountainrequest.data.add(date);
                        }

                        HashMap<String, String> mapData = new HashMap<>();
                        mapData.put("str", new Gson().toJson(sencondemoredatamountainrequest));
//                        MyRetrofit.StartQueryNetByAllPath(mContext, true, "http://192.168.0.200:5555/dynamicInfo/AwsDynamicData/getDynamicDataMountain", mapData, new ResponseCallBack<String>() {
                        MyRetrofit.StartQueryNetByAllPath(mContext, true, "http://lgrjian.gicp.net:12787/dynamicInfo/AwsDynamicData/getDynamicDataMountain", mapData, new ResponseCallBack<String>() {
                            @Override
                            protected void onLoad(Disposable d) {

                            }

                            @Override
                            protected void onError(KtkjError error) {

                            }

                            @Override
                            protected void onSuccess(String result) {
                                allPointDataBean.realdata = result;
                                ShowInfoWind(marker, SmallRiverDateUtils.setMoreDateWebView(mContext, "http://lgrjian.gicp.net:12546/webui/view/common/mapMountaindetail.html?type=app", allPointDataBean, new SmallRiverDateUtils.DeletListener() {
                                    @Override
                                    public void deletOk() {
                                        mBaiduMap.hideInfoWindow();
                                    }
                                }));
                            }
                        });
                    }
                });
                break;
            case "debrisFlowOther":
                lastUrl = "/debrisflows/getDebrisFlow";
//                MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://192.168.0.200:5555/geologyHazard" + lastUrl, mapData, new ResponseCallBack<FirstMoreDataDebrisFlow>() {
                MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://lgrjian.gicp.net:12787/geologyHazard" + lastUrl, mapData, new ResponseCallBack<FirstMoreDataDebrisFlow>() {
                    @Override
                    protected void onLoad(Disposable d) {

                    }

                    @Override
                    protected void onError(KtkjError error) {

                    }

                    @Override
                    protected void onSuccess(FirstMoreDataDebrisFlow result) {
                        allPointDataBean.data = result;
                        SencondeMoreDataDebrisFlowRequest sencondemoredatadebrisflowrequest = new SencondeMoreDataDebrisFlowRequest();
                        sencondemoredatadebrisflowrequest.setLat("" + typeData.latLng.latitude);
                        sencondemoredatadebrisflowrequest.setLon("" + typeData.latLng.longitude);
                        sencondemoredatadebrisflowrequest.data = new ArrayList<>();
                        for (FirstMoreDataDebrisFlow.TvBean item : result.getTv()) {
                            SencondeMoreDataDebrisFlowRequest.DataBean date = new SencondeMoreDataDebrisFlowRequest.DataBean();
                            date.setDay(item.getUserainday());
                            date.setDaythreshold(item.getEaryuserain());
                            date.setHour(item.getStrikeraintime());
                            date.setThreshold(item.getStrikerain());
                            sencondemoredatadebrisflowrequest.data.add(date);
                        }
                        HashMap<String, String> mapData = new HashMap<>();
                        mapData.put("str", new Gson().toJson(sencondemoredatadebrisflowrequest));
//                        MyRetrofit.StartQueryNetByAllPath(mContext, true, "http://192.168.0.200:5555/dynamicInfo/AwsDynamicData/getDynamicDataDebrisFlow", mapData, new ResponseCallBack<String>() {
                        MyRetrofit.StartQueryNetByAllPath(mContext, true, "http://lgrjian.gicp.net:12787/dynamicInfo/AwsDynamicData/getDynamicDataDebrisFlow", mapData, new ResponseCallBack<String>() {
                            @Override
                            protected void onLoad(Disposable d) {

                            }

                            @Override
                            protected void onError(KtkjError error) {

                            }

                            @Override
                            protected void onSuccess(String result) {
                                allPointDataBean.realdata = result;
                                ShowInfoWind(marker, SmallRiverDateUtils.setMoreDateWebView(mContext, "http://lgrjian.gicp.net:12546/webui/view/common/mapDebrisFlowdetail.html?type=app", allPointDataBean, new SmallRiverDateUtils.DeletListener() {
                                    @Override
                                    public void deletOk() {
                                        mBaiduMap.hideInfoWindow();
                                    }
                                }));
                            }
                        });
                    }
                });
                break;
            default:
                break;
        }
    }

    /**
     * 一般
     *
     * @param typeData
     */
    private void getLessPointData(final Marker marker, MapResourcePoitinfo.TypeData typeData) {
        String lastUrl = "";
        switch (typeData.name) {
            case "subside":
                lastUrl = "/subside/getSubsideByID/" + typeData.Id;
                break;
            case "collapse":
                lastUrl = "";
                break;
            case "landslide":
                lastUrl = "/landslide/getLandslideByID/" + typeData.Id;
                break;
            case "smallRiver":
                lastUrl = "/smallRiver/getSmallRiverByID/" + typeData.Id;
                break;
            case "flashFlood":
                lastUrl = "/flashFloods/getFlashFloodsByID/" + typeData.Id;
                break;
            case "debrisFlow":
                lastUrl = "/debrisFlow/getDebrisFlowByID/" + typeData.Id;
                break;
            default:
                break;
        }
        HashMap<String, String> mapData = new HashMap<>();
//        MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://192.168.0.200:5555/geologyHazard" + lastUrl, mapData, new ResponseCallBack<AllPointDataBean>() {
       MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://lgrjian.gicp.net:12787/geologyHazard" + lastUrl, mapData, new ResponseCallBack<AllPointDataBean>() {
            @Override
            protected void onLoad(Disposable d) {

            }

            @Override
            protected void onError(KtkjError error) {

            }

            @Override
            protected void onSuccess(AllPointDataBean result) {
                ShowInfoWind(marker, SmallRiverDateUtils.setSmallRiverDateWebView(mContext, "http://lgrjian.gicp.net:12546/webui/view/common/generalpointmobileDetail.html", result, new SmallRiverDateUtils.DeletListener() {
                    @Override
                    public void deletOk() {
                        mBaiduMap.hideInfoWindow();
                    }
                }));
            }
        });
    }
}