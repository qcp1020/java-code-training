package qinchenpu.leetcode.nowcoder;

import common.ListNode;

import static common.CommonUtils.generateListNodes;
import static common.CommonUtils.printListNode;

/**
 * @Author qinchenpu
 * @Project nowcoder
 * @Date 2026/1/12
 * @Description: 合并两个排序的链表
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class BM4 {
    public static void main(String[] args) {
        ListNode head1 = generateListNodes(new int[]{1, 2, 4, 5});
        ListNode head2 = generateListNodes(new int[]{3, 6, 7});
        printListNode(Merge(head1, head2));
    }

    public static ListNode Merge(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null) {
            return pHead2;
        }
        if (pHead2 == null){
            return pHead1;
        }
        ListNode head = null;
        ListNode node = null;
        if (pHead1.val < pHead2.val) {
            head = node = pHead1;
            pHead1 = pHead1.next;
        } else {
            head = node = pHead2;
            pHead2 = pHead2.next;
        }

        while (pHead1 != null && pHead2 != null) {
            if (pHead1.val < pHead2.val) {
                node.next = pHead1;
                pHead1 = pHead1.next;
            } else {
                node.next = pHead2;
                pHead2 = pHead2.next;
            }
            node = node.next;
        }
        if (pHead1 != null) {
            node.next = pHead1;
        } else {
            node.next = pHead2;
        }
        return head;

        // write code here
    }
}
