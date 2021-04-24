package com.igeek.javase.stu.test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.sort;

/**
 * @Description TODO
 * @Author 蔡祥麟
 * @Date 2020/12/4 16:20
 * 题目描述：
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 *
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class CharacterGroupStreamTest {
    public static void groupAnagrams(String[] strs){
        //将字符串数组转化为stream流
        Stream<String> s = Stream.of(strs);
        //调用groupingBy方法
        Map<String, List<String>> collect = s.collect(Collectors.groupingBy(a -> {
            //将字符串数组转化为字符数组并排序
            char[] chars = a.toCharArray();
            sort(chars);
            return Arrays.toString(chars);
        }));
        System.out.println(collect);
    }
    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(Arrays.toString(arr));//[eat, tea, tan, ate, nat, bat]
        groupAnagrams(arr);//{[a, n, t]=[tan, nat], [a, b, t]=[bat], [a, e, t]=[eat, tea, ate]}
    }
}
