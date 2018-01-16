package com.ktcd.malc.kt_ma_lc.activity;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.ktcd.malc.baselayer.activity.ToolbarActivity;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.adapter.NoticeAdapter;
import com.ktcd.malc.kt_ma_lc.applicatoin.ApiPathUrl;
import com.ktcd.malc.kt_ma_lc.baiduloc.LocationUtils;
import com.ktcd.malc.kt_ma_lc.bean.NoticeBean;
import com.ktcd.malc.utilslibrary.net.KtkjError;
import com.ktcd.malc.utilslibrary.net.MyRetrofit;
import com.ktcd.malc.utilslibrary.net.ResponseCallBack;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/7/6.
 */

public class NoticeActivity extends ToolbarActivity {
    @BindView(R.id.notice_recycler)
    RecyclerView noticeRecycler;
    @BindView(R.id.notice_refreshlayout)
    TwinklingRefreshLayout noticeRefreshlayout;
    private NoticeAdapter noticeAdapter;
    private List<NoticeBean.DataBean.RowsBean> rowsBeen = new ArrayList<>();
    private int PAGE = 1;
    private int PAGE_SIZE = 10;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notice);
        ButterKnife.bind(this);

        initView();
//          getBestLocation();
//        getGPSLocation();
//          getNetworkLocation();
    }

    private void initView() {
        setToolbarColor(ContextCompat.getColor(this, R.color.white));
        setTitle("公告通知");
        setTitleColorRes(R.color.black);
        setTitleTextSize(18);
        ProgressLayout header = new ProgressLayout(this);
        header.setColorSchemeColors(ContextCompat.getColor(this, R.color.blue));
        noticeRefreshlayout.setHeaderView(header);
        noticeRefreshlayout.setBottomView(new LoadingView(this));
        noticeRefreshlayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                PAGE = 1;
                initViewDate(PAGE, PAGE_SIZE);
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                initViewDate(PAGE, PAGE_SIZE);
            }
        });

        noticeRecycler.setLayoutManager(new LinearLayoutManager(this));
        noticeAdapter = new NoticeAdapter(this);
        noticeRecycler.setAdapter(noticeAdapter);
        noticeAdapter.setData(rowsBeen);
        noticeRefreshlayout.setEnableLoadmore(true);
        noticeRefreshlayout.startRefresh();
    }

    private void initViewDate(int page, final int rows) {
        Map<String, String> map = new HashMap<>();
        map.put("page", "" + page);
        map.put("rows", "" + rows);
        MyRetrofit.StartQueryNet(mContext, true, ApiPathUrl.ACTION_NOTICE, map, new ResponseCallBack<NoticeBean.DataBean>() {
            @Override
            protected void onLoad(Disposable d) {

            }

            @Override
            protected void onError(KtkjError error) {
                ToastUtils.showMessage(mContext, error.msg);
            }

            @Override
            protected void onSuccess(NoticeBean.DataBean result) {
                if (result != null && result.getRows().size() > 0) {
                    if (PAGE == 1) {
                        rowsBeen.clear();
                    }
                    rowsBeen.addAll(result.getRows());
                    noticeAdapter.notifyDataSetChanged();
                    PAGE++;
                }else {
                    if (PAGE==1) {
                        ToastUtils.showMessage(mContext, "暂无相关数据");
                    }else {
                        ToastUtils.showMessage(mContext,"无更多数据");
                    }
                }
                noticeRefreshlayout.finishRefreshing();
                noticeRefreshlayout.finishLoadmore();
            }
        });
    }

    private void getBestLocation() {
        Criteria c = new Criteria();//Criteria类是设置定位的标准信息（系统会根据你的要求，匹配最适合你的定位供应商），一个定位的辅助信息的类
        c.setPowerRequirement(Criteria.POWER_LOW);//设置低耗电
        c.setAltitudeRequired(true);//设置需要海拔
        c.setBearingAccuracy(Criteria.ACCURACY_COARSE);//设置COARSE精度标准
        c.setAccuracy(Criteria.ACCURACY_LOW);//设置低精度
        //... Criteria 还有其他属性，就不一一介绍了
        Location best = LocationUtils.getBestLocation(this, c);
        if (best == null) {
            //设置定位监听，因为GPS定位，第一次进来可能获取不到，通过设置监听，可以在有效的时间范围内获取定位信息
            LocationUtils.addLocationListener(mContext, LocationManager.GPS_PROVIDER, new LocationUtils.ILocationListener() {
                @Override
                public void onSuccessLocation(Location location) {
                    if (location != null) {
                        Log.e("xb", "lat==" + location.getLatitude() + "     lng==" + location.getLongitude());
                    } else {
                        Log.e("xb", "location is null");
                    }
                }
            });
        } else {
            Toast.makeText(this, "best location: lat==" + best.getLatitude() + " lng==" + best.getLongitude(), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 通过GPS获取定位信息
     */
    public void getGPSLocation() {
        Location gps = LocationUtils.getGPSLocation(this);
        if (gps == null) {
            //设置定位监听，因为GPS定位，第一次进来可能获取不到，通过设置监听，可以在有效的时间范围内获取定位信息
            LocationUtils.addLocationListener(mContext, LocationManager.GPS_PROVIDER, new LocationUtils.ILocationListener() {
                @Override
                public void onSuccessLocation(Location location) {
                    if (location != null) {
                        Log.e("xb", "lat==" + location.getLatitude() + "     lng==" + location.getLongitude());
                    } else {
                        Log.e("xb", "location is null");
                    }
                }
            });
        } else {
            Toast.makeText(this, "gps location: lat==" + gps.getLatitude() + "  lng==" + gps.getLongitude(), Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * 通过网络等获取定位信息
     */
    private void getNetworkLocation() {
        Location net = LocationUtils.getNetWorkLocation(this);
        if (net == null) {
            Toast.makeText(this, "net location is null", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "network location: lat==" + net.getLatitude() + "  lng==" + net.getLongitude(), Toast.LENGTH_SHORT).show();
        }
        LocationUtils.addLocationListener(mContext, LocationManager.NETWORK_PROVIDER, new LocationUtils.ILocationListener() {
            @Override
            public void onSuccessLocation(Location location) {
                if (location != null) {
                    Log.e("xb", "lat==" + location.getLatitude() + "     lng==" + location.getLongitude());
                } else {
                    Log.e("xb", "location is null");
                }
            }
        });
    }
}
