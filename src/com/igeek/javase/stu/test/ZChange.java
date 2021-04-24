package com.igeek.javase.stu.test;

/**
 * @Description Z字型变换
 * @Author 施立环
 * @Date 2020/12/8 18:43
 *  Z字形变换
 *  将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z 字形排列。
 *  比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 *  L   C   I   R
 *  E T O E S I I G
 *  E   D   H   N
 *
 *  之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 *  请你实现这个将字符串进行指定行数变换的函数：
 *  String convert(String s, int numRows);
 *
 *  示例2:
 *  输入: s = "LEETCODEISHIRING", numRows = 4
 *  输出:"LDREOEIIECIHNTSG"
 *  解释:
 *
 *  L     D     R
 *  E   O E   I I
 *  E C   I H   N
 *  T     S     G
 */
public class ZChange {
     public static String convert(String s, int numRows){
         //当行数为1时
         if(numRows==1){
             return s;
         }
         StringBuilder sb=new StringBuilder();
         //一个循环的长度
         int cycleLen=2*numRows-2;
         //第i行，行数从0开始
         for (int i = 0; i < numRows; i++) {
             for (int j = 0; i+j <s.length() ; j+=cycleLen) {
                 sb.append(s.charAt(i+j));
                 //当不是第一行和最后一行时
                 if(i!=0&&i!=numRows-1&&j+cycleLen-i<s.length()){
                     sb.append(s.charAt(j+cycleLen-i));
                 }
             }
         }
         return sb.toString();
     }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 4));
    }
}
