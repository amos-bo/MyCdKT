package com.ktcd.malc.kt_ma_lc.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;

import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.applicatoin.KtkjMaLcApplication;

import com.ktcd.malc.kt_ma_lc.fragment.MyFragment;
import com.ktcd.malc.kt_ma_lc.fragment.WorkBenchFragment;
import com.ktcd.malc.kt_ma_lc.view.bottomnavigationbar.BadgeItem;
import com.ktcd.malc.kt_ma_lc.view.bottomnavigationbar.BottomNavigationBar;
import com.ktcd.malc.kt_ma_lc.view.bottomnavigationbar.BottomNavigationItem;
import com.ktcd.malc.utilslibrary.tools.ConfigUtils;

import java.util.ArrayList;
import java.util.List;

@RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
public class HomeTabActivity extends FragmentActivity implements BottomNavigationBar.OnTabSelectedListener {

    //数字红点
    protected BadgeItem mNumberBadgeItem;
    //切换的页面
    protected ArrayList<Fragment> mFragmentList;
    //页面标题
    protected ArrayList<String> mTitiles;
    //底部栏
    protected BottomNavigationBar mBottomNavigationBar;

    protected BottomNavigationItem mCustermerBottomNavigationItem;

    protected int SELECTED_LAST_PAGE = 0;

    protected String[] needPermissions = {
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.READ_PHONE_STATE,
            Manifest.permission.CAMERA,
            Manifest.permission.RECORD_AUDIO,

    };
    //判断是否需要检测，防止不停的弹框
    private boolean isNeedCheck = true;
    private static final int PERMISSON_REQUESTCODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_tab);
        initBottomNavigation();
//        StatusBarUtil.ToolBarSteep(this);
    }

    private void initBottomNavigation() {
        KtkjMaLcApplication.getInstance().ISCAN_LOC= ConfigUtils.getIsCanLoc(HomeTabActivity.this);
        initFragment();
        mNumberBadgeItem = new BadgeItem();
        mBottomNavigationBar = (BottomNavigationBar) findViewById(R.id
                .bottom_navigation_bar);
        mBottomNavigationBar.clearAll();
        mBottomNavigationBar.setTabSelectedListener(this);
        mNumberBadgeItem = new BadgeItem().setBorderWidth(4)
                .setBackgroundColorResource(R.color.colorAccent).setText("" + 9).setHideOnSelect(false);
        mNumberBadgeItem.hide();
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        mBottomNavigationBar.setBackgroundStyle(BottomNavigationBar
                .BACKGROUND_STYLE_STATIC);
        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap
                        .home_tab_work_selected, "工作台").setActiveColorResource(R.color.blue)
                        .setInactiveIcon(getResources().getDrawable(R.mipmap.home_tab__work_normal
                        )).setInActiveColorResource(R.color.assist_1))
                .addItem(mCustermerBottomNavigationItem = new
                        BottomNavigationItem(R.mipmap.home_tab_news_selected, "消息")
                        .setActiveColorResource(R.color.blue).setInactiveIcon(getResources
                                ().getDrawable(R.mipmap.home_tab_news_normal))
                        .setInActiveColorResource(R.color.assist_1).setBadgeItem(mNumberBadgeItem))
                .addItem(new BottomNavigationItem(R.mipmap.home_tab_friends_selected, "联系人").setActiveColorResource(R.color.blue)
                        .setInactiveIcon(getResources().getDrawable(R.mipmap.home_tab_friends_normal)).setInActiveColorResource(R.color.assist_1)
                )
                .addItem(new BottomNavigationItem(R.mipmap.home_tab_mine_selected, "我").setActiveColorResource(R.color.blue)
                        .setInactiveIcon(getResources().getDrawable(R.mipmap
                                .home_tab_mine_normal)).setInActiveColorResource(R.color
                                .assist_1))
                .setFirstSelectedPosition(SELECTED_LAST_PAGE)
                .initialise();
    }

    private void initFragment() {
        mFragmentList = new ArrayList<>();
        mTitiles = new ArrayList<>();
        mTitiles.add("消息");
        mTitiles.add("消息");
        mTitiles.add("消息");
        mTitiles.add("消息");
        mFragmentList.add(WorkBenchFragment.newInstance("工作台"));
        mFragmentList.add(MyFragment.newInstance("案例库", getIntent().getExtras()));
        mFragmentList.add(MyFragment.newInstance("案例库", getIntent().getExtras()));
        mFragmentList.add(MyFragment.newInstance("案例库", getIntent().getExtras()));
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.replace(R.id.root_content, mFragmentList.get(0));
        transaction.commit();
    }


    @Override
    public void onTabSelected(int position) {
        if (mFragmentList != null) {
            if (position < mFragmentList.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = mFragmentList.get(position);
                if (fragment.isAdded()) {
                    ft.show(fragment);
                } else {
                    ft.add(R.id.root_content, fragment);
                }
                ft.commitAllowingStateLoss();
                setTitle(mTitiles.get(position));
                SELECTED_LAST_PAGE = position;
            }
        }
    }

    @Override
    public void onTabUnselected(int position) {
        if (mFragmentList != null) {
            if (position < mFragmentList.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = mFragmentList.get(position);
                ft.hide(fragment);
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isNeedCheck) {
            checkPermissions(needPermissions);
        }
    }

    private void checkPermissions(String... permissions) {
        List<String> needRequestPermissonList = findDeniedPermissions(permissions);
        if (null != needRequestPermissonList && needRequestPermissonList.size() > 0) {
            ActivityCompat.requestPermissions(this, needRequestPermissonList.toArray(
                    new String[needRequestPermissonList.size()]),
                    PERMISSON_REQUESTCODE);
        }
    }

    //获取权限集中需要申请权限的列表
    private List<String> findDeniedPermissions(String[] permissions) {
        List<String> needRequestPermissonList = new ArrayList<>();
        for (String perm : permissions) {
            if (ContextCompat.checkSelfPermission(this, perm) != PackageManager.PERMISSION_GRANTED || ActivityCompat.shouldShowRequestPermissionRationale(this, perm)) {
                needRequestPermissonList.add(perm);
            }
        }
        return needRequestPermissonList;
    }

    //检测是否说有的权限都已经授权
    private boolean verifyPermissions(int[] grantResults) {
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSON_REQUESTCODE) {
            if (!verifyPermissions(grantResults)) {
                showMissingPermissionDialog();
                isNeedCheck = false;
            }
        }
    }

    private void showMissingPermissionDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("当前应用缺少必要权限，点击设置权限");

        // 拒绝, 退出应用
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startAppSettings();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    //启动应用的设置
    private void startAppSettings() {
        Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + getPackageName()));
        startActivity(intent);
    }
}
