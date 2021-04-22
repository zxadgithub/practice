package com.zxa.practice.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

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

    public void postorderTraversal0(TreeNode root,List<Integer> res) {
        if(root == null){
            return;
        }
        postorderTraversal0(root.left,res);
        postorderTraversal0(root.right,res);
        res.add(root.val);
    }
}
