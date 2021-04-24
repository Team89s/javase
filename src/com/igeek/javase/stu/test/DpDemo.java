package com.igeek.javase.stu.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chengbin
 * @Date 2020/11/26 22:04
 */
public class DpDemo {

    public static void main(String[] args) {
        int[] arr={-2,1,-3,4,-1,2,1,-5,4};

        System.out.println("数组的连续子数组和的最大值："+getMax(arr));
    }

    public static int getMax(int[] arr){
        int max=0;//定义初始最大子数组的和最大值

        int[] dp=new int[arr.length];//每个连续子数组的最大和存放的数组
        dp[0]=-2;//第一个连续子数组只有-2，最大值也就是-2

        //如果dp[i-1] < 0, dp[i] = num[i]
        //如果dp[i-1] >= 0, dp[i] = dp[i-1] + num[i]
        for (int i = 1; i < arr.length; i++) {
            dp[i] = dp[i-1] < 0 ? arr[i] : (dp[i-1] + arr[i]);
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}
