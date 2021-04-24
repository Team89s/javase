package com.igeek.javase.day14.method;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @version 1.0
 * @Description 构造器引用
 * @Author chenmin
 * @Date 2020/11/20 17:27
 *
 * 构造器引用
 *          引用格式：
 * ​				类名::new
 * ​		注意事项：
 * ​				函数式接口的抽象方法的形参列表和构造器的形参列表一致，抽象方法的返回值类型即为构造器所属的的类型。
 * ​				类似于  s -> new Student(s)   => Student::new
 */
public class ConstructorMethod4 {

    public static void main(String[] args) {
        //无参  供给型，直接提供一个Student对象
        Supplier<Student> s = Student::new;
        System.out.println(s.get());  //Student{name = null}

        //有参 转换型，将String -> Student
        Function<String,Student> f = Student::new;
        System.out.println(f.apply("张三"));  //Student{name = 张三}

        //数组
        Function<Integer,String[]> fun = String[]::new;
        System.out.println(Arrays.toString(fun.apply(3)));  //[null, null, null]
    }

}
