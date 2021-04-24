package com.igeek.javase.stu.test;

/**
 * @Description 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 *          找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
 *           假定每组输入只存在唯一答案。
 *          示例：
 *          输入：nums = [-1,2,1,-4], target = 1
 *          输出：2
 *          解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * @Author wyk（韦燕坤）
 * @Date 2020/12/21 20:26
 */
import java.util.ArrayList;
import java.util.List;

/**
 * 无效排序，把差值放进集合，再找出最小的差值即可。效率明显提高，看下面
 */
public class CloseTest {
    public static void main(String[] args) {
        int arr[] = {-1, 2, 1, -4};
        int x = 1;
        System.out.println(test(arr, x));

    }
    public static int test(int[] arr, int target){
        //把目标数之差放进集合
        List<Integer> list = new ArrayList();
        //获取最大值
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                  int sum=arr[i] + arr[j] + arr[k];
                  //差值为0
                  if(sum==target){
                      return target;
                  }else {
                      list.add(sum-target);
                      min=Math.min( Math.abs(sum-target),min);
                  }
                }
            }
            //包含，为正数
            //否则，为负数，只要变成负数即可
            if(list.contains(min)){
                return target+min;
            }else {
                return target-min;
            }
        }
   return 0;
    }
}
