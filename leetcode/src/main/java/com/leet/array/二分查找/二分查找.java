package com.leet.array.二分查找;

/**
 * 二分查找
 *
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 *
 * 这道题目的前提是
 *  1. 数组为有序数组。
 *  2。强调数组中无重复元素。
 *      因为一旦有重复元素，使用二分查找法返回的元素下标可能不是唯一的，这些都是使用二分法的前提条件，当大家看到题目描述满足如上条件的时候，可要想一想是不是可以用二分法了。
 */
public class 二分查找 {


    private static int[] arr = {-1,0,3,5,9,12};

    private static int target = 2;


    public static void main(String[] args) {
        System.out.println(search(arr, target, 0, arr.length - 1));

        System.out.println(loopSearch(arr, target));
    }

    /**
     * 递归查询
     *
     * index： 当前查询的位置
     *
     * [left, right]
     */
    private static int search(int[] arr, int target, int left, int right) {

        // 查询中间位置的坐标
        int index = (left + right) / 2;

        if (arr[index] == target) {
            return index;
        }

        // 如果 left == right 的情况， index = left = right， 所以这里如果left = right也要直接退出
        if (left >= right) {
            return -1;
        }

        // 二分查找, 1. 比较大小

        // 向左找
        if (arr[index] > target) {
            return search(arr, target, left, index - 1);
        }

        // 向右找
        return search(arr, target, index + 1, right);
    }


    /**
     * 循环查询
     */
    private static int loopSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1; // 左闭右闭

        // 注意是否包含等于
        // 先判断循环条件，再计算index， 就包含等于

        while (left <= right) {
            int index = (left + right) / 2;

            if (arr[index] == target) {
                return index;
            }

            // 向左找
            if (arr[index] > target) {
                right = index - 1;
                continue;
            }

            // 向右找
            left = index + 1;
        }
        return -1;
    }


}
