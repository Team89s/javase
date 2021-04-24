package com.igeek.javase.day06.object.objects;

import java.util.Objects;

/**
 * @version 1.0
 * @Description Objects
 * @Author chenmin
 * @Date 2020/11/4 11:34
 */
public class Demo {

    public static void main(String[] args) {
        Student s1 = null;
        Student s2 = new Student();

        //Objects equals() 具体比较的是传入进来的对象的equals()
        System.out.println(Objects.equals(s1,s2)); //判断是否为null

        //Object  equals() 比较的是地址
        //System.out.println(s1.equals(s2));  //==  NullPointerException

        //isNull 比较的对象是否为null
        System.out.println(Objects.isNull(s1));  //true
        System.out.println(Objects.isNull(s2));  //false
    }

}
