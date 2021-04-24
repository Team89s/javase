package com.igeek.javase.day14.functionalInterface.test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * @version 1.0
 * @Description Predicate<T> 接口
 * @Author chenmin
 * @Date 2020/11/20 16:54
 *
 * //集合信息筛选  String[] array = { "张三,男", "李四,女", "王二麻子,女" };
 * 数组当中有多条“姓名+性别”的信息如下，请通过Predicate接口的拼装将符合要求的字符串筛选到集合ArrayList中，需要同时满足两个条件：
 * 1.必须为女生
 * 2.姓名为4个字
 */
public class PredicateTest {

    public static List<String> test(Predicate<String> p1,Predicate<String> p2,String[] array){
        List<String> list = new ArrayList<>();
        for (String s : array) {
            boolean flag = p1.and(p2).test(s);
            if(flag){
                list.add(s);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        String[] array = { "张三,男", "李四,女", "王二麻子,女" };
        List<String> list = test(
                a -> a.split(",")[1].equals("女"),
                b -> b.split(",")[0].length() == 4,
                array
        );
        System.out.println(list);
    }

}
