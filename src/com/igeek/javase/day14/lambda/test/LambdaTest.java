package com.igeek.javase.day14.lambda.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @version 1.0
 * @Description 练习：简化 Arrays.sort(Person[],new Comparator<Person>());
 * @Author chenmin
 * @Date 2020/11/20 10:50
 */
public class LambdaTest {

    public static void main(String[] args) {

        Person[] persons = {
                new Person("abc",26),
                new Person("abb",35),
                new Person("aba",56),
                new Person("aba",26)
        };

        //匿名内部类
        Arrays.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if(o1.getAge()==o2.getAge()){
                    return o1.getName().compareTo(o2.getName());
                }
                return o1.getAge()-o2.getAge();
            }
        });

        //Lambda表达式简化
        Arrays.sort(persons, (Person o1, Person o2) -> {
            if(o1.getAge()==o2.getAge()){
                return o1.getName().compareTo(o2.getName());
            }
            return o1.getAge()-o2.getAge();
        });

    }

}
