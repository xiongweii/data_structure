package com.neu.advance;

import java.util.Arrays;

/**
 * @program: untitled
 * @description: 输出前m大的数
 * 给定一个数组包含n个元素，统计前m大的数并且把这m个数从大到小
 * 输出。
 * 排序后再输出，复杂度 O(nlogn)
 * 用分治处理：复杂度 O(n+mlogm)
 * 思路：把前m大的都弄到数组最右边，然后对这最右边m个元素排序，
 * 再输出
 * 关键 ：O(n)时间内实现把前m大的都弄到数组最右边
 * @author: zhaojiawei
 * @create: 2019-12-17 20:07
 */
public class PreMaxm {
    public static void quickSort(int[] arr,int left,int right){//快排
        if(left<right) {
            int temp = arr[left];//以arr[left]作为数轴
            int less = left-1;//这里不能为-1
            int more = right + 1;
            int index = left;
            while (index < more) {
                if (arr[index] < temp) {
                    swap(arr, index, ++less);
                    ++index;
                } else if (arr[index] > temp) {
                    swap(arr, index, --more);//此时index不往前走，因为有可能换过来的数小于temp
                } else {//如果相等的化，则index往前走
                    index++;
                }
            }
            quickSort(arr, left, less);
            quickSort(arr, more, right);
        }
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        return;
    }
    public static void MaxkNumRight(int[] arr,int left,int  right,int k){//用O(n)时间复杂度将最大达k个数移到数组最右边
        if(left<right) {
            if(right-left+1<k)
                return;
            int comparator = arr[left];
            int less = left-1;//先把大于等于comparator的放右边，把小于comparator的放左边。less刚开始指向无效位
            int index = left;
            int more=right+1;
            while (index < more){
                if (arr[index] < comparator) {
                    swap(arr, index, ++less);
                    ++index;
                } else if (arr[index] > comparator) {
                    swap(arr, index, --more);//此时index不往前走，因为有可能换过来的数小于temp
                } else {//如果相等的化，则index往前走
                    index++;
                }
            }
            if (k == right-more+2)
                return;
            else if (k <  right-more+2) {//右边的数大于k个
                MaxkNumRight(arr, more, right, k);
            } else {//右边的数小于k个，需要从左边取k-arr.length-less-1
                MaxkNumRight(arr, left, more-2, k - (right-more+2));
            }
        }

    }
    public static void main(String[] args){
        int[] arr={200,28,15,18,36,19,13,34,2,4,5,30,100,3,2,1,6,7,8,234};
        //quickSort(arr,0,arr.length-1);
        //System.out.println(Arrays.toString(arr));
        int m=7;
        MaxkNumRight(arr,0,arr.length-1,m);
        quickSort(arr,arr.length-1-m,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

}
