package com.igeek.javase.day21.test;

import java.io.*;
import java.util.Properties;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/22 19:41
 *
 * 有一个用于记录程序运行次数的属性文件，运行次数保存在一个count属性中，
 * 当到达指定次数3次时，则提示:"程序使用次数已满，请续费"
 * 1. 开发思路：
 * 1).判断属性文件是否存在，如果不存在则创建一个。
 * 2).使用load()方法加载文件中所有的属性到Properties集合中。
 * 3).取得count属性，如果count属性为null，则设置count属性为0。
 * 4).将取得的字符串转成整型，并判断是否大于等于3次，大于3次则到期，退出。
 * 5).小于3则输出运行次数，并加1。
 * 6).将整数转成字符串后存到Properties集合中。
 * 7).创建输出流，并用store方法保存到文件中。
 */
public class Test9 {

    public static void main(String[] args) throws IOException {
        //1.加载properties文件上的count值
        File file = new File("count.properties");
        if(!file.exists()){
            file.createNewFile();
        }
        FileInputStream fis = new FileInputStream(file);
        Properties properties = new Properties();
        properties.load(fis);
        fis.close();

        //2.判断
        String count = properties.getProperty("count");
        if(count==null){
            //一次都未运行
            count = "1";
        }else{
            int i = Integer.parseInt(count);
            if(i>=3){
                System.out.println("程序使用次数已满，请续费");
                return;
            }else{
                i++;
                System.out.println("当前运行次数为："+i);
                count=i+"";
            }
        }

        //3.写回至properties文件上
        FileOutputStream fos = new FileOutputStream(file);
        properties.setProperty("count",count);
        properties.store(fos,"保存运行次数count");
        fos.close();
    }

}
