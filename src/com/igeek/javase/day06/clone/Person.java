package com.igeek.javase.day06.clone;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/4 10:16
 *
 * 需求：克隆一个Person对象
 *
 * 步骤：
 * 1.当前类必须实现Cloneable接口，避免实例克隆时抛出异常CloneNotSupportedException
 * 2.当前类必须重写clone方法，其他类才能够访问并且对实例克隆
 */
public class Person implements Cloneable{

    private String name;
    private int age;
    private Phone phone;

    public Person() {
    }

    public Person(String name, int age, Phone phone) {
        this.name = name;
        this.age = age;
        this.phone = phone;
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

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", phone=" + phone +
                '}';
    }

    @Override
    protected Person clone() throws CloneNotSupportedException {
        //浅克隆
        //return (Person) super.clone();

        //深克隆
        Person p = (Person)super.clone();
        p.setPhone(phone.clone());
        return p;
    }
}
