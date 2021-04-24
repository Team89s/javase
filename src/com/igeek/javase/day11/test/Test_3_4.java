package com.igeek.javase.day11.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @version 1.0
 * @Description 关卡三-第四题
 * @Author chenmin
 * @Date 2020/12/7 15:48
 *
 * 有四种水果(苹果，香蕉，西瓜，橘子)
 * 	 1、给每种水果设定一个商品号，商品号是8个0-9的随机数，商品号码不能重复, 最小值 "00000001", 最大值 "99999999"
 * 	 2、根据商品号查询对应的商品。
 * 如果查不到输出：“查无此商品”
 * 如果能查到打印：”根据商品号：12345678，查询到对应的商品为：西瓜”
 */
public class Test_3_4 {

    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put(id(),"苹果");
        map.put("12345678","哈密瓜");
        map.put(id(),"香蕉");
        map.put(id(),"西瓜");
        map.put(id(),"橘子");
        System.out.println(map);

        //搜索
        search("13245216",map);
    }

    public static String id(){
        //生成商品号是8个0-9的随机数
        String id = "";
        Random random = new Random();
        for (int i = 1; i <=8 ; i++) {
            int k = random.nextInt(10); //[0,10)
            id+=k;
        }
        return id;
    }

    public static void search(String id,Map<String,String> map){
        boolean flag = map.containsKey(id);
        if(flag){
            System.out.println("商品编号："+id+",商品名："+map.get(id));
        }else{
            System.out.println("查无此商品");
        }
    }

}
