package com.igeek.javase.day14.stream.test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/23 15:43
 *
 * //2.筛选出Integer集合中大于7的元素，并打印，例如6,7,3,8,1,2,9
 */
public class StreamTest2_02 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{6, 7, 3, 8, 1, 2, 9});
        Stream<Integer> stream = list.stream();
        stream.filter(a->a>7).forEach(System.out::println);
    }

}
