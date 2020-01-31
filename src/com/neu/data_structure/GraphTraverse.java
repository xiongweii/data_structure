package com.neu.data_structure;

import java.util.LinkedList;

/**
 * @program: untitled
 * @description: 图的深度和广度遍历算法
 * @author: zhaojiawei
 * @create: 2020-01-30 19:32
 */
public class GraphTraverse {
    public static void main(String[] args){
        Graph g=new Graph(6);
        g.list[0].add(1);
        g.list[0].add(2);
        g.list[0].add(3);

        g.list[1].add(0);
        g.list[1].add(3);
        g.list[1].add(4);

        g.list[2].add(0);

        g.list[3].add(0);
        g.list[3].add(1);
        g.list[3].add(4);
        g.list[3].add(5);

        g.list[4].add(1);
        g.list[4].add(3);
        g.list[4].add(5);

        g.list[5].add(3);
        g.list[5].add(4);

        System.out.println("图的深度优先遍历：");
        g.DFGraph(g,0,new boolean[g.size]);
        System.out.println();
        System.out.println("图的广度优先遍历：");
        g.BFGraph(g,5,new boolean[g.size],new LinkedList<>());
    }
}
class Vertex{
    int data;
    public Vertex(int data){
        this.data=data;
    }
}
class Graph{//领接表存储图，初始化
     int size;
     Vertex[] vertices;
     LinkedList<Integer>[] list;
    public Graph(int size){
        this.size=size;
        vertices=new Vertex[size];
        list=new LinkedList[size];
        for(int i=0;i<size;i++){
            vertices[i]=new Vertex(i);
            list[i]=new LinkedList<>();
        }
    }
    public void DFGraph(Graph g,int start,boolean[] visited){
        System.out.print(g.vertices[start].data+" ");
        visited[start]=true;
        for(int index:g.list[start]){
            if(!visited[index]){
                DFGraph(g,index,visited);
            }
        }
    }
    public void BFGraph(Graph g,int start,boolean[] visited,LinkedList<Integer> queue){
        queue.add(start);
        while(!queue.isEmpty()){
            int front=queue.poll();
            if(!visited[front]){
                System.out.print(g.vertices[front].data+" ");
                visited[front]=true;
                for(int index:g.list[front]){
                    queue.add(index);
                }
            }


        }
    }
}

