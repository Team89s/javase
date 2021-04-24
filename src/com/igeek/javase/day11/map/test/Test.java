package com.igeek.javase.day11.map.test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/13 11:40
 *
 *需求：输入一个字符串中每个字符出现次数。  Map<K,V>集合
 */
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串：");
        String str = sc.nextLine();
        total(str);
    }


    public static void total(String str){
        Map<Character,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i <str.length() ; i++) {
            char ch = str.charAt(i);
            if(map.containsKey(ch)){  //若map集合中包含了key，获取值+1
                Integer value = map.get(ch);
                value+=1;
                map.put(ch,value);
            }else{  //若map集合中不包含了key，直接添加
                map.put(ch,1);
            }
        }
        System.out.println(map);
    }

    //Map<String,List<Book>>

}
