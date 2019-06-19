package com.novo.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToString {
	/**
	 * 把日期转换为字符串
	 * @param date 传入一个时间
	 * @return 返回一个字符串,包括(年、月、日)
	 */
	public static String getString(Date date) {
		String string = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		string = sdf.format(date);
		return string;
	}
	/**
	 * 把日期转换为字符串
	 * @param date 传入一个时间
	 * @return 返回一个字符串,包括(时、分、秒)
	 */
	public static String getStringTime(Date date) {
		String string = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		string = sdf.format(date);
		return string;
	}
	
	/**
	 * 把字符串转换为日期
	 * @param str 输入一个字符串
	 * @return 返回一个时间类型
	 * @throws ParseException 
	 */
	public static Date getDate(String str) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.parse(str);	
	}
}
