package com.igeek.javase.stu.test;

import java.util.Arrays;

/**
 * @Description 拆炸弹
 * @Author 陆必顺
 * @Date 2020/12/10 19:01
 *
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
 *
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
 *
 * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * 如果 k == 0 ，将第 i 个数字用 0 替换。
 * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
 *
 * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
 */

public class LuBomb {

    public static int[] method(int[] code, int key){

        //获取待解密数组的长度
        int len = code.length;
        //创建数组arr,用来存放解密的结果
        int[] arr = new int[len];

        if (key==0){         //如果 k == 0 ，将第 i 个数字用 0 替换。
            return arr;
        }else{
            for (int i = 0; i < len; i++) {    //遍历给定的数组
                //记录要累加的元素的下标
                int index=0;
                //统计累加元素的个数
                int count=0;
                //统计累加的结果
                int sum=0;
                if (key>0){   //key大于0，从第i个元素的右侧开始
                    //从当前元素的下一个开始累加
                     index = i+1;
                     while (count<key){

                         //下标超过code数组的长度，则返回第一个元素
                         if (index>len-1){
                             index=0;
                         }
                         //元素进行累加
                         sum+=code[index];
                         //下标移动
                         index++;
                         count++;
                     }
                     //将累加结果放入结果数组的对应位置
                     arr[i]=sum;

                }else {      //key小于0，从第i个元素的左侧开始
                    //从当前元素的前一个元素开始
                    index = i-1;

                    //下标左侧越界，则返回最右侧
                    while (count<-key){
                        if (index<0){
                            index=len-1;
                        }
                        //元素累加
                        sum+=code[index];
                        index--;
                        count++;
                    }
                    //将累加结果放入结果数组的对应位置
                    arr[i]=sum;
                }
            }
            return arr;
        }

    }

    public static void main(String[] args) {

        int[] code = {5,7,1,4};

        int key = 3;

        System.out.println("解密后为："+Arrays.toString(method(code, key)));
    }
}
