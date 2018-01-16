package com.ktcd.malc.utilslibrary.tools;

/**
 * 
 * @author xiangbo
 * @作者 E-mail:284285624@qq.com
 * @date 创建时间：2015年8月19日 下午3:19:40
 * @version 1.0
 * @描述：用于Log输出
 */
public final class LogUtils {

	private static final String TAG = LogUtils.class.getSimpleName();

	private static boolean DEBUG = false;

	public static void setDebug(boolean debug) {
		DEBUG = debug;
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param msg
	 */
	public static void i(String msg) {
		i(TAG, msg);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param msg
	 */
	public static void d(String msg) {
		d(TAG, msg);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param msg
	 */
	public static void e(String msg) {
		e(TAG, msg);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param msg
	 */
	public static void v(String msg) {
		v(TAG, msg);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param tag
	 * @param msg
	 */
	public static void i(String tag, String msg) {
		if (DEBUG)
			android.util.Log.i(tag, msg);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param tag
	 * @param msg
	 */
	public static void e(String tag, String msg) {
		if (DEBUG)
			android.util.Log.e(tag, msg);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param tag
	 * @param msg
	 */
	public static void d(String tag, String msg) {
		if (DEBUG)
			android.util.Log.d(tag, msg);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param tag
	 * @param msg
	 */
	public static void v(String tag, String msg) {
		if (DEBUG)
			android.util.Log.v(tag, msg);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param tag
	 * @param msg
	 */
	public static void w(String tag, String msg) {
		if (DEBUG)
			android.util.Log.w(tag, msg);
	}

	/**
	 * @Description: 打印带方法名，类名，行号的Log @param @param tag Log标签 @param @param msg
	 *               要打印的信息 @return void @throws
	 */
	public static void showLogCat(String tag, String msg) {
		if (DEBUG) {
			StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
			int currentIndex = -1;
			for (int i = 0; i < stackTraceElement.length; i++) {
				if (stackTraceElement[i].getMethodName().compareTo("showLogCat") == 0) {
					currentIndex = i + 1;
					break;
				}
			}

			String fullClassName = stackTraceElement[currentIndex].getClassName();
			String className = fullClassName.substring(fullClassName.lastIndexOf(".") + 1);
			String methodName = stackTraceElement[currentIndex].getMethodName();
			String lineNumber = String.valueOf(stackTraceElement[currentIndex].getLineNumber());
			i(tag, "at " + fullClassName + "." + methodName + "(" + className + ".java:" + lineNumber + ") \n" + msg);
		}
	}

}
