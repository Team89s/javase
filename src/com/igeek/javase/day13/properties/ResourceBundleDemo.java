package com.igeek.javase.day13.properties;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @version 1.0
 * @Description ResourceBundle类
 * @Author chenmin
 * @Date 2020/11/19 10:06
 *
 * ResourceBundle类：可以根据指定的Locale信息，加载对应的basename属性文件上的资源
 */
public class ResourceBundleDemo {

    public static void main(String[] args) {
        //获取Locale区域对象，指定的是中文/中国
        Locale locale = new Locale("zh","CN");
        /**
         *  ResourceBundle抽象类，直接调用静态方法获取它的对象
         *  第一个参数：properties文件的base name
         *  第二个参数：Locale  区域对象
         */
        //static ResourceBundle getBundle(String baseName, Locale locale)
        //获取使用指定的基名称和区域设置的资源包，以及调用方的类加载程序。
        ResourceBundle bundle = ResourceBundle.getBundle("msg", locale);

        //通过ResourceBundle对象，根据键key获取对应的值value
        String username = bundle.getString("login.username");
        String title = bundle.getString("login.title");
        System.out.println("login.username = "+username);
        System.out.println("login.title = "+title);
    }

}
