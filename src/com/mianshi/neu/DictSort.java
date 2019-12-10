package com.mianshi.neu;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: untitled
 * @description: 字典序
 * 给定一个字符串类型的数组strs，找到一种拼接方式，使得把所
 * 有字 符串拼起来之后形成的字符串具有最低的字典序。如"ab","cd","ef",则拼接后的最低字典序是："abcdef"
 * 这里重点是选择什么样的贪心策略：
 * ①最直观的：依次比较两个字符串的ASCII码，但是这种策略有漏洞，不正确：如"b","ba",按照我们的策略，结果应该是"bba";而实际最低的字典序应该是"bab"
 * ②str1||str2<=str2||str1,则结果为str1str2;反之str2str1;
 * @author: zhaojiawei
 * @create: 2019-12-05 20:24
 */
public class DictSort {
    public static class Mycomparator implements Comparator<String> {
        @Override
        public int compare(String o1, String o2) {
            return (o1+o2).compareTo(o2+o1);
        }
    }
    public static String LowestSorts(String[] strings){
        if(strings==null||strings.length==0)
            return null;
        String res="";
        Arrays.sort(strings,new Mycomparator());
        for(String s:strings){
            res+=s;
        }
        return res;
    }
    public static void main(String[] args){
        String[] strings={"b","ba"};
        System.out.println(DictSort.LowestSorts(strings));

    }
}
