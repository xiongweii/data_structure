package com.mianshi.neu;

/**
 * @program: untitled
 * @description: CowNumber
 * @author: zhaojiawei
 * @create: 2019-12-08 10:03
 */
public class CowNumber {
    public static int CowNum(int year){//递归写法
        if(year<1)
            return 0;
        if(year==1||year==2||year==3)
            return year;
        return CowNum(year-1)+CowNum(year-3);//当前年的牛数是上一年的牛数（没有死，一直传承下来）+前三年的牛数（刚好成熟，可以生小牛）
    }
    public static long CowNum2(int year){
        long[] dp=new long[year+1];
        dp[0]=0;
        if(year<1)
            return dp[0];
        for(int i=1;i<=3;i++)
            dp[i]=i;
        for(int i=4;i<=year;i++){
            dp[i]=dp[i-1]+dp[i-3];
        }
        return dp[year];
    }
    public static void main(String[] args){
        System.out.println(CowNum(20));
        System.out.println(CowNum2(20));

    }
}
