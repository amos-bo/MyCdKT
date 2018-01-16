package com.ktcd.malc.baselayer.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;


import com.ktcd.malc.utilslibrary.net.MyRetrofit;
import com.ktcd.malc.utilslibrary.tools.StatusBarUtil;
import com.ktcd.malc.utilslibrary.tools.StringUtils;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;

import java.io.Serializable;

import io.reactivex.disposables.CompositeDisposable;


/**
 * @author amos_bo 284285624@qq.com
 * @ClassName: BaseActivity
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @date 2015年9月7日 下午4:47:30
 */
@SuppressWarnings("ResourceType")
public class BaseActivity extends AppCompatActivity {

    /**
     * 上下文
     */
    protected Context mContext;
    protected CompositeDisposable mDisposables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        mContext = this;
        mDisposables=new CompositeDisposable();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView( view );
        setStatusBar();
    }

    @Override
    public void setContentView(int layout) {
        super.setContentView( layout );
        setStatusBar();
    }

    /**
     * 设置状态栏颜色
     * 其他常用方法
     * StatusBarUtil.setColorNoTranslucent(Activity activity, @ColorInt int
     * color)
     * StatusBarUtil.setTransparent(Activity activity)
     * setColorNoTranslucentForDrawerLayout(Activity activity, DrawerLayout
     * drawerLayout, @ColorInt int color)
     */
    protected void setStatusBar() {
        StatusBarUtil.setColorNoTranslucent(this,0x000000, false );
    }

    /**
     * @return
     * @description
     * @date 2015年7月29日
     */
    public ViewGroup genRealRootView() {
        LinearLayout localLinearLayout = new LinearLayout( this );
        localLinearLayout.setOrientation( LinearLayout.VERTICAL );
        return localLinearLayout;
    }

    /**
     * @return
     * @description
     * @date 2015年7月29日
     */
    public ViewGroup genRootView() {
        LinearLayout localLinearLayout = new LinearLayout( this );
        localLinearLayout.setOrientation( LinearLayout.VERTICAL );
        return localLinearLayout;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        hideInput( ev );
        return super.dispatchTouchEvent( ev );
    }

    /**
     * 隐藏软键盘
     *
     * @Description: @param @param ev @return void @throws
     */
    protected void hideInput(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {

            // 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
            View v = getCurrentFocus();

            if (isShouldHideInput( v, ev )) {
                hideSoftInput( v.getWindowToken() );
            }
        }
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时没必要隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow( l );
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right
                    = left + v.getWidth();
            return !(event.getX() > left && event.getX() < right && event
                    .getY() > top && event.getY() < bottom);
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
        return false;
    }

    /**
     * 多种隐藏软件盘方法的其中一种
     *
     * @param token
     */
    private void hideSoftInput(IBinder token) {
        if (token != null) {
            InputMethodManager im = (InputMethodManager) getSystemService(
                    Context.INPUT_METHOD_SERVICE );
            im.hideSoftInputFromWindow( token, InputMethodManager
                    .HIDE_NOT_ALWAYS );
        }
    }


    /**
     * @param id
     * @return
     */
    protected <T extends View> T findViewByID(int id) {
        return (T) findViewById( id );
    }

    /**
     * 点击事件
     *
     * @param
     */
    protected void setViewsOnClickListener(View[] views, View.OnClickListener
            listener) {
        for (View view : views) {
            view.setOnClickListener( listener );
        }
    }

    protected void startActivity(Class<? extends Activity> cls) {
        startActivity( cls, null );
    }

    protected void startActivity(Class<? extends Activity> cls, Bundle bundle) {
        Intent intent = new Intent( mContext, cls );
        if (bundle != null) {
            intent.putExtras( bundle );
        }
        startActivity( intent );
    }

    protected void startActivityForResult(Class<? extends Activity> cls,
                                          Bundle bundle, int requestCode) {
        Intent localIntent = new Intent();
        if (bundle != null) {
            localIntent.putExtras( bundle );
        }
        localIntent.setClass( this, cls );
        startActivityForResult( localIntent, requestCode );
    }

    protected void startActivityForResult(Class<? extends Activity> cls, int
            requestCode) {
        startActivityForResult( cls, null, requestCode );
    }

    protected void setResult(Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            intent.putExtras( bundle );
        }
        setResult(RESULT_OK, intent);
        BaseActivity.this.finish();
    }

    protected String getBundleStringVaule(String key) {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String Vaule = bundle.getString( key );
            if (!StringUtils.isEmpty(Vaule)) {
                return Vaule;
            }
        }
        return null;
    }

    protected boolean getBundleBooleanVaule(String key) {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            boolean Vaule = bundle.getBoolean( key, false );
            return Vaule;
        }
        return false;
    }

    protected int getBundleIntVaule(String key) {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int Vaule = bundle.getInt( key, -1 );
            return Vaule;
        }
        return -1;
    }

    protected <T extends Serializable> T getBundleSerializableVaule(String key, Intent data) {
        Bundle bundle = data.getExtras();
        if (bundle != null) {
            T Vaule = (T) bundle.getSerializable( key );
            return Vaule;
        }
        return null;
    }


    /**
     * 设置背景透明度
     *
     * @param alpha
     */
    public void setBackgroundAlpha(float alpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = alpha;
        getWindow().setAttributes( lp );
    }


    @Override
    public void onBackPressed() {
        //返回键
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        ToastUtils.cancelCurrentToast();//防止内存泄漏
        MyRetrofit.disposeAllSubscription(mDisposables);
        super.onDestroy();
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            RequestAgent.cancelAll();
        }
        return super.onKeyDown(keyCode, event);
    }
}
