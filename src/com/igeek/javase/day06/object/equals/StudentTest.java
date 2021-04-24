package com.igeek.javase.day06.object.equals;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/4 9:18
 *
 * 需求：当Student对象中的属性内容一致时，则认定两个对象时同一个元素
 */
public class StudentTest {

    public static void main(String[] args) {
        Student stu1 = new Student("张三",10);
        Student stu2 = new Student("张三",10);

        /**
         * Object中的equals()默认比较的是地址
         *
         * 重写equals()，让其比较对象中的元素内容
         */
        System.out.println(stu1.equals(stu2)); //false  重写后为true
        //== 对于引用数据类型，比较的是地址
        System.out.println(stu1==stu2);  //false
    }

}
