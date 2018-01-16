package com.ktcd.malc.kt_ma_lc.activity;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.common.executors.CallerThreadExecutor;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.model.ItemFileTypeInfo;
import com.ktcd.malc.utilslibrary.tools.FileUtils;
import com.ktcd.malc.utilslibrary.tools.StatusBarUtil;
import com.ktcd.malc.utilslibrary.tools.ToastUtils;


import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ImageCheckListActivity extends com.ktcd.malc.baselayer.activity.BaseActivity {
    @BindView(R.id.view_pager)
    ViewPager view_pager;
    @BindView(R.id.activity_image_check)
    View mRoot;
    @BindView(R.id.tv_number)
    TextView mTvNumber;
    @BindView(R.id.img_down)
    ImageView mImgDown;
    private Rect mOriRect;
    private Rect mDestRect;
    private ArrayList<ItemFileTypeInfo> mFilePathList;

    private int mCutIte=0;

    private int mCurrentItem=0;
    public  static  void StartImagesCheckActivity(Context context, ArrayList<ItemFileTypeInfo> imgUrlPathList , int currentItem, Rect rect){
        if (imgUrlPathList!=null) {
            if (imgUrlPathList.size()>0) {
                Bundle bundle = new Bundle();
                bundle.putSerializable( "PATHLIST", imgUrlPathList );
                bundle.putInt( "CURRENT_ITEM", currentItem );
                Intent intent = new Intent( context, ImageCheckListActivity.class );
                intent.putExtra( "Rect", rect );
                intent.putExtras( bundle );
                context.startActivity( intent );
            }else {
                ToastUtils.showMessage(context,"图片数量为0");
            }
        }else{
           ToastUtils.showMessage(context,"图片地址栏为空");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_image_checklist);
        ButterKnife.bind(this);
        startAnimation();
        mRoot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    /**
     * 根据上个页面传来的信息，在本页相同位置生成控件
     * 生成控件后位移和放大
     */
    private void startAnimation() {
        mFilePathList=(ArrayList<ItemFileTypeInfo>) getIntent().getExtras().getSerializable("PATHLIST");
        mCurrentItem=getIntent().getExtras().getInt( "CURRENT_ITEM");
        view_pager.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            @Override
            public boolean onPreDraw() {
                view_pager.getViewTreeObserver().removeOnPreDrawListener(this);
                if(getIntent() == null || getIntent().getExtras() == null)
                    return true;
                //获得位置信息
                mOriRect = getIntent().getExtras().getParcelable("Rect");
                if(mOriRect == null)
                    return true;
                mDestRect = new Rect();
                //保持和上个activity相同位置
                view_pager.getGlobalVisibleRect(mDestRect);
                FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(mOriRect.width(), mOriRect.height());
                lp.setMargins(mOriRect.left, mOriRect.top - StatusBarUtil.getStatusBarHeight(mContext), mOriRect.right, mOriRect.bottom);
                view_pager.setLayoutParams(lp);
                //开始位移和缩放动画
                view_pager.setPivotX(0);
                view_pager.setPivotY(0);
                view_pager.animate()
                        .translationX(mDestRect.left - mOriRect.left)
                        .translationY(mDestRect.top - mOriRect.top)
                        .scaleX((float) mDestRect.width() / mOriRect.width())
                        .scaleY((float) mDestRect.height() / mOriRect.height())
                        .setInterpolator(INTERPOLATOR)
                        .setDuration(DURATION)
                        .setListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {
                                overridePendingTransition(0,0);
                            }
                            @Override
                            public void onAnimationEnd(Animator animation) {
                            }
                            @Override
                            public void onAnimationCancel(Animator animation) {
                            }
                            @Override
                            public void onAnimationRepeat(Animator animation) {
                            }
                        })
                        .start();
                return true;
            }
        });

        SamplePagerAdapter samplePagerAdapter= new SamplePagerAdapter();
        view_pager.setAdapter(samplePagerAdapter);
        view_pager.setCurrentItem(mCurrentItem);
        mTvNumber.setText((mCurrentItem+1)+"/"+mFilePathList.size());
        view_pager.addOnPageChangeListener( new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                mTvNumber.setText((position+1)+"/"+mFilePathList.size());
                mCutIte=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        } );
    }

    private final int DURATION = 200;
    private Interpolator INTERPOLATOR = new LinearInterpolator();
    @Override
    public void onBackPressed() {
        //退场动画
        view_pager.animate()
                .translationX(0)
                .translationY(0)
                .scaleX(1)
                .scaleY(1)
                .setInterpolator(INTERPOLATOR)
                .setDuration(DURATION)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {
                    }
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        finish();
                         overridePendingTransition(0,0);
                    }
                    @Override
                    public void onAnimationCancel(Animator animation) {
                    }
                    @Override
                    public void onAnimationRepeat(Animator animation) {
                    }
                })
                .start();
    }


    class SamplePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mFilePathList.size();
        }

        @Override
        public View instantiateItem(ViewGroup container, int position) {
            View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_image_check, container,
                    false);
            SimpleDraweeView photoView =(SimpleDraweeView)itemView.findViewById(R.id.image);
            final String path = mFilePathList.get(position).pathUrl;
            if(path.contains("http")){
                photoView.setImageURI(path);
                downPic(true);
            } else {
                photoView.setImageURI(Uri.parse("file://") + path);
                downPic(false);
            }
            container.addView(itemView, ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            return itemView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }
    }



    private void downPic(boolean isCanShow){

        if (isCanShow) {
            mImgDown.setVisibility( View.VISIBLE );
            mImgDown.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String path = mFilePathList.get( mCutIte ).pathUrl;
                    Uri uri = Uri.parse( path );
                    ImageRequest imageRequest = ImageRequestBuilder.newBuilderWithSource( uri ).build();

                    DataSource<CloseableReference<CloseableImage>> dataSource = Fresco.getImagePipeline().fetchDecodedImage( imageRequest, this );
                    dataSource.subscribe( new BaseBitmapDataSubscriber() {
                        @Override
                        public void onNewResultImpl(final Bitmap bitmap) {
                            if (bitmap != null) {
                                new Thread(new Runnable() {
                                    @Override
                                    public void run() {
                                        FileUtils.savaBitmap( "zowee", SystemClock.elapsedRealtime() + ".jpg", bitmap );
                                        ToastUtils.showMessage( mContext,
                                                "保存成功" );
                                    }
                                } ).start();
                            }
                        }

                        @Override
                        public void onFailureImpl(DataSource dataSource) {

                        }
                    }, CallerThreadExecutor.getInstance() );
                }
            } );
        }else{
            mImgDown.setVisibility(View.GONE);
        }
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTransparent(this);
    }
}
