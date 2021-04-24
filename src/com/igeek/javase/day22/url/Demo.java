package com.igeek.javase.day22.url;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/17 14:45
 *
 *
 * 使用场景：Servlet高级部分Cookie
 */
public class Demo {

    public static void main(String[] args) throws UnsupportedEncodingException {
        //编码     % + 数字 + 字母
        String s = URLEncoder.encode("今天星期四", "UTF-8");
        System.out.println("编码："+s);

        //解码
        String s1 = URLDecoder.decode(s, "UTF-8");
        System.out.println("解码："+s1);
    }

}
