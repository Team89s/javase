package com.igeek.javase.day06.math;

import java.util.Arrays;
import java.util.Date;

/**
 * @version 1.0
 * @Description System java.lang.System 系统类
 * @Author chenmin
 * @Date 2020/11/4 16:19
 */
public class SystemDemo {

    public static void main(String[] args) {

        //1.static long currentTimeMillis()  返回当前时间以毫秒为单位。
        long l = System.currentTimeMillis();
        System.out.println("当前时间："+l);
        Date date = new Date(l);
        System.out.println(date);

        //2.static void exit(int status)  终止当前正在运行的java虚拟机。
        //System.exit(0); //状态码为0时，代表虚拟机正常关闭；一切非0都是异常关闭

        //3.static void arraycopy(Object src, int srcPos, Object dest, int destPos, int length) 从指定的源数组中复制一个数组，开始在指定的位置，到目标数组的指定位置。
        int[] arr = {1,2,3,4,5,6};
        int[] brr = new int[arr.length+3];
        /**
         * arraycopy
         * 第一个参数：Object src  源数组
         * 第二个参数：int srcPos  源数组中的起始位置
         * 第三个参数：Object dest 目标数组
         * 第四个参数：int destPos 目标数组的起始位置
         * 第五个参数：int length  拷贝的长度
         */
        System.arraycopy(arr,1,brr,3,4); //brr [0,0,0,2,3,4,5,0,0]
        System.out.println(Arrays.toString(brr));
    }

}
