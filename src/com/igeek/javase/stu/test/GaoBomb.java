package com.igeek.javase.stu.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author 高敏
 * @Date 2020/12/10 18:30
 */

import java.util.Arrays;

/**
 * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为 n 的 循环 数组 code 以及一个密钥 k 。
 * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会 同时 被替换。
 * 如果 k > 0 ，将第 i 个数字用 接下来 k 个数字之和替换。
 * 如果 k < 0 ，将第 i 个数字用 之前 k 个数字之和替换。
 * 如果 k == 0 ，将第 i 个数字用 0 替换。
 * 由于 code 是循环的， code[n-1] 下一个元素是 code[0] ，且 code[0] 前一个元素是 code[n-1] 。
 * 给你 循环 数组 code 和整数密钥 k ，请你返回解密后的结果来拆除炸弹！
 *
 * 输入：code = [5,7,1,4], k = 3
 * 输出：[12,10,16,13]
 *
 * 提示：
 * n == code.length
 * 1 <= n <= 100
 * 1 <= code[i] <= 100
 * -(n - 1) <= k <= n - 1
 */
public class GaoBomb {

    public static int[] test(int[] a,int k){
        int length = a.length;
        int[] b = new int[a.length]; //存储解密结果
        //如果k==0,解密结果全为0
        if(k==0){ return b; }
        else {for (int i = 0; i < length; i++) {
            int num = 0; //数字之和
            for (int j = 0; j < Math.abs(k); j++) {
                if(k>0){
                    num+=a[(i+j+1)%length];
                }else if(k<0){
                    num+=a[(i-j-1+length)%length];
                }
            }
            b[i] = num;//存入数组
        }
            return b;
        }
    }

    public static void main(String[] args) {
        int[] a = {5,7,1,4};
        int k = 3;
        System.out.println("解密结果："+Arrays.toString(test(a,k)));
    }
}
