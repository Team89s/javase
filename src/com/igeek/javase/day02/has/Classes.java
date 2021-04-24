package com.igeek.javase.day02.has;

import java.util.Arrays;

/**
 * @version 1.0
 * @Description 班级
 * @Author chenmin
 * @Date 2020/10/29 14:08
 */
public class Classes {

    private int no;

    //一对多关联  双向关联
    private Student[] stus = new Student[3];

    public Classes() {
    }

    public Classes(int no, Student[] stus) {
        this.no = no;
        this.stus = stus;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Student[] getStus() {
        return stus;
    }

    public void setStus(Student[] stus) {
        this.stus = stus;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "no=" + no +
                ", stus=" + Arrays.toString(stus) +
                '}';
    }
}
