package com.igeek.javase.day09.test;

/**
 * @version 1.0
 * @Description 作业卷
 * @Author chenmin
 * @Date 2020/11/16 14:53
 *
 * 统计101-200之间有多少个素数，并输出所有素数。
 * 素数又叫质数，就是除了1和它本身之外，再也没有整数能被它整除的数。
 */
public class Test3_03 {

    public static void main(String[] args) {
        int count = 0;

        for (int i = 101; i <=200 ; i++) {
            boolean flag = false;
            for(int j=2;j<i;j++){
                if(i%j==0){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                count++;
                System.out.println("i="+i);
            }
        }
        System.out.println("素数个数："+count);
    }

}
