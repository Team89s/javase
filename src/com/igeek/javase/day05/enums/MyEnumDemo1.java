package com.igeek.javase.day05.enums;

/**
 * @version 1.0
 * @Description 枚举
 * @Author chenmin
 * @Date 2020/11/3 9:27
 *
 * 枚举特点：
 * 1.将实例一一列举，并且在代码的第一行，单词大写展示
 * 2.多例的设计模式 （公开的静态的常量实例）
 * 3.私有的构造方法
 * 4.有final修饰的，最终形态，不可以被继承
 * 5.extends java.lang.Enum
 * 6.枚举通常用于做信息的标志和分类。
 */
public enum  MyEnumDemo1 {

    SPRING, SUMMER, AUTUMN, WINTER;

    public static void main(String[] args) {

    }
}
