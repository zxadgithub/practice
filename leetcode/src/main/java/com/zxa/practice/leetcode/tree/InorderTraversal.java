package com.zxa.practice.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxinan
 * @Classname InorderTraversal
 * @Date 2021/4/7 10:26 下午
 */
public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorderTraversal0(root, list);
        return list;
    }

    private void inorderTraversal0(TreeNode root, List list){
        if(root == null){
            return;
        }
        inorderTraversal0(root.left, list);
        list.add(root.val);
        inorderTraversal0(root.right, list);

    }


}
