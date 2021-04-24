package com.igeek.javase.day01.classs;

/**
 * @version 1.0
 * @Description 成员变量和局部变量的区别
 * @Author chenmin
 * @Date 2020/10/27 15:58
 */
public class VariableDemo {

    /**
     * 成员变量：又称为属性
     * 1.声明的范围：在类中，方法之外声明
     * 2.可以不赋值初始值，提供默认值
     * 3.生命周期：随着对象的创建而创建随着对象的销毁而销毁
     * 4.使用：对象.成员变量
     */
    String name;  //null
    int age;  //0

    public void method(){
        /**
         * 局部变量：
         * 1.声明的范围：在方法中之内声明
         * 2.必须赋值初始值，否则会编译出错
         * 3.生命周期：随着方法的调用而创建，随着方法的结束而结束
         * 4.使用：直接使用即可
         */
        int a = 10;
        System.out.println("a = "+a);
    }

}
