package com.ktcd.malc.utilslibrary.net;




import java.io.Serializable;

/**
 * 
 * @author xiangbo
 * @作者 E-mail:284285624@qq.com
 * @date 创建时间：2015年8月19日 下午3:57:39
 * @version 1.0
 * @描述：
 */
public class KtkjError implements Serializable{

	/** 错误码 */
	public String code;
	/** 错误信息 */
	public String msg;
	/** 自定义错误 */
	public KtkjError(String code, String msg) {
		this.code = code;
		this.msg = msg;
	}

}
