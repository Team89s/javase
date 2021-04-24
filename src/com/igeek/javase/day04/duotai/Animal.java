package com.igeek.javase.day04.duotai;

/**
 * @version 1.0
 * @Description 动物 - 父类（共性）
 * @Author chenmin
 * @Date 2020/10/29 10:10
 */
public class Animal {

    private String name;
    private int age;
    int num = 10;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Animal() {
    }

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //instanceof运算符  判断左边的对象运行期类型是否是右边   返回值是布尔类型 true代表是  false代表不是
    public void eat(Animal animal){
        if(animal instanceof Tiger){
            Tiger tiger = (Tiger)animal;
            tiger.hunt();
        }else if(animal instanceof Dog){
            Dog dog= (Dog)animal;
            dog.kanjia();
        }
        System.out.println("一只"+age+"岁的"+name+"正在吃饭....");
    }

    public static void sleep(){
        System.out.println("动物正在睡觉");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
