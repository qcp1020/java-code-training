package qinchenpu.leetcode.nowcoder;

import common.ListNode;

import static common.CommonUtils.generateListNodes;
import static common.CommonUtils.printListNode;

/**
 * @author qinchenpu
 * @project LeetCode
 * @Date 2026/1/14
 * @Description: 反转链表
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class BM1 {
    public static void main(String[] args) {
        ListNode head = generateListNodes(new int[]{1, 2, 4, 5});
        printListNode(ReverseList(head));
    }

    public static ListNode ReverseList(ListNode head) {
        ListNode nextNode = null;
        ListNode preNode = head;
        ListNode node = head;
        while (node != null) {
            preNode = node.next;
            node.next = nextNode;
            nextNode = node;
            node = preNode;
        }
        return nextNode;
    }
}
