package com.mianshi.neu;

import java.util.HashMap;

/**
 * @program: untitled
 * @description: 前缀树
 * @author: zhaojiawei
 * @create: 2019-12-05 17:13
 */
public class TrieTree {
    public static class TreeNode{
        public int path;
        public int end;
        public HashMap<Character,TreeNode> next;//每个节点都对应一个TreeNode
        public TreeNode(){
                path=0;
                end=0;
                next=new HashMap<>();
        }
    }
    public static class Tree{
        private TreeNode root;
        public Tree(){
            root=new TreeNode();
        }
        public void insert(String data){//将指定字符串插入前缀树中
            if(data==null)
                return;
            char[] datas=data.toCharArray();
            TreeNode node=root;
            for(char c:datas){
                if(node.next.get(c)==null){
                    node.next.put(c,new TreeNode());
                }
                node=node.next.get(c);
                node.path++;
            }
            node.end++;
        }
        public int search(String data){ //查找一个字符串是否出现在前缀树中，若存在则返回该字符串在前缀树中出现的次数
            if(data==null)
                return 0;
            char[] datas=data.toCharArray();
            TreeNode node=root;
            for(char c:datas){
                if(node.next.get(c)==null){
                   return 0;
                }
                node=node.next.get(c);
            }
            return node.end;
        }
        public void delete(String data){//在前缀树中删除某个字符串
                if(data==null)
                     return;
                if(search(data)!=0){//如果有该字符串才删除
                    char[] datas=data.toCharArray();
                    TreeNode node=root;
                    for(char c:datas){
                        if(--node.next.get(c).path==0){ //若当前节点的path减完之后为0，则后面的直接赋null。
                           node.next.put(c,null);
                           return;
                        }
                        node=node.next.get(c);
                    }
                    node.end--;
                }
        }
        public int prefixNumber(String pre) {//查找给定字符串，有多少个字符串以它作为前缀
            if(pre==null)
                return 0;
            char[] datas=pre.toCharArray();
            TreeNode node=root;
            for(char c:datas){
                if(node.next.get(c)==null){ //若有一个字符不存在该前缀树中，直接返回0，说明不存在以该字符串为前缀的词
                    return 0;
                }
                node=node.next.get(c);
            }
            return node.path;
        }

    }
    public static void main(String[] args){
          Tree trie = new Tree();
        System.out.println(trie.search("zhao"));
        trie.insert("zhao");
        System.out.println(trie.search("zhao"));
        trie.delete("zhao");
        System.out.println(trie.search("zhao"));
        trie.insert("zhao");
        trie.insert("zhao");
        trie.delete("zhao");
        System.out.println(trie.search("zhao"));
        trie.delete("zhao");
        System.out.println(trie.search("zhao"));
        trie.insert("zhaoa");
        trie.insert("zhaoac");
        trie.insert("zhaoab");
        trie.insert("zhaoad");
        trie.delete("zhaoa");
        System.out.println(trie.search("zhaoa"));
        System.out.println(trie.prefixNumber("zhao"));
        trie.insert("abc");
        trie.insert("abc");
        trie.insert("kgf");
        trie.insert("kgzt");
        trie.delete("kgzt");
        System.out.println(trie.search("kgf"));
    }
}
