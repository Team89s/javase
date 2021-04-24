package com.igeek.javase.day06.date;

import java.util.Calendar;

/**
 * @version 1.0
 * @Description Calendar  日历类   抽象类
 * @Author chenmin
 * @Date 2020/11/4 15:15
 */
public class CalendarDemo {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        //重写toString方法
        System.out.println(calendar);

        System.out.println("------get() 获取时间 ------");
        System.out.println("年："+calendar.get(Calendar.YEAR));
        System.out.println("月："+(calendar.get(Calendar.MONTH)+1));
        System.out.println("日："+calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("星期："+getWeek(calendar.get(Calendar.DAY_OF_WEEK)));

        System.out.println("------set() 设置时间 ------");
        calendar.set(Calendar.YEAR,2021);
        System.out.println(calendar.get(Calendar.YEAR));

        System.out.println(calendar);
        System.out.println("--------add() 追加---------");
        calendar.add(Calendar.YEAR,2);
        System.out.println("2年以后："+calendar.get(Calendar.YEAR));
        calendar.add(Calendar.DAY_OF_MONTH,367);
        System.out.println("367天以后："+calendar.get(Calendar.DAY_OF_MONTH));
        calendar.add(Calendar.HOUR,3);
        System.out.println("3小时以后："+calendar.get(Calendar.HOUR));
    }

    public static String getWeek(int index){
        String[] weeks = {"星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        return weeks[index-1];
    }

}
