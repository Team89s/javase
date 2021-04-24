package com.igeek.javase.day21.reflect.field;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * @version 1.0
 * @Description Field类
 * @Author chenmin
 * @Date 2020/12/16 9:26
 *
 * Field对象常用方法
 *      void set(Object obj, Object value)
 *      Object get(Object obj)
 */
public class FieldDemo2 {

    @Test
    public void test() throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> clazz = Person.class;
        //获取构造器对象
        Constructor<Person> c = clazz.getDeclaredConstructor();
        //创建实例
        Person person = c.newInstance();
        //获取指定的属性的对象
        Field nameField = clazz.getDeclaredField("name");
        Field ageField = clazz.getDeclaredField("age");
        //暴力破解（属性原有的封装性）
        nameField.setAccessible(true);
        ageField.setAccessible(true);
        //设置值
        nameField.set(person,"巴斯光年");
        ageField.setInt(person,100);
        //获取值
        Object name = nameField.get(person);
        Object age = ageField.getInt(person);
        System.out.println("name = "+name);
        System.out.println("age = "+age);
        //输出person信息
        System.out.println("person = "+person);
    }

}
