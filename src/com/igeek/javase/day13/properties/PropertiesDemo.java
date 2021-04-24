package com.igeek.javase.day13.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @version 1.0
 * @Description Properties类
 * @Author chenmin
 * @Date 2020/11/19 9:13
 */
public class PropertiesDemo {

    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();

        /**
         * Class的API中：InputStream getResourceAsStream(String name)  查找给定名称的资源。
         * 将磁盘上的文件读入到内容中   InputStream输入字节流
         */
        InputStream inputStream = PropertiesDemo.class.getResourceAsStream("abc.properties");
        //Properties的API中：void load(InputStream inStream)  从输入字节流中读取属性列表（键和元素对）。
        properties.load(inputStream);

        /*System.out.println("username = "+properties.getProperty("username"));
        System.out.println("password = "+properties.getProperty("password"));
        System.out.println("age = "+properties.getProperty("age"));
        System.out.println("address = "+properties.getProperty("address"));*/

        //Properties 继承HashTable  实现Map
        properties.put("sex","男");
        properties.put("email","123@qq.com");

        //迭代
        properties.forEach((k,v)->{
            System.out.println(k+" = "+v);
        });
    }

}
