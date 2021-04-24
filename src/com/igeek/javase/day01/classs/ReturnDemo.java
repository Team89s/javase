package com.igeek.javase.day01.classs;

/**
 * @version 1.0
 * @Description 方法的返回值是引用数据类型
 * @Author chenmin
 * @Date 2020/10/27 15:34
 */
public class ReturnDemo {

    public static void main(String[] args) {
        Student stu = ReturnDemo.get();
        stu.eat();
        stu.study();
    }

    //方法的返回值是引用数据类型：返回的地址
    public static Student get(){
        Student student = new Student();
        student.name = "王朝";
        student.age = 3000;
        student.sex = '男';
        return student;
    }

}
