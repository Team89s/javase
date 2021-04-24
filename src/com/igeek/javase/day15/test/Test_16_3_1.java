package com.igeek.javase.day15.test;

import java.io.*;
import java.util.Scanner;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/12/8 10:46
 *
 * 有学生类包含学号，姓名，省份证号，Java成绩，数学成绩，英语成绩等成员变量，提供构造方法和setter和getter方法。
 * 要求：
 * 	* 学生信息及成绩保存到C盘的save.txt文件中
 * 	* 学生身份证号码不能保存到文件中。
 * 	* 程序运行时如果save.txt不存在，则
 * 从键盘录入1个学生信息，信息录入格式如下：
 * 	***** 录入学生信息 *****
 * 	请输入学号：9527
 * 	请输入姓名：华安
 * 	请输入身份证号：2203919831234543
 * 	请输入Java成绩：90
 * 	请输入数学成绩：80
 * 	请输入英语成绩：88
 *
 * 	根据录入的信息创建学生对象并将学生对象保存到C盘下的save.txt文件中。
 * 	* 如果程序运行时，save.txt文件已经存在，则显示学生信息。格式如下：
 * 	**** 学生基本信息 *****
 * 	学号  姓名 省份证号  Java成绩  数学成绩  英语成绩
 * 	9527  华安   null      90        80        88
 */
public class Test_16_3_1 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学号：");
        String num = sc.nextLine();
        System.out.println("请输入姓名：");
        String name = sc.nextLine();
        System.out.println("请输入身份证号：");
        String personId = sc.nextLine();
        System.out.println("请输入Java成绩：");
        double javaScore = sc.nextDouble();
        System.out.println("请输入数学成绩：");
        double mathScore = sc.nextDouble();
        System.out.println("请输入英语成绩：");
        double englishScore = sc.nextDouble();
        //创建对象信息
        Student stu = new Student(num,name,personId,javaScore,mathScore,englishScore);

        File file = new File("D:\\save.txt");
        if(!file.exists()){
            file.createNewFile();
        }

        //查询学生是否存在
        Student student = readObj(file, num, name);
        if(student!=null){
            System.out.println("学号\t姓名\t省份证号\tJava成绩\t数学成绩\t英语成绩");
            System.out.println(student.getNum()+"\t"+student.getName()+"\t"+
                    student.getPersonId()+"\t"+student.getJavaScore()+"\t"+
                    student.getMathScore()+"\t"+student.getEnglishScore());
        }else{
            //将当前对象信息写出至文本中
            writeObj(stu,file);
        }
    }

    //读取文件，获得对象信息，通过姓名和学号查找是否存在该学生
    public static Student readObj(File file,String num,String name){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            Student stu = (Student) ois.readObject();
            if(num.equals(stu.getNum()) && name.equals(stu.getName())){
                return stu;
            }
        } catch (EOFException e){

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    //写出至文件，写对象信息
    public static void writeObj(Student stu , File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(stu);
            oos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Student implements Serializable {
    private String num;
    private String name;
    private transient String personId;  //该字段不进行序列化
    private double javaScore;
    private double mathScore;
    private double englishScore;


    public Student() {
    }

    public Student(String num, String name, String personId, double javaScore, double mathScore, double englishScore) {
        this.num = num;
        this.name = name;
        this.personId = personId;
        this.javaScore = javaScore;
        this.mathScore = mathScore;
        this.englishScore = englishScore;
    }

    /**
     * 获取
     * @return num
     */
    public String getNum() {
        return num;
    }

    /**
     * 设置
     * @param num
     */
    public void setNum(String num) {
        this.num = num;
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
     * @return personId
     */
    public String getPersonId() {
        return personId;
    }

    /**
     * 设置
     * @param personId
     */
    public void setPersonId(String personId) {
        this.personId = personId;
    }

    /**
     * 获取
     * @return javaScore
     */
    public double getJavaScore() {
        return javaScore;
    }

    /**
     * 设置
     * @param javaScore
     */
    public void setJavaScore(double javaScore) {
        this.javaScore = javaScore;
    }

    /**
     * 获取
     * @return mathScore
     */
    public double getMathScore() {
        return mathScore;
    }

    /**
     * 设置
     * @param mathScore
     */
    public void setMathScore(double mathScore) {
        this.mathScore = mathScore;
    }

    /**
     * 获取
     * @return englishScore
     */
    public double getEnglishScore() {
        return englishScore;
    }

    /**
     * 设置
     * @param englishScore
     */
    public void setEnglishScore(double englishScore) {
        this.englishScore = englishScore;
    }

    public String toString() {
        return "Student{num = " + num + ", name = " + name + ", personId = " + personId + ", javaScore = " + javaScore + ", mathScore = " + mathScore + ", englishScore = " + englishScore + "}";
    }
}
