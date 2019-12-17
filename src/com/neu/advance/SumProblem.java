package com.neu.advance;

/**
 * @program: untitled
 * @description: 给定某一个数，判断它们之间加减乘除结果能否等于某个数
 * 给出4个小于10个正整数，你可以使用加减乘除4种运算以及括
 * 号把这4个数连接起来得到一个表达式。现在的问题是，是否存
 * 在一种方式使得得到的表达式的结果等于24。
 * 这里加减乘除以及括号的运算结果和运算的优先级跟我们平常
 * 的定义一致（这里的除法定义是实数除法）。
 * 比如，对于5，5，5，1，我们知道5 * (5 – 1 / 5) = 24，因此
 * 可以得到24。又比如，对于1，1，4，2，我们怎么都不能得到
 * 24。
 * @author: zhaojiawei
 * @create: 2019-12-16 17:01
 */
public class SumProblem {
    public static boolean isTarget(double[] arr,int target){
        /*
        * 整体思想：先通过枚举，找到两个数，i和j,然后进行四种可能的运算，将结果存到res中；
        * 之后将除了i和j之外的数，和res一起存放到data[]中，再递归调用isTarget(data,target);
        * 递归终止条件：当arr中只有一个数num时，return num==target;
        * */
        if(arr.length==1){
            return arr[0]==target;
        }
        for(int i=0;i<arr.length;i++)
            for(int j=i+1;j<arr.length;j++){//从arr中任意挑选两个数，arr[i]、arr[j]
                double[] arrNext=new double[arr.length-1];
                int m=0;
                for(int k=0;k<arr.length;k++){//将除了arr[i]、arr[j]之外的数赋值到新数组
                    if(k!=i&&k!=j){ //注意这里比较的是数组，而不是元素的值，因为arr[]数组内的元素有可能相等
                        arrNext[m]=arr[k];
                        m++;
                    }
                }
                arrNext[m]=arr[i]+arr[j];
                if(isTarget(arrNext, target))
                    return true;
                arrNext[m]=arr[i]-arr[j];
                if(isTarget(arrNext, target))
                    return true;
                arrNext[m]=arr[j]-arr[i];
                if(isTarget(arrNext, target))
                    return true;
                arrNext[m]=arr[i]*arr[j];
                if(isTarget(arrNext, target))
                    return true;
                arrNext[m]=arr[i]/arr[j];
                if(isTarget(arrNext, target))
                    return true;
                arrNext[m]=arr[j]/arr[i];
                if(isTarget(arrNext, target))
                    return true;
            }
        return false;
    }
    public static void main(String[] args){
        double[] data={1,1,4,2};
        System.out.println(isTarget(data,7));
    }
}
