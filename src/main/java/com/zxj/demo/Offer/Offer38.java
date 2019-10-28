package com.zxj.demo.Offer;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by upc on 2019/9/12.
 */
public class Offer38 {
    /**
     * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public int TreeDepth1(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(TreeDepth1(root.left), TreeDepth1(root.right)) + 1;
    }
    public int TreeDepth(TreeNode root) {
        if(root==null)
            return 0;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();
        queue.offer(root);
        int dep=0,count=0,current=1;
        while(!queue.isEmpty()){
            TreeNode node=queue.poll();
            count++;
            if(node.left!=null){
                queue.offer(node.left);
            }
            if(node.right!=null){
                queue.offer(node.right);
            }
            if(count==current){
                current=queue.size();
                count=0;
                dep++;
            }
        }
        return dep;
    }
}
