package com.igeek.javase.day07.integer;

import java.math.BigDecimal;

/**
 * @version 1.0
 * @Description 大浮点数类型  BigDecimal
 * @Author chenmin
 * @Date 2020/11/5 10:10
 *
 * BigDecimal  作用：将浮点类型数据的精度问题做处理
 * 1.java.math.BigDecimal
 * 2.Java大浮点数类BigDecimal，继承于Number类并实现了Comparable接口
 * 3.构造方法：
 *      BigDecimal(double val)将double类型的数据封装为BigDecimal对象
 *      BigDecimal(String val)将 BigDecimal 的字符串表示形式转换为 BigDecimal
 * 4.常用方法：
 *      BigDecimal.valueOf(double)
 *      public BigDecimal add(BigDecimal value)加法运算
 *      public BigDecimal subtract(BigDecimal value)减法运算
 *      public BigDecimal multiply(BigDecimal value)乘法运算
 *      public BigDecimal divide(BigDecimal value)除法运算
 */
public class BigDecimalDemo {

    public static void main(String[] args) {

        System.out.println(0.1+0.2);  //0.30000000000000004

        BigDecimal b1 = BigDecimal.valueOf(0.1);
        BigDecimal b2 = BigDecimal.valueOf(0.2);
        BigDecimal b3 = b1.add(b2);
        System.out.println("b3 = "+b3);  //0.3

        //继续参与运算
        double d = b3.doubleValue();
        System.out.println("d = "+d); //0.3
    }

}
