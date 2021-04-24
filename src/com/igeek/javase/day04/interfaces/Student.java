package com.igeek.javase.day04.interfaces;

/**
 * @version 1.0
 * @Description 接口与接口之间的多继承的关系
 * @Author chenmin
 * @Date 2020/11/2 11:42
 */
interface Animal1{
    void eat();
}
interface Animal2{
    void sleep();
}
//接口与接口之间的多继承
interface Person extends Animal1,Animal2{
    void study();
}

//实现类实现接口，意味着要将接口中所有的抽象方法都实现（直接实现的接口，或者此接口继承的父接口中的抽象方法，都必须要实现），否则当前类为抽象类
public class Student implements Person{

    @Override
    public void eat() {

    }

    @Override
    public void sleep() {

    }

    @Override
    public void study() {

    }
}
