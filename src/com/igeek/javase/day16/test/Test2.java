package com.igeek.javase.day16.test;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @version 1.0
 * @Description 文本排序
 * @Author chenmin
 * @Date 2020/11/26 9:41
 */
public class Test2 {

    public static void main(String[] args) {

        Map<Integer,String> map = new TreeMap<>();
        List<Character> list = Arrays.asList('一','二','三','四','五','六','七','八','九');

        try (
                BufferedReader br = new BufferedReader(new FileReader("出师表1.txt"));
                PrintWriter pw = new PrintWriter("出师表2.txt");
        ){
            String str;
            //读入
            while((str=br.readLine())!=null){
                map.put(list.indexOf(str.charAt(0)),str);
            }

            //写出
            for (String value : map.values()) {
                pw.println(value);
                pw.flush();
            }
            System.out.println("写出成功！");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
