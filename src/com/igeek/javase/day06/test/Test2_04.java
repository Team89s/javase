package com.igeek.javase.day06.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/9 14:13
 *
 * 请使用代码描述:
 * 有一段文本 "  anglebaby  	女 	 18	  515151511  "
 * 分别描述一个人的姓名 性别 年龄(int) 和QQ号码信息,完成如下需求:
 *    1. 创建一个Person类,包含性别,性别,年龄和QQ号码属性,使用解析出来信息创建一个Person对象,并打印这个人信息
 *    2. 并判断QQ号是否合法,匹配规则,全部都是数字,第一位非0,长度为5到12位.
 */
public class Test2_04 {

    public static void main(String[] args) {
        String str = "  anglebaby  女  18  515151511  ";

        //需求1：根据文本进行切割，并创建对象Person
        String[] strings = str.trim().split("\\s+");
        Person person = new Person(strings[0],strings[1],Integer.parseInt(strings[2]),strings[3]);
        System.out.println(person);

        //需求2：判断QQ号是否合法
        String regex = "[1-9]\\d{4,11}";
        System.out.println(strings[3].matches(regex)?"合法":"不合法");
    }

}
class Person{
    private String name;
    private String gender;
    private int age;
    private String qq;

    public Person() {
    }

    public Person(String name, String gender, int age, String qq) {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.qq = qq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", qq='" + qq + '\'' +
                '}';
    }
}
