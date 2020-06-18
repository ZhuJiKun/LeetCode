package com.leet.code;

/**
 * 两数相加
 *
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class AddTwoNumbers {

    public static void main(String[] args) {

        ListNode node1 = new ListNode(2);
        node1.next = new ListNode(4);
        node1.next.next = new ListNode(3);

        ListNode node2 = new ListNode(5);
        node2.next = new ListNode(6);
        node2.next.next = new ListNode(4);

        ListNode n3 = addTwoNumbers(node1, node2);
        System.out.print(n3.val);
    }


    /**
     * 同时遍历两个链表，直到两个链表全部遍历完成
     * 不足的位 补0
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        boolean flag = false;
        ListNode res = null, tmp = null;

        while (l1 != null || l2 != null) {
            int x = ((l1 == null) ? 0 : l1.val ) + ((l2 == null) ? 0 : l2.val);
            if (flag) {
                x++;
                flag = false;
            }

            if (tmp == null) {
                tmp = new ListNode((x >= 10) ? (x - 10) : x);
                res = tmp;
            } else {
                tmp.next = new ListNode((x >= 10) ? (x - 10) : x);
                tmp = tmp.next;
            }

            if (x >= 10) {
                flag = true;
            }
            l1 = (l1 == null) ? null : l1.next;
            l2 = (l2 == null) ? null : l2.next;
        }

        if (flag) {
            tmp.next = new ListNode(1);
        }

        return res;
    }

    private static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

}
