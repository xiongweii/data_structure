package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: untitled
 * @description: Test
 * @author: zhaojiawei
 * @create: 2019-12-02 17:09
 */
public class SuperClassTest {
  public static class Person{
       protected String num=null;
        public   Person(int age,String name){
            System.out.println("自定义构造方法 ！");
        }
//        public Person(){
//            System.out.println("默认的构造方法！");
//        }
    }
//   static class Student extends Person{
//        public Student(int  age,String  name,String sex){
//            super(age,name);
//            System.out.println("我是子类的构造方法！");
//        }
//        public  void fun(){
//            super.num=null;
//        }
//    }

    public static void main(String[] args){
        Person person=new Person(12,"zhao");
        String city="hello";
        String[] arrs={"hello","world","age"};
        System.out.println(String.join("--",arrs));
//        System.out.println(city);
        person.num=null;
        String res="123456";
        System.out.println(Arrays.toString(res.toCharArray()));;
        int[] scores = new int[] { 88, 77, 51, 66 };
        System.out.println(scores.toString());
        var sb=new StringBuilder();
        String[] fields = { "name", "position", "salary" };
       String  newfields=Arrays.toString(fields);
        System.out.println(newfields.substring(1,newfields.length()-1));
        Integer.parseInt("26");
        System.out.println(1<<4);
        List<Integer> ress=new ArrayList<Integer>();


    }

}
 interface Person {
    // 编译器会自动加上public statc final:
    int MALE = 1;
    int FEMALE = 2;
}