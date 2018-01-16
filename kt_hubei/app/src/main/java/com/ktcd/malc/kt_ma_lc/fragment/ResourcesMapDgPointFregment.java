package com.ktcd.malc.kt_ma_lc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.utils.CoordinateConverter;
import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.activity.EventListActivity;
import com.ktcd.malc.kt_ma_lc.activity.InstructManagementActivity;
import com.ktcd.malc.kt_ma_lc.activity.NoticeActivity;
import com.ktcd.malc.kt_ma_lc.activity.ResourcesMapActivity;
import com.ktcd.malc.kt_ma_lc.adapter.HomeWorkTypesAdapter;
import com.ktcd.malc.kt_ma_lc.adapter.MapResourceSetingtFregmentDgpointAdapter;
import com.ktcd.malc.kt_ma_lc.applicatoin.ApiPathUrl;
import com.ktcd.malc.kt_ma_lc.applicatoin.KtkjMaLcApplication;
import com.ktcd.malc.kt_ma_lc.baiduloc.BaiduLocResult;
import com.ktcd.malc.kt_ma_lc.baiduloc.LocationClientConfig;
import com.ktcd.malc.kt_ma_lc.baiduloc.LocationListener;
import com.ktcd.malc.kt_ma_lc.bean.LoginBean;
import com.ktcd.malc.kt_ma_lc.model.HomeWeatherInfo;
import com.ktcd.malc.kt_ma_lc.model.ItemHomeTypeInfo;
import com.ktcd.malc.kt_ma_lc.model.ItemMapResoureSelectType;
import com.ktcd.malc.utilslibrary.net.KtkjError;
import com.ktcd.malc.utilslibrary.net.MyRetrofit;
import com.ktcd.malc.utilslibrary.net.ResponseCallBack;
import com.ktcd.malc.utilslibrary.tools.ConfigUtils;
import com.ktcd.malc.utilslibrary.tools.DateTimeUtils;
import com.ktcd.malc.utilslibrary.tools.FileUtils;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/10/17.
 */

public class ResourcesMapDgPointFregment extends BaseFragment {


    private TextView mTvPartOne;
    private TextView mTvPartTwo;
    private RecyclerView mRecyclerViewOne;
    private RecyclerView mRecyclerViewTwo;

    private MapResourceSetingtFregmentDgpointAdapter mMapResourceSetingtFregmentDgpointAdapterOne;
    private MapResourceSetingtFregmentDgpointAdapter mMapResourceSetingtFregmentDgpointAdapterTwo;

    public List<ItemMapResoureSelectType> mItemMapResoureSelectTypeDp;
    public List<ItemMapResoureSelectType> mItemMapResoureSelectTypeLeiXing;

    private ArrayList<ItemMapResoureSelectType> mSelectPush;

    String name;

    public static ResourcesMapDgPointFregment newInstance(String type,ArrayList<ItemMapResoureSelectType> typeData) {
        ResourcesMapDgPointFregment f = new ResourcesMapDgPointFregment();
        Bundle b = new Bundle();
        b.putString("Type", type);
        if (typeData!=null) {
            b.putSerializable("DP_AND_DG", typeData);
        }
        f.setArguments(b);
        return f;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            name = args.getString("Type");
            if (args.getSerializable("DP_AND_DG")!=null) {
                mSelectPush=(ArrayList<ItemMapResoureSelectType>)args.getSerializable("DP_AND_DG");
            }
        }
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = (LinearLayout) inflater.inflate(R.layout.fregment_resourcesmap_dgpoint, container, false);
        mTvPartOne = (TextView) view.findViewById(R.id.tv_part_one);
        mTvPartTwo = (TextView) view.findViewById(R.id.tv_part_two);
        mRecyclerViewOne = (RecyclerView)view.findViewById(R.id.recyclerview_partment);
        mRecyclerViewTwo = (RecyclerView)view.findViewById(R.id.recyclerview_type);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (mItemMapResoureSelectTypeLeiXing==null) {
            initView();
            initData();
        }else{
            initView();
            mMapResourceSetingtFregmentDgpointAdapterTwo.setList(mItemMapResoureSelectTypeLeiXing);
            mMapResourceSetingtFregmentDgpointAdapterTwo.notifyDataSetChanged();
            mMapResourceSetingtFregmentDgpointAdapterOne.setList(mItemMapResoureSelectTypeDp);
            mMapResourceSetingtFregmentDgpointAdapterOne.notifyDataSetChanged();
        }
    }


    @Override
    public void onResume() {
        super.onResume();
    }

    private void initView() {
        mRecyclerViewOne.setLayoutManager(new GridLayoutManager(mContext, 4));
        mRecyclerViewTwo.setLayoutManager(new GridLayoutManager(mContext, 4));
        mMapResourceSetingtFregmentDgpointAdapterOne = new MapResourceSetingtFregmentDgpointAdapter(mContext);
        mMapResourceSetingtFregmentDgpointAdapterOne.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mItemMapResoureSelectTypeDp.get(position).isSelected = !mItemMapResoureSelectTypeDp.get(position).isSelected;
                mMapResourceSetingtFregmentDgpointAdapterOne.notifyItemChanged(position);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

        mMapResourceSetingtFregmentDgpointAdapterTwo = new MapResourceSetingtFregmentDgpointAdapter(mContext);
        mMapResourceSetingtFregmentDgpointAdapterTwo.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mItemMapResoureSelectTypeLeiXing.get(position).isSelected = !mItemMapResoureSelectTypeLeiXing.get(position).isSelected;
                mMapResourceSetingtFregmentDgpointAdapterTwo.notifyItemChanged(position);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });
        mRecyclerViewOne.setAdapter(mMapResourceSetingtFregmentDgpointAdapterOne);
        mRecyclerViewTwo.setAdapter(mMapResourceSetingtFregmentDgpointAdapterTwo);
    }

    private void initData() {
        mMapResourceSetingtFregmentDgpointAdapterOne.notifyDataSetChanged();
        mMapResourceSetingtFregmentDgpointAdapterTwo.notifyDataSetChanged();
        initSelectDate();
//        initDataDp();
    }


    private void initSelectDate() {

        Map<String, String> mapKeyDg = new HashMap<>();
        Map<String, String> mapKeyPlace = new HashMap<>();
        Map<String, String> mapPersonPlace = new HashMap<>();

        mapKeyDg.put("type", "risk_point");
        mapKeyPlace.put("type", "place");
        mapPersonPlace.put("type", "department");


        Map<String, String> mapKeyDgDp = new HashMap<>();
        Map<String, String> mapKeyPlaceDp = new HashMap<>();
        Map<String, String> mapPersonPlacedp = new HashMap<>();


          mapKeyDgDp.put("type", "department");
//        mapKeyPlaceDp.put("type", "department");
//        mapPersonPlacedp.put("type", "department");


        Map<String, String> mMapData = null;
        Map<String, String> mMapDataDp = null;
        if (name.equals("危险点")) {
            mMapData = mapKeyDg;
            mMapDataDp = mapKeyDgDp;
        } else if (name.equals("场所")) {
            mMapData = mapKeyPlace;
            mMapDataDp = mapKeyDgDp;
        }else{

        }
        final Map<String, String> finalMMapDataDp = mMapDataDp;
//        MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://192.168.0.200:5555/pointCache/basicDataService/getBasicDataServiceType", mMapData, new ResponseCallBack<ItemMapResoureSelectType>() {
        MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://lgrjian.gicp.net:12787/pointCache/basicDataService/getBasicDataServiceType", mMapData, new ResponseCallBack<ItemMapResoureSelectType>() {
            @Override
            protected void onLoad(Disposable d) {

            }

            @Override
            protected void onError(KtkjError error) {
                Log.e("xb","类型："+name);
            }

            @Override
            protected void onSuccess(ItemMapResoureSelectType result) {

            }

            @Override
            protected void onSuccessList(Object result) {
                mItemMapResoureSelectTypeLeiXing = (ArrayList<ItemMapResoureSelectType>) result;
                mMapResourceSetingtFregmentDgpointAdapterTwo.setList(mItemMapResoureSelectTypeLeiXing);
                mMapResourceSetingtFregmentDgpointAdapterTwo.notifyDataSetChanged();
//                MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://192.168.0.200:5555/user/dictionary/getAllDictionaryByType", finalMMapDataDp, new ResponseCallBack<ItemMapResoureSelectType>() {
                MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://lgrjian.gicp.net:12787/user/dictionary/getAllDictionaryByType", finalMMapDataDp, new ResponseCallBack<ItemMapResoureSelectType>() {
                    @Override
                    protected void onLoad(Disposable d) {

                    }

                    @Override
                    protected void onError(KtkjError error) {
                        Log.e("xb","部门："+name);
                    }

                    @Override
                    protected void onSuccess(ItemMapResoureSelectType result) {


                    }

                    @Override
                    protected void onSuccessList(Object result) {
                        mItemMapResoureSelectTypeDp = (ArrayList<ItemMapResoureSelectType>) result;
                        if (mSelectPush!=null) {
                            for (int i = 0; i < mSelectPush.size(); i++){
                                ItemMapResoureSelectType item=mSelectPush.get(i);
                                if (item!=null){
                                    for (int m=0;m<mItemMapResoureSelectTypeDp.size();m++){
                                        if (item.getName().equals(mItemMapResoureSelectTypeDp.get(m).getName())){
                                            mItemMapResoureSelectTypeDp.get(m).isSelected=true;
                                        }
                                    }
                                    for (int n=0;n<mItemMapResoureSelectTypeLeiXing.size();n++){
                                        if (item.getName().equals(mItemMapResoureSelectTypeLeiXing.get(n).getName())){
                                            mItemMapResoureSelectTypeLeiXing.get(n).isSelected=true;
                                        }
                                    }
                                }
                            }
                        }
                        mMapResourceSetingtFregmentDgpointAdapterOne.setList(mItemMapResoureSelectTypeDp);
                        mMapResourceSetingtFregmentDgpointAdapterOne.notifyDataSetChanged();
                        mMapResourceSetingtFregmentDgpointAdapterTwo.notifyDataSetChanged();
                    }
                });
            }
        });
    }

    /***
     * 获取选中数据
     * @return
     */
    public Map<String,ArrayList<ItemMapResoureSelectType>>getSelectData() {
        ArrayList<ItemMapResoureSelectType> selectTypesList = new ArrayList<>();
        ArrayList<ItemMapResoureSelectType> selectDpList = new ArrayList<>();
        for (ItemMapResoureSelectType item : mItemMapResoureSelectTypeLeiXing) {
            if (item.isSelected) {
                if (item.getBasicDataDerviceCode().equals("subside")) {
                    item.Type = 1;
                } else if (item.getBasicDataDerviceCode().equals("collapse")) {
                    item.Type = 2;
                } else if (item.getBasicDataDerviceCode().equals("landslide")) {
                    item.Type = 3;
                } else if (item.getBasicDataDerviceCode().equals("smallRiver")) {
                    item.Type = 4;
                } else if (item.getBasicDataDerviceCode().equals("flashFlood")) {
                    item.Type = 5;
                } else if (item.getBasicDataDerviceCode().equals("debrisFlow")) {
                    item.Type = 6;
                } else if (item.getBasicDataDerviceCode().equals("shelter")) {
                    item.Type = 8;
                }
                selectTypesList.add(item);
            }
        }
        if (mItemMapResoureSelectTypeDp!=null) {
            for (ItemMapResoureSelectType item : mItemMapResoureSelectTypeDp) {
                if (item.isSelected) {
                    selectDpList.add(item);
                }
            }
        }
        Map<String,ArrayList<ItemMapResoureSelectType>> map=new HashMap<>();
        map.put("subclassList",selectTypesList);
        map.put("departmentCodeList",selectDpList);
        return map;
    }

    public void upDataShow() {
        mMapResourceSetingtFregmentDgpointAdapterTwo.notifyDataSetChanged();
        mMapResourceSetingtFregmentDgpointAdapterOne.notifyDataSetChanged();
    }


//    public void initDataDp() {
//        Observable.zip(getObservableType(null), getObservableDp(null),
//                new BiFunction<ArrayList<ItemMapResoureSelectType>, ArrayList<ItemMapResoureSelectType>, HashMap<String, ArrayList<ItemMapResoureSelectType>>>() {
//                    @Override
//                    public HashMap<String, ArrayList<ItemMapResoureSelectType>> apply(ArrayList<ItemMapResoureSelectType> baseInfo, ArrayList<ItemMapResoureSelectType> extraInfo) throws Exception {
//                        HashMap<String, ArrayList<ItemMapResoureSelectType>> map = new HashMap<String, ArrayList<ItemMapResoureSelectType>>();
//                        map.put("1", baseInfo);
//                        map.put("2", extraInfo);
//                        return map;
//                    }
//                })
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Consumer<HashMap<String, ArrayList<ItemMapResoureSelectType>>>() {
//                    @Override
//                    public void accept(HashMap<String, ArrayList<ItemMapResoureSelectType>> userInfo) throws Exception {
//                        mMapResourceSetingtFregmentDgpointAdapterOne.setList(userInfo.get("1"));
//                        mMapResourceSetingtFregmentDgpointAdapterTwo.setList(userInfo.get("2"));
//                        mMapResourceSetingtFregmentDgpointAdapterOne.notifyDataSetChanged();
//                        mMapResourceSetingtFregmentDgpointAdapterTwo.notifyDataSetChanged();
//                    }
//                });
//    }
//
//    private Observable<ArrayList<ItemMapResoureSelectType>> getObservableType(@NonNull Object tempObject) {
//        return Observable.fromCallable(new Callable<ArrayList<ItemMapResoureSelectType>>() {
//            @Override
//            public ArrayList<ItemMapResoureSelectType> call() throws Exception {
//
//                Map<String, String> mapKeyDg = new HashMap<>();
//                Map<String, String> mapKeyPlace = new HashMap<>();
//                Map<String, String> mapPersonPlace = new HashMap<>();
//
//                mapKeyDg.put("type", "risk_point");
//                mapKeyPlace.put("type", "place");
//                mapPersonPlace.put("type", "department");
//                Map<String, String> mMapData = null;
//                if (name.equals("危险点")) {
//                    mMapData = mapKeyDg;
//                } else if (name.equals("场所")) {
//                    mMapData = mapKeyPlace;
//                } else {
//                    mMapData = mapPersonPlace;
//                }
//
//                MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://192.168.0.134:5555/pointCache/basicDataService/getBasicDataServiceType", mMapData, new ResponseCallBack<ItemMapResoureSelectType>() {
//                    @Override
//                    protected void onLoad(Disposable d) {
//
//                    }
//
//                    @Override
//                    protected void onError(KtkjError error) {
//
//                    }
//
//                    @Override
//                    protected void onSuccess(ItemMapResoureSelectType result) {
//
//                    }
//
//                    @Override
//                    protected void onSuccessList(Object result) {
//                        mItemMapResoureSelectTypeLeiXing = (ArrayList<ItemMapResoureSelectType>) result;
//
//                    }
//                });
//                return new ArrayList<ItemMapResoureSelectType>();
//            }
//        });
//    }

//    private Observable<ArrayList<ItemMapResoureSelectType>> getObservableDp(@NonNull Object tempObject) {
//
//        return Observable.fromCallable(new Callable<ArrayList<ItemMapResoureSelectType>>() {
//                                           @Override
//                                           public ArrayList<ItemMapResoureSelectType> call() throws Exception {
//                                               Map<String, String> mapKeyDgDp = new HashMap<>();
//                                               Map<String, String> mapKeyPlaceDp = new HashMap<>();
//                                               Map<String, String> mapPersonPlacedp = new HashMap<>();
//
//                                               Map<String, String> mMapDataDp = null;
//                                               if (name.equals("危险点")) {
//                                                   mMapDataDp = mapKeyDgDp;
//                                               } else if (name.equals("场所")) {
//                                                   mMapDataDp = mapKeyPlaceDp;
//                                               } else {
//                                                   mMapDataDp = mapPersonPlacedp;
//                                               }
//
//                                               MyRetrofit.StartQueryNetByAllPath(mContext, false, "http://192.168.0.134:5555/sysBasicData/dictionary/getAllDictionaryByType", mMapDataDp, new ResponseCallBack<ItemMapResoureSelectType>() {
//                                                   @Override
//                                                   protected void onLoad(Disposable d) {
//
//                                                   }
//
//                                                   @Override
//                                                   protected void onError(KtkjError error) {
//
//                                                   }
//
//                                                   @Override
//                                                   protected void onSuccess(ItemMapResoureSelectType result) {
//
//
//                                                   }
//
//                                                   @Override
//                                                   protected void onSuccessList(Object result) {
//                                                       mItemMapResoureSelectTypeDp = (ArrayList<ItemMapResoureSelectType>) result;
//                                                   }
//                                               });
//                                               return (ArrayList<ItemMapResoureSelectType>) mItemMapResoureSelectTypeDp;
//                                           }
//                                       }
//        );
//    }
}

