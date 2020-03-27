package com.leet.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 最基础的交换排序
 */
public class BubbleSort {


  public static void main(String[] strings) {
    int arr[] = {10,9,8,7,6,5,4,3,2,1};
    basicSort(arr);
    System.out.println(Arrays.toString(arr));


    int arr1[] = {1,2,3,4,5,6,7,8,10,9};
    basicSort2(arr1);
    System.out.println(Arrays.toString(arr1));


    int arr3[] = {1,2,3,4,10,9,8,6};
    basicSort3(arr3);
    System.out.println(Arrays.toString(arr3));
  }


  /**
   * 基础的排序， 大的数据往后走，一次循环最后最大的数据在最后一位
   * 相等的值不会交换下标，是稳定排序
   */
  private static void basicSort(int[] arr) {
    for (int j = arr.length - 1; j > 0; j--) {
      for (int i = 0; i <= j - 1; i++) {
        if (arr[i] > arr[j]) {
          int t = arr[j];
          arr[j] = arr[i];
          arr[i] = t;
        }
      }
    }
  }



  /**
   * 可能排序到一半就已经是有序的了，可以加一个标志，剩下的数据就不用跑了
   */
  private static void basicSort2(int[] arr) {
    for (int j = arr.length - 1; j > 0; j--) {

      boolean sort = true;

      for (int i = 0; i <= j - 1; i++) {
        if (arr[i] > arr[j]) {
          int t = arr[j];
          arr[j] = arr[i];
          arr[i] = t;

          sort = false; // 有发生过交换说明还未变成有序
        }
      }

      if (sort) {
        System.out.println(j); // 打印出j， 看是否跑到了0
        return;
      }
    }
  }



  /**
   *
   * 有序区的长度和排序的轮数是相等的。比如第一轮排序过后的有序区长度是1，第二轮排序过后的有序区长度是2 ......
   * 数列真正的有序区可能会大于这个长度，比如仅仅第二轮，后面5个元素实际都已经属于有序区。因此后面的许多次元素比较是没有意义的。
   *
   * 在第2步的基础上
   * 加一个交换坐标的标志
   * 标志后面的都是已经有序的了，就不用继续向后比较了
   */
  private static void basicSort3(int[] arr) {

    // 记录最后一次交换的位置
    int index = 0;

    // 记录无序数组的边界，大于这个边界的都是有序的
    int sortOrder = arr.length - 1;

    for (int j = arr.length - 1; j > 0; j--) {

      boolean sort = true;

      for (int i = 0; i < sortOrder; i++) {
        if (arr[i] > arr[j]) {
          int t = arr[j];
          arr[j] = arr[i];
          arr[i] = t;

          sort = false;
          index = j; // 记录最大的发生交换的下表，下表后面的就是有序的了，不用继续走了
        }
      }

      sortOrder = index;

      if (sort) {
        return;
      }
    }
  }

}
