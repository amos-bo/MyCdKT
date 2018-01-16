package com.ktcd.malc.utilslibrary.net;


import java.io.Serializable;

public class BaseResponse<T> implements Serializable{
	public String code="";
	public String msg="" ;
	public T data=null;
	public boolean success = false;
	public String timestamp="";
	public String error="";
	public String message="";
}
