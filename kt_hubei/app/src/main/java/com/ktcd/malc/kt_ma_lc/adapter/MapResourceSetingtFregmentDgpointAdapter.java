package com.ktcd.malc.kt_ma_lc.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.model.ItemEventInfoResponse;
import com.ktcd.malc.kt_ma_lc.model.ItemMapResoureSelectType;

import butterknife.BindView;

/**
 * 创建时间 2016/12/30.
 * 创建人： ${xiangbo}
 * 作用：
 * 备注：地图资源筛选
 */

public class MapResourceSetingtFregmentDgpointAdapter extends SimpleRecyclerAdapter<ItemMapResoureSelectType, MapResourceSetingtFregmentDgpointAdapter.MyHolder> {

    public MapResourceSetingtFregmentDgpointAdapter(Context context) {
        super(context, R.layout.item_fregment_mapresourcesetingt_dgpoint_select);
    }

    @Override
    protected void convert(MyHolder holder, ItemMapResoureSelectType s, final int position) {
        if (s == null || holder == null)
            return;
        if (s.isSelected) {
            holder.tvTitle.setBackgroundResource(R.drawable.bg_tv_ova5_blue);
            holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.other_3_press));
        } else {
            holder.tvTitle.setBackgroundResource(R.drawable.bg_tv_ova5_gay);
            holder.tvTitle.setTextColor(mContext.getResources().getColor(R.color.other_4_press));
        }
        if (!TextUtils.isEmpty(s.getName())) {
            holder.tvTitle.setText(s.getName());
        } else {
            holder.tvTitle.setText("暂无名称");
        }
        holder.itemRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mOnItemClickListener.onItemClick(view,position);
            }
        });
    }

    static class MyHolder extends SimpleViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.itemRoot)
        RelativeLayout itemRoot;

        MyHolder(View itemView) {
            super(itemView);
        }
    }

}
