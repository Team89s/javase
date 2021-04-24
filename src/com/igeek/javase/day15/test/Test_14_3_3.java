package com.igeek.javase.day15.test;

import java.io.File;
import java.util.Map;
import java.util.TreeMap;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/7 16:50
 *
 * 键盘录入一个文件夹路径,统计该文件夹(包含子文件夹)中每种类型的文件及个数
 * 注意:用文件类型(后缀名,不包含.(点),如："java","txt")作为key,
 * 	用个数作为value,放入到map集合中,并用两种方式遍历map集合
 * 	例如：
 * 	doc 的类型的文件有  3 个
 * 	java 的类型的文件有  5 个
 * 	txt 的类型的文件有  7 个
 */
public class Test_14_3_3 {

    public static void main(String[] args) {
        File file = new File("D:\\aaa");
        //键  String  文件后缀 ； 值  Integer  统计后缀的个数
        Map<String,Integer> map = new TreeMap<>();
        total(file,map);
        System.out.println(map);
    }

    public static void total(File file , Map<String,Integer> map) {
        //不遍历的条件
        if(file==null || !file.exists() || file.isFile() || file.isHidden())  return;

        File[] files = file.listFiles();
        for (File f : files) {
            if(f.isHidden()){
                return;
            }else if(f.isDirectory()){
                total(f,map);
            }else if(f.isFile()){
                String name = f.getName();
                String str = name.substring(name.lastIndexOf(".") + 1);
                //Map集合中包含键
                if(map.containsKey(str)){
                    //通过键取出值 +1
                    map.replace(str,map.get(str)+1);
                }else{
                    //Map集合中不包含键，则直接给集合新增元素
                    map.put(str,1);
                }
            }
        }
    }

}
