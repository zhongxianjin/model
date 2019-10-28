package com.zxj.demo.Offer;

import java.util.Stack;

/**
 * Created by upc on 2019/9/14.
 */
public class Offer58 {
    /**
     * 请实现一个函数，用来判断一颗二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
     */
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
//    boolean isSymmetrical(TreeNode pRoot){
//        if(pRoot==null)return true;
//        Stack<TreeNode> stack=new Stack<>();
//        stack.push(pRoot.left);
//        stack.push(pRoot.right);
//        while(!stack.isEmpty()){
//            TreeNode right=stack.pop();
//            TreeNode left=stack.pop();
//            if(left == null && right == null) continue;
//            if(left == null || right == null) return false;
//            if(left.val != right.val) return false;
//            //成对插入
//            stack.push(left.left);
//            stack.push(right.right);
//            stack.push(right.left);
//            stack.push(left.right);
//        }
//        return true;
//    }
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return monitor(pRoot.left, pRoot.right);
    }

    boolean monitor(TreeNode left, TreeNode right) {
        if (left == null) return right == null;
        if (right == null) return false;
        if (left.val != right.val) return false;
        return monitor(left.right, right.left) && monitor(left.left, right.right);
    }
}
