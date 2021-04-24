package com.igeek.javase.day05.innerclass;

/**
 * @version 1.0
 * @Description 内部类 - 匿名内部类
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
 *          4).匿名内部类
 *              - 简化代码的编写
 *              - 使用频率很高的
 *              - 没有名字的内部类
 *              - new 抽象类 | 接口(){ //重写抽象方法 }
 */
//外部类
abstract class A{
   public abstract void a();
}
interface B{
    void b();
}
public class InnerClassDemo4 {

    public static void main(String[] args) {

        //new 抽象类(){ //重写抽象方法 }
        A a = new A() {
            @Override
            public void a() {
                System.out.println("A a()...");
            }
        };
        a.a();

        //new 接口(){ //重写抽象方法 }
        B b = new B() {
            @Override
            public void b() {
                System.out.println("B b()...");
            }
        };
        b.b();

        //线程启动
        /*new Thread(){
            @Override
            public void run(){

            }
        }.start();
        */
    }

}
