package com.igeek.javase.day01.classs;

/**
 * @version 1.0
 * @Description 创建一个对象
 * @Author chenmin
 * @Date 2020/10/27 10:29
 */
public class StudentDemo1 {

    public static void main(String[] args) {
        //1.创建学生对象  类名  对象名 = new 构造方法();
        Student stu = new Student();

        //2.调用属性  对象名.属性
        stu.name = "张三";
        stu.age = 20;
        stu.sex = '男';

        //3.调用方法  对象名.方法()
        stu.eat();
        stu.study();
    }

}
