package com.igeek.javase.day01.visible.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/10/27 16:38
 */
public class PersonTest {

    public static void main(String[] args) {

        //1.创建对象  类名  引用名 = new  构造方法();
        Person p1 = new Person();

        //2.访问属性  引用名.属性名
        p1.setName("张三");
        p1.setSex("非");

        //3.访问方法  引用名.方法();
        p1.eat();
        p1.sleep();


        //使用有参构造方法创建对象（实例化的过程）
        Person p2 = new Person("李四","女");
        p2.eat();
        p2.sleep();
    }

}
