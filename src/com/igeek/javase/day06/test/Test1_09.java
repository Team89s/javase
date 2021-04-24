package com.igeek.javase.day06.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/9 11:22
 *
 *  获取当前的日期,并把这个日期转换为指定格式的字符串,如2088-08-08 08:08:08
 *         format
 *  Date ---------> String
 */
public class Test1_09 {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
        String str = sdf.format(date);
        System.out.println(str);
    }

}
