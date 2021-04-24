package com.igeek.javase.day21.reflect.hibernate;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Field;

/**
 * @version 1.0
 * @Description hibernate类
 * @Author chenmin
 * @Date 2020/12/16 9:38
 *
 * 模拟hibernate框架：
 *      提供对象信息，获取对象的所有属性及其对应的值，并且存储进文件中
 */
public class Demo {

    public static void transfer(Object obj){
        try (PrintWriter pw = new PrintWriter(new FileWriter("obj.txt",true));){
            //获取类类型
            Class<?> clazz = obj.getClass();
            pw.println("-----------"+clazz.getSimpleName()+"-------------");
            //获取此类中所有的属性对象，忽略访问权限修饰符
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                String name = field.getName();
                String value = field.get(obj)+"";
                pw.println(name+" === "+value);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, IllegalAccessException {
        Student stu = new Student("001","张三",16,'男');
        transfer(stu);

        Teacher teacher = new Teacher("李四","Java",66);
        transfer(teacher);
    }

}
