package com.ktcd.malc.utilslibrary.tools;

import android.app.Application;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.widget.TextView;

/**
 * 字体工具
 * Created by amos_bo on 2016/2/29.
 */
public class FontUtils {
    /**
     * 修改字體樣式
     *
     * @param tv
     * @param name
     * @param getAssets--(AssetManager getAssets用getAssets()函数即可)
     */
    public static void changeFontStyle(TextView[] tv, String name, AssetManager
            getAssets) {
        Typeface face = Typeface.createFromAsset(getAssets, "fonts/" + name +
                ".ttf");
        for (TextView textview : tv) {
            textview.setTypeface(face);
        }
    }
    /**
     *
     * @Title: setFontSize
     * @Description:防止修改字体大小
     * @param @param Application 设定文件
     * @return void 返回类型
     * @throws
     */
    public static void setFontSize(Application Application) {
        Resources resource = Application.getResources();
        Configuration c = resource.getConfiguration();
        c.fontScale = 1.0f;
        resource.updateConfiguration(c, resource.getDisplayMetrics());
    }
}
