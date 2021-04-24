package com.igeek.javase.day01.visible.demo1;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/10/27 16:22
 *
 *                 public公开的    protected受保护的   default默认的    private私有化的
 * 本类中            OK                 OK                 OK              OK
 * 同包下            OK                 OK                 OK
 * 不同包下的子类     OK                 OK
 * 不同包下的其他类   OK
 *
 * public：可以修饰类、属性、方法
 * protected：可以修饰属性、方法
 * default：可以修饰类、属性、方法
 * private：可以修饰属性、方法
 *
 */
public class Test1 {

    protected String name;
    protected int age;

    protected void eat(){
        System.out.println("一位"+age+"岁的，名字叫做"+name+"正在吃饭");
    }


    public static void main(String[] args) {
        Test1 test = new Test1();
        test.name = "zhangsan";
        test.age = 12;
        test.eat();
    }
}
