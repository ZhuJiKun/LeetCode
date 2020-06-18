package com.leet.code;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * see https://leetcode-cn.com/problems/container-with-most-water/
 */
public class MaxArea {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0, right = height.length - 1;
        maxArea = (right - left) * Math.min(height[left], height[right]);

        while (right > left) {
            int width = right - left - 1;

            // 每次都移动较低的那条线
            if (height[left] >= height[right]) {
                maxArea = Math.max(maxArea, Math.min(height[--right], height[left]) * width);
            } else {
                maxArea = Math.max(maxArea, Math.min(height[++left], height[right]) * width);
            }
        }

        return maxArea;
    }

}


/*
 * 正确的思路：
 *   维护两个指针，分别从左向右，从右向左，和之前的最大值比较
 *
 *   面积 = 高度 * 宽度， 高度为低的那一条边。
 *   如果存在 x > y 两个高度，整个面积受制于y， 移动x的坐标并不会增加面积，因为高度还是y。
 *   相反，移动y则有可能增加高度，因为y后面的数值可能大于y
 *
 *   所以要移动两条边较低的那一条。
 *
 *
 * 第一次错误的思路
 * 可以维护2个指针，分别从左向右，从右向左，和之前的最大值比较
 * 分析：
 *   开始的 left的坐标是0， right的坐标是n
 *   当前的面积是 (n - 0) * min(height(0), height(n))
 *
 *   左指针，向右遍历，下一个坐标是高度大于height[0]的第一个坐标, 因为如果高度小于height[0],面积肯定小，所以可以直接舍弃高度小的
 *   同理，右指针，向左遍历，下一个坐标是高度大于height[n]的第一个坐标
 *
 *   然后比较两者，保留面积较大的
 */