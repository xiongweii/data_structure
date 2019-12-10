package com.mianshi.neu;

/**
 * @program: untitled
 * @description: 最小路径和
 * @author: zhaojiawei
 * @create: 2019-12-08 11:05
 */
public class SmallPath {
    public static int path(int[][] arr,int i,int j){//表示arr[i][j]目前的最短路径是多少
       /*这里是从左上角依次往右下角走
       * 暴力递归写法
       * */
       if(i==0&&j==0)
           return arr[i][j];
       if(i==0)
           return path(arr,i,j-1)+arr[i][j];
       if(j==0)
           return path(arr,i-1,j)+arr[i][j];
       int left=path(arr,i,j-1);
       int up=path(arr,i-1,j);
       return arr[i][j]+Math.min(left,up);
    }
    public static int path1(int[][] arr,int m,int n){
        /*暴力递归改动态规划
        * 前提条件：无后效性问题：即有多条路径到达arr[i][j]这个点，无论选择哪条路径，arr[i][j]
        * 到右下角的最短路径都是固定的，即min(arr[i][j]->arr[终点行][终点列])与选择哪条路径到arr[i][j]
        * 无关
        * */
        int[][] dp=new int[arr.length][arr[0].length];
        dp[0][0]=arr[0][0];
        for(int i=1;i<m;i++){//填充第0列
            dp[i][0]=arr[i][0]+dp[i-1][0]; //注意这里新申请了一个dp的二维数组，arr，和dp不要用混了
        }
        for(int j=1;j<n;j++){//填充第0行
            dp[0][j]=arr[0][j]+dp[0][j-1];
        }
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++){
                dp[i][j]=Math.min(dp[i][j-1],dp[i-1][j])+arr[i][j];
            }
        return dp[m-1][n-1];
    }
    public static void main(String[] args){
        int[][] m = { { 1, 3, 5, 9 }, { 8, 1, 3, 4 }, { 5, 0, 6, 1 }, { 8, 8, 4, 0 } };
        System.out.println(path(m,m.length-1,m[0].length-1));
        System.out.println(path1(m,m.length,m[0].length));
        //System.out.println(process1(m,m.length-1,m[0].length-1));
    }
}
