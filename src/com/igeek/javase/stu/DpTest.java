package com.igeek.javase.stu;

/**
 * @version 1.0
 * @Description TODO
 * @Author 万青
 * @Date 2020/11/26 13:33
 *
 * 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * 要求时间复杂度为O(n)。
 *
 * 示例1:
 *
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 *
 * 动态规划dp 解题步骤：
 * 1.确定状态
 * 2.确定状态转移方程
 * 3.确定初始条件和边界条件
 * 4.确定计算顺序，一般是从前到后、从左到右、从上到下
 *
 * 重叠子问题、重复计算的有些问题
 * 解决方案：就是创建一个数组（集合）存放计算结果
 */
public class DpTest {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        method(arr);
    }
    private static void method(int[] num){
        //1.确定状态 dp[i] 以num[i]结尾的连续子数组的最大和
        //2.确定状态转移方程 dp[i] -> dp[i-1]
        //如果dp[i-1] < 0, dp[i] = num[i]
        //如果dp[i-1] >= 0, dp[i] = dp[i-1] + num[i]

        //3.确定初始条件和边界条件
        //dp[0] = num[0]   边界就是数组不越界

        //4.确定计算顺序，一般是从前到后、从左到右、从上到下
        int max = Integer.MIN_VALUE;
        int[] dp = new int[num.length];
        dp[0] = num[0];
        for (int i = 1; i < num.length; i++) {
            dp[i] = dp[i-1] < 0 ? num[i] : (dp[i-1] + num[i]);
            max = Math.max(max,dp[i]);
        }
        System.out.println("max = " + max);
    }
}
