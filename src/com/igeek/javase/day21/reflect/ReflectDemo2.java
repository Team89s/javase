package com.igeek.javase.day21.reflect;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description 反射
 * @Author chenmin
 * @Date 2020/12/15 15:15
 *
 * Class中的常用方法：
 * 1.String getSimpleName(); 获得类名字符串：类名
 * 2.String getName();  获得类全名：包名+类名
 * 3.T newInstance() ;  创建Class对象关联类的对象
 * 4.Package getPackage()  获取此类的包。
 * 5.Class<? super T> getSuperclass() 返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的超类的 Class。
 * 6.Class<?> getDeclaringClass()  如果此 Class 对象所表示的类或接口是另一个类的成员，则返回的 Class 对象表示该对象的声明类。
 */
public class ReflectDemo2 {

    public static void test(Object obj) throws IllegalAccessException, InstantiationException {
        //1.获得类类型或者字节码文件对象Class
        Class clazz = obj.getClass();

        //2.获得类名字符串  类名User
        System.out.println("对象的类名："+clazz.getSimpleName());

        //3.获得类全名：包名+类名  com.igeek.javase.day21.reflect.User
        System.out.println("对象的全类名："+clazz.getName());

        //4.创建Class对象关联类的对象
        Object o = clazz.newInstance();
        System.out.println(o);  //com.igeek.javase.day21.reflect.User@7f31245a

        //5.获取此类的包。
        System.out.println("包名："+clazz.getPackage());  //package com.igeek.javase.day21.reflect

        //6.返回表示此 Class 所表示的实体（类、接口、基本类型或 void）的超类的 Class。
        Class superclass = clazz.getSuperclass();
        System.out.println("类的父类："+superclass);  //class com.igeek.javase.day21.reflect.Person

        //7.获得内部类
        Class[] declaredClasses = clazz.getDeclaredClasses();
        //class com.igeek.javase.day21.reflect.User$InnerClass
        System.out.println("类的内部类："+Arrays.deepToString(declaredClasses));
    }


    public static void main(String[] args) {
        try {
            test(new User());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
