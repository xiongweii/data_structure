package com.company;

/**
 * @program: untitled
 * @description: 两个无限大的数相加
 * @author: zhaojiawei
 * @create: 2019-12-03 19:57
 */
public class BigDataAdd {
    public static String add(String s1,String s2){
        if(s1==null||s1.equals(""))
            return s2;
        if(s2==null||s2.equals(""))
            return s1;
        int maxLength=Math.max(s1.length(),s2.length());
        StringBuffer res=new StringBuffer(maxLength+1); //多申请一位，防止最后一位有进位
        int count=0;//保留进位
        int minLength=Math.min(s1.length(),s2.length());
        s1=new StringBuffer(s1).reverse().toString();
        s2=new StringBuffer(s2).reverse().toString();
        int curNum=0;
        int i;
        int temp;
        for(i=0;i<minLength;i++){
            temp=s1.charAt(i)+s2.charAt(i)-2*'0'+count;
            curNum=temp%10;
            count=temp/10;
            res.append(curNum);
        }
        if(s1.length()<s2.length())
            s1=s2;
        for(;i<s1.length();i++){
           temp= s1.charAt(i)-'0'+count;
           curNum=temp%10;
           count=temp/10;
           res.append(curNum);
        }
        if(count>0){
            res.append(count);
        }
        return res.reverse().toString();

    }
    public static void main(String[] args){
        String s1="12345678";
        String s2="5678";
        System.out.println(add(s1,s2));
        String s3="123456.789";
        String s4="2.3";
        System.out.println(s1.indexOf("."));
        System.out.println(s3.substring(0,6));
        System.out.println(s3.substring(7));
    }
}
