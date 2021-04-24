package com.igeek.javase.day21.reflect.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 枚举：一一列举   多例模式
 */
public enum MyEnum {

    INSTANCE;  //单个实例

    public static MyEnum getInstance(){
        return INSTANCE;
    }

}

class MyEnumTest{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        MyEnum instance1 = MyEnum.getInstance();
        MyEnum instance3 = MyEnum.getInstance();
        System.out.println(instance1);
        System.out.println(instance3);
        System.out.println(instance1 == instance3);  //true

        /**
         * 验证反射不能创建枚举的实例
         * Cannot reflectively create enum objects
         */
        //希望通过反射破坏单例，但是应该抛出异常IllegalArgumentException("Cannot reflectively create enum objects")
        Class clazz = MyEnum.class;
        //通过javap -p MyEnum.class反编译，出现有私有的无参构造方法，但是并不正确
        //Constructor c = clazz.getDeclaredConstructor();

        //通过IDEA自带的Show Bytecode查看，发现私有的带参数的构造方法
        Constructor c = clazz.getDeclaredConstructor(String.class,int.class);
        c.setAccessible(true);
        MyEnum instance2 = (MyEnum)c.newInstance();
        System.out.println(instance2);
        System.out.println(instance1 == instance2);
    }
}
