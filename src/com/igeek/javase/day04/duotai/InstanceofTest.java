package com.igeek.javase.day04.duotai;

/**
 * @version 1.0
 * @Description 自动类型转换和强制类型转换
 * @Author chenmin
 * @Date 2020/10/29 10:42
 */
public class InstanceofTest {

    public static void main(String[] args) {

        /**
         * 向上转型：当有子类对象赋值给一个父类引用时，便是向上转型，多态本身就是向上转型的过程。
         *
         * 语法：
         *      父类的类型  引用名 = new  子类的类型();
         */
        Animal tiger = new Tiger("华南虎",2);
        Animal dog = new Dog("萨摩",3);
        Animal animal = new Animal("动物",10);

        /**
         * 向下转型：一个已经向上转型的子类对象可以使用强制类型转换的格式，将父类引用转为子类引用，这个过程是向下转型。
         * 如果是直接创建父类对象，是无法向下转型的。
         *
         * 语法：
         *      子类类型  新引用名 = (子类类型)引用名；
         *      instanceof运算符  判断左边的对象运行期类型是否是右边   返回值是布尔类型 true代表是  false代表不是
         */
        Tiger t = (Tiger)tiger;
        t.hunt();

        //ClassCastException  类型转换异常
        //Dog d = (Dog)tiger;
        //d.kanjia();

        //解决了多态的劣势：instanceof判断为true后，进行强转，可以调用子类的拓展的新方法
        animal.eat(tiger);

    }

}
