package com.mianshi.neu;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: untitled
 * @description: 切金条问题
 * @author: zhaojiawei
 * @create: 2019-12-06 10:25
 */
public class LessMoney {
    public static class MinHeapComparator implements Comparator<Integer>{
        public int compare(Integer o1,Integer o2){
            return o1-o2;
        }
    }
    public static int lessMoney(int[] arr){
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(new MinHeapComparator());
        for(int i:arr){
            minHeap.add(i);
        }
        int sum=0;
        while(minHeap.size()>1){
            int add=minHeap.poll()+minHeap.poll();
            sum+=add;
            minHeap.add(add);
        }
        return sum;
    }
    public static void main(String[] args){
        int[] arr={10,20,30};
        System.out.println(lessMoney(arr));
    }
}
