package com.igeek.javase.day06.date;

import java.util.Date;

/**
 * @version 1.0
 * @Description Date 时间与日期类
 * @Author chenmin
 * @Date 2020/11/4 14:17
 */
public class DateDemo {

    public static void main(String[] args) {
        //            getTime()
        //将Date类型 -------------> long类型
        //获得当前时间  Wed Nov 04 14:25:38 CST 2020
        Date date = new Date();
        System.out.println(date);

        //long getTime() 返回毫秒数自1970年1月1日以来，该 Date对象表示00:00:00 GMT。 1604470761261
        long time = date.getTime();
        System.out.println("执行前："+time); //1604471138571

        System.out.println("--------------------------");
        //使用场景：计算距离2021年1月1日的时间  单位天  SimpleDateFormat  ？
        for (int i = 0; i < 1000; i++) {
            System.out.println("i = "+i);
        }

        System.out.println("--------------------------");
        //              new Date(long)
        //将long类型 --------------------> Date类型
        long time1 = System.currentTimeMillis();
        System.out.println("执行后："+time1);  //1604471138611
        Date date1 = new Date(time1);  //Wed Nov 04 14:25:38 CST 2020
        System.out.println(date1);

        System.out.println("耗时："+(time1 - time)/1000.0);  //0.053s
    }

}
