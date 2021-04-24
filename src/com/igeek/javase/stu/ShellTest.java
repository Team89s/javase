package com.igeek.javase.stu;
import java.util.Arrays;

/**
 * @version 1.0
 * @Description 希尔排序
 * @Author LiuHongRu
 * @Date 2020-11-21 10:08
 */
public class ShellTest {
    public static void main(String[] args) {
        int[] arrInt = {15, 21, 16, 70, 56, 38, 77, 65, 44, 35};
        int length=arrInt.length;
        while (length>1){
            length/=2;
            for (int i = 0; i <length ; i++) {
                for (int j = 0; j <arrInt.length-length ; j+=length) {
                    int k=j+length;
                    while (k<arrInt.length){
                        if (arrInt[j]>arrInt[k]){
                            int temp=arrInt[j];
                            arrInt[j]=arrInt[k];
                            arrInt[k]=temp;
                        }
                        k+=length;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arrInt));
    }
}
