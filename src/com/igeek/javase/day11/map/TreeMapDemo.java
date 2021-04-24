package com.igeek.javase.day11.map;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @version 1.0
 * @Description TreeMap类
 * @Author chenmin
 * @Date 2020/11/13 10:49
 *
 * Map接口
 *  * 1.Map<K,V>  K键  V值
 *  * 2.K键  Set集合
 *  * 3.V值  Collection集合
 *  * 4.put(K,V) 添加元素
 *  * 5.map集合添加元素，保证键不重复的，一旦键重复可会造成value值得覆盖
 *
 * TreeMap类
 *  * 1.键不重复的，一旦键重复可会造成value值得覆盖
 *  * 2.添加元素，键进行自然排序
 *    3.TreeMap的键与TreeSet的原理一致  红黑树
 *    4.线程不安全
 *    5.TreeMap不允许存放null键
 *  排序性：
 *  1.添加元素具备比较性  implements Comparable接口  compareTo()
 *  2.集合容器自身具备比较性  new Comparator接口   compare()
 *  总结：java有就近原则，两个比较方式同时存在，会选择Comparator接口的比较逻辑
 */
public class TreeMapDemo {

    public static void main(String[] args) {
        TreeMap<PersonInfo,Integer> map = new TreeMap<>(new Comparator<PersonInfo>() {
            @Override
            public int compare(PersonInfo o1, PersonInfo o2) {
                return o2.getAge()-o1.getAge();
            }
        });
        map.put(new PersonInfo("zhangsan",22),10);
        map.put(new PersonInfo("zhangda",48),20);
        map.put(new PersonInfo("zhanger",32),30);
        map.put(new PersonInfo("zhangsan",22),40);
        map.put(new PersonInfo("zhangdada",22),40);
        map.put(new PersonInfo("zhangdada",22),null);
        //map.put(null,null);

        map.forEach((k,v)->{
            System.out.println(k+" = "+v);
        });
    }

}
