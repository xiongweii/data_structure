package com.mianshi.neu;

/**
 * @program: untitled
 * @description: 打印给定字符串的所有子序列
 * @author: zhaojiawei
 * @create: 2019-12-06 15:01
 */
public class PrinttAllSub {
    public static void swap(char[] chars,int i,int j){
        char temp=chars[i];
        chars[i]=chars[j];
        chars[j]=temp;
    }
    public static void Permutations(char[] chars,int i){ //求给定字符数组的全排列
        if (i ==chars.length) {
            System.out.println(String.valueOf(chars));
        }
        for (int j = i; j < chars.length; j++) {
            swap(chars, i, j);
            Permutations(chars, i + 1);
            //swap(chars, i, j);
        }
    }
    public static void PrintSub(char[] chars,int i,String res){
        if(i==chars.length){
            System.out.println(res);
            return;
        }
        PrintSub(chars,i+1,res);//不要上级传来的字符串
        PrintSub(chars,i+1,res+String.valueOf(chars[i]));
    }
    public static void main(String[] args){
        String data="abc";
       // PrintSub(data.toCharArray(),0,"");
        Permutations(data.toCharArray(),0);
        String res="abcdef";
        char[] re=res.toCharArray();

    }
}
