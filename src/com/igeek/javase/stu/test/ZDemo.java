package com.igeek.javase.stu.test;

import java.util.ArrayList;

/**
 * @Description TODO
 * @Author 吴涛
 * @Date 2020/12/8 21:41
 */
//Z字形变换
// 将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z 字形排列。
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
public class ZDemo {

          public static void main(String[] args) {
               String str = convert("ABCDEFJKMNQWERTY", 2);
               System.out.println(str);
         }

        public static String convert(String str, int num){
            if(num==1){
                return str;
            }
            ArrayList<StringBuilder> list = new ArrayList<>();
            for (int i = 0; i < Math.min(str.length(), num); i++) {
                list.add(new StringBuilder());
            }
            int Row = 0;
            boolean Down = false;
            for (char c : str.toCharArray()) {
                list.get(Row).append(c);
                if(Row==0||Row==num-1){
                    Down=!Down;
                }
                  Row+=Down?1:-1;
            }
            StringBuilder Str = new StringBuilder();
            for (StringBuilder s : list) {
                Str.append(s);
            }
            return Str.toString();
        }





}
