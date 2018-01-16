package com.ktcd.malc.kt_ma_lc.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ktcd.malc.baselayer.activity.ToolbarActivity;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.adapter.InstructionRecordAdapter;
import com.ktcd.malc.kt_ma_lc.applicatoin.ApiPathUrl;
import com.ktcd.malc.kt_ma_lc.responseparam.InstructionRecordDataList;
import com.ktcd.malc.kt_ma_lc.responseparam.ItemInstrucatoinInfo;
import com.ktcd.malc.utilslibrary.net.KtkjError;
import com.ktcd.malc.utilslibrary.net.MyRetrofit;
import com.ktcd.malc.utilslibrary.net.ResponseCallBack;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;
import com.lcodecore.tkrefreshlayout.RefreshListenerAdapter;
import com.lcodecore.tkrefreshlayout.TwinklingRefreshLayout;
import com.lcodecore.tkrefreshlayout.footer.LoadingView;
import com.lcodecore.tkrefreshlayout.header.progresslayout.ProgressLayout;
import com.ktcd.malc.baselayer.view.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;

public class InstructionRecordActivity extends ToolbarActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.refreshlayout)
    TwinklingRefreshLayout refreshlayout;
    private InstructionRecordAdapter mInstructionRecordAdapter;
    private List<ItemInstrucatoinInfo> mAllItemInstrucatoinInfoList;
    private int PAGE=1;
    private int PAGE_SIZE=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_record);
        ButterKnife.bind(this);
        initView();
        initViewDate();
    }
    private void initView() {

        setTitle("历史指令");
        ProgressLayout header = new ProgressLayout(mContext);
        header.setColorSchemeColors(new int[]{mContext.getResources().getColor(R.color.colorPrimary)});
        refreshlayout.setHeaderView(header);
        refreshlayout.setBottomView(new LoadingView(mContext));
        refreshlayout.setOnRefreshListener(new RefreshListenerAdapter() {
            @Override
            public void onRefresh(final TwinklingRefreshLayout refreshLayout) {
                PAGE=1;
                getData(PAGE,PAGE_SIZE,false);
            }

            @Override
            public void onLoadMore(final TwinklingRefreshLayout refreshLayout) {
                PAGE++;
                getData(PAGE,PAGE_SIZE,true);
            }
        });


    }

    private void initViewDate(){
        mAllItemInstrucatoinInfoList=new ArrayList<>();
        mInstructionRecordAdapter=new InstructionRecordAdapter(mContext);
        recyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerview.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.HORIZONTAL_LIST));
        refreshlayout.startRefresh();
    }

    private void  getData(int page, int rows, final boolean isLoadMore){
        Map<String,String> map=new HashMap<>();
        map.put("page",""+PAGE);
        map.put("rows",""+PAGE_SIZE);
//        map.put("receiverId","");//备用
//        map.put("content","1212321");备用
        MyRetrofit.StartQueryNet(mContext, true, ApiPathUrl.ACTION_DIRECTIVELIST, map, new ResponseCallBack<InstructionRecordDataList>() {
            @Override
            protected void onLoad(Disposable d) {

            }

            @Override
            protected void onError(KtkjError error) {
                  ToastUtils.showMessage(mContext,error.msg);
            }

            @Override
            protected void onSuccess(InstructionRecordDataList result) {
                if (!isLoadMore){
                    mAllItemInstrucatoinInfoList.clear();
                    mAllItemInstrucatoinInfoList.addAll(result.rows);
                    if (result.rows.size()>0) {
                        refreshlayout.setEnableLoadmore(true);
                        mInstructionRecordAdapter.setList(mAllItemInstrucatoinInfoList);
                        recyclerview.setAdapter(mInstructionRecordAdapter);
                        recyclerview.setVisibility(View.VISIBLE);
                    }else{
                        recyclerview.setVisibility(View.GONE);
                        ToastUtils.showMessage(mContext,"暂无相关数据");
                    }
                    refreshlayout.finishRefreshing();
                    ToastUtils.showMessage(mContext,"刷新成功");
                }else{
                    if (result.rows.size()>0&&result.rows.size()<=PAGE_SIZE) {
                        mAllItemInstrucatoinInfoList.addAll(result.rows);
                        recyclerview.setAdapter(mInstructionRecordAdapter);
                    }else{
                        ToastUtils.showMessage(mContext,"无更多数据");
                        refreshlayout.setEnableLoadmore(false);
                    }
                    refreshlayout.finishLoadmore();
                }
            }
        });
    }
}



