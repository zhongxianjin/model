package com.zxj.demo.Offer;

import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Created by upc on 2019/9/14.
 */
public class Offer60 {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<>();
        if(pRoot==null)return result;
        Queue<TreeNode> queue=new LinkedList<>();

        queue.offer(pRoot);
        int start=0,end=1;
        ArrayList<Integer> temp=new ArrayList<>();
        while(!queue.isEmpty()){
            TreeNode root=queue.poll();
            start++;
            temp.add(root.val);
            if(root.left!=null)queue.offer(root.left);
            if(root.right!=null)queue.offer(root.right);
            if(start==end){
                result.add(temp);
                start=0;
                temp=new ArrayList<Integer>();
                end=queue.size();
            }
        }
        return result;
    }
//    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
//        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
//        if (pRoot == null) return result;
//        Queue<TreeNode> queue = new LinkedList<>();
//        Queue<TreeNode> queue1 = new LinkedList<>();
//        queue.offer(pRoot);
//        int layer = 0;
//        while (!queue.isEmpty() || !queue1.isEmpty()) {
//            if (layer % 2 == 0) {
//                ArrayList<Integer> temp = new ArrayList<>();
//                while (!queue.isEmpty()) {
//                    TreeNode root = queue.poll();
//                    temp.add(root.val);
//                    if (root.left != null) queue1.offer(root.left);
//                    if (root.right != null) queue1.offer(root.right);
//                }
//                result.add(temp);
//                layer++;
//            } else {
//                ArrayList<Integer> temp = new ArrayList<>();
//                while (!queue1.isEmpty()) {
//                    TreeNode root = queue1.poll();
//                    temp.add(root.val);
//                    if (root.left != null) queue.offer(root.left);
//                    if (root.right != null) queue.offer(root.right);
//                }
//                result.add(temp);
//                layer++;
//            }
//        }
//        return result;
//    }
}
