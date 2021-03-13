package com.zxa.practice.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Queue;
import java.util.Stack;

/**
 * @author zhangxinan
 * @Classname CheckBinaryTreePreOrder
 * 验证二叉树的前序序列化
 *
 * 序列化二叉树的一种方法是使用前序遍历。当我们遇到一个非空节点时，我们可以记录下这个节点的值。如果它是一个空节点，我们可以使用一个标记值记录，例如 #。
 *
 *      _9_
 *     /   \
 *    3     2
 *   / \   / \
 *  4   1  #  6
 * / \ / \   / \
 * # # # #   # #
 * 例如，上面的二叉树可以被序列化为字符串 "9,3,4,#,#,1,#,#,2,#,6,#,#"，其中 # 代表一个空节点。
 *
 * 给定一串以逗号分隔的序列，验证它是否是正确的二叉树的前序序列化。编写一个在不重构树的条件下的可行算法。
 *
 * 每个以逗号分隔的字符或为一个整数或为一个表示 null 指针的 '#' 。
 *
 * 你可以认为输入格式总是有效的，例如它永远不会包含两个连续的逗号，比如 "1,,3" 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/verify-preorder-serialization-of-a-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/3/12 8:43 下午
 */

public class CheckBinaryTreePreOrder {

    /**
     * 栈解决
     * 当一个节点不是叶子节点的时候，那么它必定至少有一个孩子非空！有两种情况：
     *
     * 两个孩子都非"#"（空）；
     * 一个孩子为"#"（空），另一个孩子非"#"（空）；
     * 所以合并 n,#,#为 #
     * @param preorder
     * @return
     */
    public static boolean isValidSerialization(String preorder) {
        Stack<String> stack = new Stack();
        String[] binaryTree = preorder.split(",");
        for (String s : binaryTree) {
            stack.push(s);
            while (stack.size() >= 3) {
                int i = stack.size();
                if (Objects.equals(stack.get(i - 1), "#")
                        && Objects.equals(stack.get(i - 2), "#")
                        && !Objects.equals(stack.get(i - 3), "#")) {
                    stack.pop();
                    stack.pop();
                    stack.pop();
                    stack.push("#");
                } else {
                    break;
                }
            }
        }
        return stack.size() == 1 && stack.pop().equals("#");
    }

    public static void main(String[] args) {
        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(isValidSerialization("1,#"));
        System.out.println(isValidSerialization("9,#,#,1"));

    }


}
