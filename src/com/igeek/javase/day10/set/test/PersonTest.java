package com.igeek.javase.day10.set.test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/12 10:56
 *
 * 练习2：ArrayList中contains方法，要求定义两个集合，一个添加String类型，一个添加Person类型
 *
 * 数据类型...形参名   可变参数
 * 1.等价于数组 例如String...str等价于String[] str  为啥不直接写数组，因为不允许传递空参  addString()
 * 2.方法中形参最多允许传递一个可变参数
 * 3.方法形参中允许出现单个参数和可变参数，但是需要满足此情况int a,String...str，单个参数放在可变参数的前面
 * 4.调用传递可变参数，允许不传递参数  addString()  addString("aaa","abc")
 * 5.数组可做的操作，可变参数皆可以  例如：数组.length  数组迭代
 */
public class PersonTest {

    public static void main(String[] args) {
        System.out.println("----------List<String>-----------");
        //addString("abc","aaa","abc","bbb");
        /*addPerson(
                new Person("abc",12,"男"),
                new Person("aaa",18,"男"),
                new Person("abc",12,"男")
        );*/

        List<String> strList = new ArrayList<>();
        strList.add("abc");
        strList.add("aaa");
        strList.add("abc");
        Set<String> set = new HashSet<>(strList);
        System.out.println(set);

        List<Person> personList = new ArrayList<>();
        personList.add(new Person("abc",12,"男"));
        personList.add(new Person("aaa",18,"男"));
        personList.add(new Person("abc",12,"男"));
        Set<Person> pset = new HashSet<>(personList);
        System.out.println(pset);
    }

    //测试添加String的集合的contains()
    public static void addString(String...str){
        List<String> strList = new ArrayList<>();
        System.out.println(str.length);
        for (String s : str) {
            if(!strList.contains(s)){  //equals()进行比较
                strList.add(s);
            }
        }
        System.out.println(strList);
    }

    //测试添加Person的集合的contains()
    public static void addPerson(Person...person){
        List<Person> personList = new ArrayList<>();
        for (Person p : person) {
            if(!personList.contains(p)){  //equals()进行比较
                personList.add(p);
            }
        }
        System.out.println(personList);
    }

}
