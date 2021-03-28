package com.zxa.practice.leetcode.string;

/**
 * @author zhangxinan
 * @Classname AddStrings
 * @Date 2021/3/28 5:20 下午
 */
public class AddStrings {

    public static void main(String[] args) {
        AddStrings addStrings = new AddStrings();
        addStrings.addStrings("123", "45");
    }

    public String addStrings(String num1, String num2) {

        if (num1 == null || num1.length() == 0){
            return num2;
        }
        if (num2 == null || num2.length() == 0){
            return num1;
        }
        int length1 = num1.length();
        int length2 = num2.length();
        //一定要用stringBuilder
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int maxLength = Math.max(length1, length2);
        for (int i = 1; i <= maxLength; i++) {
            int a = 0, b = 0;
            if (i <= length1){
                a = num1.charAt(length1 - i) - '0';
            }
            if (i <= length2){
                b = num2.charAt(length2 - i) - '0';
            }
            int sum = a + b + carry;
            carry = sum / 10;
           res.append(sum % 10);
        }
        if (carry != 0){
            res.append(carry);
        }
        return res.reverse().toString();

    }
}
