package com.igeek.javase.day18.juc.list;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @version 1.0
 * @Description 集合不安全
 * @Author chenmin
 * @Date 2020/12/4 10:41
 *
 * 多线程并发访问HashMap集合时，出现了线程不安全的情况，java.util.ConcurrentModificationException 并发修改异常
 */
public class ConcurrentHashMapDemo {

    //static Map<String,String> map = new HashMap<>();
    //static Map<String,String> map = new Hashtable<>();
    //static Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
    static ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        /**
         * 多线程并发访问HashMap集合时，出现了线程不安全的情况
         *
         * 解决方案：
         * 方式一：Map<String,String> map = new Hashtable<>();
         * HashTable 线程安全的类，方法上添加了synchronized关键字，效率较差，淘汰了
         * HashTable效率低的原因：锁定整张hash哈希表，只要有一个线程进入操作，其他线程将进入阻塞
         *
         * 方式二：Map<String,String> map = Collections.synchronizedMap(new HashMap<>());
         *
         * 方式三：ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>();
         * 综合性能更高，ConcurrentHashMap高效的原因：CAS + 局部(synchronized)锁定  “分段式锁”
         */
        for (int i = 1; i <=50; i++) {
            final int temp = i;
            new Thread(()->{
                map.put(Thread.currentThread().getName()+"-"+temp,"abc"+temp);
                System.out.println(map);
            },"线程"+i).start();
        }
    }

}
