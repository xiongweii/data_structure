package com.neu.advance;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @program: untitled
 * @description: 全排列问题
 * 将全排列的元素模拟成拿在手里的卡牌，元素的位置模拟成箱子
 * @author: zhaojiawei
 * @create: 2019-12-15 15:07
 */
public class AllSort {
    public static char[] pridata="abc".toCharArray();
    public static  int N = pridata.length;
    public static char[] data=new char[N];
    public static int[] book=new int[N];//book储存每个卡牌的状态；
    public static void allSort(int n){//表示第n个箱子应该装什么
        if(n==N){
            System.out.println(Arrays.toString(data));
            return;
        }
        for(int i=0;i<N;i++){//从N个字符里挑选符合要求的放入箱子里
            if(book[i]==0){//如果这个字符还能利用(还在手里),符合条件
                book[i]=1;//先把状态改变，锁定；
                data[n]=pridata[i];//将符合条件的字符放入n号箱子里
                allSort(n+1);//递归看下一个箱子
                book[i]=0;//一整趟下来，解锁；
            }
        }
    }
    public static void main(String[] args){
     allSort(0);//从0号箱子里看
        Scanner scanner=new Scanner(System.in);

    }
}
