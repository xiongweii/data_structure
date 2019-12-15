package com.neu.advance;

import java.util.Scanner;

/**
 * @program: untitled
 * @description: 用递归求前缀表达式的值
 * @author: zhaojiawei
 * @create: 2019-12-15 14:11
 */
public class ExpValue {
    public static double Exp(){
        Scanner scanner=new Scanner(System.in);
        String res=scanner.next(); //每次读取一个字符串
        switch (res){
            case "*":return Exp()*Exp();
            case "/":return Exp()/Exp();
            case "+":return Exp()+Exp();
            case "-":return Exp()-Exp();
            default:return Double.parseDouble(res);//若为数值类型，则直接将该数值字符串转换成double返回；
        }
    }
    public static void main(String[] args){
        System.out.println(Exp());
    }
}
