package com.igeek.javase.day11.map;

import java.util.Hashtable;

/**
 * @version 1.0
 * @Description HashTable类
 * @Author chenmin
 * @Date 2020/11/13 11:18
 *
 *                extends                      implements
 * Properties类  ------------->  HashTable类   ----------->  Map接口
 *
 * Map接口
 *  * 1.Map<K,V>  K键  V值
 *  * 2.K键  Set集合
 *  * 3.V值  Collection集合
 *  * 4.put(K,V) 添加元素
 *  * 5.map集合添加元素，保证键不重复的，一旦键重复可会造成value值得覆盖
 *
 * HashTable类
 * 1.实现了一个哈希表，它映射了值的键  (类似于HashMap)
 * 2.任何非null对象可以作为key或值
 * 3.线程安全的
 *
 * Properties类 (重要  IO流操作再重点学习)
 * Properties类代表一个持久的特性
 */
public class HashTableDemo {

    public static void main(String[] args) {
        Hashtable<String,Integer> hashtable = new Hashtable();
        hashtable.put("abc",10);
        hashtable.put("aaa",20);
        hashtable.put("abd",30);
        hashtable.put("aaa",40);
        //hashtable.put(null,null);
        //hashtable.put("bbb",null);
        hashtable.forEach((k,v)->{
            System.out.println(k+"="+v);
        });
    }

}
