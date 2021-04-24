package com.igeek.javase.day07.integer;

/**
 * @version 1.0
 * @Description Integer类
 * @Author chenmin
 * @Date 2020/11/5 10:34
 *
 * byte  short  int     long  char       boolean  float  double
 * Byte  Short  Integer Long  Character  Boolean  Float  Double
 *
 * Integer 类
 * 1.基本数据类型int 对应的 包装器类型
 * 2.extends Number implements Comparable
 * 3.构造方法：
 *      Integer(int value) 装箱
 *      Integer(String s)
 * 4.常用方法：
 *      将字符串转换成int类型：static int parseInt(String s)  将字符串参数作为带符号的十进制整数。
 *      将字符串转换成Integer类型：static Integer valueOf(String s)  返回一个 Integer对象持有指定的 String价值。
 */
public class IntegerDemo1 {

    public static void main(String[] args) {

        /**
         * Integer -128~127 整型常量池中；超出范围相当于new Integer()创建
         */
        //装箱：将基本数据类型转换成包装器类型
        int i1 = 10;
        Integer integer1 = new Integer(i1);
        Integer integer11 = new Integer(i1);
        Integer integer2 = 10;
        Integer integer22 = 10;
        System.out.println(integer1==integer11);  //false
        System.out.println(integer2==integer22);  //true
        System.out.println(integer1.equals(integer11));  //true
        System.out.println(integer2.equals(integer22));  //true
        //装箱
        Integer integer3 = Integer.valueOf(i1);
        System.out.println(integer3);  //10

        //拆箱：将包装器类型转换成基本数据类型
        //int intValue() 作为一个 int返回该 Integer价值。
        Integer integer4 = 128; //超过常量池的方法，等价于new Integer(128)
        int i4 = integer4.intValue();

        //自动拆箱装箱
        Integer integer5 = 50;
        int i5 = integer5+1;  //先拆箱
        integer5+=1; //先拆箱再装箱
        System.out.println("i5 = "+i5);
    }

}
