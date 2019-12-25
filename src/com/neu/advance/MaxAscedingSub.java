package com.neu.advance;

import java.util.Arrays;

/**
 * @program: untitled
 * @description: 最长上升子序列
 * 问题描述
 * 一个数的序列ai，当a1< a2< ... < aS的时候，我们称这个序
 * 列是上升的。对于给定的一个序列(a1, a2, ..., aN)，我们可以得到
 * 一些上升的子序列(ai1, ai2, ..., aiK)，这里1 <= i1 < i2 < ... < iK
 * <= N。比如，对于序列(1, 7, 3, 5, 9, 4, 8)，有它的一些上升子
 * 序列，如(1, 7), (3, 4, 8)等等。这些子序列中最长的长度是4，比
 * 如子序列(1, 3, 5, 8).
 * 你的任务，就是对于给定的序列，求出最长上升子序列的长度。
 * @author: zhaojiawei
 * @create: 2019-12-18 20:48
 */
/*
* 求序列的前n个元素的最长上升子序列的长度”是个
子问题，但这样分解子问题，不具有“无后效性”
假设F(n) = x,但可能有多个序列满足F(n) = x。有的序
列的最后一个元素比 an+1小，则加上an+1就能形成更长上
升子序列；有的序列最后一个元素不比an+1小……以后的事
情受如何达到状态n的影响，不符合“无后效性”
* “求以ak（k=1, 2, 3…N）为终点的最长上升子序列的
长度”
一个上升子序列中最右边的那个数，称为该子序列的
“终点”。
虽然这个子问题和原问题形式上并不完全一样，但
是只要这N个子问题都解决了，那么这N个子问题的解中，
最大的那个就是整个问题的解。
*
*
* */
public class MaxAscedingSub {
    public static int MaxAeceding(int[] arr){
        int[] maxLength=new int[arr.length];//maxLength[i]表示以arr[i]结尾的最长公共上升子序列的长度
        Arrays.fill(maxLength,1);//初始状态maxLength[]所有元素都为1
        for(int i=1;i<arr.length;i++)//遍历每个数
            for(int j=0;j<i;j++){//遍历当前数之前(不包含当前数)的所有以当前数之前结尾的最长公共上升子序列长度
                if(arr[i]>arr[j]){//如果当前数大于之前某个数的值，则maxLength[i]=maxLength[j]+1；；因为arr[i]在内层循环可能更新多次，所以还需要和上次更新过的maxLength[i]比较
                    maxLength[i]=Math.max(maxLength[i],maxLength[j]+1);
                }//反之，如果当前数不比它之前的任何数大，则arr[i]=1,为默认值
            }
        int max=0;
        for(int i=0;i<maxLength.length;i++){
            if(maxLength[i]>max)
                max=maxLength[i];
        }
        return max;
    }
    public static void main(String[] args){
        int[] arr={1,7,3,5,9,4,8};
        System.out.println(MaxAeceding(arr));
    }
}
