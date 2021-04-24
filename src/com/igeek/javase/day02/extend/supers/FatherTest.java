package com.igeek.javase.day02.extend.supers;

/**
 * @version 1.0
 * @Description super的使用
 * @Author chenmin
 * @Date 2020/10/28 15:09
 */
public class FatherTest {
    public static void main(String[] args) {
        Son son = new Son();
        son.show();
    }
}

class Father{
    String name;

    public void show(){
        name = "粑粑";
    }
}

class Son extends Father{
    String name = "儿砸";

    public void show(){
        //super.成员方法()
        super.show();
        //super.成员变量
        System.out.println(super.name);  //粑粑
        System.out.println(this.name);   //儿砸
    }
}
