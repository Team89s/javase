package com.igeek.javase.day10.conllections;

import java.util.*;

/**
 * @version 1.0
 * @Description Collections类
 * @Author chenmin
 * @Date 2020/11/12 15:08
 *
 * Collections 集合的工具类
 * 常用方法：
 * 1.static <T> boolean addAll(Collection<? super T> c, T... elements) 将所有指定的元素添加到指定的集合中。
 * 2.public static void shuffle(List<?> list) :打乱集合顺序。
 * 3.static <T extends Comparable<? super T>> void sort(List<T> list)  :将集合中元素按照默认规则排序。 添加的元素具备比较性
 * 4.public static <T> void sort(List<T> list，Comparator<? super T> ):将集合中元素按照指定规则排序。  容器具备比较性
 */
public class CollectionsDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();

        System.out.println("---------addAll---------");
        //1.static <T> boolean addAll(Collection<? super T> c, T... elements) 将所有指定的元素添加到指定的集合中。
        //可变参数，传递参数时，可以不进行传参   Collections.addAll(list);
        Collections.addAll(list,"abd","abc","aaa","aca");
        System.out.println(list);

        System.out.println("---------shuffle---------");
        //2.public static void shuffle(List<?> list) :打乱集合顺序。
        Collections.shuffle(list);
        System.out.println(list);


        List<Person> plist = new ArrayList<>();
        Collections.addAll(plist,
                new Person("zhangsan",32),
                new Person("zhanghan",12),
                new Person("zhangjin",45),
                new Person("zhangain",45)
        );
        System.out.println("---------sort(List<T> list)---------");
        //3.static <T extends Comparable<? super T>> void sort(List<T> list)  :将集合中元素按照默认规则排序。 添加的元素具备比较性
        Collections.sort(plist);
        System.out.println(plist);

        System.out.println("---------sort(List<T> list)---------");
        //4.public static <T> void sort(List<T> list，Comparator<? super T> ):将集合中元素按照指定规则排序。  容器具备比较性

        //排序
        Collections.sort(plist, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getAge()==o2.getAge()){
                    return o1.getName().compareTo(o2.getName());
                }
                return o1.getAge()-o2.getAge();
            }
        });
        System.out.println(plist);

        //数组排序方法：Arrays工具类  1.public static void sort(Object[] a)  数组中的所有元素必须实现 Comparable接口
        System.out.println("-----------sort(Object[] a)----------");
        Person[] persons = {
                new Person("zhangsan",21),
                new Person("李四",56),
                new Person("zhanger",21),
                new Person("王五",32)
        };
        Arrays.sort(persons);
        System.out.println(Arrays.toString(persons));


        //数组排序方法：Arrays工具类  2.public static <T> void sort(T[] a, Comparator<? super T> c)
        System.out.println("-----------sort(T[] a, Comparator<? super T> c)----------");
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getAge()==o2.getAge()){
                    return o2.getName().compareTo(o1.getName());
                }
                return o2.getAge()-o1.getAge();
            }
        });
        System.out.println(Arrays.toString(persons));


    }

}
