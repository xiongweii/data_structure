package com.neu.offer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
/**
 * @program: untitled
 * @description: 找到一维数组中的重复数字
 * @author: zhaojiawei
 * @create: 2019-12-20 20:37
 */
public class Duplicated {
    private int rows;
    private int cols;
    public char[][] buildMatrix(char[] array,int rows,int cols){
        char[][] matrix=new char[rows][cols];
        int index=0;
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
                matrix[i][j]=array[index++];
        return matrix;
    }
    public boolean backtracking(char[][] mat,int row,int col,boolean[][] isVisited,char[] str,int length){
        if(length==str.length)
            return true;
        if(row<0||row>=rows||col<0||col>=cols||isVisited[row][col]||mat[row][col]!=str[length])
            return false;
        isVisited[row][col]=true;
        if(backtracking(mat,row+1,col,isVisited,str,++length)||backtracking(mat,row-1,col,isVisited,str,++length)||backtracking(mat,row,col+1,isVisited,str,++length)||backtracking(mat,row,col-1,isVisited,str,++length))
            return true;
        isVisited[row][col]=false;
        return false;
    }
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        this.rows=rows;
        this.cols=cols;
        boolean[][] isVisited=new boolean[rows][cols];
        char[][] mat=buildMatrix(matrix,rows,cols);
        for(int i=0;i<rows;i++)
            for(int j=0;j<cols;j++)
            {
                if(backtracking(mat,i,j,isVisited,str,0))
                    return true;
                else
                    return false;
            }
        return false;
    }
    public int cutRope(int target) {
        if(target<2)
            return 1;
        if(target==2)
            return 1;
        if(target==3)
            return 2;
        int[] res=new int[target+1];
        res[1]=1;
        res[2]=1;
        res[3]=2;
        for(int i=4;i<=target;i++)
        {   int max=0;
            for(int j=1;j<i;j++)
            {
                if(max<res[j]*res[i-j])
                    max=res[j]*res[i-j];
            }
            res[i]=max;
        }
        return res[target];
    }



    public static ArrayList<Integer> list=new ArrayList<>();
    public static void swap(int[] num, int i, int j) {
        int temp = num[i];
        num[i] = num[j];
        num[j] = temp;
    }
    public static class ListNode {
        int val;
        ListNode next = null;
           ListNode(int val) {
           this.val = val;
        }
   }

    public static boolean findDuplicated(int[] num) {
        if (num == null || num.length <= 1) {
            return false;
        }
        for (int i = 0; i < num.length; i++) {
            if (num[i] < 0 || num[i] > num.length - 1)
                return false;
        }
        int i;
        for (i = 0; i < num.length; i++) {
            while (num[i] != i) {
                if (num[i] == num[num[i]]) {
                    System.out.println(num[i]);
                    break;
                }
                swap(num, i, num[i]);
            }
        }
        return false;

    }

    public static String replaceBlack(StringBuilder str) {
        int p1=str.length()-1;
        for (int i = 0; i <=p1; i++) {
            if (str.charAt(i) == ' ')
              str.append("  ");
        }
        int p2=str.length()-1;
        while(p2!=p1){
            if(str.charAt(p1)==' '){
                str.setCharAt(p2--,'0');
                str.setCharAt(p2--,'2');
                str.setCharAt(p2--,'%');
                p1--;
            }else{
                str.setCharAt(p2--,str.charAt(p1--));
            }
        }
        return str.toString();
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        Stack<Integer> stack=new Stack<>();
        while(listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> list=new ArrayList<>();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> list=new ArrayList<>();
        if(listNode!=null){
            list.addAll(printListFromTailToHead2(listNode.next));
            list.add(listNode.val);
        }
        return list;
    }
    public static ArrayList<Integer> headInsert(ListNode node){
        ArrayList<Integer> list=new ArrayList<>();
        ListNode head=new ListNode(-1);
        ListNode p=node;
        while(p!=null){
            ListNode next=p.next;
            p.next=head.next;
            head.next=p;
            p=next;
        }
        p=head.next;
        while(p!=null){
            list.add(p.val);
            p=p.next;
        }
        return list;
    }
    public static class TreeNode {
         char val;
         TreeNode left;
         TreeNode right;
         TreeNode parent;
        TreeNode(char x) { val = x; }
    }
    public static TreeNode nextInorder(TreeNode node){
        if(node==null)
            return null;
        if(node.right!=null){
            TreeNode p=node.right;
            while(p.left!=null){
                p=p.left;
            }
            return p;
        }else{
            if(node.parent!=null&&node.parent.left==node)
                return node.parent;
            else{
                TreeNode p=node;
                while(node.parent!=null&&node.parent.left!=node){
                    node=node.parent;
                }
                return node.parent;
            }
        }
    }
    public static int getOne(int num){ //会无限循环，因为负数的右移的性质
        int count=0;
        while(num!=0){
            if((num&1)!=0)
                count++;
            num=num>>1;
        }
        return count;
    }
    /*
    * 打印从1-到最大的n位数
    *
    * */
    public static boolean Increment(char[] num){
        int takeOver=0;
        boolean overFlow=false;
        for(int i=num.length-1;i>=0;i--)
        {
            int data=num[i]-'0'+takeOver;
            if(i==num.length-1)
                data++;
            if(data>=10){
                if(i==0)
                    overFlow=true;
                else{
                    data-=10;
                    takeOver=1;
                    num[i]=(char)('0'+data);
                }
            }else{
                num[i]=(char)('0'+data);
                break;
            }
        }
        return overFlow;
    }
    public static void PrintNum(char[] num){
        boolean key=false;
        for(int i=0;i<num.length;i++){
            if(num[i]!='0'){
                key=true;
            }
            if(key)
                System.out.print(num[i]);
        }
        System.out.println();
    }
    public static void Print1ToMaxDigit(int n){
        if(n<=0)
            return;
        char[] arr=new char[n];
        Arrays.fill(arr,'0');
        while(!Increment(arr)){
            PrintNum(arr);
        }
    }

    //换种思维，可以用全排列来解决,用递归解决更方便
    public static void Print1ToMaxDigit2(int n){
        if(n<=0)
            return;
        char[] arr=new char[n];
        Arrays.fill(arr,'0');
        print1ToMaxOfNDigits(arr,0);
    }
    public static void print1ToMaxOfNDigits(char[]num,int index){
        if(index==num.length){
            PrintNum(num);
            return;
        }

        for(int i=0;i<=9;i++){//每个位数上可能有0-9个字符可能的取值
            num[index]=(char)(i+'0');
            print1ToMaxOfNDigits(num,index+1);
        }
    }
//    public static class Solution {//重构二叉树
//        public TreeNode Construct(int preL,int preR,int inL,int inR,int[] in,int[] pre){
//            if(inL>inR)
//                return null;
//            TreeNode root=new TreeNode(pre[preL]);
//            int i;
//            for(i=inL;i<=inR;i++)
//                if(in[i]==pre[preL])
//                    break;
//            int numleft=i-inL;
//            root.left=Construct(preL+1,preL+numleft,inL,inL+numleft-1,in,pre);
//            root.right=Construct(preL+numleft+1,preR,i+1,inR,in,pre);
//            return root;
//        }
//        public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
//            return Construct(0,pre.length-1,0,in.length-1,in,pre);
//        }
//    }
    public static void main(String[] args) {
        double b,c;

        TreeNode root=new TreeNode('a');
        root.right=new TreeNode('c');
        root.left=new TreeNode('b');
        root.left.parent=root;
        root.right.parent=root;
        root.left.left=new TreeNode('d');
        root.left.left.parent=root.left;
        root.left.right=new TreeNode('e');
        root.left.right.parent=root.left;
        System.out.println(nextInorder( root.left.right).val);
        //System.out.println(getOne(-10));
        System.out.println(-0==0);
//        char[] num=new char[2];
//        Arrays.fill(num,'0');
//        System.out.println(num[0]=='0');
        //Print1ToMaxDigit(5);
        Print1ToMaxDigit2(3);
    }
}