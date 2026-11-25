package qinchenpu.hy;

import java.io.IOException;

/**
 * 题目：Wi-Fi 子路由依次下线，求最大总带宽收益
 *
 * 题目描述：
 *   一条直线上部署了 n 台 Wi-Fi 子路由节点，依次全部下线。
 *   下线某台节点时的收益 = 【当前仍在线的左侧相邻节点带宽权值】
 *                       x 【当前下线节点带宽权值】
 *                       x 【当前仍在线的右侧相邻节点带宽权值】
 *   链路最左、最右端的虚拟边界节点权值固定为 1。
 *   节点一旦下线，后续计算收益时不再参与。
 *   求最优下线顺序下的最大总带宽收益。
 *
 * 思路（区间 DP，即"戳气球"问题）：
 *   关键在于"最后下线"的思考方向：对于开区间 (left, right) 内的节点，
 *   假设其中某个节点 k 是该区间内【最后】被下线的——
 *   此时 k 的左右相邻必然就是 left 和 right（区间内其他节点都已先下线），
 *   因此 k 下线时产生的收益是 arr[left] * arr[k] * arr[right]，
 *   且这个收益与 k 之前如何下线区间内的其他节点完全无关（区间内部节点
 *   下线时看到的邻居都在同一开区间内部）。
 *
 *   设 dp[l][r] 表示开区间 (l, r) 内所有节点全部下线能获得的最大收益：
 *     dp[l][r] = max over k in (l, r) of:
 *                dp[l][k] + arr[l] * arr[k] * arr[r] + dp[k][r]
 *
 *   其中 dp[l][k] 和 dp[k][r] 分别是 k 左、右两侧子区间的最优收益。
 *   在数组两端各补一个权值为 1 的虚拟边界节点，答案为 dp[0][n+1]。
 *
 * 复杂度：
 *   时间 O(n^3)，空间 O(n^2)。
 *
 * 样例验证：
 *   输入: 4 / 3 1 5 8 -> 输出 167
 *   (下线顺序 1, 5, 3, 8:
 *     1: 3*1*5 = 15
 *     5: 3*5*8 = 120
 *     3: 1*3*8 = 24
 *     8: 1*8*1 = 8
 *    合计 15+120+24+8 = 167)
 */
public class WifiRouterOffline {

    /**
     * 计算最大总带宽收益。
     *
     * @param weights n 台子路由的带宽权值
     * @return 最优下线顺序下的最大总收益
     */
    public static long maxTotalRevenue(int[] weights) {
        int n = weights.length;
        if (n == 0) {
            return 0;
        }

        // 构造带虚拟边界的数组：arr[0] = arr[n+1] = 1
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;
        System.arraycopy(weights, 0, arr, 1, n);

        // dp[l][r]: 开区间 (l, r) 内节点全部下线的最大收益
        long[][] dp = new long[n + 2][n + 2];

        // 按区间长度从短到长枚举（len 为开区间内部节点个数）
        for (int len = 1; len <= n; len++) {
            for (int l = 0; l + len + 1 <= n + 1; l++) {
                int r = l + len + 1;
                // 初始化为极小值：区间内节点必须全部下线，即使所有收益为负
                // （权值允许为负的场景）也不能用 0 代替真实最优值
                long best = Long.MIN_VALUE;
                // 枚举区间内最后下线的节点 k
                for (int k = l + 1; k < r; k++) {
                    long revenue = (long) arr[l] * arr[k] * arr[r];
                    long total = dp[l][k] + revenue + dp[k][r];
                    if (total > best) {
                        best = total;
                    }
                }
                dp[l][r] = best;
            }
        }
        return dp[0][n + 1];
    }

    public static void main(String[] args) throws IOException {
        // 一次性读入全部输入字节（兼容 Java 8），自行分词（支持负数、任意空白分隔）
        java.io.ByteArrayOutputStream bos = new java.io.ByteArrayOutputStream();
        byte[] buf = new byte[1 << 16];
        int read;
        while ((read = System.in.read(buf)) != -1) {
            bos.write(buf, 0, read);
        }
        byte[] raw = bos.toByteArray();
        int[] tokens = new int[parseTokenCount(raw)];
        int cnt = 0;
        int i = 0;
        int len = raw.length;
        while (i < len) {
            // 跳过空白与回车换行
            while (i < len && (raw[i] == ' ' || raw[i] == '\n' || raw[i] == '\r'
                    || raw[i] == '\t' || raw[i] == '\f')) {
                i++;
            }
            if (i >= len) {
                break;
            }
            boolean neg = false;
            if (raw[i] == '-' || raw[i] == '+') {
                neg = raw[i] == '-';
                i++;
            }
            long val = 0;
            boolean hasDigit = false;
            while (i < len && raw[i] >= '0' && raw[i] <= '9') {
                val = val * 10 + (raw[i] - '0');
                i++;
                hasDigit = true;
            }
            if (hasDigit) {
                tokens[cnt++] = (int) (neg ? -val : val);
            }
        }

        // 循环处理：输入可能包含多组数据（每组：n + n 个权值），
        // 每组输出一行答案；单组数据时行为与逐行读取完全一致
        StringBuilder sb = new StringBuilder();
        int p = 0;
        while (p < cnt) {
            int n = tokens[p++];
            if (n < 0 || p + n > cnt) {
                break; // 数据不完整，丢弃残缺组
            }
            int[] weights = new int[n];
            for (int j = 0; j < n; j++) {
                weights[j] = tokens[p++];
            }
            sb.append(maxTotalRevenue(weights)).append('\n');
        }
        System.out.print(sb);
    }

    /** 预估 token 上限：字节数 / 2 + 2（最坏情形每位数字一个 token 不会超过字节长度） */
    private static int parseTokenCount(byte[] raw) {
        return raw.length / 2 + 2;
    }
}
