package com.igeek.javase.day21.reflect.field;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @version 1.0
 * @Description Field类
 * @Author chenmin
 * @Date 2020/12/16 9:17
 *
 * Field类概述
 *     每一个成员变量都是一个Field类的对象。
 *
 * Class类中与Field相关的方法
 * * Field getField(String name);
 *     *  根据成员变量名获得对应Field对象，只能获得public修饰
 * * Field getDeclaredField(String name);
 *     *  根据成员变量名获得对应Field对象，包含private修饰的
 * * Field[] getFields();
 *     * 获得所有的成员变量对应的Field对象，只能获得public的
 * * Field[] getDeclaredFields();
 *     * 获得所有的成员变量对应的Field对象，包含private的
 *
 * 反射之操作成员变量的目的
 *     通过Field对象给对应的成员变量赋值和取值
 */
public class FieldDemo1 {

    //Field getDeclaredField(String name);
    //根据成员变量名获得对应Field对象，包含private修饰的
    @Test
    public void test1() throws NoSuchFieldException {
        //获取Person的类类型
        Class<Person> clazz = Person.class;
        //获取指定属性的对象
        Field nameField = clazz.getDeclaredField("name");
        System.out.println(nameField.getName()+" === "+nameField.getType());
    }

    //Field[] getDeclaredFields();
    //获得所有的成员变量对应的Field对象，包含private的
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName()+" === "+field.getType());
        }
    }
}
