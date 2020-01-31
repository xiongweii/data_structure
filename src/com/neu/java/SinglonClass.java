package com.neu.java;

/**
 * @program: untitled
 * @description: 单例设计模式
 * @author: zhaojiawei
 * @create: 2020-01-30 19:15
 */
public class SinglonClass {
    public static void main(String[] args){
        Student s1=Student.getInstance();
        Student s2=Student.getInstance();
        System.out.println(s1==s2);

        Teacher t1=Teacher.getInstance();
        Teacher t2=Teacher.getInstance();
        System.out.println(t1==t2);
    }
}
class Student{
    private Student(){

    }
    private static Student student=new Student(); //单例设计模式之饿汉式 优点：线程安全
    public static Student getInstance(){
        return student;
    }
}
class Teacher{
    private Teacher(){}
    private static Teacher teacher=null;//单例设计模式之懒汉式，缺点：线程不安全
    public static Teacher getInstance(){
        if(teacher==null){
            teacher=new Teacher();
        }
        return teacher;
    }
}

