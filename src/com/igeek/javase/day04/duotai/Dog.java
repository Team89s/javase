package com.igeek.javase.day04.duotai;

/**
 * @version 1.0
 * @Description 狗 - 子类（个性）
 * @Author chenmin
 * @Date 2020/10/29 10:11
 */
public class Dog extends Animal {
    int num = 30;

    public Dog() {
    }

    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat(Animal animal) {
        System.out.println("一只"+this.getAge()+"岁的"+this.getName()+"正在啃骨头....");
    }

    public void kanjia(){
        System.out.println(this.getName()+"看家...");
    }

    public static void sleep(){
        System.out.println("小狗正在睡觉");
    }
}
