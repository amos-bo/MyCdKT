package com.ktcd.malc.kt_ma_lc.activity;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;

import com.ktcd.malc.baselayer.activity.ToolbarActivity;
import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
import com.ktcd.malc.baselayer.view.DividerItemDecoration;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.adapter.EventTypesAdapter;
import com.ktcd.malc.kt_ma_lc.applicatoin.ApiPathUrl;
import com.ktcd.malc.kt_ma_lc.bean.LoginCookei;
import com.ktcd.malc.kt_ma_lc.model.ItemEventInfoResponse;
import com.ktcd.malc.utilslibrary.net.KtkjError;
import com.ktcd.malc.utilslibrary.net.MyRetrofit;
import com.ktcd.malc.utilslibrary.net.ResponseCallBack;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;

public class EventListActivity extends ToolbarActivity implements SimpleRecyclerAdapter.OnItemClickListener {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.root)
    RelativeLayout mRoot;
    @BindView(R.id.refreshlayout)
    TwinklingRefreshLayout refreshlayout;
    private EventTypesAdapter mEventTypesAdapter;

    private int PAGE = 1;
    private int PAGE_SIZE = 10;

    private List<ItemEventInfoResponse.RowsBean> mRowsBeanList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        ButterKnife.bind(this);
//TODO        needNetErrorView(refreshlayout);
        initView();
        initData();
//        textLog();

    }

    private void initView() {
        setTitle("事件列表");
        recyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerview.addItemDecoration(new DividerItemDecoration(
                mContext, DividerItemDecoration.HORIZONTAL_LIST, 1,
                ContextCompat.getColor(mContext, R.color.assist_3)));
        mEventTypesAdapter = new EventTypesAdapter(mContext);
        mEventTypesAdapter.setOnItemClickListener(this);

        ProgressLayout header = new ProgressLayout(mContext);
        header.setColorSchemeColors(new int[]{mContext.getResources().getColor(R.color.colorPrimary)});
        refreshlayout.setHeaderView(header);
        refreshlayout.setBottomView(new LoadingView(mContext));
        refreshlayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                PAGE = 1;
                getData(PAGE, PAGE_SIZE, false);
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                getData(PAGE, PAGE_SIZE, true);
            }
        });
    }

    private void initData() {
        mRowsBeanList = new ArrayList<>();
        refreshlayout.startRefresh();
    }

    private void getData(int page, int rows, final boolean isLoadMore) {
        Map<String, String> mapKey = new HashMap<>();
        mapKey.put("page", "" + page);
        mapKey.put("rows", "" + rows);
        MyRetrofit.StartQueryNet(mContext, true, ApiPathUrl.ACTION_GETEVENTLIST, mapKey, new ResponseCallBack<ItemEventInfoResponse>() {
            @Override
            protected void onLoad(Disposable d) {
            }

            @Override
            protected void onError(KtkjError error) {
                ToastUtils.showMessage(mContext, error.msg);
                if (isLoadMore) {
                    refreshlayout.finishLoadmore();
                } else {
                    refreshlayout.finishRefreshing();
                }
            }

            @Override
            protected void onSuccess(ItemEventInfoResponse result) {
                if (!isLoadMore) {
                    PAGE++;
                    mRowsBeanList.clear();
                    mRowsBeanList.addAll(result.getRows());
                    if (result.getRows().size() > 0) {
                        refreshlayout.setEnableLoadmore(true);
                        mEventTypesAdapter.setList(mRowsBeanList);
                        recyclerview.setAdapter(mEventTypesAdapter);
                        recyclerview.setVisibility(View.VISIBLE);
                    } else {
                        recyclerview.setVisibility(View.GONE);
                        ToastUtils.showMessage(mContext, "暂无相关数据");
                    }
                    refreshlayout.finishRefreshing();
//                    ToastUtils.showMessage(mContext, "刷新成功");
                } else {
                    PAGE++;
                    if (result.getRows().size() > 0 && result.getRows().size() <= PAGE_SIZE) {
                        mRowsBeanList.addAll(result.getRows());
                        mEventTypesAdapter.setList(mRowsBeanList);
                        recyclerview.setAdapter(mEventTypesAdapter);
                    } else {
                        ToastUtils.showMessage(mContext, "无更多数据");
                        refreshlayout.setEnableLoadmore(false);
                    }
                    refreshlayout.finishLoadmore();
                }
            }
        });


    }

    @Override
    public void onItemClick(View view, int position) {
        EventInfoMapActivity.StartEventInfoMapActivity(mContext, mRowsBeanList.get(position));
    }

    @Override
    public void onItemLongClick(View view, int position) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        initData();
    }

    private void textLog(){

        Map<String,String> map=new HashMap<>();
        map.put("username","admin");
        map.put("password","123456");
        MyRetrofit.StartQueryNetByAllPath(mContext,true, "http://192.168.0.200:5555/uaa/login", map, new ResponseCallBack<LoginCookei>() {
            @Override
            protected void onLoad(Disposable d) {
            }

            @Override
            protected void onError(KtkjError error) {

            }

            @Override
            protected void onSuccess(LoginCookei result) {
            }
        });

    }
}
