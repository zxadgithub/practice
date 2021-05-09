package com.zxa.practice.leetcode.first.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhangxinan
 * @Classname s
 * @Date 2021/5/9 4:05 下午
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 *
 *
 *
 * 示例 1：
 * 1 > 2 > 3
 *
 * 8 < 9  < 4
 *
 * 7  6  5
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 */
public class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int cur = 1;
        int max = n * n;
        while(cur <= max){
            for(int i = l; i <= r; i++){
                res[t][i] = cur++;
            }
            t++;
            for(int i = t; i <= b; i++){
                res[i][r] = cur++;
            }
            r--;
            for(int i = r; i >= l; i--){
                res[b][i] = cur++;
            }
            b--;
            for(int i = b; i >= t; i--){
                res[i][l] = cur++;
            }
            l++;
        }
        return res;

    }

}
