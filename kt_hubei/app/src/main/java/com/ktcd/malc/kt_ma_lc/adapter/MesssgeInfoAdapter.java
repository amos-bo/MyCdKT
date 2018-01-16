//package com.ktcd.malc.kt_ma_lc.adapter;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.net.Uri;
//import android.text.SpannableString;
//import android.text.TextUtils;
//import android.view.Gravity;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
//
//import com.facebook.drawee.view.SimpleDraweeView;
//import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
//import com.ktcd.malc.kt_ma_lc.R;
//import com.ktcd.malc.kt_ma_lc.model.ItemMessgeInfo;
//import com.ktcd.malc.kt_ma_lc.xmppim.bean.ChatRecord;
//import com.ktcd.malc.kt_ma_lc.xmppim.constant.EmotionType;
//import com.ktcd.malc.kt_ma_lc.xmppim.util.ChatTimeUtil;
//import com.ktcd.malc.kt_ma_lc.xmppim.util.EmotionUtil;
//import com.ktcd.malc.kt_ma_lc.xmppim.util.ImageLoaderHelper;
//
//import butterknife.BindView;
//
//
///**
// * 创建时间 2016/12/30.
// * 创建人： ${xiangbo}
// * 作用：
// * 备注：首页消息列表
// */
//
//public class MesssgeInfoAdapter extends SimpleRecyclerAdapter<ChatRecord, MesssgeInfoAdapter.MyHolder> {
//
//    private Context mContext;
//
//    public MesssgeInfoAdapter(Context context) {
//        super(context, R.layout.item_messge_personinfo);
//        mContext = context;
//    }
//
//    @Override
//    protected void convert(MyHolder holder, ChatRecord s, final int position) {
//        if (s == null || holder == null)
//            return;
//        if (!TextUtils.isEmpty(s.getFriendAvatar())) {
//            holder.imgHead.setImageURI(Uri.parse(s.getFriendAvatar()));
//        }
//        holder.tvName.setText(s.getFriendNickname());
//        holder.tvGroup.setText("(" + 12 + "/" + 24 + ")");
//        holder.tvGroup.setVisibility(View.GONE);
//        holder.tvTime.setText(ChatTimeUtil.getFriendlyTimeSpanByNow(s.getChatTime()));
//        holder.tvMessgeNum.setText("");
//        if (!TextUtils.isEmpty(s.getLastMessage())) {
//            holder.tvMessgeContent.setText(s.getLastMessage());
//            if(holder.tvMessgeContent.getVisibility() == View.GONE) {
//                holder.tvMessgeContent.setVisibility(View.VISIBLE);
//            }
//            SpannableString content = EmotionUtil.getInputEmotionContent(mContext, EmotionType.EMOTION_TYPE_CLASSIC, holder.tvMessgeContent, s.getLastMessage());
//            holder.tvMessgeContent.setText(content);
//        }else{
//            holder.tvMessgeContent.setText("暂无消息");
//        }
//
//        if (s.getUnReadMessageCount()==0) {
//            holder.tvMessgeNum.setVisibility(View.GONE);
//        } else {
//            holder.tvMessgeNum.setTextColor(Color.WHITE);
//            holder.tvMessgeNum.setVisibility(View.VISIBLE);
//            if (s.getUnReadMessageCount()>9) {
//                holder.tvMessgeNum.setText("9+");
//            }else{
//                holder.tvMessgeNum.setText(""+s.getUnReadMessageCount());
//            }
//        }
//        holder.itemRoot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mOnItemClickListener.onItemClick(v, position);
//            }
//        });
//    }
//
//    static class MyHolder extends SimpleViewHolder {
//        @BindView(R.id.img_tip)
//        ImageView imgTip;
//        @BindView(R.id.img_head)
//        SimpleDraweeView imgHead;
//        @BindView(R.id.tv_name)
//        TextView tvName;
//        @BindView(R.id.tv_group)
//        TextView tvGroup;
//        @BindView(R.id.tv_time)
//        TextView tvTime;
//        @BindView(R.id.tv_messge_content)
//        TextView tvMessgeContent;
//        @BindView(R.id.tv_messge_num)
//        TextView tvMessgeNum;
//        @BindView(R.id.item_root)
//        LinearLayout itemRoot;
//        MyHolder(View itemView) {
//            super(itemView);
//        }
//    }
//
//}
