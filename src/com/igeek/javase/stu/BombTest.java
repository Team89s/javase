package com.igeek.javase.stu;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description TODO
 * @Author 蔡祥麟
 * @Date 2020/12/10 13:34
 * * 你有一个炸弹需要拆除，时间紧迫！你的情报员会给你一个长度为n的循环数组code以及一个密钥k。
 * *
 * * 为了获得正确的密码，你需要替换掉每一个数字。所有数字会同时被替换。
 * *
 * * 如果?k > 0，将第i个数字用 接下来k个数字之和替换。
 * * 如果?k < 0，将第i个数字用 之前k个数字之和替换。
 * * 如果?k == 0?，将第i个数字用0替换。
 * * 由于?code?是循环的，?code[n-1]?下一个元素是?code[0]?，且?code[0]?前一个元素是?code[n-1]?。
 * *
 * * 给你 循环?数组?code?和整数密钥?k?，请你返回解密后的结果来拆除炸弹！
 * *
 * * 示例 1：
 * * 输入：code = [5,7,1,4], k = 3
 * * 输出：[12,10,16,13]
 * *[7+1+4,1+4+5,4+5+7,5+7+1]
 * * 示例 2：
 * * 输入：code = [1,2,3,4], k = 0
 * * 输出：[0,0,0,0]
 * *
 * * 示例 3：
 * * 输入：code = [2,4,9,3], k = -2
 * * 输出：[12,5,6,13]
 * [3+9,2+3,4+2,9+4]
 */
public class BombTest {
    public static int[] decrypt(int[] code,int k){
        int length=code.length;
        int[] result = new int[length];//存放返回的结果
        if (k==0){
            //如果k == 0，将第i个数字用0替换。
            return result;
        }else {
            for (int i = 0; i <length ; i++) {
                int sum=0;//k个数字之和
                for (int j = 0; j <Math.abs(k) ; j++) {//Math.abs(k):返回k的绝对值
                    if (k>0){
                        //如果k > 0，将第i个数字用 接下来k个数字之和替换。
                        sum+=code[(i+(j+1))%length];
                    }else {
                        //如果k < 0，将第i个数字用 之前k个数字之和替换。
                        sum+=code[(i-(j+1)+length+(Math.abs(k)*length/length))%length];
                    }
                }
                result[i]=sum;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] code={2,4,9,3};
        System.out.println("炸弹的密码为："+Arrays.toString(decrypt(code, -22)));
    }
}
