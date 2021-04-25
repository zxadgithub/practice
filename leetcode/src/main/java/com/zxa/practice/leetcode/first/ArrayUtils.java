package com.zxa.practice.leetcode.first;

/**
 * @author zhangxinan
 * @Classname ArrayUtils
 * @Date 2021/3/14 3:43 下午
 */
public class ArrayUtils {

    public static void main(String[] args) {
        Integer[] arr = {1, 3};
        swap(arr, 0, 1);
        System.out.println(arr[0] + "===" + arr[1]);
    }

    public static void swap(Object[] array, int a, int b){
        Object temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }
}
