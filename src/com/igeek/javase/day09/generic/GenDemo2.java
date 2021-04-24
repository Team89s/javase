package com.igeek.javase.day09.generic;

/**
 * @version 1.0
 * @Description 泛型接口
 * @Author chenmin
 * @Date 2020/11/10 9:18
 *
 * 此时接口的拓展性更好
 */
public interface GenDemo2<T> {
    //增
    void insert(T t);

    //删
    void delete(Integer id);

    //改
    void update(T t);

    //查
    T select(Integer id);
}
class Person implements GenDemo2<Person>{

    @Override
    public void insert(Person person) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Person person) {

    }

    @Override
    public Person select(Integer id) {
        return null;
    }
}
class Animal implements GenDemo2<Animal>{

    @Override
    public void insert(Animal animal) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public void update(Animal animal) {

    }

    @Override
    public Animal select(Integer id) {
        return null;
    }
}