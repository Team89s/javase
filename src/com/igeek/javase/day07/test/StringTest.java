package com.igeek.javase.day07.test;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description String练习
 * @Author chenmin
 * @Date 2020/11/6 9:33
 */
public class StringTest {

    public static void main(String[] args) {
        //统计
        /*Scanner sc = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String str = sc.nextLine();
        StringTest.total(str);*/

        /*String[] strs = {"nba","abc","cba","afe","abb","haha"};
        StringTest.sort(strs);*/

        System.out.println(StringTest.myTrim("   abc 12 3  ")+"AAAA");
    }

    //练习1：统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数。(不考虑其他字符)
    public static void total(String str){
        //统计数字
        int count1 = 0;
        //统计小写字母
        int count2 = 0;
        //统计大写字母
        int count3 = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(Character.isDigit(ch)){
                count1++;
            }else if(Character.isLowerCase(ch)){
                count2++;
            }else if(Character.isUpperCase(ch)){
                count3++;
            }
        }

        System.out.println("数字个数："+count1);
        System.out.println("小写字母个数："+count2);
        System.out.println("大写字母个数："+count3);
    }

    //练习3：给定一个字符串数组。按照字典顺序进行从小到大的排序。{"nba","abc","cba","zz","qq","haha"}
    public static void sort(String[] strs){
        //让数组中的元素具备比较性
        Arrays.sort(strs);
        //容器自身具备比较性
        /*Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });*/
        System.out.println(Arrays.toString(strs));
    }


    //练习4：模拟一个trim()功能一致的方法。
    public static String myTrim(String str){
        int start = 0;
        int end = str.length()-1;
        for(int i=0;i<str.length();i++) {
            if(start<end && str.charAt(start)==' ') {
                start++;
            }
            if(start<end && str.charAt(end)==' ') {
                end--;
            }
        }
        return str.substring(start,end+1);
    }

}
