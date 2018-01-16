package com.ktcd.malc.utilslibrary.tools;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/**
 * 
 * @author xiangbo
 * @作者 E-mail:284285624@qq.com
 * @date 创建时间：2015年8月19日 下午3:18:01
 * @version 1.0 @描述：
 */
public final class PhoneUtils {

	/** 验证手机号码 */
	public static boolean validatePhoneNum(String phoneNum) {
		if (TextUtils.isEmpty(phoneNum)) {
			return false;
		}
		String regex = "[1][34578]\\d{9}";
		if (phoneNum.matches(regex)) {
			return true;
		}else {
			return false;
		}
	}

	/**
	 * 判断是否有网络
	 * 
	 * @param mContext
	 * @return
	 */
	public static boolean isNetworkAvailable(Context mContext) {
		if(mContext!=null) {
			ConnectivityManager mConnectivityManager = (ConnectivityManager) mContext
					.getSystemService(Context.CONNECTIVITY_SERVICE);
			if (mConnectivityManager!=null) {
				NetworkInfo mNetworkInfo = mConnectivityManager.getActiveNetworkInfo();
				if (mNetworkInfo != null) {
					return mNetworkInfo.isAvailable();
				}
			}else{
				return false;
			}
		}
		return false;
	}

	/**
	 * 判断Sim卡是否良好
	 * 
	 * @param mContext
	 * @return
	 */
	public static boolean isSimStateReady(Context mContext) {
		/*
		 * TelephonyManager telephonyManager = (TelephonyManager)
		 * TelMeetingApplication.getInstance()
		 * .getSystemService(Context.TELEPHONY_SERVICE);
		 */
		TelephonyManager telephonyManager = (TelephonyManager) mContext.getSystemService(Context.TELEPHONY_SERVICE);
		int simState = telephonyManager.getSimState();
		if (simState == TelephonyManager.SIM_STATE_READY) {
			return true;
		}

		return false;
	}
	//获得手机系统版本号
	public static int getAndroidSDKVersion() {
		int version = 0;
		try {
			version = Integer.valueOf(android.os.Build.VERSION.SDK);
		} catch (NumberFormatException e) {
		}
		return version;
	}

	/**
	 * 判断sd卡是否挂载
	 * @return
	 */
	public static boolean hasSdcard() {
		return Environment.getExternalStorageState().equals(
				Environment.MEDIA_MOUNTED);
	}
}
