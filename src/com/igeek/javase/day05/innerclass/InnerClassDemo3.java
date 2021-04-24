package com.igeek.javase.day05.innerclass;

/**
 * @version 1.0
 * @Description 内部类 - 局部内部类
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
 *          3).局部内部类：
 *              - 在外部类的某个方法中、代码块中声明的内部类
 *              - 语法与外部类一致
 *              - 使用：在方法内部完成创建及使用
 *              - 不会去使用，了解即可
 */
//外部类
class OuterClass3{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void eat(){

        //局部内部类
        class InnerClass{
            private int age;

            public int getAge() {
                return age;
            }

            public void setAge(int age) {
                this.age = age;
            }

            public void sleep(){
                System.out.println(age+",叫"+name+"正在睡觉....");
            }
        }

        //完成局部内部类的方法调用
        InnerClass i = new InnerClass();
        i.setAge(10);
        i.sleep();
    }
}

public class InnerClassDemo3 {

    public static void main(String[] args) {
        OuterClass3 o = new OuterClass3();
        o.setName("李四");
        o.eat();
    }

}
