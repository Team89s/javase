package com.igeek.javase.day11.test;

import java.util.TreeSet;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/16 16:25
 *
 * 将字符串中的数值进行排序。例如String str="8 10 15 5 2 7";    2,5,7,8,10,15  使用 TreeSet完成。
 */
public class Test3 {

    public static void main(String[] args) {
        String str="8 10 15 5 2 7";
        TreeSet<Integer> set = new TreeSet<>();
        String[] strings = str.split(" ");
        for (String s : strings) {
            set.add(Integer.parseInt(s));
        }
        System.out.println(set);
    }

}
