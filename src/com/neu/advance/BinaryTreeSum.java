package com.neu.advance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: untitled
 * @description:
 * @author: zhaojiawei
 * @create: 2019-12-29 12:30
 */
public class BinaryTreeSum {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
    private static ArrayList<ArrayList<Integer>> res=new ArrayList<>();
    public static void FindPath2(TreeNode root,int num,ArrayList<Integer> list){
        if(root==null)
            return;
        list.add(root.val);
        if(root.val==num)
        {
            res.add(new ArrayList<>(list));
        }
        FindPath2(root.left,num,list);
        FindPath2(root.right,num,list);

        list.remove(list.size()-1);

    }
    public static void FindPath(TreeNode root,int target,ArrayList<Integer> list){
        if(root==null)
            return;
        int temp=root.val;
        list.add(temp);
        target-=temp;

        if(target==0&&root.left==null&&root.right==null)
        {
            res.add(new ArrayList<>(list));
        }
        FindPath(root.left,target,list);
        FindPath(root.right,target,list);

        list.remove(list.size()-1);


    }
    private static StringBuffer s=new StringBuffer();
   public static  String Serialize(TreeNode root) {
       if(root==null){
           return"#";
       }
       return root.val+"!"+Serialize(root.left)+Serialize(root.right);
    }
    public static  ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        FindPath(root,target,new ArrayList<Integer>());
        return res;
    }
    public static void main(String[] args){
         TreeNode root=new TreeNode(10);
         root.left=new TreeNode(5);
         root.right=new TreeNode(12);
         root.left.left=new TreeNode(4);
         root.left.right=new TreeNode(7);
         root.left.left.left=new TreeNode(4);
         System.out.println( Serialize(root));
         String  rr="abcd";
         String[] rrr=rr.split("!");
        Queue<String> queue=new LinkedList<>();

//        FindPath2(root,12,new ArrayList<>());
//         System.out.println(res);
////         System.out.println(FindPath(root,22));
//       HashMap<Integer,Integer> hash=new HashMap<>();

    }
}
