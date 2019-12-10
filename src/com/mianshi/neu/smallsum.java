package com.mianshi.neu;

/**
 * @program: untitled
 * @description: 任意两个数字能否任意累加得到target
 * @author: zhaojiawei
 * @create: 2019-12-08 14:51
 */
public class smallsum {
    /*暴力递归
    *假设sum中都是正数
    * */
    public static boolean isSum(int[] arr,int i,int sum,int target){
        if(i==arr.length)
            return sum== target;
        return isSum(arr,i+1,sum,target)||isSum(arr,i+1,arr[i]+sum,target);
    }
    public static boolean isSum1(int[] arr,int target){
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
        }
        boolean[][] dp=new boolean[arr.length+1][sum+1];
        if(target>sum)
            return dp[0][0];
        dp[arr.length][target]=true;
        for(int i=arr.length-1;i>=0;i--)
            for(int j=0;j<=target;j++){ //比如f(2,0)只和f(3,0)||f(3,5),5为arr[i]的值
                if(j + arr[i]<=target)
                {
                    dp[i][j] = dp[i + 1][j] || dp[i + 1][j + arr[i]];//只要有一个满足条件即可
                }
            }
        return dp[0][0];
    }
    public static boolean money2(int[] arr, int aim) {
        boolean[][] dp = new boolean[arr.length + 1][aim + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][aim] = true;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = aim - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (j + arr[i] <= aim) {
                    dp[i][j] = dp[i][j] || dp[i + 1][j + arr[i]];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args){
       int[] arr={2,4,6,14,5,18};
//        System.out.println(isSum(arr,0,0,0));
        System.out.println(isSum1(arr,50));
        String string="abcdad";
        System.out.println(string.substring(1));
    }

}
