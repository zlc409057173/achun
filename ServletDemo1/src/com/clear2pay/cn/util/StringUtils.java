package com.clear2pay.cn.util;

public final class StringUtils {
	public static boolean isNotEmpty(String str){
		return str != null && !"".equals(str) && str.length()>0;
	} 
	public static boolean isEmpty(String str){
		return str == null || "".equals(str) || str.length()<=0;
	} 
}
