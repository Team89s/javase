package com.igeek.javase.day05.innerclass;

/**
 * @version 1.0
 * @Description 内部类 - 静态内部类
 * @Author chenmin
 * @Date 2020/11/2 15:23
 *
 * 类的成员：
 *      成员变量（属性）
 *      成员方法（行为）
 *      构造方法（构造器）
 *      代码块
 *      内部类（成员内部类、静态内部类、局部内部类、匿名内部类）
 *          概念：在一个类的内部，再去定义一个类（内部类）
 *          [访问权限修饰符] [final] [static] [abstract] class 内部类的类名{ //类体 }
 *          1).成员内部类
 *              - 相当于成员变量或者成员方法一样的存在
 *              - 成员内部类当中的成员：与外部类一致的
 *              - 成员内部类中可以使用外部类的成员
 *              - 使用语法：外部类.成员内部类 引用名 = new 外部类().new 成员内部类();
 *              特殊：
 *                1.成员内部类可不可以访问到外部类的非静态的成员？ 可以
 *                2.成员内部类可不可以访问到外部类的静态的成员？   可以
 *
 *
 *          2).静态内部类
 *              - 使用static关键字  内存中独一份
 *              - 成员内部类当中的成员：与外部类一致的
 *              - 使用语法：外部类.成员内部类 引用名 = new 外部类.静态内部类();
 *                若是在同一个类中访问静态内部类，可以省略外部类
 *              特殊：
 *                1.静态内部类可不可以访问外部类的非静态的成员？  不可以
 *                2.静态内部类可不可以访问外部类的静态的成员？    可以
 */
//外部类
class OuterClass{
    //静态的成员变量
    public static String name = "李四";

    //构造方法
    public OuterClass() {
    }

    public OuterClass(String name) {
        this.name = name;
    }

    //静态的成员方法
    public static void eat(){
        System.out.println(name+"吃饭....");
    }

    //静态内部类
    public static class InnerClass{
        private int age;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void sleep(){
            System.out.println(age+","+name+"正在睡觉....");
        }
    }

    /*public static void main(String[] args) {
        //同类中访问静态内部类，完全可以参考外部类创建对象的语法
        InnerClass innerClass = new InnerClass();
    }*/
}

public class InnerClassDemo2 {

    public static void main(String[] args) {

        //外部类.静态成员
        System.out.println(OuterClass.name);
        OuterClass.eat();

        //new 外部类.静态内部类();
        OuterClass.InnerClass i = new OuterClass.InnerClass();
        i.setAge(10);
        i.sleep();
    }

}
