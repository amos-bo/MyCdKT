package com.ktcd.malc.kt_ma_lc.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.model.ItemEventInfoResponse;
import com.ktcd.malc.kt_ma_lc.model.ItemEventProgressInfo;
import com.ktcd.malc.kt_ma_lc.model.ItemHomeTypeInfo;

import butterknife.BindView;

/**
 * 创建时间 2016/12/30.
 * 创建人： ${xiangbo}
 * 作用：
 * 备注：事件列表
 */

public class EventProgressAdapter extends SimpleRecyclerAdapter<ItemEventInfoResponse.RowsBean.EventDetailInfoListBean, EventProgressAdapter.MyHolder> {

    public EventProgressAdapter(Context context) {
        super(context, R.layout.item_eventprogress);
    }

    @Override
    protected void convert(MyHolder holder, ItemEventInfoResponse.RowsBean.EventDetailInfoListBean s, final int position) {
        if (s == null || holder == null)
            return;
        holder.tvTitle.setText(s.getEdiTile());
        holder.tvTime.setText(s.getUpdateTime());
        holder.tvContent.setText(s.getEdiDescription());
        if (position == 0) {
            holder.viewLine.setVisibility(View.INVISIBLE);
        } else {
            holder.viewLine.setVisibility(View.VISIBLE);
        }
    }

    static class MyHolder extends SimpleViewHolder {
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.view_line)
        View viewLine;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.item_root)
        LinearLayout itemRoot;
        MyHolder(View itemView) {
            super(itemView);
        }
    }

}
