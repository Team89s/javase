package com.igeek.javase.day04.interfaces;

/**
 * JDK1.9接口特点 - 私有的方法
 *
 * 接口中的成员：
 *  1.除了有公开的静态的常量、公开的抽象的方法
 *  2.新增：
 *      私有的方法 private
 *      1).私有的实例方法
 *      格式：private 返回值类型 方法名称(参数列表){ 方法体 }
 *      作用：接口中的默认方法或者静态方法调用。解决多个默认方法之间重复代码的问题。
 *
 *      2).私有的静态方法
 *      格式：private static 返回值类型 方法名称(参数列表){ 方法体 }
 *      作用：静态私有方法：解决多个静态方法之间的重复代码问题
 */
interface E{

    public default void test(){
       //e();
    }

   /* private void e(){
        System.out.println("代码复用...");
    }*/

}

public class InterfaceDemo3 implements E{

    public static void main(String[] args) {

    }

}
