package com.igeek.javase.day02.extend.employeetest;
/**
 * @version 1.0
 * @Description 测试类
 * @Author chenmin
 * @Date 2020/10/28 15:36
 *
 * 共有1个经理,2个服务员,1个厨师
 * 让所有的员工工作
 * 并求所有人的总收入是多少?
 */
public class Test {

    public static void main(String[] args) {

        Employee employee = new Employee("小宝",15.0);
        //com.igeek.javase.day02.employeetest.Employee@1b6d3586
        System.out.println(employee);

        Manager manager = new Manager("小强",40.0,5.0);
        Waiter waiter1 = new Waiter("小明",0.5);
        Waiter waiter2 = new Waiter("小红",0.6);
        Cooker cooker = new Cooker("小斌",20.0);

        System.out.println(manager);

        //工资
        manager.work();
        waiter1.work();
        waiter2.work();
        cooker.work();

        //计算总收入
        double sum = manager.getSalary()+manager.getBonus()+waiter1.getSalary()+waiter2.getSalary()+cooker.getSalary();
        System.out.println("总收入 = "+sum);

    }

}
