package com.ktcd.malc.kt_ma_lc.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.model.ItemEventInfoResponse;
import com.ktcd.malc.kt_ma_lc.model.ItemHomeTypeInfo;

import butterknife.BindView;

/**
 * 创建时间 2016/12/30.
 * 创建人： ${xiangbo}
 * 作用：
 * 备注：事件列表
 */

public class EventTypesAdapter extends SimpleRecyclerAdapter<ItemEventInfoResponse.RowsBean, EventTypesAdapter.MyHolder> {


    public EventTypesAdapter(Context context) {
        super(context, R.layout.item_event);
    }

    @Override
    protected void convert(MyHolder holder, ItemEventInfoResponse.RowsBean s, final int position) {
        if (s == null || holder == null)
            return;
        holder.tvTitile.setText(s.getEiName());
        holder.tvState.setText(s.getEiStatus().getDescription());
        holder.tvCode.setText(""+s.getEiId());
        holder.mRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v, position);
            }
        });
    }

    static class MyHolder extends SimpleViewHolder {
        @BindView(R.id.tv_titile)
        TextView tvTitile;
        @BindView(R.id.tv_state)
        TextView tvState;
        @BindView(R.id.tv_code)
        TextView tvCode;
        @BindView(R.id.item_root)
        LinearLayout itemRoot;

        MyHolder(View itemView) {
            super(itemView);
        }
    }

}
