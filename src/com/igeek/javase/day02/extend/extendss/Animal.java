package com.igeek.javase.day02.extend.extendss;

/**
 * @version 1.0
 * @Description 动物 - 父类
 * @Author chenmin
 * @Date 2020/10/28 11:21
 *
 * 继承：is-a
 *   1.设计层面改变
 *   2.extends 关键字
 *   3.父类定义共性，子类定义个性
 *   4.意义：代码复用
 *   5.Java单继承 ； Object是所有类的父类（要么直接继承Object,要么就间接继承Object）
 *   6.父类可以使用自己的属性及行为，但是不可以使用子类新拓展的属性和行为
 *
 * 总结：
 * 子类继承父类
 * 父类中有大部分的属性及行为子类都可以继承
 */
public class Animal {

    private String name;
    private int age;

    public Animal() {
    }

    public Animal(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Animal eat(Animal animal) throws NullPointerException{
        System.out.println(name+"正在吃饭...");
        return this;
    }

}
