package com.neu.advance;

import java.util.Arrays;

/**
 * @program: untitled
 * @description: KMP字符串匹配算法
 * @author: zhaojiawei
 * @create: 2019-12-09 16:49
 */
public class KMP {
    public static int[] GetNextArray(char[] str2){//str2为子串
        if(str2.length==1)
            return new int[]{-1};
        int[] next=new int[str2.length];
        next[0]=-1;
        next[1]=0;
        int i=2;
        int cn=0;
        while(i<next.length){
            if(str2[i-1]==str2[cn]){
//                next[i]=next[i-1]+1;
//                ++i;
//                ++cn;
                next[i++]=++cn;
            }else if(cn>0){
                cn=next[cn];
            }else{
                next[i++]=0;//此时cn一定为0
            }
        }
        System.out.println("next数组："+Arrays.toString(next));
        return next;
    }
    public static int KMP(String s_1,String s_2){//s1为主串，s2为子串
        if(s_1==null||s_2==null||s_2.length()<1||s_1.length()<s_2.length())
            return -1;
        char[] str1=s_1.toCharArray();
        char[] str2=s_2.toCharArray();
        int i1=0;
        int i2=0;
        int[] next=GetNextArray(str2);
        while(i1<str1.length&&i2<str2.length){
            if(str1[i1]==str2[i2]){
                i1++;
                i2++;
            }else  if(next[i2]==-1){//说明此时i2已经在0位置了
                i1++;
            }else{
                i2=next[i2];//i2往回跳
            }
        }
        return i2==str2.length?i1-i2:-1;
    }
    public static int Common(String m,String n){
        if(m==null ||n==null||n.length()<1||m.length()<n.length()){
            return -1;
        }
        char[] str1=m.toCharArray();
        char[] str2=n.toCharArray();
        int i1=0;
        int i2=0;
        int index=0;
        for(int i=0;i<str1.length;i++) {
            index=i+1;
            while (i1 < str1.length && i2 < str2.length) {
                if (str1[i1] == str2[i2]) {
                    i1++;
                    i2++;
                } else {
                    i1 = index; //index记录着上一个i1位置的下一位置
                    i2 = 0;
                    break;
                }
            }
            if(i2==str2.length)
                return i1-i2;
        }
            return -1;

    }
    public static StringBuilder intToSecond(int num){
        String res="";
        while(num>0){
            res+=num%2;
            num/=2;
        }
        return new StringBuilder(res).reverse();
    }
    public  static int SecondToInt(String num){
        int pow=0;
        int sum=0;
        char[] data=num.toCharArray();
        for(int i=num.length()-1;i>=0;i--){
            sum+=Math.pow(2,pow++);
        }
        return sum;
    }
    public static void main(String[] args){
        String str1="ababacbbadcf";
        String str2="abcabcb";
        System.out.println(KMP(str1,str2));
        System.out.println(Common(str1,str2));
//        System.out.println(intToSecond(150));
//        System.out.println(SecondToInt("0101011000100101"));
    }
}
