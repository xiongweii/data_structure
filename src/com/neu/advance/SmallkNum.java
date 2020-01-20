package com.neu.advance;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * @program: untitled
 * @description:
 * @author: zhaojiawei
 * @create: 2020-01-03 20:39
 */
public class SmallkNum {
    private PriorityQueue<Integer> left=new PriorityQueue<>((o1,o2)->o2-o1);
    public static void swap(int[] input,int i,int j){
        int temp=input[i];
        input[i]=input[j];
        input[j]=temp;
        return;
    }
    public static int Partation(int[] input,int start,int end){
        int less=start-1;
        int temp=input[start];
        int i=start;
        while(i!=end){
            if(input[i]<temp){
                swap(input,++less,i);
                i++;
            }else{
                i++;
            }
        }

        return less;
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res=new ArrayList<>();
        if(k>input.length)
            return res;
        int start=0;
        int end=input.length-1;
        int index=Partation(input,start,end);
        while(index!=k-1){
            if(index==start-1)
                break;
            if(index>k-1){
                end=index-1;
                index=Partation(input,start,end);
            }else{
                start=index+1;
                index=Partation(input,start,end);
            }
        }
        for(int i=0;i<k;i++)
            res.add(input[i]);
        return res;
    }
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        for(int i=1;i<=n;i++){
            int temp=i;
            while(temp>0){
                if(temp%10==1)
                    count++;
                temp/=10;
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] input={4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution(input,4));
        //System.out.println(Partation(input,0,input.length-1));
        System.out.println(NumberOf1Between1AndN_Solution(13));
    }
}
