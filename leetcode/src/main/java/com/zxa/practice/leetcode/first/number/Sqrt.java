package com.zxa.practice.leetcode.first.number;

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

    public int mySqrt2(int x) {
        if (x == 0) {
            return 0;
        }
        double C = x, x0 = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }

}
