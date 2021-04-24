package com.igeek.javase.day16.properties;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * @version 1.0
 * @Description Properties 属性集
 * @Author chenmin
 * @Date 2020/11/26 16:15
 *
 * Properties 新建Properties类，赋值，写出到磁盘上
 *
 * 常用方法：
 *      Properties()  构造方法
 *      Object setProperty(String key, String value)  设置键值对
 *      void store(OutputStream out, String comments) 以字节流写出至指定文件
 *      void store(Writer writer, String comments)    以字符流写出至指定文件
 *      Set<String> stringPropertyNames()             获取properties文件上所有的键
 *
 */
public class PropertiesStoreDemo {

    public static void main(String[] args) {
        //创建Properties属性集对象
        Properties props = new Properties();
        //设置键值对
        props.setProperty("name","李四");
        props.setProperty("age","123");
        //获取所有的键
        //Set<String> keys = props.stringPropertyNames();
        //keys.forEach(System.out::println);
        //将Properties信息写出至文件
        try (FileWriter fw = new FileWriter("src\\abc.properties");){
            //将Properties对象信息写出至磁盘上
            props.store(fw,"properties store");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
