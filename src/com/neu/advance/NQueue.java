package com.neu.advance;

import java.util.Arrays;

/**
 * @program: untitled
 * @description: N皇后问题
 * @author: zhaojiawei
 * @create: 2019-12-15 12:51
 */
public class NQueue {
    public static int N=8;
    public static  int[] QueueColumm=new int[N];//QueueColumn[i]的值表示第i个皇后放在哪一列；每行代表一个皇后
    public static int M=0;
    public static void nqueue(int nIndex){
        if(nIndex==N){
            M++;
            System.out.println(Arrays.toString(QueueColumm));

        }
        int j=0;
        for(int i=0;i<N;i++){ //寻找当前皇后(nIndex)可能放的位置i->0:i->N-1
            for(j=0;j<nIndex;j++){//判断当前皇后(nIndex)与前[0-nIndex-1]的位置是否冲突
                if(QueueColumm[j]==i||Math.abs(nIndex-j)==Math.abs(i-QueueColumm[j])){ //如果列冲突了；或者对角线冲突了(当前点的横坐标和之前点的横坐标只差绝对值==当前点纵坐标和之前点的纵坐标绝对值相等，则说明对角线冲突)，分别对应前后两个条件
                    break;
                }
            }
            if(j==nIndex){//说明不冲突，第nIndex个皇后应该放在i位置上
                QueueColumm[nIndex]=i;
                nqueue(nIndex+1);//这个皇后位置放好以后再递归求解下一个皇后应该放的位置
            }
        }
    }
    public static void main(String[] args){
        nqueue(0);//表示当前n-1个皇后已经排列好，现在排第n个皇后
        System.out.println("方案数为"+M);

    }
}
