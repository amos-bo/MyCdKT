package com.ktcd.malc.kt_ma_lc.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.model.ItemHomeTypeInfo;

import butterknife.BindView;

/**
 * 创建时间 2016/12/30.
 * 创建人： ${xiangbo}
 * 作用：
 * 备注：首页功能列表
 */

public class ResourcesTypesAdapter extends SimpleRecyclerAdapter<ItemHomeTypeInfo, ResourcesTypesAdapter.MyHolder> {

    public ResourcesTypesAdapter(Context context) {
        super(context, R.layout.item_resource_type);
    }

    @Override
    protected void convert(MyHolder holder, ItemHomeTypeInfo s, final int position) {
        if (s == null || holder == null)
            return;
        if (s.isSelected){
            switch (s.drawAbleId){
                case 1:
                    //塌陷
                    holder.imgWorkType.setImageResource(R.mipmap.map_icon_danger_taxian);
                    break;
                case 2:
                    //崩塌
                    holder.imgWorkType.setImageResource(R.mipmap.map_icon_danger_bengta);
                    break;
                case 3:
                    //滑坡
                    holder.imgWorkType.setImageResource(R.mipmap.map_icon_danger_huapo);
                    break;
                case 4:
                    //中小河流
                    holder.imgWorkType.setImageResource(R.mipmap.map_icon_danger_smallriver);
                    break;
                case 5:
                    //山洪沟
                    holder.imgWorkType.setImageResource(R.mipmap.map_icon_danger_floods);
                    break;
                case 6:
                    //泥石流
                    holder.imgWorkType.setImageResource(R.mipmap.map_icon_danger_debrisflow);
                    break;
            }
            holder.itemRoot.setBackgroundResource(R.drawable.bg_rectangle4_blue);
        }else{
            switch (s.drawAbleId){
                case 1:
                    //塌陷
                    holder.imgWorkType.setImageResource(R.mipmap.map_icon_danger_taxian_gray);

                    break;
                case 2:
                    //崩塌
                    holder.imgWorkType.setImageResource(R.mipmap.map_icon_danger_bengta_gray);
                    break;
                case 3:
                    //滑坡
                    holder.imgWorkType.setImageResource(R.mipmap.map_icon_danger_huapo_gray);
                    break;
                case 4:
                    //中小河流
                    holder.imgWorkType.setImageResource(R.mipmap.map_icon_danger_smallriver_gray);
                    break;
                case 5:
                    //山洪沟
                    holder.imgWorkType.setImageResource(R.mipmap.map_icon_danger_floods_gray);
                    break;
                case 6:
                    //泥石流
                    holder.imgWorkType.setImageResource(R.mipmap.map_icon_danger_debrisflow_gray);
                    break;
            }
            holder.itemRoot.setBackgroundResource(R.drawable.bg_rectangle4_gay);
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

}
