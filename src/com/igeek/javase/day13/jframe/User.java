package com.igeek.javase.day13.jframe;

/**
 * @version 1.0
 * @Description 用户类
 * @Author chenmin
 * @Date 2020/11/18 10:07
 */
public class User {

    private String name;
    private String sex;
    private String pwd;
    private String hobby;
    private String address;
    private String content;
    private String email;

    public User() {
    }

    public User(String name, String sex, String pwd, String hobby, String address, String content, String email) {
        this.name = name;
        this.sex = sex;
        this.pwd = pwd;
        this.hobby = hobby;
        this.address = address;
        this.content = content;
        this.email = email;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * 设置
     * @param sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 获取
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取
     * @return hobby
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * 设置
     * @param hobby
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    /**
     * 获取
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 获取
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置
     * @param content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return "User{name = " + name + ", sex = " + sex + ", pwd = " + pwd + ", hobby = " + hobby + ", address = " + address + ", content = " + content + ", email = " + email + "}";
    }
}
