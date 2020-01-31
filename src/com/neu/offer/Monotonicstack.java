package com.neu.offer;

import java.util.Stack;

/**
 * @program: untitled
 * @description: 单调栈原理和应用
 * @author: zhaojiawei
 * @create: 2020-01-20 21:13
 */
public class Monotonicstack {
    public static class Maxnums{
        private int left;
        private int  right;
        public Maxnums(int left,int right){
            this.left=left;
            this.right=right;
        }
    }
    public static Maxnums[] MaxNumsLeftAndRight(int[] arrays){//给定一个数组，找到数组中每个数左边离它最近的比它大的，右边离他最近的比它大的数
        //假设给定数组中没有重复元素
       Maxnums[] res=new  Maxnums[arrays.length];
       Stack<Integer> stack=new Stack<>();//栈中存放下标
       for(int i=0;i<arrays.length;i++){
           while(!stack.isEmpty()&&arrays[stack.peek()]<arrays[i]){//如果当前数比栈顶元素大时，违反了我们想要的从栈底到栈顶是由大到小的顺序
               int index=stack.pop();
               res[index]=new Maxnums(0,0);
               res[index].right=arrays[i];
               if(stack.size()>0)
                   res[index].left=arrays[stack.peek()];
           }
           stack.push(i);//如果栈为空，则直接入栈
       }
       while(!stack.isEmpty()){
           int cur=stack.pop();
           res[cur]=new Maxnums(0,0);
           if(stack.size()>0){
               res[cur].left=arrays[stack.peek()];
           }
       }
       return res;

    }
    public static void main(String[] args) throws InterruptedException {
        int[] test=new int[10];
        int[] arrays={3,5,2,4,6,0,1,5};
        Maxnums[] res=MaxNumsLeftAndRight(arrays);

    }
}
