package com.igeek.javase.day02.extend.supers;

/**
 * @version 1.0
 * @Description 父类
 * @Author chenmin
 * @Date 2020/10/28 14:17
 *
 * super和this
 *
 * super 关键字
 * 1.调用执行父类的成员，但是super并不是父类的对象
 * 2.默认提供super()，调用执行父类中的无参构造方法
 * super(name, age); 调用执行父类中的有参构造方法
 * 默认存在在子类构造方法的第一行
 * 3.super调用父类的成员方法，调用父类的成员变量
 *
 * this
 * 1.当前正在创建的对象，当前正在使用的对象
 * 2.this() 调用本类中无参的构造方法
 * this(name,age) 调用本类中有参的构造方法 ，但是两者不能互相调用
 * 3.this调用本类的成员方法，调用本类的成员变量
 */
public class Person {

    private String name;
    private int age;

    public Person() {
        super();
        System.out.println("Person()");
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
        System.out.println("Person(String,int)");
    }

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

    public void eat(){
        System.out.println(name+"在吃饭...");
    }
}
