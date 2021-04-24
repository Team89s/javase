package com.igeek.javase.day10.set;

/**
 * @version 1.0
 * @Description Set接口
 * @Author chenmin
 * @Date 2020/11/11 16:00
 *
 * Set接口
 * 1.存储的元素是不可重复的
 * 2.丢失原存储顺序（元素都是无序的(即存取顺序不能保证不一致)）
 *
 * HashSet 实现类
 * 1.根据对象的哈希值来确定元素在集合中的存储位置，无序状态（存取顺序不能保证不一致）
 * 2.具有良好的存储和查找性能
 * 3.保证元素的唯一性 - equals()和hashCode()
 * 4.线程不安全的
 *
 * TreeSet 实现类
 * 1.使用元素的[自然顺序]实现Comparable接口，对元素进行排序
 * 2.保证元素的唯一性 - compareTo()
 * 3.底层依赖于TreeMap,是一种基于红黑树的实现
 * 4.线程不安全的
 *
 * LinkedHashSet 实现类
 * 1.根据对象的哈希值来确定元素在集合中的存储位置
 * 2.具有良好的存储和查找性能
 * 3.保证元素的唯一性 - equals()和hashCode()
 * 4.有序（存取顺序一致），加上了链表进行存储保证有序性
 * 5.线程不安全的
 */
public class SetDemo {
}
