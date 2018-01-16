package com.ktcd.malc.kt_ma_lc.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.applicatoin.KtkjMaLcApplication;


import java.util.ArrayList;
import java.util.List;

/**
 * @author amos_bo 284285624@qq.com
 * @ClassName: GuideActivity
 * @Description: 应用引导界面
 * @date 2015年9月9日 下午4:42:13
 */
public class GuideActivity extends Activity {
    public static final int PAGE_SIZE = 4;

    private ViewPager mPagerGuide = null;
    private List<View> mListGuideView = null;
    private GuideAdapter mGuideAdapter = null;
//    private MyDotView[] mImageViews = null;
    private Button mBtnLogin = null;
    private Button mBtnRelation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 隐藏标题栏
        requestWindowFeature( Window.FEATURE_NO_TITLE);
        // 隐藏状态栏
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView( R.layout.activity_guide);
        KtkjMaLcApplication.getInstance().addActivity(this);
        initView();
    }

    private void initView() {
        mPagerGuide = (ViewPager) findViewById(R.id.guide_viewpaper);
        mBtnLogin = (Button) findViewById(R.id.btn_login);
        mBtnLogin.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                // 跳转到下一个页面
                Intent intent = new Intent(GuideActivity.this,
                        LoginActivity.class);
                startActivity(intent);
			    GuideActivity.this.finish();
            }
        });
        // init imageview
        ImageView imageView1 = new ImageView(this);
        imageView1.setBackgroundResource(R.mipmap.ic_launcher);
        ImageView imageView2 = new ImageView(this);
        imageView2.setBackgroundResource(R.mipmap.ic_launcher);
        ImageView imageView3 = new ImageView(this);
        imageView3.setBackgroundResource(R.mipmap.ic_launcher);
        ImageView imageView4 = new ImageView(this);
        imageView4.setBackgroundResource(R.mipmap.ic_launcher);
        mListGuideView = new ArrayList<View>();
        mListGuideView.add(imageView1);
        mListGuideView.add(imageView2);
        mListGuideView.add(imageView3);
        mListGuideView.add(imageView4);

//        ViewGroup group = (ViewGroup) findViewById(R.id.guide_btm);
////        mImageViews = new MyDotView[mListGuideView.size()];
//
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
//                DeviceUtils.dip2px(GuideActivity.this, 15), DeviceUtils.dip2px(
//                GuideActivity.this, 15));
//        layoutParams.setMargins(4, 0, 4, 0);

//        MyDotView imageView;
//        for (int i = 0; i < mListGuideView.size(); i++) {
//            imageView = new MyDotView(this);
//            imageView.setLayoutParams(layoutParams);
//            mImageViews[i] = imageView;
//            if (i == 0) {
//                // 默认选中第一张图片
//                mImageViews[i].changeState(true);
//            } else {
//                mImageViews[i].changeState(false);
//            }
//            group.addView(mImageViews[i]);
//        }
        mGuideAdapter = new GuideAdapter(mListGuideView);
        mPagerGuide.setAdapter(mGuideAdapter);
        mPagerGuide.setOnPageChangeListener(new GuidePageChangeListener());
    }

    /**
     * @author libai
     * @Title: GuideActivity.java
     * @Description: 引导页面的图片适配器
     */
    private final class GuideAdapter extends PagerAdapter {
        private List<View> views = null;

        public GuideAdapter(List<View> views) {
            this.views = views;
        }

        @Override
        public void destroyItem(View arg0, int arg1, Object arg2) {
            ((ViewPager) arg0).removeView(views.get(arg1));
        }

        @Override
        public void finishUpdate(View arg0) {

        }

        @Override
        public int getCount() {
            return views.size();
        }

        @Override
        public Object instantiateItem(View arg0, int arg1) {
            ((ViewPager) arg0).addView(views.get(arg1), 0);
            return views.get(arg1);
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public void restoreState(Parcelable arg0, ClassLoader arg1) {

        }

        @Override
        public Parcelable saveState() {
            return null;
        }

        @Override
        public void startUpdate(View arg0) {

        }
    }

    /**
     * 指引页面改监听器
     */
    private final class GuidePageChangeListener implements OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageSelected(int arg0) {
            if (arg0 == PAGE_SIZE - 1) {
                if (mBtnLogin.getVisibility()==View.GONE) {
                    mBtnLogin.setVisibility( View.VISIBLE );
                    mBtnLogin.setEnabled( true );
                    ObjectAnimator animator1 = ObjectAnimator.ofFloat( mBtnLogin, "alpha", 0f, 1f );
                    ObjectAnimator animator2 = ObjectAnimator.ofFloat( mBtnLogin, "scaleY", 0f, 1f );
                    AnimatorSet animSet = new AnimatorSet();
                    animSet.play( animator1 ).with( animator2 );
                    animSet.setDuration( 500 );
                    animSet.start();
                }

            }else{
                if (mBtnLogin.getVisibility()==View.VISIBLE) {
                    ObjectAnimator animator1 = ObjectAnimator.ofFloat( mBtnLogin, "alpha", 1f, 0f );
                    ObjectAnimator animator2 = ObjectAnimator.ofFloat( mBtnLogin, "scaleY", 1f, 0f );
                    AnimatorSet animSet = new AnimatorSet();
                    animSet.play( animator1 ).with( animator2 );
                    animSet.setDuration(500);
                    animSet.addListener( new Animator.AnimatorListener() {
                        @Override
                        public void onAnimationStart(Animator animation) {

                        }

                        @Override
                        public void onAnimationEnd(Animator animation) {
                            mBtnLogin.setVisibility( View.GONE );
                            mBtnLogin.setEnabled( false );
                        }

                        @Override
                        public void onAnimationCancel(Animator animation) {

                        }

                        @Override
                        public void onAnimationRepeat(Animator animation) {

                        }
                    } );
                    animSet.start();
                }
            }
//            for (int i = 0; i < mImageViews.length; i++) {
//                mImageViews[arg0].changeState(true);
//                ;
//                if (arg0 != i) {
//                    mImageViews[i].changeState(false);
//                }
//            }
        }
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
    protected void onStop() {
        super.onStop();

    }

}
