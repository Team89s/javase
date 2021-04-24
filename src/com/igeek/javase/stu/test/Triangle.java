package com.igeek.javase.stu.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 张小强
 */
public class Triangle {
    public static void main(String[] args) {
        int[] x = {3, 4, 5,6};
get(x);

    }

    public static void get(int[] arr) {
        int x=0;
        List<int[]> list=new ArrayList<>();
        for (int i = 0; i < arr.length-2; i++) {
            for (int j = i+1; j <arr.length-1 ; j++) {
                for (int k = j+i; k <arr.length ; k++) {
                    if(i!=j&&i!=k&&j!=k){
                        if(arr[i]+arr[j]>arr[k]&&arr[k]+arr[j]>arr[i]&&arr[i]+arr[k]>arr[j]){
                            int [] c={arr[i],arr[j],arr[k]};
                            list.add(c);
                            x++;
                        }
                    }
                }
            }
        }
        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println("一共有"+x+"个");
    }

}
