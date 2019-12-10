package com.mianshi.neu;

/**
 * @program: untitled
 * @description: 汉诺塔问题
 * @author: zhaojiawei
 * @create: 2019-12-06 14:30
 */
public class HanNuoTower {
    public static void Process(int n,String from,String to,String help){//N代表有n个圆盘，初始位置在from这个柱子上
        if(n==1)
        {
            System.out.println("move"+n+"from"+from+"to"+to);
            return;
        }
        Process(n-1,from,help,to);
        System.out.println("move"+n+"from"+from+"to"+to);
        Process(n-1,help,to,from);
    }
    public static void main(String[] args){
        Process(3,"左","右","中");
    }
}
