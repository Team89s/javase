package com.igeek.javase.day16.print;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * @version 1.0
 * @Description PrintWriter类
 * @Author chenmin
 * @Date 2020/11/25 16:12
 *
 * 打印流
 * PrintWriter  字符流  打印流  高效流
 * 使用评率高
 */
public class PrintWriterDemo {

    public static void main(String[] args) {
        try (
                PrintWriter ps = new PrintWriter("abc.txt");
        ){
            ps.println("后天星期五");
            ps.append("xxxx");
            ps.flush();
            System.out.println("写出完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        /*try (
                PrintWriter ps = new PrintWriter(new FileWriter("abc.txt",true));
        ){
            ps.println("后天星期五");
            ps.println("xxxx");
            ps.flush();
            System.out.println("写出完成");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
