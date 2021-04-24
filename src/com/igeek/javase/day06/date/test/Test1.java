package com.igeek.javase.day06.date.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/4 15:10
 *
 * "2014-5-25"到"2012-12-28"中间有多少天？
 */
public class Test1 {

    public static void main(String[] args) throws ParseException {

        String str1 = "2014-5-25";
        String str2 = "2012-12-28";

        //String --->  Date
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = sdf.parse(str1);
        Date date2 = sdf.parse(str2);

        //Date ---> long  ms
        long time1 = date1.getTime();
        long time2 = date2.getTime();

        // 减法
        System.out.println((time1-time2)/1000/60/60/24);  //513天
    }

}
