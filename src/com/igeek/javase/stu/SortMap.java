package com.igeek.javase.stu;

import java.util.*;

/**
 * @version 1.0
 * @Description 1.写一个方法对hashmap中的值,按照年龄进行排序,要求返回的是一个HashMap,
 * 且原键值对不发生改变
 * @Author 冯世航
 * @Date 2020/12/1 13:37
 */
public class SortMap {

    public static void main(String[] args) {
        HashMap<Integer,User> map = new HashMap<>();
        map.put(1,new User("张三",14));
        map.put(2,new User("张三",12));
        map.put(3,new User("张三",13));
        System.out.println(map);
        HashMap<Integer,User> map1 = sortM(map);
        System.out.println(map1);
    }
    private static HashMap<Integer, User> sortM(HashMap<Integer, User> map) {
        //1.取出键值对
        Set<Map.Entry<Integer, User>> entries = map.entrySet();
        //包装成一个list集合
        ArrayList<Map.Entry<Integer, User>> entries1 = new ArrayList<>(entries);
        //调用工具类进行排序
        Collections.sort(entries1, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o1.getValue().getAge().compareTo(o2.getValue().getAge());
            }
        });
        LinkedHashMap<Integer,User> lMap = new LinkedHashMap<>();
        for (Map.Entry<Integer, User> e : entries1) {
            lMap.put(e.getKey(),e.getValue());
        }
        return lMap;
    }
}
class User{
    private String name;
    private Integer age;


    public User() {
    }

    public User(String name, Integer age) {
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
        return "User{name = " + name + ", age = " + age + "}";
    }
}
