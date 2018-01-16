//package com.ktcd.malc.kt_ma_lc.activity;
//
//import android.content.Context;
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.View;
//
//import com.ktcd.malc.baselayer.activity.ToolbarActivity;
//import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
//import com.ktcd.malc.baselayer.view.DividerItemDecoration;
//import com.ktcd.malc.kt_ma_lc.R;
//import com.ktcd.malc.kt_ma_lc.adapter.SelcetGroupTypeAdapter;
//import com.ktcd.malc.kt_ma_lc.model.SelectGrunpInfo;
//import com.ktcd.malc.kt_ma_lc.model.SelectPersonInfo;
//import com.ktcd.malc.kt_ma_lc.xmppim.SmackListenerManager;
//import com.ktcd.malc.kt_ma_lc.xmppim.SmackManager;
//import com.ktcd.malc.kt_ma_lc.xmppim.SmackMultiChatManager;
//import com.ktcd.malc.kt_ma_lc.xmppim.activity.MultiChatActivity;
//import com.ktcd.malc.kt_ma_lc.xmppim.bean.ChatRecord;
//import com.ktcd.malc.kt_ma_lc.xmppim.bean.ChatUser;
//import com.ktcd.malc.kt_ma_lc.xmppim.util.DBQueryHelper;
//import com.ktcd.malc.kt_ma_lc.xmppim.util.IntentHelper;
//import com.ktcd.malc.kt_ma_lc.xmppim.util.LoginHelper;
//import com.ktcd.malc.utilslibrary.tools.ToastUtils;
//import com.orhanobut.logger.Logger;
//
//import org.greenrobot.eventbus.EventBus;
//import org.jivesoftware.smack.roster.RosterEntry;
//import org.jivesoftware.smack.roster.RosterGroup;
//import org.jivesoftware.smackx.muc.MultiUserChat;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import io.reactivex.Observable;
//import io.reactivex.ObservableEmitter;
//import io.reactivex.ObservableOnSubscribe;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.annotations.NonNull;
//import io.reactivex.functions.Consumer;
//import io.reactivex.schedulers.Schedulers;
//
//public class PersonSelectActivity extends ToolbarActivity {
//
//    @BindView(R.id.recyclerview)
//    RecyclerView recyclerview;
//
//
//    private SelcetGroupTypeAdapter mSelcetGroupTypeAdapter;
//    //总人数
//    private List<SelectGrunpInfo> mSelectGrunpInfoList;
//    //选中人
//    private ArrayList<SelectPersonInfo> mSelectedPersonInfoList;
//
//    private String mGroupName;
//
//    private boolean INVITE_MULTICHAT =false;//是创建还是邀请
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_person_select);
//        ButterKnife.bind(this);
//        initViews();
//        initData();
//    }
//
//    private void initViews() {
//        mGroupName = getBundleStringVaule("GroupName");
//        INVITE_MULTICHAT =getBundleBooleanVaule("invite");
//        mSelectedPersonInfoList = new ArrayList<>();
//        setTitle("选择人员");
//        LinearLayoutManager mLayoutManager;
//        recyclerview.setLayoutManager(mLayoutManager = new LinearLayoutManager(mContext));
//        mLayoutManager.setStackFromEnd(true);
//        recyclerview.addItemDecoration(new DividerItemDecoration(
//                mContext, DividerItemDecoration.HORIZONTAL_LIST, 2,
//                ContextCompat.getColor(mContext, R.color.assist_3)));
//        mSelcetGroupTypeAdapter = new SelcetGroupTypeAdapter(mContext);
//        mSelcetGroupTypeAdapter.setShowSelectFlage(true);
//        mSelcetGroupTypeAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//                mSelcetGroupTypeAdapter.getItem(position).isSelected = !mSelcetGroupTypeAdapter.getItem(position).isSelected;
//                mSelcetGroupTypeAdapter.notifyItemChanged(position);
//            }
//
//            @Override
//            public void onItemLongClick(View view, int position) {
//
//            }
//        });
//        addText("完成", ContextCompat.getColor(this, R.color.blue), 18, new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                mSelectedPersonInfoList.clear();
//                for (SelectGrunpInfo item1 : mSelcetGroupTypeAdapter.getList()
//                        ) {
//                    for (SelectPersonInfo item2 : item1.selectPersonInfoList) {
//                        if (item2.isSelected) {
//                            mSelectedPersonInfoList.add(item2);
//                        }
//                    }
//                }
//                if (mSelectedPersonInfoList.size() > 0) {
//                    if(!INVITE_MULTICHAT) {
//                        createMultiChat();
//                    }else{
//                        Bundle bundle=new Bundle();
//                        bundle.putSerializable("Persons",mSelectedPersonInfoList);
//                        setResult(bundle);
//                    }
//                } else {
//                    ToastUtils.showMessage(mContext, "请选择群成员");
//                }
//            }
//        });
//    }
//
//
//    private void initData() {
////        mSelcetGroupTypeAdapter.setList(mSelectGrunpInfoList);
////        recyclerview.setAdapter(mSelcetGroupTypeAdapter);
//        getFrindList();
//
//    }
//
//    private void getFrindList() {
//        // ContactEntity
//        Observable.create(new ObservableOnSubscribe<List<SelectGrunpInfo>>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<List<SelectGrunpInfo>> subscriber) throws Exception {
//                List<RosterGroup> friends = SmackManager.getInstance().getGroupsInfo();
//                List<SelectGrunpInfo> list = new ArrayList<>();
//                for (RosterGroup friend : friends) {
//                    SelectGrunpInfo selectgrunpinfo = new SelectGrunpInfo();
//                    selectgrunpinfo.name = friend.getName();
//                    selectgrunpinfo.stateOnline = "12";
//                    selectgrunpinfo.stateAll = "" + friend.getEntryCount();
//                    selectgrunpinfo.selectPersonInfoList = new ArrayList<SelectPersonInfo>();
//                    for (RosterEntry item : friend.getEntries()) {
//                        SelectPersonInfo selectpersoninfo = new SelectPersonInfo();
//                        selectpersoninfo.name = item.getName();
//                        selectpersoninfo.jid = item.getUser();
//                        selectpersoninfo.imgUrl = "";
//                        selectpersoninfo.state = item.getType().name();
//                        selectgrunpinfo.selectPersonInfoList.add(selectpersoninfo);
//                    }
//                    list.add(selectgrunpinfo);
//                }
//                subscriber.onNext(list);
//                subscriber.onComplete();
//            }
//        })
//                .subscribeOn(Schedulers.io())//指定上面的Subscriber线程
//                .observeOn(AndroidSchedulers.mainThread())//指定下面的回调线程
//                .doOnError(new Consumer<Throwable>() {
//                               @Override
//                               public void accept(@NonNull Throwable throwable) throws Exception {
//                                   Logger.e(throwable, "query contact list failure");
//                                   ToastUtils.showMessage(mContext, "加载好友列表失败");
//                               }
//                           }
//                )
//                .subscribe(new Consumer<List<SelectGrunpInfo>>() {
//                    @Override
//                    public void accept(@NonNull List<SelectGrunpInfo> contactEntities) throws Exception {
//                        if (contactEntities.size() > 0) {
//                            mSelcetGroupTypeAdapter.setList(contactEntities);
//                            recyclerview.setAdapter(mSelcetGroupTypeAdapter);
//                        } else {
//                            ToastUtils.showMessage(mContext, "暂无好友");
//                        }
//                    }
//                });
//    }
//
//    /**
//     * 创建多人聊天
//     */
//    private void createMultiChat() {
//
//        String meNickName = LoginHelper.getUser().getNickname();
////        String chatRoomName = String.format(getString(R.string.text_default_multi_chat_nickname), meNickName);
//        String chatRoomName = mGroupName;
////        String reason = String.format(getString(R.string.text_invite_to_multi_chat), meNickName);
//        String reason = meNickName + "邀请您入群";
//        try {
//            MultiUserChat multiUserChat = SmackManager.getInstance().createChatRoom(chatRoomName, meNickName, null);
//            for (SelectPersonInfo entity : mSelectedPersonInfoList) {
//                String jid = SmackManager.getInstance().getFullJid(entity.jid);
//                multiUserChat.invite(jid, reason);//邀请入群
//            }
//            SmackListenerManager.addMultiChatMessageListener(multiUserChat);
//            SmackMultiChatManager.saveMultiChat(multiUserChat);
//            startMultiChatActivity(this, multiUserChat);
//            finish();
//        } catch (Exception e) {
//            Logger.e(e, "invite friend to chatRoom failure ");
//            ToastUtils.showMessage(mContext, "创建群失败");
//        }
//    }
//
//    private void startMultiChatActivity(Context context, MultiUserChat multiUserChat) {
//        ChatUser chatUser = DBQueryHelper.queryChatUser(multiUserChat);
//        ChatRecord chatRecord = DBQueryHelper.queryChatRecord(chatUser.getUuid());
//        if (chatRecord == null) {
//            chatRecord = new ChatRecord(chatUser);
//        }
//        EventBus.getDefault().post(chatRecord);//发起聊天时，发送一个事件到消息列表界面进行处理，如果不存在此聊天记录则创建一个新的
//        Intent intent;
//        intent = new Intent(context, MultiChatActivity.class);
//        intent.putExtra(IntentHelper.KEY_CHAT_DIALOG, chatUser);
//        startActivity(intent);
//    }
//}
