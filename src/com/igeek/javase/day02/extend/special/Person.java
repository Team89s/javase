package com.igeek.javase.day02.extend.special;

/**
 * @version 1.0
 * @Description Person 父类
 * @Author chenmin
 * @Date 2020/10/28 13:58
 *
 * 继承：
 * 1.使用关键字extends
 * 2.Java单继承
 *
 * 继承特殊点：
 *      1.构造方法 不会 发生继承
 *      2.私有成员会不会发生继承？ 会继承
 *      3.静态成员会不会发生继承？ 不会继承，所有实例共享
 *
 * 方法重写特殊点： @Override
 *      1.构造方法会不会发生重写？  不会
 *      2.私有方法会不会发生重写？  不会
 *      3.静态方法会不会发生重写？  不会
 */
public class Person {

    private String name;
    private String sex;

    public Person() {
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void sleep(){
        System.out.println(name+"正在睡觉....");
    }
}
