package com.igeek.javase.day06.clone;

/**
 * @version 1.0
 * @Description 测试Object - clone方法
 * @Author chenmin
 * @Date 2020/11/4 10:03
 *
 * 抛出异常CloneNotSupportedException，此类没有实现Cloneable接口，也没有重写它的clone()
 */
public class CloneDemo2 /*extends Object */{

    public static void main(String[] args) throws CloneNotSupportedException {

        //测试Object的clone方法  不能调用，protected受保护的
        //Object obj1 = new Object();
        //Object obj2 = obj1.clone();

        //本类直接使用clone方法
        /*CloneDemo2 d1 = new CloneDemo2();
        CloneDemo2 d2 = (CloneDemo2)d1.clone();
        System.out.println(d1);
        System.out.println(d2);*/

        //同包下的其他类 不能调用，protected受保护的 ； 除非其他类重写clone方法
        CloneDemo1 d3 = new CloneDemo1();
        CloneDemo1 d4 = (CloneDemo1)d3.clone();
        System.out.println(d3);   //com.igeek.javase.day06.clone.CloneDemo1@1b6d3586
        System.out.println(d4);
    }

}
