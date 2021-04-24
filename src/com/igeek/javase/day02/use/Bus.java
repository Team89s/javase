package com.igeek.javase.day02.use;

/**
 * @version 1.0
 * @Description 交通工具
 * @Author chenmin
 * @Date 2020/10/29 14:12
 */
public class Bus {

    private String name;

    public Bus() {
    }

    public Bus(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bus{" +
                "name='" + name + '\'' +
                '}';
    }
}
