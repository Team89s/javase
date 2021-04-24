package com.igeek.javase.stu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author 张小强
 * @Date 2020/12/21 13:24
 */
 /*
    给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
    找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。
    假定每组输入只存在唯一答案。
    示例：
    输入：nums = [-1,2,1,-4], target = 1
    输出：2
    解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     */
public class CloseTest {
    public static void main(String[] args) {
        int arr[] = {-1, 2, 1, -4};
        int x = 1;
        System.out.println(test(arr, x));
    }

    public static int test(int[] arr, int target) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    list.add(arr[i] + arr[j] + arr[k]);
                }
            }

        }
        if (list.contains(target)) {
            return target;

        } else {
            list.add(target);
            Collections.sort(list);
            int i = list.indexOf(target);
            if (i >= 1) {
                if (i < list.size() - 1) {
                    if ((target - list.get(i - 1)) <= (list.get(i + 1) - target)) {
                        return list.get(i - 1);
                    } else {
                        return list.get(i + 1);
                    }
                } else {
                    return list.get(i - 1);
                }

            } else {
                return list.get(i + 1);
            }
        }
    }
}
