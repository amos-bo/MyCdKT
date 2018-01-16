package com.ktcd.malc.kt_ma_lc.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ktcd.malc.baselayer.activity.ToolbarActivity;
import com.ktcd.malc.baselayer.view.DividerItemDecoration;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.adapter.EventProgressAdapter;
import com.ktcd.malc.kt_ma_lc.model.ItemEventInfoResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventProgressListActivity extends ToolbarActivity {

    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;

    private EventProgressAdapter mEventProgressAdapter;
    private ArrayList<ItemEventInfoResponse.RowsBean.EventDetailInfoListBean> mEventDetailInfoList;


    public static void StartEventProgressListActivity(Context context, ArrayList<ItemEventInfoResponse.RowsBean.EventDetailInfoListBean> eventDetailInfoList ){
        Bundle bundle=new Bundle();
        bundle.putSerializable("DATA_INFO",eventDetailInfoList);
        Intent intent=new Intent(context,EventProgressListActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_progress_list);
        ButterKnife.bind(this);
        initView();
        initData();
    }

    private void initView() {
        setTitle("事件报告");
        recyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        mEventProgressAdapter = new EventProgressAdapter(mContext);
    }

    private void initData() {
        mEventDetailInfoList=(ArrayList<ItemEventInfoResponse.RowsBean.EventDetailInfoListBean>)getIntent().getExtras().getSerializable("DATA_INFO");
        if (mEventDetailInfoList.size()>0){
            mEventProgressAdapter.setList(mEventDetailInfoList);
            recyclerview.setAdapter(mEventProgressAdapter);
        }else{
            recyclerview.setVisibility(View.GONE);
        }
    }
}
