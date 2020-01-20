package com.neu.advance;

import java.util.HashMap;

/**
 * @program: untitled
 * @description:作者：CyC2018
 * 给定一个数字，按照如下规则翻译成字符串：1 翻译成“a”，2 翻译成“b”... 26 翻译成“z”。
 * 一个数字有多种翻译可能，例如 12258 一共有 5 种，分别是 abbeh，lbeh，aveh，abyh，lyh。
 * 实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * @author: zhaojiawei
 * @create: 2020-01-05 21:34
 */
public class NumDecoding {
    private static  HashMap<Integer,Integer> hash=new HashMap<>();//用哈希表来避免重复计算
    public static int numDecoding(String num,int start){
        if(start==num.length())//每一次start==num.length,都代表了一种划分情况的终结；可以举1,12这样的例子自己想一下
            return 1;
        if(num.charAt(start)=='0')
            return 0;
        int  key=hash.getOrDefault(start,-1);
        if(key!=-1){
            return key;
        }
        int answer1=numDecoding(num,start+1);
        int answer2=0;
        if(start<num.length()-1){//保证不越界
            int temp=(num.charAt(start)-'0')*10+num.charAt(start+1)-'0';
            if(temp<=26)
               answer2=numDecoding(num,start+2);
        }
        hash.put(start,answer1+answer2);
        return answer1+answer2;
    }
    public static int numDecoding(String num){
        return numDecoding(num,0);
    }
    public static void main(String[] args){
        System.out.println(numDecoding("12258"));
    }
}
