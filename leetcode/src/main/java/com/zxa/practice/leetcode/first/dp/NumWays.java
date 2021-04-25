package com.zxa.practice.leetcode.first.dp;

/**
 * @author zhangxinan
 * @Classname NumWays
 * @Date 2021/4/7 9:43 下午
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
