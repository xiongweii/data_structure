package com.neu.advance;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: untitled
 * @description: 二分查找相关内容
 * @author: zhaojiawei
 * @create: 2019-12-17 10:44
 */
public class BinarySelect {
    public static class Mycomporatar implements Comparator<Integer>{
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2-o1;
        }
    }
    public static int selectNum(Integer[] arr,int target){//从某个数组中查找某个数，查到返回给数的下标
        int index=-1;
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(arr[mid]==target)
                return mid;
            else if(arr[mid]<=target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return index;
    }
    public static void find2Num(Integer[] arr,int target){//从给定的数组中找出两个数和等于target
        for(int i=0;i<arr.length;i++)
            for(int j=i;j<arr.length;j++){
                if(arr[i]+arr[j]==target)
                    System.out.println(arr[i]+","+arr[j]);
            }
        return;

    }
    public static void find2Num_1(Integer[] arr,int target){
        //首先排序，遍历每个数，用二分查找寻找target-arr[i]
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            int data=target-arr[i];
            int left=0;           //left和right必须放到for循环里，每次选定一个数时，就初始化left和right
            int right=arr.length-1;
            while(left<=right){
                int mid=left+(right-left)/2;
                if(data==arr[mid]){
                   System.out.println(arr[i]+","+arr[mid]);
                   break;//break结束内层循环
                }else if(arr[mid]>=data){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return;
    }
    public static void find2Num_2(Integer[] arr,int target){
        Arrays.sort(arr);
        int left=0;
        int right=arr.length-1;
        for(;left<=right;){
            if(arr[left]+arr[right]==target){
                System.out.println(arr[left]+","+arr[right]);
                left++;
                right--;
            }else if(arr[left]+arr[right]<target){//如果左右之数之和小于给定值，说明左边数取小了，left右移
                left++;
            }
            else{
                right--;//反之右边数取大了，右指针左移
            }
        }
        return;
    }
    public static void main(String[] args){
        Integer[] arr={1,5,8,10,14,16};
//        System.out.println(selectNum(arr,176));
//        Arrays.sort(arr,new Mycomporatar());
//        System.out.println(Arrays.toString(arr));
        find2Num_1(arr,24);
        find2Num(arr,24);
        find2Num_2(arr,24);
     }
}
