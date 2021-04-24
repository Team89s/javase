package com.igeek.javase.day04.duotai;

/**
 * @version 1.0
 * @Description 老虎 - 子类（个性）
 * @Author chenmin
 * @Date 2020/10/29 10:11
 */
public class Tiger extends Animal {

    int num = 20;

    public Tiger() {
    }

    public Tiger(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat(Animal animal) {
        System.out.println("一只"+this.getAge()+"岁的"+this.getName()+"正在吃肉....");
    }

    public void hunt(){
        System.out.println(this.getName()+"正在捕猎...");
    }

    public static void sleep(){
        System.out.println("老虎正在睡觉");
    }
}
