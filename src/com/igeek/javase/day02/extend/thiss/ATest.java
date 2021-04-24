package com.igeek.javase.day02.extend.thiss;

/**
 * @version 1.0
 * @Description this的使用
 * @Author chenmin
 * @Date 2020/10/28 15:13
 */
public class ATest {
    public static void main(String[] args) {
        C c = new C();
        c.show();
    }
}

class A{
    public A(){
        super();
        this.show();
        System.out.println(this);  //this 当前对象
    }

    public void show(){
        System.out.println("A");
    }
}

class B extends A{
    public B(){
        super();
        this.show();
    }

    @Override
    public void show(){
        System.out.println("B");
    }
}

class C extends B{
    public C(){
        super();
        this.show();
    }

    @Override
    public void show(){
        System.out.println("C");
    }
}
