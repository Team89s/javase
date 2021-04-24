package com.igeek.javase.day06.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version 1.0
 * @Description 把你的生日字符串表示转换为对应的日期对象.
 * @Author chenmin
 * @Date 2020/11/9 11:27
 *            parse
 * String  ---------->  Date
 */
public class Test1_10 {

    public static void main(String[] args) {
        String date ="2020/10-1";
        SimpleDateFormat sdp = new SimpleDateFormat("yyyy-MM-dd");
        Date s = null;
        try {
            s = sdp.parse(date);  //此处发生异常
            System.out.println("try");
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(s);
    }

}
