package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static int uniquePaths(int m, int n) {
        if(m<=0||m<=0)
            return 0;
        int i,j;
        int dp[][]=new int[m+1][n+1];
        for(i=1;i<m;i++)
            dp[i][0]=1;
        for( j=1;j<n;j++)
            dp[0][j]=1;
        for(i=1;i<m;i++)
            for(j=1;j<n;j++)
            {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        return dp[i-1][j-1];
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1)
            return 0;
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        obstacleGrid[0][0]=1;
        for(int i=1;i<m;i++)
        {
            if(obstacleGrid[i][0]==0)
                obstacleGrid[i][0]=obstacleGrid[i-1][0];
            else
                obstacleGrid[i][0]=0;
        }
        for(int j=1;j<n;j++)
        {
            if(obstacleGrid[0][j]==0)
                obstacleGrid[0][j]=obstacleGrid[0][j-1];
           else
                obstacleGrid[0][j]=0;
        }
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
            {
                if(obstacleGrid[i][j]==0)
                    obstacleGrid[i][j]=obstacleGrid[i-1][j]+obstacleGrid[i][j-1];
                else{
                    obstacleGrid[i][j]=0;
                }
            }
        return obstacleGrid[m-1][n-1];
    }

    public static int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        for(int i=1;i<m;i++)
            grid[i][0]=grid[i-1][0]+grid[i][0];
        for(int j=1;j<n;j++)
            grid[0][j]=grid[0][j-1]+grid[0][j];
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++){
                grid[i][j]=Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
            }
        return grid[m-1][n-1];
    }

    public static int maxSubArray(int[] nums) {

        int ans=nums[0];
        int sum=0;
        for(int num:nums){
            if(num>0)
                sum+=num;
            else {
                sum=num;
            }
            ans=Math.max(ans,sum);
        }
        return sum;
    }
    public static int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new  int[m+1][n+1];//表示长度为m的字符串到长度为n的字符串的最小编辑距离
        for(int i=1;i<=n;i++)
            dp[0][i]=1;
        for(int j=1;j<=m;j++)
            dp[j][0]=1;
        for(int i=1;i<=m;i++)
            for(int j=1;j<=n;j++)
            {
                if(word1.charAt(i-1)==word2.charAt(j-1))
                    dp[i][j]=dp[i-1][j-1];
                else{ // dp[i][j]=dp[i-1][j-1]+1 替换;dp[i][j]=dp[i][j-1]+1 添加；dp[i][j]=dp[i-1][j]+1 删除
                    dp[i][j]=Math.min(Math.min(dp[i-1][j-1],dp[i][j-1]),dp[i-1][j])+1;
                }
            }
        return dp[m][n];

    }
    public int maxSubArray2(int[] nums) {
       int n=nums.length;
       int max=nums[0];
       for(int i=0;i<n;i++)
       {
           int sum=0;
           for(int j=1;j<n;j++){
               sum+=nums[j];
               max=Math.max(sum,max);
           }
       }
       return max;
    }
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int n=nums.length;
        List<List> list=new ArrayList<>();
        int count=0;
        for(int i=0;i<n;i++){
            int product=1;
            List<Integer> data=new ArrayList<>();
            for(int j=i;j<n;j++){
                product*=nums[j];
                if(product<k){
                    count++;
                    data.add(nums[j]);
                }
                else{
                    list.add(data);
                    break;
                }
            }
            list.add(data);
        }
        return count;

    }
    public static int numSubarrayProductLessThanK2(int[] nums, int k) {
        if (k <= 1) return 0;
        int now = 1, times = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            now *= nums[right];
            while (now >= k) now /= nums[left++];
            times += right - left + 1;
        }
        return times;
    }

    public static void main(String[] args) {
        // write your code here
//        System.out.println(uniquePaths(7,3));
//        int[][] arr=new int[2][1];
//        System.out.println(uniquePathsWithObstacles(arr));
        int[][] num ={{1,2,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(num));
        System.out.println(minDistance("horse","ros"));
        String str="i like\" you\\me/";
        System.out.println(str);
        String s = "hello";
        String t = s;
        s = "world";
        System.out.println(t);
        System.out.println(s);
        for (int i=1; i<=10; i++) {
            System.out.println("i = " + i);
            for (int j=1; j<=10; j++) {
                System.out.println("j = " + j);
                if (j >= i) {
                    break;
                }
            }
            // break跳到这里
            System.out.println("breaked");
        }
        int[] ns = { 1, 1, 2, 3, 5, 8 };
        String res= Arrays.toString(ns);
        String ress="my love";
        System.out.println(res);
        System.out.println( Arrays.deepToString(new  int[][]{{1,2,3},{4,5,6}}));
        int[] nums={10,9,10,4,3,8,3,3,6,2,10,10,9,3};
        System.out.println(numSubarrayProductLessThanK(nums,19));
    }
}

