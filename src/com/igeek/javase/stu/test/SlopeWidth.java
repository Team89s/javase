package com.igeek.javase.stu.test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @Description TODO
 * @Author 徐超
 * @Date 2020/12/1 8:47
 */
public class SlopeWidth {

    public static int max(int[] arr){
        Deque<Integer> dq = new ArrayDeque<>(); //双向队列，LinkedList是它的实现，存放arr的下标
        for (int i = 0; i < arr.length; i++) {
            while (dq.isEmpty() || arr[dq.peek()]>arr[i]){
                dq.push(i);
            }
        }

        int max = 0;  //定义坡的最大宽度
        for (int j=arr.length-1;j>=0;j--){
            while(!dq.isEmpty() && arr[dq.peek()]<=arr[j]){
                Integer pop = dq.pop();
                max = Math.max(max,j-pop);
            }
        }
          return max;
    }

    public static void main(String[] args) {

           int[] arr = {4,11,9,15,2,43};
           int i = max(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("坡的最大宽度为:"+i);

    }
}
