package com.igeek.javase.day14.lambda;

import javax.swing.*;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * @version 1.0
 * @Description Lambda 表达式
 * @Author chenmin
 * @Date 2020/11/20 9:37
 *
 * lambda表达式简化匿名内部类，首先要求是接口，其次是该接口只有一个抽象方法。
 * 满足以上条件，就会称此接口为“函数式接口”
 */
public class LambdaDemo2 extends JFrame{

    public static void main(String[] args) {
        //无参数，无返回值
        //匿名内部类
        Test test = new Test();
        test.init(new MyInterface() {
            @Override
            public void work() {
                System.out.println("正在工作中....");
            }
        });

        //Lambda简化：
        test.init(() -> { System.out.println("正在工作中...."); });

        test.init(() -> System.out.println("正在工作中...."));

        System.out.println("---------------------------------------------------");

        //有参数，有返回值
        //匿名内部类
        TreeSet<String> set = new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        set.add("abc");
        set.add("ABD");
        set.add("ABB");
        System.out.println(set);

        //Lambda简化：
        TreeSet<String> set1 = new TreeSet<>((String o1, String o2) -> {
            return o1.compareToIgnoreCase(o2);
        });
        set1.add("aaa");
        set1.add("DDD");
        set1.add("BBB");
        System.out.println(set1);

        //Lambda简化
        TreeSet<String> set2 = new TreeSet<>((o1, o2) ->  o1.compareToIgnoreCase(o2) );

    }
}