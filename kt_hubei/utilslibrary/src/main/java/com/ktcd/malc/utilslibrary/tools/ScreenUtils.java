package com.ktcd.malc.utilslibrary.tools;

import android.app.Activity;
import android.view.WindowManager;

/**
 * 创建时间 2016/12/7.
 * 创建人： ${xiangbo}
 * 作用：
 * 备注：屏幕
 */
public final class ScreenUtils {
    public static void setScreenBrightness(Activity activity, int value) {
        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
        params.screenBrightness = value / 255f;
        activity.getWindow().setAttributes(params);
    }
}
