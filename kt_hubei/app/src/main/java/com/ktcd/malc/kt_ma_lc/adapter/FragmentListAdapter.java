package com.ktcd.malc.kt_ma_lc.adapter;

/**
 * Created by heshihai on 2017/1/7.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import java.util.List;

public class FragmentListAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;

    public FragmentListAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        Log.e("xb", "getItem: "+ position);
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

}
