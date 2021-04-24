package com.igeek.javase.day14.stream.test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/23 15:43
 *
 * //4.获取String集合中最长的元素
 */
public class StreamTest2_04 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList(new String[]{"aaa","asdasddd","sd","asdasdsa"});
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("max = "+max.orElse(""));
    }

}
