package com.mianshi.neu;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @program: untitled
 * @description: 如何安排会议
 * @author: zhaojiawei
 * @create: 2019-12-06 13:23
 */
public class BeatArranges {
    public static class Programs{
        private int start;
        private int end;
        public Programs(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    public static class EarliestEndComparator implements Comparator<Programs>{
        public int compare(Programs o1,Programs o2){
            return o1.end-o2.end;//这里的贪心策略按照哪个项目结束时间早，就做哪个项目
        }
    }
    public static int MaxPrograms(Programs[] programs,int currentTime){
        Arrays.sort(programs,new EarliestEndComparator());
        int count=0;
        for(int i=0;i<programs.length;i++){
            if(currentTime<=programs[i].start){
                count++;
                currentTime=programs[i].end;
            }
        }
        return count;
    }
    public static void main(String[] args){

    }
}
