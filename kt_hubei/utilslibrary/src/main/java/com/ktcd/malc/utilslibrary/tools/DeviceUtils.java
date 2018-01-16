/**
 * @项目名称：DateScrollPicker
 * @文件名：DeviceUitls.java
 * @版本信息：
 * @日期：2015年7月30日
 * @Copyright 2015 www.517na.com Inc. All rights reserved.
 */
package com.ktcd.malc.utilslibrary.tools;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;


/**
 * 
 * @author xiangbo
 * @作者 E-mail:284285624@qq.com
 * @date 创建时间：2015年8月19日 下午3:21:53
 * @version 1.0 
 * @描述：设备处理
 */
public class DeviceUtils {
	/**
	 * 获取控件的高度，如果获取的高度为0，则重新计算尺寸后再返回高度
	 *
	 * @param view
	 * @return
	 */
	public static int getViewMeasuredHeight(View view) {
		calcViewMeasure(view);
		return view.getMeasuredHeight();
	}

	/**
	 * 测量控件的尺寸
	 *
	 * @param view
	 */
	public static void calcViewMeasure(View view) {
		int width = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
		int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
		view.measure(width, expandSpec);
	}

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static int dip2px(Context context, float dpValue) {
		final float scale = context.getResources().getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 判断当前设备是手机还是平板，代码来自 Google I/O App for Android
	 * @param context
	 * @return 平板返回 True，手机返回 False
	 */
	public static boolean isTablet(Context context) {
		return (context.getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) >= Configuration.SCREENLAYOUT_SIZE_LARGE;
	}

}
