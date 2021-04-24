package com.igeek.javase.day14.functionalInterface.test;

import java.util.function.Consumer;

/**
 * @version 1.0
 * @Description Consumer 类
 * @Author chenmin
 * @Date 2020/11/20 15:39
 *
 * //格式化打印信息  String[] array = { "张三,女", "李四,女", "王二麻,男" };
 * 如上字符串数组当中存有多条信息，请按照格式姓名：XX。性别：XX。的格式将信息打印出来。
 * 要求将打印姓名的动作作为第一个Consumer接口的Lambda实例，将打印性别的动作作为第二个Consumer接口的Lambda实例。
 */
public class ConsumerTest {

    public static void print(Consumer<String> c1,Consumer<String> c2,String[] array){
        for (String s : array) {
            c1.andThen(c2).accept(s);

            //等价于
            /*c1.accept(s);
            c2.accept(s);*/
        }
    }

    public static void main(String[] args) {
        String[] array = { "张三,女", "李四,女", "王二麻,男" };
        print(
            a -> System.out.print("姓名："+a.split(",")[0]+"。"),
            b -> System.out.println("性别："+b.split(",")[1]),
            array
        );
    }

}
