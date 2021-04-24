package com.igeek.javase.day11.map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @version 1.0
 * @Description Map 的迭代方式
 * @Author chenmin
 * @Date 2020/11/13 9:43
 *
 * 1.keySet()    获取所有的键
 * 2.entrySet()  获取所有键值对
 * 3.values()    获取所有的值
 * 4.Lambda表达式 获取所有键值对
 */
public class IterDemo {

    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        //添加元素
        map.put("adb",10);
        map.put("aaa",10);
        map.put("adb",30);
        map.put("abc",10);

        //迭代  keySet()
        System.out.println("------------ keySet()--------------");
        //获取键的set集合
        Set<String> keys = map.keySet();
        for (String key : keys) {
            //通过键获取值
            System.out.println("key="+key+",values="+map.get(key));
        }

        //迭代 entrySet()
        System.out.println("----------entrySet()------------");
        //获取键值对的set集合
        Set<Map.Entry<String,Integer>> entries = map.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println("key="+entry.getKey()+",value="+entry.getValue());
        }

        //迭代 values
        System.out.println("----------values---------");
        Collection<Integer> values = map.values();
        for (Integer value : values) {
            System.out.println("value="+value);
        }

        //Lambda
        System.out.println("----------Lambda-----------");
        map.forEach((k,v)->{
            System.out.println("key="+k+",value="+v);
        });
    }

}
