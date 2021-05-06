package com.zxa.practice.leetcode.first.array;

/**
 * @author zhangxinan
 * @Classname LengthInOrderSUn
 * @Date 2021/4/29 7:15 下午
 */
public class LengthInOrderSub {

    public static void main(String[] args) {
        LengthInOrderSub lengthInOrderSub = new LengthInOrderSub();
        System.out.println(lengthInOrderSub.lengthInOrderSub(new int[]{0,1,0,3,2,3}));
    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }


    public int lengthInOrderSub(int[] nums){
        int max = 0;
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int pre = nums[i];
            int curMax = 1;
            for (int j = i; j < length; j++) {
                if (pre < nums[j]){
                    curMax++;
                    pre = nums[j];
                }
            }
            max = Math.max(max, curMax);
        }
        return max;

    }

}
