/**
 * @项目名称：517TelMeeting
 * @文件名：ResponseCallBack.java
 * @版本信息：
 * @日期：2015年7月24日
 * @Copyright 2015 www.517na.com Inc. All rights reserved.
 */
package com.ktcd.malc.utilslibrary.net;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import io.reactivex.disposables.Disposable;

/**
 * 
 * @author xiangbo
 * @作者 E-mail:284285624@qq.com
 * @date 创建时间：2015年8月19日 下午3:58:36
 * @version 1.0 @描述：
 */
public abstract class ResponseCallBack<T extends Object> {

	/**
	 * @description 获取当前的泛型对象
	 * @date 2015年8月5日
	 */
	protected final Class<T> initGenericClass() {
		Type genType = getClass().getGenericSuperclass();
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		if (params != null && params.length > 0 && params[0] instanceof Class<?>) {
			return (Class<T>) params[0];
		} else {
			throw new IllegalArgumentException("泛型错误");
		}
	}
	/**
	 * 开始发起网络请求的回调
	 */
	protected abstract void onLoad(Disposable d);

	/**
	 * 网络请求出错的回调函数
	 */
	protected abstract void onError(KtkjError error);
	/**
	 * 网络请求成功后的回调处理函数
	 */
	protected abstract void onSuccess(T result);

	protected void onSuccessList(Object result ){};//纯list使用
}