//package com.ktcd.malc.kt_ma_lc.fragment;
//
//import android.app.ListActivity;
//import android.content.Intent;
//import android.graphics.Color;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//
//import com.ktcd.malc.baselayer.view.*;
//
//import android.support.v4.content.ContextCompat;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.text.TextUtils;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.EditText;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
//import com.ktcd.malc.kt_ma_lc.R;
//import com.ktcd.malc.kt_ma_lc.activity.PersonSelectActivity;
//import com.ktcd.malc.kt_ma_lc.adapter.MesssgeInfoAdapter;
//import com.ktcd.malc.kt_ma_lc.dialog.MyAlertDialog;
//import com.ktcd.malc.kt_ma_lc.xmppim.activity.ChatActivity;
//import com.ktcd.malc.kt_ma_lc.xmppim.activity.MultiChatActivity;
//import com.ktcd.malc.kt_ma_lc.xmppim.activity.SearChFriendActivity;
//import com.ktcd.malc.kt_ma_lc.xmppim.bean.ChatMessage;
//import com.ktcd.malc.kt_ma_lc.xmppim.bean.ChatRecord;
//import com.ktcd.malc.kt_ma_lc.xmppim.bean.ChatUser;
//import com.ktcd.malc.kt_ma_lc.xmppim.bean.MultiChatRoom;
//import com.ktcd.malc.kt_ma_lc.xmppim.util.DBHelper;
//import com.ktcd.malc.kt_ma_lc.xmppim.util.DBQueryHelper;
//import com.ktcd.malc.kt_ma_lc.xmppim.util.IntentHelper;
//import com.ktcd.malc.utilslibrary.tools.ConfigUtils;
//import com.ktcd.malc.utilslibrary.tools.ToastUtils;
//import com.orhanobut.logger.Logger;
//import com.yanzhenjie.recyclerview.swipe.SwipeMenu;
//import com.yanzhenjie.recyclerview.swipe.SwipeMenuBridge;
//import com.yanzhenjie.recyclerview.swipe.SwipeMenuCreator;
//import com.yanzhenjie.recyclerview.swipe.SwipeMenuItem;
//import com.yanzhenjie.recyclerview.swipe.SwipeMenuItemClickListener;
//import com.yanzhenjie.recyclerview.swipe.SwipeMenuRecyclerView;
//
//import org.greenrobot.eventbus.EventBus;
//import org.greenrobot.eventbus.Subscribe;
//import org.greenrobot.eventbus.ThreadMode;
//import org.jivesoftware.smack.packet.Message;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import io.reactivex.Observable;
//import io.reactivex.ObservableEmitter;
//import io.reactivex.ObservableOnSubscribe;
//import io.reactivex.android.schedulers.AndroidSchedulers;
//import io.reactivex.annotations.NonNull;
//import io.reactivex.functions.Consumer;
//import io.reactivex.schedulers.Schedulers;
//
//
///**
// * Created by xiangbo on 2017/6/17.
// * 工作台fragment
// */
//
//public class MessgeFragment extends BaseFragment implements View.OnClickListener {
//    private TextView mPageTitie;
//    private ImageView mAddFuc;
//
//    private RelativeLayout mRelaSearch;
//    private SwipeMenuRecyclerView mRecyclerView;
//    private List<ChatRecord> mItemMessgeInfoList;
//
//    private MesssgeInfoAdapter mMesssgeInfoAdapter;
//    private LinearLayoutManager mLayoutManager;
//    private HashMap<String, Integer> mMap = new HashMap<>();//聊天用户的用户名与用户聊天记录Position的映射关系
//
//    public static MessgeFragment newInstance(String type) {
//        MessgeFragment f = new MessgeFragment();
//        Bundle b = new Bundle();
//        b.putSerializable("DATA", type);
//        f.setArguments(b);
//        return f;
//    }
//
//    @SuppressWarnings("unchecked")
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        Bundle args = getArguments();
//        if (args != null) {
//
//        }
//    }
//
//    @Override
//    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_messgess, container, false);
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        EventBus.getDefault().register(this);
//        initViews();
//        initData();
////        SmackListenerManager.addGlobalListener();
//    }
//
//    private void initViews() {
//        mPageTitie = (TextView) getActivity().findViewById(R.id.tv_title);
//        mAddFuc = (ImageView) getActivity().findViewById(R.id.img_messge_add);
//
//        mRelaSearch = (RelativeLayout) getActivity().findViewById(R.id.re_search);
//        mRecyclerView =getActivity().findViewById(R.id.recycler_view1);
//
//        mRecyclerView.setLayoutManager(mLayoutManager = new LinearLayoutManager(mContext));
//        mRecyclerView.addItemDecoration(new DividerItemDecoration(
//                mContext, DividerItemDecoration.HORIZONTAL_LIST, 2,
//                ContextCompat.getColor(mContext, R.color.assist_3)));
//        mAddFuc.setOnClickListener(this);
//        //侧滑RecyclerView
//        mRecyclerView.setSwipeMenuCreator(swipeMenuCreator);
//        mRecyclerView.setSwipeMenuItemClickListener(mMenuItemClickListener);
//
//    }
//
//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.img_messge_add:
//                try {
//                    final MyAlertDialog alertDialog = new MyAlertDialog.Builder(mContext)
//                            .setContentView(R.layout.sim_dialog_add_functoin)
//                            .show();
//                    //操作特有的对象 getview()  ListView等
//                    final TextView tvGroupName = alertDialog.getView(R.id.tv_add_group_name);
//                    final TextView tvFriend = alertDialog.getView(R.id.tv_add_frind);
//                    final TextView tvGroup = alertDialog.getView(R.id.tv_add_group);
//                    tvGroupName.setVisibility(View.GONE);
//                    //dialog去操作点击事件
//                    alertDialog.setOnClickListener(R.id.tv_add_group_name, new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            alertDialog.dismiss();
//
//                            startActivity(PersonSelectActivity.class);
//                        }
//                    });
//                    alertDialog.setOnClickListener(R.id.tv_add_frind, new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            startActivity(SearChFriendActivity.class);
//                            alertDialog.dismiss();
//                        }
//                    });
//                    alertDialog.setOnClickListener(R.id.tv_add_group, new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            alertDialog.dismiss();
//                            final MyAlertDialog alertDialog2 = new MyAlertDialog.Builder(mContext)
//                                    .setContentView(R.layout.sim_dialog_groupname)
//                                    .fullWidth().show();
//                            final TextView tvName = alertDialog2.getView(R.id.tv_name);
//                            final EditText etname = alertDialog2.getView(R.id.et_name);
//                            tvName.setText("新建群名称:");
//                            //dialog去操作点击事件
//                            alertDialog2.setOnClickListener(R.id.bt_ok, new View.OnClickListener() {
//                                @Override
//                                public void onClick(View v) {
//                                    alertDialog2.dismiss();
//                                    final String name = etname.getText().toString().trim();
//                                    if (!TextUtils.isEmpty(name)) {
//                                        Bundle bundle = new Bundle();
//                                        bundle.putString("GroupName", name);
//                                        startActivity(PersonSelectActivity.class, bundle);
//
//                                    } else {
//                                        ToastUtils.showMessage(mContext, "群名称不能为空");
//                                    }
//                                }
//                            });
//                        }
//                    });
//                } catch (Exception e) {
//                    ToastUtils.showMessage(mContext, "操作失败，请配置及时通讯服务器");
//                }
//
//                break;
//            case R.id.re_search:
//
//                break;
//        }
//
//    }
//
//    public void initData() {
//        Observable.create(new ObservableOnSubscribe<ArrayList<ChatRecord>>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<ArrayList<ChatRecord>> e) throws Exception {
//                ArrayList<ChatRecord> list = (ArrayList<ChatRecord>) DBQueryHelper.queryChatRecord();
//                e.onNext(list);
//                e.onComplete();
//            }
//        }).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnError(new Consumer<Throwable>() {
//                    @Override
//                    public void accept(@NonNull Throwable throwable) throws Exception {
//                        Logger.e(throwable, "get chat record failure");
//                    }
//                })
//                .subscribe(new Consumer<List<ChatRecord>>() {
//                    @Override
//                    public void accept(@NonNull List<ChatRecord> chatRecords) throws Exception {
//                        mItemMessgeInfoList = chatRecords;
//                        mMesssgeInfoAdapter = new MesssgeInfoAdapter(mContext);
//                        mMesssgeInfoAdapter.setList(chatRecords);
//                        mRecyclerView.setAdapter(mMesssgeInfoAdapter);
//                        mMesssgeInfoAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
//                            @Override
//                            public void onItemClick(View view, int position) {
//                                ChatUser chatUser = mMesssgeInfoAdapter.getItem(position);
//                                Intent intent;
//                                if (chatUser.getChatJid().contains("conference")) {
//                                    intent = new Intent(mContext, MultiChatActivity.class);
//                                } else {
//                                    if (chatUser.getFileJid().contains("Smack")) {
//                                        chatUser.setFileJid(chatUser.getChatJid() + "/Smack");//发送图片BUG
//                                    }
//                                    intent = new Intent(mContext, ChatActivity.class);
//                                }
//                                //红点逻辑
//                                ChatRecord chatrecord = mMesssgeInfoAdapter.getItem(position);
//                                chatrecord.setUnReadMessageCount(0);
//                                mMesssgeInfoAdapter.update(chatrecord);
//                                DBHelper.getInstance().getSQLiteDB().update(chatrecord);//更新数据库中的记录
//                                intent.putExtra(IntentHelper.KEY_CHAT_DIALOG, chatUser);
//                                startActivity(intent);
//                            }
//
//                            @Override
//                            public void onItemLongClick(View view, int position) {
//
//                            }
//                        });
//                    }
//                });
//    }
//
//
//    @Override
//    public void onResume() {
//        super.onResume();
//    }
//
//    @Override
//    public void onDestroyView() {
//
//        super.onDestroyView();
//        EventBus.getDefault().unregister(this);
//        mMesssgeInfoAdapter = null;
//        mMap.clear();
//    }
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onChatRecordEvent(ChatRecord event) {
//        //向其他人发起聊天时接收到的事件
//        if (isRemoving() || mMesssgeInfoAdapter == null) {
//            return;
//        }
//        if (mMesssgeInfoAdapter.getList().indexOf(event) > -1) {
//            return;//已经存在此人的聊天窗口记录
//        }
//        addChatRecord(event);
//    }
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onReceiveChatMessageEvent(ChatMessage message) {
//        //收到发送的消息时接收到的事件(包括别人发送的和自己发送的消息)
//        if (isRemoving() || mMesssgeInfoAdapter == null) {
//            return;
//        }
//        ChatRecord chatRecord = getChatRecord(message);
//        if (chatRecord == null) {//还没有创建此朋友的聊天记录
//            chatRecord = new ChatRecord(message);
//            addChatRecord(chatRecord);
//        } else {
//            chatRecord.setChatTime(message.getDatetime());
//            chatRecord.setLastMessage(message.getContent());
//
//            ChatMessage isSaved = DBHelper.getInstance().getSQLiteDB().queryOne(ChatMessage.class, "messageId=?", new String[]{message.getMessageId()});
//            if (isSaved == null) {
//                chatRecord.updateUnReadMessageCount();
//            }
//            mMesssgeInfoAdapter.update(chatRecord);
//            mMesssgeInfoAdapter.notifyDataSetChanged();//TODO 解决错乱BUG
//            DBHelper.getInstance().getSQLiteDB().update(chatRecord);//更新数据库中的记录
//        }
//    }
//
//    private void addChatRecord(ChatRecord chatRecord) {
//        mMesssgeInfoAdapter.add(chatRecord, 0);
//        mMesssgeInfoAdapter.notifyDataSetChanged();//TODO 解决错乱BUG
//        DBHelper.getInstance().getSQLiteDB().save(chatRecord);
//        mLayoutManager.scrollToPosition(0);
//        for (String key : mMap.keySet()) {//创建新的聊天记录之后，需要将之前的映射关系进行更新
//            mMap.put(key, mMap.get(key) + 1);
//        }
//    }
//
//    /**
//     * 根据消息获取聊天记录窗口对象
//     *
//     * @param message
//     * @return
//     */
//    private ChatRecord getChatRecord(ChatMessage message) {
//
//        ChatRecord chatRecord = null;
//        if (mMap.containsKey(message.getFriendUsername())) {
//            chatRecord = mMesssgeInfoAdapter.getList().get(mMap.get(message.getFriendUsername()));
//        } else {
//            for (int i = 0; i < mMesssgeInfoAdapter.getList().size(); i++) {
//                chatRecord = mMesssgeInfoAdapter.getList().get(i);
//                if (chatRecord.getMeUsername().equals(message.getMeUsername()) &&
//                        chatRecord.getFriendUsername().equals(message.getFriendUsername())) {
//                    mMap.put(message.getFriendUsername(), i);
//                    break;
//                } else {
//                    chatRecord = null;
//                }
//            }
//        }
//        return chatRecord;
//    }
//
////===================================侧滑删除==================================//
//    /**
//     * 菜单创建器，在Item要创建菜单的时候调用。
//     */
//    private SwipeMenuCreator swipeMenuCreator = new SwipeMenuCreator() {
//        @Override
//        public void onCreateMenu(SwipeMenu swipeLeftMenu, SwipeMenu swipeRightMenu, int viewType) {
//            int width = getResources().getDimensionPixelSize(R.dimen.dp_70);
//            // 1. MATCH_PARENT 自适应高度，保持和Item一样高;
//            // 2. 指定具体的高，比如80;
//            // 3. WRAP_CONTENT，自身高度，不推荐;
//            int height = ViewGroup.LayoutParams.MATCH_PARENT;
//            // 添加右侧的，如果不添加，则右侧不会出现菜单。
//            SwipeMenuItem deleteItem = new SwipeMenuItem(mContext)
//                    .setBackground(R.drawable.sim_selector_red)
//                    .setImage(R.mipmap.sim_ic_action_delete)
//                    .setText("删除")
//                    .setTextColor(Color.WHITE)
//                    .setWidth(width)
//                    .setHeight(height);
//            swipeRightMenu.addMenuItem(deleteItem);// 添加菜单到右侧。
//        }
//    };
//    /**
//     * RecyclerView的Item的Menu点击监听。
//     */
//    private SwipeMenuItemClickListener mMenuItemClickListener = new SwipeMenuItemClickListener() {
//        @Override
//        public void onItemClick(SwipeMenuBridge menuBridge) {
//            menuBridge.closeMenu();
//            int direction = menuBridge.getDirection(); // 左侧还是右侧菜单。
//            final int adapterPosition = menuBridge.getAdapterPosition(); // RecyclerView的Item的position。
//            int menuPosition = menuBridge.getPosition(); // 菜单在RecyclerView的Item中的Position。
//            if (direction == SwipeMenuRecyclerView.RIGHT_DIRECTION) {
//                if (!mMesssgeInfoAdapter.getItem(adapterPosition).getFriendUsername().contains("@conference")){
//                    DBHelper.getInstance().getSQLiteDB().delete(mMesssgeInfoAdapter.getItem(adapterPosition));
//                    DBHelper.getInstance().getSQLiteDB().delete(ChatUser.class, "friendUserName=?", new String[]{mMesssgeInfoAdapter.getItem(adapterPosition).getFriendUsername()});
//                    DBHelper.getInstance().getSQLiteDB().delete(ChatMessage.class, "friendUserName=?", new String[]{mMesssgeInfoAdapter.getItem(adapterPosition).getFriendUsername()});
//                    mMesssgeInfoAdapter.getList().remove(adapterPosition);
//                    mMesssgeInfoAdapter.notifyItemRemoved(adapterPosition);
//                    mMesssgeInfoAdapter.notifyDataSetChanged();
//                }else{
//                    //群聊
//                    final MyAlertDialog alertDialog = new MyAlertDialog.Builder(mContext)
//                            .setContentView(R.layout.sim_dialog_exit_muchint)
//                            .show();
//                    //dialog去操作点击事件
//                    alertDialog.setOnClickListener(R.id.btn_ok, new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            alertDialog.dismiss();
//                            DBHelper.getInstance().getSQLiteDB().delete(mMesssgeInfoAdapter.getItem(adapterPosition));
//                            DBHelper.getInstance().getSQLiteDB().delete(ChatUser.class, "friendUserName=?", new String[]{mMesssgeInfoAdapter.getItem(adapterPosition).getFriendUsername()});
//                            DBHelper.getInstance().getSQLiteDB().delete(ChatMessage.class, "friendUserName=?", new String[]{mMesssgeInfoAdapter.getItem(adapterPosition).getFriendUsername()});
//                            DBHelper.getInstance().getSQLiteDB().delete(MultiChatRoom.class, "roomJid=?", new String[]{mMesssgeInfoAdapter.getItem(adapterPosition).getFriendUsername()});
//                            mMesssgeInfoAdapter.getList().remove(adapterPosition);
//                            mMesssgeInfoAdapter.notifyItemRemoved(adapterPosition);
//                            mMesssgeInfoAdapter.notifyDataSetChanged();
//                        }
//                    });
//                    alertDialog.setOnClickListener(R.id.btn_no, new View.OnClickListener() {
//                        @Override
//                        public void onClick(View v) {
//                            alertDialog.dismiss();
//                        }
//                    });
//                }
//            }
//        }
//    };
//
//}
