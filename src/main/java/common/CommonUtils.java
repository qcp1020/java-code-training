package common;

/**
 * @author qinchenpu
 * @project LeetCode
 * @Date 2026/1/14
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class CommonUtils {

    public static ListNode generateListNodes(int[] nums) {
        ListNode headNode = new ListNode(nums[0]);
        ListNode preNode = headNode;
        for (int i = 1; i < nums.length; i++) {
            ListNode node = new ListNode(nums[i]);
            preNode.next = node;
            preNode = node;
        }
        return headNode;
    }

    public static void printListNode(ListNode node1) {
        ListNode node = node1;
        do {
            System.out.println(node);
            node = node.next;
        } while (node != null);
    }

}
