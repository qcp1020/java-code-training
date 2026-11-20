package qinchenpu.nowcoder.BM;

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

import static common.CommonUtils.generateListNodes;

/**
 * @author qinchenpu
 * @project java-code-training
 * @Date 2026/10/13
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class BM13 {
    public static void main(String[] args) {
        ListNode head = generateListNodes(new int[]{-401261, -449050, -456674, -456674, -449050, -401261});

        System.out.println(isPail(head));

    }

    public static boolean isPail(ListNode head) {
        // write code here
        List<Integer> list = new ArrayList<Integer>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        if (list.size() == 0) {
            return false;
        } else if (list.size() == 1) {
            return true;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }
}
