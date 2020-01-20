package com.neu.advance;

import java.util.PriorityQueue;

/**
 * @program: untitled
 * @description: 快速找到数据流中的中位数，剑指offer上214页例题
 * @author: zhaojiawei
 * @create: 2020-01-04 22:27
 */
public class GetMidNum {
    private static PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    private static PriorityQueue<Integer> right =new PriorityQueue<>();
    private static int N=0;
    public static void Insert(Integer num) {
        if (N % 2 == 0) {
            //N为偶数时，插入左边
            right.add(num);
            left.add(right.poll());
        } else
        {//N为奇数时，插入右边

            left.add(num);
            right.add(left.poll());
        }
        N++;//有两个注意点，因为N是从0开始计数的；当执行Insert函数3次时，N是等于3，但是N=0和N=2，是插入了左边；
            //N等于1插入了右边；此时N为3，为奇数；所以应该从左边堆里弹出元素；
    }

    public static  Double GetMedian() {
        if(N%2==0){
            return (left.peek()+right.peek())/2.0;

        }else{

            return (double)left.peek();
        }
    }
    public static void main(String[] args){
        Insert(1);
        Insert(2);
        Insert(3);
        System.out.println(GetMedian());
    }
}
