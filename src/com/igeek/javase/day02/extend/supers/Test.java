package com.igeek.javase.day02.extend.supers;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/10/28 14:17
 */
public class Test {

    public static void main(String[] args) {
        Teacher teacher = new Teacher("张三",50,1.0);
        teacher.eat();
        teacher.teach();

        Teacher teacher1 = new Teacher();
        teacher1.eat();
    }

}
