package com.zxa.practice.leetcode.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhangxinan
 * @Classname PostorderTraversal
 * @Date 2021/4/22 9:01 下午
 */
public class PostorderTraversal {
    /**
     * 递归实现
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal0(root, res);
        return res;
    }

    public List<Integer> postorderTraversal0(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        TreeNode prev = null;
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.right == null || root.right == prev) {
                res.add(root.val);
                prev = root;
                root = null;
            } else {
                stack.push(root);
                root = root.right;
            }
        }
        return res;
    }


    public void postorderTraversal0(TreeNode root,List<Integer> res) {
        if(root == null){
            return;
        }
        postorderTraversal0(root.left,res);
        postorderTraversal0(root.right,res);
        res.add(root.val);
    }
}
