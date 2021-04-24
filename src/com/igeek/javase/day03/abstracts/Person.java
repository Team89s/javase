package com.igeek.javase.day03.abstracts;

/**
 * @version 1.0
 * @Description 抽象类与抽象方法
 * @Author chenmin
 * @Date 2020/10/30 16:09
 *
 * 抽象：模糊的，不具体的概念
 *      1.abstract 关键字
 *      2.abstract修饰类，抽象类
 *      3.abstract修饰方法，抽象方法
 *
 *  抽象类：abstract class
 *      1.抽象类中仍然可以定义成员变量、成员方法、构造方法
 *      2.抽象类不可以再被实例化，只能当做模板类存在，等待被继承
 *      3.抽象类中可以没有抽象方法
 *      4.当前抽象类一旦被继承，要么子类全部实现抽象类中的抽象方法；要么子类也变成抽象类
 *
 *   抽象方法：abstract
 *      1.抽象方法，没有方法体  public abstract void 方法名();
 *      2.一旦类中有抽象方法，则当前类一定是抽象类
 *
 *   提问：
 *        1.final与 abstract 能否一起使用？？？  不可以一起使用
 *        2.抽象类的构造方法存在的意义？
 * ​	 子类构造方法中通过super语句调用抽象父类的构造方法,为抽象父类中的成员变量赋值初始化；而赋好值的成员变量可以被子类的对象使用。
 *
 */
public abstract class Person {

    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public abstract void eat();

    public static void main(String[] args) {

        //Person p = new Person();

    }
}
