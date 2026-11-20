package qinchenpu.nowcoder.BM;

import common.ListNode;

import static common.CommonUtils.generateListNodes;
import static common.CommonUtils.printListNode;

/**
 * @author qinchenpu
 * @project java-code-training
 * @Date 2026/10/13
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class BM14 {
    public static void main(String[] args) {
        ListNode head = generateListNodes(new int[]{2, 1, 3, 5, 6, 4, 7});
        ListNode result = oddEvenList(head);
        printListNode(result);
    }

    public static ListNode oddEvenList(ListNode head) {
        // write code here
        ListNode odd = null;
        ListNode even = null;
        ListNode oddFirst = null;
        ListNode evenFirst = null;

        if (head == null) {
            return null;
        }

        int index = 1;
        while (head != null) {

            if (index % 2 == 0) {
                if (even == null) {
                    even = head;
                    evenFirst = head;
                } else {
                    even.next = head;
                    even = even.next;
                }
            } else {
                if (odd == null) {
                    oddFirst = head;
                    odd = head;
                } else {
                    odd.next = head;
                    odd = odd.next;
                }
            }
            head = head.next;
            index++;
        }

        if (even != null) {
            even.next = null;
            odd.next = evenFirst;
        }
        return oddFirst;
    }


    public ListNode oddEvenList2 (ListNode head) {
        // write code here
        if(head == null || head.next == null) return head;
        ListNode evenHead = head.next;
        ListNode odd = head,even = head.next;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

}
