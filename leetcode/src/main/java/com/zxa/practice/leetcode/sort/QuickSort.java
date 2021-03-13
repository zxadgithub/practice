package com.zxa.practice.leetcode.sort;

/**
 * @author zhangxinan
 * @Classname QuckSort
 * @Date 2021/3/13 5:33 下午
 */
public class QuickSort {

    public static void main(String[] args) {
        Integer[] integers = {2, 13, 454, 6, 67, 32, 1};
        quickSort(integers, 0, integers.length - 1);
        System.out.println(integers);
    }


    public static void quickSort(Integer[] array, int l ,int r){
        if (l >= r){
            return;
        }
        int partition = partition(array, l, r);
        quickSort(array, l, partition - 1);
        quickSort(array, partition + 1, r);


    }

    public static int partition(Integer[] array, int l, int r) {
        int p = array[l];
        int i = l, j = r+1;
        while (true) {
            while (array[++i] < p) {
                if (i == r){
                    break;
                }
            }
            while (array[--j] > p) {
                if (j == l){
                    break;
                }
            }
            if ((i >= j)) {
                 break;
            }
            compareAndSwap(array, i, j);
        }
        compareAndSwap(array, l, j);
        return j;
    }

    private static void compareAndSwap(Integer[] array, int l, int r) {
        if (array[l] <= array[r]){
            return;
        }
        int temp = array[l];
        array[l] = array[r];
        array[r] = temp;
    }

}
