package com.igeek.javase.day05.innerclass;

/**
 * @version 1.0
 * @Description 内部类 - 成员内部类
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
 *              1.成员内部类可不可以访问到外部类的非静态的成员？ 可以
 *              2.成员内部类可不可以访问到外部类的静态的成员？   可以
 *
 */
//外部类
class OuterClass1{
    //成员变量
    private String name;
    private static int i;

    //构造方法
    public OuterClass1() {
    }

    public OuterClass1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //成员方法
    public void eat(){
        System.out.println(name+"吃饭....");
    }

    //成员内部类  [访问权限修饰符] [final] [static] [abstract] class 内部类的类名{ //类体 }
    public class InnerClass{
        private int age;

        public InnerClass() {
        }

        public InnerClass(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void sleep(){
            System.out.println(age+"岁，叫"+name+"正在睡觉....");
            System.out.println(i);
        }
    }
}

public class InnerClassDemo1 {

    public static void main(String[] args) {
        //创建外部类对象  外部类对象.成员();
        OuterClass1 o = new OuterClass1();
        o.setName("张三");
        o.eat();

        //创建内部类对象  外部类的对象.new 成员内部类的构造方法();
        OuterClass1.InnerClass i = o.new InnerClass();
        i.setAge(2);
        i.sleep();
    }

}
