package com.zxa.practice.leetcode.array;

/**
 * @author zhangxinan
 * @Classname StockMaxProfit
 * @Date 2021/4/11 3:47 下午
 */
public class StockMaxProfit {

    /**
     * 暴力解法
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0; i < prices.length; i++){
            for(int j = i; j < prices.length; j++){
                int temp = prices[j] - prices[i];
                max = max > temp ? max : temp;
            }
        }
        return max;

    }

}
