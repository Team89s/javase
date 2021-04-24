package com.igeek.javase.day02.extend.extendss;

/**
 * @version 1.0
 * @Description 老虎 - 子类
 * @Author chenmin
 * @Date 2020/10/28 11:21
 *
 *
 * 方法重载  Overload
 * 1.发生在同一个类中
 * 2.方法名相同的
 * 3.参数列表是不同的
 * 4.与返回值无关
 *
 * 方法重写  @Override
 * 1.发生在继承关系中  子类重写父类的方法
 * 2.方法名相同
 * 3.参数列表是相同的
 * 4.返回值类型  若是基本数据类型则一致；若是引用数据类型不可以放大  Object > Animal > Tiger
 * 5.访问权限修饰符不可以缩小  public > protected > default > private
 * 6.抛出异常，子类抛出异常比父类要小  Exception异常的根类
 */
public class Tiger extends Animal{

    public Tiger() {
    }

    public Tiger(String name, int age) {
        super(name, age);
    }

    public void hunt(){
        System.out.println(this.getName()+"正在捕猎...");
    }

    @Override
    public Tiger eat(Animal animal) /*throws Exception*/ {
        System.out.println(this.getName()+"正在吃肉...");
        return this;
    }
}
