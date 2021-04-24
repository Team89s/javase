package com.igeek.javase.day10.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @Description ArrayList类
 * @Author chenmin
 * @Date 2020/11/11 10:33
 *
 * List集合  接口
 * 1.允许重复存放
 * 2.有序的（按照存储顺序，获取元素）
 *
 * ArrayList 实现类
 * 1.基于数组的原理，在内存中是连续的
 * 2.查询快，增删慢
 * 3.线程不安全的
 * 4.使用频率最高的
 *
 * 常用方法：
 * 1.boolean add(E e) 将指定的元素列表的结束。
 * 2.E remove(int index) 移除此列表中指定位置的元素。
 * 3.boolean remove(Object o) 从该列表中移除指定元素的第一个发生，如果它是存在的。
 * 4.E set(int index, E element) 用指定元素替换此列表中指定位置的元素。
 * 5.E get(int index) 返回此列表中指定位置的元素。
 *
 * List<String> list = new ArrayList<>(); (多态的形式，是实际项目中最常用的写法)
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        //创建ArrayList集合对象
        ArrayList<String> list = new ArrayList<>();

        //boolean add(E e) 将指定的元素列表的结束。
        list.add("小黄鸭");
        list.add("123");
        list.add("hello");
        //void add(int index, E element)  在列表中指定的位置上插入指定的元素。
        list.add(2,"小丑鸭");
        //boolean addAll(int index, Collection<? extends E> c) 将指定集合中的所有元素插入到该列表中，从指定位置开始。
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("abc");
        list1.add("ABC");
        list.addAll(2,list1);
        System.out.println(list);
        //void clear()  从这个列表中移除所有的元素。
        //list.clear();
        //System.out.println(list);
        //boolean contains(Object o) 返回 true如果这个列表包含指定元素。
        System.out.println("---------contains---------");
        System.out.println(list.contains("abc"));
        System.out.println(list.contains("aaa"));
        //E get(int index) 返回此列表中指定位置的元素。
        System.out.println("---------get---------");
        System.out.println(list.get(2));  //0~size()-1
        //boolean isEmpty()  返回 true如果此列表不包含元素。
        System.out.println("---------isEmpty---------");
        //list1.clear();
        System.out.println(list.isEmpty());  //false
        System.out.println(list1.isEmpty()); //true
        //int lastIndexOf(Object o) 返回此列表中指定元素的最后一个发生的索引，或-如果此列表不包含元素，或- 1。
        System.out.println("---------lastIndexOf---------");
        System.out.println(list);
        System.out.println(list.lastIndexOf("小丑鸭"));
        System.out.println("---------remove---------");
        //E remove(int index) 移除此列表中指定位置的元素。
        System.out.println(list.remove(1));  //123
        //boolean remove(Object o) 从该列表中移除指定元素的第一个发生，如果它是存在的。
        System.out.println(list.remove("hello1"));  //false
        //boolean removeAll(Collection<?> c) 从这个列表中移除包含在指定集合中的所有元素。
        //System.out.println(list.removeAll(list1)); //false
        System.out.println(list);
        //boolean retainAll(Collection<?> c)  仅保留包含在指定集合中的列表中的元素。
        //System.out.println("--------retainAll--------");
        //System.out.println(list.retainAll(list1));  //true
        //System.out.println(list);  //[abc, ABC]
        System.out.println("--------set---------");
        //E set(int index, E element) 用指定元素替换此列表中指定位置的元素。
        list.set(2,"new-ABC");
        System.out.println(list);
        //int size()  返回此列表中元素的数目。
        System.out.println("长度："+list.size());
        //List<E> subList(int fromIndex, int toIndex)  返回一个视图之间的指定 fromIndex，包容，和 toIndex这份名单的部分，独家。
        System.out.println("---------subList---------");
        System.out.println(list.subList(1,3));
        //Object[] toArray() 返回一个数组，包含在这个列表中的所有元素在适当的顺序（从第一个到最后一个元素）。
        //<T> T[] toArray(T[] a) 返回一个数组，包含在这个列表中的所有元素在适当的顺序（从第一到最后一个元素）；返回数组的运行时类型是指定的数组的运行时类型。
        System.out.println("---------集合转数组toArray---------");
        String[] strs = list.toArray(new String[0]);
        System.out.println(Arrays.toString(strs));
        System.out.println("---------数组转集合Arrays.asList-----------");
        Integer[] ins = {12,45,3,65};
        List<Integer> integers = Arrays.asList(ins);
        System.out.println(integers);
    }



}
