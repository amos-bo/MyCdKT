package com.ktcd.malc.kt_ma_lc.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.ktcd.malc.baselayer.activity.ToolbarActivity;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.adapter.FragmentListAdapter;
import com.ktcd.malc.kt_ma_lc.fragment.ResourcesMapDgPointFregment;
import com.ktcd.malc.kt_ma_lc.model.ItemMapResoureSelectType;
import com.ktcd.malc.kt_ma_lc.view.bottomnavigationbar.MyViewPager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResourcesMapSettingActivity extends ToolbarActivity {

    @BindView(R.id.rg_select)
    RadioGroup rgSelect;
    @BindView(R.id.rb_dg_point)
    RadioButton rbDgPoint;
    @BindView(R.id.rb_person)
    RadioButton rbPerson;
    @BindView(R.id.rb_place)
    RadioButton rbPlace;
    @BindView(R.id.viewpager)
    MyViewPager viewpager;
    //切换的页面
    protected List<Fragment> mFragmentList;
    @BindView(R.id.tv_reset)
    TextView tvReset;
    @BindView(R.id.tv_ok)
    TextView tvOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources_map_setting);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setTitle("信息检索");
        initFragment();
        rgSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.rb_dg_point:
//                        reSetShowFregment(0);
                        viewpager.setCurrentItem(0);
                        viewpager.getAdapter().notifyDataSetChanged();
                        break;
                    case R.id.rb_person:
//                        reSetShowFregment(1);
                        viewpager.setCurrentItem(1);
                        viewpager.getAdapter().notifyDataSetChanged();
                        break;
                    case R.id.rb_place:
//                        reSetShowFregment(2);
                        viewpager.setCurrentItem(2);
                        viewpager.getAdapter().notifyDataSetChanged();
                        break;
                }
            }
        });
    }

    private void initFragment() {
        mFragmentList = new ArrayList<>();
        if (getIntent().getExtras()!=null) {
            getIntent().getExtras().getSerializable("DP_AND_DG");
            mFragmentList.add(ResourcesMapDgPointFregment.newInstance("危险点", (ArrayList<ItemMapResoureSelectType>) getIntent().getExtras().getSerializable("DP_AND_DG")));
            mFragmentList.add(ResourcesMapDgPointFregment.newInstance("人员", (ArrayList<ItemMapResoureSelectType>) getIntent().getExtras().getSerializable("DP_AND_DG")));
            mFragmentList.add(ResourcesMapDgPointFregment.newInstance("场所", (ArrayList<ItemMapResoureSelectType>) getIntent().getExtras().getSerializable("DP_AND_DG")));
        }else{
            mFragmentList.add(ResourcesMapDgPointFregment.newInstance("危险点",null));
            mFragmentList.add(ResourcesMapDgPointFregment.newInstance("人员",null));
            mFragmentList.add(ResourcesMapDgPointFregment.newInstance("场所", null));
        }
        viewpager.setAdapter(new FragmentListAdapter(getSupportFragmentManager(), mFragmentList));
        viewpager.setOffscreenPageLimit(1);
        viewpager.setCurrentItem(0);
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @OnClick({R.id.tv_reset, R.id.tv_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_reset:
                for (int i=0;i<mFragmentList.size();i++){
                    ResourcesMapDgPointFregment f=(ResourcesMapDgPointFregment)mFragmentList.get(i);
                    if (f.mItemMapResoureSelectTypeLeiXing!=null) {
                        for (int m = 0; m < f.mItemMapResoureSelectTypeLeiXing.size(); m++) {
                            f.mItemMapResoureSelectTypeLeiXing.get(m).isSelected = false;
                        }
                    }
                    if (f.mItemMapResoureSelectTypeDp!=null) {
                        for (int m = 0; m < f.mItemMapResoureSelectTypeDp.size(); m++) {
                            f.mItemMapResoureSelectTypeDp.get(m).isSelected = false;
                        }
                    }
                    f.upDataShow();
                }
                break;
            case R.id.tv_ok:
                selectResultOk();
                break;
        }
    }

    private void  selectResultOk(){
        HashMap<Integer,ArrayList<ItemMapResoureSelectType>> myData=new HashMap<>();
        List<ItemMapResoureSelectType> dgAlllist=new ArrayList<>();
        List<ItemMapResoureSelectType> dpAlllist=new ArrayList<>();
        for (int i=0;i<mFragmentList.size();i++){
            ResourcesMapDgPointFregment f=(ResourcesMapDgPointFregment)mFragmentList.get(i);
            if (f.mItemMapResoureSelectTypeLeiXing!=null) {
                if (f.mItemMapResoureSelectTypeLeiXing.size() > 0) {
                    dgAlllist.addAll(f.getSelectData().get("subclassList"));
                }
            }
            if (f.mItemMapResoureSelectTypeDp!=null){
                if (f.mItemMapResoureSelectTypeLeiXing.size() > 0) {
                    dpAlllist.addAll(f.getSelectData().get("departmentCodeList"));
                }
            }
        }
        myData.put(1,(ArrayList)dpAlllist);
        myData.put(2,(ArrayList)dgAlllist);
        Bundle bundle=new Bundle();
        bundle.putSerializable("DATA",myData);
        setResult(bundle);
    }

}
