package com.igeek.javase.day04.interfaces;

/**
 * @version 1.0
 * @Description  JDK1.8接口特点 - 默认的方法
 * @Author chenmin
 * @Date 2020/11/2 10:27
 *
 * 接口中的成员：
 * 1.除了有公开的静态的常量、公开的抽象的方法
 * 2.新增：
 *      1).默认的方法  public 可写可不写（若不写，默认提供的）
 *          1).public default 返回值类型/void  方法名(){ }
 *          2).实现类可以实现默认的方法，也可以不实现
 *          3).使用：子类对象.默认方法();
 *          4).当实现类实现多个接口时，此时多个接口拥有相同的默认方法，则实现类必须重写此默认方法
 *          5).一旦实现类重写接口中的默认方法，不要添加default关键字
 *
 *      2).静态的方法  public 可写可不写（若不写，默认提供的）
 */
interface A {

    public default void test(){
        System.out.println("A test()...");
    }

}
interface B {

    public default void test(){
        System.out.println("B test()...");
    }

}
public class InterfaceDemo1 implements A,B{

    @Override
    public void test() {
        System.out.println("InterfaceDemo1  test()...");
    }

    public static void main(String[] args) {
        InterfaceDemo1 d1 = new InterfaceDemo1();
        d1.test(); //InterfaceDemo1  test()...

        A a = new InterfaceDemo1();
        a.test(); //InterfaceDemo1  test()...

        B b = new InterfaceDemo1();
        b.test(); //InterfaceDemo1  test()...
    }


}



