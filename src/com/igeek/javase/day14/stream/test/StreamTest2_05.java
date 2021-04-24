package com.igeek.javase.day14.stream.test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/23 15:43
 *
 * //5.获取Integer集合中最大值
 */
public class StreamTest2_05 {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(new Integer[]{6, 7, 3, 8, 1, 2, 9});
        //Optional<Integer> max = list.stream().max(Comparator.comparing(Integer::intValue));
        //Optional<Integer> max = list.stream().max(Comparator.comparingInt(Integer::intValue));
        Optional<Integer> max = list.stream().max(Integer::compareTo);
        //Optional<Integer> max = list.stream().max((a,b)->(a-b));  不建议使用，不够优雅
        System.out.println("max = "+max.orElse(0));
    }

}
