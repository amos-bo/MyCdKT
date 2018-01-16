package com.ktcd.malc.kt_ma_lc.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;

import com.ktcd.malc.kt_ma_lc.R;
/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class MyAlertDialog extends Dialog {
    private AlertController mAlert;

    public MyAlertDialog(Context context, int themeResId) {
        super(context, themeResId);

        mAlert=new AlertController(this,getWindow());
    }

    /**
     * 设置文本
     *
     * @param viewId
     * @param text
     */

    public void setText(int viewId, CharSequence text) {
        mAlert.setText(viewId,text);
    }

    /**
     * 设置点击事件
     * @param viewId
     * @param listener
     */
    public void setOnClickListener(int viewId, View.OnClickListener listener) {
        mAlert.setOnClickListener(viewId,listener);
    }

    public  <T extends View> T getView(int viewId) {
        return mAlert.getView(viewId);
    }

    public static class Builder{
        private final AlertController.AlertParams P;

        public Builder(Context context){
            this(context, R.style.dialog);
        }

        public Builder(Context context,int themeResId){
            P=new AlertController.AlertParams(context,themeResId);
        }

        public Builder setContentView(View view){
            P.mView=view;
            P.mViewLayoutResId=0;
            return this;
        }
        //设置布局id
        public Builder setContentView(int layoutId){
            P.mView=null;
            P.mViewLayoutResId=layoutId;
            return this;
        }

        public Builder setText(int viewId,CharSequence text){
            P.mTextArray.put(viewId,text);
            return this;
        }

        public Builder setOnClickListener(int view, View.OnClickListener listener){
            P.mClickArray.put(view,listener);
            return this;
        }

        //配置一些万能的参数
        //全屏
        public Builder fullWidth(){
            P.mWidth=ViewGroup.LayoutParams.MATCH_PARENT;
            return this;
        }
        //从底部弹出
        public Builder fromBottom(boolean isAnimation){
            if (isAnimation){
                P.mAnimation=R.style.dialog_from_bottom_anim;
            }
            P.mGravity= Gravity.BOTTOM;
            return this;
        }
        //设置宽高
        public Builder fromWidthHeight(int width,int height){
            P.mWidth=width;
            P.mHeight=height;
            return this;
        }

        //设置默认动画
        public Builder addDefaultAnimation(){
            P.mAnimation=R.style.dialog;
            return this;
        }

        //设置自定义动画
        public Builder addAnimations(int styleAnimation){
            P.mAnimation=styleAnimation;
            return this;
        }

        public Builder setCancelable(boolean cancelable){
            P.mCancelable=cancelable;
            return this;
        }

        public Builder setOnCancelListener(OnCancelListener onCancelListener){
            P.mOnCancelListener=onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(OnDismissListener onDismissListener){
            P.mOnDismissListener=onDismissListener;
            return this;
        }

        public Builder setOnKeyListener(OnKeyListener onKeyListener){
            P.mOnKeyListener=onKeyListener;
            return this;
        }

        public MyAlertDialog create(){
            final MyAlertDialog dialog=new MyAlertDialog(P.mContext,P.mThemeResId);
            P.apply(dialog.mAlert);
            dialog.setCancelable(P.mCancelable);
            if (P.mCancelable){
                dialog.setCanceledOnTouchOutside(true);
            }
            dialog.setOnCancelListener(P.mOnCancelListener);
            dialog.setOnDismissListener(P.mOnDismissListener);
            if (P.mOnKeyListener!=null){
                dialog.setOnKeyListener(P.mOnKeyListener);
            }
            return dialog;
        }

        public MyAlertDialog show(){
            final MyAlertDialog dialog=create();
            dialog.show();
            return dialog;
        }
    }
}
