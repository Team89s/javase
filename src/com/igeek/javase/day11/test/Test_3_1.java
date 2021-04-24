package com.igeek.javase.day11.test;

import java.util.*;

/**
 * @version 1.0
 * @Description 关卡三-第一题
 * @Author 孙二林
 * @Date 2020/12/7 15:01
 *
 * Map中有{张三=3,李四=4,王五=5,赵六=6,孙七=7,田七=7,周八=5}这些元素.
 * 将Map中value相同的元素从Map中去除(value为7和5是相同的,都要删除).
 * 再将Map中剩余元素的key存放到一个ArrayList中,并打印到控制台上  //3 4 6
 */
public class Test_3_1 {

    public static void main(String[] args) {

        Map<String,Integer> map = new HashMap<String,Integer>();
        map.put("张三",3);
        map.put("李四",4);
        map.put("王五",5);
        map.put("赵六",6);
        map.put("孙七",7);
        map.put("田七",7);
        map.put("周八",5);

        //此valueSet集合中，存储的map集合的value值，确保不重复
        Collection<Integer> values = map.values();
        System.out.println(values);  //[4, 7, 3, 5, 6, 5, 7]

        List<String> keyList = new ArrayList<>();
        map.forEach((k,v)->{
            Map<String,Integer> newMap = new HashMap<String,Integer>(map);
            newMap.remove(k);  //王五
            boolean flag = newMap.containsValue(v);
            if(!flag){
                keyList.add(k);
            }
        });
        System.out.println(keyList);
    }

}


