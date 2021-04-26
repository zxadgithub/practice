package com.zxa.practice.leetcode.first.array;

import com.zxa.practice.leetcode.first.ArrayUtils;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author zhangxinan
 * @Classname TopN
 * @Date 2021/3/14 3:41 下午
 */
public class TopN {

    public static void main(String[] args) {
        int[] integers = {2,3,4,1,4,6};
        System.out.println(topN1(integers, 1));
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }

    /**
     * 快速排序
     * @param arry
     * @param l
     * @param r
     * @param k
     * @return
     */
    public static int  topN(Integer[] arry, int l, int r,int k){
        int point = partition(arry,  l, r);
        if (k == point){
            return arry[point];
        } else {
           return point < k ? topN(arry,point + 1, r, k) :topN(arry, l, point - 1, k);
        }

    }

    /**
     * 优先队列实现，最小堆
     * @param arry
     * @param k
     * @return
     */
    public static int  topN1(int[] arry,int k){
        Queue<Integer> queue = new PriorityQueue<>();
        for (int integer : arry) {
            queue.add(integer);
            if (queue.size() > k){
                queue.poll();
            }
        }
        return queue.peek();
    }

    public static int partition(Integer[] nums, int l, int r){
        int i = l;
        int j = r + 1;
        int p = nums[l];
        while (true){
            while (i < r && nums[++i] <= p ){
            }
            while (j > l && nums[--j] >= p){
            }
            if (i >= j){
                break;
            }
            ArrayUtils.swap(nums, i, j);
        }
        ArrayUtils.swap(nums, l, j);
        return j;
    }

}
