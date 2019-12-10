package com.mianshi.neu;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

/**
 * @program: untitled
 * @description: 并查集相关内容
 * @author: zhaojiawei
 * @create: 2019-12-05 10:31
 */
public class UnionFindSet {
    public static class Node{
        //里面可以是你想要的任何类型
    }
    public static class UnionSet{
       public HashMap<Node,Node>  fatherMap;//表示第一个节点的父亲节点是第二个节点
       public HashMap<Node,Integer> sizeMap;//表示某个节点所在的集合包含节点的数目
       public UnionSet(){
           fatherMap=new HashMap<>();
           sizeMap=new HashMap<>();
       }
       public  void makeSet(List<Node> nodeList){ //给定一个节点列表，初始化并查集
           fatherMap.clear(); //每次初始化前最好清空一下HashMap;
           sizeMap.clear();
           for(Node node:nodeList){
               fatherMap.put(node,node);
               sizeMap.put(node,1);
           }
       }
       public Node findHead(Node node){ //找到某个节点的头节点
//           还可以用下面这种递归方式实现，代码比较简洁
//           Node father=fatherMap.get(node);
//           if(father!=node){
//               father=findHead(father);
//           }
//           fatherMap.put(node,father);
//           return father;
           Stack<Node> stack=new Stack<>();
           Node parent=fatherMap.get(node);
           Node current=node;
           while(parent!=current){
               stack.push(current);
               current=parent;
               parent=fatherMap.get(current);
           }
           while(!stack.isEmpty()){
               fatherMap.put(stack.pop(),parent);
           }
           return parent;
       }
       public boolean isSame(Node a,Node b){
           return findHead(a)==findHead(b);
       }
       public void union(Node a,Node b){
           if(a==null||b==null)
               return;
           Node head1=findHead(a);
           Node head2=findHead(b);
           if(head1!=head2){
               int aSize=sizeMap.get(head1);
               int bSize=sizeMap.get(head2);
               if(aSize<=bSize){
                   fatherMap.put(head1,head2); //将较小节点数的集合挂在较大节点数的集合下面
                   sizeMap.put(head2,aSize+bSize);//同时更新合并后的集合根节点的sizeMap;其它的节点这里不用更新，因为我们只根据根节点来查
               }else{
                   fatherMap.put(head2,head1);
                   sizeMap.put(head1,aSize+bSize);
               }
           }
       }
    }
}
