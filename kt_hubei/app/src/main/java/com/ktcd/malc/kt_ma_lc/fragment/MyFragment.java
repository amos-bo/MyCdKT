package com.ktcd.malc.kt_ma_lc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.applicatoin.KtkjMaLcApplication;
import com.ktcd.malc.kt_ma_lc.bean.LoginBean;
import com.ktcd.malc.utilslibrary.tools.ConfigUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2017/6/27.
 */

public class MyFragment extends BaseFragment {

    @BindView(R.id.my_img_mine)
    ImageView myImgMine;
    @BindView(R.id.my_username)
    TextView myUsername;
    @BindView(R.id.my_post)
    TextView myPost;
    @BindView(R.id.my_institution)
    TextView myInstitution;
    @BindView(R.id.my_phone)
    TextView myPhone;
    @BindView(R.id.my_gps)
    CheckBox myGps;
    @BindView(R.id.my_quit)
    Button myQuit;
    Unbinder unbinder;
    private LoginBean.DataBean dataBean;

    public static MyFragment newInstance(String type, Bundle bundle) {
        MyFragment f = new MyFragment();
        f.setArguments(bundle);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle args = getArguments();
        if (args != null) {
            dataBean = (LoginBean.DataBean) args.getSerializable("data");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initViews();
    }

    private void initViews() {
        myUsername.setText(dataBean.getCpName());
        myInstitution.setText(dataBean.getDepartment().getBdmName());
        myPhone.setText(dataBean.getCpMobile());
        myPost.setText(dataBean.getDepartment().getBdmName());
        if (KtkjMaLcApplication.getInstance().ISCAN_LOC) {
            myGps.setChecked(true);
        } else {
            myGps.setChecked(false);
        }
        myGps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                KtkjMaLcApplication.getInstance().ISCAN_LOC = !KtkjMaLcApplication.getInstance().ISCAN_LOC;
                if (myGps.isChecked()) {
                    KtkjMaLcApplication.getInstance().ISCAN_LOC = true;
                    if (!KtkjMaLcApplication.getInstance().LOCATION_CLIENT.isStarted()) {
                        KtkjMaLcApplication.getInstance().LOCATION_CLIENT.start();
                    }
                } else {
                    KtkjMaLcApplication.getInstance().ISCAN_LOC = false;
                    if (KtkjMaLcApplication.getInstance().LOCATION_CLIENT.isStarted()) {
                        KtkjMaLcApplication.getInstance().LOCATION_CLIENT.stop();
                    }
                }
                ConfigUtils.setIsCanLoc(mContext, KtkjMaLcApplication.getInstance().ISCAN_LOC);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.my_quit)
    public void onViewClicked() {
        ConfigUtils.setUserLogin(mContext, false);
        KtkjMaLcApplication.getInstance().exitApp();
    }
}
