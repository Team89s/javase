package com.igeek.javase.day14.stream.test;

import com.igeek.javase.day14.stream.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/23 11:20
 *
 * 1. 第一个队伍只要名字为3个字的成员姓名；
 * 2. 第一个队伍筛选之后只要前3个人；
 * 3. 第二个队伍只要姓张的成员姓名；
 * 4. 第二个队伍筛选之后不要前2个人；
 * 5. 将两个队伍合并为一个队伍；
 * 6. 根据姓名创建`Person`对象；
 * 7. 打印整个队伍的Person对象信息。
 */
public class StreamTest1 {

    public static void main(String[] args) {
        List<String> one = new ArrayList<>();
        one.add("迪丽热巴");
        one.add("宋远桥");
        one.add("苏星河");
        one.add("老子");
        one.add("庄子");
        one.add("孙子");
        one.add("洪七公");

        List<String> two = new ArrayList<>();
        two.add("古力娜扎");
        two.add("张无忌");
        two.add("张三丰");
        two.add("赵丽颖");
        two.add("张二狗");
        two.add("张天爱");
        two.add("张三");

        Stream<String> oneStream = one.stream();
        Stream<String> twoStream = two.stream();

        /*
        1. 第一个队伍只要名字为3个字的成员姓名；
        2. 第一个队伍筛选之后只要前3个人；
         */
        Stream<String> oneNewStream = oneStream.filter(s -> s.length() == 3).limit(3);

        /*
        3. 第二个队伍只要姓张的成员姓名；
        4. 第二个队伍筛选之后不要前2个人；
        5. 将两个队伍合并为一个队伍；
         */
        Stream<String> twoNewStream = twoStream.filter(s -> s.startsWith("张")).skip(2);
        Stream<String> newStream = Stream.concat(oneNewStream, twoNewStream);

        /*
        6. 根据姓名创建`Student`对象；
        7. 打印整个队伍的Student对象信息。
         */
        newStream.map(Student::new).forEach(System.out::println);
    }

}
