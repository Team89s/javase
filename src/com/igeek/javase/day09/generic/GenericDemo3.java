package com.igeek.javase.day09.generic;

/**
 * @version 1.0
 * @Description 泛型接口
 * @Author chenmin
 * @Date 2020/11/9 16:15
 *
 * 泛型接口：
 * 1.语法：public interface  接口名<泛型的类型>{}
 * 2.使用：public class GenericDemo3 implements  接口名<真实的具体的数据类型>{}
 *
 * 需求：定义一个接口，提供CRUD的方法，具有良好的拓展性
 */
interface GenericInterface<T> {
    //增
    public void insert(T t);

    //删
    public void delete(Integer id);

    //改
    public void update(T t);

    //查
    public T select(Integer id);
}

public class GenericDemo3 implements GenericInterface<Tiger>{
    @Override
    public void insert(Tiger tiger) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Tiger tiger) {

    }

    @Override
    public Tiger select(Integer id) {
        return null;
    }


    public static void main(String[] args) {
        GenericDemo3 gen = new GenericDemo3();
        gen.insert(new Tiger());
//        gen.insert(new Dog());
//        gen.insert(new Cat());
    }
}

class Tiger{
    public void eat(){
        System.out.println("老虎正在吃饭...");
    }
}
class Dog{
    public void eat(){
        System.out.println("小狗正在吃饭...");
    }
}
class Cat{
    public void eat(){
        System.out.println("小猫正在吃饭...");
    }
}