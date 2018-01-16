package com.ktcd.malc.utilslibrary.tools;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.FloatRange;
import android.support.v4.content.ContextCompat;


/**
 * @ClassName
 * @Description
 * @Author Xiaoborui
 * @Date 2017/4/18 16:58
 */

public class DrawableUtils {
    /**
     * @param shape       形状
     * @param color       颜色
     * @param corner      圆角
     * @param strokeSize  边框大小
     * @param strokeColor 边框颜色
     * @param width       宽
     * @param height      高
     * @param alpha       透明度
     * @return
     */
    public static GradientDrawable getShape(int shape, @ColorInt int color, float corner, int strokeSize, @ColorInt int strokeColor, int width, int height, @FloatRange(from = 0.0D, to = 1.0D) float alpha) {
        GradientDrawable bg = new GradientDrawable();
        bg.setColor(adjustAlpha(color, alpha));
        bg.setShape(shape);
        if (corner > 0)
            bg.setCornerRadius(corner);
        if (strokeSize > 0)
            bg.setStroke(strokeSize, strokeColor);

        if (width > 0 && height > 0)
            bg.setSize(width, height);

        return bg;
    }

    /**
     * @param shape
     * @param color
     * @return
     */
    public static GradientDrawable getShape(int shape, @ColorInt int color) {
        return getShape(shape, color, 0, 0, 0, 0, 0, 1f);
    }

    /**
     * @param corner
     * @param stroke
     * @param color
     * @return
     */
    public static GradientDrawable getCornerWithStroke(float corner, int stroke, @ColorInt int color, @ColorInt int strokeColor) {
        return getShape(GradientDrawable.RECTANGLE, color, corner, stroke, strokeColor, 0, 0, 1f);
    }

    /**
     * @param corner
     * @param color
     * @return
     */
    public static GradientDrawable getCorner(float corner, @ColorInt int color) {
        return getShape(GradientDrawable.RECTANGLE, color, corner, 0, 0, 0, 0, 1f);
    }


    public static Drawable getPressDrawable(@ColorInt int defaultColor, @ColorInt int effectColor) {
        GradientDrawable defaultDrawable = new GradientDrawable();
        defaultDrawable.setColor(defaultColor);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            GradientDrawable contentDrawable = new GradientDrawable();
            contentDrawable.setColor(defaultColor);
            return new RippleDrawable(ColorStateList.valueOf(effectColor),
                    contentDrawable,
                    null);
        } else {
            GradientDrawable effectDrawable = new GradientDrawable();
            effectDrawable.setColor(effectColor);
            StateListDrawable stateListDrawable = new StateListDrawable();
            stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, effectDrawable);
            stateListDrawable.addState(new int[]{}, defaultDrawable);
            return stateListDrawable;
        }
    }

    /**
     * 调整颜色透明度
     *
     * @param paramInt
     * @param paramFloat
     * @return
     */
    @ColorInt
    public static int adjustAlpha(@ColorInt int paramInt, @FloatRange(from = 0.0D, to = 1.0D) float paramFloat) {
        return Color.argb(Math.round(Color.alpha(paramInt) * paramFloat), Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt));
    }

    @ColorInt
    public static int getColor(Context context, @ColorRes int colorRes) {
        return ContextCompat.getColor(context, colorRes);
    }

    public static Drawable getDrawable(Context context, @DrawableRes int drawableRes) {
        return ContextCompat.getDrawable(context, drawableRes);
    }

}
