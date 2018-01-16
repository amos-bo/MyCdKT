package com.ktcd.malc.kt_ma_lc.activity;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
import com.baidu.mapapi.map.UiSettings;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.google.gson.Gson;
import com.ktcd.malc.baselayer.activity.ToolbarActivity;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.baiduloc.MyItemMarker;
import com.ktcd.malc.kt_ma_lc.baiduloc.clusterutil.clustering.Cluster;
import com.ktcd.malc.kt_ma_lc.baiduloc.clusterutil.clustering.ClusterItem;
import com.ktcd.malc.kt_ma_lc.baiduloc.clusterutil.clustering.ClusterManager;
import com.ktcd.malc.kt_ma_lc.bean.MapResourcePoitinfo;
import com.ktcd.malc.kt_ma_lc.fragment.ResourcesMapDgPointFregment;
import com.ktcd.malc.kt_ma_lc.fragment.ResourcesMapDgPointFregment1;
import com.ktcd.malc.kt_ma_lc.fragment.ResourcesMapDgPointFregment2;
import com.ktcd.malc.kt_ma_lc.model.ItemMapResoureSelectType;
import com.ktcd.malc.utilslibrary.net.KtkjError;
import com.ktcd.malc.utilslibrary.net.MyRetrofit;
import com.ktcd.malc.utilslibrary.net.ResponseCallBack;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;

import java.io.Serializable;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

public class NewResourcesMapActivity extends ToolbarActivity implements SensorEventListener, BaiduMap.OnMapLoadedCallback {

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
        textData();
    }

    private void initView() {
        setUpToolbar(mToolbar);
        setNavigationIcon(R.mipmap.home_return);
        setTitle("灾害点资源地图");
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
//        // 定义点聚合管理类ClusterManager
//        mClusterManager = new ClusterManager<MyItemMarker>(this, mBaiduMap);
//        // 设置地图监听，当地图状态发生改变时，进行点聚合运算
//        mBaiduMap.setOnMapStatusChangeListener(mClusterManager);
//        // 设置maker点击时的响应
//        mBaiduMap.setOnMarkerClickListener(mClusterManager);
//
//        mClusterManager.setOnClusterClickListe0ner(new ClusterManager.OnClusterClickListener<MyItemMarker>() {
//            @Override
//            public boolean onClusterClick(Cluster<MyItemMarker> cluster) {
//                return false;
//            }
//        });
//        mClusterManager.setOnClusterItemClickListener(new ClusterManager.OnClusterItemClickListener<MyItemMarker>() {
//            @Override
//            public boolean onClusterItemClick(MyItemMarker item) {
//                return false;
//            }
//        });

        mBaiduMap.setOnMapStatusChangeListener(new BaiduMap.OnMapStatusChangeListener() {
            @Override
            public void onMapStatusChangeStart(MapStatus mapStatus) {
            }

            @Override
            public void onMapStatusChange(MapStatus mapStatus) {
            }

            @Override
            public void onMapStatusChangeFinish(MapStatus mapStatus) {
                try {
                    Thread.sleep(1000);
                    if (mSelectDg != null || mSelectDp != null) {
                        getDataRequest(mSelectDp, mSelectDg);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Log.e("xb", "Latlng_Finish" + mapStatus.toString());
            }
        });
        mBaiduMap.setMaxAndMinZoomLevel(21, 11);
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
                ToastUtils.showMessage(mContext, marker.getExtraInfo().getString("xb"));
                ShowInfoWind(marker);
                return true;
            }
        });
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

        mDgPointInfo = null;
        mPersonPointInfo = null;
        mPlacePointInfo = null;

        mPalcMarkerList = null;
        mDgMarkerList = null;
        mPersonMarkerList = null;


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
                startActivityForResult(ResourcesMapSettingActivity.class, 1000);
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
                LatLng ll = new LatLng(24.629394,
                        116.170636);
                mbuilder.target(ll).zoom(13.0f);
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(mbuilder.build()));
            }
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }
    }


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (resultCode == RESULT_OK) {
//            if (requestCode == 1000) {
//                HashMap<Integer, ArrayList<ItemMapResoureSelectType>> selectData = (HashMap<Integer, ArrayList<ItemMapResoureSelectType>>) data.getExtras().getSerializable("DATA");
//                if (selectData.size() > 0) {
//                    Iterator iter = selectData.entrySet().iterator();
//                    while (iter.hasNext()) {
//                        Map.Entry entry = (Map.Entry) iter.next();
//                        int key = (int) entry.getKey();
//                        int type[] = new int[10];
//                        ArrayList<ItemMapResoureSelectType> item = (ArrayList<ItemMapResoureSelectType>) entry.getValue();
//                        for (int i = 0; i < item.size(); i++) {
//                            type[i] = item.get(i).Type;
//                        }
//                        boolean typeShow;
//                        if (key == 1) {
//                            typeShow = mIsCanShowDgMark;
//                        } else if (key == 2) {
//                            typeShow = mIsCanShowPlaceMark;
//                        } else {
//                            typeShow = mIsCanShowPersonMark;
//                        }
//                        ReShowOrHiddeMark(key, typeShow, type);
//                    }
//                }
//            }
//        }
//    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == 1000) {
                HashMap<Integer, ArrayList<ItemMapResoureSelectType>> selectData = (HashMap<Integer, ArrayList<ItemMapResoureSelectType>>) data.getExtras().getSerializable("DATA");
                if (selectData.size() > 0) {
                    mBaiduMap.clear();
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
        for (int i = 0; i < dpList.size(); i++) {
            dpcode.add(dpList.get(i).dictCode);
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
//TODO  mdate.put("departmentCodeList", new Gson().toJson(dpcode));
        mdate.put("departmentCodeList", "department_code");
//TODO  mdate.put("subclassList", new Gson().toJson(dgcode));
        mdate.put("subclassList", dgcodetest.substring(0, dgcodetest.length() - 1));
        mdate.put("polygonJsonStr", new Gson().toJson(json));
        MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://192.168.0.200:5555/pointCache/point/getCountInformationPointByParam", mdate, new ResponseCallBack<MapResourcePoitinfo>() {
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
                List<MapResourcePoitinfo> allDataInfo = (ArrayList<MapResourcePoitinfo>) result;
                splitDataofAllData(allDataInfo);
                Log.e("xb", "allnum:" + allDataInfo.size());
            }
        });

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
            item.typeData.name = item.getCategory() + "_" + item.getSubclass();
            if (item.getCategory().equals("risk_point")) { /**危险点**/
                //  1  subside 崩塌
                //  2  collapse 塌陷
                //  3  landslide 滑坡
                //  4  smallRiver 中小河流
                //  5  floods 山洪沟
                //  6 debrisFlow 泥石流
                item.typeData.PointType = 1;
                if (item.getSubclass().equals("subside")) {
                    item.typeData.subType = 1;
                    item.typeData.ImageType = R.mipmap.map_icon_danger_taxian;
                } else if (item.getSubclass().equals("collapse")) {
                    item.typeData.subType = 2;
                    item.typeData.ImageType = R.mipmap.map_icon_danger_bengta;
                } else if (item.getSubclass().equals("landslide")) {
                    item.typeData.subType = 3;
                    item.typeData.ImageType = R.mipmap.map_icon_danger_huapo;
                } else if (item.getSubclass().equals("smallRiver")) {
                    item.typeData.subType = 4;
                    item.typeData.ImageType = R.mipmap.map_icon_danger_smallriver;
                } else if (item.getSubclass().equals("flashFlood")) {
                    item.typeData.subType = 5;
                    item.typeData.ImageType = R.mipmap.map_icon_danger_floods;
                } else if (item.getSubclass().equals("debrisFlow")) {
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
        if (typeData.ImageType != 0) {

            MarkerOptions overlayOptions = new MarkerOptions()
                    .position(typeData.latLng)
                    .icon(mBitmapDescriptors[typeData.subType]);
            Marker marker = (Marker) mBaiduMap.addOverlay(overlayOptions);
            SoftReference<Marker> sMarker = new SoftReference<Marker>(marker);
            Bundle bundle = new Bundle();
            bundle.putString("xb", "" + typeData.subType);
            sMarker.get().setExtraInfo(bundle);
            if (typeData.PointType == 1) {
                mDgMarkerList.add(sMarker.get());
            } else if (typeData.PointType == 2) {
                mPalcMarkerList.add(sMarker.get());
            } else if (typeData.PointType == 3) {
                mPersonMarkerList.add(sMarker.get());
            }
//            pic.recycle();
        } else {
            Log.e("xb", "typeData:" + typeData.PointType);
            Log.e("xb", "name:" + typeData.name);
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


//    /**
//     * 是否显示marker
//     *
//     * @param Type    大类
//     * @param isShow  是否显示
//     * @param subType 小类筛选
//     */
//    private void ReShowOrHiddeMark(int Type, final boolean isShow, final int subType[]) {
//
//        String s = "";
//        for (int i = 0; i < subType.length; i++) {
//            s = s + subType[i] + ",";
//        }
//
//        if (Type == 1) {
//            if (isShow) {
//                imgDgpoint.setImageResource(R.mipmap.map_btn_danger);
//
//                if (subType.length == 0) {
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            synchronized (mDgMarkerList) {
//                                for (Marker item : mDgMarkerList) {
//                                    item.setVisible(isShow);
//                                }
//                            }
//                        }
//                    }).start();
//                } else {
//                    final String finalS = s;
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            synchronized (mDgMarkerList) {
//                                for (Marker item : mDgMarkerList) {
//                                    if (finalS.contains((String) item.getExtraInfo().get("xb"))) {
//                                        item.setVisible(true);
//                                        Log.e("xb", "xbt:" + (String) item.getExtraInfo().get("xb"));
//                                    } else {
//                                        item.setVisible(false);
//                                        Log.e("xb", "xbf:" + (String) item.getExtraInfo().get("xb"));
//                                    }
//                                }
//                            }
//                        }
//                    }).start();
//                }
//                //TODO 可以继续添加子类操作
//            } else {
//                imgDgpoint.setImageResource(R.mipmap.map_btn_gray_danger);
//                if (subType.length == 0) {
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            synchronized (mDgMarkerList) {
//                                for (Marker item : mDgMarkerList) {
//                                    item.setVisible(isShow);
//                                }
//                            }
//                        }
//                    }).start();
//                }
//                //TODO 可以继续添加子类操作
//                else {
//                    final String finalS = s;
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            synchronized (mDgMarkerList) {
//                                for (Marker item : mDgMarkerList) {
//                                    if (finalS.contains((String) item.getExtraInfo().get("xb"))) {
//                                        item.setVisible(true);
//                                    } else {
//                                        item.setVisible(false);
//                                    }
//                                }
//                            }
//                        }
//                    }).start();
//                }
//            }
//        } else if (Type == 2) {
//            if (isShow) {
//                imgPlace.setImageResource(R.mipmap.map_btn_place);
//                if (subType.length == 0) {
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            synchronized (mPalcMarkerList) {
//                                for (Marker item : mPalcMarkerList) {
//                                    item.setVisible(isShow);
//                                }
//                            }
//                        }
//                    }).start();
//                    //TODO 可以继续添加子类操作
//                } else {
//                    final String finalS = s;
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            synchronized (mPalcMarkerList) {
//                                for (Marker item : mPalcMarkerList) {
//                                    if (finalS.contains((String) item.getExtraInfo().get("xb"))) {
//                                        item.setVisible(true);
//                                    } else {
//                                        item.setVisible(false);
//                                    }
//                                }
//                            }
//                        }
//                    }).start();
//                }
//            } else {
//                imgPlace.setImageResource(R.mipmap.map_btn_gray_place);
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        synchronized (mPalcMarkerList) {
//                            for (Marker item : mPalcMarkerList) {
//                                item.setVisible(isShow);
//                            }
//                        }
//                    }
//                }).start();
//            }
//        } else if (Type == 3) {
//            if (isShow) {
//                imgPerson.setImageResource(R.mipmap.map_btn_man);
//                if (subType.length == 0) {
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            synchronized (mPersonMarkerList) {
//                                for (Marker item : mPersonMarkerList) {
//                                    item.setVisible(isShow);
//                                }
//                            }
//                        }
//                    }).start();
//
//                } else {
//                    final String finalS = s;
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                            synchronized (mPersonMarkerList) {
//                                for (Marker item : mPersonMarkerList) {
//                                    if (finalS.contains((String) item.getExtraInfo().get("xb"))) {
//                                        item.setVisible(true);
//                                    } else {
//                                        item.setVisible(false);
//                                    }
//                                }
//                            }
//                        }
//                    }).start();
//                }
//                //TODO 可以继续添加子类操作
//            } else {
//                imgPerson.setImageResource(R.mipmap.map_btn_gray_man);
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        synchronized (mPersonMarkerList) {
//                            for (Marker item : mPersonMarkerList) {
//                                item.setVisible(isShow);
//                            }
//                        }
//                    }
//                }).start();
//            }
//        }
//    }


    @Override
    public void onMapLoaded() {
        // TODO Auto-generated method stub
        ms = new MapStatus.Builder().zoom(16).build();
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
    private void ShowInfoWind(final Marker marker) {
        Button button = new Button(getApplicationContext());
        button.setBackgroundResource(R.drawable.d_dahaqi);
        InfoWindow.OnInfoWindowClickListener listener = null;
        button.setText("更改位置");
        button.setTextColor(Color.BLACK);
        button.setWidth(300);
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
        mInfoWindow = new InfoWindow(BitmapDescriptorFactory.fromView(button), ll, -47, listener);
        mBaiduMap.showInfoWindow(mInfoWindow);
    }


    private void  textData(){
        Map<String,String> mapData=new HashMap<>();
        mapData.put("str","1AF029D2D87648C98B534BE87D022441");
        MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://192.168.0.200:5555/geologyHazard/debrisflows/getDebrisFlow", mapData, new ResponseCallBack<Serializable>() {
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
}