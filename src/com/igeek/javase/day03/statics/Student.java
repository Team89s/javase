package com.igeek.javase.day03.statics;

/**
 * @version 1.0
 * @Description 学生类
 * @Author chenmin
 * @Date 2020/10/30 14:00
 *
 * static修饰符，所修饰的成员不再属于某个特定对象，而是属于类的
 *   成员变量：
 *      实例成员变量：属性，随着对象加载而加载
 *          使用：对象.属性
 *
 *      静态成员变量：static关键字，随着类加载而加载，只加载一份
 *          使用：
 *              1.类名.静态变量
 *              2.静态变量  （要求同类中可以省略类名）
 *              3.对象.静态变量 （不建议使用）
 *
 *   成员方法：
 *      实例方法：行为
 *          使用：对象.行为
 *      静态方法：static关键字
 *          使用：
 *              1.类名.静态方法
 *              2.静态方法  （要求同类中可以省略类名）
 *              3.对象.静态方法 （不建议使用）
 *
 *    使用场景：
 *       1.工具类中的方法  静态方法
 *       2.所有对象共享某个属性时  静态成员变量
 *
 *    疑问：
 *       1.实例方法中可不可以访问实例成员变量？  可以
 *       2.实例方法中可不可以访问实例方法？  可以
 *       3.实例方法中可不可以访问静态成员变量？  可以
 *       4.实例方法中可不可以访问静态方法？  可以
 *    -------------------------------------------
 *       1.静态方法中可不可以访问静态成员变量？  可以
 *       2.静态方法中可不可以访问静态方法？  可以
 *       3.静态方法中可不可以访问实例成员变量？  不可以
 *       4.静态方法中可不可以访问实例方法？  不可以
 *
 */
public class Student {
    //静态属性
    private static int count = 10;

    //属性：成员变量
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //成员方法
    public void study(){
        System.out.println(name+"正在学习...");
    }

    //静态方法
    public static void setCount(){
        count++;
        System.out.println(count+"个学生");
    }

    //main方法
    public static void main(String[] args) {
        //访问静态变量
        System.out.println(Student.count);  //10
        System.out.println(count);  //10

        //访问成员属性
        //System.out.println(name);  报错
        Student student = new Student("王朝",1);
        System.out.println(student.name);  //王朝
        System.out.println(student.count); //不建议  10

        //访问静态方法
        Student.setCount(); //11
        setCount(); //12

        //访问成员方法
        //study(); 报错
        student.study();  //王朝正在学习
    }
}
