package com.zxj.demo.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by upc on 2019/8/27.
 */
public class Offer1 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public int run(TreeNode root) {
        //if(root==null)return 0;
        //if(root.left==null&&root.right==null)return 1;
        //if(root.left==null)
        // return run(root.right)+1;
        //if(root.right==null)
        // return run(root.left)+1;
        //return Math.min(run(root.left),run(root.right))+1;
        if(root==null)return 0;
        if(root.left==null&&root.right==null)return 1;
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        int count=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(temp.left==null&&temp.right==null){
                    return count;
                }
                if(temp.left!=null){
                    q.offer(temp.left);
                }
                if(temp.right!=null){
                    q.offer(temp.right);
                }
            }
            count++;
        }
        return count;
      }
}
