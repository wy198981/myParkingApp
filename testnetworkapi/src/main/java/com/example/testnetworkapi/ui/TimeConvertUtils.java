package com.example.testnetworkapi.ui;

import android.text.format.DateFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Administrator on 2017-02-22.
 */
public class TimeConvertUtils
{
    static private final String formatString = "yyyy-MM-dd HH:mm:ss";

    /**
     * 获取年月日时分秒的字符串
     * 输入: time, 表示毫秒数
     * 输出: 由 yyyy-MM-dd HH:mm:ss 表示的字符串
     */
    public static String longToString(long time)
    {
        return (String) DateFormat.format(formatString, time);
    }

    public static String longToString(String formatString, long time)
    {
        return (String) DateFormat.format(formatString, time);
    }

    /**
     * 获取年月日时分秒的数组
     * 输入: time, 表示毫秒数
     * 输出: 由数组来表示的时间，[0] year; [1] month; [2] day; [3] hour; [4] minute; [5] second;
     */
    public static int[] getArrayDate(long time)
    {
        int[] oResult = new int[6];
        Date date = new Date(time);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        int i = 0;
        oResult[i++] = calendar.get(Calendar.YEAR);
        oResult[i++] = calendar.get(Calendar.MONTH) + 1;
        oResult[i++] = calendar.get(Calendar.DAY_OF_MONTH);
        oResult[i++] = calendar.get(Calendar.HOUR);
        oResult[i++] = calendar.get(Calendar.MINUTE);
        oResult[i++] = calendar.get(Calendar.SECOND);

        return oResult;
    }

    /**
     * 获取指定时间的日历
     * 输入: time, 表示毫秒数
     * 输出: 日历中包含有各种丰富的时间数据，输出想要的日历
     */
    public static Calendar getCalender(long inputDate)
    {
        Date date = new Date(inputDate);
        Calendar calendar = Calendar.getInstance();

        calendar.setTime(date);
        return calendar;
    }

    /**
     * 输出两个单位为毫秒数的时间差
     * enterTime：表示其中一个时间，单位为毫秒
     * currentTime: 表示其中另一个时间，单位为毫秒
     * 注: 如按照年月来比较，逻辑肯定是比较复杂，所以采用秒数据来进行; (这里的处理可能少一天，即对于一年的天数不是确定的？)
     */
    public static String getDateTimeInterval(long enterTime, long currentTime)
    {
        StringBuffer stringBuffer = new StringBuffer();
        // 秒 seconds
        // 以1970 1. 1日来作为时间标准，先相减
        long intervalSeconds;
        if (currentTime - enterTime > 0)
        {
            intervalSeconds = (currentTime - enterTime) / 1000;
        }
        else
        {
            intervalSeconds = (enterTime - currentTime) / 1000;
        }

        // 一年的秒数是不固定的；
        long y = intervalSeconds / (60 * 60 * 24 * 30 * 12); //年
        long remainSeconds = intervalSeconds;
        if (y != 0)
        {
            remainSeconds -= y * (60 * 60 * 24 * 30 * 12);
        }

        long m = remainSeconds / (60 * 60 * 24 * 30);// 月
        if (m != 0)
        {
            remainSeconds -= m * (60 * 60 * 24 * 30);
        }

        long d = remainSeconds / (60 * 60 * 24);// 日
        if (d != 0)
        {
            remainSeconds -= d * (60 * 60 * 24);
        }

        long h = remainSeconds / (60 * 60);// 时
        if (h != 0)
        {
            remainSeconds -= h * (60 * 60);
        }

        long minute = remainSeconds / (60);// 分
        if (minute != 0)
        {
            remainSeconds -= minute * (60);
        }

        boolean zeroFlag = false; // 设置是否为0标记
        if (y != 0)
        {
            stringBuffer.append(y + "年");
        }
        else
        {
            zeroFlag = true;
        }

        if (m == 0 && zeroFlag == true) // 当前月相差 0, 且 年相差为0
        {
            zeroFlag = true;
        }
        else
        {
            stringBuffer.append(m + "月");
        }

        if (d == 0 && zeroFlag == true)
        {
            zeroFlag = true;
        }
        else
        {
            stringBuffer.append(d + "天");
        }

        if (h == 0 && zeroFlag == true)
        {
            zeroFlag = true;
        }
        else
        {
            stringBuffer.append(h + "小时");
        }

        if (minute == 0 && zeroFlag == true)
        {
            zeroFlag = true;
        }
        else
        {
            stringBuffer.append(minute + "分");
        }

        stringBuffer.append(remainSeconds + "秒");

        return stringBuffer.toString();
    }

    /**
     * 将指定年月日时分秒转换成毫秒数
     * 输入: 年 月 日 时 分 秒
     * 输出: 时间的毫秒数
     */
    public static long getMilliSecondByDate(int y, int m, int d, int h, int minute, int s)
    {
        Calendar instance = Calendar.getInstance();
        instance.set(y, m - 1, d, h, minute, s);
        return instance.getTimeInMillis();
    }

    /**
     * 将"yyyy-MM-dd HH:mm:ss"字符串转换毫秒时间
     * 输入：str 例如 2016-11-07 09:23:18
     * 输出：时间的毫秒数 millisSecond
     */
    public static long stringToLong(String str)
    {
        long result = 0;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(formatString);
        try
        {
            Date parse = simpleDateFormat.parse(str);
            result = parse.getTime();
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * 将 date 表示的时间转换成"yyyy-MM-dd HH:mm:ss"的字符串
     * 输入：Date表示日期时间
     * 输出："yyyy-MM-dd HH:mm:ss"格式的时间字符串
     */
    public static String dateToString(Date data)
    {
        return new SimpleDateFormat(formatString).format(data);
    }


    /**
     * 将"yyyy-MM-dd HH:mm:ss"的时间字符串转换成date
     * 输入：strTime 表示"yyyy-MM-dd HH:mm:ss"的时间
     * 输出：Date 表示日期结构
     */
    public static Date stringToDate(String strTime)
    {
        SimpleDateFormat formatter = new SimpleDateFormat(formatString);
        Date date = null;
        try
        {
            date = formatter.parse(strTime);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 将long的毫秒数的时间转换成date结构
     * 输入：currentTime:表示毫秒数时间
     * 输出：Date 表示日期结构
     */
    public static Date longToDate(long currentTime)
    {
        Date dateOld = new Date(currentTime); // 根据long类型的毫秒数生命一个date类型的时间
        String sDateTime = dateToString(dateOld); // 把date类型的时间转换为string
        Date date = stringToDate(sDateTime); // 把String类型转换为Date类型
        return date;
    }

    /**
     * date要转换的date类型的时间
     * 输入：date 表示日期时间
     * 输出：表示的毫秒数
     */
    public static long dateToLong(Date date)
    {
        return date.getTime();
    }

}

