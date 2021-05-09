package com.zxa.practice.leetcode.first.array;

import java.util.Random;

/**
 * @author zhangxinan
 * @Classname Shu
 * @Date 2021/5/9 5:06 下午
 * 给你一个整数数组 nums ，设计算法来打乱一个没有重复元素的数组。
 *
 * 实现 Solution class:
 *
 * Solution(int[] nums) 使用整数数组 nums 初始化对象
 * int[] reset() 重设数组到它的初始状态并返回
 * int[] shuffle() 返回数组随机打乱后的结果
 *  
 *
 * 示例：
 *
 * 输入
 * ["Solution", "shuffle", "reset", "shuffle"]
 * [[[1, 2, 3]], [], [], []]
 * 输出
 * [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
 *
 * 解释
 * Solution solution = new Solution([1, 2, 3]);
 * solution.shuffle();    // 打乱数组 [1,2,3] 并返回结果。任何 [1,2,3]的排列返回的概率应该相同。例如，返回 [3, 1, 2]
 * solution.reset();      // 重设数组到它的初始状态 [1, 2, 3] 。返回 [1, 2, 3]
 * solution.shuffle();    // 随机返回数组 [1, 2, 3] 打乱后的结果。例如，返回 [1, 3, 2]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/shuffle-an-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Shuffle {

    int[] init;
    Random random = new Random();

    public Shuffle(int[] nums) {
        int length = nums.length;
        init = new int[length];
        for(int i = 0;i < length;i++){
            init[i] = nums[i];
        }
    }

    private int[] copy(){
        int[] copy = new int[init.length];
        int length = init.length;
        for(int i = 0;i < length;i++){
            copy[i] = init[i];
        }
        return copy;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return init;
    }

    private int randomRange(int min, int max){
        return random.nextInt(max - min) + min;
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int size = init.length;
        int[] copy = copy();
        for(int i = 0; i < size; i++){
            swap(copy, i, randomRange(i, size));
        }
        return copy;
    }

}
