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

    /**
     * 动态记录最低价格，每天和最低价格比较
     * @param prices
     * @return
     */
    public int maxProfit1(int[] prices) {
        int max = 0;
        int minPrice = prices[0];
        for(int i = 0; i < prices.length; i++){
            int tempMin = prices[i] - minPrice;
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else if (max < tempMin) {
                max = tempMin;
            }
        }
        return max;
    }

}
