package com.zxa.practice.leetcode.number;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @author zhangxinan
 * @Classname EvalRPN
 * 根据 逆波兰表示法，求表达式的值。
 * <p>
 * 有效的算符包括 +、-、*、/ 。每个运算对象可以是整数，也可以是另一个逆波兰表达式。
 * <p>
 *  
 * <p>
 * 说明：
 * <p>
 * 整数除法只保留整数部分。
 * 给定逆波兰表达式总是有效的。换句话说，表达式总会得出有效数值且不存在除数为 0 的情况。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 * <p>
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/evaluate-reverse-polish-notation
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date 2021/4/7 10:02 下午
 */
public class EvalRPN {

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        evalRPN.evalRPN(new String[]{"4","13","5","/","+"});
    }

    public int evalRPN(String[] tokens) {

        int length = tokens.length;
        Set<String> op = new HashSet<>();
        op.add("/");
        op.add("+");
        op.add("-");
        op.add("*");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < length; i++) {
            String cur = tokens[i];
            if (op.contains(cur)) {
                Integer b = Integer.valueOf(stack.pop());
                Integer a = Integer.valueOf(stack.pop());
                if ("+".equals(cur)) {
                    stack.push(Integer.toString(a + b));
                } else if ("/".equals(cur)) {
                    stack.push(Integer.toString(a / b));
                } else if ("*".equals(cur)) {
                    stack.push(Integer.toString(a * b));
                } else if ("-".equals(cur)) {
                    stack.push(Integer.toString(a - b));
                }
            } else {
                stack.push(cur);
            }
        }
        return Integer.parseInt(stack.peek());

    }

}
