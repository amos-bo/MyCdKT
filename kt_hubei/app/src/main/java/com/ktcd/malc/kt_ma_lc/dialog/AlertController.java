package com.ktcd.malc.kt_ma_lc.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

/**
 * Created by Administrator on 2017/6/7 0007.
 */

public class AlertController {
    private MyAlertDialog mDialog;
    private Window mWindow;
    private DialogViewHelper mViewHelper;

    public AlertController(MyAlertDialog alertDialog, Window window) {
        this.mDialog=alertDialog;
        this.mWindow=window;
    }

    public void setViewHelper(DialogViewHelper viewHelper) {
        this.mViewHelper = viewHelper;
    }

    /**
     * 设置文本
     *
     * @param viewId
     * @param text
     */

    public void setText(int viewId, CharSequence text) {
        mViewHelper.setText(viewId,text);
    }

    /**
     * 设置点击事件
     * @param viewId
     * @param listener
     */
    public void setOnClickListener(int viewId, View.OnClickListener listener) {
        mViewHelper.setOnClickListner(viewId,listener);
    }

    public  <T extends View> T getView(int viewId) {
        return mViewHelper.getView(viewId);
    }

    /**
     * 获取dialog
     * @return
     */
    public MyAlertDialog getDialog() {
        return mDialog;
    }

    /**
     * 获取dialog的window
     * @return
     */
    public Window getWindow() {
        return mWindow;
    }

    public static class AlertParams {
        public Context mContext;
        public int mThemeResId;
        //点击空白是否能够取消
        public boolean mCancelable=true;
        //dialog Cancel监听
        public DialogInterface.OnCancelListener mOnCancelListener;
        //dialog  Dismiss监听
        public DialogInterface.OnDismissListener mOnDismissListener;
        //dialog  Key监听
        public DialogInterface.OnKeyListener mOnKeyListener;
        //布局
        public View mView;
        //布局的Layout
        public int mViewLayoutResId;
        //存放字体的修改
        public SparseArray<CharSequence> mTextArray=new SparseArray<>();
        //存放点击事件
        public SparseArray<View.OnClickListener> mClickArray=new SparseArray<>();
        //宽度
        public int mWidth= ViewGroup.LayoutParams.WRAP_CONTENT;
        //动画
        public int mAnimation=0;
        //位置
        public int mGravity= Gravity.CENTER;
        //高度
        public int mHeight=ViewGroup.LayoutParams.WRAP_CONTENT;

        public AlertParams(Context context, int themeResId) {
            this.mContext=context;
            this.mThemeResId=themeResId;
        }

        /**
         * 绑定和设置参数
         * @param mAlert
         */
        public void apply(AlertController mAlert) {
            //1.设置布局
            DialogViewHelper viewHelper=null;
            if (mViewLayoutResId!=0){
                viewHelper=new DialogViewHelper(mContext,mViewLayoutResId);
            }
            if (mView!=null){
                viewHelper=new DialogViewHelper();
                viewHelper.setContentView(mView);
            }
            if (viewHelper==null){
                throw new IllegalArgumentException("请设置布局setContentView()");
            }
            //给dialog设置布局
            mAlert.getDialog().setContentView(viewHelper.getContentView());

            //设置Controller的辅助类
            mAlert.setViewHelper(viewHelper);

            //2，设置文本
            int textArraySize=mTextArray.size();
            for (int i=0;i<textArraySize;i++){
                mAlert.setText(mTextArray.keyAt(i),mTextArray.valueAt(i));
            }
            //3，设置点击
            int clickArraySize=mClickArray.size();
            for (int i=0;i<clickArraySize;i++){
                mAlert.setOnClickListener(mClickArray.keyAt(i),mClickArray.valueAt(i));
            }

            //4，配置自定义效果，全屏，从底部弹出  默认动画
            Window window=mAlert.getWindow();
            //设置位置
            window.setGravity(mGravity);
            //设置动画
            if (mAnimation!=0) {
                window.setWindowAnimations(mAnimation);
            }
            //设置宽高
            WindowManager.LayoutParams params=window.getAttributes();
            params.width=mWidth;
            params.height=mHeight;
            window.setAttributes(params);
        }
    }
}
