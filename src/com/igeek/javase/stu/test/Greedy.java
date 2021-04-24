package com.igeek.javase.stu.test;

/**
 * @Description 贪婪法
 * 小写字符 的 数值 是它在字母表中的位置（从 1 开始），因此 a 的数值为 1 ，b 的数值为 2 ，c 的数值为 3 ，以此类推。
 * 字符串由若干小写字符组成，字符串的数值 为各字符的数值之和。例如，字符串 "abe" 的数值等于 1 + 2 + 5 = 8 。
 * 给你两个整数 n 和 k 。返回 长度 等于 n 且 数值 等于 k 的 字典序最小 的字符串。
 * 注意，如果字符串 x 在字典排序中位于 y 之前，就认为 x 字典序比 y 小，有以下两种情况：
 * x 是 y 的一个前缀；
 * 如果 i 是x[i] != y[i] 的第一个位置，且 x[i]在字母表中的位置比y[i]靠前
 * 输入：n = 5, k = 73
 * 输出："aaszz"
 * 输入：n = 3, k = 27
 * 输出："aay"
 * @Author 吴详
 * @Date 2020/12/14 19:19
 */
public class Greedy {
    //贪婪算法
    //n 为字符串长度 k为返回的最小数值
    public static String method(int n,int k){
        char[] chars = new char[n];//定义一个长度为n的字符数组，存放字符
        int index = n-1; //数组下标
        //贪婪策略 从字母的最后一个z开始，能存放z就存放，总是选择最优解的那个字符
        while (n>0){
            if (k-26>=n-1){
                //从后往前遍历
                chars[index--] = 'z';
                k-=26;
            }else if (k>n){
                chars[index--]=(char)('a'+k-n);
                k=n-1;
            }else if (k>0){
                chars[index--]='a';
                k--;
            }else {
                System.out.print("未找到符合条件的字符串");
            }
            n--;
        }
        return new String(chars);
    }
    //测试类
    public static void main(String[] args) {
        System.out.println(method(1,0));
        System.out.println(method(3,27));
    }
}
