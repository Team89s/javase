package com.igeek.javase.day02.order;

/**
 * @version 1.0
 * @Description 测试订单
 * @Author chenmin
 * @Date 2020/10/30 9:26
 */
public class Test {

    public static void main(String[] args) {

        Goods good1 = new Goods("辣条",2.5,"美味",10);
        Goods good2 = new Goods("薯条",13.5,"孜然",20);
        Goods good3 = new Goods("炸鸡",10.0,"梅子味",50);

        User user = new User("张三","无锡新吴区","123");

        //已经将订单与下单者绑定一起了
        Orders order1 = new Orders(1L,user,new Goods[]{good3});
        Orders order2 = new Orders(2L,user,new Goods[]{good1,good2});
        Orders[] orders = {order1,order2};

        //将下单者与订单绑定一起
        user.setOrders(orders);

        //执行用户下单
        user.xiadan();
    }

}
