package com.ktcd.malc.kt_ma_lc.activity;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import com.ktcd.malc.baselayer.activity.ToolbarActivity;
import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
import com.ktcd.malc.baselayer.view.DividerItemDecoration;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.adapter.InstructTypeAdapter;
import com.ktcd.malc.kt_ma_lc.applicatoin.ApiPathUrl;
import com.ktcd.malc.kt_ma_lc.model.ItemInstructTypeInfo;
import com.ktcd.malc.utilslibrary.net.KtkjError;
import com.ktcd.malc.utilslibrary.net.MyRetrofit;
import com.ktcd.malc.utilslibrary.net.ResponseCallBack;
import com.ktcd.malc.utilslibrary.tools.ConfigUtils;
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
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

public class InstructManagementActivity extends ToolbarActivity {

    @BindView(R.id.toolbar_divider)
    View toolbarDivider;
    @BindView(R.id.toolbar_btn_container)
    LinearLayout toolbarBtnContainer;
    @BindView(R.id.toolbar_title1)
    RadioButton toolbarTitle1;
    @BindView(R.id.toolbar_title2)
    RadioButton toolbarTitle2;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.appbarLayout)
    AppBarLayout appbarLayout;
    @BindView(R.id.img_seach)
    ImageView imgSeach;
    @BindView(R.id.re_search)
    RelativeLayout reSearch;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.bt_putidea)
    Button btPutidea;
    @BindView(R.id.instrut_manager_refreshlayout)
    TwinklingRefreshLayout instrutManagerRefreshlayout;

    private InstructTypeAdapter mInstructTypeAdapter;
    private List<ItemInstructTypeInfo.DataBean.RowsBean> rowsBeanReceive = new ArrayList<>();
    private List<ItemInstructTypeInfo.DataBean.RowsBean> rowsBeanIssue = new ArrayList<>();
    private int PAGE = 1;
    private int PAGE_SIZE = 10;
    private int USER_ID;
    private int onResumeID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruct_management);
        ButterKnife.bind(this);
        USER_ID = ConfigUtils.getUserID(this);
        initViews();
    }


    private void initViews() {
        toolbar.setNavigationIcon(R.mipmap.home_return);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ProgressLayout header = new ProgressLayout(this);
        header.setColorSchemeColors(ContextCompat.getColor(this, R.color.blue));
        instrutManagerRefreshlayout.setHeaderView(header);
        instrutManagerRefreshlayout.setBottomView(new LoadingView(this));
        instrutManagerRefreshlayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(TwinklingRefreshLayout refreshLayout) {
                super.onRefresh(refreshLayout);
                PAGE = 1;
                getDataReceive(USER_ID, PAGE, PAGE_SIZE);
            }

            @Override
            public void onLoadMore(TwinklingRefreshLayout refreshLayout) {
                super.onLoadMore(refreshLayout);
                getDataReceive(USER_ID, PAGE, PAGE_SIZE);
            }
        });
        recyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerview.addItemDecoration(new DividerItemDecoration(
                mContext, DividerItemDecoration.HORIZONTAL_LIST, 2,
                ContextCompat.getColor(mContext, R.color.assist_3)));

        mInstructTypeAdapter = new InstructTypeAdapter(mContext);
        recyclerview.setAdapter(mInstructTypeAdapter);
        instrutManagerRefreshlayout.setEnableLoadmore(true);
        instrutManagerRefreshlayout.startRefresh();


        mInstructTypeAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("rows", rowsBeanReceive.get(position));
                startActivity(OrderDetailsActivity.class, bundle);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    private void getDataReceive(int userid, int page, int rows) {
        mInstructTypeAdapter.setList(rowsBeanReceive);
        Map<String, String> map = new HashMap<>();
        map.put("userid", "" + userid);
        map.put("page", "" + page);
        map.put("rows", "" + rows);
        MyRetrofit.StartQueryNet(mContext, true, ApiPathUrl.ACTION_BYUSER, map, new ResponseCallBack<ItemInstructTypeInfo.DataBean>() {
            @Override
            protected void onLoad(Disposable d) {

            }

            @Override
            protected void onError(KtkjError error) {
                ToastUtils.showMessage(mContext, error.msg);
            }

            @Override
            protected void onSuccess(ItemInstructTypeInfo.DataBean result) {
                if (result != null && result.getRows().size() > 0) {
                    if (PAGE == 1) {
                        rowsBeanReceive.clear();
                    }
                    rowsBeanReceive.addAll(result.getRows());
                    mInstructTypeAdapter.notifyDataSetChanged();
                    PAGE++;
                } else {
                    if (PAGE == 1) {
                        ToastUtils.showMessage(mContext, "暂无相关数据");
                    } else {
                        ToastUtils.showMessage(mContext, "无更多数据");
                    }
                }
                instrutManagerRefreshlayout.finishRefreshing();
                instrutManagerRefreshlayout.finishLoadmore();
            }
        });
    }


    private void getDataIssue() {
        mInstructTypeAdapter.setList(rowsBeanIssue);
        mInstructTypeAdapter.notifyDataSetChanged();
    }

    @Override
    protected boolean needToolbar() {
        return false;
    }


    @OnClick({R.id.toolbar_title1, R.id.toolbar_title2, R.id.re_search, R.id.bt_putidea})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.toolbar_title1:
                getDataIssue();
                ToastUtils.showMessage(mContext, "暂无相关数据");
                break;
            case R.id.toolbar_title2:
                mInstructTypeAdapter.setList(rowsBeanReceive);
                mInstructTypeAdapter.notifyDataSetChanged();
                break;
            case R.id.re_search:
                break;
            case R.id.bt_putidea:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        onResumeID++;

        if (onResumeID > 1) {
            PAGE = 1;
            getDataReceive(USER_ID, PAGE, PAGE_SIZE);
        }
    }

}
