package com.igeek.javase.day04.interfaces;

/**
 * 接口
 *
 * 1.关键字
 *      interface  定义接口
 *      implements 实现接口
 *
 * 2.特点：定义一系列的规范
 *      1.接口（子接口）可以继承其它接口，接口与接口之间的多继承的关系  多继承
 *      public interface 接口名  extends  接口名1,接口名2,接口名3,...{
 *
 *      }
 *
 *      2.类（实现类）实现接口，一个类可以实现多个接口  多实现
 *      public class 实现类  extends 类 implements 接口1,接口2,....{
 *
 *      }
 * 3.成员：
 *      1.JDK1.8之前：
 *              公开的静态的常量 public static final 数据类型 变量名;
 *              公开的抽象的方法 public abstract 返回值  方法名();
 *      2.JDK1.8之后：新增
 *              默认的方法
 *              静态的方法
 *      3.JDK1.9之后：新增
 *              私有的方法
 */
public interface Animal {

    //JDK1.8之前
    /**
     * 1.公开的静态的常量
     * public static final  写或者不写皆可（不写的话，会默认提供），地址唯一，值唯一
     * 常量名：所有单词都大写，若出现多个单词，可以通过下划线_拼接
     */
    /*public static final */ int SCORE_LEVEL = 10;

    /**
     * 2.公开的抽象的方法
     * public abstract 写或者不写皆可（不写的话，会默认提供），没有方法体
     */
    /*public abstract */int eat();

    void sleep();

}
