package com.leet.structure;


import java.util.Arrays;
import java.util.StringJoiner;

/**
 * 堆是一个完整的二叉树
 * 最小堆： 任何一个父节点的值，都小于等于它左右孩子节点的值。 堆顶的值数据最小
 * 最大堆： 任何一个父节点的值，都大于等于它左右孩子节点的值。 堆顶的值数据最大
 *
 * 代码以最小堆为例, 堆顶是最小的值
 */
public class Heap {

  public static void main(String[] strings) {
    int arr[] = {10,2,3,4,5,6,7,8,9};
    down(arr, 0, arr.length);
    System.out.println(Arrays.toString(arr));

    // 新增的值直接放在最后一个，作为最后一个叶子结点上浮，找到自己的位置
    int arr2[] = {1,2,3,4,5,6,7,8,9,   0};
    up(arr2, 9);
    System.out.println(Arrays.toString(arr2));


    // 对于一个二叉树，构建为二叉堆
    // 从最后一个非叶子节点开始，依次执行下沉操作，每个节点都找到自己的合适位置，整个堆就构造完成
    int arr3[] = {10,9,8,7,6,5,4,3,2,1};
    for (int index = (arr3.length / 2); index >= 0; index--) {
      down(arr3, index, 10);
    }
    System.out.println(Arrays.toString(arr3));


    // 对于一个无序数组，转为有序数组
    // 先转为二叉堆，然后溢出堆顶，然后重新构建，直到全部移除
    // 堆排序： 非稳定性排序， N * log(N)

    // 直接用二叉堆arr3
    StringJoiner sj = new StringJoiner(",");
    for (int length = 10; length > 0; length--) {

      // 溢出堆顶
      sj.add(arr3[0] + "");

      // 最后一个元素移到顶部
      arr3[0] = arr3[length - 1];

      // 堆顶元素执行下沉操作, 找到适合自己的位置
      down(arr3, 0, length - 1);
    }
    System.out.println(sj.toString());

  }



  /**
   *  用一个数组来表示堆的值
   *  父节点的下标为0， 则左子节点的下标为 2n+1，右子节点的下标为 2n+2
   */


  /**
   * 下沉操作: 与子节点比较，一直下沉下去，直到找到自己应该在的位置
   * 数组的有效长度
   *
   * @param arr 数组
   * @param index 需要下沉的节点坐标
   * @param length 数组的有效长度
   */
  public static void down(int[] arr, int index, int length) {
    int temp = arr[index];

    // 循环向下沉
    for (int child = (index * 2 + 1); child < length; child = (child * 2) + 1) {

      // 构建最小堆，所以要选择两个字节点中 小的那一个交换，这样保证交换完 父节点小于2个字节点
      if ((child + 1 < length) && arr[child] > arr[child + 1]) {
        child++;
      }

      if (temp <= arr[child]) {
        break;
      }

      // 交换位置
      arr[index] = arr[child];
      arr[child] = temp;

      index = child;
      temp = arr[child];
    }
  }


  /**
   * 上浮操作: 与父节点比较，如果小于父亲的值，则交换，一直找到自己的位置
   * 数组的有效长度
   *
   * @param arr 数组
   * @param index 需要下沉的节点坐标
   */
  public static void up(int[] arr, int index) {
    int temp = arr[index];

    // 循环向上
    for (int parent = (index - 1) / 2; parent >= 0; parent = (parent - 1) / 2) {

      if (temp >= arr[parent]) {
        break;
      }

      // 交换位置
      arr[index] = arr[parent];
      arr[parent] = temp;
      index = parent;
      temp = arr[parent];
    }
  }

}
