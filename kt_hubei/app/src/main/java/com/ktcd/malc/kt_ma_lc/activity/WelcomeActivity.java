package com.ktcd.malc.kt_ma_lc.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.applicatoin.ApiPathUrl;
import com.ktcd.malc.kt_ma_lc.applicatoin.BuildConfig;
import com.ktcd.malc.kt_ma_lc.applicatoin.KtkjMaLcApplication;
import com.ktcd.malc.kt_ma_lc.bean.LoginBean;
//import com.ktcd.malc.kt_ma_lc.client.ServiceManager;
import com.ktcd.malc.kt_ma_lc.client.ServiceManager;
import com.ktcd.malc.kt_ma_lc.dialog.MyAlertDialog;
import com.ktcd.malc.utilslibrary.net.PathUrl;
import com.ktcd.malc.utilslibrary.tools.ConfigUtils;
import com.ktcd.malc.utilslibrary.tools.FileUtils;
import com.ktcd.malc.utilslibrary.tools.LoadImageUtils;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;

/**
 * @author amos_bo 284285624@qq.com
 * @ClassName: WelcomeActivity
 * @Description: 闪屏页用于应用数据初始化
 * @date 2015年9月9日 下午3:49:13
 */
@SuppressLint("WorldWriteableFiles")
public class WelcomeActivity extends Activity {

    private Context mContext;

    /**
     * 是否第一次打开
     */
    private boolean mIsFirst = false;

    /**
     * 界面延时跳转
     */
    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        mContext = this;
        setContentView(R.layout.activity_welcome );
        initView();
        init();

    }

    @SuppressLint("NewApi")
    private void initView() {
        // 初始化页面
        ImageView linearLayout = (ImageView) findViewById( R.id.img_welcome );
    }

    private void init() {
        // 判断是否第一次打开
        int firstOpen = ConfigUtils.isFirstOpen( this );
        if (firstOpen <= BuildConfig.FIRST_VERSION) {
            mIsFirst = true;
            ConfigUtils.setFirstOpen( this, BuildConfig.FIRST_VERSION + 1 );

        }
        LoadImageUtils.initLoadImageUtils(KtkjMaLcApplication.getInstance()
                .getInstance() );
        loadHomeActivity();
    }

    /**
     * 跳转到主界面
     */
    private void loadHomeActivity() {
        final Intent intent = new Intent();
        // 判断是否进入过引导页面
//        if (!mIsFirst) {
            // 判断是否登录，如果登录，那么直接进入HOME界面，如果没有，那么需要跳转到登录页面
            if (ConfigUtils.getUserLogin(mContext)) {
                intent.setClass( WelcomeActivity.this, HomeTabActivity
                        .class );
            } else {
                intent.setClass( WelcomeActivity.this, LoginActivity.class );
            }

//        } else {
//            intent.setClass(WelcomeActivity.this, GuideActivity.class );
//        }
        LoginBean.DataBean  dataBean=null;
        if (ConfigUtils.getUserLogin(mContext)&&(FileUtils.getObject(mContext,"LoginBean.DataBean")!=null)) {
            //启动推送
            ServiceManager serviceManager = new ServiceManager(this);
            serviceManager.setNotificationIcon(R.mipmap.ic_launcher);
            serviceManager.startService();
            dataBean=(LoginBean.DataBean )FileUtils.getObject(mContext,"LoginBean.DataBean");
//            MyImManager.register(mContext,dataBean.getCpLoginName(), dataBean.getCpName(), dataBean.getCpLoginPwd());
            Bundle bundle=new Bundle();
            bundle.putSerializable("data",dataBean);
            intent.putExtras(bundle);
//            intent.setClass(WelcomeActivity.this, HomeTabActivity.class);
            intent.setClass(WelcomeActivity.this, HomeTabActivity.class);
        }else{
            intent.setClass(WelcomeActivity.this, LoginActivity.class);
        }
        mHandler.postDelayed( new Runnable() {
            public void run() {
                startActivity( intent );
                finish();
            }
        }, 1000 * 2 );
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mHandler.removeCallbacksAndMessages(null);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}
