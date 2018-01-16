package com.ktcd.malc.kt_ma_lc.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.activity.EventDetailActivity;
import com.ktcd.malc.kt_ma_lc.activity.ImageCheckListActivity;
import com.ktcd.malc.kt_ma_lc.adapter.FileTypeAdapter;
import com.ktcd.malc.kt_ma_lc.model.ItemEventInfoResponse;
import com.ktcd.malc.kt_ma_lc.model.ItemFileTypeInfo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static it.sephiroth.android.library.imagezoom.ImageViewTouchBase.LOG_TAG;

/**
 * @author amos_bo 284285624@qq.com
 * @version V1.0
 * @Title: bigroadofbusiness
 * @Package com.zowee.roadbusiness.dialog
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2017/5/17 15:30
 */
public class PopWindowMapBottom extends PopupWindow {

    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private FileTypeAdapter mFileTypeAdapter;
    private FrameLayout mRoot;
    private RecyclerView mRecyclerView;
    private List<ItemFileTypeInfo> mItemFileTypeInfoList;

    private TextView mTvFileSize;
    private TextView mTvAddress;
    private TextView mTvNameAndTime;

    private  int mPicNumber;
    private  int mAvNumber;
    private  int mVoiceNumber;

    private ImageView mSkipPage;

    //图片文件
    private ArrayList<ItemFileTypeInfo> mItemFilePicInfoList;
    private ItemEventInfoResponse.RowsBean.EventDetailInfoListBean mItem;
    public PopWindowMapBottom(Context context, ItemEventInfoResponse.RowsBean.EventDetailInfoListBean item, List<ItemFileTypeInfo> itemFileTypeInfoList , OnItemClickListener listener) {
        mContext=context;
        mOnItemClickListener=listener;
        mItemFileTypeInfoList=itemFileTypeInfoList;
        mItem=item;
        initDate();
        initView();
    }

    private void initDate(){
        mItemFilePicInfoList=new ArrayList<>();
        this.mRoot =(FrameLayout)LayoutInflater.from(mContext).inflate(R.layout.dialog_event_preview, null);
        mRecyclerView=(RecyclerView) mRoot.findViewById(R.id.recyclerview);

        mTvAddress=mRoot.findViewById(R.id.tv_loc);
        mTvFileSize=mRoot.findViewById(R.id.tv_file_num);
        mTvNameAndTime=mRoot.findViewById(R.id.tv_name_time);
        mSkipPage=mRoot.findViewById(R.id.img_skip_page);
        mSkipPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EventDetailActivity.StartEventProgressListActivity(mContext,mItem,(ArrayList<ItemFileTypeInfo>)mItemFileTypeInfoList);
            }
        });

        for (ItemFileTypeInfo item:
                mItemFileTypeInfoList) {
            switch (item.Type){
                case 1:
                    mPicNumber++;
                    break;
                case 2:
                    mAvNumber++;
                    break;
                case 3:
                    mVoiceNumber++;
                    break;
            }
        }
        mTvAddress.setText(""+mItem.getEdiTile());
        mTvFileSize.setText("  图片  "+mPicNumber+"  视频  "+mAvNumber+"  语音  "+mVoiceNumber);
        mTvNameAndTime.setText(""+mItem.getUpdateTime());
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext,3));
        mFileTypeAdapter=new FileTypeAdapter(mContext);
        mFileTypeAdapter.setFileDeleteIsShow(false);
        mFileTypeAdapter.setList(mItemFileTypeInfoList);
        mRecyclerView.setAdapter(mFileTypeAdapter);
        mFileTypeAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (mItemFileTypeInfoList.get(position).Type == 2) {
                    Intent intents = new Intent(Intent.ACTION_VIEW);
                    intents.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    intents.setDataAndType(Uri.parse(mItemFileTypeInfoList.get(position).pathUrl), "video/*");
                    mContext.startActivity(intents);
                } else if (mItemFileTypeInfoList.get(position).Type == 1) {
                    if (mItemFilePicInfoList.size() < 1) {
                        for (ItemFileTypeInfo item : mItemFileTypeInfoList) {
                            if (item.Type == 1) {
                                mItemFilePicInfoList.add(item);
                            }
                        }
                    }
                    Rect rect = new Rect();
                    view.getGlobalVisibleRect(rect);
                    ImageCheckListActivity.StartImagesCheckActivity(mContext,(ArrayList<ItemFileTypeInfo>)mItemFilePicInfoList, mItemFilePicInfoList.indexOf(mItemFileTypeInfoList.get(position)), rect);
                } else {
                    try {
                        MediaPlayer mPlayer = new MediaPlayer();
                        mPlayer.reset();
                        mPlayer.setDataSource(mItemFileTypeInfoList.get(position).pathUrl);
                        mPlayer.prepare();
                        mPlayer.start();
                    } catch (IOException e) {
                        Log.e(LOG_TAG, "播放失败");
                    }
                }
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

    }


    public interface OnItemClickListener {
        void ItemClick(int position);

    }

    public void initView(){
        // 设置外部可点击
        this.setOutsideTouchable(true);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        this.mRoot.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                int height = mRoot.getTop();
                int y = (int) event.getY();
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    if (y < height) {
                        dismiss();
                    }
                }
                return true;
            }
        });

    /* 设置弹出窗口特征 */
        // 设置视图
        this.setContentView(this.mRoot);
        // 设置弹出窗体的宽和高
        this.setHeight(RelativeLayout.LayoutParams.WRAP_CONTENT);
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        // 设置弹出窗体可点击
        this.setFocusable(true);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        // 设置弹出窗体的背景
        this.setBackgroundDrawable(dw);
        // 设置弹出窗体显示时的动画，从底部向上弹出
        this.setAnimationStyle(R.style.popwindows);
    }

    public static void Show(final Activity context, View view,ItemEventInfoResponse.RowsBean.EventDetailInfoListBean item, List<ItemFileTypeInfo> mItemFileTypeInfoList, OnItemClickListener onItemClickListener){
        PopWindowMapBottom popWindowMapBottom =new PopWindowMapBottom(context,item,mItemFileTypeInfoList,onItemClickListener);
        popWindowMapBottom.showAtLocation(view,Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
//        WindowManager.LayoutParams params=context.getWindow().getAttributes();
//        //当弹出Popupwindow时，背景变半透明
//        params.alpha=0.0f;
//        context.getWindow().setAttributes(params);
        //设置Popupwindow关闭监听，当Popup
        popWindowMapBottom.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
//                WindowManager.LayoutParams params = context.getWindow().getAttributes();
//                params.alpha=1f;
//                context.getWindow().setAttributes(params);
            }
        });
    }
}
