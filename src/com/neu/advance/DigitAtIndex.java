package com.neu.advance;

/**
 * @program: untitled
 * @description: 数字序列中某一位的数字,从0开始计数
 * 剑指offer225页例题
 * @author: zhaojiawei
 * @create: 2020-01-05 15:18
 */
public class DigitAtIndex {
    public static int getAmountOfPlace(int place){//得到n位数字所包含总的数字的个数
        if(place==1)
            return 10;
        return (int)Math.pow(10,place-1)*9;
    }
    public static int getBeginNumOgPlace(int place){//找到place位数开始的第一位数
        if(place==1)
            return 0;
        return (int)Math.pow(10,place-1);
    }
    public static int getDigitAtIndex(int index, int place){
        int beginNum=getBeginNumOgPlace(place);
        int numIndex=beginNum+index/place;//index,place当前对应的实际数字，这里可以理解成index包含几个二位数
        return String.valueOf(numIndex).charAt(index%place)-'0';//把当前数组实际对应的哪个位数求出来
    }
    public static int getDigitAtIndex(int index) {
        if(index<0)
            return -1;
        int place=1;
        while(true){
            int amount=getAmountOfPlace(place);
            int totalamount=amount*place;//当前place位总共占多少位置
            if(totalamount<index){
                place++;
                index-=totalamount;
            }
            return getDigitAtIndex(index, place);
        }
    }
    public static void main(String[] args){
        System.out.println(getDigitAtIndex(19));

    }
}
