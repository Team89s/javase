package com.igeek.javase.day10.conllections;

/**
 * @version 1.0
 * @Description 集合的总结
 * @Author chenmin
 * @Date 2020/11/12 15:35
 *
 * 常用集合的总结：
 *      1.ArrayList  最常用
 *      2.LinkedList
 *      3.Vector  线程安全，用的少
 *      4.HashSet
 *      5.LinkedHashSet
 *      6.TreeSet
 *
 *      当项目中经常需要对集合容器做查询操作，优先选择ArrayList，例如登录、分页+条件搜索等
 *      当项目中经常需要对集合容器的头尾操作，优先选择LinkedList，例如浏览记录、自定义数据源连接池等
 *      当项目中需要对添加进容器中的元素保证唯一性，但是不考虑排序问题，也不关心存取顺序，优先选择HashSet，例如注册
 *      当项目中需要对添加进容器中的元素既保证唯一性，又要进行排序，优先选择TreeSet，例如类似于ATM项目中的按照同身份证号进行资产排名
 *      当项目中需要对添加进容器中的元素既保证唯一性，又要存取顺序，优先选择LinkedHashSet
 *
 *      一旦需要存储双值（键值对），优先选择Map集合
 *      HashMap  保证key键的唯一性，不在意存取顺序
 *      LinkedHashMap  保证key键的唯一性，又要保证存取顺序
 *      TreeMap  保证key键的唯一性，保证key键的排序
 *      Properties 读取properties属性文件
 */
public class Demo {
}
