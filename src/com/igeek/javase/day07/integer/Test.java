package com.igeek.javase.day07.integer;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/5 14:40
 */
//练习：写一个程序，接受一个十六进制的数值字符串，输出改数值的十进制字符串
public class Test {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个十六进制的数值：");
        String str = sc.nextLine();

        //java.lang.NumberFormatException: For input string: "123213214241adcfaaaaaaafffff"
        /*long value = Long.parseLong(str.substring(2), 16);
        System.out.println("value = "+value);*/

        BigInteger integer = Test.transfer(str);
        System.out.println(integer);
    }

    //BigInteger
    public static BigInteger transfer(String str){
        BigInteger result = new BigInteger("0");
        BigInteger base = new BigInteger("16");
        if(str!=null && !str.equals("")){
            //将0x截取掉  0x   12ab45ef
            str = str.substring(2);

            for (int i = 0; i < str.length(); i++) {
                //fe54ba21
                char ch = str.charAt(str.length()-1-i);
                if(ch>='a' && ch<='f'){ //若取出来是字母 a-f   字母f  --->  15*16^0
                    BigInteger temp = new BigInteger(Integer.toString((ch - 'a')+10)).multiply(base.pow(i));
                    result = result.add(temp);
                }else{ //若取出来是数字 0-9   数字5 --->  5*16^2
                    BigInteger temp = new BigInteger(Character.toString(ch)).multiply(base.pow(i));
                    result = result.add(temp);
                }
            }
        }
        return result;
    }


}
