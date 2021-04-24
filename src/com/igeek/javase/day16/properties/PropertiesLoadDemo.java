package com.igeek.javase.day16.properties;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @version 1.0
 * @Description Properties 属性集
 * @Author chenmin
 * @Date 2020/11/26 16:15
 *
 * Properties 加载properties文件至内存中
 *
 * 常用方法：
 *      Properties()  构造方法
 *      String getProperty(String key)   通过键获取值
 *      void load(InputStream inStream)  通过字节流读入properties文件
 *      void load(Reader reader)         通过字符流读入properties文件
 *      Set<String> stringPropertyNames()  获取properties文件上所有的键
 *
 */
public class PropertiesLoadDemo {

    public static void main(String[] args) {

        Properties props = new Properties();
        try (FileReader fw = new FileReader("src\\abc.properties")){
            //加载Properties文件，将文件文本信息读入至内存中
            props.load(fw);
            //单个拿值
            String name = props.getProperty("name");
            System.out.println("name="+name);
            //批量获取值
            Set<String> keys = props.stringPropertyNames();
            keys.forEach(k->{
                System.out.println(k+"="+props.getProperty(k));
            });
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
