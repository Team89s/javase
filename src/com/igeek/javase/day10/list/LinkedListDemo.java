package com.igeek.javase.day10.list;

import java.util.LinkedList;

/**
 * @version 1.0
 * @Description LinkedList类
 * @Author chenmin
 * @Date 2020/11/11 14:44
 *
 * List集合  接口
 * 1.允许重复存放
 * 2.有序的（按照存储顺序，获取元素）
 * 3.允许存放null值
 *
 * LinkedList
 * 1.基于链表实现的  node(nodePrevious、data、nodeNext)
 * 2.查询慢，增删快
 * 3.线程不安全的
 * 4.分头尾进行操作
 * 5.通过下标进行操作
 *
 * 使用场景：自定义的数据库连接池、浏览足迹
 *
 */
public class LinkedListDemo {

    public static void main(String[] args) {
        LinkedList<Object> list = new LinkedList();
        System.out.println("------------add添加------------");
        list.add("小强");
        list.add("abc");
        list.add(true);
        list.add(10);
        list.add(null);
        //void addFirst(E e)  在此列表的开始处插入指定的元素。
        list.addFirst("小宝");
        //void addLast(E e)  将指定的元素列表的结束。
        list.addLast("xxx");
        System.out.println(list);
        System.out.println("----------offer添加------------");  //队列 "入队列"
        //boolean offer(E e) 将指定的元素添加到列表的尾部（最后一个元素）。
        list.offer(12);
        //boolean offerFirst(E e) 在列表的前面插入指定的元素。
        //boolean offerLast(E e) 在列表的结尾插入指定的元素。
        System.out.println(list);
        System.out.println("----------push添加------------");  //堆栈  将值压入第一个 类似于"入栈/压栈"
        //void push(E e) 将一个元素推到由该列表所表示的堆栈上。
        list.push("world");
        System.out.println(list);

        System.out.println("----------get获取------------");
        //一旦获取的元素是不存在，则直接抛出异常NoSuchElementException
        //E get(int index) 返回此列表中指定位置的元素。
        System.out.println(list.get(0));
        //E getFirst() 返回此列表中的第一个元素。
        System.out.println(list.getFirst());
        //E getLast() 返回此列表中的最后一个元素。
        System.out.println(list.getLast());
        System.out.println(list);
        System.out.println("----------element获取------------");
        //一旦获取的元素是不存在，则直接抛出异常NoSuchElementException
        //E element() 检索，但不删除，此列表的头（第一个元素）。
        System.out.println(list.element());
        System.out.println(list);
        System.out.println("----------peek获取------------");
        //一旦获取的元素是不存在，返回null值
        //E peek()  检索，但不删除，此列表的头（第一个元素）。
        //E peekFirst() 检索，但不删除该列表的第一个元素，或返回 null如果这个列表是空的。
        System.out.println(list.peekFirst());
        //E peekLast()  检索，但不删除该列表的最后一个元素，或返回 null如果这个列表是空的。
        System.out.println(list);
        System.out.println("----------poll获取并删除------------");  //队列 "出队列"
        //一旦获取的元素是不存在，返回null值
        //E poll() 检索并删除此列表的头（第一个元素）。
        //E pollFirst()  检索并移除此列表的第一个元素，或返回 null如果这个列表是空的。
        System.out.println(list.pollFirst());
        //E pollLast()  检索并移除此列表的最后一个元素，或返回 null如果这个列表是空的。
        System.out.println(list);
        System.out.println("----------pop获取并删除------------");
        //一旦获取的元素是不存在，则直接抛出异常NoSuchElementException
        //E pop() 从这个列表所表示的堆栈中弹出一个元素。
        System.out.println(list.pop());  //弹栈  类似于"出栈"
        System.out.println(list);
        System.out.println("----------remove获取并删除------------");
        //一旦获取的元素是不存在，则直接抛出异常NoSuchElementException
        //E remove()  检索并删除此列表的头（第一个元素）。
        //E removeFirst() 移除并返回此列表中的第一个元素。
        System.out.println(list.removeFirst());
        //E removeLast()  移除并返回此列表中的最后一个元素。
        System.out.println(list.removeLast());
        System.out.println(list);
    }

}
