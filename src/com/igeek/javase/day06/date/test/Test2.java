package com.igeek.javase.day06.date.test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * @version 1.0
 * @Description 距离你出生有多久了？
 * @Author chenmin
 * @Date 2020/11/5 10:01
 */
public class Test2 {

    public static void main(String[] args) {
        //当前时间
        LocalDate now = LocalDate.now();
        //出生时间
        LocalDate birthday = LocalDate.of(2017, 12, 31);
        //long toEpochDay() 将此日期转换为新纪元日。
        System.out.println("出生多久："+(now.toEpochDay() - birthday.toEpochDay()));

        //long until(Temporal endExclusive, TemporalUnit unit) 计算时间的量，直到指定单元的另一个日期为止。
        System.out.println("出生多久："+birthday.until(now, ChronoUnit.DAYS));

    }

}
