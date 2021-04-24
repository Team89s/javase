package com.igeek.javase.stu.test;

import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @Description TODO
 * @Author 张小强
 * @Date 2020/12/16 09:02
 *
 * */

public class ZhangHappy {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        int sum=0;
        System.out.println(ishappy(7, list));
    }

    public static boolean ishappy(int a,List<Integer> list){

      int sum=0;
      while(a>=1){
          int x;
          x=a%10;
          sum+=x*x;
          a=a/10;
      }
      if(sum==1){
          return true;
      }else if(list.contains(sum)){
          return false;
      }else {
          list.add(sum);
          return ishappy(sum,list);
      }

    }
}
