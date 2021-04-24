package com.igeek.javase.day04.interfaces;

/**
 * @version 1.0
 * @Description  既继承extends，又实现implements
 * @Author chenmin
 * @Date 2020/11/2 14:07
 *
 * 某个类继承父类，又实现了接口，此时父类中和接口中有同名方法，
 * 执行时根据就近原则，优先执行父类中的方法逻辑。
 */
interface Shape{
    public default void draw(){
        System.out.println("画形状...");
    }
}
class Demo{
    public void draw(){
        System.out.println("画demo...");
    }
}
public class Circle extends Demo implements Shape{
    public static void main(String[] args) {
        Circle c = new Circle();
        c.draw(); //遵循就近原则，执行画demo...
    }
}
