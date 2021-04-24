package com.igeek.javase.day09.generic;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @version 1.0
 * @Description 泛型 & 泛型的好处
 * @Author chenmin
 * @Date 2020/11/9 16:01
 *
 * 泛型：
 * 1.可以在类或方法声明时预支地使用未知的类型，但是当实际使用时需要传递进来真实的类型
 * 2.在集合中使用最为广泛，一旦指定了集合泛型，当前添加元素时必须按照指定类型添加
 * （暴力添加元素：反射）
 * 3.将运行时期的ClassCastException，转移到了编译时期变成了编译失败。
 * 4.避免了类型强转的麻烦。
 */
public class GenericDemo1 {

    public static void main(String[] args) {

        //接口  Collection
        Collection<String> c = new ArrayList();
        c.add("哈利波特");
        //c.add(true);  //java.lang.ClassCastException: java.lang.Boolean cannot be cast to java.lang.String
        //c.add(123);
        c.add("abc");

        //迭代  ((String)s).length()  强制转换
        for (String s : c) {
            System.out.println("s="+s+"，当前字符串的长度："+s.length());
        }

    }

}
