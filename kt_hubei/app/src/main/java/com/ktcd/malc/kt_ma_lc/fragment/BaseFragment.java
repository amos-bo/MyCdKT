package com.ktcd.malc.kt_ma_lc.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.LinearLayout;
import butterknife.Unbinder;

/**
 * @ClassName
 * @Description
 * @Date 2016/12/614:17
 */

public class BaseFragment extends Fragment {
    protected Context mContext;
    protected Unbinder mUnBinder;
    @Override
    public void onAttach(Context context) {
        super.onAttach( context );
        mContext = context;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mUnBinder != null) mUnBinder.unbind();
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

    protected void startActivityForResult(Class<? extends Activity> cls, Bundle bundle, int requestCode) {
        Intent localIntent = new Intent();
        if (bundle != null) {
            localIntent.putExtras( bundle );
        }
        localIntent.setClass( mContext, cls );
        startActivityForResult( localIntent, requestCode );
    }

    protected void startActivityForResult(Class<? extends Activity> cls, int requestCode) {
        startActivityForResult( cls, null, requestCode );
    }
}
