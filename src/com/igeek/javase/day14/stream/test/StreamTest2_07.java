package com.igeek.javase.day14.stream.test;

import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/23 15:43
 *
 * //7.计算Integer集合中大于6的元素的个数
 */
public class StreamTest2_07 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{6, 7, 3, 8, 1, 2, 9});
        long count = list.stream().filter(s -> s > 6).count();
        System.out.println(count);
    }

}
