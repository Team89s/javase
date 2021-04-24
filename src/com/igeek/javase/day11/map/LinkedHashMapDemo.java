package com.igeek.javase.day11.map;

import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @version 1.0
 * @Description LinkedHashMap
 * @Author chenmin
 * @Date 2020/11/13 10:31
 *
 * Map接口
 *  * 1.Map<K,V>  K键  V值
 *  * 2.K键  Set集合
 *  * 3.V值  Collection集合
 *  * 4.put(K,V) 添加元素
 *  * 5.map集合添加元素，保证键不重复的，一旦键重复可会造成value值得覆盖
 *
 * LinkedHashMap类
 *    1.键不重复的，一旦键重复可会造成value值得覆盖
 *    2.添加元素，键保证存取顺序
 *    3.LinkedHashMap的键与LinkedHashSet原理一致  JDK1.8 哈希表（链表+数组+红黑树），会多出一条链表维护存取顺序
 *    4.线程不安全
 *    5.允许 null值和 null关键
 */
public class LinkedHashMapDemo {

    public static void main(String[] args) {
        LinkedHashMap<Person,String> map = new LinkedHashMap<>();

        //V put(K key, V value)  将指定的值与此映射中的指定键关联。
        map.put(new Person("abc",23),"abc");
        map.put(new Person("add",9),"add");
        map.put(new Person("aaa",32),"aaa");
        map.put(new Person("aaa",32),"bbb");
        map.put(null,null);

        //boolean containsKey(Object key) 返回 true如果这Map包含一个指定的键映射。
        System.out.println(map.containsKey(new Person("aaa",32)));

        //V remove(Object key)  如果存在（可选操作），则从该Map中移除一个键的映射。
        System.out.println(map.remove(new Person("aaa",32)));

        //V replace(K key, V value)  仅当它当前映射到某一值时，替换指定的键的条目。
        System.out.println(map.replace(null,"AAA"));

        Set<Person> keys = map.keySet();
        for (Person key : keys) {
            System.out.println("key="+key+",value="+map.get(key));
        }
    }

}
