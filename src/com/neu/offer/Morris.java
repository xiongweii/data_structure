package com.neu.offer;

/**
 * @program: untitled
 * @description: morris遍历
 * 时间复杂度为O(n),额外空间复杂度O(1);
 * 而我们常规的遍历无论是递归还是非递归，空间复杂度都是O(h),h为二叉树的高度
 * 算法思想：来到的当前节点是cur,如果cur无左孩子，则cur=cur.right;
 *           如果cur有左孩子，找到左子树上最右的节点mostRight，分情况讨论：
 *           ①：如果mostRight.right==null,则mostRight.right=cur;cur=cur.left;
 *           ②：如果mostRight.right=cur,则mostRight.right=null;cur=cur.right;
 *           循环结束的条件是cur=null;
 * @author: zhaojiawei
 * @create: 2020-01-20 17:41
 */
public class Morris {
    public static class TreeNode{
        private int val;
        private TreeNode left;
        private TreeNode right;
        public TreeNode(int val){
            this.val=val;
        }
    }
    public static void morris(TreeNode head){//这是morris遍历的一般程序
        //本质：若有左子树，就能回到节点两次；若无左子树，则到达节点一次；且第二次到达时，左子树节点已经遍历完成
        if(head==null)
            return;
        TreeNode cur=head;
        TreeNode mostRight=null;
        while(cur!=null){
            mostRight=cur.left;
            if(mostRight!=null){
                while(mostRight.right!=null&&mostRight.right!=cur)
                    mostRight=mostRight.right;//找到左子树最右的节点
                if(mostRight.right==null)
                {
                    mostRight.right=cur;
                    cur=cur.left;
                }else{
                    mostRight.right=null;
                    cur=cur.right;//这里其实可以和后面的cur=cur.right合并成一步
                }
            }else{//else cur.left==null
                cur=cur.right;
            }
        }
    }
    public static void morrisPre(TreeNode head){//这是morris的先序遍历，注意System.out.print的位置
        //本质：若有左子树，就能回到节点两次；若无左子树，则到达节点一次；且第二次到达时，左子树节点已经遍历完成
        if(head==null)
            return;
        TreeNode cur=head;
        TreeNode mostRight=null;
        while(cur!=null){
            mostRight=cur.left;
            if(mostRight!=null){
                while(mostRight.right!=null&&mostRight.right!=cur)
                    mostRight=mostRight.right;//找到左子树最右的节点
                if(mostRight.right==null)
                {
                    System.out.print(cur.val+" ");//注意这里
                    mostRight.right=cur;
                    cur=cur.left;
                }else{
                    mostRight.right=null;
                    cur=cur.right;//这里其实可以和后面的cur=cur.right合并成一步
                }
            }else{//else cur.left==null
                System.out.print(cur.val+" ");//注意这里，当左子树不存在节点时，在进入右子树时，打印当前节点
                cur=cur.right;
            }
        }
        System.out.println();
    }
    public static void morrisIn(TreeNode head){//这是morris的中序遍历，注意System.out.print的位置
        if(head==null)
            return;
        TreeNode cur=head;
        TreeNode mostRight=null;
        while(cur!=null){
            mostRight=cur.left;
            if(mostRight!=null){
                while(mostRight.right!=null&&mostRight.right!=cur)
                    mostRight=mostRight.right;//找到左子树最右的节点
                if(mostRight.right==null)
                {
                    mostRight.right=cur;
                    cur=cur.left;
                    continue;//后面的cur=cur.right无须执行
                }else{
                    mostRight.right=null;
                    System.out.print(cur.val+" ");//在进入右子树前打印
                    cur=cur.right;//这里其实可以和后面的cur=cur.right合并成一步
                }
            }else{//else cur.left==null
                System.out.print(cur.val+" ");//注意这里，当左子树不存在节点时，在进入右子树时，打印当前节点
                cur=cur.right;
            }
        }
        System.out.println();
    }
    public static void main(String[] args){
        TreeNode head=new TreeNode(1);
        head.left=new TreeNode(2);
        head.right=new TreeNode(3);
        head.left.left=new TreeNode(4);
        head.left.right=new TreeNode(5);
        head.right.left=new TreeNode(6);
        head.right.right=new TreeNode(7);
        morrisPre(head);
        morrisIn(head);
    }
}
