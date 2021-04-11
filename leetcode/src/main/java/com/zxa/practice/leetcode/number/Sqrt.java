package com.zxa.practice.leetcode.number;

/**
 * @author zhangxinan
 * @Classname Sqrt
 * @Date 2021/4/11 5:22 下午
 */
public class Sqrt {

    public int mySqrt(int x) {
       return (int)Math.sqrt(x);
    }

    public int mySqrt1(int x) {
        int l = 0, r = x, ans = -1;
        while (l <= r){
            int mid = l + ((r - l) >>> 2);
            if ((long)mid * mid <= x){
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }


        }
        return ans;
    }

}
