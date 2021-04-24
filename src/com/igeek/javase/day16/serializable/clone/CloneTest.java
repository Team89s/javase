package com.igeek.javase.day16.serializable.clone;

/**
 * @version 1.0
 * @Description 克隆测试类
 * @Author chenmin
 * @Date 2020/11/26 15:05
 */
public class CloneTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        Major major = new Major("变天鹅","666");
        Student stu = new Student("小黄鸭",6,major);

        System.out.println("-------克隆-------");
        Student stu1 = stu.clone();
        System.out.println("原版本："+stu);
        System.out.println("克隆后版本："+stu1);
        System.out.println(stu == stu1);  //false

        System.out.println("-------修改-------");
        stu.setAge(10);
        stu.getMajor().setMajorId("888");
        System.out.println("原版本："+stu);
        System.out.println("克隆后版本："+stu1);
    }

}
