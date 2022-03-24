package com.leet.array;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 *
 * 二分查找
 */
public class 搜索插入位置 {

    private static int[] arr = {-1,0,3,5,9,12};

    private static int target = 4;


    public static void main(String[] args) {


        int left = 0;
        int right = arr.length - 1; // 左闭右闭

        // 注意是否包含等于
        // 先判断循环条件，再计算index， 就包含等于


        while (left <= right) {
            int index = (left + right) / 2;

            if (arr[index] == target) {

                break;
            }

            // 向左找
            if (arr[index] > target) {
                right = index - 1;
                continue;
            }

            // 向右找
            left = index + 1;
        }

        System.out.println(left); // 直接取left。 区间越来越小，最后left的位置就是 大于等于 target的第一个数据
    }

}
