package com.igeek.javase.day15.test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/8 9:29
 *
 * 在d盘目录下有一个加密文件a.txt（文件里只有英文和数字），密码是“igeek”
 * 当密码输入正确时才能读取文件里的数据。现要求用代码来模拟读取文件的过程，
 * 并统计文件里各个字母出现的次数，并把统计结果按照如下格式输出到d盘的count.txt中。
 * a：2个
 * b：3个
 * c：4个
 * ............
 */
public class Test_15_3_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入密码：");
        String pwd = sc.next();
        while (true){
            if(pwd.equals("igeek")){
                break;
            }else{
                System.out.println("请再次输入密码核对：");
            }
            pwd = sc.next();
        }

        Test_15_3_2 test = new Test_15_3_2();
        //读取文件信息
        Map<Character,Integer> map = test.readFile(new File("D:\\a.txt"));
        //写出至文件
        test.writeFile(map,new File("D:\\count.txt"));
    }

    //读取文件，返回Map集合 <每个字符,字符的统计个数>
    public Map<Character,Integer> readFile(File file){
        Map<Character,Integer> map = new HashMap<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))){
            String str = null;
            while ((str=br.readLine())!= null){
                char[] chars = str.toCharArray();
                for (char c : chars) {
                    if(map.containsKey(c)){
                        //原本map集合中包含指定的键，进行覆盖
                        map.put(c,map.get(c)+1);
                    }else{
                        //map集合不包含指定的键，进行插入元素
                        map.put(c,1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    //写出至文件
    public void writeFile(Map<Character, Integer> map , File file) {
        try (PrintWriter pw = new PrintWriter(file)){
            map.forEach((k,v)->{
                //a : 10
                pw.println(k+" : "+v);
            });
            pw.flush();
            System.out.println("写出成功");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
