package com.igeek.javase.day05.enums;

/**
 * @version 1.0
 * @Description 枚举使用场景：枚举通常用于做信息的标志和分类
 * @Author chenmin
 * @Date 2020/11/3 9:39
 */
public class MyEnumDemo2 {

    //公开的静态的常量
//    public static final int WORD = 0;
//    public static final int PPT = 1;
//    public static final int EXCEL = 2;
//    public static final int XMIND = 3;

    public static void main(String[] args) {
        //模糊，不规范
        //draw(0);
        //更加直观，不规范
        //draw(MyEnumDemo2.EXCEL);
        //枚举，更加直观，更加规范
        draw(MyEnum.PPT);
    }

    public static void draw(MyEnum my){
        switch (my){
            case WORD:
                System.out.println("Word开始绘制");
                break;
            case PPT:
                System.out.println("PPT开始绘制");
                break;
            case EXCEL:
                System.out.println("Excel开始绘制");
                break;
            case XMIND:
                System.out.println("Xmind开始绘制");
                break;
            default:
                System.out.println("无法绘制，没有匹配选项");
                break;
        }
    }

}
enum MyEnum{
    WORD,PPT,EXCEL,XMIND;
}
