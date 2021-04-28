package com.zxa.practice.leetcode.first.tree;

import com.sun.javafx.collections.MappingChange;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangxinan
 * @Classname a
 * @Date 2021/4/28 10:09 下午
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class BuildTreeByPreAndInOrder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length != inorder.length){
            return null;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < preorder.length ;i++){
            map.put(inorder[i], i);
        }

        return buildTree0(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, map);
    }

    public TreeNode buildTree0(int[] preorder, int[] inorder, int preL, int preR, int inL,int inR, Map<Integer,Integer> map){
        if(preL > preR || inL > inR){
            return null;
        }
        int root = preorder[preL];
        TreeNode tree = new TreeNode(root);
        int index = map.get(root);
        tree.left = buildTree0(preorder, inorder, preL + 1, index- inL + preL, inL, index - 1, map);
        tree.right = buildTree0(preorder, inorder, index- inL + preL + 1, preR, index + 1, inR, map);

        return tree;
    }
}
