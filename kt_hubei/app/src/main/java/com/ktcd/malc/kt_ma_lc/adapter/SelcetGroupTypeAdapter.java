//package com.ktcd.malc.kt_ma_lc.adapter;
//
//import android.content.Context;
//import android.content.Intent;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.facebook.drawee.view.SimpleDraweeView;
//import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
//import com.ktcd.malc.baselayer.view.DividerItemDecoration;
//import com.ktcd.malc.kt_ma_lc.R;
//import com.ktcd.malc.kt_ma_lc.model.SelectGrunpInfo;
//import com.ktcd.malc.kt_ma_lc.xmppim.activity.ChatActivity;
//import com.ktcd.malc.kt_ma_lc.xmppim.activity.MultiChatActivity;
//import com.ktcd.malc.kt_ma_lc.xmppim.bean.ChatRecord;
//import com.ktcd.malc.kt_ma_lc.xmppim.bean.ChatUser;
//import com.ktcd.malc.kt_ma_lc.xmppim.util.DBQueryHelper;
//import com.ktcd.malc.kt_ma_lc.xmppim.util.IntentHelper;
//
//import org.greenrobot.eventbus.EventBus;
//
//import butterknife.BindView;
//
///**
// * 创建时间 2016/12/30.
// * 创建人： ${xiangbo}
// * 作用：
// * 备注：首页消息列表
// */
//
//public class SelcetGroupTypeAdapter extends SimpleRecyclerAdapter<SelectGrunpInfo, SelcetGroupTypeAdapter.MyHolder> {
//
//    private  boolean isShowselectedFlag=false;
//
//    public SelcetGroupTypeAdapter(Context context) {
//        super(context, R.layout.item_group_type);
//    }
//
//    @Override
//    protected void convert(MyHolder holder, final SelectGrunpInfo s, final int position) {
//        if (s == null || holder == null)
//            return;
//        if (s.isSelected) {
//            holder.imgArrow.setImageResource(R.mipmap.icon_dropdown_down);
//            holder.recyclerview.setVisibility(View.VISIBLE);
//        } else {
//            holder.imgArrow.setImageResource(R.mipmap.icon_dropdown_retract);
//            holder.recyclerview.setVisibility(View.GONE);
//        }
//        holder.tvGroupName.setText(s.name);
////        holder.tvShowState.setText(s.stateOnline+"/"+s.stateAll);
//        holder.tvShowState.setText(""+s.stateAll);
//        final SelcetPersonAdapter selcetPersonAdapter=new SelcetPersonAdapter(mContext);
//        selcetPersonAdapter.setShowSelectFlage(isShowselectedFlag);
//        selcetPersonAdapter.setList(s.selectPersonInfoList);
//        //二级列表
//        holder.recyclerview.setLayoutManager(new LinearLayoutManager(mContext));
//        holder.recyclerview.addItemDecoration(new DividerItemDecoration(
//                mContext, DividerItemDecoration.HORIZONTAL_LIST, 2,
//                ContextCompat.getColor(mContext, R.color.assist_3)));
//        holder.recyclerview.setAdapter(selcetPersonAdapter);
//        selcetPersonAdapter.setOnItemClickListener(new OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                if (isShowselectedFlag) {
//                    s.selectPersonInfoList.get(position).isSelected = !s.selectPersonInfoList.get(position).isSelected;
//                    selcetPersonAdapter.notifyItemChanged(position);
//                }else {
//                        ChatUser chatUser = DBQueryHelper.queryChatUser(selcetPersonAdapter.getItem(position).jid, selcetPersonAdapter.getItem(position).name);
//                        ChatRecord chatRecord = DBQueryHelper.queryChatRecord(chatUser.getUuid());
//                        if (chatRecord == null) {
//                            chatRecord = new ChatRecord(chatUser);
//                        }
//                        EventBus.getDefault().post(chatRecord);//发起聊天时，发送一个事件到消息列表界面进行处理，如果不存在此聊天记录则创建一个新的
//                        Intent intent;
//                        if (chatUser.isMulti()) {
//                            intent = new Intent(mContext, MultiChatActivity.class);
//                        } else {
//                            intent = new Intent(mContext, ChatActivity.class);
//                        }
//                        intent.putExtra(IntentHelper.KEY_CHAT_DIALOG, chatUser);
//                        mContext.startActivity(intent);
//                }
//            }
//
//            @Override
//            public void onItemLongClick(View view, int position) {
//
//            }
//        });
//        holder.itemRoot.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mOnItemClickListener.onItemClick(v, position);
//            }
//        });
//    }
//
//    static class MyHolder extends SimpleViewHolder {
//        @BindView(R.id.img_arrow)
//        ImageView imgArrow;
//        @BindView(R.id.tv_group_name)
//        TextView tvGroupName;
//        @BindView(R.id.tv_show_state)
//        TextView tvShowState;
//        @BindView(R.id.recyclerview)
//        RecyclerView recyclerview;
//        @BindView(R.id.item_root)
//        LinearLayout itemRoot;
//
//        MyHolder(View itemView) {
//            super(itemView);
//        }
//    }
//
//    public void setShowSelectFlage(boolean show) {
//        this.isShowselectedFlag = show;
//    }
//}
