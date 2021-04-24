package com.igeek.javase.day21.reflect;

/**
 * @version 1.0
 * @Description 反射
 * @Author chenmin
 * @Date 2020/12/15 15:15
 *
 * 反射：
 *      反射是一种机制，是指对于任何一个类，在"运行的时候"都可以直接得到这个类全部成分。
 *      使用前提：要获得该类字节码文件对象，就是Class对象
 *      使用场景：开发IDE(集成开发环境)，比如IDEA,Eclipse；各种框架的设计和学习 比如Spring，Hibernate，SpringMVC，Mybatis...
 *
 * 总结：
 * 1.反射是工作在运行时的技术，因为只有运行之后才会有class类对象。
 * 2.反射的核心思想和关键就是得到，编译以后的class对象。
 * 3.反射是在运行时获取类的字节码文件对象，然后可以解析类中的全部成分。
 *
 * Class对象的获取方式：
 * 方式1: 通过类名.class获得
 * 方式2：通过对象名.getClass()方法获得
 * 方式3：通过Class类的静态方法获得： static Class forName("类全名")
 *       每一个类的Class对象都只有一个。
 */
public class ReflectDemo1 {

    public static void main(String[] args) throws ClassNotFoundException {
        //方式一：通过类名.class获得Class字节码对象
        Class<User> clazz1 = User.class;
        System.out.println(clazz1);   //class com.igeek.javase.day21.reflect.User

        //方式二：通过对象.getClass()获得Class字节码对象
        User user = new User();
        Class<? extends User> clazz2 = user.getClass();
        System.out.println(clazz2);   //class com.igeek.javase.day21.reflect.User
        System.out.println(clazz1 == clazz2);  //true

        //方式三：通过Class.forName("全类名")获得Class字节码对象  全类名：包名.类名
        Class<?> clazz3 = Class.forName("com.igeek.javase.day21.reflect.User");
        //class com.igeek.javase.day21.reflect.User
        System.out.println(clazz3);
        //true
        System.out.println(clazz2 == clazz3);
    }

}
