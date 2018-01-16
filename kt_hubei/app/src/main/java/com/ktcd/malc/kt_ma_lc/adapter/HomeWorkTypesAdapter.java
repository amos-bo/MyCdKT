package com.ktcd.malc.kt_ma_lc.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.applicatoin.ApiPathUrl;
import com.ktcd.malc.kt_ma_lc.model.ItemHomeTypeInfo;
import com.ktcd.malc.kt_ma_lc.model.MessageNumInfo;
import com.ktcd.malc.utilslibrary.net.KtkjError;
import com.ktcd.malc.utilslibrary.net.MyRetrofit;
import com.ktcd.malc.utilslibrary.net.ResponseCallBack;
import com.ktcd.malc.utilslibrary.tools.ConfigUtils;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import io.reactivex.disposables.Disposable;
import q.rorbin.badgeview.QBadgeView;

/**
 * 创建时间 2016/12/30.
 * 创建人： ${xiangbo}
 * 作用：
 * 备注：首页功能列表
 */

public class HomeWorkTypesAdapter extends SimpleRecyclerAdapter<ItemHomeTypeInfo, HomeWorkTypesAdapter.MyHolder> {


    public HomeWorkTypesAdapter(Context context) {
        super(context, R.layout.item_home_work_type);
    }

    @Override
    protected void convert(MyHolder holder, ItemHomeTypeInfo s, final int position) {
        if (s == null || holder == null)
            return;
        holder.imgWorkType.setImageResource(s.drawAbleId);
        holder.tvWorkName.setText(s.TypeName);
        if ("指令管理".equals(s.TypeName)) {
            int userid = ConfigUtils.getUserID(mContext);
            upDataNum(userid,holder.imgWorkType);
        }
        holder.mRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v, position);
            }
        });
    }


    static class MyHolder extends SimpleViewHolder {
        @BindView(R.id.img_work_type)
        ImageView imgWorkType;
        @BindView(R.id.tv_work_name)
        TextView tvWorkName;
        @BindView(R.id.item_root)
        LinearLayout itemRoot;

        MyHolder(View itemView) {
            super(itemView);
        }
    }

    /***
     * 网络未读消息数目
     */
    private void upDataNum(Integer userid, final ImageView imgWorkType) {

        Map<String, String> map = new HashMap<>();
        map.put("userid", userid.toString());
        map.put("msgType", "actionPlanDirective");
        MyRetrofit.StartQueryNet(mContext, true, ApiPathUrl.ACTION_GETMESSAGESNUM, map, new ResponseCallBack<MessageNumInfo>() {
            @Override
            protected void onLoad(Disposable d) {

            }

            @Override
            protected void onError(KtkjError error) {
                ToastUtils.showMessage(mContext, error.msg);
            }

            @Override
            protected void onSuccess(MessageNumInfo result) {
                if (result.getAmount()>0) {
                    new QBadgeView(mContext).bindTarget(imgWorkType).setBadgeNumber(result.getAmount());
                }
            }
        });
    }
}
