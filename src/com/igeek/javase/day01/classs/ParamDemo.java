package com.igeek.javase.day01.classs;

/**
 * @version 1.0
 * @Description 将引用数据类型作为方法的形参
 * @Author chenmin
 * @Date 2020/10/27 14:34
 */
public class ParamDemo {

    public static void main(String[] args) {
        Student stu = new Student();
        stu.name = "王二";
        stu.sex = '男';
        stu.age = 18;

        //执行
        ParamDemo.method(stu);

        System.out.println("main:():"+stu.name);
        System.out.println("main:():"+stu.sex);
        System.out.println("main:():"+stu.age);
    }

    //将引用数据类型作为方法的形参：传递的地址
    public static void method(Student student){
        student.name = "王二麻";
        System.out.println("method:()"+student.name);
        System.out.println("method:()"+student.sex);
        System.out.println("method:()"+student.age);
    }


}
