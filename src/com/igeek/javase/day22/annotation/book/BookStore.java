package com.igeek.javase.day22.annotation.book;

/**
 * @version 1.0
 * @Description BookStore 书店
 * @Author chenmin
 * @Date 2020/12/16 15:34
 */
@MyBook(value = "《Java从入门到放弃》",price = 199.9,authors = {"冯世航","万青"})
public class BookStore {

    @MyBook(value = "《MySQL从建库到删库跑路》",authors = {"傅总","老毕"})
    public void purchase(){

    }

}
