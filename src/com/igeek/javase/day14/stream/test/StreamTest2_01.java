package com.igeek.javase.day14.stream.test;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/23 15:11
 *
 * //1.练习Stream中的常用方法of()、iterate()、generate()、
 * findFirst()、findAny()、anyMatch()、distinct()等
 */
public class StreamTest2_01 {

    public static void main(String[] args) {

        //static <T> Stream<T> generate(Supplier<T> s)  返回一个无穷序列无序流，其中每个元素是由提供 Supplier生成。  
        Stream.generate(Math::random).limit(1).forEach(System.out::println);

        //static <T> Stream<T> iterate(T seed, UnaryOperator<T> f)  返回一个无穷序列有序 Stream由最初的一元 seed函数的 f迭代应用产生的，产生一个由 seed， f(seed)， f(f(seed)) Stream，等。  
        Stream.iterate(10,s->s+10).limit(3).forEach(System.out::println);

        //Optional<T> findFirst()  返回一个 Optional描述此流的第一个元素，或者一个空的 Optional如果流是空的。
        Stream<String> stream1 = Stream.of("张小强", "王小明", "张三三","张三", "李四");
        //java.util.NoSuchElementException: No value present
        Optional<String> first = stream1.filter(s -> s.length() == 3).filter(s->s.startsWith("李")).findFirst();
        System.out.println("findFirst()-->"+first.orElse("查无元素"));
        System.out.println("findFirst()-->"+first.orElseGet(String::new));

        //Optional<T> findAny() 返回一个 Optional描述一些流元素，或一个空的 Optional如果流是空的。更适用于并行流
        Stream<String> stream2 = Stream.of("张小强", "王小明", "张三三","张三", "李四");
        //除了直接通过集合创建并行流对象，也可以将Stream流转成并行流
        Stream<String> parallelStream = stream2.parallel();
        Optional<String> any = stream2.filter(s -> s.length() == 3).findAny();
        System.out.println("findAny()-->"+any.orElse("无"));

        //boolean anyMatch(Predicate<? super T> predicate) 返回此流中的任何元素是否匹配所提供的谓词。
        Stream<String> stream3 = Stream.of("张小强", "王小明", "张三三","张三", "李四");
        boolean flag = stream3.anyMatch(s -> s.startsWith("陈"));
        System.out.println("flag = "+flag);

        //Stream<T> distinct()  返回一个包含不同的元素流（根据 Object.equals(Object)）这个流。
        Stream<String> s1 = Stream.of("a", "b", "b", "c", "d");
        Stream<String> s2 = Stream.of("e", "a", "b", "c", "f");
        //concat 合并流  distinct去除重复的元素
        Stream.concat(s1,s2).distinct().forEach(System.out::println);
    }

}
