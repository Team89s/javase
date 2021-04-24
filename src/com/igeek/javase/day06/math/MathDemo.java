package com.igeek.javase.day06.math;

/**
 * @version 1.0
 * @Description Math 数学类  java.lang.Math
 * @Author chenmin
 * @Date 2020/11/4 16:02
 */
public class MathDemo {

    public static void main(String[] args) {

        System.out.println(Math.PI);  //3.141592653589793

        //static double ceil(double a)  返回最小（接近负无穷大） double值是大于或等于的说法，等于一个数学整数。
        System.out.println(Math.ceil(10.6));   //11.0
        System.out.println(Math.ceil(-10.6));  //-10.0

        //static double floor(double a)  收益最大（最接近正无穷大） double值小于或等于该参数等于数学整数。
        System.out.println(Math.floor(10.6));  //10.0
        System.out.println(Math.floor(-10.6)); //-11.0

        //static double max(double a, double b)  返回两个 double值越大。
        System.out.println("max = "+Math.max(10.6,11.3));

        //static int min(int a, int b)  返回两个 int值较小。
        System.out.println("min = "+Math.min(10,12));

        //static double random() 返回一个 double值与一个积极的迹象，大于或等于 0.0小于 1.0。[0.0 , 1.0)
        System.out.println(Math.random());
    }

}
