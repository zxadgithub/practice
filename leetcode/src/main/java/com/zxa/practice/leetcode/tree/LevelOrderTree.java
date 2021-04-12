package com.zxa.practice.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author zhangxinan
 * @Classname LevelOrderTree
 * @Date 2021/4/11 6:06 下午
 */
public class LevelOrderTree {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()){
            int n = stack.size();
            List<Integer> cur = new ArrayList<>();
            res.add(cur);
            for (int i = 0; i < n; i++) {
                TreeNode node = stack.poll();
                cur.add(node.val);
                if (node.left != null){
                    stack.add(node.left);
                }
                if (node.right != null){
                    stack.add(node.right);
                }
            }


        }

        return res;

    }
}
