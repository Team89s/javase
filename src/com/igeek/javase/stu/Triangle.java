package com.igeek.javase.stu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/9 13:34
 *
 * 一个全是正数的整型数组，挑出三个数组成三角形，可以组成多少个？元素不能重复使用
 */
public class Triangle {

    public static List<int[]> method1(int[] arr){

        List<int[]> list = new ArrayList<>();
        if (arr.length<3)return null;

        for (int l1 = 0; l1 < arr.length - 2; l1++) {

            for (int l2 = l1+1; l2 < arr.length - 1; l2++) {
                for (int l3 = l2+1; l3 < arr.length; l3++) {

                    if (arr[l2]+arr[l3]>arr[l1] && arr[l1]+arr[l3]>arr[l2] && arr[l1]+arr[l2]>arr[l3]){

                        list.add(new int[]{arr[l1],arr[l2],arr[l3]});
                    }
                }
            }
        }

        return list;
    }


    public static List<int[]> method2(int[] arr){

        List<int[]> list = new ArrayList<>();

        if (arr.length<3)return null;

        //对数组进行排序
        Arrays.sort(arr);

        //从数组的第三个元素开始，作为三角形的第三条边，遍历数组
        for (int l3 = 2; l3 < arr.length; l3++) {

            //数组的第一个元素作为第一条边
            int l1 = 0;
            //第三条边的前一个元素作为第二条边
            int l2 = l3-1;

            while (l1<l2){

                //若较小的两条边之和大于最大的边，则符合条件
                if (arr[l1]+arr[l2]>arr[l3]){

                    //此时，l1~l2之间的元素作为第一条边都是符合条件的
                    for (int i = l1; i < l2; i++) {
                        list.add(new int[]{arr[i],arr[l2],arr[l3]});
                    }
                    //l2向l1移动
                    l2--;
                }else{
                    l1++;
                }
            }
        }

        return list;
    }

    public static void main(String[] args) {
        int[] arr = {3,3,3};

        List<int[]> list1 = method1(arr);

        if (list1!=null && list1.size()!=0){
            for (int[] ints : list1) {

                System.out.println(Arrays.toString(ints));
            }
            System.out.println("符合条件的三元组共有 "+list1.size()+" 个");
        }else{
            System.out.println("没有符合条件的三元组");
        }

        System.out.println("---------------------------");

        List<int[]> list2 = method2(arr);

        if (list2!=null && list2.size()!=0){
            for (int[] ints : list2) {

                System.out.println(Arrays.toString(ints));
            }
            System.out.println("符合条件的三元组共有 "+list2.size()+" 个");
        }else{
            System.out.println("没有符合条件的三元组");
        }
    }

}
