package com.igeek.javase.day06.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

/**
 * @version 1.0
 * @Description DateFormat 日期格式化器 - 抽象类
 * @Author chenmin
 * @Date 2020/11/4 14:30
 */
public class DateFormatDemo {

    public static void main(String[] args) throws ParseException {
        //DateFormat 抽象类  静态的获得本类实例的方法getDateInstance()
        DateFormat dateFormat = DateFormat.getDateInstance();
        String str = dateFormat.format(new Date());
        System.out.println(str);

        Date date = dateFormat.parse("2020-01-01");
        System.out.println(date);
    }

}
