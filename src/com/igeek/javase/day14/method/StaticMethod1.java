package com.igeek.javase.day14.method;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @version 1.0
 * @Description 静态方法的引用
 * @Author chenmin
 * @Date 2020/11/20 17:06
 *
 * 静态方法的引用
 *
 *          引用格式：
 *
 * ​				类名::静态方法
 *
 * ​		简化步骤：
 *
 * ​				定义一个静态方法，把需要简化的代码放到一个静态方法中。
 *
 * ​		注意事项：
 *
 * ​				被引用的方法的参数列表，要和函数式接口中的抽象方法的参数列表一致。
 *
 * ​				如果函数式接口中的抽象方法有返回值，则被引用的方法必须也有相同的返回值。
 *
 * ​				如果函数式接口中的抽象方法没有返回值，则被引用的方法可以有返回值，也可以没有返回值。
 */
public class StaticMethod1 {

    public static void main(String[] args) {

        Person[] ps = {
                new Person("张三",10),
                new Person("李四",9),
                new Person("王五",12),
        };
        //匿名函数
        Arrays.sort(ps, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });

        //Lambda简化版本
        Arrays.sort(ps,(o1,o2) -> o1.getAge()-o2.getAge());
        System.out.println(Arrays.toString(ps));

        //静态方法引用的简化版本  类名::静态方法
        //Arrays.sort(ps,(o1,o2) -> Person.compareAge(o1,o2));
        Arrays.sort(ps,Person::compareAge);
        System.out.println(Arrays.toString(ps));
    }

}
