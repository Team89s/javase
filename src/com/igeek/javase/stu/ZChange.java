package com.igeek.javase.stu;

import java.util.ArrayList;

/**
 * Z字形变换
 将一个给定字符串根据给定的行数，以从上往下、从左到右进行Z 字形排列。
 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：

 L   C   I   R
 E T O E S I I G
 E   D   H   N

 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。

 请你实现这个将字符串进行指定行数变换的函数：
 String convert(String s, int numRows);

 示例2:
 输入: s = "LEETCODEISHIRING", numRows = 4
 输出:"LDREOEIIECIHNTSG"
 解释:

 L     D     R
 E   O E   I I
 E C   I H   N
 T     S     G

 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/8 13:34
 */
public class ZChange {
    public static String convert(String s, int numRows){
        if(numRows==1){
            return s;
        }

        //建立一个集合，存储每行的字符串，list.size()=numRows;
        ArrayList<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            list.add(new StringBuilder());
        }

        //遍历s，确定每个字符所在的行数，添加进每行的字符串
        //当前行
        int curRow = 0;
        //当前方向  false  向上  true 向下
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            list.get(curRow).append(c);
            if(curRow==0||curRow==numRows-1){
                goingDown=!goingDown;
            }
            curRow+=goingDown?1:-1;
        }

        //遍历集合，将所有的集合元素拼接在一起输出
        StringBuilder newStr = new StringBuilder();
        for (StringBuilder str : list) {
            newStr.append(str);
        }
        return newStr.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 4));
    }

}
