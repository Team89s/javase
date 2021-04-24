package com.igeek.javase.day22.base.url;

import java.util.Base64;

/**
 * @version 1.0
 * @Description Base64  URL
 * @Author chenmin
 * @Date 2020/12/17 14:15
 *
 * Java 8 内置了 Base64 编码的编码器和解码器。
 *
 * 编码：**static class Base64.Encoder**该类实现一个编码器，使用 Base64 编码来编码字节数据
 *
 * 解码：**static class Base64.Decoder**该类实现一个解码器用于，使用 Base64 编码来解码字节数据。
 */
public class Base64Demo {

    public static void main(String[] args) {

        //请求：http://localhost:8080/login?name=张三&pwd=123
        String s = Base64.getUrlEncoder().encodeToString("?name=张三&pwd=123".getBytes());
        System.out.println("编码："+s);

        byte[] bytes = Base64.getUrlDecoder().decode(s);
        System.out.println("解码："+new String(bytes));
    }
    
}
