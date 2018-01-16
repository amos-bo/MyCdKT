package com.ktcd.malc.utilslibrary.tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author xiangbo
 * @version 1.0
 * @作者 E-mail:284285624@qq.com
 * @date 创建时间：2015年8月19日 下午3:24:12
 * @描述：时间处理类
 */
public class DateTimeUtils {

    /**
     * 获取指定开始结束时间的字符串
     *
     * @param startTime
     * @param endTime
     * @return
     * @description
     * @date 2015年7月27日
     */
    public static String getDate(long startTime, long endTime) {
        StringBuilder builder = new StringBuilder();

        SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日", Locale
                .getDefault());
        builder.append(sdf.format(startTime));

        sdf = new SimpleDateFormat("HH:mm", Locale.getDefault());
        builder.append(" ");
        builder.append(sdf.format(startTime));
        builder.append("-");
        builder.append(sdf.format(endTime));
        return builder.toString().trim();
    }

    /**
     * 获取时间跨度
     *
     * @param stime
     * @param etime
     * @return
     * @description
     * @date 2015年7月28日
     */
    public static String getDate(String stime, String etime) {
        return getDate(stime, etime, "yyyy-MM-dd HH:mm");
    }

    /**
     * 获取日期跨度
     *
     * @param stime
     * @param etime
     * @param format
     * @return
     * @description
     * @date 2015年7月28日
     */
    public static String getDate(String stime, String etime, String format) {
        StringBuilder sBuilder = new StringBuilder();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format,
                Locale.getDefault());
        try {
            Date startTime = simpleDateFormat.parse(stime);
            Date endTime = simpleDateFormat.parse(etime);
            simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm",
                    Locale.getDefault());
            sBuilder.append(simpleDateFormat.format(startTime));
            sBuilder.append(" - ");
            simpleDateFormat = new SimpleDateFormat("HH:mm", Locale
                    .getDefault());
            sBuilder.append(simpleDateFormat.format(endTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sBuilder.toString();
    }

    /**
     * 按照指定格式返回当前时间字符串
     *
     * @param format
     * @return
     * @description
     * @date 2015年7月27日
     */
    public static String getCurrentTime(String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format, Locale.getDefault
                ());
        Date date = new Date(System.currentTimeMillis());
        return sdf.format(date);
    }

    /**
     * 返回默认格式的当前时间【2012-12-23 07:45】
     *
     * @return
     * @description
     * @date 2015年7月27日
     */
    public static String getCurrentTime() {
        return getCurrentTime("yyyy-MM-dd HH:mm:ss");
    }

    /**
     * @param smdate
     * @param edate
     * @return 获取两个时间差天数
     * @throws ParseException
     */
    public static int getDaysBetween(String smdate, String edate) throws
            ParseException {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long day = 0;
        Date date = myFormatter.parse(smdate);
        Date mydate = myFormatter.parse(edate);
        day = (mydate.getTime() - date.getTime()) / (24 * 60 * 60 * 1000);
        return (int) day;
    }

    public static String getYearMounthDayChar(String timeStr,String ymd){
        if (!StringUtils.isEmpty(timeStr)){
        timeStr = timeStr.replace("/","-");

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date d2 = null;
        try {
            d2 = formatter.parse(timeStr);
        } catch (Exception e) {
            e.printStackTrace();
        }

        SimpleDateFormat sdf0 = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdf1 = new SimpleDateFormat("MM");
        SimpleDateFormat sdf2= new SimpleDateFormat("dd");
        SimpleDateFormat sdf3= new SimpleDateFormat("yyyy年MM月dd日");
        String year = sdf0.format(d2);
        String mounth = sdf1.format(d2);
        String day = sdf2.format(d2);
        String mYearMunthDay = sdf3.format(d2);
        if (ymd.equals("YEAR")){//返回年份
            return year;
        }else if (ymd.equals("MOUNTH")){//返回月份
            return mounth;
        }else if (ymd.equals("DAY")){//返回天
            return day;
        }else{
            return mYearMunthDay;//返回年月日格式：2016年7月6日
        }
        }else{
            return " 年 月 日";
        }
    }

}
