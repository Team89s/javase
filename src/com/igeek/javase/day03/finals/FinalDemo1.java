package com.igeek.javase.day03.finals;

/**
 * @version 1.0
 * @Description final关键字
 * @Author chenmin
 * @Date 2020/10/30 15:16
 *
 * final 关键字：用于修饰不可改变内容。不可改变，最终的含义。可以用于修饰类、方法和变量。
 *
 * final:
 *      1.final修饰类，代表当前类不允许再被继承
 *      2.final修饰方法，代表当前方法不允许再被重写
 *      3.final修饰变量，代表变量的值不可更改
 *          若是基本数据类型，数值（二进制值）不可再更改
 *          若是引用数据类型，地址不可再更改
 *
 *          - 实例成员变量
 *          - 静态成员变量
 *          - 局部变量
 */
public /*final*/ class FinalDemo1 {

    private final int a = 10;

    public /*final*/ void eat(){
        //a = 20;
        System.out.println("吃饭");
    }

}
