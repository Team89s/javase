package com.igeek.javase.day02.extend.persontest;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/10/28 16:33
 */
public class Test {

    public static void main(String[] args) {

        Person p1 = new Person("白娘娘",1000,false,null);
        Person p2 = new Person("许仙",25,true,null);
        Person p3 = new Person("小青",500,true,null);
        Person p4 = new Person("法海",99,true,null);

        p1.marry(p2);
        p2.marry(p3);
    }

}
