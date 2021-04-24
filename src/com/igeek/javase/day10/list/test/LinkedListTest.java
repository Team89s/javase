package com.igeek.javase.day10.list.test;

import java.util.LinkedList;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/11 15:27
 */
public class LinkedListTest {

    //模仿队列操作：先进先出   "排队"  添加1243数据，存储状态：4321，获取顺序：1234
    public static void deque(){
        LinkedList<Integer> deque = new LinkedList<>();
        //入  offer
        deque.offer(1);
        deque.offer(2);
        deque.offer(3);
        deque.offer(4);
        System.out.println(deque);  //[1, 2, 3, 4]
        //出  poll
        int size = deque.size();
        for (int i = 0; i < size; i++) {
            System.out.print(deque.poll()+" ");
        }

    }

    //模仿堆栈操作：先进后出  "压入子弹"  添加元素1234数据，存储状态：1234，获取顺序：4321
    public static void stack(){
        LinkedList<Integer> stack = new LinkedList<>();
        //入栈  push
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack);
        //出栈  pop
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop()+" ");
        }
    }

    public static void main(String[] args) {
        System.out.println("---------队列----------");
        deque();
        System.out.println("---------堆栈----------");
        stack();
    }


}
