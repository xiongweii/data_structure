package com.neu.advance;

/**
 * @program: untitled
 * @description: 放苹果问题
 * 把M个同样的苹果放在N个同样的盘子里，允许有的盘子空着不放，
 * 问共有多少种不同的分法？5，1，1和1，5，1 是同一种分法。
 * 输入
 * 第一行是测试数据的数目t（0 <= t <= 20）。以下每行均包含二个整
 * 数M和N，以空格分开。1<=M，N<=10。
 * 输出
 * 对输入的每组数据M和N，用一行输出相应的K。
 * @author: zhaojiawei
 * @create: 2019-12-16 16:13
 */
public class PlaceApple {
    public static int PlaceNum(int m,int n){//表示将m个苹果放入n个盘子里，一共有多少种放法
      /*①当n>m时，因为盘子和苹果是无差别的，PlaceNum(m,n)等价于PlaceNum(m,m)
      * ②当n<=m时，分成两种情况：1.有空盘子。2.无空盘子
      *     有空盘子：可知至少有一个空盘子，PlaceNum(m,n)=PlaceNum(m,n-1)
      *     无空盘子：，PlaceNum(m,n)=PlaceNum(m-n,n)
      * */
      if(m==0)
          return 1;
      if(n==0)
          return 0;
      if(n>m)
          return PlaceNum(m,m);
      else{
          return PlaceNum(m,n-1)+PlaceNum(m-n,n);
      }
    }
    public static long PlaceNum2(int m,int n){//动态规划
        long[][] method=new long[m+1][n+1];//method[m][n]表示m个苹果放入n个碟子里，一共有多少种放法
        for(int i=0;i<method.length;i++)
            method[i][0]=0;
        for(int j=0;j<method[0].length;j++)
            method[0][j]=1;
        for(int i=1;i<method.length;i++)
            for(int j=1;j<method[0].length;j++){
                if(j>i){
                    method[i][j]=method[i][i];
                }else{
                    method[i][j]=method[i][j-1]+method[i-j][j];
                }
            }
        return method[m][n];
    }
    public static void main(String[] args){
        //System.out.println(PlaceNum(200,100));
        System.out.println(PlaceNum2(200,100));
    }
}
