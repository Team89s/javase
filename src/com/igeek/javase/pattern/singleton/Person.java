package com.igeek.javase.pattern.singleton;

/**
 * @version 1.0
 * @Description TODO
 * @Author chenmin
 * @Date 2020/11/3 16:33
 */
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    static class Student{
        private int no; //学号

        public Student() {
        }

        public Student(int no) {
            this.no = no;
        }

        public int getNo() {
            return no;
        }

        public void setNo(int no) {
            this.no = no;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "no=" + no +
                    '}';
        }
    }

    public static void main(String[] args) {
        Person person = new Person("张三",25);
        Person.Student student = new Person.Student(1);
        System.out.println(student);
    }


}
