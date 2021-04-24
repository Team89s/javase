package com.igeek.javase.day01.visible.test;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/10/28 9:40
 */
/**6.该实例为定义一个成绩计算类。
 类中包含的内容有：
 1、三个float类型的成员属性（Java成绩、C#成绩、数据库成绩）；
 2、对三个私有属性的公开的getter/setter方法；
 3、一个无参的构造方法和一个带参数的构造方法；
 4、计算三个科目的平均值的方法；
 5、计算三个科目的总成绩的方法；
 6、程序入口main方法。

 在main中分别通过有参和无参的构造方法实例化成绩计算类的对象实体并传入成绩参数。
 再通过对象调用计算平均值和总成绩的方法打印输出。
 在计算平均值和总成绩的方法中，分别获取到属性的值进行计算。
 */
public class Score {

    private float javaScore;
    private float csharpScore;
    private float oracleScore;

    public float getJavaScore() {
        return javaScore;
    }

    public void setJavaScore(float javaScore) {
        this.javaScore = javaScore;
    }

    public float getCsharpScore() {
        return csharpScore;
    }

    public void setCsharpScore(float csharpScore) {
        this.csharpScore = csharpScore;
    }

    public float getOracleScore() {
        return oracleScore;
    }

    public void setOracleScore(float oracleScore) {
        this.oracleScore = oracleScore;
    }

    public Score() {
    }

    public Score(float javaScore, float csharpScore, float oracleScore) {
        this.javaScore = javaScore;
        this.csharpScore = csharpScore;
        this.oracleScore = oracleScore;
    }

    // 计算三个科目的平均值的方法；
    public float getAvg(){
        return (this.javaScore+this.csharpScore+this.oracleScore)/3;
    }

    // 计算三个科目的总成绩的方法；
    public float getSum(){
        return this.javaScore+this.csharpScore+this.oracleScore;
    }
}
