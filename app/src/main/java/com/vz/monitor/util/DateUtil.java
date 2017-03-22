package com.vz.monitor.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日期与时间辅助类
 * @author 谭汉才
 * @date 2012-09-12
 */
public class DateUtil {
	public static final String TYPE_DATE_TIME_1 	= "yyyy-MM-dd HH:mm:ss";
	public static final String TYPE_DATE_TIME_2		= "yyyyMMdd_HHmmss";
	public static final String TYPE_DATE 			= "yyyy-MM-dd";
	public static final String TYPE_TIME 		 	= "HH:mm:ss";
	public static final String TYPE_TIME_1		 	= "HH-mm-ss";

	/**
	 * 获取当前的日期
	 * @return 样式为yyyy-MM-dd的日期字符串
	 */
	public static final String getNowDate(){
		return getNowDateAndTime(TYPE_DATE);
	}

	/**
	 * 获取当前的时间
	 * @return 样式为HH-mm-ss的时间字符串
	 */
	public static final String getNowTime() {
		return getNowDateAndTime(TYPE_TIME);
	}

	/**
	 * 获取当前的日期和时间
	 * @param style 日期和时间的样式风格
	 * @return 返回具有style样式格式的日期和时间字符串
	 */
	public static final String getNowDateAndTime(String style) {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		String timeStr = sdf.format(date);
		return timeStr;
	}

	public static final String getNowDateAndTime(String style, int differ) {
		Calendar calendar = Calendar.getInstance();
		long time = calendar.getTime().getTime() + differ * 1000;
		Date date = new Date(time);
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		String timeStr = sdf.format(date);
		return timeStr;
	}

	public static final String getDate(Calendar calendar, String style) {
		Date date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat(style);
		String dateString = sdf.format(date);
		return dateString;
	}

	/**
	 * 把日期字符串转成Calendar日期类型
	 * @param dateStr 时期字符串
	 * @return Calendar日期类型
	 */
	public static final Calendar string2Calendar(String dateStr) {
		GregorianCalendar calendar = null;
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(TYPE_DATE_TIME_1);
			Date date = sdf.parse(dateStr);
			calendar = new GregorianCalendar();
			calendar.setTime(date);
		} catch (Exception e) {
			return null;
		}
		return calendar;
	}
	
	public static final String string2String(String str) {
		StringBuilder builder = new StringBuilder();
		for(int i = 0;i<str.length();i++){
			Character temp = Character.valueOf(str.charAt(i));
			if(!"-".equals(temp.toString()) && !":".equals(temp.toString()) && !" ".equals(temp.toString()) ) {
				builder.append(temp);
			}
		}
		return builder.toString();
	}
	
	public static final String millisecond2String(long millisecond) {
		Date d = new Date(millisecond);
		String dStr = "";
		try{
			SimpleDateFormat sdf = new SimpleDateFormat(TYPE_DATE_TIME_1);
			dStr = sdf.format(d);
		} catch (Exception e) {
		}
		return dStr;
	}
	
	public static final String convertTime(int second) {
		String text = "00:00";
		
		if(second>=0) {
			int s = second % 60;
			int m = (second / 60) % 60;
			
			
			text= String.format("%02d:%02d", m,s);
		}
		
		return text;
	}
}
