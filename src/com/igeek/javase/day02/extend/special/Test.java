package com.igeek.javase.day02.extend.special;

/**
 * @version 1.0
 * @Description 测试类
 * @Author chenmin
 * @Date 2020/10/28 14:02
 */
public class Test {

    public static void main(String[] args) {
        Student student = new Student();
        student.setName("小明");
        student.setSex("男");
        student.sleep();
        student.study();
    }

}
