package com.ktcd.malc.utilslibrary.tools;

import android.app.ActivityManager;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;

import java.io.File;
import java.util.List;

/**
 * 描述： 获取应用程序相关信息
 * 
 * @creator genie@517na.com
 */
public final class PackageUtils {

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param mContext
	 * @return
	 */
	public static int getVersionCode(Context mContext) {
		int versionCode = -1;
		try {
			versionCode = mContext.getPackageManager().getPackageInfo(
					getPackageName(mContext), 0).versionCode;
			return versionCode;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return -1;
		}
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param mContext
	 * @return
	 */
	public static String getVersionName(Context mContext) {
		String versionName = "";
		try {
			versionName = mContext.getPackageManager().getPackageInfo(
					getPackageName(mContext), 0).versionName;
			return versionName;
		} catch (NameNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param mContext
	 * @return
	 */

	public static String getPackageName(Context mContext) {
		return mContext.getPackageName();
	}

	/**
	 * 安装APK
	 * 
	 * @param file
	 * @param context
	 */
	public static void installAPK(File file, Context context) {
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.setDataAndType(Uri.fromFile(file),
				"application/vnd.android.package-archive");
		context.startActivity(intent);
	}

	/**
	 * get currnet activity's name
	 * 
	 * @param context
	 * @return
	 */
	public static String getActivityName(Context context) {
		if (context == null) {
			return "";
		}
		ActivityManager am = (ActivityManager) context
				.getSystemService(Context.ACTIVITY_SERVICE);
		if (checkPermissions(context, "android.permission.GET_TASKS")) {
			ComponentName cn = am.getRunningTasks(1).get(0).topActivity;
			String activityName = cn.getShortClassName();
			activityName = activityName.substring(
					activityName.lastIndexOf(".") + 1, activityName.length());
			return activityName;
		} else {
			LogUtils.e("lost permission", "android.permission.GET_TASKS");
			return "";
		}

	}

	/**
	 * checkPermissions
	 * 
	 * @param context
	 * @param permission
	 * @return true or false
	 */
	public static boolean checkPermissions(Context context, String permission) {
		PackageManager localPackageManager = context.getPackageManager();
		return localPackageManager.checkPermission(permission,
				context.getPackageName()) == PackageManager.PERMISSION_GRANTED;
	}
	/**
	 * @description 获取APPLICATION metadata的数据
	 * @date 2015-09-12
	 * @param
	 * @return String
	 * @Exception
	 */
	public static Object getApplicationMetaData(Context context, String key) {
		Object sRst = null;
		ApplicationInfo appInfo = null;
		if (context == null || StringUtils.isEmpty(key)) {
			return null;
		}
		try {
			appInfo = context.getPackageManager()
					.getApplicationInfo(context.getPackageName(),
							PackageManager.GET_META_DATA);
			sRst =""+appInfo.metaData.get(key);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return sRst;
	}

	public  static String getApplicationName(Application application) {
		PackageManager packageManager = null;
		ApplicationInfo applicationInfo = null;
		try {
			packageManager =application.getPackageManager();
			applicationInfo = packageManager.getApplicationInfo(getPackageName(application), 0);
		} catch (NameNotFoundException e) {
			applicationInfo = null;
		}
		String applicationName =
				(String) packageManager.getApplicationLabel(applicationInfo);
		return applicationName;
	}
	public static boolean isWeixinAvilible(Context context) {
		final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
		List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
		if (pinfo != null) {
			for (int i = 0; i < pinfo.size(); i++) {
				String pn = pinfo.get(i).packageName;
				if (pn.equals("com.tencent.mm")) {
					return true;
				}
			}
		}
		return false;
	}
}
