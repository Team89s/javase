package com.igeek.javase.day11.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @version 1.0
 * @Description 关卡三-第二题
 * @Author chenmin
 * @Date 2020/12/7 15:18
 *
 * 极客营包含2个班级:Java基础班,Java就业班
 * Java基础班:
 *      001	李晨
 *      002	范冰冰
 * Java就业班:
 *      001	马云
 *      002	马化腾
 * 使用HashMap嵌套HashMap方式完成,1使用keySet和增强for遍历出里面的元素,2使用entrySet和迭代器遍历出里面的元素
 */
public class Test_3_2 {

    public static void main(String[] args) {
        Map<String,String> javaseMap = new HashMap<>();
        javaseMap.put("001","李晨");
        javaseMap.put("002","范冰冰");

        Map<String,String> javaeeMap = new HashMap<>();
        javaeeMap.put("001","马云");
        javaeeMap.put("002","马化腾");

        Map<String,Map<String,String>> map = new HashMap<>();
        map.put("Java基础班",javaseMap);
        map.put("Java就业班",javaeeMap);

        //1使用keySet和增强for遍历出里面的元素   键的集合
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            Map<String, String> value = map.get(key);
            Set<String> keySet1 = value.keySet();
            for (String key1 : keySet1) {
                String value1 = value.get(key1);
                System.out.println(key+" = ("+key1+" = "+value1+")");
            }
        }

        System.out.println("++++++++++++++++++++++++++++++++++");
        //2使用entrySet和迭代器遍历出里面的元素  键值对集合
        Set<Map.Entry<String,Map<String,String>>> entries = map.entrySet();
        Iterator<Map.Entry<String, Map<String, String>>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Map<String, String>> entry = iterator.next();
            String key = entry.getKey();
            //第一重对应的值是Map集合
            Map<String, String> value = entry.getValue();
            Set<Map.Entry<String, String>> entries1 = value.entrySet();
            Iterator<Map.Entry<String, String>> iterator1 = entries1.iterator();
            while (iterator1.hasNext()){
                Map.Entry<String, String> entry1 = iterator1.next();
                String key1 = entry1.getKey();
                String value1 = entry1.getValue();
                System.out.println(key+" = ("+key1+" = "+value1+")");
            }
        }

        System.out.println("++++++++++++++++++++++++++++++++++");
        //3Lambda使用迭代
        map.forEach((k,v)->{
            v.forEach((k1,v1)->{
                System.out.println(k+" = ("+k1+" = "+v1+")");
            });
        });
    }

}
