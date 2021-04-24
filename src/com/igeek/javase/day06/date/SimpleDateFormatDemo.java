package com.igeek.javase.day06.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @Description SimpleDateFormat  extends  DateFormat
 * @Author chenmin
 * @Date 2020/11/4 14:33
 */
public class SimpleDateFormatDemo {

    public static void main(String[] args) throws ParseException {
        /**
         *         format(Date)
         *  Date -------------->  String 以指定的格式显示
         */
        //public final String format(Date date) 将日期格式化为日期/时间字符串。
        Date date1 = new Date();
        System.out.println("date1 = "+date1);  //Wed Nov 04 14:39:02 CST 2020
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss EEE a"); //2020/11/04 14:39:02 星期三 下午
        String str1 = simpleDateFormat1.format(date1);
        System.out.println("str1 = "+str1);

        /**
         *              parse(String)
         *  String  ------------------->  Date
         */
        //public Date parse(String source) throws ParseException 解析文本从给定字符串的生产开始日期。
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = simpleDateFormat2.parse("2022-05-05"); //抛出异常java.text.ParseException: Unparseable date: "2022-05-05"
        System.out.println("date2 = "+date2);  //Thu May 05 00:00:00 CST 2022
    }

}
