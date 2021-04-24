package com.igeek.javase.day07.string;

/**
 *
 * StringBuilder -- String
 * 		public String toString():通过toString()就可以实现把StringBuilder转成String
 *
 * String -- StringBuilder
 * 		StringBuilder(String str):通过构造方法就可以实现把String转成StringBuilder
 */
public class StringBuilderDemo {

    public static void main(String[] args) {
        //链式编程

        //1.StringBuilder -- String
        String str1 = new StringBuilder("abc").append(true).toString();
        System.out.println("str1 = "+str1);

        //2.String -- StringBuilder
        String str2 = new String("username");
        StringBuilder sb = new StringBuilder(str2);
        System.out.println("sb = "+sb);

    }

}
