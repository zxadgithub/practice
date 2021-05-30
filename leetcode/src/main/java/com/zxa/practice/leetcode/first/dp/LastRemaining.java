package com.zxa.practice.leetcode.first.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxinan
 * @Classname LastRemaining
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 *
 * 输入: n = 10, m = 17
 * 输出: 2
 * @Date 2021/5/20 10:39 下午
 */
public class LastRemaining {

    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList(n);
        for (int i = 0; i < n; i++) {
            list.add(n);
        }

        int idx = 0;
        while (n > 1){
            idx = (idx + m - 1) % n;
            n--;
        }
        return list.get(0);
    }

    public int lastRemaining1(int n, int m) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = (res + m) % i;
        }
        return res;
    }

}
