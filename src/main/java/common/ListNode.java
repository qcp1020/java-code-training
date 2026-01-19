/**
 * @project ecs-web
 * @File ListNode.java
 * @Date 2021年7月14日
 * @CopyRight 版权所有 (C) 中国移动 杭州研发中心.
 */
package common;

/**
 * @author qinchenpu
 * @project ecs-web
 * @File ListNode.java
 * @Date 2021年7月14日
 * @CopyRight 版权所有 (C) 中国移动 杭州研发中心.
 */
public class ListNode {
    public int val;

    @Override
    public String toString() {
        return "ListNode{" + "val=" + val + '}';
    }

    public ListNode next;

    ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
