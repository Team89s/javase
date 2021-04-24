package com.igeek.javase.day09.generic;

/**
 * @version 1.0
 * @Description 泛型
 * @Author chenmin
 * @Date 2020/11/10 9:08
 *
 * 泛型使用场景：
 * 1.泛型类   public class 类名<E>{}
 * 2.泛型方法 public <T> 返回值类型 方法名(形参列表){}
 * 3.泛型接口 public interface 接口名<E>{}
 *
 * 使用特点：
 * 1.泛型常用大写字母：E T K V
 * 2.声明时，用大写字母当做类型使用，但是真正使用的时候必须给定真实的数据类型
 * 3.静态成员中，不可以使用泛型
 * 4.使用时传递数据类型，只能是引用数据类型
 * 5.一般多用于基类使用的情况，需要通过基类做拓展效果
 */
public class GenDemo1<E,T,K> {

    private E name;
    private T age;
    private K sex;

    public GenDemo1() {
    }

    public GenDemo1(E name, T age, K sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public E getName() {
        return name;
    }

    public void setName(E name) {
        this.name = name;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    public K getSex() {
        return sex;
    }

    public void setSex(K sex) {
        this.sex = sex;
    }

    public void work(){
        System.out.println(name+"正在工作...");
    }

    @Override
    public String toString() {
        return "GenDemo1{" +
                "name=" + name +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }

    //主方法
    public static void main(String[] args) {
        GenDemo1<String,Integer,Character> gen = new GenDemo1("张三",22,'男');
        System.out.println(gen);
        gen.work();
    }
}
