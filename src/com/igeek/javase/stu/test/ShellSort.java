package com.igeek.javase.stu.test;

import java.util.Arrays;

/**
 * @Description 希尔排序算法
 * @Author designal朱永俊
 * @Date 2020/11/24 11:03
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {2,3,7,9,1,10,4,23,0};
        System.out.println(Arrays.toString(shellSort(arr)));
    }

    /**
    * @methodName: shellSort
    * @Description: //TODO 希尔排序
    * @param: [array]
    * @return void
    */
    public static int[] shellSort(int[] array){
        if(array == null || array.length <= 1){
            return array;
        }
        //定义初始增量
        int grp = array.length / 2;
        for (int i = grp; grp>0; grp /= 2) {
            //调用插入排序算法
            insertSort(array,grp);
        }
        return array;
    }

    /**
    * @methodName: insertSort
    * @Description: //TODO 插入排序
    * @param: []
    * @return void
    */
    public static void insertSort(int[] array,int grp){
        for (int i = grp; i < array.length; i++){
            //i:插入的元素的下标（每一组比较数据的最后一个元素）
            //j:代表与i同一组的数组元素下标
            for (int j = i-grp; j>=0; j-=grp){//i-grp 为了避免下面数组角标越界
                if (array[j] > array[j+grp]) {// j+grp 代表即将插入的元素所在的角标
                    //符合条件，插入元素（交换位置）
                    int temp = array[j];
                    array[j] = array[j+grp];
                    array[j+grp] = temp;
                }
            }
        }
    }
}
