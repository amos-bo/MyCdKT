package com.ktcd.malc.kt_ma_lc.adapter;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.model.SelectPersonInfo;

import butterknife.BindView;

/**
 * 创建时间 2016/12/30.
 * 创建人： ${xiangbo}
 * 作用：
 * 备注：首页消息列表
 */

public class SelcetPersonAdapter extends SimpleRecyclerAdapter<SelectPersonInfo, SelcetPersonAdapter.MyHolder> {


    private boolean isShowSelect = false;


    public SelcetPersonAdapter(Context context) {
        super(context, R.layout.item_select_person);
    }


    @Override
    protected void convert(MyHolder holder, SelectPersonInfo s, final int position) {
        if (s == null || holder == null)
            return;
        if (isShowSelect) {
            holder.imgArrow.setVisibility(View.VISIBLE);
            if (s.isSelected) {
                holder.imgArrow.setImageResource(R.drawable.sim_vector_checked);
            } else {
                holder.imgArrow.setImageResource(R.drawable.sim_vector_uncheck);
            }
        } else {
            holder.imgArrow.setVisibility(View.GONE);
        }
        if (!TextUtils.isEmpty(s.imgUrl)) {
            holder.imgHead.setImageURI(Uri.parse(s.imgUrl));
        }
        holder.tvPersonName.setText(s.name);
        holder.tvShowState.setText(s.state);
        holder.itemRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onItemClick(v, position);
            }
        });
    }

    static class MyHolder extends SimpleViewHolder {
        @BindView(R.id.img_arrow)
        ImageView imgArrow;
        @BindView(R.id.img_head)
        SimpleDraweeView imgHead;
        @BindView(R.id.tv_person_name)
        TextView tvPersonName;
        @BindView(R.id.tv_show_state)
        TextView tvShowState;
        @BindView(R.id.item_root)
        RelativeLayout itemRoot;

        MyHolder(View itemView) {
            super(itemView);
        }
    }

    public void setShowSelectFlage(boolean show) {
        this.isShowSelect = show;
    }


}
