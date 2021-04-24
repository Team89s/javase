package com.igeek.javase.day04.duotai;

/**
 * @version 1.0
 * @Description 测试类
 * @Author chenmin
 * @Date 2020/10/29 10:15
 */
public class Test {

    public static void main(String[] args) {

        Animal a = new Animal("动物",10);
        Tiger t = new Tiger("华南虎",3);
        Dog d = new Dog("田园犬",15);

        /*a.eat();
        tiger.eat();
        dog.eat();

        // a.hunt();  父类对象不能调用子类拓展的方法
        tiger.hunt();
        dog.kanjia();*/


        /**
         * 多态的概念：
         *      同一个类型的对象，执行同一个行为，在不同状态下会表现出不同的行为特征。
         *
         * 多态语法：父类的类型  引用名 = new 子类类型();
         * 父类的引用指向子类的实例
         *
         * 多态使用的大前提：
         * 1.发生了继承或者实现关系
         * 2.父类的引用指向子类的实例
         * 3.发生了方法重写
         *
         * 多态的原则：
         * 1.调用成员方法时，先去等号左边找存不存在，若存在则执行等号右边的逻辑。
         * （编译看左边，运行看右边） --> 子类对父类的方法存在方法重写
         * 2.调用成员变量时，编译看左边，运行看左边  -->不存在重写变量
         * 3.调用静态方法时，编译看左边，运行看左边  -->不存在重写静态方法
         *
         * 多态的优势：
         * 1.代码的拓展性好，右边对象可以实现组件化切换，业务功能随之改变
         * 2.实现类与类之间的解耦
         * 3.使用多态参数（要求传递父类类型，但是实际也可以传递子类类型）
         *
         * 多态的劣势：不能使用子类拓展的方法
         * 解决方案：强转  Animal > Tiger  instanceof运算符
         */
        Animal tiger = new Tiger("华南虎",2);
        Animal dog = new Dog("萨摩",3);

        /**
         * 多态参数：方法中的形参要求是父类类型，但是实际传递进来的也可以是子类类型
         */
        //使用成员方法：编译看左边，运行看右边
        tiger.eat(t);
        dog.eat(d);

        //使用成员变量：编译看左边，运行看左边
        System.out.println(tiger.num); //10
        System.out.println(dog.num);  //10

        //使用静态方法：编译看左边，运行看左边
        tiger.sleep();  //动物正在睡觉
        dog.sleep();    //动物正在睡觉

        //tiger.hunt();
    }

}
