package com.ktcd.malc.kt_ma_lc.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ktcd.malc.baselayer.activity.ToolbarActivity;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.applicatoin.ApiPathUrl;
import com.ktcd.malc.kt_ma_lc.bean.UpdateOrderBean;
import com.ktcd.malc.kt_ma_lc.dialog.MyAlertDialog;
import com.ktcd.malc.kt_ma_lc.model.ItemInstructTypeInfo;
import com.ktcd.malc.utilslibrary.net.KtkjError;
import com.ktcd.malc.utilslibrary.net.MyRetrofit;
import com.ktcd.malc.utilslibrary.net.ResponseCallBack;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.Disposable;

/**
 * Created by Administrator on 2017/6/28.
 */

public class OrderDetailsActivity extends ToolbarActivity {
    @BindView(R.id.order_detail_state)
    ImageView orderDetailState;
    @BindView(R.id.order_detail_time)
    TextView orderDetailTime;
    @BindView(R.id.order_detail_content)
    TextView orderDetailContent;
    @BindView(R.id.order_detail_establish)
    TextView orderDetailEstablish;
    @BindView(R.id.order_detail_cancel)
    Button orderDetailCancel;
    @BindView(R.id.order_detail_refuse)
    Button orderDetailRefuse;
    @BindView(R.id.order_detail_sub)
    Button orderDetailSub;
    @BindView(R.id.order_detail_sub_layout)
    LinearLayout orderDetailSubLayout;
    @BindView(R.id.order_detail_refuse_causes)
    TextView orderDetailRefuseCauses;
    @BindView(R.id.order_detail_refuse_name)
    TextView orderDetailRefuseName;
    @BindView(R.id.order_detail_refuse_layout)
    LinearLayout orderDetailRefuseLayout;

    private ItemInstructTypeInfo.DataBean.RowsBean rowsBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        ButterKnife.bind(this);
        rowsBean = (ItemInstructTypeInfo.DataBean.RowsBean) getIntent().getExtras().getSerializable("rows");
        initView();
    }

    private void initView() {
        setToolbarColor(ContextCompat.getColor(this, R.color.white));
        setTitle("指令详情");
        setTitleColorRes(R.color.black);
        setTitleTextSize(18);

        initData();
    }

    private void initData() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        Date date = new Date(rowsBean.getCreateTime());
        orderDetailTime.setText(sdf.format(date));
        orderDetailContent.setText(rowsBean.getEapdDes());
        orderDetailEstablish.setText(rowsBean.getEapdCreateBy());
        switch (rowsBean.getEapdStatus().getValue()) {
            case 0:
                orderDetailState.setImageResource(R.mipmap.order_details_zhiling_waiiting);
                orderDetailCancel.setVisibility(View.GONE);
                orderDetailRefuseLayout.setVisibility(View.GONE);
                break;
            case 1:
                orderDetailState.setImageResource(R.mipmap.order_details_zhiling_ing);
                orderDetailCancel.setText("指令完成");
                orderDetailCancel.setBackgroundResource(R.drawable.selector_order_cancel);
                orderDetailSubLayout.setVisibility(View.GONE);
                orderDetailRefuseLayout.setVisibility(View.GONE);
                break;
            case 2:
                orderDetailState.setImageResource(R.mipmap.order_details_zhiling_over);
                orderDetailCancel.setVisibility(View.GONE);
                orderDetailSubLayout.setVisibility(View.GONE);
                orderDetailRefuseLayout.setVisibility(View.GONE);
                break;
            case 3:
                orderDetailState.setImageResource(R.mipmap.order_details_zhiling_cancel);
                orderDetailCancel.setVisibility(View.GONE);
                orderDetailSubLayout.setVisibility(View.GONE);
                orderDetailRefuseLayout.setVisibility(View.GONE);
                break;
            case 4:
                orderDetailState.setImageResource(R.mipmap.order_details_zhiling_refuse);
                orderDetailRefuseCauses.setText(rowsBean.getRefuseReason());
                orderDetailCancel.setVisibility(View.GONE);
                orderDetailSubLayout.setVisibility(View.GONE);
                orderDetailRefuseName.setVisibility(View.GONE);
                break;
            default:
                orderDetailState.setImageResource(R.mipmap.order_details_zhiling_waiiting);
                orderDetailCancel.setVisibility(View.GONE);
                orderDetailRefuseLayout.setVisibility(View.GONE);
                break;
        }
        if (rowsBean.getEapdStatus().getValue()==-2) {
            getDataUpdateStatus(rowsBean.getEapdId(), "-1", "");
        }
    }

    private void getDataUpdateStatus(int eapdId, String value, String rows) {
        Map<String, String> map = new HashMap<>();
        map.put("eapdId", "" + eapdId);
        map.put("eapdStatus.value", value);
        if (!rows.isEmpty()) {
            map.put("rows", rows);
        }
        MyRetrofit.StartQueryNet(mContext, true, ApiPathUrl.ACTION_UPDATESTATUS, map, new ResponseCallBack<UpdateOrderBean.DataBean>() {
            @Override
            protected void onLoad(Disposable d) {

            }

            @Override
            protected void onError(KtkjError error) {
                ToastUtils.showMessage(mContext, error.msg);
            }

            @Override
            protected void onSuccess(UpdateOrderBean.DataBean result) {
                if (result.getEapdStatus().getValue()!=-1) {
                    finish();
                }
            }
        });
    }

    @OnClick({R.id.order_detail_cancel, R.id.order_detail_refuse, R.id.order_detail_sub})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.order_detail_cancel:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("提示");
                builder.setMessage("你确定已经完成指令？");
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getDataUpdateStatus(rowsBean.getEapdId(), "2", "");
                    }
                });
                builder.show();
                break;
            case R.id.order_detail_refuse:
                final MyAlertDialog alertDialog = new MyAlertDialog.Builder(this)
                        .setContentView(R.layout.popup_refuse_order)
                        .fullWidth().show();
                //操作特有的对象 getview()  ListView等
                final EditText popup_refuse_content = alertDialog.getView(R.id.popup_refuse_content);
                //dialog去操作点击事件
                alertDialog.setOnClickListener(R.id.popup_refuse_sub, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String content = popup_refuse_content.getText().toString().trim();
                        getDataUpdateStatus(rowsBean.getEapdId(), "4", content);
                        alertDialog.dismiss();
                    }
                });
                alertDialog.setOnClickListener(R.id.popup_refuse_delete, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.setOnClickListener(R.id.popup_refuse_cancel, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alertDialog.dismiss();
                    }
                });
                break;
            case R.id.order_detail_sub:
                AlertDialog.Builder builderSub= new AlertDialog.Builder(this);
                builderSub.setTitle("提示");
                builderSub.setMessage("你确定要接受指令？");
                builderSub.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                builderSub.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        getDataUpdateStatus(rowsBean.getEapdId(), "1", "");
                    }
                });
                builderSub.show();
                break;
        }
    }
}
