package com.igeek.javase.day02.extend.extendss;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/10/28 11:25
 */
public class Test {

    public static void main(String[] args) {

        Tiger tiger = new Tiger("东北虎",1);
        //tiger.eat();
        tiger.hunt();

        System.out.println("----------------");

        Dog dog = new Dog("哈巴狗",3);
        //dog.eat();
        dog.kanjia();

        System.out.println("----------------");

        Animal animal = new Animal("动物",10);
        //animal.eat();
        //animal.hunt();
    }

}
