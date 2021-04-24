package com.igeek.javase.day02.use;

/**
 * @version 1.0
 * @Description 人
 * @Author chenmin
 * @Date 2020/10/29 14:12
 *
 * 依赖关系： use - a
 *
 * 概念（代码上体现）：一个类作为另外一个类中的方法的形参出现  偶然性和临时性
 */
public class Person {

    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //依赖关系
    public void work(Bus bus){
        System.out.println(name+"乘坐"+bus.getName()+"去上班...");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
