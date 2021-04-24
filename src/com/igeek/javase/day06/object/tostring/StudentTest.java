package com.igeek.javase.day06.object.tostring;

/**
 * @version 1.0
 * @Description Object常用方法 - toString()
 * @Author chenmin
 * @Date 2020/11/4 9:40
 */
public class StudentTest {

    public static void main(String[] args) {

        Student stu = new Student("李四",12);
        /**
         * 重写toString之前：getClass().getName() + "@" + Integer.toHexString(hashCode())
         * 等价于 全类名@16进制的hashcode值  其中全类名：包名.类名
         * com.igeek.javase.day06.tostring.Student@1b6d3586
         *
         * 重写toString之后：对象具体内容
         * Student{name='李四', age=12}
         */
        System.out.println(stu);
        System.out.println(stu.toString());
    }

}
