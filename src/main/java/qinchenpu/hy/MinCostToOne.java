package qinchenpu.hy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 题目：牛牛把 n 变成 1 的最小花费
 *
 * <p>两种操作：
 * <ol>
 *   <li>n = n - 1，花费 x 元；</li>
 *   <li>n = n / k（要求 n % k == 0），花费 y 元。</li>
 * </ol>
 * 求把 n 变成 1 的最小总花费。输入 t 组 (n, k, x, y)，每组输出一行答案。
 *
 * <p>思路（最优子结构）：
 * 设 f(v) 为把 v 变成 1 的最小花费。对当前值 v 只有两种决策：
 * <ul>
 *   <li>一路减到 1：花费 (v - 1) * x；</li>
 *   <li>先减掉 r = v % k 次，凑成 k 的倍数，再除一次得到 q = v / k：
 *       花费 r * x + y + f(q)。</li>
 * </ul>
 * 所以 f(v) = min( (v - 1) * x , r * x + y + f(v / k) )，其中 f(v) 只依赖 f(v / k)。
 * 不需要枚举"减到更远的倍数"：那样等价于先用 (k + r) 次减法走到 q-1 再除，
 * 而 f(q) &lt;= x + f(q-1)，走 q 再减一次一定不差。
 *
 * <p>因为 v 每次至少变成 v/2，递归链长度不超过 log2(1e9) ≈ 30，
 * 所以单组 O(log_k n)；下面用数组自底向上倒推，避免递归。
 * 时间 O(log n)，空间 O(log n)（实际不超过 31 个 long，可视为 O(1)）。
 *
 * <p>注意点：
 * <ul>
 *   <li>k == 1 时必须特判：n / 1 == n 会无限循环，答案只能是 (n - 1) * x；</li>
 *   <li>v &lt; k 时无法再除，只能靠减法；</li>
 *   <li>n, x 都到 1e9，花费可达 1e18，必须用 long（long 上限约 9.2e18，安全）。</li>
 * </ul>
 *
 * @author qinchenpu
 * @project java-code-training
 * @Date 2026/11/01
 * @CopyRight 版权所有 (C) QIN CHENPU.
 */
public class MinCostToOne {

    public static void main(String[] args) throws IOException {
        FastScanner in = new FastScanner();
        String tToken = in.next();
        if (tToken == null) {
            return;
        }
        int t = Integer.parseInt(tToken);
        StringBuilder out = new StringBuilder(t * 4);

        for (int i = 0; i < t; i++) {
            String ns = in.next();
            String ks = in.next();
            String xs = in.next();
            String ys = in.next();
            if (ns == null || ks == null || xs == null || ys == null) {
                break; // 输入不完整，容错退出
            }
            long n = Long.parseLong(ns);
            long k = Long.parseLong(ks);
            long x = Long.parseLong(xs);
            long y = Long.parseLong(ys);
            out.append(minCost(n, k, x, y)).append('\n');
        }
        System.out.print(out);
    }

    /**
     * 计算 n 变成 1 的最小花费。
     *
     * @param n 初始值（&gt;= 1）
     * @param k 除法因子（&gt;= 1）
     * @param x 每次减法花费
     * @param y 每次除法花费
     * @return 最小总花费
     */
    private static long minCost(long n, long k, long x, long y) {
        if (n <= 1) {
            return 0; // 已经是 1
        }
        // k == 1 时除法没有意义（n / 1 == n），只能一路减
        if (k == 1) {
            return (n - 1) * x;
        }

        // 自顶向下收集链：n, n/k, n/k^2, ...
        long[] chain = new long[64];
        int size = 0;
        long v = n;
        while (v > 1 && v >= k) {
            chain[size++] = v;
            v /= k;
        }
        // 链尾：v == 1 花 0；v < k 时已无法再除，只能减 v-1 次
        long best = (v <= 1) ? 0 : (v - 1) * x;

        // 自底向上倒推
        for (int i = size - 1; i >= 0; i--) {
            long cur = chain[i];
            long r = cur % k;                 // 先减 r 次凑成 k 的倍数，再除
            long byDivide = r * x + y + best;
            long byMinus = (cur - 1) * x;     // 从 cur 一路减到 1
            best = Math.min(byDivide, byMinus);
        }
        return best;
    }

    /** 按空白符切分的快速输入，兼容多行/跨行数据。 */
    private static final class FastScanner {
        private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
        private StringTokenizer st;

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                if (line == null) {
                    return null;
                }
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }
    }
}
