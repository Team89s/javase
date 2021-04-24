package com.igeek.javase.day06.date;

import java.time.LocalDate;

/**
 * @version 1.0
 * @Description LocalDate和LocalDateTime和LocalTime
 * @Author chenmin
 * @Date 2020/11/5 9:09
 */
public class LocalDateDemo {

    public static void main(String[] args) {

        //static LocalDate now()  在默认时区中从系统时钟获取当前日期。
        LocalDate date = LocalDate.now();
        System.out.println(date);  //2020-11-05

        // int getDayOfMonth() 获取月字段的一天。
        System.out.println("获取月字段的一天:"+date.getDayOfMonth());
        // int getDayOfYear() 获取一年的日子。
        System.out.println("获取一年的日子:"+date.getDayOfYear());
        // int getMonthValue() 从1到12得到一个月的时间字段
        System.out.println("从1到12得到一个月的时间字段:"+date.getMonthValue());
        // int getYear() 获取年度字段。
        System.out.println("获取年度字段:"+date.getYear());
        // boolean isLeapYear() 检查，如果今年是闰年，根据ISO预期历法系统规则
        System.out.println("是否是闰年："+date.isLeapYear());
        // int lengthOfMonth() 返回此日期所表示的月份的长度
        System.out.println("月份的长度："+date.lengthOfMonth());
        // int lengthOfYear() 返回此日期所表示的年份的长度。
        System.out.println("年份的长度："+date.lengthOfYear());

        /*
        LocalDate minusDays(long daysToSubtract)  返回一份本 LocalDate与指定的天数减去。
        LocalDate minusMonths(long monthsToSubtract)  返回一份本 LocalDate与指定期个月减去。
        LocalDate minusWeeks(long weeksToSubtract)  返回一份本 LocalDate在周中减去指定的时间。
        LocalDate minusYears(long yearsToSubtract)  返回一份本 LocalDate与指定期在年中减去。

        LocalDate plusDays(long daysToAdd)  返回一份本 LocalDate与指定的天数增加。
        LocalDate plusMonths(long monthsToAdd)  返回一份本 LocalDate在月期添加指定的。
        LocalDate plusWeeks(long weeksToAdd)  返回一份本 LocalDate在周指定期间补充。
        LocalDate plusYears(long yearsToAdd)  返回一份本 LocalDate年指定期间补充。
         */
        System.out.println("在月期添加指定的:"+date.plusMonths(2)); //2021-01-05
        System.out.println("年指定期间补充:"+date.plusYears(3));//2023-11-05

        System.out.println("指定的天数减去:"+date.minusDays(5));  //2020-10-31
        System.out.println("在周中减去指定的时间:"+date.minusWeeks(4)); //2020-10-08

        //static LocalDate of(int year, int month, int dayOfMonth) 获得 LocalDate实例从一年、月、日。
        //java.time.DateTimeException: Invalid value for DayOfMonth (valid values 1 - 28/31): 32  当前指定日期不合法
        LocalDate localDate = LocalDate.of(2021, 1, 31);
        System.out.println(localDate);

        //static LocalDate parse(CharSequence text) 获得 LocalDate实例从一个文本字符串，如 2007-12-03。
        LocalDate parse1 = LocalDate.parse("2020-12-12");
        System.out.println("parse1:"+parse1);

        /*
        LocalDate withDayOfMonth(int dayOfMonth) 返回此日期的副本与月更改日期。
        LocalDate withDayOfYear(int dayOfYear) 返回此日期的副本与一年的日期更改。
        LocalDate withMonth(int month) 返回此日期的副本与更改的月份。
        LocalDate withYear(int year) 返回此日期的副本与年更改。
         */
        System.out.println("月更改日期:"+date.withDayOfMonth(10)); //2020-11-10
        System.out.println("一年的日期更改:"+date.withDayOfYear(300)); //2020-10-26
    }

}
