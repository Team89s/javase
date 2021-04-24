package com.igeek.javase.stu;

/**
 * @version 1.0
 * @Description TODO
 * @Author 成斌
 * @Date 2020/12/14 13:30
 */

/*小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。
字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。
给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。
注意，如果字符串 x 在字典排序中位于 y 之前，就认为 x 字典序比 y 小，有以下两种情况：
x 是 y 的一个前缀；
如果 i 是?x[i] != y[i] 的第一个位置，且 x[i]?在字母表中的位置比?y[i]?靠前

输入：n = 5, k = 73
输出："aaszz"
输入：n = 3, k = 27
输出："aay"

*/
public class Greedy {//贪婪算法

    public static String getSmallString(int n, int k){
        char[] chars=new char[n];
        int index=n-1;
        //贪婪策略 能放下z就放z 从后往前
        while(n>0){
            if(k-26>=n-1){//aaszz 73
                chars[index--]='z';
                k-=26;
            }else if(k>n){//()()()  a+a+"x"=21
                chars[index--]=(char) ('a'+k-n);
                k=n-1;
            }else {
                chars[index--]='a';
                k--;
            }
            n--;
        }


        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(getSmallString(3, 27));
    }

}
