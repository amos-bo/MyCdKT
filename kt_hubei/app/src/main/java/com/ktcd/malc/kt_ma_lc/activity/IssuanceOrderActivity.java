package com.ktcd.malc.kt_ma_lc.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;

import com.ktcd.malc.baselayer.activity.ToolbarActivity;
import com.ktcd.malc.kt_ma_lc.R;

/**
 * Created by Administrator on 2017/6/28.
 */

public class IssuanceOrderActivity extends ToolbarActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issuance_order);

        initView();
    }

    private void initView() {
        setToolbarColor(ContextCompat.getColor(this, R.color.white));
        setTitle("发布指令");
        setTitleColorRes(R.color.black);
        setTitleTextSize(18);
    }
}
