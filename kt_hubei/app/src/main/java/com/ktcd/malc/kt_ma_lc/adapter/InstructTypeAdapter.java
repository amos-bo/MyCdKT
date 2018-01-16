package com.ktcd.malc.kt_ma_lc.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.model.ItemInstructTypeInfo;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import butterknife.BindView;

/**
 * 创建时间 2016/12/30.
 * 创建人： ${xiangbo}
 * 作用：
 * 备注：指令列表
 */

public class InstructTypeAdapter extends SimpleRecyclerAdapter<ItemInstructTypeInfo.DataBean.RowsBean, InstructTypeAdapter.MyHolder> {

    public InstructTypeAdapter(Context context) {
        super(context, R.layout.item_instruct_type);
    }

    @Override
    protected void convert(MyHolder holder, ItemInstructTypeInfo.DataBean.RowsBean s, final int position) {
        holder.tvTitle.setText(s.getEapdDes());
        if (s.getEapdStatus() != null) {
            holder.frTime.setVisibility(View.VISIBLE);
            if (s.getEapdStatus().getValue() == 2) {
                SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日-HH:mm:ss", Locale.getDefault());
                Date date = new Date(s.getUpdateTime());
                String[] time = sdf.format(date).split("-");
                holder.tvState.setVisibility(View.GONE);
                holder.tvDate.setVisibility(View.VISIBLE);
                holder.tvTime.setVisibility(View.VISIBLE);
                holder.tvDate.setText(time[0]);
                holder.tvTime.setText(time[1]);
            } else {
                if (TextUtils.isEmpty(s.getEapdStatus().getDescription())){
                    holder.frTime.setVisibility(View.GONE);
                }else{
                    holder.frTime.setVisibility(View.VISIBLE);
                }
                holder.tvDate.setVisibility(View.GONE);
                holder.tvTime.setVisibility(View.GONE);
                holder.tvState.setVisibility(View.VISIBLE);
                holder.tvState.setText(s.getEapdStatus().getDescription());
                switch (s.getEapdStatus().getValue()) {
                    case 0:
                        holder.tvState.setTextColor(ContextCompat.getColor(mContext, R.color.other_2));
                        break;
                    case 1:
                        holder.tvState.setTextColor(ContextCompat.getColor(mContext, R.color.blue));
                        break;
                    case 3:
                        holder.tvState.setTextColor(ContextCompat.getColor(mContext, R.color.assist_2));
                        break;
                    case 4:
                        holder.tvState.setTextColor(ContextCompat.getColor(mContext, R.color.red_normal));
                        break;
                }
            }
            holder.itemRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(view, position);
                }
            });
        }else{
            holder.frTime.setVisibility(View.GONE);
            holder.itemRoot.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ToastUtils.showMessage(mContext,"服务器此条数据不正确");
                }
            });
        }
    }


    static class MyHolder extends SimpleViewHolder {

        @BindView(R.id.fr_time)
        FrameLayout frTime;
        @BindView(R.id.tv_title)
        TextView tvTitle;
        @BindView(R.id.tv_date)
        TextView tvDate;
        @BindView(R.id.tv_time)
        TextView tvTime;
        @BindView(R.id.tv_state)
        TextView tvState;
        @BindView(R.id.item_root)
        LinearLayout itemRoot;

        MyHolder(View itemView) {
            super(itemView);
        }
    }

}
