package com.leet.array.二分查找;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：你可以设计并实现时间复杂度为 $O(\log n)$ 的算法解决此问题吗？
 */
public class 排序数组中查找元素的第一个和最后一个位置 {

    private static int[] arr = {-1,0,3,5,5, 5, 5, 5, 9,12};

    private static int target = 5;


    /**
     * 左、右分开计算
     */
    public static void main(String[] args) {
        System.out.println(leftPoint(arr, 5));
        System.out.println(rightPoint(arr, 5));

    }


    /**
     * 最左
     */
    private static int leftPoint(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        int point = -1;

        while (left <= right) {
            // 校验最右侧的数据是否小于目标值, 如果小于，说明target不在这个区间
            if (arr[right] < target) {
                break;
            }

            int index = (left + right) / 2;
            if (arr[index] == target) {
                point = index;
            }

            // 区间缩小, 向左
            // 主要要包含等于，等于的时候就继续向左找，知道找到最左边的数据
            if (arr[index] >= target) {
                right = index - 1;
            }
            // 向右
            else {
                left = index + 1;
            }
        }
        return point;
    }


    /**
     * 最右
     */
    private static int rightPoint(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        int point = -1;

        while (left <= right) {
            // 校验最左侧的数据是否大于目标值, 如果大于，说明target不在这个区间，， 处于更左边的区间
            if (arr[left] > target) {
                break;
            }

            int index = (left + right) / 2;
            if (arr[index] == target) {
                point = index;
            }

            // 区间缩小,
            // 向右查找
            // 主要要包含等于，等于的时候就继续向右找，知道找到最右边的数据
            if (arr[index] <= target) {
                left = index + 1;
            }
            // 向左
            else {
                right = index - 1;
            }
        }
        return point;
    }


}

