package com.ktcd.malc.kt_ma_lc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * @ClassName
 * @Description
 * @Author Xiaoborui
 * @Date 2016/12/15 14:16
 */

public class SimpleViewHolder extends RecyclerView.ViewHolder {
    public View mRoot;
    public SimpleViewHolder(View itemView) {
        super(itemView);
        mRoot = itemView;
        ButterKnife.bind(this,itemView);
    }
}
