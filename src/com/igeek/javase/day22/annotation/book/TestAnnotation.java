package com.igeek.javase.day22.annotation.book;

import org.junit.Test;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/16 15:36
 *
 * 注解解析：使用Java技术获得注解上数据的过程则称为注解解析。
 */
public class TestAnnotation {

    //测试加在类上的注解解析
    @Test
    public void purchaseClass(){
        Class<BookStore> clazz = BookStore.class;
        MyBook myBook = clazz.getDeclaredAnnotation(MyBook.class);
        System.out.println("书名："+myBook.value());
        System.out.println("价格："+myBook.price());
        System.out.println("作者："+ Arrays.toString(myBook.authors()));
    }

    //测试加在方法上的注解解析
    @Test
    public void purchaseMethod() throws NoSuchMethodException {
        Class<BookStore> clazz = BookStore.class;
        Method purchaseMethod = clazz.getDeclaredMethod("purchase");
        //isAnnotationPresent  判断当前方法上，是否有MyBook注解，返回true则代表有此注解
        if(purchaseMethod.isAnnotationPresent(MyBook.class)){
            MyBook myBook = purchaseMethod.getDeclaredAnnotation(MyBook.class);
            System.out.println("书名："+myBook.value());
            System.out.println("价格："+myBook.price());
            System.out.println("作者："+ Arrays.toString(myBook.authors()));
        }
    }

}
