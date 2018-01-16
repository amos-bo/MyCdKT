package com.ktcd.malc.kt_ma_lc.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.ktcd.malc.baselayer.activity.ToolbarActivity;
import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.adapter.FileTypeAdapter;
import com.ktcd.malc.kt_ma_lc.applicatoin.ApiPathUrl;
import com.ktcd.malc.kt_ma_lc.bean.LoginBean;
import com.ktcd.malc.kt_ma_lc.model.ItemEventInfoResponse;
import com.ktcd.malc.kt_ma_lc.model.ItemFileTypeInfo;
import com.ktcd.malc.kt_ma_lc.responseparam.IdGetInfoResponse;
import com.ktcd.malc.utilslibrary.net.KtkjError;
import com.ktcd.malc.utilslibrary.net.MyRetrofit;
import com.ktcd.malc.utilslibrary.net.ResponseCallBack;
import com.ktcd.malc.utilslibrary.tools.ConfigUtils;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;


public class EventDetailActivity extends ToolbarActivity {

    @BindView(R.id.tv_name_time)
    TextView tvNameTime;
    @BindView(R.id.tv_remark)
    TextView tvRemark;
    @BindView(R.id.recyclerview)
    RecyclerView recyclerview;
    @BindView(R.id.tv_loc)
    TextView tvLoc;

    private FileTypeAdapter mFileTypeAdapter;
    //所有文件
    private List<ItemFileTypeInfo> mItemFileTypeInfoList;
    //图片文件
    private ArrayList<ItemFileTypeInfo> mItemFilePicInfoList;
    private ItemEventInfoResponse.RowsBean.EventDetailInfoListBean mEventDetailInfoListBean;

    public static void StartEventProgressListActivity(Context context, ItemEventInfoResponse.RowsBean.EventDetailInfoListBean item, ArrayList<ItemFileTypeInfo> itemFileTypeInfoList){
        Bundle bundle=new Bundle();
        bundle.putSerializable("DATA_INFO",item);
        bundle.putSerializable("DATA_FILES",itemFileTypeInfoList);
        Intent intent=new Intent(context,EventDetailActivity.class);
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        ButterKnife.bind(this);
        initView();
        initData();
    }
    private void initView(){
        setTitle("实况信息");
        recyclerview.setLayoutManager(new GridLayoutManager(mContext, 3));
        mFileTypeAdapter = new FileTypeAdapter(mContext);
        mFileTypeAdapter.setFileDeleteIsShow(false);
        mFileTypeAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (mItemFileTypeInfoList.get(position).Type == 2) {
                    Intent intents = new Intent(Intent.ACTION_VIEW);
                    intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intents.setDataAndType(Uri.parse(mItemFileTypeInfoList.get(position).pathUrl), "video/*");
                    startActivity(intents);
                } else if (mItemFileTypeInfoList.get(position).Type == 1) {
                    if (mItemFilePicInfoList.size() < 1) {
                        for (ItemFileTypeInfo item : mItemFileTypeInfoList) {
                            if (item.Type == 1) {
                                mItemFilePicInfoList.add(item);
                            }
                        }
                    }
                    Rect rect = new Rect();
                    view.getGlobalVisibleRect(rect);
                    ImageCheckListActivity.StartImagesCheckActivity(mContext, mItemFilePicInfoList, mItemFilePicInfoList.indexOf(mItemFileTypeInfoList.get(position)), rect);
                } else {
                    try {
                        MediaPlayer mPlayer = new MediaPlayer();
                        mPlayer.reset();
                        mPlayer.setDataSource(mItemFileTypeInfoList.get(position).pathUrl);
                        mPlayer.prepare();
                        mPlayer.start();
                    } catch (IOException e) {
                        Log.e("", "播放失败");
                    }
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
    }

    private  void initData(){
        mEventDetailInfoListBean=(ItemEventInfoResponse.RowsBean.EventDetailInfoListBean)getIntent().getExtras().getSerializable("DATA_INFO");
        mItemFileTypeInfoList=(ArrayList<ItemFileTypeInfo>)getIntent().getExtras().getSerializable("DATA_FILES");
        mItemFilePicInfoList=new ArrayList<>();

        mFileTypeAdapter.setList(mItemFileTypeInfoList);
        recyclerview.setAdapter(mFileTypeAdapter);
        tvRemark.setText(mEventDetailInfoListBean.getEdiDescription());
        tvLoc.setText(mEventDetailInfoListBean.getEdiAddress());
        getPersonInfo();
    }

    private void getPersonInfo(){

        final Map<String,String> map=new HashMap<>();
        map.put("cpId", ""+ConfigUtils.getUserID(mContext));
        final ProgressDialog pDialog = ProgressDialog
                .show(this, "请稍等", "正在加载数据...");
        MyRetrofit.StartQueryNet(mContext, true, ApiPathUrl.ACTION_GETUSERBYID, map, new ResponseCallBack<IdGetInfoResponse>() {
            @Override
            protected void onLoad(Disposable d) {
               pDialog.show();
            }

            @Override
            protected void onError(KtkjError error) {
                pDialog.dismiss();
                ToastUtils.showMessage(mContext,error.msg);
            }

            @Override
            protected void onSuccess(IdGetInfoResponse result) {
                pDialog.dismiss();
                tvNameTime.setText(result.getCpName()+" "+mEventDetailInfoListBean.getUpdateTime());
            }
        });


    }

}
