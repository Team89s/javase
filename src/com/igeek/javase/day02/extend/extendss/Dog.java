package com.igeek.javase.day02.extend.extendss;

/**
 * @version 1.0
 * @Description 狗 - 子类
 * @Author chenmin
 * @Date 2020/10/28 11:21
 */
public class Dog extends Animal{

    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    public void kanjia(){
        System.out.println(this.getName()+"正在看家...");
    }

}
