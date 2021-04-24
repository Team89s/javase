package com.igeek.javase.day18.juc.list;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @version 1.0
 * @Description 集合不安全 - 解决方案：CopyOnWriteArrayList类
 * @Author chenmin
 * @Date 2020/12/4 10:41
 *
 * ArrayList集合 线程不安全的类
 * 代码中会出现java.util.ConcurrentModificationException异常，“并发下修改异常”
 */
public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        /**
         * 并发访问下ArrayList线程不安全的
         * List<String> list = new ArrayList<>();
         *
         * 解决ArrayList线程安全的方式：
         * 1.方式一：List<String> list = new Vector<>();
         * 线程安全的类，方法中都添加了Synchronized，执行效率会低
         *
         * 2.方法二：List<String> list = Collections.synchronizedList(new ArrayList<>());
         * 通过Collections集合工具类，将ArrayList转换成线程安全的集合
         *
         * 3.方式三：CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();
         * CopyOnWrite  优化的策略，写入时赋值    “读写分离”
         * CopyOnWriteArrayList  性能更优
         */
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList();

        for (int i = 1; i <=50 ; i++) {
            final int temp = i;
            new Thread(()->{
                list.add("abc"+temp);
                System.out.println(list);
            },"线程"+i).start();
        }

    }

}
