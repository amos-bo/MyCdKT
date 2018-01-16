package com.ktcd.malc.kt_ma_lc.adapter;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.responseparam.ItemInstrucatoinInfo;

import butterknife.BindView;

/**
 * 创建时间 2016/12/30.
 * 创建人： ${gonghaohao}
 * 作用：
 * 备注：排行榜适配器
 */

public class InstructionRecordAdapter extends SimpleRecyclerAdapter<ItemInstrucatoinInfo, InstructionRecordAdapter.InstructionRecordHolder> {

    public InstructionRecordAdapter(Context context) {
        super(context, R.layout.item_instruction);
    }

    @Override
    protected void convert(InstructionRecordHolder holder, ItemInstrucatoinInfo s, final int position) {
        if (s==null||holder==null)
            return;
        holder.tvCreatetime.setText(s.createTime);
        holder.tvUpdateTime.setText(s.updateTime);
        holder.tvId.setText(s.id);
        holder.tvDirectiveId.setText(s.directiveId);
        holder.tvContent.setText(s.content);
        holder.tvReceiverId.setText(s.receiverId);
        holder.mRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v,position);
            }
        });
    }

    static class InstructionRecordHolder extends SimpleViewHolder {

        @BindView(R.id.tv_createtime)
        TextView tvCreatetime;
        @BindView(R.id.tv_updateTime)
        TextView tvUpdateTime;
        @BindView(R.id.tv_id)
        TextView tvId;
        @BindView(R.id.tv_directiveId)
        TextView tvDirectiveId;
        @BindView(R.id.tv_content)
        TextView tvContent;
        @BindView(R.id.tv_receiverId)
        TextView tvReceiverId;
        @BindView(R.id.item_root)
        LinearLayout itemRoot;
        InstructionRecordHolder(View itemView) {
            super(itemView);
        }
    }

}
