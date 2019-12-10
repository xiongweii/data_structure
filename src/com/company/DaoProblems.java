package com.company;

/**
 * @program: untitled
 * @description: 岛问题
 * @author: zhaojiawei
 * @create: 2019-11-29 17:22
 * 一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右
 * 四个位置相连，如果有一片1连在一起，这个部分叫做一个岛，求一个
 * 矩阵中有多少个岛？
 * 思想：依次遍历每个数如果遇到一，先加1，然后感染一片；
 * 将周围的数都变成2，具体感染规则就是上下左右感染
 */
public class DaoProblems {
    public static int dao(int[][] arr){
        int m=arr.length;
        int n=arr[0].length;
        int result=0;
        if(m==0)
            return 0;
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++)
            {
                if(arr[i][j]==1)
                    result++;
                infect(arr,i,j,m,n);
            }
        return result;
    }
    public static void infect(int[][] arr,int i,int j,int m,int n){
        if(i<0||i>m-1||j<0||j>n-1||arr[i][j]!=1)
            return;
        arr[i][j]=2;
        infect(arr,i-1,j,m,n);
        infect(arr,i+1,j,m,n);
        infect(arr,i,j-1,m,n);
        infect(arr,i,j+1,m,n);
    }
    public static void main(String[] args){
        int[][] arr=new int[4][6];
        arr[0][2]=1;
        arr[0][4]=1;
        arr[1][0]=1;
        arr[1][1]=1;
        arr[1][2]=1;
        arr[1][4]=1;
        arr[2][0]=1;
        arr[2][3]=1;
        for(int i=0;i<arr.length;i++)
        { for(int j=0;j<arr[0].length;j++)
                System.out.print(arr[i][j]+" ");
            System.out.println();
        }
        System.out.println(dao(arr));


    }

}
