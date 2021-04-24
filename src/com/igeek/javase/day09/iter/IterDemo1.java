package com.igeek.javase.day09.iter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @version 1.0
 * @Description 集合的迭代
 * @Author chenmin
 * @Date 2020/11/10 10:22
 *
 * Collection 接口的三种迭代方式
 * 1.第一种迭代方式 - foreach
 * 语法：for(容器中元素类型  临时变量名:数组名/集合名){}
 *
 * 2.第二种迭代方式 - Iterator
 * Iterator  集合对象.iterator()
 * hasNext() 判断是否有下一个值
 * next() 取出下一个值
 *
 * 3.第三种迭代方式 - Lambda
 * 集合对象.foreach(临时变量名->{
 *     sout(临时变量名);
 * });
 */
public class IterDemo1 {

    public static void main(String[] args) {
        Collection<Object> cs = new ArrayList<>();
        cs.add("hello");
        cs.add(false);
        cs.add(10);
        cs.add("world");

        //迭代  - foreach    集合名.for + 回车键
        System.out.println("--------foreach 迭代----------");
        for (Object c : cs) {
            System.out.println(c);
        }

        //迭代器  - Iterator
        System.out.println("--------Iterator 迭代器----------");
        Iterator<Object> iterator = cs.iterator();
        while(iterator.hasNext()){
            //java.util.NoSuchElementException 在迭代时超过了集合中数据的元素个数，可能会出现此异常
            Object obj = iterator.next();
            System.out.println(obj);
        }

        //迭代器 - Lambda  JDK1.8新增
        System.out.println("--------Lambda 迭代器----------");
        cs.forEach(c->{
            System.out.println(c);
        });
        //简化的写法（了解）
        cs.forEach(c->System.out.println(c));
        cs.forEach(System.out::println);

    }

}
