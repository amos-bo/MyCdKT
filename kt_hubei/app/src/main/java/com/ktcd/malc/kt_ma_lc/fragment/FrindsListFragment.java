//package com.ktcd.malc.kt_ma_lc.fragment;
//
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.content.ContextCompat;
//import android.support.v7.widget.LinearLayoutManager;
//import android.support.v7.widget.RecyclerView;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.RelativeLayout;
//import android.widget.TextView;
//
//import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
//import com.ktcd.malc.baselayer.view.DividerItemDecoration;
//import com.ktcd.malc.kt_ma_lc.R;
//import com.ktcd.malc.kt_ma_lc.adapter.SelcetGroupTypeAdapter;
//import com.ktcd.malc.kt_ma_lc.model.SelectGrunpInfo;
//import com.ktcd.malc.kt_ma_lc.model.SelectPersonInfo;
//import com.ktcd.malc.kt_ma_lc.xmppim.SmackManager;
//import com.ktcd.malc.utilslibrary.tools.ToastUtils;
//import com.orhanobut.logger.Logger;
//
//import org.jivesoftware.smack.roster.RosterEntry;
//import org.jivesoftware.smack.roster.RosterGroup;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;
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
//public class FrindsListFragment extends BaseFragment implements View.OnClickListener {
//
//    @BindView(R.id.tv_title)
//    TextView tvTitle;
//    @BindView(R.id.img_seach)
//    ImageView imgSeach;
//    @BindView(R.id.re_search)
//    RelativeLayout reSearch;
//    @BindView(R.id.recycler_view)
//    RecyclerView recyclerView;
//
//    private SelcetGroupTypeAdapter mSelcetGroupTypeAdapter;
//
//    public static FrindsListFragment newInstance(String type) {
//        FrindsListFragment f = new FrindsListFragment();
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
//        View view = inflater.inflate(R.layout.fregment_frindlist, container, false);
//        mUnBinder = ButterKnife.bind(this, view);
//        return view;
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        initViews();
//    }
//
//    private void initViews() {
//        tvTitle.setText("联系人");
//        LinearLayoutManager mLayoutManager;
//        recyclerView.setLayoutManager(mLayoutManager = new LinearLayoutManager(mContext));
//        mLayoutManager.setStackFromEnd(true);
//        recyclerView.addItemDecoration(new DividerItemDecoration(
//                mContext, DividerItemDecoration.HORIZONTAL_LIST, 2,
//                ContextCompat.getColor(mContext, R.color.assist_3)));
//        mSelcetGroupTypeAdapter = new SelcetGroupTypeAdapter(mContext);
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
//    }
//
//    @Override
//    public void onClick(View view) {
//
//
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        initData();
//    }
//
//    @Override
//    public void onDestroyView() {
//        super.onDestroyView();
//    }
//
//    @OnClick(R.id.re_search)
//    public void onViewClicked() {
//    }
//
//    private void initData() {
//        getFrindList();
//    }
//
//    private void getFrindList() {
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
//                            recyclerView.setAdapter(mSelcetGroupTypeAdapter);
//                        } else {
//                            ToastUtils.showMessage(mContext, "暂无好友");
//                        }
//                    }
//                });
//    }
//}
