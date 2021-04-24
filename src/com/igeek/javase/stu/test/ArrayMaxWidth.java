package com.igeek.javase.stu.test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Description TODO
 * @Author Joker Wu  吴祥
 * @Date 2020/11/30 23:11
 * 题目：
 * 给定一个整数数组A，坡是元组(i, j)，其中i < j且A[i] <= A[j]。这样的坡的宽度为j - i。
 * 找出A中的坡的最大宽度，如果不存在，返回 0 。
 * 示例 1：
 * 输入：[6,0,8,2,1,5]
 * 输出：4
 * 解释：
 * 最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 * 本题用到的知识点：
 * 双端队列： deque支持高效插入和删除容器的头部元素
 * deque容器为一个给定类型的元素进行线性处理，像向量一样，它能够快速地随机访问任一个元素，并且能够高效地插入和删除容器的尾部元素
 * 常用方法：
 * void push(E) 向队列的头部插入一个元素
 * E pop() 弹出队列头部元素
 * E peek() 取队首元素但不删除
 */
public class ArrayMaxWidth {
    public static void main(String[] args) {
        //初始化一个数组
        int[] arr = {6, 0, 8, 2, 1, 5};
        int max = maxWidth(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("坡的最大宽度为:" + max);

    }

    /**
     * @methodName maxWidth
     * @Description 计算数组坡底到坡顶的最大宽度方法
     * [A]
     * @return void
     */
    public static int maxWidth(int[] A) {
        //定义一个坡度宽度最大值
        int max = 0;
        //定义一个双端队列容器用来存储符合题意的数组下标
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < A.length; i++) {
            // 数组下标为 0 1 2 3 4 5
            while (dq.isEmpty() || A[dq.peek()] > A[i]) {
                //若满足条件，将坡底对应的数组下标元素插入到队列的头部
                dq.push(i);
            }
        }
        //逆序遍历数组，找出坡顶距离坡底时的最大宽度
        for (int j = A.length - 1; j > 0; j--) {
            while (!dq.isEmpty() && A[dq.peek()] <= A[j]) {
                Integer pop = dq.pop();
                max = Math.max(max, j - pop);
            }
        }
        return max;
    }

}
