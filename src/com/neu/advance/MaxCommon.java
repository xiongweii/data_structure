package com.neu.advance;

/**
 * @program: untitled
 * @description: 最长公共子序列:子序列可以不连续，子串必须连续，注意区别
 * 给出两个字符串，求出这样的一
 * 个最长的公共子序列的长度：子序列
 * 中的每个字符都能在两个原串中找到，
 * 而且每个字符的先后顺序和原串中的
 * 先后顺序一致。
 * Sample Input
 * abcfbc abfcab
 * programming    contest
 * abcd    mnp
 * Sample Output
 * 4
 * 2
 * 0
 * @author: zhaojiawei
 * @create: 2019-12-18 21:38
 */
public class MaxCommon {
    public static int  maxCommonLength(String str1,String str2){
        char[] s1=str1.toCharArray();
        char[] s2=str2.toCharArray();
        int[][] maxLength=new int[str1.length()+1][str2.length()+1];
        //maxLength[i][j]表示s1[i]前i个字符和s2[j]的前j个字符的最长公共子序列
        for(int i=0;i<maxLength.length;i++){
            maxLength[i][0]=0;
        }
        for(int j=0;j<maxLength[0].length;j++){
            maxLength[0][j]=0;
        }//边界条件
        for(int i=1;i<maxLength.length;i++)
            for(int j=1;j<maxLength[0].length;j++){
                if(s1[i-1]==s2[j-1]){//注意这里是i-1和j-1，要不然数据会越界
                    maxLength[i][j]=maxLength[i-1][j-1]+1;
                }else{
                    maxLength[i][j]=Math.max(maxLength[i-1][j],maxLength[i][j-1]);
                }
            }
        return maxLength[str1.length()][str2.length()];
    }
    public static void main(String[] args){
        String string1="abcde";
        String string2="ace";
        System.out.println(maxCommonLength(string1,string2));
    }
}
