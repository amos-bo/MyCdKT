package com.ktcd.malc.kt_ma_lc.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.bean.NoticeBean;
import com.ktcd.malc.kt_ma_lc.responseparam.PushParmInfo;

import java.util.List;

/**
 * Created by Administrator on 2017/7/6.
 */

public class NoticeAdapter extends RecyclerView.Adapter {

    private List<NoticeBean.DataBean.RowsBean> data;
    private List<PushParmInfo.DataBean> dataNotify;
    private LayoutInflater inflater;
    private Context context;

    public NoticeAdapter(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<NoticeBean.DataBean.RowsBean> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    public void setDataNotify(List<PushParmInfo.DataBean> data) {
        this.dataNotify = data;
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;
        if (viewType == 0) {
            view = inflater.inflate(R.layout.item_notice_normal, parent, false);
            return new NoticeHolderOne(view);
        } else {
            view = inflater.inflate(R.layout.item_notice_warning, parent, false);
            return new NoticeHolderTwo(view);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof NoticeHolderOne) {
            NoticeHolderOne one = (NoticeHolderOne) holder;
            one.item_notice_normal_content.setText(data.get(position).getBaContent());
        } else if (holder instanceof NoticeHolderTwo) {
            NoticeHolderTwo two = (NoticeHolderTwo) holder;
            two.item_notice_warning_content.setText(data.get(position).getBaContent());
            two.item_notice_warning_type.setText(data.get(position).getBaTitle());
            switch (getItemViewType(position)) {
                case 1:
                    two.item_notice_warning_type.setBackgroundColor(ContextCompat.getColor(context, R.color.warning_2));
                    break;
                case 2:
                    two.item_notice_warning_type.setBackgroundColor(ContextCompat.getColor(context, R.color.other_2));
                    break;
                case 3:
                    two.item_notice_warning_type.setBackgroundColor(ContextCompat.getColor(context, R.color.yellow));
                    break;
                case 4:
                    two.item_notice_warning_type.setBackgroundColor(ContextCompat.getColor(context, R.color.blue));
                    break;
            }
        }
    }

    @Override
    public int getItemCount() {
        return data != null ? data.size() : 0;
    }

    @Override
    public int getItemViewType(int position) {
        return data.get(position).getBaType().getValue();
    }

    private class NoticeHolderOne extends RecyclerView.ViewHolder {
        TextView item_notice_normal_time;
        TextView item_notice_normal_content;

        NoticeHolderOne(View itemView) {
            super(itemView);
            item_notice_normal_time = itemView.findViewById(R.id.item_notice_normal_time);
            item_notice_normal_content = itemView.findViewById(R.id.item_notice_normal_content);
        }
    }

    private class NoticeHolderTwo extends RecyclerView.ViewHolder {
        TextView item_notice_warning_time;
        TextView item_notice_warning_type;
        TextView item_notice_warning_content;

        NoticeHolderTwo(View itemView) {
            super(itemView);
            item_notice_warning_time = itemView.findViewById(R.id.item_notice_warning_time);
            item_notice_warning_type = itemView.findViewById(R.id.item_notice_warning_type);
            item_notice_warning_content = itemView.findViewById(R.id.item_notice_warning_content);
        }
    }

}
