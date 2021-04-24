package com.igeek.javase.day09.generic;

/**
 * @version 1.0
 * @Description 泛型类
 * @Author chenmin
 * @Date 2020/11/9 16:15
 *
 * 泛型类：
 * 1.当声明类时，类名 <数据类型> ，在整个类中都可以使用这个数据类型
 * public class 类名<数据类型1,数据类型2,数据类型3>{ //类体 }
 *
 * 2.<数据类型>  通常使用大写字母，一般使用E T K V
 * 3.数据类型，预支地使用未知的类型，在真正使用时必须传递进来真实的类型
 * 4.数据类型  只能是引用数据类型
 * 5.泛型不可以使用在静态的成员下
 * 6.一般用于基类使用，该类将具备良好的拓展性
 * 7.类中声明时，泛型可以使用多个<E,T,K>
 * 8.GenericDemo2<String,Integer,Character> gen = new GenericDemo2<>();
 * 等号右边直接写<>  简化写法
 *
 * 9.泛型的作用域：在当前整个类中都是使用
 */
public class GenericDemo2<E,T,K> {

    //属性的数据类型使用
    private E name;
    private T age;
    private K gender;

    public GenericDemo2() {
    }

    //方法的形参类型使用
    public GenericDemo2(E name, T age, K gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    //方法的返回值类型使用
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

    public K getGender() {
        return gender;
    }

    public void setGender(K gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "GenericDemo2{" +
                "name=" + name +
                ", age=" + age +
                ", gender=" + gender +
                '}';
    }

    public static void main(String[] args) {
        GenericDemo2<String,Integer,Character> gen = new GenericDemo2<>();
        gen.setName("张三");
        gen.setAge(10);
        gen.setGender('男');
        System.out.println(gen);
    }
}
