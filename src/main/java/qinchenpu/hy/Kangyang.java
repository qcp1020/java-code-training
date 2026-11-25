package qinchenpu.hy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 题目：C(3) 移动康养监护链路风险评估 —— 二叉树中的最大路径和（ACM 模式）
 *
 * ACM 平台输入输出要求（参照平台示例题 A+B）：
 *   1. 类名必须为 Main（平台以 public class Main 为编译入口）；
 *   2. 测试用例会包含多行测试数据，需支持持续读取：
 *      while 逐行读取直到 EOF，每行为一棵树的层序序列，处理完立即输出一行结果。
 *   注意：提交到平台时请删除本文件第一行的 package 声明。
 *
 * 题意：每行给出二叉树的层序遍历序列（-1 代表空节点），节点权值可正可负。
 *       求一条沿父子关系连通、不分叉、起点终点任意（可不经过根）的路径的最大权值和。
 *
 * 算法：树形 DP（等价于 LeetCode 124 Binary Tree Maximum Path Sum）
 *   1) 节点"单边最大贡献"：gain(u) = val(u) + max(0, gain(left), gain(right))
 *      —— 从 u 出发只选一条分支向下能得到的最大路径和，负贡献直接丢弃；
 *   2) 以 u 为"拐点（最高点）"的链路：throughU = val(u) + max(0, 左gain) + max(0, 右gain)
 *      —— 覆盖"左子树某节点 -> u -> 右子树某节点"，单节点链路也包含在内；
 *   3) 全局答案 = 所有节点 throughU 的最大值。
 *
 * 实现细节：
 *   - 建树：按标准层序序列规则（队列 + 仅非空节点消耗两个孩子 token），与样例格式一致；
 *   - 防爆栈：不递归。按建树创建序（即层序）倒序遍历即为自底向上顺序，
 *     此时每个节点的孩子一定已计算完毕，等价于后序遍历的 DP 效果；
 *   - 结果用 long 累加，防止大量正权重相加时 int 溢出。
 *
 * 复杂度：每组用例时间 O(n)、空间 O(n)。满足 1000MS / 128MB 限制。
 *
 * 样例：输入 "-10 9 20 -1 -1 15 7" -> 输出 42（链路 15 -> 20 -> 7）
 */
public class Kangyang {

    /** 层序序列中表示空节点的占位符。 */
    private static final long EMPTY = -1L;

    /** 二叉树节点：gain 字段保存"从本节点向下走（单分支）"的最大路径和。 */
    private static final class Node {
        final long val;
        Node left;
        Node right;
        long gain;

        Node(long val) {
            this.val = val;
        }
    }

    public static void main(String[] args) throws IOException {
        // ---------- ACM 输入：持续读取多行测试用例，逐行处理、逐行输出 ----------
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {            // 持续读取直到 EOF
            StringTokenizer st = new StringTokenizer(line);
            if (!st.hasMoreTokens()) {                      // 跳过空行
                continue;
            }
            out.append(solve(st)).append('\n');             // 每行一个用例，输出一个整数
        }
        System.out.print(out);
    }

    /** 处理一行层序序列，返回该监护树的链路综合得分最大值。 */
    private static long solve(StringTokenizer st) {
        // ---------- 建树：层序序列，-1 为空节点，仅非空节点消耗两个孩子 token ----------
        List<Node> creationOrder = new ArrayList<>();       // 创建顺序 = 层序，供逆序 DP 使用
        Node root = new Node(Long.parseLong(st.nextToken()));
        creationOrder.add(root);
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty() && st.hasMoreTokens()) {
            Node cur = queue.poll();
            // 左孩子
            if (st.hasMoreTokens()) {
                long v = Long.parseLong(st.nextToken());
                if (v != EMPTY) {
                    cur.left = new Node(v);
                    creationOrder.add(cur.left);
                    queue.add(cur.left);
                }
            }
            // 右孩子
            if (st.hasMoreTokens()) {
                long v = Long.parseLong(st.nextToken());
                if (v != EMPTY) {
                    cur.right = new Node(v);
                    creationOrder.add(cur.right);
                    queue.add(cur.right);
                }
            }
        }

        // ---------- 逆层序（自底向上）迭代树形 DP，无递归 ----------
        long best = Long.MIN_VALUE;                         // 权值可全为负，答案至少为单节点权值
        for (int i = creationOrder.size() - 1; i >= 0; i--) {
            Node cur = creationOrder.get(i);
            long leftGain = cur.left == null ? 0 : Math.max(0L, cur.left.gain);
            long rightGain = cur.right == null ? 0 : Math.max(0L, cur.right.gain);

            // 以 cur 为拐点的最优链路
            long throughCur = cur.val + leftGain + rightGain;
            if (throughCur > best) {
                best = throughCur;
            }

            // 向上提供贡献：只能选一条分支
            cur.gain = cur.val + Math.max(leftGain, rightGain);
        }
        return best;
    }
}
