package com.neu.advance;

import java.util.*;

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
    private ArrayList<Integer> res=new ArrayList<>();
    public static class Node{
       private int data;
       private Node next;
       public Node(int data){
           this.data=data;
       }
    }
    public static class ListNode{
        private int val;
        private ListNode next;
        public ListNode(int val){
            this.val=val;
        }
    }
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
    public static void reOrderArray(int [] array) {
        if(array.length<1)
            return;
        int end=array.length;
        for(int i=0;i<end;){
            if(array[i]%2==0){
                int temp=array[i];
                int j=i;
                while(j<array.length-1){
                    array[j]=array[j+1];
                    j++;
                }
                array[j]=temp;
                end--;
            }else{
                i++;
            }

        }

        return;


    }
    public static int findNumNode(Node head){
        if(head==null)
            return 0;
        else{
            return findNumNode(head.next)+1;
        }
    }
     public static Node findLastkNode(DeleteNodeByO1.Node head,int k){
        return null;
     }
    public static ListNode Merge(ListNode list1,ListNode list2) {
        if(list1==null)
            return list2;
        if(list2==null)
            return list1;
        ListNode newList=null;
        if(list1.val<list2.val){
            newList=list1;
            newList.next=Merge(list1.next,list2);
        }else{
            newList=list2;
            newList.next=Merge(list1,list2.next);
        }
        return newList;
    }
    public static boolean matchCore(char[] str,int index1,char[] pattern,int index2){
            if(index1==str.length&&index2==pattern.length)
                return  true;
            if(index1!=str.length&&index2==pattern.length)//字符串没到头，模式串到头一定返回false；字符串到头，模式串没到头则不一定返回false；
                return false;
            if(index2!=pattern.length-1&&pattern[index2+1]=='*'){
                if((index1!=str.length&&pattern[index2]==str[index1])||(pattern[index2]=='.'&&index1!=str.length)){
                    return matchCore(str,index1,pattern,index2+2)||matchCore(str,index1+1,pattern,index2)||matchCore(str,index1+1,pattern,index2+2);
                }else{
                    return matchCore(str,index1,pattern,index2+2);
                }
            }
            if(index1!=str.length&&pattern[index2]==str[index1]||(pattern[index2]=='.'&&index1!=str.length))
                return matchCore(str,index1+1,pattern,index2+1);

            return false;
        }
        public static boolean match(char[] str, char[] pattern)
        {
            if(str==null&&pattern==null)
                return false;
            return matchCore(str,0,pattern,0);

        }

    public static void main(String[] args){
        double[] data={1,1,4,2};
        System.out.println(isTarget(data,7));
        char[] c=new char[10];
        System.out.println(Arrays.toString(c));
        System.out.println(c[0]=='\0');
        System.out.println(c.length);
        String ss="zhao";
        char[] ssto=ss.toCharArray();
        System.out.println(ssto.length);
        int[] array={1,2,3,4,5,6,7};
        reOrderArray(array);
        System.out.println(Arrays.toString(array));
        String rr="";
        System.out.println(rr.length());
        char[] array1={};
        char[] array2={'.'};
        match(array1,array2);

        Queue<Integer> queue=new LinkedList<>();
        ArrayList<Integer> res=new ArrayList<>();
        res.add(23);
        res.add(24);
        System.out.println(res.size());
         res=new ArrayList<>();
         System.out.println(res.size());
         ArrayList<Integer> d=new ArrayList<>();
         d.add(2);
         d.add(3);
         System.out.println(d.size());
         d.remove(0);
         System.out.println(d);

    }
}
