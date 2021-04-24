package com.igeek.javase.day06.clone;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/4 10:16
 */
public class Test {

    public static void main(String[] args) throws CloneNotSupportedException {

        Phone phone1 = new Phone("苹果",8000.0);
        /*Phone phone2 = phone1.clone();
        System.out.println("--------克隆后----------");
        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println("---------修改后---------");
        phone2.setLabel("华为");
        System.out.println(phone1);  //苹果
        System.out.println(phone2);  //华为*/


        Person p1 = new Person("张三",10,phone1);
        Person p2 = p1.clone();
        System.out.println("--------克隆后----------");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println("---------修改后---------");
        /**
         * 浅克隆结果：
         * p1  张三  10  华为
         * p2  李四  10  华为
         */
        /**
         * 深克隆结果：
         * p1  张三  10  苹果
         * p2  李四  10  华为
         */
        p2.setName("李四");
        p2.getPhone().setLabel("华为");
        System.out.println(p1);
        System.out.println(p2);
    }

}
