package com.igeek.javase.stu;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/30 13:32
 */
/**
 * 给定一个整数数组A，坡是元组(i, j)，其中i < j且A[i] <= A[j]。这样的坡的宽度为j - i。
 *  找出A中的坡的最大宽度，如果不存在，返回 0 。
 *  示例 1：
 *  输入：[6,0,8,2,1,5]
 *  输出：4
 *  解释：
 *  最大宽度的坡为 (i, j) = (1, 5): A[1] = 0 且 A[5] = 5.
 */

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 以A[0] 递减的序列 抽离出来  坡底i在序列中
 * 反证：假设k  k(下标)的元素比之前所有元素都要小   确定坡底i
 * 逆向的遍历数组A  坡顶j
 *   0 3 5 7 6    6  4   3
 *   0 1 2 3 4
 *
 */
public class WidthRamp {
    public static int max(int[] A){
        Deque<Integer> dq = new ArrayDeque<>();//LinkedList 数组A的下标
        for (int i = 0; i < A.length; i++) {
            while(dq.isEmpty() || A[dq.peek()]>A[i]){
                dq.push(i);
            }
        }

        int max = 0; //坡的最大宽度
        for (int j = A.length-1; j >= 0; j--) {
            while(!dq.isEmpty() && A[dq.peek()]<=A[j]){//A[i] <= A[j]
                Integer pop = dq.pop();
                max = Math.max(max,j-pop);  //j - i
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] A={6,0,8,2,1,5};
        int i = max(A);
        System.out.println(Arrays.toString(A));
        System.out.println("坡的最大宽度:"+i);
    }
}
