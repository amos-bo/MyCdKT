package com.ktcd.malc.utilslibrary.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;

import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @author xiangbo
 * @作者 E-mail:284285624@qq.com
 * @date 创建时间：2015年8月19日 下午3:17:11
 * @version 1.0 
 * @描述：
 */
public class SPUtils {

	private Context mContext;

	private SharedPreferences mSp = null;

	private Editor mEdit = null;

	/**
	 * Create DefaultSharedPreferences
	 * 
	 * @param mContext
	 */
	public SPUtils(Context mContext) {
		this(mContext, PreferenceManager.getDefaultSharedPreferences(mContext));
	}

	/**
	 * Create SharedPreferences by filename
	 * 
	 * @param mContext
	 * @param filename
	 */
	public SPUtils(Context mContext, String filename) {
		this(mContext, mContext.getSharedPreferences(filename, Context.MODE_MULTI_PROCESS | Context.MODE_PRIVATE));
	}

	/**
	 * Create SharedPreferences by SharedPreferences
	 * 
	 * @param context
	 * @param sp
	 */
	public SPUtils(Context context, SharedPreferences sp) {
		this.mContext = context;
		this.mSp = sp;
		mEdit = sp.edit();
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param key
	 * @param value
	 */
	public void setValue(String key, boolean value) {
		mEdit.putBoolean(key, value);
		mEdit.commit();
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param resKey
	 * @param value
	 */
	public void setValue(int resKey, boolean value) {
		setValue(this.mContext.getString(resKey), value);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param key
	 * @param value
	 */
	public void setValue(String key, float value) {
		mEdit.putFloat(key, value);
		mEdit.commit();
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param resKey
	 * @param value
	 */
	public void setValue(int resKey, float value) {
		setValue(this.mContext.getString(resKey), value);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param key
	 * @param value
	 */
	public void setValue(String key, int value) {
		mEdit.putInt(key, value);
		mEdit.commit();
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param resKey
	 * @param value
	 */
	public void setValue(int resKey, int value) {
		setValue(this.mContext.getString(resKey), value);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param key
	 * @param value
	 */
	// Long
	public void setValue(String key, long value) {
		mEdit.putLong(key, value);
		mEdit.commit();
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param resKey
	 * @param value
	 */
	public void setValue(int resKey, long value) {
		setValue(this.mContext.getString(resKey), value);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param key
	 * @param value
	 */
	// String
	public void setValue(String key, String value) {
		mEdit.putString(key, value);
		mEdit.commit();
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param resKey
	 * @param value
	 */
	public void setValue(int resKey, String value) {
		setValue(this.mContext.getString(resKey), value);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public boolean getValue(String key, boolean defaultValue) {
		return mSp.getBoolean(key, defaultValue);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param resKey
	 * @param defaultValue
	 * @return
	 */
	public boolean getValue(int resKey, boolean defaultValue) {
		return getValue(this.mContext.getString(resKey), defaultValue);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	// Float
	public float getValue(String key, float defaultValue) {
		return mSp.getFloat(key, defaultValue);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param resKey
	 * @param defaultValue
	 * @return
	 */
	public float getValue(int resKey, float defaultValue) {
		return getValue(this.mContext.getString(resKey), defaultValue);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	// Integer
	public int getValue(String key, int defaultValue) {
		return mSp.getInt(key, defaultValue);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param resKey
	 * @param defaultValue
	 * @return
	 */
	public int getValue(int resKey, int defaultValue) {
		return getValue(this.mContext.getString(resKey), defaultValue);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	// Long
	public long getValue(String key, long defaultValue) {
		return mSp.getLong(key, defaultValue);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param resKey
	 * @param defaultValue
	 * @return
	 */
	public long getValue(int resKey, long defaultValue) {
		return getValue(this.mContext.getString(resKey), defaultValue);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	// String
	public String getValue(String key, String defaultValue) {
		return mSp.getString(key, defaultValue);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param resKey
	 * @param defaultValue
	 * @return
	 */
	public String getValue(int resKey, String defaultValue) {
		return getValue(this.mContext.getString(resKey), defaultValue);
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 * @param key
	 */
	// Delete
	public void remove(String key) {
		mEdit.remove(key);
		mEdit.commit();
	}

	/**
	 * @description
	 * @date 2015年8月5日
	 */
	// Clear
	public void clear() {
		mEdit.clear();
		mEdit.commit();
	}

	/**
	 * @description 移除所有的包含指定字符串的配置项
	 * @date 2016年3月3日
	 * @param indexStr
	 */
	public void removeContainString(String indexStr) {
		Set<String> keys = mSp.getAll().keySet();
		Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			if (key.endsWith(indexStr)) {
				mEdit.remove(key);
			}
		}
		mEdit.commit();
	}

}
