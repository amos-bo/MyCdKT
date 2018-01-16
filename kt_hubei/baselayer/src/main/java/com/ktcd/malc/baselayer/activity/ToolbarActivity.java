package com.ktcd.malc.baselayer.activity;

import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ktcd.malc.baselayer.R;
import com.ktcd.malc.utilslibrary.tools.DeviceUtils;

import me.rawn_hwang.library.widgit.DefaultLoadingLayout;
import me.rawn_hwang.library.widgit.SmartLoadingLayout;


/**
 * @ClassName
 * @Description
 * @Author Xiaoborui
 * @Date 2016/12/2 14:06
 */

public class ToolbarActivity extends BaseActivity {
    protected Toolbar mToolbar;
    private AppBarLayout mAppBarLayout;
    private View mToolbarDivider;
    private TextView mTitleTextView;
    private LinearLayout mRightContainer;
    private String mNavigationTitle = "返回";

    protected DefaultLoadingLayout mErroeLayout;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 初始化toolbar
     *
     * @param toolbar
     */
    protected void setUpToolbar(Toolbar toolbar) {
        mToolbar = toolbar;
        mToolbar.setTitleTextColor(ContextCompat.getColor(this, R.color.navigation_title_text));
        mToolbar.setTitle("");
        setSupportActionBar(toolbar);
        setNavigationIcon(R.mipmap.home_return);
        setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToolbarActivity.super.onBackPressed();
            }
        });
        mTitleTextView = (TextView) mToolbar.findViewById(R.id.toolbar_title);
        mRightContainer = (LinearLayout) mToolbar.findViewById(R.id.toolbar_btn_container);
    }

    /**
     * 设置toolbar背景色
     */
    protected void setToolbarColor(@ColorInt int color) {
        mToolbar.setBackgroundColor(color);
    }

    /**
     * 设置导航文字
     *
     * @param navigationTitle
     */
    protected void setNavigationText(CharSequence navigationTitle) {
        mNavigationTitle = navigationTitle.toString();
        mToolbar.setTitle(mNavigationTitle);
    }

    protected void setNavigationText(@StringRes int resId) {
        mNavigationTitle = getString(resId);
        mToolbar.setTitle(mNavigationTitle);
    }

    /**
     * 设置标题栏是否可见
     */
    protected void setToolbarVisible(boolean bln) {
        mToolbar.setVisibility(bln ? View.VISIBLE : View.GONE);
    }

    /**
     * 导航文字是否可见
     *
     * @param visisble
     */
    protected void setNavigationTextVisibility(boolean visisble) {
        mToolbar.setTitle(visisble ? mNavigationTitle : "");
    }

    /**
     * 设置导航文字
     *
     * @param color
     */
    protected void setNavigationTextColor(@ColorInt int color) {
        mToolbar.setTitleTextColor(color);
    }

    /**
     * 设置导航图标
     *
     * @param resId
     */
    protected void setNavigationIcon(@DrawableRes int resId) {
        mToolbar.setNavigationIcon(resId);
    }

    protected void setNavigationIcon(Drawable icon) {
        mToolbar.setNavigationIcon(icon);
    }

    /**
     * 设置导航图标点击事件
     *
     * @param l
     */
    protected void setNavigationOnClickListener(View.OnClickListener l) {
        mToolbar.setNavigationOnClickListener(l);
    }

    @Override
    public void setContentView(int layoutResID) {
        if (needToolbar()) {
            LinearLayout rootLayout = new LinearLayout(this);
            rootLayout.setOrientation(LinearLayout.VERTICAL);
            addToolbar(rootLayout);
            rootLayout.addView(getLayoutInflater().inflate(layoutResID, null), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            super.setContentView(rootLayout);
        } else {
            super.setContentView(layoutResID);
        }
        setStatusBar();
    }

    /**
     * 添加toolbar到根布局
     *
     * @param rootView
     */
    protected void addToolbar(LinearLayout rootView) {
        if (rootView == null)
            return;
        AppBarLayout appBarLayout = (AppBarLayout) getLayoutInflater().inflate(R.layout.toolbar, null);
        mToolbarDivider = appBarLayout.findViewById(R.id.toolbar_divider);
        mToolbar = (Toolbar) appBarLayout.findViewById(R.id.toolbar);
        mAppBarLayout = appBarLayout;
        setUpToolbar(mToolbar);
        rootView.addView(appBarLayout, ViewGroup.LayoutParams.MATCH_PARENT, DeviceUtils.dip2px(this, 48));
    }


    /**
     * 是否添加toolbar
     *
     * @return
     */
    protected boolean needToolbar() {
        return true;
    }

    /**
     * 是否添加网络无响应重试
     *
     * @return
     */
    protected void needNetErrorView(View rePlaceView) {
           mErroeLayout = SmartLoadingLayout.createDefaultLayout(this, rePlaceView);
    }

    /**
     * 设置标题栏
     */
    @Override
    public void setTitle(@StringRes int titleId) {
        mTitleTextView.setText(getString(titleId));
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitleTextView.setText(title);
    }

    /**
     * 标题是否可见
     *
     * @param visisble
     */
    protected void setTitleVisibility(boolean visisble) {
        mTitleTextView.setVisibility(visisble ? View.VISIBLE : View.GONE);
    }

    /**
     * 设置标题栏颜色
     */
    protected void setTitleColorInt(@ColorInt int color) {
        mTitleTextView.setTextColor(color);
    }

    protected void setTitleColorRes(@ColorRes int colorRes) {
        mTitleTextView.setTextColor(ContextCompat.getColor(this, colorRes));
    }

    /**
     * 设置标题栏字体大小
     */
    protected void setTitleTextSize(int size) {
        mTitleTextView.setTextSize(size);
    }

    /**
     * 最右侧添加按钮
     */
    protected void addButton(@DrawableRes int resId, @Nullable View.OnClickListener l) {
        ImageButton imageButton = new ImageButton(this);
        if (l != null)
            imageButton.setOnClickListener(l);
        imageButton.setImageResource(resId);
        imageButton.setBackgroundColor(Color.TRANSPARENT);
        imageButton.setTag(resId + "");
        //点击效果
        TypedArray a = getTheme().obtainStyledAttributes(
                new int[]{});
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                a = getTheme().obtainStyledAttributes(new int[]{android.R.attr.selectableItemBackgroundBorderless});
            } else {
                a = getTheme().obtainStyledAttributes(new int[]{android.R.attr.selectableItemBackground});
            }
            imageButton.setBackgroundDrawable(a.getDrawable(0));
        } finally {
            a.recycle();
        }

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(DeviceUtils.dip2px(this, 48), DeviceUtils.dip2px(this, 32));
        lp.setMargins(0, 0, DeviceUtils.dip2px(this, 4), 0);
        imageButton.setLayoutParams(lp);
        mRightContainer.addView(imageButton);
    }

    /**
     * 最右侧添加文字
     */
    protected void addText(CharSequence text, @ColorInt int textColor, int textSize, @Nullable View.OnClickListener l) {
        TextView textView = new TextView(this);
        if (l != null)
            textView.setOnClickListener(l);
        textView.setText(text);
        textView.setTextColor(textColor);
        textView.setTextSize(textSize);
        textView.setGravity(Gravity.CENTER);
        textView.setMaxLines(1);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setTag(text);
        //点击效果
        TypedArray a = getTheme().obtainStyledAttributes(
                new int[]{});
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                a = getTheme().obtainStyledAttributes(new int[]{android.R.attr.selectableItemBackgroundBorderless});
            } else {
                a = getTheme().obtainStyledAttributes(new int[]{android.R.attr.selectableItemBackground});
            }
            textView.setBackgroundDrawable(a.getDrawable(0));
        } finally {
            a.recycle();
        }

        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, DeviceUtils.dip2px(this, 32));
        lp.setMargins(0, 0, DeviceUtils.dip2px(this, 4), 0);
        textView.setLayoutParams(lp);
        mRightContainer.addView(textView);
    }

    protected void addText(CharSequence text, View.OnClickListener l) {
        addText(text, Color.WHITE, 18, l);
    }

    /**
     * 隐藏右侧文字或者图标
     *
     * @param tag     imagebutton的tag为图片资源id; textview的tag为设置的文字
     * @param visible
     */
    protected void setRightVisible(String tag, boolean visible) {
        View view = mRightContainer.findViewWithTag(tag);
        if (view != null) {
            view.setVisibility(visible ? View.VISIBLE : View.GONE);
        }
    }

    /**
     * 分割线是否可见
     *
     * @param visible
     */
    protected void setDividerVisible(boolean visible) {
        if (mToolbarDivider != null)
            mToolbarDivider.setVisibility(visible ? View.VISIBLE : View.GONE);
    }

    protected Toolbar getToolbar() {
        if (mToolbar != null) {
            return mToolbar;
        } else {
            return null;
        }
    }

    protected AppBarLayout getAppBarLayout() {
        if (mAppBarLayout != null) {
            return mAppBarLayout;
        } else {
            return null;
        }
    }

    /**
     * 网络重试按钮
     */
    protected void reGetNetData() {
        //TOOD 调用重试响应

    }

    /**
     * 根据index找到右侧控件里面的textView或者imageButton
     *
     * @param index
     * @return
     */
    protected <T extends View> T getRightViewAt(int index) {
        return (T) mRightContainer.getChildAt(index);
    }


}
