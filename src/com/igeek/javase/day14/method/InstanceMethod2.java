package com.igeek.javase.day14.method;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description 实例方法的引用
 * @Author chenmin
 * @Date 2020/11/20 17:16
 *
 * 实例方法的引用
 *
 *          引用格式：
 *
 * ​				对象::实例方法
 *
 * ​		简化步骤：
 *
 * ​				定义一个实例方法，把需要的代码放到实例方法中
 *
 * ​		注意事项：
 *
 * ​				被引用的方法的参数列表，要和函数式接口中的抽象方法的参数列表一致。
 */
public class InstanceMethod2 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("ccc");
        list.add("ddd");

        //Lambda 版本
        list.forEach(s -> System.out.println(s));

        /**
         * 实例方法的引用  对象::实例方法
         *
         * 对象  System.out  PrintStream流对象
         * 实例方法  println()
         */
        list.forEach(System.out::println);
    }

}
