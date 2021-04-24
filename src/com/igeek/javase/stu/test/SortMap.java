package com.igeek.javase.stu.test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @version 1.0
 * @Description 对Map集合进行排序
 * @Author sunerlin 孙二林
 * @Date 2020/12/1 14:08
 */
public class SortMap {
    public static void main(String[] args) {
        HashMap<Integer,Person> map = new HashMap<>();
        map.put(1,new Person("张三",12));
        map.put(2,new Person("李四",14));
        map.put(3,new Person("王五",13));
        map.put(4,new Person("赵六",11));
        System.out.println("-----------------sort1-----------------");
        sort1(map).forEach((k,v)-> System.out.println(k+"="+v));
        System.out.println("-----------------sort2-----------------");
        sort2(map).forEach((k,v)-> System.out.println(k+"="+v));

    }

    /**
    * @methodName sort1
    * @Description 按照值对象的属性对map集合进行排序
    * @param map: 需要进行排序的Map集合
    * @date 2020/12/1
    * @return java.util.HashMap<java.lang.Integer, com.igeekHome.javase.Week07.Day02.Person>
    */
    private static HashMap<Integer, Person> sort1(HashMap<Integer, Person> map) {
        //获得值的流对象并进行排序，最终得到一个排好序的值集合collect
        List<Person> collect = map.values().stream().sorted(Comparator.comparingInt(Person::getAge)).collect(Collectors.toList());
        LinkedHashMap<Integer,Person> mapNew = new LinkedHashMap<>();
        //遍历collect，寻找每个值对应的键，并加入一个新的Map集合中
        for (Person person : collect) {
            Integer i = 0;
            //在map中查找与person相对应的键
            for (Map.Entry<Integer, Person> entry : map.entrySet()) {
                Integer k = entry.getKey();
                Person v = entry.getValue();
                if (person == v) {
                    i = k;
                    break;
                }
            }
            mapNew.put(i,person);
        }
        return mapNew;
    }

    /**
     * @methodName sort2
     * @Description 按照值对象的属性对map集合进行排序
     * @param map: 需要进行排序的Map集合
     * @date 2020/12/1
     * @return java.util.HashMap<java.lang.Integer, com.igeekHome.javase.Week07.Day02.Person>
     */
    private static HashMap<Integer, Person> sort2(HashMap<Integer, Person> map) {
        //获得一个map集合的流对象，按照值对象的年龄进行排序，收集排好序的项用List集合进行存储
        //static <K,V> Comparator<Map.Entry<K,V>> comparingByValue(Comparator<? super V> cmp) 返回一个比较器，比较 Map.Entry利用给出的 Comparator价值。
        List<Map.Entry<Integer, Person>> collect = map.entrySet().stream().sorted(Map.Entry.comparingByValue(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        })).collect(Collectors.toList());
        //新建一个Map集合，遍历collect中的项，将项的键和值添加至mapNew中
        LinkedHashMap<Integer,Person> mapNew = new LinkedHashMap<>();
        for (Map.Entry<Integer, Person> integerPersonEntry : collect) {
            mapNew.put(integerPersonEntry.getKey(),integerPersonEntry.getValue());
        }
        return mapNew;
    }
}

class Person{
    private String name;
    private Integer age;

    public Person() {
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "Person{name = " + name + ", age = " + age + "}";
    }
}
