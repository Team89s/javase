package com.igeek.javase.day04.interfaces;

/**
 * @version 1.0
 * @Description 实现类 implements
 * @Author chenmin
 * @Date 2020/11/2 10:18
 *
 * 类（实现类）实现接口，一个类可以实现多个接口  多实现
 *  public class 实现类  extends 类 implements 接口1,接口2,....{
 *
 *  }
 *
 *  要么当前实现类变成抽象类
 *  要么实现接口中的所有抽象方法
 *
 */
public class Tiger implements Animal{

    private String name;

    public Tiger(String name) {
        this.name = name;
    }

    @Override
    public int eat() {
        return Animal.SCORE_LEVEL;
    }

    @Override
    public void sleep() {
        System.out.println("正在睡觉");
    }

    public void hunt(){
        System.out.println(name+"正在狩猎...");
    }

    public static void main(String[] args) {
        Tiger tiger = new Tiger("东北虎");
        System.out.println("SCORE_LEVEL = "+tiger.eat());
        tiger.sleep();
        tiger.hunt();

        //多态
        Animal animal = new Tiger("华南虎");
        System.out.println("多态SCORE_LEVEL："+animal.eat());
        animal.sleep();
        if(animal instanceof Tiger){
            ((Tiger)animal).hunt();
        }
    }

}
