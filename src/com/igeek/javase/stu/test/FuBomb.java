package com.igeek.javase.stu.test;

import java.util.Arrays;

/**
 * @Description 如果?k > 0，将第i个数字用 接下来k个数字之和替换。
     *  * * 如果?k < 0，将第i个数字用 之前k个数字之和替换。
 *  * * 如果?k == 0?，将第i个数字用0替换。
 * @Author fuxiaohai
 * @Date 2020/12/10 0010 18:02
 */
public class FuBomb {
    public static void main(String[] args) {
         int[] code = {2,4,9,3};
         int[] bomb = bomb(code, -2);
         System.out.println(Arrays.toString(bomb));
    }


    public static int[] bomb(int[] arr,int key){
        int length = arr.length;
        int[] newArr = new int[length];

        if (key==0){
            return newArr;
        }else {
            for (int i = 0; i <length ; i++) {
                int sum = 0;
                for(int j=0;j<Math.abs(key);j++){
                    //如果?k > 0，将第i个数字用 接下来k个数字之和替换。 i后面的
                    if (key>0){
                       sum += arr[(i+j+1)%length];
                    }else if(key<0){
                        //如果?k < 0，将第i个数字用 之前k个数字之和替换。
                        sum += arr[(i+length-(j+1))%length];
                    }
                }
                newArr[i] = sum;
            }
        }

        return newArr;
    }
}
 
  