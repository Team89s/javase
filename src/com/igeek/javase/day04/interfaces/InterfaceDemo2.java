package com.igeek.javase.day04.interfaces;

/**
 * JDK1.8接口特点 - 静态的方法
 *
 * 接口中的成员：
 *  1.除了有公开的静态的常量、公开的抽象的方法
 *  2.新增：
 *      1).默认的方法  public 可写可不写（若不写，默认提供的）
 *      2).静态的方法  public 可写可不写（若不写，默认提供的）
 *          1).public static 返回值类型/void 方法名(参数列表){  }
 *          2).使用：当前接口名.静态方法();  注意：不能使用子类调用
 *
 */
interface C{
    public static void test(){
        System.out.println("C test()....");
    }
}
interface D{
    public static void test(){
        System.out.println("D test()....");
    }
}
public class InterfaceDemo2 implements C,D{

    public static void main(String[] args) {
        InterfaceDemo2 d = new InterfaceDemo2();
        //InterfaceDemo2.test();

        C.test();
        D.test();

    }

}
