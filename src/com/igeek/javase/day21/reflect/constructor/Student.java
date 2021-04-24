package com.igeek.javase.day21.reflect.constructor;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/15 15:57
 */
public class Student {
    private String name;
    private int age;

    private Student(){
        System.out.println("Student()执行无参构造方法");
    }

    public Student(String name){
        System.out.println("Student(String)执行有参构造方法");
        this.name = name;
    }

    public Student(String name,int age){
        System.out.println("Student(String,int)执行有参构造方法");
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        System.out.println("setName()");
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("setAge()");
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
