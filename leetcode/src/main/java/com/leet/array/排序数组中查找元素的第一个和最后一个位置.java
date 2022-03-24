package com.leet.array;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 *
 * 进阶：你可以设计并实现时间复杂度为 $O(\log n)$ 的算法解决此问题吗？
 */
public class 排序数组中查找元素的第一个和最后一个位置 {

    private static int[] arr = {-1,0,3,5,9,12};

    private static int target = 4;


    /**
     * 左、右分开计算
     */
    public static void main(String[] args) {



    }


    /**
     * 最左
     */
    private static int leftPoint(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {



        }
        return -1;
    }

}
