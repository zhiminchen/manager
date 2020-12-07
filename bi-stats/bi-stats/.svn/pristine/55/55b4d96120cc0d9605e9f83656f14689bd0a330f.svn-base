package com.zhuoqu.slg.data.bi.stats.util;


import com.zhuoqu.slg.data.bi.stats.constant.FiledPool;
import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Description:
 *
 * @Author: lxl217
 * @Date:2020/8/26:15:17
 */
public class TimeUtils {

    public static final long SECOND = 1000L;
    public static final long MINUTE = 60 * SECOND;
    public static final long HOUR = 60 * MINUTE;
    public static final long DAY = 24 * HOUR;
    public static final long WEEK = 7 * DAY;
    public static final long MILLIS_IN_GTM = TimeZone.getDefault().getOffset(0);

    private static final SimpleDateFormat datetimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private static long toSeminaryGMT(long time) {
        return time + MILLIS_IN_GTM;
    }



    /** 日期格式化*/
    public static final String format = "yyyy-MM-dd";

    /** 日期格式化*/
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    /** 到秒级别的格式化*/
    public static final DateTimeFormatter SECOND_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /** 零点格式化*/
    public static final DateTimeFormatter HOUR_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:00:00");

    /** 后缀零点*/
    public static final String DAY_TAIL_ZERO = " 00:00:00";

    /** 一天最大的小时-秒数*/
    private static final String DAY_TAIL_END = " 23:59:59";

    /** 晚上10点*/
    public static final String DAY_22_POINT = " 22:00:00";




    /** 计算机默认的起始事件*/
    public static final String DEFAUL_DATE_TIME = "1971-01-01 00:00:00";

    /**  本地时区编号 */
    public static final int localZoneIdNo;

    static {
        // 获取本地的时区
        TimeZone timeZone = TimeZone.getDefault();
        // 获取毫秒数偏移量
        int offsetSeconds = timeZone.getRawOffset();
        // 算出时区
        localZoneIdNo = offsetSeconds / (FiledPool.ONE_HOUR);
    }






    /**
     * 判断两个时间是否是相同周的
     *
     * @param time1
     * @param time2
     * @param n     小时偏移量 比如n=5 那么这周一的5点以后和下周一的5点以前算为同一周
     * @return
     */
    public static boolean isSameWeek(Date time1, Date time2, int n) {
        if (Math.abs(time1.getTime() - time2.getTime()) > WEEK) {
            return false;
        }
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setFirstDayOfWeek(Calendar.MONDAY);
        calendar1.setFirstDayOfWeek(Calendar.MONDAY);
        calendar1.setTime(time1);
        calendar2.setTime(time2);
        calendar1.add(Calendar.HOUR_OF_DAY, -n);
        calendar2.add(Calendar.HOUR_OF_DAY, -n);
        int week1 = calendar1.get(Calendar.WEEK_OF_YEAR);
        int week2 = calendar2.get(Calendar.WEEK_OF_YEAR);
        return week1 == week2;

    }

    /**
     * 是否同月份
     *
     * @param date1 日期1
     * @param date2 日期2
     * @return
     */
    public static boolean isSameMonth(Date date1, Date date2) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTime(date1);
        calendar2.setTime(date2);
        int m1 = calendar1.get(Calendar.MONTH);
        int m2 = calendar2.get(Calendar.MONTH);
        int year1 = calendar1.get(Calendar.YEAR);
        int year2 = calendar2.get(Calendar.YEAR);
        return year1 == year2 && m1 == m2;
    }

    /**
     * 是否同月份
     *
     * @param time1 时间1
     * @param time2 时间2
     * @return
     */
    public static boolean isSameMonth(long time1, long time2) {
        Calendar calendar1 = Calendar.getInstance();
        Calendar calendar2 = Calendar.getInstance();
        calendar1.setTimeInMillis(time1);
        calendar2.setTimeInMillis(time2);

        int m1 = calendar1.get(Calendar.MONTH);
        int m2 = calendar2.get(Calendar.MONTH);
        int year1 = calendar1.get(Calendar.YEAR);
        int year2 = calendar2.get(Calendar.YEAR);
        return year1 == year2 && m1 == m2;
    }


    public static int getAcrossDay(Date early, Date later) {

        return getAcrossDay(early.getTime(), later.getTime());
    }


    public static int getAcrossDay(long early, long later) {

        early = toSeminaryGMT(early);
        later = toSeminaryGMT(later);
        return Math.abs((int) (later / DAY - early / DAY));
    }

    /**
     * 获取今天第几小时的时间戳
     *
     * @param hour
     * @return
     */
    public static long getTodayHourMs(int hour) {
        Date currentTime = new Date();
        return getAfterDayHourMs(currentTime, 0, hour);
    }


    /**
     * 获取给定时间的几天后的0点0分0秒 时间戳 如果是当天day传0
     *
     * @param currentTime
     * @param day
     * @return
     */
    public static long getAfterDayZeroMillis(Date currentTime, int day) {
        return getAfterDayHourMs(currentTime, day, 0);

    }

    /**
     * 获取几天后的0点0分0秒 Date形式
     *
     * @param day
     * @return
     */
    public static Date getAfterDayZeroDate(Date currentTime, int day) {

        return new Date(getAfterDayZeroMillis(currentTime, day));
    }


    /**
     * 获取给定时间的几天后的几点整的时间，比如获取给定时间2天后5点整的时间
     *
     * @param currentTime 给定时间
     * @param day         几天后
     * @param hour        几点整
     * @return 时间戳
     */
    public static long getAfterDayHourMs(Date currentTime, int day, int hour) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(currentTime);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTimeInMillis() + day * DAY;
    }


    public static void main(String[] args) {

        long todayHourMs = getAfterDayHourMs(new Date(), 10, 10);
        System.out.println(todayHourMs);
    }



    /**
     *  系统时间 SU -> second unit
     * @return long
     */
    public static long systemIntTime(){

        return System.currentTimeMillis()/1000;
    }

    /**
     *  系统时间 MU ->  单位毫秒
     * @return long
     */
    public static long  systemTimeMU(){
        return System.currentTimeMillis();
    }

    /**
     * 系统时间  NU -> 纳秒
     * @return
     */
    public static long systemTimeNU() {return System.nanoTime();}

    /**
     *  系统时间 SU -> second unit
     * @return long
     */
    public static long systemTimeSU(){

        return System.currentTimeMillis()/1000;
    }

    /**
     * 格式化当天 格式化后的结果是  yyyy-mm-dd
     *
     * @return String
     */
    public static String formatCurrDay(){
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.now();

        return ldt.format(dtf);
    }

    /**
     * 带有零点
     *
     * @return
     */
    public static String formatCurrDayZero(){
        return formatCurrDay()+ DAY_TAIL_ZERO;
    }



    /**
     * 获取当前月份
     * */
    public static Integer getNowMonth() {
        LocalDateTime ldt = LocalDateTime.now();
        int year = ldt.getYear();
        int month = ldt.getMonthValue();
        String monthStr = String.valueOf(month);
        if (month < FiledPool.NUM_10) {
            monthStr = "0" + monthStr;
        }
        return Integer.valueOf (year+""+monthStr);
    }

    /**
     * 获取当前周末0点的时间戳
     * */
    public static long getNowWeekWithSunday() {
        LocalDateTime ldt = LocalDateTime.now();
        switch (ldt.getDayOfWeek()) {
            case MONDAY:
                //周一
                ldt = ldt.plusDays(6);
                break;
            case TUESDAY:
                //周二
                ldt = ldt.plusDays(5);
                break;
            case WEDNESDAY:
                //周三
                ldt = ldt.plusDays(4);
                break;
            case THURSDAY:
                //周四
                ldt = ldt.plusDays(3);
                break;
            case FRIDAY:
                //周五
                ldt = ldt.plusDays(2);
                break;
            case SATURDAY:
                //周六
                ldt = ldt.plusDays(1);
                break;
            default:
                break;
        }

        ldt = LocalDateTime.of(ldt.toLocalDate(), LocalTime.MIN);

        return LocalDateTime.from(ldt).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()/ FiledPool.NUM_1000;
    }

    /**
     * 获取下周末0点的时间戳
     * */
    public static long getNextWeekWithSunday() {
        LocalDateTime ldt = LocalDateTime.now();
        //当前日期加7天就是下周
        ldt = ldt.plusDays(7);
        switch (ldt.getDayOfWeek()) {
            case MONDAY:
                //周一
                ldt = ldt.plusDays(6);
                break;
            case TUESDAY:
                //周二
                ldt = ldt.plusDays(5);
                break;
            case WEDNESDAY:
                //周三
                ldt = ldt.plusDays(4);
                break;
            case THURSDAY:
                //周四
                ldt = ldt.plusDays(3);
                break;
            case FRIDAY:
                //周五
                ldt = ldt.plusDays(2);
                break;
            case SATURDAY:
                //周六
                ldt = ldt.plusDays(1);
                break;
            default:
                break;
        }

        ldt = LocalDateTime.of(ldt.toLocalDate(), LocalTime.MIN);

        return LocalDateTime.from(ldt).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()/ FiledPool.NUM_1000;
    }

    /**
     * 时间戳 转格式化 日期时间
     * @param time
     * @return
     */
    public static String timeStamp2FormatDateTime(long time){

        LocalDateTime ldt = LocalDateTime.ofEpochSecond(time / 1000, 0, ZoneOffset.ofHours(localZoneIdNo));
        return ldt.format(SECOND_DATE_TIME_FORMATTER);
    }

    /**
     * 格式化当前时间点
     *
     * @return
     */
    public static String formatCurrDateTime(){

        LocalDateTime ldt = LocalDateTime.now();

        return ldt.format(SECOND_DATE_TIME_FORMATTER);
    }

    /**
     * str 转  秒
     * @param strTime  格式为 "2019-01-01 23:00:00"
     * @return
     */
    public static long strTime2Time(String strTime){

        LocalDateTime ldt = LocalDateTime.parse(strTime, SECOND_DATE_TIME_FORMATTER);

        return LocalDateTime.from(ldt).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

    }


    /**
     * 格式化指定时间
     *
     * @param  time 单位秒
     * @return String   yyyy-mm-dd 格式
     */
    public static String formatTime(Long time){
        DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
        LocalDateTime ldt = LocalDateTime.ofEpochSecond(time, 0, ZoneOffset.ofHours(localZoneIdNo));

        return ldt.format(dtf);
    }

    /**
     * 不带小时 分 秒的格式化
     *
     * @return
     */
    public static String formatCurrDayWithoutMS(){

        return formatCurrDay().substring(0 ,10) ;
    }

    /**
     * 获取当天的0点
     * */
    public static long todayZeroPoint() {
        LocalDateTime time = LocalDateTime.now();

        String dayStr = DATE_TIME_FORMATTER.format(time) + DAY_TAIL_ZERO;

        LocalDateTime ldt = LocalDateTime.parse(dayStr, SECOND_DATE_TIME_FORMATTER);

        return LocalDateTime.from(ldt).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()/ FiledPool.NUM_1000;
    }


    /**
     * 获取指定时间戳的0点时间
     * */
    public static long timeSUtoZeroPoint(long timeSU) {

        LocalDateTime time = LocalDateTime.ofEpochSecond(timeSU, 0, ZoneOffset.ofHours(localZoneIdNo));

        String dayStr = DATE_TIME_FORMATTER.format(time) + DAY_TAIL_ZERO;

        LocalDateTime ldt = LocalDateTime.parse(dayStr, SECOND_DATE_TIME_FORMATTER);

        return LocalDateTime.from(ldt).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()/ FiledPool.NUM_1000;
    }



    /**
     * 获取下一天的零点时间戳  （单位秒）
     *
     * @return
     */
    public static long nextDayZeroPoint(){

        LocalDateTime time = LocalDateTime.now();
        LocalDateTime nexTtime =time.plusDays(1);
        String dayStr = DATE_TIME_FORMATTER.format(nexTtime) + DAY_TAIL_ZERO;

        LocalDateTime ldt = LocalDateTime.parse(dayStr, SECOND_DATE_TIME_FORMATTER);

        return LocalDateTime.from(ldt).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli()/ FiledPool.NUM_1000;
    }

    /**
     *
     * @param strDay : 格式为 2019-05-12 这种格式
     * @return
     */
    public static long strDay2Time(String strDay){

        if(StringUtils.isEmpty(strDay)){
            throw new IllegalArgumentException("非常字符串日期");
        }

        strDay += DAY_TAIL_ZERO;
        LocalDateTime ldt = LocalDateTime.parse(strDay, SECOND_DATE_TIME_FORMATTER);


        return LocalDateTime.from(ldt).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

    }

    /**
     * 日期相加
     *
     * @param strDay
     * @param days
     * @return
     */
    public static String dayPlus(String strDay , int days ){

        if(StringUtils.isEmpty(strDay)){
            throw new IllegalArgumentException("非常字符串日期");
        }

        strDay = strDay.substring(0,10);
        strDay += DAY_TAIL_ZERO;
        LocalDateTime ldt = LocalDateTime.parse(strDay, SECOND_DATE_TIME_FORMATTER);

        LocalDateTime nldt = ldt.plusDays(days);
        return DATE_TIME_FORMATTER.format(nldt);

    }


    /**
     * 日期相加 带有尾号
     *
     * @param strDay
     * @param days
     * @return
     */
    public static String dayPlusEnd(String strDay , int days ){

        if(StringUtils.isEmpty(strDay)){
            throw new IllegalArgumentException("非常字符串日期");
        }

        strDay = strDay.substring(0 ,10);

        strDay += DAY_TAIL_ZERO;
        LocalDateTime ldt = LocalDateTime.parse(strDay, SECOND_DATE_TIME_FORMATTER);

        LocalDateTime nldt = ldt.plusDays(days);
        return DATE_TIME_FORMATTER.format(nldt) + DAY_TAIL_END;

    }








    /**
     * 计算出两个时间点(中点时间 比如 12:30 13:30 14:30)中有多少个自然时间整点
     * <p>
     * 时间单位都是秒
     *
     * @param startTime
     * @param endTime
     */
    public static int listHalfNatureHourPointNum(long startTime, long endTime, int hours) {

        if (startTime > endTime) {
            return 0;
        }


        if(hours < 0 ){
            hours = FiledPool.NUM_8 ;
        }

        String hourForm = formatCurrDateTime();

        hourForm = hourForm.substring(0,14)+"30:00";

        long timePoint = strTime2Time(hourForm);
        timePoint /= FiledPool.NUM_1000;

        int count = 0;

        int  h0 = hours + 2 ;

        // 采用倒叙来计算，需求
        for(int j = h0 ; j> 0 ;j --){


            if(timePoint >= startTime && timePoint <= endTime){
                count ++ ;
            }

            timePoint -= FiledPool.HOUR_SECOND;

        }


        if(count > hours){
            count = hours ;
        }


        return count;
    }


    /**
     * 计算出两个时间点中有多少个自然时间整点
     * <p>
     * 时间单位都是秒
     *
     * @param startTime
     * @param endTime
     */
    public static int listNatureHourPointNum(long startTime, long endTime, int hours) {

        if (startTime > endTime) {
            return 0;
        }


        if(hours < 0 ){
            hours = FiledPool.NUM_8 ;
        }


        LocalDateTime time = LocalDateTime.ofEpochSecond(startTime, 0, ZoneOffset.ofHours(localZoneIdNo));

        String hourForm = time.format(HOUR_DATE_TIME_FORMATTER);

        long timePoint = strTime2Time(hourForm);
        timePoint /= FiledPool.NUM_1000;

        int count = 0;
        for (int i = 0; i < hours; i++) {
            timePoint += FiledPool.HOUR_SECOND;
            if (timePoint <= endTime) {
                count++;
            } else {
                return count;
            }
        }

        return count;
    }

    /**
     * 字符串日期详见
     *
     * @param minusDate 减数
     * @param beMinusDate 被减数
     * @param format
     * @return
     */
    public static int dayDiff(String minusDate, String beMinusDate, String format) {

        SimpleDateFormat formater = new SimpleDateFormat(format);
        int
                diff = 0;
        try {
            long d1 = formater.parse(minusDate).getTime();
            long d2 = formater.parse(beMinusDate).getTime();
            diff = (int) ((d1 - d2) / (1000 * 60 * 60 * 24));
        } catch (Exception e) {
//            logger.error(e.getMessage(), e);
        }

        return diff;
    }


    /**
     * 当前星期号
     *
     * @return
     */
    public static int  currWeekNo(){

        LocalDateTime localDateTime = LocalDateTime.now();
        return localDateTime.getDayOfWeek().getValue();
    }


    /**
     * 获取本周的周以日期
     *
     * @return
     */
    public static String locaMondayDate(){

        int no = currWeekNo();

        int diff = no - 1 ;

        String currDay = formatCurrDay();

        if(diff  == 0){
            return currDay;
        }

        return dayPlus(currDay , -diff);

    }


    /**
     *  一年第几周
     *
     * @param now
     * @return
     */
    public static  int weekOfYear(long now){

        LocalDateTime localTime = null ;
        if(now <= 0){
            localTime = LocalDateTime.now();

        }else{
            DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
            localTime = LocalDateTime.ofEpochSecond(now, 0, ZoneOffset.ofHours(localZoneIdNo));

        }

        return Integer.parseInt(localTime.format(DateTimeFormatter.ofPattern("w")));

    }



}
