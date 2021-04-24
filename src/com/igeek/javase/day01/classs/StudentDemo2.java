package com.igeek.javase.day01.classs;

/**
 * @version 1.0
 * @Description 创建两个不同对象
 * @Author chenmin
 * @Date 2020/10/27 10:29
 */
public class StudentDemo2 {

    public static void main(String[] args) {
        //1.创建学生对象  类名  对象名 = new 构造方法();
        Student stu1 = new Student();
        //2.调用属性  对象名.属性
        stu1.name = "张三";
        stu1.age = 20;
        stu1.sex = '男';
        //3.调用方法  对象名.方法()
        stu1.eat();
        stu1.study();

        //第二个对象的创建
        Student stu2 = new Student();
        stu2.name = "李四";
        stu2.age = 22;
        stu2.sex = '女';
        stu2.eat();
        stu2.study();
    }

}
