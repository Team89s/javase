package com.igeek.javase.day01.classs;

/**
 * @version 1.0
 * @Description 学生类
 * @Author chenmin
 * @Date 2020/10/27 10:22
 *
 * 语法：
 *  [修饰符]  class  类名{
 *
 *     //属性
 *     数据类型  属性名;
 *
 *     //行为
 *     void/数据类型  方法名(){
 *
 *     }
 *
 *  }
 */
public class Student {

    /**
     * 属性（成员变量）
     * 语法：数据类型  属性名;
     * 位置：类里，方法之外声明
     * 特点：无需赋初始值，整型0  浮点类型0.0  char'\u0000' 布尔类型false  引用数据类型null
     */
    String name;
    int age;
    char sex;

    //行为（成员方法）
    void study(){
        System.out.println("一位"+age+"岁学生，名字是："+name+"正在学习");
    }

    void eat(){
        System.out.println("一位"+sex+"同学正在吃饭");
    }

}
