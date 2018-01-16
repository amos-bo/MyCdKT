package com.ktcd.malc.utilslibrary.tools;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * 
 * @author xiangbo
 * @作者 E-mail:284285624@qq.com
 * @date 创建时间：2015年8月19日 下午3:15:22
 * @version 1.0
 * @描述：Toast工具类
 */
public class ToastUtils {

	private static Handler handler = new Handler(Looper.getMainLooper());

	private static Toast toast = null;

	private static Object synObj = new Object();

	/**
	 * Toast发送消息，默认Toast.LENGTH_SHORT
	 */
	public static void showMessage(final Context act, final String msg) {
		showMessage(act, msg, Toast.LENGTH_SHORT);
	}

	/**
	 * Toast发送消息，默认Toast.LENGTH_LONG
	 */
	public static void showMessageLong(final Context act, final String msg) {
		showMessage(act, msg, Toast.LENGTH_LONG);
	}

	/**
	 * Toast发送消息，默认Toast.LENGTH_SHORT
	 */
	public static void showMessage(final Context act, final int msg) {
		showMessage(act, msg, Toast.LENGTH_SHORT);
	}

	/**
	 * Toast发送消息，默认Toast.LENGTH_LONG
	 */
	public static void showMessageLong(final Context act, final int msg) {
		showMessage(act, msg, Toast.LENGTH_LONG);
	}

	/**
	 * Toast发送消息
	 */
	public static void showMessage(final Context act, final int msg, final int len) {
		new Thread(new Runnable() {
			public void run() {
				handler.post(new Runnable() {

					@Override
					public void run() {
						synchronized (synObj) {
							if (toast != null) {
								toast.setText(msg);
								toast.setDuration(len);
							} else {
								toast = Toast.makeText(act, msg, len);
							}
							toast.show();
						}
					}
				});
			}
		}).start();
	}

	/**
	 * Toast发送消息
	 */
	public static void showMessage(final Context act, final String msg, final int len) {
		new Thread(new Runnable() {
			public void run() {
				handler.post(new Runnable() {

					@Override
					public void run() {
						synchronized (synObj) {
							if (toast != null) {
								toast.setText(msg);
								toast.setDuration(len);
							} else {
								toast = Toast.makeText(act, msg, len);
							}
							toast.show();
						}
					}
				});
			}
		}).start();
	}

	/**
	 * 关闭当前Toast
	 */
	public static void cancelCurrentToast() {
		if (toast != null) {
			toast.cancel();
		}
	}

}
