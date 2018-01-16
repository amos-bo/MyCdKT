package com.ktcd.malc.kt_ma_lc.activity;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
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
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.ktcd.malc.baselayer.activity.ToolbarActivity;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.applicatoin.ApiPathUrl;
import com.ktcd.malc.kt_ma_lc.dialog.PopWindowMapBottom;
import com.ktcd.malc.kt_ma_lc.model.AttachmentVoInfo;
import com.ktcd.malc.kt_ma_lc.model.ItemAddressInfo;
import com.ktcd.malc.kt_ma_lc.model.ItemEventInfoResponse;
import com.ktcd.malc.kt_ma_lc.model.ItemFileTypeInfo;
import com.ktcd.malc.utilslibrary.net.MyRetrofit;
import com.ktcd.malc.utilslibrary.tools.ConfigUtils;
import com.ktcd.malc.utilslibrary.tools.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class EventInfoMapActivity extends ToolbarActivity implements SensorEventListener, BaiduMap.OnMarkerClickListener {

    @BindView(R.id.lin_progression)
    LinearLayout linProgression;
    @BindView(R.id.lin_report)
    LinearLayout linReport;
    @BindView(R.id.lin_video)
    LinearLayout linVideo;
    @BindView(R.id.lin_zhiling)
    LinearLayout linZhiling;
    @BindView(R.id.bmapView)
    MapView bmapView;
    @BindView(R.id.root)
    FrameLayout root;
    private MapView mMapView = null;
    private BaiduMap mBaiduMap = null;
    private MapStatus.Builder mbuilder = null;
    private UiSettings mUiSettings = null;

    // 定位相关
    LocationClient mLocClient;
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

    private ItemEventInfoResponse.RowsBean mRowBean;

    private ItemAddressInfo mItemAddressInfo;

    private List<AttachmentVoInfo> mAttachmentVoInfoList;

    private Map<String, List<AttachmentVoInfo>> mAttachmentVoInfoMap;


    public static void StartEventInfoMapActivity(Context context, ItemEventInfoResponse.RowsBean rowsBean) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("DATA_INFO", rowsBean);
        Intent intent = new Intent(context, EventInfoMapActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_info_map);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        setTitle("事件");
        setNavigationIcon(R.mipmap.home_return);
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
        option.setIsNeedAddress(true);
        option.setOpenGps(true); // 打开gps
        option.setCoorType("bd09ll"); // 设置坐标类型
        option.setScanSpan(30000);
        mLocClient.setLocOption(option);
        mLocClient.start();

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);//获取传感器管理服务
        mCurrentMode = MyLocationConfiguration.LocationMode.NORMAL;
        mBaiduMap.setOnMarkerClickListener(this);

    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void initData() {
        mRowBean = (ItemEventInfoResponse.RowsBean) getIntent().getExtras().getSerializable("DATA_INFO");
        mItemAddressInfo = new ItemAddressInfo();
        mAttachmentVoInfoMap = new HashMap<>();
        initRSMark(new LatLng(mRowBean.getEiLatitude(), mRowBean.getEiLongitude()));
        for (ItemEventInfoResponse.RowsBean.EventDetailInfoListBean item :
                mRowBean.getEventDetailInfoList()) {
            mAttachmentVoInfoMap.put(item.getUpdateTime(), MyRetrofit.convertEntities(item.getEdiContent(), AttachmentVoInfo.class));
        }
        initMapIcon();
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

    /**
     * @param marker 点击回调
     * @return
     */
    @Override
    public boolean onMarkerClick(Marker marker) {
        if (marker.getExtraInfo()!=null) {
            ItemEventInfoResponse.RowsBean.EventDetailInfoListBean item = (ItemEventInfoResponse.RowsBean.EventDetailInfoListBean) marker.getExtraInfo().getSerializable("xb");
            if (item != null) {
                List<ItemFileTypeInfo> itemFileTypeInfoList = new ArrayList<>();
                List<AttachmentVoInfo> attachmentVoInfoList = mAttachmentVoInfoMap.get(item.getUpdateTime());
                for (AttachmentVoInfo info : attachmentVoInfoList) {
                    ItemFileTypeInfo file = new ItemFileTypeInfo();
                    if (info.getType().equals("jpg") || info.getType().equals("png")) {
                        file.Type = 1;
                        String ip[]=ConfigUtils.getAppDataIP(mContext).split(",");
                        String path = ip[0]+":"+ip[2]+"/service/KT_S_Attachment/" + info.getPath();
                        path = path.replaceAll("\\\\", "/");
                        file.pathUrl = path;
                    } else if (info.getType().equals("mp4")) {
                        String ip[]=ConfigUtils.getAppDataIP(mContext).split(",");
                        String path = ip[0]+":"+ip[2]+"/service/KT_S_Attachment/" + info.getPath();
                        path = path.replaceAll("\\\\", "/");
                        file.pathUrl = path;
                        file.Type = 2;
                    } else {
                        String ip[]=ConfigUtils.getAppDataIP(mContext).split(",");
                        String path = ip[0]+":"+ip[2]+"/service/KT_S_Attachment/" + info.getPath();
                        path = path.replaceAll("\\\\", "/");
                        file.pathUrl = path;
                        file.Type = 3;
                    }
                    itemFileTypeInfoList.add(file);
                }
                PopWindowMapBottom.Show(EventInfoMapActivity.this, root, item, itemFileTypeInfoList, new PopWindowMapBottom.OnItemClickListener() {
                    @Override
                    public void ItemClick(int position) {

                    }
                });
            }
        }
        return true;
    }

    @OnClick({R.id.lin_progression, R.id.lin_report, R.id.lin_video, R.id.lin_zhiling})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lin_progression:
                EventProgressListActivity.StartEventProgressListActivity(mContext, (ArrayList<ItemEventInfoResponse.RowsBean.EventDetailInfoListBean>) mRowBean.getEventDetailInfoList());
                break;
            case R.id.lin_report:
                EventReportActivity.StartEventReportActivity(mContext, mRowBean, mItemAddressInfo);
                break;
            case R.id.lin_video:
                break;
            case R.id.lin_zhiling:
                startActivity(InstructManagementActivity.class);
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
//                    .direction(mCurrentDirection).latitude(location.getLatitude())
//                    .longitude(location.getLongitude()).build();
                    .direction(mCurrentDirection).latitude(mCurrentLat)
                    .longitude(mCurrentLon).build();
            mBaiduMap.setMyLocationData(locData);
            if (isFirstLoc) {
                isFirstLoc = false;
                LatLng ll = new LatLng(location.getLatitude(),
                        location.getLongitude());
                mbuilder.target(ll).zoom(11.0f);
                mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(mbuilder.build()));
            }
            mItemAddressInfo.LONG = mCurrentLon;
            mItemAddressInfo.LAT = mCurrentLat;
            mItemAddressInfo.Address = location.getAddrStr();
        }

        @Override
        public void onConnectHotSpotMessage(String s, int i) {

        }

        public void onReceivePoi(BDLocation poiLocation) {
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void initMapIcon() {
        int i = 0;
        for (ItemEventInfoResponse.RowsBean.EventDetailInfoListBean item : mRowBean.getEventDetailInfoList()) {
            LatLng lat = new LatLng(Double.parseDouble(item.getCpLattitude()), Double.parseDouble(item.getEdiLongtitude()));
            i++;
            List<AttachmentVoInfo> attachmentVoInfoList = mAttachmentVoInfoMap.get(item.getUpdateTime());
            String url ="";
            if (attachmentVoInfoList.size() > 0) {
                for (AttachmentVoInfo attachmentvoinfo : attachmentVoInfoList) {
                    if (attachmentvoinfo.getType().equals("jpg")||attachmentvoinfo.getType().equals("png")) {
                        url = attachmentvoinfo.getPath();
                        break;
                    }
                }

                    initBitmap(url, lat, item);

            } else {
                initBitmap(url, lat, item);
            }
        }
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void initBitmap(String url, final LatLng ll, final ItemEventInfoResponse.RowsBean.EventDetailInfoListBean item) {

        if (!StringUtils.isEmpty(url)) {
            String ip[]=ConfigUtils.getAppDataIP(mContext).split(",");
            String path = ip[0]+":"+ip[2]+"/service/KT_S_Attachment/" + url;
            path = path.replaceAll("\\\\", "/");
            Glide.with(mContext).load(path).asBitmap().transform(new GlideCircleTransform(mContext))
                    .into(new SimpleTarget<Bitmap>() {
                        @Override
                        public void onLoadFailed(Exception e, Drawable errorDrawable) {
                            super.onLoadFailed(e, errorDrawable);
                            FrameLayout RootView = (FrameLayout) LayoutInflater.from(mContext).inflate(R.layout.item_map_view, null);
                            ImageView imageView = (ImageView) RootView.findViewById(R.id.img_view);
                            imageView.setImageResource(R.mipmap.map_icon_live_white);
                            RootView.setBackground(null);
                            BitmapDescriptor pic = BitmapDescriptorFactory.fromView(RootView);
                            MarkerOptions overlayOptions = new MarkerOptions()
                                    .position(ll)
                                    .icon(pic);
                            Marker marker = (Marker) mBaiduMap.addOverlay(overlayOptions);
                            Bundle bundle = new Bundle();
                            bundle.putSerializable("xb", item);
                            marker.setExtraInfo(bundle);//marker点击事件监听时，可以获取到此时设置的数据
                        }

                        @Override
                        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
                            if (resource != null) {
//                                final ImageView imageView = new ImageView(mContext);
//                                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//                                imageView.setImageBitmap(resource);
//                                BitmapDescriptor pic = BitmapDescriptorFactory.fromView(imageView);
//                                MarkerOptions overlayOptions = new MarkerOptions()
//                                        .position(ll)
//                                        .icon(pic);
//                                Marker marker = (Marker) mBaiduMap.addOverlay(overlayOptions);
//                                Bundle bundle = new Bundle();
//                                bundle.putSerializable("xb", item);
//                                marker.setExtraInfo(bundle);//marker点击事件监听时，可以获取到此时设置的数据

                                FrameLayout RootView = (FrameLayout) LayoutInflater.from(mContext).inflate(R.layout.item_map_view, null);
                                ImageView imageView = (ImageView) RootView.findViewById(R.id.img_view);
                                imageView.setImageBitmap(resource);
                                BitmapDescriptor pic = BitmapDescriptorFactory.fromView(RootView);
                                MarkerOptions overlayOptions = new MarkerOptions()
                                        .position(ll)
                                        .icon(pic);
                                Marker marker = (Marker) mBaiduMap.addOverlay(overlayOptions);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("xb", item);
                                marker.setExtraInfo(bundle);//marker点击事件监听时，可以获取到此时设置的数据
                            } else {
//                                final ImageView imageView = new ImageView(mContext);
//                                imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
//                                imageView.setImageResource(R.mipmap.map_icon_live_white);
//                                BitmapDescriptor pic = BitmapDescriptorFactory.fromView(imageView);
//                                MarkerOptions overlayOptions = new MarkerOptions()
//                                        .position(ll)
//                                        .icon(pic);
//                                Marker marker = (Marker) mBaiduMap.addOverlay(overlayOptions);
//                                Bundle bundle = new Bundle();
//                                bundle.putSerializable("xb", item);
//                                marker.setExtraInfo(bundle);//marker点击事件监听时，可以获取到此时设置的数据

                                FrameLayout RootView = (FrameLayout) LayoutInflater.from(mContext).inflate(R.layout.item_map_view, null);
                                ;
                                ImageView imageView = (ImageView) RootView.findViewById(R.id.img_view);
                                imageView.setImageResource(R.mipmap.map_icon_live_white);
                                RootView.setBackground(null);
                                BitmapDescriptor pic = BitmapDescriptorFactory.fromView(RootView);
                                MarkerOptions overlayOptions = new MarkerOptions()
                                        .position(ll)
                                        .icon(pic);
                                Marker marker = (Marker) mBaiduMap.addOverlay(overlayOptions);
                                Bundle bundle = new Bundle();
                                bundle.putSerializable("xb", item);
                                marker.setExtraInfo(bundle);//marker点击事件监听时，可以获取到此时设置的数据
                            }
                        }
                    });
        } else {
//            final ImageView imageView = new ImageView(mContext);
//            imageView.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//            imageView.setImageResource(R.mipmap.map_icon_live_white);
//            BitmapDescriptor pic = BitmapDescriptorFactory.fromView(imageView);
//            MarkerOptions overlayOptions = new MarkerOptions()
//                    .position(ll)
//                    .icon(pic);
//            Marker marker = (Marker) mBaiduMap.addOverlay(overlayOptions);
//            Bundle bundle = new Bundle();
//            bundle.putSerializable("xb", item);
//            marker.setExtraInfo(bundle);//marker点击事件监听时，可以获取到此时设置的数据
            FrameLayout RootView = (FrameLayout) LayoutInflater.from(mContext).inflate(R.layout.item_map_view, null);
            ImageView imageView = (ImageView) RootView.findViewById(R.id.img_view);
            imageView.setImageResource(R.mipmap.map_icon_live_white);
            RootView.setBackground(null);
            BitmapDescriptor pic = BitmapDescriptorFactory.fromView(RootView);
            MarkerOptions overlayOptions = new MarkerOptions()
                    .position(ll)
                    .icon(pic);
            Marker marker = (Marker) mBaiduMap.addOverlay(overlayOptions);
            Bundle bundle = new Bundle();
            bundle.putSerializable("xb", item);
            marker.setExtraInfo(bundle);//marker点击事件监听时，可以获取到此时设置的数据
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void initRSMark(LatLng ll) {
        CoordinateConverter converter = new CoordinateConverter();
        converter.from(CoordinateConverter.CoordType.COMMON);
        converter.coord(ll);
        LatLng desLatLng = converter.convert();
        FrameLayout RootView = (FrameLayout) LayoutInflater.from(mContext).inflate(R.layout.item_map_view, null);
        ImageView imageView = (ImageView) RootView.findViewById(R.id.img_view);
        imageView.setImageResource(R.mipmap.map_icon_live_white);
        RootView.setBackground(null);
        imageView.setImageResource(R.mipmap.map_icon_disasterarea);
        BitmapDescriptor pic = BitmapDescriptorFactory.fromView(imageView);
        MarkerOptions overlayOptions = new MarkerOptions()
                .position(desLatLng)
                .icon(pic);
        Marker marker = (Marker) mBaiduMap.addOverlay(overlayOptions);
    }

    public class GlideCircleTransform extends BitmapTransformation {
        public Context context;

        public GlideCircleTransform(Context context) {
            super(context);
            this.context = context;
        }

        @Override
        protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
            return circleCrop(pool, toTransform);
        }

        private Bitmap circleCrop(BitmapPool pool, Bitmap source) {
            if (source == null) return null;
//            int size = Math.min(source.getWidth(), source.getHeight());
            int size = EventInfoMapActivity.this.getResources().getDimensionPixelSize(R.dimen.dp_50);
            int x = (source.getWidth() - size) / 2;
            int y = (source.getHeight() - size) / 2;
            // TODO this could be acquired from the pool too
            Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);
            Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
            if (result == null) {
                result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
            }
            Canvas canvas = new Canvas(result);
            Paint paint = new Paint();
            paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
            paint.setAntiAlias(true);
            float r = size / 2f;
            canvas.drawCircle(r, r, r, paint);

            return result;
        }

        @Override
        public String getId() {
            return getClass().getName();
        }
    }
}
