package com.igeek.javase.day06.object.equals;

import java.util.Objects;

/**
 * @version 1.0
 * @Description 学生类  Object常用方法
 * @Author chenmin
 * @Date 2020/11/4 9:17
 */
public class Student /*extends Object*/{

    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
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

    //重写equals()：比较对象中属性内容是否一致
    /*@Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        if(obj instanceof Student){
            Student stu = (Student)obj;
            return this.name.equals(stu.name) && this.age==stu.age;
        }
        return true;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    /*@Override
    public int hashCode() {
        return Objects.hash(name, age);
    }*/
}
