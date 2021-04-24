package com.igeek.javase.day22.decorationpattern;

/**
 * @version 1.0
 * @Description 装饰模式
 * @Author chenmin
 * @Date 2020/12/17 11:31
 *
 * 装饰模式：指的是在不改变原来的类基础上，动态的拓展一个类的功能。
 * 思想：创建一个新的类即装饰类，包装原始类，从而在新类中提升原来类的功能。
 *
 * 典型代表：IO流
 *
 * 使用步骤：
 * 1.定义父类
 * 2.定义原始类，继承父类，重写功能
 * 3.定义装饰类，继承父类，包装原始类，增强功能
 */
public class Test {

    public static void main(String[] args) {
        InputStream is = new BufferedInputStream(new FileInputStream());
        is.read();
        is.close();
    }

}
