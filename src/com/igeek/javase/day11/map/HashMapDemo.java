package com.igeek.javase.day11.map;

import java.util.HashMap;

/**
 * @version 1.0
 * @Description HashMap类
 * @Author chenmin
 * @Date 2020/11/13 9:31
 *
 *  Map接口
 *  * 1.Map<K,V>  K键  V值
 *  * 2.K键  Set集合
 *  * 3.V值  Collection集合
 *  * 4.put(K,V) 添加元素
 *  * 5.map集合添加元素，保证键不重复的，一旦键重复可会造成value值得覆盖
 *
 *  HashMap类
 *    1.键不重复的，一旦键重复可会造成value值得覆盖
 *    2.添加元素，键无法保证存取顺序
 *    3.线程不安全的
 *    4.允许 null值和 null关键
 *    5.HashMap的键与HashSet原理一致  JDK1.8 哈希表（链表+数组+红黑树）
 *
 */
public class HashMapDemo {

    public static void main(String[] args) {
        HashMap<Person,String> map = new HashMap<>();

        //V put(K key, V value)  将指定的值与此映射中的指定键关联。
        map.put(new Person("abc",23),"abc");
        map.put(new Person("add",9),"add");
        map.put(new Person("aaa",32),"aaa");
        map.put(new Person("aaa",32),"bbb");
        map.put(null,null);

        map.forEach((k,v)->{
            System.out.println("key = "+k+",value="+v);
        });
    }

}
