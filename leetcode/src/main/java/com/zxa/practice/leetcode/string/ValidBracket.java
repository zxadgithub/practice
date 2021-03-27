package com.zxa.practice.leetcode.string;

import java.util.Stack;

/**
 * @author zhangxinan
 * @Classname ValidBracket
 * @Date 2021/3/27 4:12 下午
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidBracket {

    public boolean isValid(String s) {
        if (s == null ){
            return false;
        }
        int length = s.length();
        if (length <= 1){
            return false;
        }

        Stack<Character> stack = new Stack();
        for (int i = 0; i < length; i++) {
            if (!stack.isEmpty()){
                Character peek = stack.peek();
                if (peek == '(' && s.charAt(i) == ')'){
                    stack.pop();
                    continue;
                } else if (peek == '[' && s.charAt(i) == ']'){
                    stack.pop();
                    continue;
                }else if (peek == '{' && s.charAt(i) == '}'){
                    stack.pop();
                    continue;
                } else {
                    stack.push(s.charAt(i));
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }

}
