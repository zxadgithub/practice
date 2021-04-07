package com.zxa.practice.leetcode.dp;

/**
 * @author zhangxinan
 * @Classname NumWays
 * @Date 2021/4/7 9:43 下午
 */
public class NumWays {

    /**
     * 数组存储每次结果
     * @param n
     * @return
     */
    public int numWays(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int[] res = new int[n];
        res[0] = 1;
        res[1] = 2;
        for(int i = 2; i< n; i++){
            res[i] = (res[i - 1] % 1000000007) + (res[i - 2] % 1000000007);
        }
        return res[n - 1] % 1000000007;
    }

    /**
     * 只存储最近两次结果
     * @param n
     * @return
     */
    public int numWays2(int n) {
        if(n == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int a = 1;
        int b = 2;
        int sum = 0;
        for(int i = 2; i< n; i++){
            sum = (a % 1000000007) + (b % 1000000007);
            a = b;
            b = sum;
        }
        return sum % 1000000007;
    }

}
