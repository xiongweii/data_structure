package com.company;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: untitled
 * @description: 回溯
 * @author: zhaojiawei
 * @create: 2019-12-03 14:23
 */
 class Test{
    public int result;
    public List<List<String>> ress=new ArrayList<>();
    public  List<List<Integer>> res=new LinkedList<>();
    public  List<List<Integer>> permute(int[] nums) {
        LinkedList<Integer> trace=new LinkedList<>();
        backtrack(nums,trace);
        return res;
    }
    public  void backtrack(int[] nums, LinkedList<Integer> trace){
        if(trace.size()==nums.length){
            res.add(new LinkedList<>(trace));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(trace.contains(nums[i]))
                continue;
            trace.add(nums[i]);
            backtrack(nums,trace);
            trace.removeLast();
        }

    }

    public int kthGrammar(int N, int K) {
        int[] res=new int[1<<(N-1)];
        if(N==1)
            return res[0];
        for(int i=0;i<N-1;i++)
            for(int j=0;j<(1<<(N-2));j++)
            {
                res[2*j]=res[j]==1?1:0;
                res[2*j+1]=1-res[j];
            }
        return res[K-1];
    }

}

enum Weekday {
    MON(1, "星期一"), TUE(2, "星期二"), WED(3, "星期三"), THU(4, "星期四"), FRI(5, "星期五"), SAT(6, "星期六"), SUN(0, "星期日");

    public final int dayValue;
    public final String chinese;

    private Weekday(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return this.chinese;
    }
}

public class backtrack {

    public static void main(String[] args){
        int[] nums={1,2,3};
        System.out.println(new Test().permute(nums).toString());
        LinkedList<Integer> track=new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<Integer>(new LinkedList<Integer>(track));
        System.out.println(!Boolean.parseBoolean(String.valueOf(0)));
//      System.out.println(new Test().kthGrammar(30,434991989));
        System.out.println(Weekday.SUN.name());
        System.out.println(Weekday.SUN.chinese);
        BigInteger i1 = new BigInteger("1234567890");
        BigInteger i2 = new BigInteger("12345678901234567890");
        BigInteger sum = i1.add(i2); // 12345678902469135780
        System.out.println(sum);

    }
}
