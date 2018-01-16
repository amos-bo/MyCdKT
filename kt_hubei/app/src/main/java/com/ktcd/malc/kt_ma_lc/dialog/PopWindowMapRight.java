package com.ktcd.malc.kt_ma_lc.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import com.ktcd.malc.baselayer.adapter.SimpleRecyclerAdapter;
import com.ktcd.malc.kt_ma_lc.R;
import com.ktcd.malc.kt_ma_lc.adapter.FileTypeAdapter;
import com.ktcd.malc.kt_ma_lc.adapter.ResourcesTypesAdapter;
import com.ktcd.malc.kt_ma_lc.model.ItemFileTypeInfo;
import com.ktcd.malc.kt_ma_lc.model.ItemHomeTypeInfo;

import java.util.List;

/**
 * @author amos_bo 284285624@qq.com
 * @version V1.0
 * @Title: bigroadofbusiness
 * @Package com.zowee.roadbusiness.dialog
 * @Description: ${todo}(用一句话描述该文件做什么)
 * @date 2017/5/17 15:30
 */
public class PopWindowMapRight extends PopupWindow {

    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private ResourcesTypesAdapter mResourcesTypesAdapter;
    private LinearLayout mRoot;
    private View mLeftView;
    private RecyclerView mRecyclerView;
    private List<ItemHomeTypeInfo> mItemFileTypeInfoList;

    public PopWindowMapRight(Context context, List<ItemHomeTypeInfo> itemFileTypeInfoList, OnItemClickListener listener) {
        mContext = context;
        mOnItemClickListener = listener;
        mItemFileTypeInfoList = itemFileTypeInfoList;
        initDate();
        initView();
    }

    private void initDate() {
        this.mRoot = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.dialog_resources_selectdot, null);
        mRecyclerView = (RecyclerView) mRoot.findViewById(R.id.recyclerview);
        mLeftView = mRoot.findViewById(R.id.view);
        mRecyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
        mResourcesTypesAdapter = new ResourcesTypesAdapter(mContext);
        mResourcesTypesAdapter.setList(mItemFileTypeInfoList);
        mRecyclerView.setAdapter(mResourcesTypesAdapter);
        mResourcesTypesAdapter.setOnItemClickListener(new SimpleRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                mItemFileTypeInfoList.get(position).isSelected=!mItemFileTypeInfoList.get(position).isSelected;
                mResourcesTypesAdapter.notifyItemChanged(position);
                mOnItemClickListener.ItemClick(position);
            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

    }


    public interface OnItemClickListener {
        void ItemClick(int position);

    }

    public void initView() {
        // 设置外部可点击
        this.setOutsideTouchable(true);
        // mMenuView添加OnTouchListener监听判断获取触屏位置如果在选择框外面则销毁弹出框
        this.mLeftView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_UP) {
                        dismiss();
                }
                return true;
            }
        });

    /* 设置弹出窗口特征 */
        // 设置视图
        this.setContentView(this.mRoot);
        // 设置弹出窗体的宽和高
        this.setHeight(RelativeLayout.LayoutParams.MATCH_PARENT);
        this.setWidth(RelativeLayout.LayoutParams.MATCH_PARENT);
        // 设置弹出窗体可点击
        this.setFocusable(true);
        // 实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x90000000);
        // 设置弹出窗体的背景
        this.setBackgroundDrawable(dw);
//         设置弹出窗体显示时的动画，从底部向上弹出
//        this.setAnimationStyle(R.style.popwindows_right);
    }

    public static void Show(final Activity context, View view, List<ItemHomeTypeInfo> mItemFileTypeInfoList, OnItemClickListener onItemClickListener) {
        PopWindowMapRight popWindowMapBottom = new PopWindowMapRight(context, mItemFileTypeInfoList, onItemClickListener);
        popWindowMapBottom.showAtLocation(view, Gravity.RIGHT | Gravity.CENTER_VERTICAL, 0, 0);
        WindowManager.LayoutParams params = context.getWindow().getAttributes();
        //当弹出Popupwindow时，背景变半透明
        params.alpha = 0.5f;
        context.getWindow().setAttributes(params);
        //设置Popupwindow关闭监听，当Popup
        popWindowMapBottom.setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams params = context.getWindow().getAttributes();
                params.alpha = 1f;
                context.getWindow().setAttributes(params);
            }
        });
    }
}
