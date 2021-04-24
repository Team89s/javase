package com.igeek.javase.day14.method;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @version 1.0
 * @Description  特定类型方法的引用
 * @Author chenmin
 * @Date 2020/11/20 17:22
 *
 *  特定类型方法的引用
 *          引用格式：
 * ​				特定类型::方法
 * ​		特定类型：
 * ​				String，任何类型
 * ​		注意事项：
 * ​				如果函数式接口中的抽象方法的参数列表中，
 *          第一个参数作为了后面的方法的调用者，并且其余参数作为后面方法的形参，
 *          那么就可以用特定类型方法引用了。
 */
public class SpecialMethod3 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("AAA");
        list.add("DDD");
        list.add("bbb");

        //匿名内部类
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });

        //Lambda简化
        Collections.sort(list,(o1,o2)->o1.compareToIgnoreCase(o2));

        //特定类型方法的引用  特定类型::方法
        Collections.sort(list,String::compareToIgnoreCase);
        System.out.println(list);
    }

}
