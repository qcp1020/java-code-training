/**
 * @project ecs-web
 * @File TreeNode.java
 * @Date 2021年7月8日
 * @CopyRight 版权所有 (C) 中国移动 杭州研发中心.
 */
package common;

/**
 * @project ecs-web
 * @File TreeNode.java
 * @Date 2021年7月8日
 * @author qinchenpu
 * @CopyRight 版权所有 (C) 中国移动 杭州研发中心.
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
