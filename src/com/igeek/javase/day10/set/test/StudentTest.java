package com.igeek.javase.day10.set.test;

import java.util.HashSet;
import java.util.Set;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/12 10:35
 *
 * 练习1：学生管理系统，同名同学号即为同一个学生，不进行录入库（容器）中。
 *
 * 若hashcode相同，equals未必相同；
 * 若equals相同，则hashcode必相同。
 */
public class StudentTest {

    public static void main(String[] args) {
        Set<Student> set = new HashSet<>();

        Student s1 = new Student("李四","111");
        Student s2 = new Student("王五","222");
        Student s3 = new Student("李四","111");
        Student s4 = new Student("赵柳","333");

        //当重写Student的hashCode()和equals()之后，此时会根据对象的属性值，来判定是否是同一元素
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);

        for (Student student : set) {
            System.out.println(student);
        }
    }

}
