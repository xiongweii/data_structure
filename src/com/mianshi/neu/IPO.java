package com.mianshi.neu;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: untitled
 * @description:
 * @author: zhaojiawei
 * @create: 2019-12-06 11:16
 */
public class IPO {
    public static class Node{
        private int cost;
        private int profit;
        public Node(int cost,int profit){
            this.cost=cost;
            this.profit=profit;
        }
    }
    public static class minCostComparator implements Comparator<Node>{
        public int compare(Node o1,Node o2){
            return o1.cost-o2.cost;
        }
    }
    public static class maxProfitComparator implements Comparator<Node>{
        public int compare(Node o1,Node o2){
            return o2.profit-o1.profit;
        }
    }
    public static int maxProfit(int[] cost,int[] profit,int w,int k){
        Node[] nodes=new Node[profit.length];
        PriorityQueue<Node> minCostQueue=new PriorityQueue<>(new minCostComparator());
        PriorityQueue<Node> maxProfitQueue=new PriorityQueue<>(new maxProfitComparator());
        for(int i=0;i<profit.length;i++){
            nodes[i]=new Node(cost[i],profit[i]);
            minCostQueue.add(nodes[i]);
        }
        for(int i=0;i<k;i++){
            while(!minCostQueue.isEmpty()&&minCostQueue.peek().cost<=w){
                maxProfitQueue.add(minCostQueue.poll());
            }
            if(maxProfitQueue.isEmpty()){
                return w;
            }
            w+=maxProfitQueue.poll().profit;
        }
        return w;

    }
}
