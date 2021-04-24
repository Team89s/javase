package com.igeek.javase.day16.serializable.clone;

import java.io.Serializable;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/26 15:05
 */
public class Major /*implements Cloneable*/ implements Serializable {

    private static final long serialVersionUID = -2912226201867733586L;
    private String majorName;
    private String majorId;

   /* @Override
    protected Major clone() throws CloneNotSupportedException {
        return (Major)super.clone();
    }*/

    public Major() {
    }

    public Major(String majorName, String majorId) {
        this.majorName = majorName;
        this.majorId = majorId;
    }

    /**
     * 获取
     * @return majorName
     */
    public String getMajorName() {
        return majorName;
    }

    /**
     * 设置
     * @param majorName
     */
    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    /**
     * 获取
     * @return majorId
     */
    public String getMajorId() {
        return majorId;
    }

    /**
     * 设置
     * @param majorId
     */
    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String toString() {
        return "Major{majorName = " + majorName + ", majorId = " + majorId + "}";
    }
}
