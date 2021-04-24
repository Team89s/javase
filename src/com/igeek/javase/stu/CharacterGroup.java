package com.igeek.javase.stu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @Description
 *
题目描述：
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
输出:
[
["ate","eat","tea"],
["nat","tan"],
["bat"]
]
注意：
所有输入均为小写字母。
不考虑答案输出的顺序。
 * @Author 吴详
 * @Date 2020/12/4 12:26
 */
public class CharacterGroup {

    public static List<List<String>> groupAnagrams(String[] strs ){
        List<List<String>> result = new ArrayList<>();
        if (strs.length==0){
            return result;
        }
        for (int i = 0; i < strs.length; i++) {
            char[] chars1 = strs[i].toCharArray();
            //对字符数组排序
            Arrays.sort(chars1);
            boolean flag = true;
            for (int j = 0; j < result.size(); j++) {
                //拿到result集合中的第一个集合的第一个元素
                String str = result.get(j).get(0);
                //将字符串转换成字符数组
                char[] chars2 = str.toCharArray();
                Arrays.sort(chars2);
                if (Arrays.equals(chars1,chars2)){
                    //第j行的集合中的最后位置中
                    result.get(j).add(result.get(j).size(),strs[i]);
                    flag = false;
                    break;
                }
            }
            if (flag){
                List<String> sub = new ArrayList<>();
                sub.add(strs[i]);
                result.add(sub);
            }
        }
        return result;

    }
    public static void main(String[] args) {
        String[] arr = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(Arrays.toString(arr));
        System.out.println(groupAnagrams(arr));
    }




}
