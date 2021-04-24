package com.igeek.javase.day02.has;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/10/29 14:05
 */
public class Test {

    public static void main(String[] args) {

        Phone phone = new Phone("苹果",8300,"白色");
        Person person = new Person("小海",phone);

        person.play();

    }

}
