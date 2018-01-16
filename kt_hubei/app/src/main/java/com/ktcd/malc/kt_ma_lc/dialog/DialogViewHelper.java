package com.ktcd.malc.kt_ma_lc.dialog;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class DialogViewHelper {
    private View mContentView=null;
    private SparseArray<WeakReference<View>> mViews;
    private TextView view;

    public DialogViewHelper(Context context, int mViewLayoutResId) {
        this();
        mContentView= LayoutInflater.from(context).inflate(mViewLayoutResId,null);
    }

    public DialogViewHelper() {
        mViews=new SparseArray<>();
    }

    /**
     * 设置布局view
     * @param contentView
     */
    public void setContentView(View contentView) {
        this.mContentView = contentView;
    }

    /**
     * 设置文本
     *
     * @param viewId
     * @param text
     */

    public void setText(int viewId, CharSequence text) {
        //减少findViewById的次数
        TextView tv = getView(viewId);
        //TextView tv = (TextView) mContentView.findViewById(viewId);
        if (tv != null) {
            tv.setText(text);
        }
    }

    /**
     * 设置点击事件
     * @param viewId
     * @param listener
     */
    public void setOnClickListner(int viewId, View.OnClickListener listener) {
        View view=getView(viewId);
        if (view!=null){
            view.setOnClickListener(listener);
        }
    }

    public View getContentView() {
        return mContentView;
    }

    public  <T extends View> T getView(int viewId) {
        WeakReference<View> weakReference=mViews.get(viewId);
        View view=null;
        if (weakReference!=null){
            view=weakReference.get();
        }
        if (view==null){
            view=mContentView.findViewById(viewId);
            if (view!=null) {
                mViews.put(viewId, new WeakReference<>(view));
            }
        }
        return (T) view;
    }
}
