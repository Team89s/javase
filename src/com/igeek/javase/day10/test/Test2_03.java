package com.igeek.javase.day10.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/16 15:40
 * <p>
 * 已知数组存放一批QQ号码.QQ号码最长为11位,最短为5位
 * String[] strs = {"12345","67891","12347809933","98765432102","67891","12347809933"}
 * 将该数组里面的所有qq号都存放在LinkedList中,将list中重复元素删除,将list中所有元素用两种方式打印出来
 */
public class Test2_03 {

    public static void main(String[] args) {
        String[] strs = {"12345", "67891", "12347809933", "98765432102", "67891", "12347809933"};
        HashSet<String> set = new HashSet<>(Arrays.asList(strs));
        System.out.println("set = " + set);
        LinkedList list = new LinkedList(set);
        System.out.println("list = " + list);
    }

}
