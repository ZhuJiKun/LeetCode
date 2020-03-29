package com.leet.sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 计数排序
 *
 * 用数组的下标来实现
 */
public class CountSort {



  public static void main(String[] strings) {
    int arr[] = {10,9,8,7,7,7,7,6,5,4,3,2,1,1,1,1};
    basicCount(arr);
    System.out.println(Arrays.toString(arr));

    int arr2[] = {100, 100, 103, 103, 102, 101};
    basicCount2(arr2);
    System.out.println(Arrays.toString(arr2));

  }


  /**
   * 用数组下标来表示出现的数值， 数组元素代表出现的个数
   */
  private static void basicCount(int[] arr) {

    // 查询最大值
    int max = 0;
    for (int a : arr) {
      max = (max < a) ? a : max;
    }

    // 创建数组
    int[] array = new int[max + 1];

    // 放入数组
    for (int a : arr) {
      array[a] += 1;
    }

    // 循环输出
    int i = 0;
    for (int index = 0; index < array.length; index++) {
      int a = array[index];
      if (a > 0) {
        for (int j = 0; j < a; j++) {
          arr[i] = index;
          i++;
        }
      }
    }
  }




  /**
   * 如果数据很大的话，比如说 都是 100以上的， 就不能直接从0开始
   * 因为0-99都是浪费的资源
   * 需要用偏移量的方式，将数据从0开始往后排
   */
  private static void basicCount2(int[] arr) {

    // 查询最大值、最小值
    int max = 0, min = Integer.MAX_VALUE;
    for (int a : arr) {
      max = (max < a) ? a : max;
      min = (min > a) ? a : min;
    }

    // 创建数组
    int[] array = new int[max - min + 1];

    // 放入数组, min相当于偏移亮
    for (int a : arr) {
      array[a - min] += 1;
    }

    // 循环输出
    int i = 0;
    for (int index = 0; index < array.length; index++) {
      int a = array[index];
      if (a > 0) {
        for (int j = 0; j < a; j++) {
          arr[i] = index + min; // + 偏移量
          i++;
        }
      }
    }
  }








}
