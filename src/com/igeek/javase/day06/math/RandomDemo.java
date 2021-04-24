package com.igeek.javase.day06.math;

import java.util.Random;

/**
 * @version 1.0
 * @Description Random  java.util.Random  随机数类
 * @Author chenmin
 * @Date 2020/11/4 16:08
 */
public class RandomDemo {

    public static void main(String[] args) {

        Random random = new Random();
        //产生随机整数[0 , 10)
        System.out.println("随机整数："+random.nextInt(10));
        //产生随机小数[0.0 , 1.0)
        System.out.println("随机小数："+random.nextDouble());

        //特殊情况：相同种子数的Random对象，相同次数生成的随机数字是完全相同的。
        Random random1 = new Random(10);
        Random random2 = new Random(10);
        for (int i=0;i<1;i++){
            System.out.println(random1.nextInt(20));
            System.out.println(random2.nextInt(20));
        }
    }

}
