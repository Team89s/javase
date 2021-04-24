package com.igeek.javase.day02.extend.supers;

/**
 * @version 1.0
 * @Description 子类
 * @Author chenmin
 * @Date 2020/10/28 14:17
 */
public class Teacher extends Person{

    private double salary;

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Teacher() {
        super();
        //this("李四",123);
        System.out.println("Teacher()");
    }

    /*public Teacher(String name, int age) {
        //super();
        //调用父类中的有参构造方法
        super(name, age);
        //this();
        System.out.println("Teacher(String,int)");
        //System.out.println(super);
        System.out.println(this);
    }*/

    public Teacher(String name, int age,double salary) {
        super(name , age);
        this.salary = salary;
    }

    public void teach(){
        System.out.println(this.getName()+"授课");
    }
}
