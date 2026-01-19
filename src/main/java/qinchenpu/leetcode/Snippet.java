package qinchenpu.leetcode;

import common.ListNode;

public class Snippet {
    public static void main(String[] args) {
        int[] nodes = {1, 2, 3, 3, 3};
//        int[] nodes = {1, 2, 3, 3, 4, 4, 5};
        ListNode head = new ListNode(nodes[0]);
        ListNode node = head;
        for (int i = 1; i < nodes.length; i++) {
            node.next = new ListNode(nodes[i]);
            node = node.next;
        }

        ListNode pHead = removeDupicateNode(head);
        while (pHead != null) {
            System.out.println(pHead);
            pHead = pHead.next;
        }

    }

    private static ListNode removeDupicateNode(ListNode head) {
        ListNode firstNode = new ListNode(-1);
        ListNode preNode = firstNode;
        ListNode node = head;
        int tmp = preNode.val;
        while (node.next != null) {
            if (tmp != node.val && node.val != node.next.val) {
                preNode.next = new ListNode(node.val);
                preNode = preNode.next;
            }
            tmp = node.val;
            node = node.next;
        }
        if (node.val != tmp) {
            preNode.next = node;
        }
        return firstNode.next;
    }
}

