package com.igeek.javase.day10.set;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/12 14:04
 *
 * Set接口
 *  * 1.存储的元素是不可重复的
 *  * 2.丢失原存储顺序（元素都是无序的(即存取顺序不能保证不一致)）
 *
 *  TreeSet 实现类
 *  * 1.使用元素的[自然顺序]实现Comparable接口，对元素进行排序
 *  * 2.保证元素的唯一性 - compareTo()
 *  * 3.底层依赖于TreeMap,是一种基于红黑树的实现
 *  * 4.线程不安全的
 *
 *  TreeSet 添加进来的元素，具有排序性
 *  1).添加进来的元素具备比较性  元素implements实现Comparable接口，重写compareTo()
 *  2).容器自身具备比较性  TreeSet(Comparator<? super E> comparator)，重写compare()
 *  总结：当两者比较方式并存时，根据就近原则，优先第二种“容器自身具备比较性”的比较逻辑
 */
public class TreeSetDemo {

    public static void main(String[] args) {
        System.out.println("---------String  TreeSet------------");
        TreeSet<String> set = new TreeSet<>();
        set.add("afc");
        set.add("abc");
        set.add("adc");
        System.out.println(set);  //[abc, adc, afc]

        System.out.println("---------Employee TreeSet------------");
        //java.lang.ClassCastException: com.igeek.javase.day10.set.Employee cannot be cast to java.lang.Comparable
        //第二种方式：让容器自身具备比较性
        TreeSet<Employee> employees = new TreeSet<>(new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                //int result = new Double(o1.getSalary()).compareTo(o2.getSalary());
                int result = Double.compare(o1.getSalary(),o2.getSalary());
                if(result==0){
                    return o1.getName().compareTo(o2.getName());
                }
                return result*(-1);  //薪资降序排列
            }
        });
        employees.add(new Employee("zhangsan",60000.0));
        employees.add(new Employee("zhangwu",40000.0));
        employees.add(new Employee("zhangsan",55000.0));
        employees.add(new Employee("zhangwa",40000.0));
        System.out.println(employees);
    }

}
