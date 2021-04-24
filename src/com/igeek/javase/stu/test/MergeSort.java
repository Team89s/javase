package com.igeek.javase.stu.test;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description 归并排序
 * @Author 朱永俊
 * @Date 2020/12/17 13:46
 */
public class MergeSort {

    public static void sort(int[] array){
        //定义过渡数组
        int[] temp = new int[array.length];

        sort(array,0,array.length-1,temp);
    }

    //递归排序
    public static void sort(int[] array,int left,int right,int[] temp){
        if(left<right){
            int mid = (left+right)/2;
            //左序列，让左序列有序
            sort(array,0,mid,temp);
            //右序列，让右序列有序
            sort(array,mid+1,right,temp);
            merge(array,left,mid,right,temp);
        }

    }

    //合并
    public static void merge(int[] array,int left, int mid,int right,int[] temp){
        int i = left;
        int j = mid+1;
        //定义过渡数组的临时下标
        int t = 0; //temp[]

        while (i<=mid&&j<=right){
            if(array[i] <= array[j]){
                temp[t++] = array[i++];
            }else {
                temp[t++] = array[j++];
            }
        }

        //左序列剩余元素
        while (i<=mid){
            temp[t++] = array[i++];
        }

        //有序列剩余元素
        while (j<=right){
            temp[t++] = array[j++];
        }

        //拷贝
        t=0;
        while (left<=right){
            array[left++] = temp[t++];
        }

    }

    public static void main(String[] args) {
        int[] array = {9,8,7,6,5,4,3,2,1};
        System.out.println(Arrays.toString(array));
        sort(array);
        System.out.println(Arrays.toString(array));
    }

}
