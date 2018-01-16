package com.ktcd.malc.kt_ma_lc.activity;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
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

public class NewResourcesMapSettingActivity extends ToolbarActivity {

    @BindView(R.id.rg_select)
    RadioGroup rgSelect;
    @BindView(R.id.rb_dg_point)
    RadioButton rbDgPoint;
    @BindView(R.id.rb_person)
    RadioButton rbPerson;
    @BindView(R.id.rb_place)
    RadioButton rbPlace;
    @BindView(R.id.framelayout)
    FrameLayout framelayout;
    @BindView(R.id.recyclerview_partment)
    RecyclerView recyclerviewPartment;
    @BindView(R.id.recyclerview_type)
    RecyclerView recyclerviewType;
    @BindView(R.id.tv_reset)
    TextView tvReset;
    @BindView(R.id.tv_ok)
    TextView tvOk;

    public List<ItemMapResoureSelectType> mItemMapResoureSelectTypeDp_Dg;
    public List<ItemMapResoureSelectType> mItemMapResoureSelectTypeLeiXing_Dg;

    public List<ItemMapResoureSelectType> mItemMapResoureSelectTypeDp_Person;
    public List<ItemMapResoureSelectType> mItemMapResoureSelectTypeLeiXing_Person;

    public List<ItemMapResoureSelectType> mItemMapResoureSelectTypeDp_Place;
    public List<ItemMapResoureSelectType> mItemMapResoureSelectTypeLeiXing_Place;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resources_map_setting_new);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        setTitle("信息检索");
        rgSelect.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, @IdRes int i) {
                switch (i) {
                    case R.id.rb_dg_point:

                        break;
                    case R.id.rb_person:

                        break;
                    case R.id.rb_place:

                        break;
                }
            }
        });
    }


    @OnClick({R.id.tv_reset, R.id.tv_ok})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_reset:


                break;
            case R.id.tv_ok:
                selectResultOk();
                break;
        }
    }

    private void selectResultOk() {
        HashMap<Integer, ArrayList<ItemMapResoureSelectType>> myData = new HashMap<>();
        Bundle bundle = new Bundle();
        bundle.putSerializable("DATA", myData);
        setResult(bundle);
    }

}
